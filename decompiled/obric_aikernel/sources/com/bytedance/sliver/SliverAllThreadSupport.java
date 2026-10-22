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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Keep
final class SliverAllThreadSupport {
    static final int SLIVER_GROUP_CACHE_SIZE = 50000;
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 21;
    private static Sliver.i filter;
    private static volatile boolean isRunning;
    private static volatile boolean isStart;
    private static final Thread mainThread = null;
    private static int samplingRateMs;
    private static ThreadGroup systemThreadGroup;
    private static final List<b> threadGroups = null;
    private static Handler threadHandler;

    static class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2760c;

        a(String r10) {
            this.f2760c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SliverAllThreadSupport.access$000(this.f2760c) == true) goto L5;
            return;
        L5:
            Iterator r10 = SliverAllThreadSupport.access$100().iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            ((b) r10.next()).d(this.f2760c);
            goto L7
        L9:
            Iterator r11 = SliverAllThreadSupport.access$100().iterator();
        L11:
            if (r11.hasNext() == false) goto L13;
            ((b) r11.next()).c(this.f2760c);
            goto L11
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HashSet<Thread> f2763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile long f2764d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f2765e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Sliver.Mode f2766f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile boolean f2767g;

        b(int r10, int r11, int r12, Sliver.Mode r13) {
            this.f2764d = 0;
            this.f2767g = false;
            this.f2761a = r10;
            this.f2762b = r11;
            this.f2763c = new HashSet();
            this.f2765e = r12;
            this.f2766f = r13;
        }

