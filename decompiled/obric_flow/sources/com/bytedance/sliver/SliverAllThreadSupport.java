package com.bytedance.sliver;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.Keep;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
final class SliverAllThreadSupport {
    static final int SLIVER_GROUP_CACHE_SIZE = 50000;
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 21;
    private static e filter;
    private static volatile boolean isRunning;
    private static volatile boolean isStart;
    private static final Thread mainThread = null;
    private static int samplingRateMs;
    private static ThreadGroup systemThreadGroup;
    private static final List<g> threadGroups = null;
    private static Handler threadHandler;

    static {
        threadGroups = new LinkedList();
        mainThread = Looper.getMainLooper().getThread();
        isStart = false;
        isRunning = false;
        samplingRateMs = 10;
        threadHandler = null;
        systemThreadGroup = null;
    }

    public SliverAllThreadSupport() {
    }

    public static /* synthetic */ boolean access$000(String r5) {
        return dumpHeader(r5);
    }

    public static /* synthetic */ List access$100() {
        return threadGroups;
    }

    public static /* synthetic */ void access$1000(long r5) {
        nPauseSliverGroup(r5);
    }

    public static /* synthetic */ void access$1100(long r5) {
        nResumeSliverGroup(r5);
    }

    public static /* synthetic */ void access$1200(long r5) {
        nClearSliverGroup(r5);
    }

    public static /* synthetic */ List access$200() {
        return getAllThread();
    }

    public static /* synthetic */ Handler access$300() {
        return newThreadHandler();
    }

    public static /* synthetic */ e access$400() {
        return null;
    }

    public static /* synthetic */ void access$500(long r5, Thread[] r10, long[] r11) {
        nNotifySliverGroup(r5, r10, r11);
    }

    public static /* synthetic */ long access$600(int r5, int r10, int r11, int r12) {
        return nStartSliverGroup(r5, r10, r11, r12);
    }

    public static /* synthetic */ void access$700(long r5) {
        nStopSliverGroup(r5);
    }

    public static /* synthetic */ int access$800(long r5) {
        return nGetThreadId(r5);
    }

    public static /* synthetic */ void access$900(long r5, String r10) {
        nDumpSliverGroup(r5, r10);
    }

