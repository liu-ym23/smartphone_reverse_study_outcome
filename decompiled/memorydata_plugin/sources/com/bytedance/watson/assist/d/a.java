package com.bytedance.watson.assist.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3384a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3385b;
    private static String c;
    private static List<C0170a> d;
    private static List<Integer> e;
    private static List<Integer> f;

    /* JADX INFO: renamed from: com.bytedance.watson.assist.d.a$a, reason: collision with other inner class name */
    public static class C0170a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<Integer> f3389b;
        private List<Long> c;

        public C0170a(String r2) {
            this.f3389b = new ArrayList();
            this.c = new ArrayList();
            this.f3388a = r2;
        }

        public String a() {
            return this.f3388a;
        }

        public void a(List<Integer> r3) {
            this.f3389b = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        public List<Integer> b() {
            return this.f3389b;
        }

        public void b(List<Long> r3) {
            this.c = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        public String toString() {
            return "CpuClusterInfo{name='" + this.f3388a + "', affectedCpuList=" + this.f3389b + ", freqList=" + this.c + '}';
        }
    }

    static {
    }

    public static int a() {
        if (f3384a != (-1)) goto L10;
        File[] r0 = new File("/sys/devices/system/cpu").listFiles(new AnonymousClass1());
        if (r0 != null) goto L7;
        int r1 = 1;
    L8:
        f3384a = r1;
        goto L10
    L7:
        r1 = r0.length;
    L10:
        return f3384a;
    }

    public static synchronized List<Integer> b() {
        monitor-enter(a.class);
        List<Integer> r1 = f;     // Catch: Throwable -> L24
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        int r2 = a();     // Catch: Throwable -> L24
        if (r2 == (-1)) goto L12;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L24
        int r4 = 0;
    L15:
        if (r4 >= r2) goto L21;
        File[] r5 = new File("/sys/devices/system/cpu/cpu" + r4 + "/cpuidle").listFiles(new AnonymousClass2());     // Catch: Throwable -> L24
        if (r5 != null) goto L19;
        int r6 = 0;
    L20:
        r3.add(Integer.valueOf(r6));     // Catch: Throwable -> L24
        r4 = r4 + 1;     // Catch: Throwable -> L24
        goto L15
    L19:
        r6 = r5.length;     // Catch: Throwable -> L24
        goto L20
    L21:
        f = r3;     // Catch: Throwable -> L24
        monitor-exit(a.class);
        return r3;
    L12:
        monitor-exit(a.class);
        return null;
    L24:
        th = move-exception;
        throw th;
    }

    public static String c() {
        String r0 = c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = e.a("ro.board.platform", "");
        c = r1;
        return r1;
    }

    public static synchronized List<C0170a> d() {
        monitor-enter(a.class);
        List<C0170a> r1 = d;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L18
        File[] r3 = new File("/sys/devices/system/cpu/cpufreq").listFiles(new AnonymousClass3());     // Catch: Throwable -> L18
        if (r3 != null) goto L11;
    L15:
        d = r2;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r2;
    L11:
        if (r3.length <= 0) goto L15;
        Arrays.sort(r3, new AnonymousClass4());     // Catch: Throwable -> L18
        int r4 = r3.length;     // Catch: Throwable -> L18
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L15;
        File r6 = r3[r5];     // Catch: Throwable -> L18
        C0170a r7 = new C0170a(r6.getName());     // Catch: Throwable -> L18
        final ArrayList r8 = new ArrayList();     // Catch: Throwable -> L18
        final ArrayList r9 = new ArrayList();     // Catch: Throwable -> L18
        c.a(r6.getAbsolutePath() + "/scaling_available_frequencies", new AnonymousClass5(r8));     // Catch: Throwable -> L18
        c.a(r6.getAbsolutePath() + "/affected_cpus", new AnonymousClass6(r9));     // Catch: Throwable -> L18
        r7.b(r8);     // Catch: Throwable -> L18
        r7.a(r9);     // Catch: Throwable -> L18
        r2.add(r7);     // Catch: Throwable -> L18
        r5 = r5 + 1;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized List<Integer> e() {
        monitor-enter(a.class);
        List<Integer> r1 = e;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(a.class);
        return r1;
    L8:
        List<C0170a> r2 = d();     // Catch: Throwable -> L15
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<C0170a> r4 = r2.iterator();     // Catch: Throwable -> L15
    L10:
        if (r4.hasNext() == false) goto L12;
        r3.add(Integer.valueOf(((C0170a) ZeusTransformUtils.preCheckCast(r4.next(), C0170a.class, "com.obric.memorydata.plugin")).b().size()));     // Catch: Throwable -> L15
        goto L10
    L12:
        e = r3;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r3;
    L15:
        th = move-exception;
        throw th;
    }
}
