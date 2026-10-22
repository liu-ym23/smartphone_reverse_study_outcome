package n5;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11243a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f11244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<g> f11245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<Integer> f11246d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static List<Integer> f11247e;

    /* JADX INFO: renamed from: n5.a$a, reason: collision with other inner class name */
    static class C0246a implements FilenameFilter {
        C0246a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return Pattern.matches("cpu[0-9]", r11);
        }
    }

    static class b implements FilenameFilter {
        b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return Pattern.matches("state[0-9]", r11);
        }
    }

    static class c implements FilenameFilter {
        c() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return Pattern.matches("policy[0-9]", r11);
        }
    }

    static class d implements Comparator<File> {
        d() {
        }

        public int a(File r10, File r11) {
            return r10.getName().compareTo(r11.getName());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File r10, File r11) {
            return a(r10, r11);
        }
    }

    static class e implements n5.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f11248a;

        e(List r10) {
            this.f11248a = r10;
        }

        @Override // n5.c.a
        public boolean a(String r10) {
            if (r10 != null) goto L5;
        L10:
            return true;
        L5:
            if (r10.isEmpty() == true) goto L10;
            String[] r11 = r10.split(" ");
            int r12 = r11.length;
            int r13 = 0;
        L8:
            if (r13 >= r12) goto L10;
            String r14 = r11[r13];
            this.f11248a.add(Long.valueOf(Long.parseLong(r14)));
            r13 = r13 + 1;
            goto L8
        }
    }

    static class f implements n5.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f11249a;

        f(List r10) {
            this.f11249a = r10;
        }

        @Override // n5.c.a
        public boolean a(String r10) {
            if (r10 != null) goto L5;
        L10:
            return true;
        L5:
            if (r10.isEmpty() == true) goto L10;
            String[] r11 = r10.split(" ");
            int r12 = r11.length;
            int r13 = 0;
        L8:
            if (r13 >= r12) goto L10;
            String r14 = r11[r13];
            this.f11249a.add(Integer.valueOf(Integer.parseInt(r14)));
            r13 = r13 + 1;
            goto L8
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f11250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<Integer> f11251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<Long> f11252c;

        public g(String r10) {
            this.f11251b = new ArrayList();
            this.f11252c = new ArrayList();
            this.f11250a = r10;
        }

        public List<Integer> a() {
            return this.f11251b;
        }

        public String b() {
            return this.f11250a;
        }

        public void c(List<Integer> r10) {
            this.f11251b = r10;
        }

        public void d(List<Long> r10) {
            this.f11252c = r10;
        }

        public String toString() {
            return "CpuClusterInfo{name='" + this.f11250a + "', affectedCpuList=" + this.f11251b + ", freqList=" + this.f11252c + '}';
        }
    }

    static {
    }

    public static synchronized List<Integer> a() {
        monitor-enter(a.class);
        List<Integer> r10 = f11246d;     // Catch: Throwable -> L15
        if (r10 == null) goto L8;
        monitor-exit(a.class);
        return r10;
    L8:
        List<g> r11 = b();     // Catch: Throwable -> L15
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<g> r13 = r11.iterator();     // Catch: Throwable -> L15
    L10:
        if (r13.hasNext() == false) goto L12;
        r12.add(Integer.valueOf(r13.next().a().size()));     // Catch: Throwable -> L15
        goto L10
    L12:
        f11246d = r12;     // Catch: Throwable -> L15
        monitor-exit(a.class);
        return r12;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized List<g> b() {
        monitor-enter(a.class);
        List<g> r10 = f11245c;     // Catch: Throwable -> L18
        if (r10 == null) goto L8;
        monitor-exit(a.class);
        return r10;
    L8:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L18
        File[] r12 = new File("/sys/devices/system/cpu/cpufreq").listFiles(new c());     // Catch: Throwable -> L18
        if (r12 != null) goto L11;
    L15:
        f11245c = r11;     // Catch: Throwable -> L18
        monitor-exit(a.class);
        return r11;
    L11:
        if (r12.length <= 0) goto L15;
        Arrays.sort(r12, new d());     // Catch: Throwable -> L18
        int r13 = r12.length;     // Catch: Throwable -> L18
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L15;
        File r15 = r12[r14];     // Catch: Throwable -> L18
        g r16 = new g(r15.getName());     // Catch: Throwable -> L18
        ArrayList r17 = new ArrayList();     // Catch: Throwable -> L18
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L18
        n5.c.d(r15.getAbsolutePath() + "/scaling_available_frequencies", new e(r17));     // Catch: Throwable -> L18
        n5.c.d(r15.getAbsolutePath() + "/affected_cpus", new f(r18));     // Catch: Throwable -> L18
        r16.d(r17);     // Catch: Throwable -> L18
        r16.c(r18);     // Catch: Throwable -> L18
        r11.add(r16);     // Catch: Throwable -> L18
        r14 = r14 + 1;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static int c() {
        if (f11243a != (-1)) goto L10;
        File[] r10 = new File("/sys/devices/system/cpu").listFiles(new C0246a());
        if (r10 != null) goto L7;
        int r11 = 1;
    L8:
        f11243a = r11;
        goto L10
    L7:
        r11 = r10.length;
    L10:
        return f11243a;
    }

    public static String d() {
        String r10 = f11244b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        String r11 = n5.e.a("ro.board.platform", "");
        f11244b = r11;
        return r11;
    }

    public static synchronized List<Integer> e() {
        monitor-enter(a.class);
        List<Integer> r10 = f11247e;     // Catch: Throwable -> L24
        if (r10 == null) goto L8;
        monitor-exit(a.class);
        return r10;
    L8:
        int r11 = c();     // Catch: Throwable -> L24
        if (r11 == (-1)) goto L12;
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L24
        int r13 = 0;
    L15:
        if (r13 >= r11) goto L21;
        File[] r14 = new File("/sys/devices/system/cpu/cpu" + r13 + "/cpuidle").listFiles(new b());     // Catch: Throwable -> L24
        if (r14 != null) goto L19;
        int r15 = 0;
    L20:
        r12.add(Integer.valueOf(r15));     // Catch: Throwable -> L24
        r13 = r13 + 1;     // Catch: Throwable -> L24
        goto L15
    L19:
        r15 = r14.length;     // Catch: Throwable -> L24
        goto L20
    L21:
        f11247e = r12;     // Catch: Throwable -> L24
        monitor-exit(a.class);
        return r12;
    L12:
        monitor-exit(a.class);
        return null;
    L24:
        th = move-exception;
        throw th;
    }
}
