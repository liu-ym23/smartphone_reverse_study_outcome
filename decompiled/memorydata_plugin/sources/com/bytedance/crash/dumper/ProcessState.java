package com.bytedance.crash.dumper;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.DoubleReflectHelper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessState {
    private static final int LENGTH = 10;
    private static ProcessState sProcessState;
    private Object activityThread;
    private Class activityThreadClass;
    private Object applicationThread;
    private int index;
    private volatile boolean isInited;
    private Field processStateField;
    private Entry[] result;
    private Runnable runnable;
    private Entry[] state;

    static class Entry {
        public int state;
        public long time;

        Entry() {
        }

        public void reset() {
            this.time = 0;
            this.state = 0;
        }
    }

    static {
        sProcessState = new ProcessState();
    }

    public ProcessState() {
        this.state = new Entry[10];
        this.result = new Entry[10];
        this.index = 0;
        this.activityThread = null;
        this.applicationThread = null;
        this.processStateField = null;
        this.isInited = false;
        this.runnable = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(ProcessState r0) {
        r0.collect();
    }

    private synchronized void collect() {
        monitor-enter(this);
        this.state[this.index].reset();     // Catch: Throwable -> L6
        Entry r0 = this.state[this.index];     // Catch: Throwable -> L6
        r0.time = System.currentTimeMillis();     // Catch: Throwable -> L6
        Entry r1 = this.state[this.index];     // Catch: Throwable -> L6
        r1.state = getState();     // Catch: Throwable -> L6
        this.index = (this.index + 1) % 10;     // Catch: Throwable -> L6
        DefaultWorkThread.postDelayed(this.runnable, 3000);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void copy() {
        monitor-enter(this);
        Entry[] r0 = this.state;     // Catch: Throwable -> L15
        monitor-enter(r0);     // Catch: Throwable -> L15
        int r1 = 0;
    L7:
        if (r1 >= 10) goto L9;
        this.result[r1] = this.state[r1];     // Catch: Throwable -> L12
        r1 = r1 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static ProcessState getInstance() {
        return sProcessState;
    }

    private int getState() {
        int r0 = -1;
        if (this.activityThread != null) goto L9;
        Class r1 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        this.activityThreadClass = r1;     // Catch: Throwable -> L23
        Method r2 = DoubleReflectHelper.getMethodInner(r1, "currentActivityThread", null);     // Catch: Throwable -> L23
        r2.setAccessible(true);     // Catch: Throwable -> L23
        this.activityThread = r2.invoke(this.activityThreadClass, new Object[0]);     // Catch: Throwable -> L23
    L9:
        if (Build.VERSION.SDK_INT < 29) goto L16;
        if (this.processStateField != null) goto L13;
        this.processStateField = DoubleReflectHelper.getField(this.activityThreadClass, "mLastProcessState");     // Catch: Throwable -> L23
    L13:
        this.processStateField.setAccessible(true);     // Catch: Throwable -> L23
        Object r8 = ZeusTransformUtils.preCheckCast(this.processStateField.get(this.activityThread), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
    L14:
        r0 = ((Integer) r8).intValue();     // Catch: Throwable -> L23
        return r0;
    L16:
        if (this.applicationThread != null) goto L18;
        Method r3 = DoubleReflectHelper.getMethodInner(this.activityThreadClass, "getApplicationThread", null);     // Catch: Throwable -> L23
        r3.setAccessible(true);     // Catch: Throwable -> L23
        Object r4 = r3.invoke(this.activityThread, new Object[0]);     // Catch: Throwable -> L23
        this.applicationThread = r4;     // Catch: Throwable -> L23
        this.processStateField = DoubleReflectHelper.getField(r4.getClass(), "mLastProcessState");     // Catch: Throwable -> L23
    L18:
        Field r5 = this.processStateField;     // Catch: Throwable -> L23
        if (r5 == null) goto L26;
        r5.setAccessible(true);     // Catch: Throwable -> L23
        r8 = ZeusTransformUtils.preCheckCast(this.processStateField.get(this.applicationThread), Integer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        goto L14
    L26:
        return -1;
    L27:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void pushFilters(File r21, JSONObject r22, JSONObject r23) {
        long r3 = r22.optLong("crash_time");     // Catch: Throwable -> L65
        File r5 = new File(r21, "process_state.txt");     // Catch: Throwable -> L65
        if (r5.exists() == true) goto L6;
        return;
    L6:
        SimpleDateFormat r6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: Throwable -> L65
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L65
        long r8 = 2147483647L;
        BufferedReader r10 = null;
        String r0 = null;
        BufferedReader r11 = null;
        char r12 = 1;
        char r13 = 0;
        BufferedReader r14 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L36 Exception -> L39
    L74:
        String r9 = r14.readLine();     // Catch: Throwable -> L30 Exception -> L33
        if (r9 == null) goto L22;
        String[] r15 = r9.split(",");     // Catch: Exception -> L21 Throwable -> L30
        BufferedReader r16 = r14;
        long r17 = Long.parseLong(r15[r13]);     // Catch: Exception -> L20 Throwable -> L27
        long r18 = r17 - r3;     // Catch: Exception -> L20 Throwable -> L27
        if (r18 > 0) goto L16;
    L18:
        r7.append(r6.format(new Date(r17)));     // Catch: Exception -> L20 Throwable -> L27
        r7.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);     // Catch: Exception -> L20 Throwable -> L27
        r7.append(r15[1]);     // Catch: Exception -> L20 Throwable -> L27
        r7.append("\n");     // Catch: Exception -> L20 Throwable -> L27
        r14 = r16;
        r13 = 0;
        goto L74
    L16:
        if (r18 >= r8) goto L18;
        r0 = r9;
        r8 = r18;
    L27:
        th = th;
    L32:
        r10 = r16;
    L37:
        FileSystemUtils.close(r10);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L20:
        r0 = r0;
        r11 = r16;
        char r4 = 0;
    L40:
        FileSystemUtils.close(r11);     // Catch: Throwable -> L65
        r0 = r0;
    L42:
        if (TextUtils.isEmpty(r0) == false) goto L44;
        return;
    L44:
        int r1 = Integer.parseInt(r0.split(",")[1]);     // Catch: Throwable -> L65
        if (Build.VERSION.SDK_INT != 29) goto L52;
        if (r1 > 7) goto L50;
    L49:
        r12 = r4;
    L50:
        boolean r19 = r12;
    L62:
        r23.put("is_background_v2", String.valueOf(r19));     // Catch: Throwable -> L65
        r23.put("process_state", String.valueOf(r1));     // Catch: Throwable -> L65
        return;
    L52:
        if (Build.VERSION.SDK_INT != 28) goto L57;
        if (r1 <= 5) goto L49;
    L57:
        if (Build.VERSION.SDK_INT >= 23) goto L59;
        r19 = r4;
        goto L62
    L59:
        if (r1 <= 6) goto L49;
    L21:
        r16 = r14;
        r4 = r13;
    L35:
        r11 = r16;
        goto L40
    L22:
        r16 = r14;
        r4 = 0;
        FileUtils.writeFile(new File(r21, "process_state_format.txt"), r7.toString(), false);     // Catch: Throwable -> L27 Exception -> L64
        FileSystemUtils.close(r16);     // Catch: Throwable -> L65
        goto L42
    L29:
        r4 = 0;
    L30:
        th = th;
        r16 = r14;
    L33:
        r4 = r13;
        r16 = r14;
        goto L35
    L39:
        r4 = 0;
        r0 = null;
    L36:
        th = th;
        goto L37
    }

    public void dump(File r6) {
        if (this.isInited == true) goto L12;
        return;
    L12:
        DefaultWorkThread.removeCallbacks(this.runnable);     // Catch: Throwable -> L11
        collect();     // Catch: Throwable -> L11
        copy();     // Catch: Throwable -> L11
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L11
        Arrays.sort(this.result, new AnonymousClass2(this));     // Catch: Throwable -> L11
        int r2 = 0;
    L6:
        Entry[] r3 = this.result;     // Catch: Throwable -> L11
        if (r2 >= r3.length) goto L9;
        r0.append(r3[r2].time);     // Catch: Throwable -> L11
        r0.append(",");     // Catch: Throwable -> L11
        r0.append(this.result[r2].state);     // Catch: Throwable -> L11
        r0.append("\n");     // Catch: Throwable -> L11
        r2 = r2 + 1;     // Catch: Throwable -> L11
        goto L6
    L9:
        FileUtils.writeFile(new File(r6, "process_state.txt"), r0.toString(), false);     // Catch: Throwable -> L11
        return;
    }

    public void start() {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L6;
        this.state[r0] = new Entry();
        r0 = r0 + 1;
        goto L4
    L6:
        DefaultWorkThread.postDelayed(this.runnable, 3000);
        this.isInited = true;
    }
}
