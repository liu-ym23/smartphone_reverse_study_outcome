package com.bytedance.sliver;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
final class SliverAllThreadSupport {
    static final int SLIVER_GROUP_CACHE_SIZE = 50000;
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 21;
    private static Sliver.e filter;
    private static volatile boolean isRunning;
    private static volatile boolean isStart;
    private static final Thread mainThread = null;
    private static int samplingRateMs;
    private static ThreadGroup systemThreadGroup;
    private static final List<a> threadGroups = null;
    private static Handler threadHandler;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3190b;
        private final HashSet<Thread> c;
        private volatile long d;
        private final int e;
        private final Sliver.Mode f;
        private volatile boolean g;

        a(int r3, int r4, int r5, Sliver.Mode r6) {
            this.d = 0;
            this.g = false;
            this.f3189a = r3;
            this.f3190b = r4;
            this.c = new HashSet();
            this.e = r5;
            this.f = r6;
        }

        synchronized void a() {
            monitor-enter(this);
            b();     // Catch: Throwable -> L26
            if (this.d != 0) goto L9;
            monitor-exit(this);
            return;
        L9:
            if (this.g == true) goto L12;
            monitor-exit(this);
            return;
        L12:
            ArrayList r0 = new ArrayList(this.c.size());     // Catch: Throwable -> L26
            ArrayList r1 = new ArrayList(this.c.size());     // Catch: Throwable -> L26
            Iterator<Thread> r4 = this.c.iterator();     // Catch: Throwable -> L26
        L14:
            if (r4.hasNext() == false) goto L19;
            Thread r5 = (Thread) ZeusTransformUtils.preCheckCast(r4.next(), Thread.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
            long r6 = Sliver.getThreadPeer(r5);     // Catch: Throwable -> L26
            if (r6 == 0) goto L14;
            r0.add(Long.valueOf(r6));     // Catch: Throwable -> L26
            r1.add(r5);     // Catch: Throwable -> L26
            goto L14
        L19:
            long[] r2 = new long[r0.size()];     // Catch: Throwable -> L26
            int r7 = 0;
        L21:
            if (r7 >= r0.size()) goto L23;
            r2[r7] = ((Long) ZeusTransformUtils.preCheckCast(r0.get(r7), Long.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L26
            r7 = r7 + 1;     // Catch: Throwable -> L26
            goto L21
        L23:
            SliverAllThreadSupport.access$500(this.d, (Thread[]) ZeusTransformUtils.preCheckCast(r1.toArray(new Thread[0]), Thread[].class, "com.obric.memorydata.plugin"), r2);     // Catch: Throwable -> L26
            this.g = false;     // Catch: Throwable -> L26
            monitor-exit(this);
            return;
        L26:
            th = move-exception;
            throw th;
        }

        synchronized void a(String r7) {
            monitor-enter(this);
            BufferedWriter r0 = null;
            BufferedWriter r1 = new BufferedWriter(new FileWriter(r7, true));     // Catch: Throwable -> L24
            Iterator<Thread> r8 = this.c.iterator();     // Catch: Throwable -> L14
        L7:
            if (r8.hasNext() == false) goto L12;
            Thread r2 = (Thread) ZeusTransformUtils.preCheckCast(r8.next(), Thread.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            long r3 = Sliver.getThreadPeer(r2);     // Catch: Throwable -> L14
            if (r3 == 0) goto L7;
            r1.write("# thread_info:" + SliverAllThreadSupport.access$800(r3) + ParameterizedMessage.ERROR_MSG_SEPARATOR + r2.getName() + "\n");     // Catch: Throwable -> L14
            goto L7
        L12:
            r1.flush();     // Catch: Throwable -> L14
            r1.close();     // Catch: Throwable -> L18 IOException -> L23
        L29:
        L14:
            r0 = r1;
        L15:
            if (r0 == null) goto L21;
            r0.close();     // Catch: Throwable -> L18 IOException -> L23
        L18:
            th = move-exception;
            throw th;
        L21:
            monitor-exit(this);
        }

        synchronized void a(Thread r2) {
            monitor-enter(this);
            this.c.add(r2);     // Catch: Throwable -> L6
            this.g = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void b() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.d == 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.d = SliverAllThreadSupport.access$600(this.f3190b, this.e, Sliver.mode2Int(this.f), this.f3189a);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        synchronized void b(String r3) {
            monitor-enter(this);
            SliverAllThreadSupport.access$900(this.d, r3);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean b(Thread r3) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.c.isEmpty() == false) goto L9;
            monitor-exit(this);
            return false;
        L9:
            if (this.c.remove(r3) == false) goto L13;
            this.g = true;     // Catch: Throwable -> L15
            monitor-exit(this);
            return true;
        L13:
            monitor-exit(this);
            return false;
        }

        synchronized void c() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.d != 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            SliverAllThreadSupport.access$700(this.d);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        synchronized void d() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1000(this.d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void e() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1100(this.d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void f() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1200(this.d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    private static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<Thread> f3192b;

        public b(int r1) {
            this.f3191a = r1;
        }

        private void a() {
            Iterator r3 = SliverAllThreadSupport.access$100().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin")).a();
            goto L4
        }

        private void a(List<Thread> r5) {
            Iterator r4 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r4.hasNext() == false) goto L12;
            Thread r6 = (Thread) ZeusTransformUtils.preCheckCast(r4.next(), Thread.class, "com.obric.memorydata.plugin");
            int r1 = 1;
        L7:
            if (r1 >= SliverAllThreadSupport.access$100().size()) goto L4;
            if (((a) ZeusTransformUtils.preCheckCast(SliverAllThreadSupport.access$100().get(r1), a.class, "com.obric.memorydata.plugin")).b(r6) == true) goto L4;
            r1 = r1 + 1;
            goto L7
        }

        private void b(List<Thread> r8) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            int r9 = r7.size();
            int r2 = 0;
        L3:
            int r3 = 1;
        L4:
            if (r2 >= r9) goto L13;
            if (SliverAllThreadSupport.access$400() == null) goto L10;
            if (SliverAllThreadSupport.access$400().a((Thread) ZeusTransformUtils.preCheckCast(r7.get(r2), Thread.class, "com.obric.memorydata.plugin")) == true) goto L10;
            r2 = r2 + 1;
        L10:
            ((a) ZeusTransformUtils.preCheckCast(SliverAllThreadSupport.access$100().get(r3), a.class, "com.obric.memorydata.plugin")).a((Thread) ZeusTransformUtils.preCheckCast(r7.get(r2), Thread.class, "com.obric.memorydata.plugin"));
            r2 = r2 + 1;
            r3 = r3 + 1;
            if (r3 < SliverAllThreadSupport.access$100().size()) goto L4;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Thread> r0 = SliverAllThreadSupport.access$200();
            if (this.f3192b != null) goto L5;
            b(r0);
        L18:
            this.f3192b = r0;
            a();
            SliverAllThreadSupport.access$300().postDelayed(this, this.f3191a);
            return;
        L5:
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            Iterator<Thread> r3 = r0.iterator();
        L7:
            if (r3.hasNext() == false) goto L11;
            Thread r4 = (Thread) ZeusTransformUtils.preCheckCast(r3.next(), Thread.class, "com.obric.memorydata.plugin");
            if (this.f3192b.contains(r4) == true) goto L7;
            r1.add(r4);
            goto L7
        L11:
            Iterator<Thread> r5 = this.f3192b.iterator();
        L13:
            if (r5.hasNext() == false) goto L17;
            Thread r6 = (Thread) ZeusTransformUtils.preCheckCast(r5.next(), Thread.class, "com.obric.memorydata.plugin");
            if (r0.contains(r6) == true) goto L13;
            r2.add(r6);
            goto L13
        L17:
            a(r2);
            b(r1);
            goto L18
        }
    }

    static {
        threadGroups = new LinkedList();
        mainThread = Looper.getMainLooper().getThread();
        isStart = false;
        isRunning = false;
        samplingRateMs = 10;
        filter = null;
        threadHandler = null;
        systemThreadGroup = null;
    }

    SliverAllThreadSupport() {
    }

    static /* synthetic */ boolean access$000(String r0) {
        return dumpHeader(r0);
    }

    static /* synthetic */ List access$100() {
        return threadGroups;
    }

    static /* synthetic */ void access$1000(long r0) {
        nPauseSliverGroup(r0);
    }

    static /* synthetic */ void access$1100(long r0) {
        nResumeSliverGroup(r0);
    }

    static /* synthetic */ void access$1200(long r0) {
        nClearSliverGroup(r0);
    }

    static /* synthetic */ List access$200() {
        return getAllThread();
    }

    static /* synthetic */ Handler access$300() {
        return newThreadHandler();
    }

    static /* synthetic */ Sliver.e access$400() {
        return filter;
    }

    static /* synthetic */ void access$500(long r0, Thread[] r2, long[] r3) {
        nNotifySliverGroup(r0, r2, r3);
    }

    static /* synthetic */ long access$600(int r0, int r1, int r2, int r3) {
        return nStartSliverGroup(r0, r1, r2, r3);
    }

    static /* synthetic */ void access$700(long r0) {
        nStopSliverGroup(r0);
    }

    static /* synthetic */ int access$800(long r0) {
        return nGetThreadId(r0);
    }

    static /* synthetic */ void access$900(long r0, String r2) {
        nDumpSliverGroup(r0, r2);
    }

    static boolean clearAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        Iterator<a> r0 = threadGroups.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).f();
        goto L8
    L10:
        return true;
    }

    private static synchronized void deleteThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
        Handler r1 = threadHandler;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
        threadHandler.getLooper().quitSafely();     // Catch: Throwable -> L9
        threadHandler = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(SliverAllThreadSupport.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static boolean dumpAll(final String r1, boolean r2) {
        if (isStart == true) goto L6;
        return false;
    L6:
        Runnable r0 = new AnonymousClass1(r1);
        if (r2 == false) goto L9;
        r0.run();
        return true;
    L9:
        newThreadHandler().post(r0);
        return true;
    }

    private static boolean dumpHeader(String r3) {
        BufferedWriter r0 = null;
        BufferedWriter r1 = new BufferedWriter(new FileWriter(r3));     // Catch: Throwable -> L14
        r1.write("# sliver\n");     // Catch: Throwable -> L8
        r1.write("# pid:" + Process.myPid() + "\n");     // Catch: Throwable -> L8
        r1.flush();     // Catch: Throwable -> L8
        r1.close();     // Catch: IOException -> L13
    L7:
        return true;
    L8:
        r0 = r1;
    L10:
        if (r0 != null) goto L22;
    L12:
        return false;
    L22:
        r0.close();     // Catch: IOException -> L15
        goto L12
    }

    private static List<Thread> getAllThread() {
        int r0 = systemThreadGroup.activeCount();
        Thread[] r1 = new Thread[r0 + (r0 / 2)];
        int r2 = systemThreadGroup.enumerate(r1);
        ArrayList r3 = new ArrayList(r2);
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L12;
        if (r1[r4] == mainThread) goto L11;
        if (r1[r4].getName().contains("sliver") == true) goto L11;
        r3.add(r1[r4]);
    L11:
        r4 = r4 + 1;
        goto L3
    L12:
        return r3;
    }

    private static boolean initSystemThreadGroup() {
        if (systemThreadGroup != null) goto L7;
        Field r1 = ThreadGroup.class.getDeclaredField("systemThreadGroup");     // Catch: Throwable -> L11
        r1.setAccessible(true);     // Catch: Throwable -> L11
        systemThreadGroup = (ThreadGroup) ZeusTransformUtils.preCheckCast(r1.get(null), ThreadGroup.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L7:
        if (systemThreadGroup != null) goto L14;
        return false;
    L14:
        return true;
    }

    static boolean isStart() {
        return isStart;
    }

    private static native void nClearSliverGroup(long r0);

    private static native void nDumpSliverGroup(long r0, String r2);

    private static native int nGetThreadId(long r0);

    private static native void nNotifySliverGroup(long r0, Thread[] r2, long[] r3);

    private static native void nPauseSliverGroup(long r0);

    private static native void nResumeSliverGroup(long r0);

    private static native long nStartSliverGroup(int r0, int r1, int r2, int r3);

    private static native void nStopSliverGroup(long r0);

    private static synchronized Handler newThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (threadHandler != null) goto L7;
        HandlerThread r1 = new HandlerThread("sliver_check_thread");     // Catch: Throwable -> L10
        r1.start();     // Catch: Throwable -> L10
        threadHandler = new Handler(r1.getLooper());     // Catch: Throwable -> L10
    L7:
        Handler r2 = threadHandler;     // Catch: Throwable -> L10
        monitor-exit(SliverAllThreadSupport.class);
        return r2;
    }

    static boolean pauseAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == true) goto L8;
        return false;
    L8:
        Iterator<a> r0 = threadGroups.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).d();
        goto L10
    L12:
        deleteThreadHandler();
        isRunning = false;
        return true;
    }

