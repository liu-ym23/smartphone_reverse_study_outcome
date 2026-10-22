package com.bytedance.monitor.collector;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import b3.g;
import com.bumptech.glide.load.engine.a;
import com.bytedance.apm.j;
import com.lynx.tasm.ui.image.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import jg.d;
import jg.e;
import jg.f;
import jg.k;
import org.json.JSONException;
import org.json.JSONObject;
import z6.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LockMonitorManager {
    private static final int DEFAULT_SIZE = 100;
    private static final String DELIMITER = "&#&";
    private static final String KEY_IS_ALL_THREAD = "is_all_thread";
    private static final String KEY_IS_LOCK = "is_lock";
    private static final String KEY_RAW_DUMP_INFO = "raw_dump_info";
    private static final String LOCK_THREAD_NAME = "lock_handler_time";
    private static final String STACK_THREAD_NAME = "lock_stack_fetch";
    private static final String TAG = "LockMonitorManager";
    private static final int bufferSize = 100;
    private static boolean isAllThread = false;
    private static volatile boolean isLockMonitoring = false;
    private static volatile String lastJavaStack = null;
    private static volatile String lastOwnerJavaStack = null;
    private static e[] lockInfoQueue = null;
    private static volatile boolean openFetchStack = false;
    private static int position;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sLockHandler;
    private static final BlockingQueue<String> sOwnerStackBlockingQueue = null;
    private static final BlockingQueue<String> sStackBlockingQueue = null;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sStackFetcher;

    static {
        lockInfoQueue = new e[100];
        sStackBlockingQueue = new LinkedBlockingQueue();
        sOwnerStackBlockingQueue = new LinkedBlockingQueue();
        sLockHandler = Executors.newSingleThreadExecutor(new a(2));
        sStackFetcher = Executors.newSingleThreadExecutor(new a(3));
        isLockMonitoring = false;
    }

    public LockMonitorManager() {
    }

    public static /* synthetic */ JSONObject access$000(e r5, JSONObject r10) {
        return packJsonData(r5, r10);
    }

    public static /* synthetic */ void access$1000(String r5) {
        getThreadStack(r5);
    }

    public static /* synthetic */ boolean access$300() {
        return openFetchStack;
    }

    public static /* synthetic */ BlockingQueue access$400() {
        return sStackBlockingQueue;
    }

    public static /* synthetic */ String access$500() {
        return lastJavaStack;
    }

    public static /* synthetic */ String access$502(String r5) {
        lastJavaStack = r5;
        return r5;
    }

    public static /* synthetic */ BlockingQueue access$600() {
        return sOwnerStackBlockingQueue;
    }

    public static /* synthetic */ String access$700() {
        return lastOwnerJavaStack;
    }

    public static /* synthetic */ String access$702(String r5) {
        lastOwnerJavaStack = r5;
        return r5;
    }

    public static /* synthetic */ void access$800(e r5) {
        enqueue(r5);
    }

    public static /* synthetic */ boolean access$900() {
        return isAllThread;
    }

    public static void dumpLockInfo(f r5) {
        b.f23409a.d(new h(r5, 27));
    }

    public static void endLockDetect(@NonNull JSONObject r5) {
        if (isLockMonitoring == true) goto L5;
        return;
    L5:
        isLockMonitoring = false;
        r5.put(KEY_IS_LOCK, true);     // Catch: JSONException -> L8
        r5.put(KEY_IS_ALL_THREAD, isAllThread);     // Catch: JSONException -> L8
    L11:
        if (j.d() == false) goto L22;
        reportLockInfo(r5);
        k r10 = k.m();
        monitor-enter(r10);
        setOpenFetchStack(false);     // Catch: Throwable -> L19
        if (k.f18337c == true) goto L24;
    L17:
        monitor-exit(r10);
        return;
    L24:
        MonitorJni.disableLock();     // Catch: Throwable -> L23
    L19:
        th = move-exception;
        throw th;
    L22:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @WorkerThread
    private static void enqueue(e r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        e[] r10 = lockInfoQueue;
        int r11 = position;
        r10[r11] = r5;
        position = (r11 + 1) % 100;
    }

    private static void getOwnerStack(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L27;
        ThreadGroup r5 = Looper.getMainLooper().getThread().getThreadGroup();
        int r11 = r5.activeCount();
        int r12 = (r11 / 2) + r11;
        Thread[] r13 = new Thread[r12];
        r5.enumerate(r13);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L28;
        Thread r15 = r13[r14];
        if (r15 == null) goto L29;
        if (r15 == Thread.currentThread()) goto L19;
        if (r15.getName().contains(r10) == false) goto L19;
        if (openFetchStack == false) goto L19;
        sStackFetcher.execute(new d(r15, 0));
    L19:
        r14 = r14 + 1;
        goto L7
    L29:
        return;
    L28:
        return;
    }

    private static void getThreadStack(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L23;
        ThreadGroup r5 = Looper.getMainLooper().getThread().getThreadGroup();
        int r11 = r5.activeCount();
        int r12 = (r11 / 2) + r11;
        Thread[] r13 = new Thread[r12];
        r5.enumerate(r13);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L24;
        Thread r15 = r13[r14];
        if (r15 == null) goto L25;
        if (r15.getName().contains(r10) == false) goto L16;
        if (openFetchStack == false) goto L16;
        sStackFetcher.execute(new d(r15, 1));
    L16:
        r14 = r14 + 1;
        goto L7
    L25:
        return;
    L24:
        return;
    }

    @Keep
    @WorkerThread
    private static void nativeGetJavaStack(String r5, String r10) {
        if (openFetchStack == false) goto L22;
        sStackFetcher.execute(new com.bytedance.apm.d(r10, 8));
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5.isEmpty() == true) goto L30;
        int r11 = r5.indexOf("monitor contention with owner");
        if (r11 > 0) goto L12;
        return;
    L12:
        if (r11 >= r5.length()) goto L25;
        String r12 = r5.substring(r11);
        int r13 = r12.indexOf("(") - 1;
        if (r13 > 0) goto L16;
        return;
    L16:
        if (30 < r12.length()) goto L18;
        return;
    L18:
        if (r13 >= r12.length()) goto L28;
        if (30 >= r13) goto L29;
        getOwnerStack(r12.substring(30, r13));
        return;
    L29:
        return;
    L28:
        return;
    L25:
        return;
    L30:
        return;
    }

    @Keep
    @WorkerThread
    private static void nativePut(String r5) {
        sLockHandler.execute(new com.bytedance.apm.d(r5, 7));
    }

    private static JSONObject packJsonData(e r10, JSONObject r11) {
        JSONObject r5 = new JSONObject();
        long r12 = r10.f18327a;     // Catch: JSONException -> L9
        String r13 = r10.f18329c;
        r5.put("timestamp", r12);     // Catch: JSONException -> L9
        r5.put("crash_time", r10.f18327a);     // Catch: JSONException -> L9
        r5.put("is_main_process", j.d());     // Catch: JSONException -> L9
        r5.put("process_name", j.a());     // Catch: JSONException -> L9
        r5.put("block_duration", r10.f18328b);     // Catch: JSONException -> L9
        r5.put(KEY_RAW_DUMP_INFO, r13);     // Catch: JSONException -> L9
        StringBuilder r14 = new StringBuilder();     // Catch: JSONException -> L9
        if (TextUtils.isEmpty(r10.e) == true) goto L11;
        r14.append(r10.e.replace(Profiler.DATA_SEP, ""));     // Catch: JSONException -> L9
        r14.append("\n");     // Catch: JSONException -> L9
    L11:
        r14.append("-OwnerThread: ");     // Catch: JSONException -> L9
        r14.append(r10.g);     // Catch: JSONException -> L9
        r14.append("\n");     // Catch: JSONException -> L9
        r14.append("-OwnerStack: ");     // Catch: JSONException -> L9
        r14.append(r10.f);     // Catch: JSONException -> L9
        r14.append("\n");     // Catch: JSONException -> L9
        r14.append("-WaiterStack: ");     // Catch: JSONException -> L9
        r14.append(r10.d);     // Catch: JSONException -> L9
        r14.append("\n");     // Catch: JSONException -> L9
        r14.append("-RawAtrace: ");     // Catch: JSONException -> L9
        r14.append(r13);     // Catch: JSONException -> L9
        r14.append("\n");     // Catch: JSONException -> L9
        r14.append("-LockThread: ");     // Catch: JSONException -> L9
        r14.append(r10.f18330h);     // Catch: JSONException -> L9
        r14.append("\n");     // Catch: JSONException -> L9
        r14.append("-Activity: ");     // Catch: JSONException -> L9
        r14.append("unknown");     // Catch: JSONException -> L9
        r14.append("\n");     // Catch: JSONException -> L9
        q7.a r15 = q7.a.k();     // Catch: JSONException -> L9
        r15.getClass();     // Catch: JSONException -> L9
        JSONObject r16 = new JSONObject();     // Catch: JSONException -> L9
        Iterator r17 = ((ConcurrentHashMap) r15.f21489c).entrySet().iterator();     // Catch: JSONException -> L25
    L14:
        if (r17.hasNext() == false) goto L17;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: JSONException -> L25
        r16.put((String) r18.getKey(), r18.getValue());     // Catch: JSONException -> L25
    L17:
        r16.put("block_stack_type", "stack");     // Catch: JSONException -> L9
        Iterator<String> r19 = r11.keys();     // Catch: JSONException -> L9
    L19:
        if (r19.hasNext() == false) goto L21;
        String r20 = r19.next();     // Catch: JSONException -> L9
        r16.put(r20, r11.get(r20));     // Catch: JSONException -> L9
        goto L19
    L21:
        r5.put("filters", r16);     // Catch: JSONException -> L9
        r5.put("stack", r14.toString());     // Catch: JSONException -> L9
        r5.put("event_type", "lag");     // Catch: JSONException -> L9
        return r5;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void reportLockInfo(JSONObject r5) {
        dumpLockInfo(new g(r5));
    }

    public static void setOpenFetchStack(boolean r5) {
        openFetchStack = r5;
        if (r5 == true) goto L6;
        lastJavaStack = null;
        lastOwnerJavaStack = null;
        return;
    }

    public static void startLockDetect() {
        startLockDetect(30);
    }

    public static void startLockDetect(long r5) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        if (j.d() == false) goto L18;
        k r10 = k.m();
        monitor-enter(r10);
        setOpenFetchStack(true);     // Catch: Throwable -> L15
        if (k.f18337c == true) goto L22;
    L13:
        monitor-exit(r10);
        return;
    L22:
        MonitorJni.enableLockAll(r5, false);     // Catch: Throwable -> L19
    L15:
        th = move-exception;
        throw th;
    }

    @WorkerThread
    public static List<e> dumpLockInfo() {
        LinkedList r5 = new LinkedList();
        int r10 = 0;
    L4:
        if (r10 >= 100) goto L9;
        int r11 = (((position + 100) - r10) - 1) % 100;
        e[] r12 = lockInfoQueue;
        e r13 = r12[r11];
        r12[r11] = null;
        if (r13 == null) goto L8;
        r5.add(r13);
    L8:
        r10 = r10 + 1;
        goto L4
    L9:
        return r5;
    }

    public static String dumpLockInfo(long r12, long r14) {
        e[] r5 = new e[100];
        int r10 = 0;
        System.arraycopy(lockInfoQueue, 0, r5, 0, 100);
        ArrayList r11 = new ArrayList();
    L3:
        if (r10 >= 100) goto L17;
        e r13 = r5[((position + r10) + 1) % 100];
        if (r13 == null) goto L15;
        long r15 = r13.f18327a;
        long r16 = r13.f18328b;
        if (r15 >= r14) goto L10;
    L11:
        r11.add(r13);
    L13:
        if ((r15 + r16) >= r12) goto L15;
    L10:
        if ((r15 + r16) <= r12) goto L13;
    L15:
        r10 = r10 + 1;
    L17:
        return r11.toString();
    }

    public static void startLockDetect(long r5, boolean r10) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        isAllThread = r10;
        if (j.d() == false) goto L17;
        k r11 = k.m();
        monitor-enter(r11);
        setOpenFetchStack(true);     // Catch: Throwable -> L14
        if (k.f18337c == true) goto L21;
    L12:
        monitor-exit(r11);
        return;
    L21:
        MonitorJni.enableLockAll(r5, r10);     // Catch: Throwable -> L18
    L14:
        th = move-exception;
        throw th;
    }
}
