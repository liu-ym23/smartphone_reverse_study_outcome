package g5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SuppressLint({"CI_StaticFieldLeak", "StaticFieldLeak"})
    public static volatile k f7654k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f7655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f7656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f7658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f7659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f7660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future<n> f7661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n f7662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z4.c f7663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j0 f7664j;

    public class a implements Callable<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f7665a;

        public a(k r8) {
            this.f7665a = r8;
        }

        @Override // java.util.concurrent.Callable
        public final n call() {
            k r8 = this.f7665a;
            o r10 = r8.f7656b;
            int r11 = x4.r.f13543a;
            if (defpackage.c.f3197b > 0) goto L55;
            defpackage.c.f3197b = System.currentTimeMillis();
        L55:
            n r12 = n.a(r10.f7676a.getString("oaid", ""));     // Catch: Throwable -> L36
            Objects.toString(r12);     // Catch: Throwable -> L36
            if (r12 == null) goto L10;
            r8.f7662h = r12;     // Catch: Throwable -> L36
        L10:
            if (defpackage.c.f3198c > 0) goto L13;
            defpackage.c.f3198c = System.currentTimeMillis();     // Catch: Throwable -> L36
        L13:
            n r13 = r8.a(r8.f7658d, r12);     // Catch: Throwable -> L36
            if (defpackage.c.f3199d > 0) goto L17;
            defpackage.c.f3199d = System.currentTimeMillis();     // Catch: Throwable -> L36
        L17:
            if (r13 == null) goto L19;
            r10.f7676a.edit().putString("oaid", r13.b().toString()).apply();     // Catch: Throwable -> L36
        L19:
            if (r13 == null) goto L21;
            r8.f7662h = r13;     // Catch: Throwable -> L36
        L21:
            Objects.toString(r13);     // Catch: Throwable -> L36
            if (defpackage.c.f3200e > 0) goto L26;
            defpackage.c.f3200e = System.currentTimeMillis();
        L26:
            r8.f7660f = new l(r8);
            monitor-enter(r8);
            Runnable r14 = r8.f7660f;     // Catch: Throwable -> L33
            if (r14 == null) goto L31;
            r14.run();     // Catch: Throwable -> L33
        L31:
            monitor-exit(r8);
            return r13;
        L33:
            th = move-exception;
            throw th;
        L36:
            th = move-exception;
            if (defpackage.c.f3200e > 0) goto L41;
            defpackage.c.f3200e = System.currentTimeMillis();
        L41:
            r8.f7660f = new l(r8);
            monitor-enter(r8);
            Runnable r15 = r8.f7660f;     // Catch: Throwable -> L48
            if (r15 == null) goto L47;
            r15.run();     // Catch: Throwable -> L48
        L47:
            throw th;
        L48:
            th = move-exception;
            throw th;
        }
    }

    public k(Context r10) {
        boolean r8 = false;
        this.f7659e = new AtomicBoolean(false);
        Context r11 = r10.getApplicationContext();
        this.f7658d = r11;
        String r12 = Build.BRAND;
        if (r12.equals("Pico") == false) goto L6;
        m r13 = new r();
    L102:
        this.f7655a = r13;
        this.f7657c = r13.b(r10);
        this.f7656b = new o(r11);
        return;
    L6:
        if (k5.j.e() == false) goto L8;
        r13 = new q(new u());
        goto L102
    L8:
        String r14 = Build.MANUFACTURER;
        if (r14.equalsIgnoreCase("XIAOMI") == false) goto L11;
    L16:
        boolean r15 = true;
    L17:
        if (r15 == false) goto L28;
        if (u.f7690b != null) goto L21;
    L25:
        boolean r16 = false;
    L26:
        if (r16 == false) goto L28;
    L35:
        r13 = new u();
        goto L102
    L21:
        if (u.f7689a == null) goto L25;
        if (u.f7691c == null) goto L25;
        r16 = true;
    L28:
        if ("BlackShark".equalsIgnoreCase(r14) == false) goto L30;
    L33:
        boolean r17 = true;
    L34:
        if (r17 == true) goto L35;
        if (p.f7677a.b(new Object[0]).booleanValue() == false) goto L40;
        r13 = new p();
        goto L102
    L40:
        if (k5.j.g() == false) goto L45;
        if (k5.j.d() == false) goto L45;
        int r18 = x4.r.f13543a;
        r13 = new e();
    L45:
        if (k5.j.g() == false) goto L50;
        if (k5.j.d() == true) goto L50;
        int r19 = x4.r.f13543a;
        r13 = new g();
    L50:
        if ("HUAWEI".equalsIgnoreCase(r14) == false) goto L53;
        r13 = new e();
        goto L102
    L53:
        if ("OnePlus".equalsIgnoreCase(r14) == false) goto L55;
    L58:
        boolean r20 = true;
    L59:
        if (r20 == false) goto L61;
        r13 = new q(null);
        goto L102
    L61:
        if (r12 != null) goto L63;
        boolean r21 = false;
    L64:
        if (r21 == false) goto L67;
        r13 = new i();
        goto L102
    L67:
        if ("samsung".equalsIgnoreCase(r12) == false) goto L69;
    L72:
        boolean r22 = true;
    L73:
        if (r22 == false) goto L75;
        r13 = new s();
        goto L102
    L75:
        String r23 = "";
        if (r14 != null) goto L78;
        String r24 = "";
    L80:
        if (r24.toUpperCase().contains("NUBIA") == false) goto L82;
        r13 = new j();
        goto L102
    L82:
        String r25 = Build.FINGERPRINT;
        if (TextUtils.isEmpty(r25) == true) goto L85;
        r8 = r25.contains("VIBEUI_V2");
    L90:
        if (r8 == false) goto L92;
        r13 = new h();
        goto L102
    L92:
        if (r14 == null) goto L96;
        r23 = r14.trim();
    L96:
        if (r23.toUpperCase().contains("ASUS") == false) goto L98;
        r13 = new g5.a();
        goto L102
    L98:
        r13 = new d(r10);
        if (r13.b(r10) == true) goto L102;
        r13 = new c();
        goto L102
    L85:
        String r26 = k5.j.c("ro.build.version.incremental");
        if (TextUtils.isEmpty(r26) == true) goto L90;
        if (r26.contains("VIBEUI_V2") == false) goto L90;
        r8 = true;
        goto L90
    L78:
        r24 = r14.trim();
        goto L80
    L69:
        if ("samsung".equalsIgnoreCase(r14) == true) goto L72;
        r22 = false;
        goto L73
    L63:
        r21 = r12.toLowerCase(Locale.ENGLISH).contains("meizu");
        goto L64
    L55:
        if ("OnePlus".equalsIgnoreCase(r12) == true) goto L58;
        r20 = false;
        goto L59
    L30:
        if ("BlackShark".equalsIgnoreCase(r12) == true) goto L33;
        r17 = false;
        goto L34
    L11:
        if (r12.equalsIgnoreCase("XIAOMI") == true) goto L16;
        if (r12.equalsIgnoreCase("REDMI") == true) goto L16;
        r15 = false;
        goto L17
    }

    public static k c(Context r8) {
        if (f7654k != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7654k != null) goto L9;
        f7654k = new k(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f7654k;
    }

    public static void d(JSONObject r8, String r10, Object r11) {
        if (TextUtils.isEmpty(r10) == true) goto L12;
        if (r11 == null) goto L13;
        r8.put(r10, r11);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    public static void e(HashMap r8, String r10, String r11) {
        if (r11 == null) goto L5;
        r8.put(r10, r11);
        return;
    }

    public final n a(Context r13, n r14) {
        long r8 = SystemClock.elapsedRealtime();
        String r10 = null;
        m r12 = this.f7655a;
        if (r12 == null) goto L27;
        m.a r15 = r12.a(r13);
        if (r15 == null) goto L27;
        int r16 = 1;
        if (r14 == null) goto L13;
        Integer r11 = r14.f7674f;
        if (r11 != null) goto L11;
        int r17 = 0;
    L12:
        int r18 = r17 + 1;
        r10 = r14.f7670b;
        int r19 = r18;
    L15:
        if (TextUtils.isEmpty(r10) == false) goto L17;
        r10 = UUID.randomUUID().toString();
    L17:
        String r20 = r10;
        if (r19 <= 0) goto L21;
        r16 = r19;
    L21:
        long r21 = SystemClock.elapsedRealtime() - r8;
        if ((r15 instanceof e.b) == false) goto L24;
        long r22 = ((e.b) r15).f7649c;
    L26:
        return new n(r15.f7667a, r20, Boolean.valueOf(r15.f7668b), Long.valueOf(r21), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r16), Long.valueOf(r22));
    L24:
        r22 = 0;
        goto L26
    L11:
        r17 = r11.intValue();
        goto L12
    L13:
        r19 = -1;
    L27:
        return null;
    }

    public final void b() {
        if (this.f7659e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (defpackage.c.f3196a > 0) goto L8;
        defpackage.c.f3196a = System.currentTimeMillis();
    L8:
        a r8 = new a(this);
        this.f7661g = x4.t.c(x4.t.a(x4.t.f13550b)).submit(r8);
    }
}