    public static boolean clearAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        Iterator<g> r5 = threadGroups.iterator();
    L8:
        if (r5.hasNext() == false) goto L17;
        g r10 = r5.next();
        monitor-enter(r10);
        access$1200(r10.d);     // Catch: Throwable -> L14
        monitor-exit(r10);
    L14:
        th = move-exception;
        throw th;
    L17:
        return true;
    }

    private static synchronized void deleteThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
        Handler r5 = threadHandler;     // Catch: Throwable -> L8
        if (r5 == null) goto L10;
        r5.removeCallbacksAndMessages(null);     // Catch: Throwable -> L8
        threadHandler.getLooper().quitSafely();     // Catch: Throwable -> L8
        threadHandler = null;     // Catch: Throwable -> L8
    L10:
        monitor-exit(SliverAllThreadSupport.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean dumpAll(String r5, boolean r10) {
        if (isStart == true) goto L6;
        return false;
    L6:
        f r11 = new f(r5);
        if (r10 == false) goto L9;
        r11.run();
        return true;
    L9:
        newThreadHandler().post(r11);
        return true;
    }

    private static boolean dumpHeader(String r5) {
        BufferedWriter r10 = null;
        BufferedWriter r11 = new BufferedWriter(new FileWriter(r5));     // Catch: Throwable -> L14
        r11.write("# sliver\n");     // Catch: Throwable -> L8
        r11.write("# pid:" + Process.myPid() + "\n");     // Catch: Throwable -> L8
        r11.flush();     // Catch: Throwable -> L8
        r11.close();     // Catch: IOException -> L13
        return true;
    L24:
        return true;
    L8:
        r10 = r11;
    L9:
        if (r10 == null) goto L25;
        r10.close();     // Catch: IOException -> L15
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    private static List<Thread> getAllThread() {
        int r5 = systemThreadGroup.activeCount();
        Thread[] r10 = new Thread[(r5 / 2) + r5];
        int r11 = systemThreadGroup.enumerate(r10);
        ArrayList r12 = new ArrayList(r11);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L12;
        Thread r14 = r10[r13];
        if (r14 == mainThread) goto L11;
        if (r14.getName().contains("sliver") == true) goto L11;
        r12.add(r10[r13]);
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        return r12;
    }

    private static boolean initSystemThreadGroup() {
        if (systemThreadGroup != null) goto L7;
        Field r5 = ThreadGroup.class.getDeclaredField("systemThreadGroup");     // Catch: Throwable -> L11
        r5.setAccessible(true);     // Catch: Throwable -> L11
        systemThreadGroup = (ThreadGroup) r5.get(null);     // Catch: Throwable -> L11
    L7:
        if (systemThreadGroup != null) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean isStart() {
        return isStart;
    }

    private static native void nClearSliverGroup(long r5);

    private static native void nDumpSliverGroup(long r5, String r10);

    private static native int nGetThreadId(long r5);

    private static native void nNotifySliverGroup(long r5, Thread[] r10, long[] r11);

    private static native void nPauseSliverGroup(long r5);

    private static native void nResumeSliverGroup(long r5);

    private static native long nStartSliverGroup(int r5, int r10, int r11, int r12);

    private static native void nStopSliverGroup(long r5);

    private static synchronized Handler newThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (threadHandler != null) goto L9;
        HandlerThread r5 = new HandlerThread("sliver_check_thread");     // Catch: Throwable -> L7
        r5.start();     // Catch: Throwable -> L7
        threadHandler = new Handler(r5.getLooper());     // Catch: Throwable -> L7
    L9:
        Handler r10 = threadHandler;     // Catch: Throwable -> L7
        monitor-exit(SliverAllThreadSupport.class);
        return r10;
    }

    public static boolean pauseAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == true) goto L8;
        return false;
    L8:
        Iterator<g> r5 = threadGroups.iterator();
    L10:
        if (r5.hasNext() == false) goto L19;
        g r10 = r5.next();
        monitor-enter(r10);
        access$1000(r10.d);     // Catch: Throwable -> L16
        monitor-exit(r10);
    L16:
        th = move-exception;
        throw th;
    L19:
        deleteThreadHandler();
        isRunning = false;
        return true;
    }

    public static boolean resumeAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == false) goto L8;
        return false;
    L8:
        Iterator<g> r5 = threadGroups.iterator();
    L10:
        if (r5.hasNext() == false) goto L19;
        g r10 = r5.next();
        monitor-enter(r10);
        access$1100(r10.d);     // Catch: Throwable -> L16
        monitor-exit(r10);
    L16:
        th = move-exception;
        throw th;
    L19:
        newThreadHandler().post(new h(samplingRateMs));
        isRunning = true;
        return true;
    }

    public static boolean startAll(int r5, int r10, int r11, Sliver.Mode r12, e r13) {
        if (Build.VERSION.SDK_INT <= 31) goto L6;
        return false;
    L6:
        if (isStart == false) goto L9;
        return false;
    L9:
        if (initSystemThreadGroup() == true) goto L11;
        return false;
    L11:
        samplingRateMs = r10;
        List<g> r14 = threadGroups;
        r14.clear();
        int r15 = Math.max(r5, 2);
        g r16 = new g(0, r10, r11, r12);
        Thread r17 = mainThread;
        monitor-enter(r16);
        r16.f7519c.add(r17);     // Catch: Throwable -> L20
        r16.g = true;     // Catch: Throwable -> L20
        monitor-exit(r16);
        r16.a();
        r14.add(r16);
        int r18 = 1;
    L16:
        if (r18 >= r15) goto L18;
        threadGroups.add(new g(r18, r10, r11, r12));
        r18 = r18 + 1;
        goto L16
    L18:
        newThreadHandler().post(new h(r10 * 5));
        isStart = true;
        isRunning = true;
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean stopAll() {
        if (isStart == true) goto L5;
        return false;
    L5:
        Iterator<g> r5 = threadGroups.iterator();
    L7:
        if (r5.hasNext() == false) goto L21;
        g r10 = r5.next();
        monitor-enter(r10);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (r10.d == 0) goto L13;
        access$700(r10.d);     // Catch: Throwable -> L18
        monitor-exit(r10);
        goto L7
    L13:
        monitor-exit(r10);
        goto L7
    L21:
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }
}
