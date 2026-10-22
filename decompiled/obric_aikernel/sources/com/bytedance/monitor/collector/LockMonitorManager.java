package com.bytedance.monitor.collector;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.crash.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
    private static i[] lockInfoQueue = null;
    private static volatile boolean openFetchStack = false;
    private static int position;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sLockHandler;
    private static final BlockingQueue<String> sOwnerStackBlockingQueue = null;
    private static final BlockingQueue<String> sStackBlockingQueue = null;

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    private static ExecutorService sStackFetcher;

    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable r10) {
            Thread r11 = new Thread(r10);
            r11.setName(LockMonitorManager.LOCK_THREAD_NAME);
            return r11;
        }
    }

    static class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable r10) {
            Thread r11 = new Thread(r10);
            Process.setThreadPriority(-20);
            r11.setName(LockMonitorManager.STACK_THREAD_NAME);
            return r11;
        }
    }

    static class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f2226a;

        c(JSONObject r10) {
            this.f2226a = r10;
        }

        @Override // com.bytedance.monitor.collector.LockMonitorManager.j
        public void a(@Nullable List<i> r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (com.bytedance.apm.d.D() == false) goto L7;
            Log.d(LockMonitorManager.TAG, "dumpLockInfo size -> " + r10.size());
        L7:
            Iterator<i> r11 = r10.iterator();
        L9:
            if (r11.hasNext() == false) goto L21;
            i r12 = r11.next();
            JSONObject r13 = LockMonitorManager.access$000(r12, this.f2226a);     // Catch: Throwable -> L19
            if (r13 == null) goto L9;
            if (com.bytedance.apm.d.D() == false) goto L17;
            Log.d(LockMonitorManager.TAG, "lock report LockInfo: " + r12);     // Catch: Throwable -> L19
        L17:
            y.d r14 = new y.d(LogTypeName.MONITOR_TYPE_BLOCK, r13, r12.f2233a);     // Catch: Throwable -> L19
            r14.g();     // Catch: Throwable -> L19
            x.a.p().e(r14);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Log.e(LockMonitorManager.TAG, "onData: parse lock info failed: " + th.getLocalizedMessage());
            goto L9
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f2227c;

        d(j r10) {
            this.f2227c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            j r10 = this.f2227c;     // Catch: Throwable -> L8
            if (r10 == null) goto L6;
            r10.a(LockMonitorManager.dumpLockInfo());     // Catch: Throwable -> L8
        L10:
            return;
        L6:
            r10.a(null);     // Catch: Throwable -> L8
        L8:
            this.f2227c.a(null);
        }
    }

    static class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2228c;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ i f2229c;

            a(e r10, i r11) {
                this.f2229c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                LockMonitorManager.access$800(this.f2229c);
            }
        }

        e(String r10) {
            this.f2228c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            i r10 = i.c(this.f2228c);     // Catch: Throwable -> L6
            if (r10 == null) goto L9;
            q0.b.f().i(new a(this, r10));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    static class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Thread f2230c;

        f(Thread r10) {
            this.f2230c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = o.c(this.f2230c.getStackTrace());     // Catch: Throwable -> L14
            BlockingQueue r11 = LockMonitorManager.access$600();     // Catch: Throwable -> L14
            monitor-enter(r11);     // Catch: Throwable -> L14
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
            goto L19
        L5:
            if (LockMonitorManager.access$600().size() == 0) goto L7;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L10
        L7:
            LockMonitorManager.access$600().put(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            goto L19
        L13:
            return;
        }
    }

    static class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Thread f2231c;

        g(Thread r10) {
            this.f2231c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = o.c(this.f2231c.getStackTrace());     // Catch: Throwable -> L14
            BlockingQueue r11 = LockMonitorManager.access$400();     // Catch: Throwable -> L14
            monitor-enter(r11);     // Catch: Throwable -> L14
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
            goto L19
        L5:
            if (LockMonitorManager.access$400().size() == 0) goto L7;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L10
        L7:
            LockMonitorManager.access$400().put(r10);     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            goto L19
        L13:
            return;
        }
    }

    static class h implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2232c;

        h(String r10) {
            this.f2232c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LockMonitorManager.access$900() == false) goto L5;
            LockMonitorManager.access$1000(this.f2232c);     // Catch: Throwable -> L17
            return;
        L5:
            String r10 = o.c(Looper.getMainLooper().getThread().getStackTrace());     // Catch: Throwable -> L17
            BlockingQueue r11 = LockMonitorManager.access$400();     // Catch: Throwable -> L17
            monitor-enter(r11);     // Catch: Throwable -> L17
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L8:
            if (LockMonitorManager.access$400().size() == 0) goto L10;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L13
        L10:
            LockMonitorManager.access$400().put(r10);     // Catch: Throwable -> L13
            monitor-exit(r11);     // Catch: Throwable -> L13
            goto L22
        L21:
            return;
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f2233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f2236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f2237e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f2238f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f2239g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f2240h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f2241i;

        private i(long r10, long r11, String r12, String r13) {
            this.f2236d = "unknown";
            this.f2233a = r10;
            this.f2234b = r11;
            this.f2235c = r12;
            this.f2241i = r13;
            h(r12);
            ActivityLifecycleService r14 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
            if (r14 == null) goto L8;
            String r15 = r14.getTopActivityClassName();
            if (TextUtils.isEmpty(r15) == true) goto L9;
            this.f2236d = r15;
            return;
        L9:
            return;
        }

        static /* synthetic */ String a(i r10) {
            return r10.f2238f;
        }

        static /* synthetic */ String b(i r10) {
            return r10.f2236d;
        }

        @Nullable
        @WorkerThread
        static i c(String r10) {
            String r11 = null;
            if (r10 != null) goto L5;
        L61:
            return null;
        L5:
            if (r10.isEmpty() == true) goto L61;
            Log.d("lockDetect", "" + r10);
            String[] r12 = r10.split(LockMonitorManager.DELIMITER);
            if (r12.length == 4) goto L11;
            Log.d("lockDetect", "spiltData != 4" + r10);
            return null;
        L11:
            long r13 = Long.parseLong(r12[0]);
            long r14 = Long.parseLong(r12[1]);
            String r15 = r12[2];
            i r16 = new i(r13, r14, r15, r12[3]);
            if (LockMonitorManager.access$300() == false) goto L53;
            BlockingQueue r17 = LockMonitorManager.access$400();
            monitor-enter(r17);
            String r18 = (String) LockMonitorManager.access$400().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L18 InterruptedException -> L20
        L22:
            if (r18 == null) goto L24;
        L26:
            LockMonitorManager.access$502(r18);     // Catch: Throwable -> L18
        L28:
            if (LockMonitorManager.access$400().isEmpty() == true) goto L30;
            LockMonitorManager.access$400().clear();     // Catch: Throwable -> L18
        L30:
            monitor-exit(r17);     // Catch: Throwable -> L18
            BlockingQueue r19 = LockMonitorManager.access$600();
            monitor-enter(r19);
            r11 = (String) LockMonitorManager.access$600().poll(200, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L35 InterruptedException -> L37
        L39:
            if (r11 == null) goto L41;
        L43:
            LockMonitorManager.access$702(r18);     // Catch: Throwable -> L35
        L45:
            if (LockMonitorManager.access$600().isEmpty() == true) goto L47;
            LockMonitorManager.access$600().clear();     // Catch: Throwable -> L35
        L47:
            monitor-exit(r19);     // Catch: Throwable -> L35
            String r20 = r11;
            r11 = r18;
        L54:
            if (r11 != null) goto L56;
        L58:
            if (r20 == null) goto L60;
            r16.j(r20);
        L60:
            return r16;
        L56:
            if (r15.contains(o.a(r11)) == false) goto L58;
            r16.i(r11);
            goto L58
        L41:
            if (LockMonitorManager.access$700() == null) goto L43;
            r11 = LockMonitorManager.access$700();     // Catch: Throwable -> L35
            goto L45
        L37:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            throw th;
        L24:
            if (LockMonitorManager.access$500() == null) goto L26;
            r18 = LockMonitorManager.access$500();     // Catch: Throwable -> L18
            goto L28
        L18:
            th = move-exception;
            throw th;
        L20:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L18
            r18 = null;
            goto L22
        L53:
            r20 = null;
            goto L54
        }

        private void h(String r10) {
            String r11 = r10.substring(r10.indexOf("monitor contention with owner"));
            this.f2240h = r11.substring(30, r11.indexOf("(") - 1);
            int r12 = r11.indexOf(" at ");
            if (r12 == (-1)) goto L5;
            String r13 = r11.substring(r12 + 5, r11.indexOf("waiters=", r12));
            String r14 = r13.substring(r13.indexOf(" "));
            this.f2239g = r14.substring(1, r14.indexOf("(")) + r14.substring(r14.indexOf(")") + 1, r14.lastIndexOf(")") + 1);
        L5:
            String r15 = r11.substring(r11.indexOf("blocking from") + 14);
            String r16 = r15.substring(r15.indexOf(" ") + 1);
            this.f2237e = r16.substring(0, r16.indexOf("(")) + r16.substring(r16.indexOf(")") + 1, r16.lastIndexOf(")") + 1);
        }

        public String d() {
            return this.f2237e;
        }

        public String e() {
            return this.f2241i;
        }

        public String f() {
            return this.f2239g;
        }

        public String g() {
            return this.f2240h;
        }

        public void i(String r10) {
            this.f2238f = r10;
        }

        public void j(String r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.isEmpty() == true) goto L8;
            this.f2239g = r10;
            return;
        }

        public String toString() {
            return "LockInfo{timestamp=" + this.f2233a + ", duration=" + this.f2234b + ", rawAtrace='" + this.f2235c + "', topActivityName='" + this.f2236d + "', blockStackInfo='" + this.f2237e + "', completeBlockStackInfo='" + this.f2238f + "', ownerStackInfo='" + this.f2239g + "', lockThreadName='" + this.f2241i + "', ownerThreadName='" + this.f2240h + "'}";
        }
    }

    public interface j {
        @WorkerThread
        void a(@Nullable List<i> r10);
    }

    static {
        lockInfoQueue = new i[100];
        sStackBlockingQueue = new LinkedBlockingQueue();
        sOwnerStackBlockingQueue = new LinkedBlockingQueue();
        sLockHandler = Executors.newSingleThreadExecutor(new a());
        sStackFetcher = Executors.newSingleThreadExecutor(new b());
        isLockMonitoring = false;
    }

    public LockMonitorManager() {
    }

    static /* synthetic */ JSONObject access$000(i r10, JSONObject r11) {
        return packJsonData(r10, r11);
    }

    static /* synthetic */ void access$1000(String r10) {
        getThreadStack(r10);
    }

    static /* synthetic */ boolean access$300() {
        return openFetchStack;
    }

    static /* synthetic */ BlockingQueue access$400() {
        return sStackBlockingQueue;
    }

    static /* synthetic */ String access$500() {
        return lastJavaStack;
    }

    static /* synthetic */ String access$502(String r10) {
        lastJavaStack = r10;
        return r10;
    }

    static /* synthetic */ BlockingQueue access$600() {
        return sOwnerStackBlockingQueue;
    }

    static /* synthetic */ String access$700() {
        return lastOwnerJavaStack;
    }

    static /* synthetic */ String access$702(String r10) {
        lastOwnerJavaStack = r10;
        return r10;
    }

    static /* synthetic */ void access$800(i r10) {
        enqueue(r10);
    }

    static /* synthetic */ boolean access$900() {
        return isAllThread;
    }

    public static String dumpLockInfo(long r10, long r11) {
        i[] r12 = new i[100];
        int r13 = 0;
        System.arraycopy(lockInfoQueue, 0, r12, 0, 100);
        ArrayList r14 = new ArrayList();
    L3:
        if (r13 >= 100) goto L17;
        i r15 = r12[((position + r13) + 1) % 100];
        if (r15 == null) goto L15;
        long r16 = r15.f2233a;
        if (r16 >= r11) goto L10;
    L11:
        r14.add(r15);
    L13:
        if ((r15.f2233a + r15.f2234b) >= r10) goto L15;
    L10:
        if ((r16 + r15.f2234b) <= r10) goto L13;
    L15:
        r13 = r13 + 1;
    L17:
        return r14.toString();
    }

    @WorkerThread
    public static List<i> dumpLockInfo() {
        LinkedList r10 = new LinkedList();
        int r11 = 0;
    L4:
        if (r11 >= 100) goto L9;
        int r12 = (((position + 100) - r11) - 1) % 100;
        i[] r13 = lockInfoQueue;
        i r14 = r13[r12];
        r13[r12] = null;
        if (r14 == null) goto L8;
        r10.add(r14);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        return r10;
    }

    public static void dumpLockInfo(j r10) {
        q0.b.f().i(new d(r10));
    }

    public static void endLockDetect(@NonNull JSONObject r10) {
        if (isLockMonitoring == true) goto L5;
        return;
    L5:
        isLockMonitoring = false;
        r10.put(KEY_IS_LOCK, true);     // Catch: JSONException -> L8
        r10.put(KEY_IS_ALL_THREAD, isAllThread);     // Catch: JSONException -> L8
    L11:
        if (com.bytedance.apm.d.J() == false) goto L16;
        reportLockInfo(r10);
        k.n().l();
        return;
    L16:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @WorkerThread
    private static void enqueue(i r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        i[] r11 = lockInfoQueue;
        int r12 = position;
        r11[r12] = r10;
        position = (r12 + 1) % 100;
    }

    private static void getOwnerStack(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L27;
        ThreadGroup r11 = Looper.getMainLooper().getThread().getThreadGroup();
        int r12 = r11.activeCount();
        int r13 = r12 + (r12 / 2);
        Thread[] r14 = new Thread[r13];
        r11.enumerate(r14);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L28;
        Thread r16 = r14[r15];
        if (r16 == null) goto L29;
        if (r16 == Thread.currentThread()) goto L19;
        if (r16.getName().contains(r10) == false) goto L19;
        if (openFetchStack == false) goto L19;
        sStackFetcher.execute(new f(r16));
    L19:
        r15 = r15 + 1;
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
        ThreadGroup r11 = Looper.getMainLooper().getThread().getThreadGroup();
        int r12 = r11.activeCount();
        int r13 = r12 + (r12 / 2);
        Thread[] r14 = new Thread[r13];
        r11.enumerate(r14);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L24;
        Thread r16 = r14[r15];
        if (r16 == null) goto L25;
        if (r16.getName().contains(r10) == false) goto L16;
        if (openFetchStack == false) goto L16;
        sStackFetcher.execute(new g(r16));
    L16:
        r15 = r15 + 1;
        goto L7
    L25:
        return;
    L24:
        return;
    }

    @Keep
    @WorkerThread
    private static void nativeGetJavaStack(String r10, String r11) {
        if (openFetchStack == false) goto L22;
        sStackFetcher.execute(new h(r11));
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == true) goto L30;
        int r12 = r10.indexOf("monitor contention with owner");
        if (r12 > 0) goto L12;
        return;
    L12:
        if (r12 >= r10.length()) goto L25;
        String r13 = r10.substring(r12);
        int r14 = r13.indexOf("(") - 1;
        if (r14 > 0) goto L16;
        return;
    L16:
        if (30 < r13.length()) goto L18;
        return;
    L18:
        if (r14 >= r13.length()) goto L28;
        if (30 >= r14) goto L29;
        getOwnerStack(r13.substring(30, r14));
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
    private static void nativePut(String r10) {
        sLockHandler.execute(new e(r10));
    }

    private static JSONObject packJsonData(i r10, JSONObject r11) {
        JSONObject r12 = new JSONObject();
        r12.put("timestamp", r10.f2233a);     // Catch: JSONException -> L16
        r12.put("crash_time", r10.f2233a);     // Catch: JSONException -> L16
        r12.put("is_main_process", com.bytedance.apm.d.I());     // Catch: JSONException -> L16
        r12.put("process_name", com.bytedance.apm.d.h());     // Catch: JSONException -> L16
        r12.put("block_duration", r10.f2234b);     // Catch: JSONException -> L16
        r12.put(KEY_RAW_DUMP_INFO, r10.f2235c);     // Catch: JSONException -> L16
        StringBuilder r13 = new StringBuilder();     // Catch: JSONException -> L16
        if (TextUtils.isEmpty(i.a(r10)) == true) goto L7;
        r13.append(i.a(r10).replace("\t", ""));     // Catch: JSONException -> L16
        r13.append("\n");     // Catch: JSONException -> L16
    L7:
        r13.append("-OwnerThread: ");     // Catch: JSONException -> L16
        r13.append(r10.g());     // Catch: JSONException -> L16
        r13.append("\n");     // Catch: JSONException -> L16
        r13.append("-OwnerStack: ");     // Catch: JSONException -> L16
        r13.append(r10.f());     // Catch: JSONException -> L16
        r13.append("\n");     // Catch: JSONException -> L16
        r13.append("-WaiterStack: ");     // Catch: JSONException -> L16
        r13.append(r10.d());     // Catch: JSONException -> L16
        r13.append("\n");     // Catch: JSONException -> L16
        r13.append("-RawAtrace: ");     // Catch: JSONException -> L16
        r13.append(r10.f2235c);     // Catch: JSONException -> L16
        r13.append("\n");     // Catch: JSONException -> L16
        r13.append("-LockThread: ");     // Catch: JSONException -> L16
        r13.append(r10.e());     // Catch: JSONException -> L16
        r13.append("\n");     // Catch: JSONException -> L16
        if (i.b(r10) == null) goto L10;
        r13.append("-Activity: ");     // Catch: JSONException -> L16
        r13.append(i.b(r10));     // Catch: JSONException -> L16
        r13.append("\n");     // Catch: JSONException -> L16
    L10:
        JSONObject r14 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: JSONException -> L16
        r14.put("block_stack_type", "stack");     // Catch: JSONException -> L16
        Iterator<String> r15 = r11.keys();     // Catch: JSONException -> L16
    L12:
        if (r15.hasNext() == false) goto L14;
        String r16 = r15.next();     // Catch: JSONException -> L16
        r14.put(r16, r11.get(r16));     // Catch: JSONException -> L16
        goto L12
    L14:
        r12.put("filters", r14);     // Catch: JSONException -> L16
        r12.put("stack", r13.toString());     // Catch: JSONException -> L16
        r12.put(Constants.EVENT_TYPE, "lag");     // Catch: JSONException -> L16
        return r12;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void reportLockInfo(JSONObject r10) {
        dumpLockInfo(new c(r10));
    }

    public static void setOpenFetchStack(boolean r10) {
        openFetchStack = r10;
        if (r10 == true) goto L6;
        lastJavaStack = null;
        lastOwnerJavaStack = null;
        return;
    }

    public static void startLockDetect() {
        startLockDetect(30);
    }

    public static void startLockDetect(long r10) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        if (com.bytedance.apm.d.J() == false) goto L9;
        k.n().B(r10, false);
        return;
    }

    public static void startLockDetect(long r10, boolean r11) {
        if (isLockMonitoring == false) goto L5;
        return;
    L5:
        isLockMonitoring = true;
        isAllThread = r11;
        if (com.bytedance.apm.d.J() == false) goto L9;
        k.n().B(r10, r11);
        return;
    }
}
