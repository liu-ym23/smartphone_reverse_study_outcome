package x4;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.BDInstallProvider;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class j implements v {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ConcurrentHashMap f13449l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AtomicInteger f13450m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"CI_StaticFieldLeak", "StaticFieldLeak"})
    public volatile j0 f13451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile defpackage.c f13452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f13453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f13454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f13455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final defpackage.c f13456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f13457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f13458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k5.b f13459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z4.c f13460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f13461k;

    public class a extends c4.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f13462c;

        public a(j r8) {
            this.f13462c = r8;
            super(1);
        }

        @Override // c4.b
        public final Object a(Object[] r8) {
            if (x0.f((Context) r8[0]) == false) goto L15;
            k0 r10 = new k0(this.f13462c);
            Context r11 = (Context) r8[0];
            if ((r11 instanceof Application) == true) goto L8;
            if (r11 == null) goto L8;
            r11 = r11.getApplicationContext();
        L8:
            Application r12 = (Application) r11;
            if (r12 != null) goto L12;
        L14:
            r10.f13519d = this.f13462c.f13460j;
            return r10;
        L12:
            if (k0.f13515g.compareAndSet(false, true) == false) goto L14;
            r12.registerActivityLifecycleCallbacks(h.f13429a);
            goto L14
        L15:
            r0 r13 = new r0(this.f13462c);
            r13.f13545b = this.f13462c.f13460j;
            return r13;
        }
    }

    public class b extends k5.l<i0> {
        @Override // k5.l
        public final i0 a(Object[] r8) {
            String r10 = ((Context) r8[0]).getSharedPreferences("ug_install_op_pref", 0).getString("install_info", null);     // Catch: Exception -> L8
            if (TextUtils.isEmpty(r10) == false) goto L6;
            String r11 = x0.f13579a;     // Catch: Exception -> L8
        L6:
            return i0.b(r10);
        L8:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static {
        f13449l = new ConcurrentHashMap();
        f13450m = new AtomicInteger(0);
    }

    public j() {
        this.f13451a = null;
        this.f13452b = new defpackage.c();
        this.f13453c = new n0();
        this.f13454d = new AtomicBoolean(false);
        this.f13455e = new AtomicBoolean(false);
        this.f13456f = new defpackage.c();
        this.f13457g = new a(this);
        this.f13461k = new b();
        f13450m.incrementAndGet();
        this.f13458h = new f(this);
        this.f13459i = new k5.b();
        this.f13460j = new z4.c();
    }

    public static j c(String r8) {
        return (j) f13449l.get(r8);
    }

    public final Context a() {
        if (this.f13451a == null) goto L9;
        if (this.f13451a.f13465c == null) goto L9;
        return this.f13451a.f13465c;
    L9:
        return BDInstallProvider.f3791n;
    }

    public final i0 b() {
        if (this.f13451a != null) goto L5;
    L9:
        int r8 = r.f13543a;
        Context r10 = a();
        if (r10 != null) goto L13;
        return null;
    L13:
        return this.f13461k.b(new Object[]{r10});
    L5:
        if (this.f13451a.f13465c == null) goto L9;
        return ((i5.b) this.f13457g.b(new Object[]{this.f13451a.f13465c})).d();
    }

    public final void d(j0 r8, s r10) {
        monitor-enter(this);
        ConcurrentHashMap r11 = f13449l;     // Catch: Throwable -> L12
        if (r11.containsKey(String.valueOf(r8.f13463a)) == true) goto L43;
        int r12 = r8.f13463a;     // Catch: Throwable -> L12
        int r13 = r.f13543a;     // Catch: Throwable -> L12
        r11.put(String.valueOf(r12), this);     // Catch: Throwable -> L12
        if (this != h.f13430b) goto L8;
        boolean r14 = true;
    L9:
        r8.J = r14;     // Catch: Throwable -> L12
        this.f13451a = r8;     // Catch: Throwable -> L12
        this.f13460j.f14209e = this.f13451a.a();     // Catch: Throwable -> L12
        defpackage.c r15 = r8.f13481s;     // Catch: Throwable -> L12
        if (r15 == null) goto L14;
        this.f13452b = r15;     // Catch: Throwable -> L12
    L14:
        c0 r16 = r8.f13479q;     // Catch: Throwable -> L12
        if (r16 == null) goto L20;
        String r17 = String.valueOf(r8.f13463a);     // Catch: Throwable -> L12
        ConcurrentHashMap<String, c0> r18 = u0.f13568c;     // Catch: Throwable -> L12
        if (r18.containsKey(r17) == true) goto L20;
        r18.put(r17, r16);     // Catch: Throwable -> L12
    L20:
        if (r8.G == false) goto L34;
        f r19 = this.f13458h;     // Catch: Throwable -> L12
        Context r20 = r8.f13465c;     // Catch: Throwable -> L12
        if (k5.g.f8937c == null) goto L24;
    L33:
        r19.f13416f = k5.g.f8937c;     // Catch: Throwable -> L12
        k5.g.f8939e.incrementAndGet();     // Catch: Throwable -> L12
        goto L34
    L24:
        monitor-enter(k5.g.class);     // Catch: Throwable -> L12
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L26:
        if (k5.g.f8937c != null) goto L28;
        k5.g.f8937c = new k5.g(r20);     // Catch: Throwable -> L30
    L28:
        monitor-exit(k5.g.class);     // Catch: Throwable -> L30
    L34:
        ((i5.b) this.f13457g.b(new Object[]{r8.f13465c})).f(r8, r10);     // Catch: Throwable -> L12
        this.f13454d.set(true);     // Catch: Throwable -> L12
        if (this.f13455e.get() == false) goto L43;
        if (this.f13454d.get() == true) goto L39;
        this.f13455e.set(true);     // Catch: Throwable -> L12
        goto L43
    L39:
        Context r21 = a();     // Catch: Throwable -> L12
        if (r21 == null) goto L43;
        ((i5.b) this.f13457g.b(new Object[]{r21})).a();     // Catch: Throwable -> L12
        goto L43
    L8:
        r14 = false;
    L43:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