    static boolean resumeAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == false) goto L8;
        return false;
    L8:
        Iterator<a> r0 = threadGroups.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).e();
        goto L10
    L12:
        newThreadHandler().post(new b(samplingRateMs));
        isRunning = true;
        return true;
    }

    static boolean startAll(int r3, int r4, int r5, Sliver.Mode r6, Sliver.e r7) {
        Sliver.e r8 = (Sliver.e) ZeusTransformUtils.wrapperContextForParams(r7, Sliver.e.class, "com.obric.memorydata.plugin");
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 21) goto L5;
    L18:
        return false;
    L5:
        if (r0 > 31) goto L18;
        if (isStart == false) goto L11;
        return false;
    L11:
        if (initSystemThreadGroup() == true) goto L13;
        return false;
    L13:
        samplingRateMs = r4;
        filter = r8;
        List<a> r9 = threadGroups;
        r9.clear();
        int r10 = Math.max(r3, 2);
        a r1 = new a(0, r4, r5, r6);
        r1.a(mainThread);
        r1.a();
        r9.add(r1);
        int r2 = 1;
    L14:
        if (r2 >= r10) goto L16;
        threadGroups.add(new a(r2, r4, r5, r6));
        r2 = r2 + 1;
        goto L14
    L16:
        newThreadHandler().post(new b(r4 * 5));
        isStart = true;
        isRunning = true;
        return true;
    }

    static boolean stopAll() {
        if (isStart == true) goto L5;
        return false;
    L5:
        Iterator<a> r0 = threadGroups.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).c();
        goto L7
    L9:
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }
}
