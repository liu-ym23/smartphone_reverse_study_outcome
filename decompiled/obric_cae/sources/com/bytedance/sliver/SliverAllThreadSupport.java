package com.bytedance.sliver;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.Keep;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
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

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4056a;

        public a(String r8) {
            this.f4056a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SliverAllThreadSupport.access$000(this.f4056a) == true) goto L5;
            return;
        L5:
            Iterator r8 = SliverAllThreadSupport.access$100().iterator();
        L7:
            if (r8.hasNext() == false) goto L29;
            b r10 = (b) r8.next();
            String r11 = this.f4056a;
            monitor-enter(r10);
            BufferedWriter r12 = new BufferedWriter(new FileWriter(r11, true));     // Catch: Throwable -> L20
            Iterator<Thread> r13 = r10.f4059c.iterator();     // Catch: Throwable -> L42
        L13:
            if (r13.hasNext() == false) goto L18;
            Thread r14 = r13.next();     // Catch: Throwable -> L42
            long r15 = Sliver.getThreadPeer(r14);     // Catch: Throwable -> L42
            if (r15 == 0) goto L13;
            r12.write("# thread_info:" + SliverAllThreadSupport.access$800(r15) + BdimCategoryConstants.SEPARATOR_COLON + r14.getName() + "\n");     // Catch: Throwable -> L42
            goto L13
        L18:
            r12.flush();     // Catch: Throwable -> L42
        L49:
            r12.close();     // Catch: Throwable -> L24 IOException -> L41
        L24:
            th = move-exception;
            throw th;
        L27:
            monitor-exit(r10);
        L21:
            if (r12 == null) goto L27;
        L20:
            r12 = null;
            goto L21
        L29:
            Iterator r16 = SliverAllThreadSupport.access$100().iterator();
        L31:
            if (r16.hasNext() == false) goto L40;
            b r17 = (b) r16.next();
            String r18 = this.f4056a;
            monitor-enter(r17);
            SliverAllThreadSupport.access$900(r17.f4060d, r18);     // Catch: Throwable -> L37
            monitor-exit(r17);
        L37:
            th = move-exception;
            throw th;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashSet<Thread> f4059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f4060d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f4061e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Sliver.e f4062f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f4063g;

        public b(int r8, int r10, int r11, Sliver.e r12) {
            this.f4060d = 0;
            this.f4063g = false;
            this.f4057a = r8;
            this.f4058b = r10;
            this.f4059c = new HashSet();
            this.f4061e = r11;
            this.f4062f = r12;
        }

        public final synchronized void a() {
            monitor-enter(this);
            monitor-enter(this);     // Catch: Throwable -> L34
        L36:
            th = move-exception;
            throw th;     // Catch: Throwable -> L34
        L6:
            if (this.f4060d == 0) goto L9;
        L7:
            monitor-exit(this);     // Catch: Throwable -> L34
            if (this.f4060d != 0) goto L17;
            monitor-exit(this);
            return;
        L17:
            if (this.f4063g == true) goto L20;
            monitor-exit(this);
            return;
        L20:
            ArrayList r8 = new ArrayList(this.f4059c.size());     // Catch: Throwable -> L34
            ArrayList r10 = new ArrayList(this.f4059c.size());     // Catch: Throwable -> L34
            Iterator<Thread> r11 = this.f4059c.iterator();     // Catch: Throwable -> L34
        L22:
            if (r11.hasNext() == false) goto L27;
            Thread r12 = r11.next();     // Catch: Throwable -> L34
            long r13 = Sliver.getThreadPeer(r12);     // Catch: Throwable -> L34
            if (r13 == 0) goto L22;
            r8.add(Long.valueOf(r13));     // Catch: Throwable -> L34
            r10.add(r12);     // Catch: Throwable -> L34
            goto L22
        L27:
            long[] r14 = new long[r8.size()];     // Catch: Throwable -> L34
            int r15 = 0;
        L29:
            if (r15 >= r8.size()) goto L31;
            r14[r15] = ((Long) r8.get(r15)).longValue();     // Catch: Throwable -> L34
            r15 = r15 + 1;     // Catch: Throwable -> L34
            goto L29
        L31:
            SliverAllThreadSupport.access$500(this.f4060d, (Thread[]) r10.toArray(new Thread[0]), r14);     // Catch: Throwable -> L34
            this.f4063g = false;     // Catch: Throwable -> L34
            monitor-exit(this);
            return;
        L9:
            this.f4060d = SliverAllThreadSupport.access$600(this.f4058b, this.f4061e, Sliver.mode2Int(this.f4062f), this.f4057a);     // Catch: Throwable -> L36
        L34:
            th = move-exception;
            throw th;
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Thread> f4065b;

        public c(int r8) {
            this.f4064a = r8;
        }

        public static void a(List r8) {
            int r10 = r8.size();
            int r11 = 0;
        L3:
            int r12 = 1;
        L4:
            if (r11 >= r10) goto L15;
            SliverAllThreadSupport.access$400();
            b r13 = (b) SliverAllThreadSupport.access$100().get(r12);
            Thread r14 = (Thread) r8.get(r11);
            monitor-enter(r13);
            r13.f4059c.add(r14);     // Catch: Throwable -> L12
            r13.f4063g = true;     // Catch: Throwable -> L12
            monitor-exit(r13);
            r11 = r11 + 1;
            r12 = r12 + 1;
            if (r12 < SliverAllThreadSupport.access$100().size()) goto L4;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<Thread> r8 = SliverAllThreadSupport.access$200();
            if (this.f4065b != null) goto L5;
            a(r8);
        L42:
            this.f4065b = r8;
            Iterator r10 = SliverAllThreadSupport.access$100().iterator();
        L44:
            if (r10.hasNext() == false) goto L46;
            ((b) r10.next()).a();
            goto L44
        L46:
            SliverAllThreadSupport.access$300().postDelayed(this, this.f4064a);
            return;
        L5:
            ArrayList r11 = new ArrayList();
            ArrayList r12 = new ArrayList();
            Iterator<Thread> r13 = r8.iterator();
        L7:
            if (r13.hasNext() == false) goto L11;
            Thread r14 = r13.next();
            if (this.f4065b.contains(r14) == true) goto L7;
            r11.add(r14);
            goto L7
        L11:
            Iterator<Thread> r15 = this.f4065b.iterator();
        L13:
            if (r15.hasNext() == false) goto L17;
            Thread r16 = r15.next();
            if (r8.contains(r16) == true) goto L13;
            r12.add(r16);
            goto L13
        L17:
            Iterator r17 = r12.iterator();
        L19:
            if (r17.hasNext() == false) goto L41;
            Thread r18 = (Thread) r17.next();
            int r19 = 1;
        L22:
            if (r19 >= SliverAllThreadSupport.access$100().size()) goto L19;
            b r20 = (b) SliverAllThreadSupport.access$100().get(r19);
            monitor-enter(r20);
        L38:
            th = move-exception;
            throw th;
        L26:
            if (r20.f4059c.isEmpty() == false) goto L29;
        L33:
            monitor-exit(r20);
            boolean r21 = false;
        L35:
            if (r21 == true) goto L19;
            r19 = r19 + 1;
            goto L22
        L29:
            if (r20.f4059c.remove(r18) == false) goto L33;
            r20.f4063g = true;     // Catch: Throwable -> L38
            monitor-exit(r20);
            r21 = true;
            goto L35
        L41:
            a(r11);
            goto L42
        }
    }

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

    public static /* synthetic */ boolean access$000(String r8) {
        return dumpHeader(r8);
    }

    public static /* synthetic */ List access$100() {
        return threadGroups;
    }

    public static /* synthetic */ void access$1000(long r8) {
        nPauseSliverGroup(r8);
    }

    public static /* synthetic */ void access$1100(long r8) {
        nResumeSliverGroup(r8);
    }

    public static /* synthetic */ void access$1200(long r8) {
        nClearSliverGroup(r8);
    }

    public static /* synthetic */ List access$200() {
        return getAllThread();
    }

    public static /* synthetic */ Handler access$300() {
        return newThreadHandler();
    }

    public static /* synthetic */ Sliver.i access$400() {
        return null;
    }

    public static /* synthetic */ void access$500(long r8, Thread[] r10, long[] r11) {
        nNotifySliverGroup(r8, r10, r11);
    }

    public static /* synthetic */ long access$600(int r8, int r10, int r11, int r12) {
        return nStartSliverGroup(r8, r10, r11, r12);
    }

    public static /* synthetic */ void access$700(long r8) {
        nStopSliverGroup(r8);
    }

    public static /* synthetic */ int access$800(long r8) {
        return nGetThreadId(r8);
    }

    public static /* synthetic */ void access$900(long r8, String r10) {
        nDumpSliverGroup(r8, r10);
    }

    public static boolean clearAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        Iterator<b> r8 = threadGroups.iterator();
    L8:
        if (r8.hasNext() == false) goto L17;
        b r10 = r8.next();
        monitor-enter(r10);
        access$1200(r10.f4060d);     // Catch: Throwable -> L14
        monitor-exit(r10);
    L14:
        th = move-exception;
        throw th;
    L17:
        return true;
    }

    private static synchronized void deleteThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
        Handler r8 = threadHandler;     // Catch: Throwable -> L9
        if (r8 == null) goto L7;
        r8.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
        threadHandler.getLooper().quitSafely();     // Catch: Throwable -> L9
        threadHandler = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(SliverAllThreadSupport.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean dumpAll(String r8, boolean r10) {
        if (isStart == true) goto L6;
        return false;
    L6:
        a r11 = new a(r8);
        if (r10 == false) goto L9;
        r11.run();
        return true;
    L9:
        newThreadHandler().post(r11);
        return true;
    }

    private static boolean dumpHeader(String r8) {
        BufferedWriter r10 = null;
        BufferedWriter r11 = new BufferedWriter(new FileWriter(r8));     // Catch: Throwable -> L14
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
        int r8 = systemThreadGroup.activeCount();
        Thread[] r10 = new Thread[(r8 / 2) + r8];
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
        Field r8 = ThreadGroup.class.getDeclaredField("systemThreadGroup");     // Catch: Throwable -> L11
        r8.setAccessible(true);     // Catch: Throwable -> L11
        systemThreadGroup = (ThreadGroup) r8.get(null);     // Catch: Throwable -> L11
    L7:
        if (systemThreadGroup != null) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean isStart() {
        return isStart;
    }

    private static native void nClearSliverGroup(long r8);

    private static native void nDumpSliverGroup(long r8, String r10);

    private static native int nGetThreadId(long r8);

    private static native void nNotifySliverGroup(long r8, Thread[] r10, long[] r11);

    private static native void nPauseSliverGroup(long r8);

    private static native void nResumeSliverGroup(long r8);

    private static native long nStartSliverGroup(int r8, int r10, int r11, int r12);

    private static native void nStopSliverGroup(long r8);

    private static synchronized Handler newThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (threadHandler != null) goto L7;
        HandlerThread r8 = new HandlerThread("sliver_check_thread");     // Catch: Throwable -> L10
        r8.start();     // Catch: Throwable -> L10
        threadHandler = new Handler(r8.getLooper());     // Catch: Throwable -> L10
    L7:
        Handler r10 = threadHandler;     // Catch: Throwable -> L10
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
        Iterator<b> r8 = threadGroups.iterator();
    L10:
        if (r8.hasNext() == false) goto L19;
        b r10 = r8.next();
        monitor-enter(r10);
        access$1000(r10.f4060d);     // Catch: Throwable -> L16
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
        Iterator<b> r8 = threadGroups.iterator();
    L10:
        if (r8.hasNext() == false) goto L19;
        b r10 = r8.next();
        monitor-enter(r10);
        access$1100(r10.f4060d);     // Catch: Throwable -> L16
        monitor-exit(r10);
    L16:
        th = move-exception;
        throw th;
    L19:
        newThreadHandler().post(new c(samplingRateMs));
        isRunning = true;
        return true;
    }

    public static boolean startAll(int r8, int r10, int r11, Sliver.e r12, Sliver.i r13) {
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
        List<b> r14 = threadGroups;
        r14.clear();
        int r15 = Math.max(r8, 2);
        b r16 = new b(0, r10, r11, r12);
        Thread r17 = mainThread;
        monitor-enter(r16);
        r16.f4059c.add(r17);     // Catch: Throwable -> L20
        r16.f4063g = true;     // Catch: Throwable -> L20
        monitor-exit(r16);
        r16.a();
        r14.add(r16);
        int r18 = 1;
    L16:
        if (r18 >= r15) goto L18;
        threadGroups.add(new b(r18, r10, r11, r12));
        r18 = r18 + 1;
        goto L16
    L18:
        newThreadHandler().post(new c(r10 * 5));
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
        Iterator<b> r8 = threadGroups.iterator();
    L7:
        if (r8.hasNext() == false) goto L20;
        b r10 = r8.next();
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L12:
        if (r10.f4060d == 0) goto L13;
        access$700(r10.f4060d);     // Catch: Throwable -> L17
    L13:
        monitor-exit(r10);
        goto L7
    L20:
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }
}
