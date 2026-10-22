package c0;

import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.util.v;
import com.bytedance.apm6.util.log.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {

    static class a implements Comparator<v> {
        a() {
        }

        public int a(v r10, v r11) {
            return (int) (r11.f1151c - r10.f1151c);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(v r10, v r11) {
            return a(r10, r11);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f592d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private double f593e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f594f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f595g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private double f596h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private double f597i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private double f598j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f599k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f600l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private long f601m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private long f602n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private long f603o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private List<String> f604p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private long f605q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private long f606r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private List<v> f607s;

        public b() {
            this.f589a = -1;
            this.f590b = -1;
            this.f591c = -1;
            this.f592d = -1;
            this.f593e = -1.0d;
            this.f594f = -1;
            this.f595g = -1;
            this.f596h = -1.0d;
            this.f597i = -1.0d;
            this.f598j = -1.0d;
            this.f599k = -1;
            this.f600l = -1;
            this.f601m = -1;
            this.f602n = -1;
            this.f603o = -1;
            this.f604p = null;
            this.f605q = -1;
            this.f606r = -1;
        }

        static /* synthetic */ double a(b r10, double r11) {
            r10.f596h = r11;
            return r11;
        }

        static /* synthetic */ long b(b r10, long r11) {
            r10.f591c = r11;
            return r11;
        }

        static /* synthetic */ double c(b r10, double r11) {
            r10.f597i = r11;
            return r11;
        }

        static /* synthetic */ long d(b r10, long r11) {
            r10.f592d = r11;
            return r11;
        }

        static /* synthetic */ long e(b r10, long r11) {
            r10.f603o = r11;
            return r11;
        }

        static /* synthetic */ List f(b r10, List r11) {
            r10.f604p = r11;
            return r11;
        }

        static /* synthetic */ long g(b r10) {
            return r10.f605q;
        }

        static /* synthetic */ long h(b r10, long r11) {
            r10.f605q = r11;
            return r11;
        }

        static /* synthetic */ long i(b r10) {
            return r10.f606r;
        }

        static /* synthetic */ long j(b r10, long r11) {
            r10.f606r = r11;
            return r11;
        }

        static /* synthetic */ List k(b r10, List r11) {
            r10.f607s = r11;
            return r11;
        }

        static /* synthetic */ double l(b r10, double r11) {
            r10.f598j = r11;
            return r11;
        }

        static /* synthetic */ long m(b r10, long r11) {
            r10.f594f = r11;
            return r11;
        }

        static /* synthetic */ long n(b r10, long r11) {
            r10.f595g = r11;
            return r11;
        }

        static /* synthetic */ double o(b r10, double r11) {
            r10.f593e = r11;
            return r11;
        }

        static /* synthetic */ long p(b r10, long r11) {
            r10.f601m = r11;
            return r11;
        }

        static /* synthetic */ long q(b r10, long r11) {
            r10.f602n = r11;
            return r11;
        }

        static /* synthetic */ long r(b r10, long r11) {
            r10.f589a = r11;
            return r11;
        }

        static /* synthetic */ long s(b r10, long r11) {
            r10.f590b = r11;
            return r11;
        }

        public long A() {
            return this.f595g;
        }

        public double B() {
            return this.f596h;
        }

        public List<String> C() {
            return this.f604p;
        }

        public long D() {
            return this.f599k;
        }

        public long E() {
            return this.f602n;
        }

        public long F() {
            return this.f601m;
        }

        public long G() {
            return this.f605q;
        }

        public long H() {
            return this.f606r;
        }

        public double I() {
            return this.f597i;
        }

        public double J() {
            return this.f598j;
        }

        public List<v> K() {
            return this.f607s;
        }

        public long L() {
            return this.f594f;
        }

        public void M(long r10) {
            this.f600l = r10;
        }

        public long t() {
            return this.f603o;
        }

        public String toString() {
            return "LaunchTraceData{gcCount=" + this.f589a + ", gcTime=" + this.f590b + ", blockGcCount=" + this.f591c + ", blockGcTime=" + this.f592d + ", cpuTime=" + this.f593e + ", voluntarySwitches=" + this.f594f + ", inVoluntarySwitches=" + this.f595g + ", iowaitTime=" + this.f596h + ", runnableTime=" + this.f597i + ", sleepTime=" + this.f598j + ", minorFault=" + this.f601m + ", majorFault=" + this.f602n + ", allThreadCount=" + this.f603o + ", javaThreadNameList=" + this.f604p + ", lockTime=" + this.f599k + ", binderTime=" + this.f600l + '}';
        }

        public long u() {
            return this.f600l;
        }

        public long v() {
            return this.f591c;
        }

        public long w() {
            return this.f592d;
        }

        public double x() {
            return this.f593e;
        }

        public long y() {
            return this.f589a;
        }

        public long z() {
            return this.f590b;
        }
    }

    private static void a(b r10, int r11, int r12, long r13) {
        b.h(r10, com.bytedance.apm.util.b.c());
        b.j(r10, g.a(r11));
        long r14 = (r13 * com.bytedance.apm.util.b.k(100)) / 1000;
        if (b.i(r10) <= (2 * r14)) goto L9;
        if (com.bytedance.apm.d.D() == false) goto L7;
        Logger.w("LaunchPerfData", "originProcessDuration: " + b.i(r10) + " new: " + r14);
    L7:
        b.j(r10, r14);
    L9:
        if (com.bytedance.apm.d.D() == false) goto L11;
        Logger.i("LaunchPerfData", "processCpuTime: " + b.g(r10) + " processDuration: " + b.i(r10));
    L11:
        LinkedList<v> r15 = com.bytedance.apm.util.b.m(r11, true, b.i(r10));
        Collections.sort(r15, new a());
        b.k(r10, r15.subList(0, Math.min(r15.size(), r12)));
    }

    private static void b(b r10) {
        int r11 = 0;
        int r12 = new File("/proc/self/task/").listFiles().length;     // Catch: Throwable -> L5
    L6:
        if (r12 != 0) goto L8;
        return;
    L8:
        ThreadGroup r13 = Looper.getMainLooper().getThread().getThreadGroup();
        if (r13 != null) goto L12;
        return;
    L12:
        if (r13.getParent() == null) goto L14;
        r13 = r13.getParent();
        goto L12
    L14:
        int r14 = r13.activeCount();
        Thread[] r15 = new Thread[r14 + (r14 / 2)];
        int r16 = r13.enumerate(r15);
        LinkedList r17 = new LinkedList();
    L15:
        if (r11 >= r16) goto L20;
        String r18 = r15[r11].getName();
        if (TextUtils.isEmpty(r18) == true) goto L19;
        r17.add(r18);
    L19:
        r11 = r11 + 1;
        goto L15
    L20:
        b.e(r10, r12);
        b.f(r10, r17);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    public static b c(long r11) {
        b r10 = new b();
        int r12 = Process.myPid();     // Catch: Throwable -> L43
        BufferedReader r13 = null;
        BufferedReader r14 = new BufferedReader(new FileReader("/proc/" + r12 + "/task/" + r12 + "/sched"), 100);     // Catch: Throwable -> L52
    L61:
        String r15 = r14.readLine();     // Catch: Throwable -> L27
        if (r15 != null) goto L9;
    L55:
        BufferedReader r16 = new BufferedReader(new FileReader("/proc/" + r12 + "/task/" + r12 + "/stat"), 100);     // Catch: Throwable -> L51
        String[] r17 = r16.readLine().split(" ");     // Catch: Throwable -> L32
        b.p(r10, Long.parseLong(r17[9]));     // Catch: Throwable -> L32
        b.q(r10, Long.parseLong(r17[11]));     // Catch: Throwable -> L32
    L63:
        if (Build.VERSION.SDK_INT < 23) goto L67;
        b.r(r10, Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count")));     // Catch: Throwable -> L48
        b.s(r10, Long.parseLong(Debug.getRuntimeStat("art.gc.gc-time")));     // Catch: Throwable -> L48
        b.b(r10, Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-count")));     // Catch: Throwable -> L48
        b.d(r10, Long.parseLong(Debug.getRuntimeStat("art.gc.blocking-gc-time")));     // Catch: Throwable -> L48
    L67:
        b(r10);     // Catch: Throwable -> L49
        if (com.bytedance.apm.internal.a.d(128) == false) goto L40;
        a(r10, r12, com.bytedance.apm.internal.a.b(), r11);     // Catch: Throwable -> L49
    L40:
        if (r16 != null) goto L53;
    L45:
        return r10;
    L53:
        r16.close();     // Catch: Throwable -> L50
    L32:
        r14 = r16;
    L33:
        r16 = r14;
        goto L63
    L9:
        if (r15.contains("se.statistics.iowait_sum") == true) goto L10;
        if (r15.contains("se.statistics.wait_sum") == true) goto L13;
        if (r15.contains("se.statistics.sum_sleep_runtime") == true) goto L16;
        if (r15.contains("nr_voluntary_switches") == true) goto L19;
        if (r15.contains("nr_involuntary_switches") == true) goto L22;
        if (r15.contains("se.sum_exec_runtime") == false) goto L61;
        b.o(r10, Double.parseDouble(r15.substring(r15.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L61
    L22:
        b.n(r10, Long.parseLong(r15.substring(r15.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L61
    L19:
        b.m(r10, Long.parseLong(r15.substring(r15.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L61
    L16:
        b.l(r10, Double.parseDouble(r15.substring(r15.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L61
    L13:
        b.c(r10, Double.parseDouble(r15.substring(r15.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
        goto L61
    L10:
        b.a(r10, Double.parseDouble(r15.substring(r15.lastIndexOf(" ") + 1)));     // Catch: Throwable -> L27
    L27:
        r13 = r14;
    L28:
        r14 = r13;
    L43:
        th = move-exception;
        c0.a.b().e("error when fetch launch perf data: " + th.getLocalizedMessage());     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }
}
