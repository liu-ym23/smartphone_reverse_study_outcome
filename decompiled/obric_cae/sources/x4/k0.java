package x4;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.obric.cae.cloud.ttnet.AppConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k0 implements i5.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f13515g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile j0 f13516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d0 f13517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile d5.q f13518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile z4.c f13519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f13520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v f13521f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k0 f13522a;

        public a(k0 r8) {
            this.f13522a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k0.k(this.f13522a, false);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f13523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k0 f13524b;

        public b(k0 r8, s r10) {
            this.f13524b = r8;
            this.f13523a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f13524b.f13517b.c(this.f13523a);
            d5.q r8 = this.f13524b.f13518c;
            j0 r10 = r8.f6808f;
            i5.a r11 = (i5.a) i5.d.a(i5.a.class, String.valueOf(r10.f13463a));
            if (r11 == null) goto L5;
            r11.c();
        L5:
            m.a(r8.f6807e, r10);
            k5.h r12 = k5.i.f8941a;
            k5.i.f8941a = new k5.h();
            d5.q r13 = this.f13524b.f13518c;
            r13.f();
            z4.c r14 = r13.f6815m;
            if (r14 == null) goto L8;
            r14.a(new a5.a(r13.f6811i));
        L8:
            r13.i();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k0 f13525a;

        public c(k0 r8) {
            this.f13525a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d0 r8 = this.f13525a.f13517b;
            if (r8 == null) goto L10;
            int r10 = r.f13543a;
            long r11 = System.currentTimeMillis();
            if ((r11 - r8.f13400s) < 900000) goto L12;
            j0 r12 = r8.f13392a;
            if (k5.e.a(r12.f13465c) == false) goto L14;
            r8.f13400s = r11;
            r8.b(new x4.c(r12, r8.f13396o));
            return;
        L14:
            return;
        L12:
            return;
        L10:
            new RuntimeException("active failed");
            int r13 = r.f13543a;
        }
    }

    static {
        f13515g = new AtomicBoolean(false);
    }

    public k0(j r8) {
        this.f13520e = new AtomicBoolean(false);
        this.f13521f = r8;
    }

    public static void k(k0 r8, boolean r10) {
        if (r8.f13517b == null) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L27;
        if (r8.f13516a == null) goto L27;
        if (r8.f13520e.getAndSet(true) == true) goto L28;
        i5.c r12 = (i5.c) i5.d.a(i5.c.class, r8.f13516a.a());
        if (r12 == null) goto L15;
        r12.start();
    L15:
        r8.f13518c.j();
        d0 r13 = r8.f13517b;
        r13.d(r13.f13396o, r10);
        if (r13.f13392a.f13475m == false) goto L21;
        e0 r14 = new e0(r13);
        f0 r15 = new f0(r13, r14);
        y4.a r16 = (y4.a) r13.f13395n;
        r16.f13991n = r15;
        if (r16.f13990m == false) goto L21;
        int r17 = r.f13543a;
        r14.run();
    L21:
        q0 r18 = new q0(r8.f13516a.f13465c);
        j0 r19 = r8.f13516a;
        r18.f13542b = r19;
        if (r19 == null) goto L29;
        String r20 = String.valueOf(r19.f13463a);
        y4.a r21 = h.f13429a;
        j r22 = j.c(r20);
        r22.getClass();
        r22.f13460j.b(true, new z4.f(r18));
        return;
    L29:
        return;
    L28:
        return;
    L27:
        throw new RuntimeException("please init first");
    L5:
        r11 = false;
        goto L6
    }

    @Override // i5.b
    public final boolean a() {
        int r8 = r.f13543a;
        if (this.f13517b == null) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
    L11:
        return false;
    L8:
        if (this.f13516a == null) goto L11;
        t.e(new c(this), this.f13516a.a());
        return true;
    L5:
        r10 = false;
        goto L6
    }

    @Override // i5.b
    public final void b(HashMap r8) {
        if (this.f13518c == null) goto L21;
        Iterator r10 = r8.entrySet().iterator();
    L5:
        boolean r11 = false;
    L7:
        if (r10.hasNext() == false) goto L12;
        Map.Entry r12 = (Map.Entry) r10.next();
        String r13 = (String) r12.getKey();
        Object r14 = r12.getValue();
        if (this.f13518c.k(r14, r13) == true) goto L11;
        if (r11 == false) goto L5;
    L11:
        r11 = true;
        goto L7
    L12:
        if (r11 == true) goto L14;
        return;
    L14:
        if (this.f13519d == null) goto L23;
        this.f13519d.a(new a5.a(this.f13518c.f6811i));
        return;
    L23:
        return;
    }

    @Override // i5.b
    public final void c(Application r8, HashMap r10) {
        SharedPreferences.Editor r11 = k5.a.a(r8, this.f13516a).edit();
        boolean r12 = false;
        if (this.f13518c == null) goto L18;
        Iterator r13 = r10.entrySet().iterator();
        boolean r14 = false;
    L6:
        if (r13.hasNext() == false) goto L15;
        Map.Entry r15 = (Map.Entry) r13.next();
        String r16 = (String) r15.getKey();
        String r17 = (String) r15.getValue();
        if (this.f13518c.k(r17, r16) == true) goto L12;
        if (r14 == true) goto L12;
        r14 = false;
    L13:
        if (r11 == null) goto L6;
        r11.putString(r16, r17);
    L12:
        r14 = true;
        goto L13
    L15:
        if (r11 == null) goto L17;
        r11.apply();
    L17:
        r12 = r14;
    L18:
        if (r12 == true) goto L20;
    L24:
        if (r12 == true) goto L26;
        return;
    L26:
        if (this.f13519d == null) goto L35;
        this.f13519d.a(new a5.a(this.f13518c.f6811i));
        return;
    L35:
        return;
    L20:
        if (this.f13517b == null) goto L24;
        d0 r18 = this.f13517b;
        t0 r19 = r18.f13398q;
        if (r19 == null) goto L24;
        r18.f(r19, true);
        goto L24
    }

    @Override // i5.b
    public final i0 d() {
        if (this.f13518c != null) goto L7;
        return null;
    L7:
        return this.f13518c.d();
    }

    @Override // i5.b
    public final boolean e(JSONObject r8) {
        if (this.f13518c == null) goto L11;
        d5.q r10 = this.f13518c;
        if (r10.f6813k == false) goto L7;
        JSONObject r11 = r10.f6811i;
    L8:
        if (r11 == null) goto L13;
        x0.d(r8, r11);
        return true;
    L13:
        return false;
    L7:
        r11 = null;
        goto L8
    L11:
        return false;
    }

    @Override // i5.b
    public final void f(j0 r8, s r10) {
        System.currentTimeMillis();
        int r11 = r.f13543a;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f13517b != null) goto L14;
        this.f13516a = r8;     // Catch: Throwable -> L12
        if (TextUtils.equals(r8.f13469g, AppConstants.CHANNEL_NAME) == true) goto L19;
    L11:
        this.f13518c = new d5.q(r8.f13465c, r10, r8);     // Catch: Throwable -> L12
        this.f13518c.f6815m = this.f13519d;     // Catch: Throwable -> L12
        d5.q r12 = this.f13518c;     // Catch: Throwable -> L12
        y4.a r13 = h.f13429a;     // Catch: Throwable -> L12
        this.f13517b = new d0(r10, r8, r12);     // Catch: Throwable -> L12
        this.f13517b.f13401t = this.f13519d;     // Catch: Throwable -> L12
        this.f13518c.getClass();     // Catch: Throwable -> L12
        i5.d.b(p.class, new q(r8), String.valueOf(r8.f13463a));     // Catch: Throwable -> L12
        goto L14
    L19:
        Class<?> r14 = Class.forName("com.bytedance.bdinstall.nu.NUModeServiceImpl");     // Catch: Throwable -> L10
        i5.d.b(i5.c.class, (i5.c) r14.getConstructor(new Class[]{j0.class}).newInstance(new Object[]{r8}), String.valueOf(r8.f13463a));     // Catch: Throwable -> L10
    L10:
        int r15 = r.f13543a;     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);     // Catch: Throwable -> L12
        System.currentTimeMillis();
    }

    @Override // i5.b
    public final void g(s r8) {
        int r10 = r.f13543a;
        if (this.f13517b != null) goto L5;
    L9:
        new RuntimeException("not init yet");
        return;
    L5:
        if (this.f13516a == null) goto L9;
        if (this.f13518c == null) goto L9;
        Objects.toString(r8);
        String r11 = this.f13516a.a();
        t.e(new b(this, r8), r11);
    }

    @Override // i5.b
    public final String h() {
        if (this.f13518c != null) goto L7;
        return null;
    L7:
        return this.f13518c.c();
    }

    @Override // i5.b
    public final void i(s r8) {
        int r10 = r.f13543a;
        if (this.f13517b == null) goto L7;
        Objects.toString(r8);
        k5.o r11 = new k5.o(this.f13516a);
        j r12 = (j) this.f13521f;
        r12.getClass();
        z4.f r13 = new z4.f(r11);
        r12.f13460j.b(false, r13);
        r11.f8954a.postDelayed(new k5.p(r11), 0);
        if (this.f13516a == null) goto L9;
        String r14 = this.f13516a.a();
        t.e(new l0(this, r8), r14);
        return;
    L9:
        return;
    L7:
        new RuntimeException("not init yet");
    }

    @Override // i5.b
    public final void j(i0 r8) {
    }

    public final void l() {
        if (k5.a.a(this.f13516a.f13465c, this.f13516a).getBoolean("_install_started_v2", false) == true) goto L6;
        k5.a.a(this.f13516a.f13465c, this.f13516a).edit().putBoolean("_install_started_v2", true).apply();
        return;
    }

    @Override // i5.b
    public final void start() {
        if (this.f13517b == null) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L12;
        if (this.f13516a == null) goto L12;
        int r10 = this.f13516a.f13463a;
        int r11 = r.f13543a;
        String r12 = this.f13516a.a();
        t.e(new a(this), r12);
        l();
        return;
    L12:
        throw new RuntimeException("please init first");
    L5:
        r8 = false;
        goto L6
    }
}
