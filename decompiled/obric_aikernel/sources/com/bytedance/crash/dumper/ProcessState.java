package com.bytedance.crash.dumper;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.DoubleReflectHelper;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    static /* synthetic */ void access$000(ProcessState r10) {
        r10.collect();
    }

    private synchronized void collect() {
        monitor-enter(this);
        this.state[this.index].reset();     // Catch: Throwable -> L6
        Entry r10 = this.state[this.index];     // Catch: Throwable -> L6
        r10.time = System.currentTimeMillis();     // Catch: Throwable -> L6
        Entry r11 = this.state[this.index];     // Catch: Throwable -> L6
        r11.state = getState();     // Catch: Throwable -> L6
        this.index = (this.index + 1) % 10;     // Catch: Throwable -> L6
        DefaultWorkThread.postDelayed(this.runnable, WsConstants.EXIT_DELAY_TIME);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void copy() {
        monitor-enter(this);
        Entry[] r10 = this.state;     // Catch: Throwable -> L15
        monitor-enter(r10);     // Catch: Throwable -> L15
        int r11 = 0;
    L7:
        if (r11 >= 10) goto L9;
        this.result[r11] = this.state[r11];     // Catch: Throwable -> L12
        r11 = r11 + 1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L12
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
        int r10 = -1;
        if (this.activityThread != null) goto L8;
        Class<?> r11 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L22
        this.activityThreadClass = r11;     // Catch: Throwable -> L22
        Method r12 = DoubleReflectHelper.getMethodInner(r11, "currentActivityThread", null);     // Catch: Throwable -> L22
        r12.setAccessible(true);     // Catch: Throwable -> L22
        this.activityThread = r12.invoke(this.activityThreadClass, new Object[0]);     // Catch: Throwable -> L22
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if (this.processStateField != null) goto L12;
        this.processStateField = DoubleReflectHelper.getField(this.activityThreadClass, "mLastProcessState");     // Catch: Throwable -> L22
    L12:
        this.processStateField.setAccessible(true);     // Catch: Throwable -> L22
        Object r13 = this.processStateField.get(this.activityThread);     // Catch: Throwable -> L22
    L13:
        r10 = ((Integer) r13).intValue();     // Catch: Throwable -> L22
        return r10;
    L15:
        if (this.applicationThread != null) goto L17;
        Method r14 = DoubleReflectHelper.getMethodInner(this.activityThreadClass, "getApplicationThread", null);     // Catch: Throwable -> L22
        r14.setAccessible(true);     // Catch: Throwable -> L22
        Object r15 = r14.invoke(this.activityThread, new Object[0]);     // Catch: Throwable -> L22
        this.applicationThread = r15;     // Catch: Throwable -> L22
        this.processStateField = DoubleReflectHelper.getField(r15.getClass(), "mLastProcessState");     // Catch: Throwable -> L22
    L17:
        Field r16 = this.processStateField;     // Catch: Throwable -> L22
        if (r16 == null) goto L25;
        r16.setAccessible(true);     // Catch: Throwable -> L22
        r13 = this.processStateField.get(this.applicationThread);     // Catch: Throwable -> L22
        goto L13
    L25:
        return -1;
    L26:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void pushFilters(File r21, JSONObject r22, JSONObject r23) {
        long r10 = r22.optLong("crash_time");     // Catch: Throwable -> L65
        File r11 = new File(r21, "process_state.txt");     // Catch: Throwable -> L65
        if (r11.exists() == true) goto L6;
        return;
    L6:
        SimpleDateFormat r12 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: Throwable -> L65
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L65
        long r14 = 2147483647L;
        BufferedReader r15 = null;
        String r16 = null;
        BufferedReader r17 = null;
        char r18 = 1;
        char r19 = 0;
        BufferedReader r110 = new BufferedReader(new FileReader(r11));     // Catch: Throwable -> L36 Exception -> L39
    L74:
        String r20 = r110.readLine();     // Catch: Throwable -> L30 Exception -> L33
        if (r20 == null) goto L22;
        String[] r111 = r20.split(",");     // Catch: Exception -> L21 Throwable -> L30
        BufferedReader r112 = r110;
        long r113 = Long.parseLong(r111[r19]);     // Catch: Exception -> L20 Throwable -> L27
        long r114 = r113 - r10;     // Catch: Exception -> L20 Throwable -> L27
        if (r114 > 0) goto L16;
    L18:
        r13.append(r12.format(new Date(r113)));     // Catch: Exception -> L20 Throwable -> L27
        r13.append(":");     // Catch: Exception -> L20 Throwable -> L27
        r13.append(r111[1]);     // Catch: Exception -> L20 Throwable -> L27
        r13.append("\n");     // Catch: Exception -> L20 Throwable -> L27
        r110 = r112;
        r19 = 0;
        goto L74
    L16:
        if (r114 >= r14) goto L18;
        r16 = r20;
        r14 = r114;
    L27:
        th = th;
    L32:
        r15 = r112;
    L37:
        FileSystemUtils.close(r15);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L20:
        r16 = r16;
        r17 = r112;
        char r24 = 0;
    L40:
        FileSystemUtils.close(r17);     // Catch: Throwable -> L65
        r16 = r16;
    L42:
        if (TextUtils.isEmpty(r16) == false) goto L44;
        return;
    L44:
        int r25 = Integer.parseInt(r16.split(",")[1]);     // Catch: Throwable -> L65
        int r26 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L65
        if (r26 != 29) goto L52;
        if (r25 > 7) goto L50;
    L49:
        r18 = r24;
    L50:
        boolean r115 = r18;
    L62:
        r23.put("is_background_v2", String.valueOf(r115));     // Catch: Throwable -> L65
        r23.put("process_state", String.valueOf(r25));     // Catch: Throwable -> L65
        return;
    L52:
        if (r26 != 28) goto L57;
        if (r25 <= 5) goto L49;
    L57:
        if (r26 >= 23) goto L59;
        r115 = r24;
        goto L62
    L59:
        if (r25 <= 6) goto L49;
    L21:
        r112 = r110;
        r24 = r19;
    L35:
        r17 = r112;
        goto L40
    L22:
        r112 = r110;
        r24 = 0;
        FileUtils.writeFile(new File(r21, "process_state_format.txt"), r13.toString(), false);     // Catch: Throwable -> L27 Exception -> L64
        FileSystemUtils.close(r112);     // Catch: Throwable -> L65
        goto L42
    L29:
        r24 = 0;
    L30:
        th = th;
        r112 = r110;
    L33:
        r24 = r19;
        r112 = r110;
        goto L35
    L39:
        r24 = 0;
        r16 = null;
    L36:
        th = th;
        goto L37
    }

    public void dump(File r10) {
        if (this.isInited == true) goto L12;
        return;
    L12:
        DefaultWorkThread.removeCallbacks(this.runnable);     // Catch: Throwable -> L11
        collect();     // Catch: Throwable -> L11
        copy();     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L11
        Arrays.sort(this.result, new AnonymousClass2(this));     // Catch: Throwable -> L11
        int r12 = 0;
    L6:
        Entry[] r13 = this.result;     // Catch: Throwable -> L11
        if (r12 >= r13.length) goto L9;
        r11.append(r13[r12].time);     // Catch: Throwable -> L11
        r11.append(",");     // Catch: Throwable -> L11
        r11.append(this.result[r12].state);     // Catch: Throwable -> L11
        r11.append("\n");     // Catch: Throwable -> L11
        r12 = r12 + 1;     // Catch: Throwable -> L11
        goto L6
    L9:
        FileUtils.writeFile(new File(r10, "process_state.txt"), r11.toString(), false);     // Catch: Throwable -> L11
        return;
    }

    public void start() {
        int r10 = 0;
    L4:
        if (r10 >= 10) goto L6;
        this.state[r10] = new Entry();
        r10 = r10 + 1;
        goto L4
    L6:
        DefaultWorkThread.postDelayed(this.runnable, WsConstants.EXIT_DELAY_TIME);
        this.isInited = true;
    }
}