        synchronized void a(Thread r10) {
            monitor-enter(this);
            this.f2763c.add(r10);     // Catch: Throwable -> L6
            this.f2767g = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void b() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1200(this.f2764d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void c(String r10) {
            monitor-enter(this);
            SliverAllThreadSupport.access$900(this.f2764d, r10);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void d(String r10) {
            monitor-enter(this);
            BufferedWriter r11 = null;
            BufferedWriter r12 = new BufferedWriter(new FileWriter(r10, true));     // Catch: Throwable -> L24
            Iterator<Thread> r13 = this.f2763c.iterator();     // Catch: Throwable -> L14
        L7:
            if (r13.hasNext() == false) goto L12;
            Thread r14 = r13.next();     // Catch: Throwable -> L14
            long r15 = Sliver.getThreadPeer(r14);     // Catch: Throwable -> L14
            if (r15 == 0) goto L7;
            r12.write("# thread_info:" + SliverAllThreadSupport.access$800(r15) + ":" + r14.getName() + "\n");     // Catch: Throwable -> L14
            goto L7
        L12:
            r12.flush();     // Catch: Throwable -> L14
            r12.close();     // Catch: Throwable -> L18 IOException -> L23
        L29:
        L14:
            r11 = r12;
        L15:
            if (r11 == null) goto L21;
            r11.close();     // Catch: Throwable -> L18 IOException -> L23
        L18:
            th = move-exception;
            throw th;
        L21:
            monitor-exit(this);
        }

        synchronized void e() {
            monitor-enter(this);
            i();     // Catch: Throwable -> L26
            if (this.f2764d != 0) goto L9;
            monitor-exit(this);
            return;
        L9:
            if (this.f2767g == true) goto L12;
            monitor-exit(this);
            return;
        L12:
            ArrayList r10 = new ArrayList(this.f2763c.size());     // Catch: Throwable -> L26
            ArrayList r11 = new ArrayList(this.f2763c.size());     // Catch: Throwable -> L26
            Iterator<Thread> r12 = this.f2763c.iterator();     // Catch: Throwable -> L26
        L14:
            if (r12.hasNext() == false) goto L19;
            Thread r13 = r12.next();     // Catch: Throwable -> L26
            long r14 = Sliver.getThreadPeer(r13);     // Catch: Throwable -> L26
            if (r14 == 0) goto L14;
            r10.add(Long.valueOf(r14));     // Catch: Throwable -> L26
            r11.add(r13);     // Catch: Throwable -> L26
            goto L14
        L19:
            long[] r15 = new long[r10.size()];     // Catch: Throwable -> L26
            int r16 = 0;
        L21:
            if (r16 >= r10.size()) goto L23;
            r15[r16] = ((Long) r10.get(r16)).longValue();     // Catch: Throwable -> L26
            r16 = r16 + 1;     // Catch: Throwable -> L26
            goto L21
        L23:
            SliverAllThreadSupport.access$500(this.f2764d, (Thread[]) r11.toArray(new Thread[0]), r15);     // Catch: Throwable -> L26
            this.f2767g = false;     // Catch: Throwable -> L26
            monitor-exit(this);
            return;
        L26:
            th = move-exception;
            throw th;
        }

        synchronized void f() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1000(this.f2764d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean g(Thread r10) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.f2763c.isEmpty() == false) goto L9;
            monitor-exit(this);
            return false;
        L9:
            if (this.f2763c.remove(r10) == false) goto L13;
            this.f2767g = true;     // Catch: Throwable -> L15
            monitor-exit(this);
            return true;
        L13:
            monitor-exit(this);
            return false;
        }

        synchronized void h() {
            monitor-enter(this);
            SliverAllThreadSupport.access$1100(this.f2764d);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void i() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f2764d == 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f2764d = SliverAllThreadSupport.access$600(this.f2762b, this.f2765e, Sliver.mode2Int(this.f2766f), this.f2761a);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        synchronized void j() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f2764d != 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            SliverAllThreadSupport.access$700(this.f2764d);     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    private static class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f2768c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<Thread> f2769g;

        public c(int r10) {
            this.f2768c = r10;
        }

        private void a() {
            Iterator r10 = SliverAllThreadSupport.access$100().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((b) r10.next()).e();
            goto L4
        }

        private void b(List<Thread> r10) {
            Iterator<Thread> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L12;
            Thread r12 = r11.next();
            int r13 = 1;
        L7:
            if (r13 >= SliverAllThreadSupport.access$100().size()) goto L4;
            if (((b) SliverAllThreadSupport.access$100().get(r13)).g(r12) == true) goto L4;
            r13 = r13 + 1;
            goto L7
        }

        private void c(List<Thread> r10) {
            int r11 = r10.size();
            int r12 = 0;
        L3:
            int r13 = 1;
        L4:
            if (r12 >= r11) goto L13;
            if (SliverAllThreadSupport.access$400() == null) goto L10;
            if (SliverAllThreadSupport.access$400().a(r10.get(r12)) == true) goto L10;
            r12 = r12 + 1;
        L10:
            ((b) SliverAllThreadSupport.access$100().get(r13)).a(r10.get(r12));
            r12 = r12 + 1;
            r13 = r13 + 1;
            if (r13 < SliverAllThreadSupport.access$100().size()) goto L4;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<Thread> r10 = SliverAllThreadSupport.access$200();
            if (this.f2769g != null) goto L5;
            c(r10);
        L18:
            this.f2769g = r10;
            a();
            SliverAllThreadSupport.access$300().postDelayed(this, this.f2768c);
            return;
        L5:
            ArrayList r11 = new ArrayList();
            ArrayList r12 = new ArrayList();
            Iterator<Thread> r13 = r10.iterator();
        L7:
            if (r13.hasNext() == false) goto L11;
            Thread r14 = r13.next();
            if (this.f2769g.contains(r14) == true) goto L7;
            r11.add(r14);
            goto L7
        L11:
            Iterator<Thread> r15 = this.f2769g.iterator();
        L13:
            if (r15.hasNext() == false) goto L17;
            Thread r16 = r15.next();
            if (r10.contains(r16) == true) goto L13;
            r12.add(r16);
            goto L13
        L17:
            b(r12);
            c(r11);
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

    static /* synthetic */ boolean access$000(String r10) {
        return dumpHeader(r10);
    }

    static /* synthetic */ List access$100() {
        return threadGroups;
    }

    static /* synthetic */ void access$1000(long r10) {
        nPauseSliverGroup(r10);
    }

    static /* synthetic */ void access$1100(long r10) {
        nResumeSliverGroup(r10);
    }

    static /* synthetic */ void access$1200(long r10) {
        nClearSliverGroup(r10);
    }

    static /* synthetic */ List access$200() {
        return getAllThread();
    }

    static /* synthetic */ Handler access$300() {
        return newThreadHandler();
    }

    static /* synthetic */ Sliver.i access$400() {
        return filter;
    }

    static /* synthetic */ void access$500(long r10, Thread[] r11, long[] r12) {
        nNotifySliverGroup(r10, r11, r12);
    }

    static /* synthetic */ long access$600(int r10, int r11, int r12, int r13) {
        return nStartSliverGroup(r10, r11, r12, r13);
    }

    static /* synthetic */ void access$700(long r10) {
        nStopSliverGroup(r10);
    }

    static /* synthetic */ int access$800(long r10) {
        return nGetThreadId(r10);
    }

    static /* synthetic */ void access$900(long r10, String r11) {
        nDumpSliverGroup(r10, r11);
    }

    static boolean clearAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        Iterator<b> r10 = threadGroups.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().b();
        goto L8
    L10:
        return true;
    }

    private static synchronized void deleteThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
        Handler r10 = threadHandler;     // Catch: Throwable -> L9
        if (r10 == null) goto L7;
        r10.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
        threadHandler.getLooper().quitSafely();     // Catch: Throwable -> L9
        threadHandler = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(SliverAllThreadSupport.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static boolean dumpAll(String r10, boolean r11) {
        if (isStart == true) goto L6;
        return false;
    L6:
        a r12 = new a(r10);
        if (r11 == false) goto L9;
        r12.run();
        return true;
    L9:
        newThreadHandler().post(r12);
        return true;
    }

    private static boolean dumpHeader(String r10) {
        BufferedWriter r11 = null;
        BufferedWriter r12 = new BufferedWriter(new FileWriter(r10));     // Catch: Throwable -> L14
        r12.write("# sliver\n");     // Catch: Throwable -> L8
        r12.write("# pid:" + Process.myPid() + "\n");     // Catch: Throwable -> L8
        r12.flush();     // Catch: Throwable -> L8
        r12.close();     // Catch: IOException -> L13
    L7:
        return true;
    L8:
        r11 = r12;
    L10:
        if (r11 != null) goto L22;
    L12:
        return false;
    L22:
        r11.close();     // Catch: IOException -> L15
        goto L12
    }

    private static List<Thread> getAllThread() {
        int r10 = systemThreadGroup.activeCount();
        Thread[] r11 = new Thread[r10 + (r10 / 2)];
        int r12 = systemThreadGroup.enumerate(r11);
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L12;
        if (r11[r14] == mainThread) goto L11;
        if (r11[r14].getName().contains("sliver") == true) goto L11;
        r13.add(r11[r14]);
    L11:
        r14 = r14 + 1;
        goto L3
    L12:
        return r13;
    }

    private static boolean initSystemThreadGroup() {
        if (systemThreadGroup != null) goto L7;
        Field r10 = ThreadGroup.class.getDeclaredField("systemThreadGroup");     // Catch: Throwable -> L11
        r10.setAccessible(true);     // Catch: Throwable -> L11
        systemThreadGroup = (ThreadGroup) r10.get(null);     // Catch: Throwable -> L11
    L7:
        if (systemThreadGroup != null) goto L14;
        return false;
    L14:
        return true;
    }

    static boolean isStart() {
        return isStart;
    }

    private static native void nClearSliverGroup(long r10);

    private static native void nDumpSliverGroup(long r10, String r11);

    private static native int nGetThreadId(long r10);

    private static native void nNotifySliverGroup(long r10, Thread[] r11, long[] r12);

    private static native void nPauseSliverGroup(long r10);

    private static native void nResumeSliverGroup(long r10);

    private static native long nStartSliverGroup(int r10, int r11, int r12, int r13);

    private static native void nStopSliverGroup(long r10);

    private static synchronized Handler newThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (threadHandler != null) goto L7;
        HandlerThread r10 = new HandlerThread("sliver_check_thread");     // Catch: Throwable -> L10
        r10.start();     // Catch: Throwable -> L10
        threadHandler = new Handler(r10.getLooper());     // Catch: Throwable -> L10
    L7:
        Handler r11 = threadHandler;     // Catch: Throwable -> L10
        monitor-exit(SliverAllThreadSupport.class);
        return r11;
    }

    static boolean pauseAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == true) goto L8;
        return false;
    L8:
        Iterator<b> r10 = threadGroups.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r10.next().f();
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
        Iterator<b> r10 = threadGroups.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r10.next().h();
        goto L10
    L12:
        newThreadHandler().post(new c(samplingRateMs));
        isRunning = true;
        return true;
    }

    static boolean startAll(int r10, int r11, int r12, Sliver.Mode r13, Sliver.i r14) {
        int r15 = Build.VERSION.SDK_INT;
        if (r15 >= 21) goto L5;
    L18:
        return false;
    L5:
        if (r15 > 31) goto L18;
        if (isStart == false) goto L11;
        return false;
    L11:
        if (initSystemThreadGroup() == true) goto L13;
        return false;
    L13:
        samplingRateMs = r11;
        filter = r14;
        List<b> r16 = threadGroups;
        r16.clear();
        int r17 = Math.max(r10, 2);
        b r18 = new b(0, r11, r12, r13);
        r18.a(mainThread);
        r18.e();
        r16.add(r18);
        int r19 = 1;
    L14:
        if (r19 >= r17) goto L16;
        threadGroups.add(new b(r19, r11, r12, r13));
        r19 = r19 + 1;
        goto L14
    L16:
        newThreadHandler().post(new c(r11 * 5));
        isStart = true;
        isRunning = true;
        return true;
    }

    static boolean stopAll() {
        if (isStart == true) goto L5;
        return false;
    L5:
        Iterator<b> r10 = threadGroups.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().j();
        goto L7
    L9:
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }
}
