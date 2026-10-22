package qa;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f10903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f10904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f10905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f10906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f10907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile b f10908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile long f10909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile String f10910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile String f10911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile long f10912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile long f10913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f10914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f10915m;

    public class a extends m1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f10916b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Context f10917m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ long f10918n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ JSONObject f10919o;

        public a(boolean r8, Context r10, long r11, JSONObject r12) {
            this.f10916b = r8;
            this.f10917m = r10;
            this.f10918n = r11;
            this.f10919o = r12;
        }

        @Override // qa.m1
        public final void a() {
            JSONObject r8 = this.f10919o;
            long r10 = this.f10918n;
            Context r11 = this.f10917m;
            boolean r12 = this.f10916b;
            if (r12 == false) goto L8;
            Iterator<File> r13 = p4.c(p4.h(r11)).iterator();
        L6:
            if (r13.hasNext() == false) goto L8;
            p4.a(r11, r13.next().getName());
        L8:
            p4.f(r11);
            byte[] r14 = r8.toString().getBytes();     // Catch: Throwable -> L28
            byte[] r15 = z.j(r11);     // Catch: Throwable -> L19
            byte[] r16 = z.f11246b;     // Catch: Throwable -> L19
            if (r16 != null) goto L14;
        L16:
            r16 = Arrays.copyOfRange(z.j(r11), 0, z.j(r11).length / 2);     // Catch: Throwable -> L19
            z.f11246b = r16;     // Catch: Throwable -> L19
        L17:
            byte[] r17 = l4.f(r15, r14, r16);     // Catch: Throwable -> L19
        L20:
            String r18 = p4.b(r10);     // Catch: Throwable -> L28
            File r19 = new File(p4.h(r11) + "/" + r18);     // Catch: Throwable -> L28
            if (r19.getParentFile().exists() == true) goto L23;
            r19.getParentFile().mkdirs();     // Catch: Throwable -> L28
        L23:
            FileOutputStream r20 = new FileOutputStream(r19);     // Catch: Throwable -> L28
            r20.write(r17);     // Catch: Throwable -> L26
        L64:
            r20.close();     // Catch: Throwable -> L34
        L36:
            boolean r21 = p4.e(r11, r8);
            if (r21 != true) goto L50;
            String r22 = p4.b(r10);
            if (r22 == null) goto L50;
            if (r22.length() == 0) goto L50;
            File r23 = new File(p4.h(r11) + "/" + r22);     // Catch: Throwable -> L48
            if (r23.exists() == false) goto L50;
            r23.delete();     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            th.printStackTrace();
        L50:
            if (r12 == false) goto L52;
            p4.d(r11);
        L52:
            if (r21 == true) goto L77;
            p4.a(r11, p4.b(r10));
            return;
        L77:
            return;
        L34:
            th = move-exception;
            th.printStackTrace();
        L26:
            th = th;
        L66:
            th.printStackTrace();     // Catch: Throwable -> L55
            if (r20 == null) goto L36;
        L55:
            th = move-exception;
            if (r20 != null) goto L72;
        L61:
            throw th;
        L72:
            r20.close();     // Catch: Throwable -> L59
        L59:
            th = move-exception;
            th.printStackTrace();
            goto L61
        L14:
            if (r16.length <= 0) goto L16;
        L19:
            r17 = new byte[0];     // Catch: Throwable -> L28
        L28:
            th = th;
            r20 = null;
            goto L66
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f10920b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final b f10921m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final b f10922n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ b[] f10923o = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10924a;

        static {
            b r8 = new b("Unknow", 0, -1);
            f10920b = r8;
            b r10 = new b("NotAgree", 1, 0);
            f10921m = r10;
            b r11 = new b("DidAgree", 2, 1);
            f10922n = r11;
            f10923o = new b[]{r8, r10, r11};
        }

        public b(String r8, int r10, int r11) {
            super(r8, r10);
            this.f10924a = r11;
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f10923o.clone();
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f10925b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final c f10926m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final c f10927n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ c[] f10928o = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10929a;

        static {
            c r8 = new c("Unknow", 0, -1);
            f10925b = r8;
            c r10 = new c("NotContain", 1, 0);
            f10926m = r10;
            c r11 = new c("DidContain", 2, 1);
            f10927n = r11;
            f10928o = new c[]{r8, r10, r11};
        }

        public c(String r8, int r10, int r11) {
            super(r8, r10);
            this.f10929a = r11;
        }

        public static c valueOf(String r8) {
            return (c) Enum.valueOf(c.class, r8);
        }

        public static c[] values() {
            return (c[]) f10928o.clone();
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f10930b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final d f10931m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final d f10932n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final d f10933o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final d f10934p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final d f10935q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final d f10936r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final d f10937s = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final d f10938t = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final /* synthetic */ d[] f10939u = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10940a;

        static {
            d r8 = new d("SuccessCode", 0, 0);
            f10930b = r8;
            d r10 = new d("ShowUnknowCode", 1, 555570);
            f10931m = r10;
            d r11 = new d("ShowNoShowCode", 2, 555571);
            f10932n = r11;
            d r12 = new d("InfoUnknowCode", 3, 555572);
            f10933o = r12;
            d r13 = new d("InfoNotContainCode", 4, 555573);
            f10934p = r13;
            d r14 = new d("AgreeUnknowCode", 5, 555574);
            f10935q = r14;
            d r15 = new d("AgreeNotAgreeCode", 6, 555575);
            f10936r = r15;
            d r16 = new d("InvaildUserKeyCode", 7, 10001);
            f10937s = r16;
            d r17 = new d("IllegalArgument", 8, 20001);
            f10938t = r17;
            f10939u = new d[]{r8, r10, r11, r12, r13, r14, r15, r16, r17};
        }

        public d(String r8, int r10, int r11) {
            super(r8, r10);
            this.f10940a = r11;
        }

        public static d valueOf(String r8) {
            return (d) Enum.valueOf(d.class, r8);
        }

        public static d[] values() {
            return (d[]) f10939u.clone();
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f10941b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final e f10942m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final e f10943n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ e[] f10944o = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10945a;

        static {
            e r8 = new e("Unknow", 0, -1);
            f10941b = r8;
            e r10 = new e("NotShow", 1, 0);
            f10942m = r10;
            e r11 = new e("DidShow", 2, 1);
            f10943n = r11;
            f10944o = new e[]{r8, r10, r11};
        }

        public e(String r8, int r10, int r11) {
            super(r8, r10);
            this.f10945a = r11;
        }

        public static e valueOf(String r8) {
            return (e) Enum.valueOf(e.class, r8);
        }

        public static e[] values() {
            return (e[]) f10944o.clone();
        }
    }

    static {
        f10903a = c.f10925b;
        f10904b = e.f10941b;
        f10905c = "";
        f10906d = "";
        f10907e = -1;
        f10908f = b.f10920b;
        f10909g = -1;
        f10910h = "";
        f10911i = "";
        f10912j = 0;
        f10913k = 0;
        f10914l = false;
        f10915m = true;
    }

    public static void a(Context r8, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length() == 0) goto L21;
        File r11 = new File(h(r8) + "/" + r10);     // Catch: Throwable -> L15
        if (r11.exists() == true) goto L10;
        return;
    L10:
        File r12 = new File((r8.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload") + "/" + r10);     // Catch: Throwable -> L15
        if (r12.getParentFile().exists() == true) goto L13;
        r12.getParentFile().mkdirs();     // Catch: Throwable -> L15
    L13:
        r11.renameTo(r12);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static String b(long r8) {
        return String.format("%d-%s", new Object[]{Long.valueOf(r8), "privacy.data"});
    }

    public static ArrayList<File> c(String r8) {
        ArrayList<File> r10 = new ArrayList();
        if (r8 != null) goto L5;
    L17:
        return r10;
    L5:
        if (r8.length() == 0) goto L17;
        File r11 = new File(r8);
        if (r11.exists() == true) goto L10;
        return r10;
    L10:
        File[] r12 = r11.listFiles();
        int r13 = 0;
    L12:
        if (r13 >= r12.length) goto L17;
        File r14 = r12[r13];
        if (r14.isFile() == false) goto L16;
        r10.add(r14);
    L16:
        r13 = r13 + 1;
        goto L12
    }

    public static void d(Context r10) {
        Iterator<File> r8 = c(r10.getFilesDir().getAbsolutePath() + "/AMap/Privacy/Reload").iterator();     // Catch: Throwable -> L36
    L3:
        if (r8.hasNext() == false) goto L35;
        File r11 = r8.next();     // Catch: Throwable -> L36
        String r12 = r11.getName();     // Catch: Throwable -> L26
        if (r12.endsWith("-privacy.data") == false) goto L31;
        String[] r13 = r12.split("-");     // Catch: Throwable -> L26
        if (r13 != null) goto L15;
        if (r13.length != 2) goto L31;
    L15:
        if (Long.parseLong(r13[0]) <= 0) goto L31;
        FileInputStream r14 = new FileInputStream(r11);     // Catch: Throwable -> L26
        byte[] r15 = new byte[r14.available()];     // Catch: Throwable -> L26
        r14.read(r15);     // Catch: Throwable -> L26
        byte[] r16 = z.j(r10);     // Catch: Throwable -> L26 Exception -> L28
        byte[] r17 = z.f11246b;     // Catch: Throwable -> L26 Exception -> L28
    L19:
        if (r17 != null) goto L21;
    L23:
        r17 = Arrays.copyOfRange(z.j(r10), 0, z.j(r10).length / 2);     // Catch: Throwable -> L26 Exception -> L28
        z.f11246b = r17;     // Catch: Throwable -> L26 Exception -> L28
    L24:
        byte[] r18 = l4.c(r16, r15, r17);     // Catch: Throwable -> L26 Exception -> L28
    L30:
        if (e(r10, new JSONObject(new String(r18))) == false) goto L3;
    L21:
        if (r17.length <= 0) goto L23;
    L28:
        r18 = new byte[0];     // Catch: Throwable -> L26
    L31:
        r11.delete();     // Catch: Throwable -> L26
        goto L3
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L36
        goto L3
    L35:
        return;
    L36:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean e(Context r8, JSONObject r10) {
        t r11 = new t();     // Catch: Throwable -> L9
        r11.f11107l = r8;     // Catch: Throwable -> L9
        r11.f11106k = r10;     // Catch: Throwable -> L9
        new h0();     // Catch: Throwable -> L9
        JSONObject r12 = new JSONObject(t4.c(h0.a(r11).f10842a));     // Catch: Throwable -> L9
        if (r12.has("status") == false) goto L14;
        if (r12.getInt("status") == 1) goto L16;
        return false;
    L16:
        return true;
    L14:
        return false;
    L9:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static synchronized void f(Context r8) {
        monitor-enter(p4.class);
        if (r8 != null) goto L20;
        monitor-exit(p4.class);
        return;
    L20:
    L17:
        th = move-exception;
        throw th;
    L8:
        if (f10914l == true) goto L22;
        g(r8);     // Catch: Throwable -> L17
        f10914l = true;     // Catch: Throwable -> L17
    L22:
        z.d(r8, "AMap.privacy.data", "AMap.privacy.data", String.format("%d&%d&%d&%s&%s&%d&%d&%s&%s&%d&%d", new Object[]{Integer.valueOf(f10903a.f10929a), Integer.valueOf(f10904b.f10945a), Long.valueOf(f10907e), f10905c, f10906d, Integer.valueOf(f10908f.f10924a), Long.valueOf(f10909g), f10910h, f10911i, Long.valueOf(f10912j), Long.valueOf(f10913k)}));     // Catch: Throwable -> L13
        monitor-exit(p4.class);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L17
    }

    public static void g(Context r8) {
        if (r8 != null) goto L40;
        return;
    L40:
        String r10 = z.c(r8, "AMap.privacy.data", "AMap.privacy.data");     // Catch: Throwable -> L7
    L9:
        if (r10 != null) goto L11;
        return;
    L11:
        String[] r11 = r10.split("&");
        if (r11.length == 11) goto L38;
        return;
    L38:
        int r12 = Integer.parseInt(r11[0]);     // Catch: Throwable -> L35
        if (r12 != 0) goto L18;
        c r13 = c.f10926m;     // Catch: Throwable -> L35
    L21:
        f10903a = r13;     // Catch: Throwable -> L35
        int r14 = Integer.parseInt(r11[1]);     // Catch: Throwable -> L35
        if (r14 != 0) goto L24;
        e r15 = e.f10942m;     // Catch: Throwable -> L35
    L27:
        f10904b = r15;     // Catch: Throwable -> L35
        f10907e = Long.parseLong(r11[2]);     // Catch: Throwable -> L35
        f10906d = r11[3];     // Catch: Throwable -> L35
        f10906d = r11[4];     // Catch: Throwable -> L35
        int r16 = Integer.parseInt(r11[5]);     // Catch: Throwable -> L35
        if (r16 != 0) goto L30;
        b r17 = b.f10921m;     // Catch: Throwable -> L35
    L33:
        f10908f = r17;     // Catch: Throwable -> L35
        f10909g = Long.parseLong(r11[6]);     // Catch: Throwable -> L35
        f10910h = r11[7];     // Catch: Throwable -> L35
        f10911i = r11[8];     // Catch: Throwable -> L35
        f10912j = Long.parseLong(r11[9]);     // Catch: Throwable -> L35
        f10913k = Long.parseLong(r11[10]);     // Catch: Throwable -> L35
        return;
    L30:
        if (r16 != 1) goto L32;
        r17 = b.f10922n;     // Catch: Throwable -> L35
        goto L33
    L32:
        r17 = b.f10920b;     // Catch: Throwable -> L35
        goto L33
    L24:
        if (r14 != 1) goto L26;
        r15 = e.f10943n;     // Catch: Throwable -> L35
        goto L27
    L26:
        r15 = e.f10941b;     // Catch: Throwable -> L35
        goto L27
    L18:
        if (r12 != 1) goto L20;
        r13 = c.f10927n;     // Catch: Throwable -> L35
        goto L21
    L20:
        r13 = c.f10925b;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        r10 = null;
        goto L9
    }

    public static String h(Context r8) {
        return defpackage.a.e(r8.getFilesDir().getAbsolutePath(), "/AMap/Privacy/Upload");
    }
}
