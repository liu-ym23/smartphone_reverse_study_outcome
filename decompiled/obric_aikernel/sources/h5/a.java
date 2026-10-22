package h5;

import android.content.Context;
import g5.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile a f9175g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j5.a f9177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l5.a f9178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k5.b f9179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i5.a f9180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g5.a f9181f;

    static {
    }

    private a(Context r10) {
        this(r10, g5.a.f8961i);
    }

    private a(Context r10, g5.a r11) {
        Context r12 = r10.getApplicationContext();
        this.f9176a = r12;
        if (r11 != null) goto L5;
        g5.a r13 = g5.a.f8961i;
    L6:
        this.f9181f = r13;
        this.f9177b = new j5.a(r12, this);
        this.f9178c = new l5.a(this.f9176a, this);
        this.f9179d = new k5.b(this.f9176a, this);
        this.f9180e = new i5.a(this);
        n5.b.e("new assist obj:" + this + " config : " + r11);
        return;
    L5:
        r13 = r11;
        goto L6
    }

    public static a l(Context r10) {
        if (f9175g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9175g != null) goto L9;
        f9175g = new a(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9175g;
    }

    @Override // g5.c
    public void a() {
        n5.b.a("end, obj:" + this);
        this.f9177b.a();
        this.f9178c.a();
        this.f9179d.a();
    }

    @Override // g5.c
    public float b() {
        return this.f9177b.d();
    }

    @Override // g5.c
    public c.b c() {
        return this.f9179d.g();
    }

    @Override // g5.c
    public int d() {
        return this.f9177b.h();
    }

    @Override // g5.c
    public int e() {
        return this.f9177b.c();
    }

    @Override // g5.c
    public c.a f() {
        c.a r10 = new c.a();
        r10.f8976a = j();
        r10.f8977b = n();
        r10.f8978c = e();
        r10.f8979d = k();
        r10.f8980e = d();
        r10.f8981f = b();
        r10.f8982g = m();
        return r10;
    }

    @Override // g5.c
    public boolean g(float r10) {
        return this.f9180e.a(r10);
    }

    @Override // g5.c
    public g5.a getConfig() {
        return this.f9181f;
    }

    @Override // g5.c
    public void h() {
        this.f9179d.j();
    }

    @Override // g5.c
    public boolean i() {
        return this.f9180e.b();
    }

    public String j() {
        return n5.a.d();
    }

    public int k() {
        return this.f9178c.c();
    }

    public List<List<Integer>> m() {
        return this.f9179d.f();
    }

    public boolean n() {
        return this.f9177b.f();
    }

    @Override // g5.c
    public c start() {
        n5.b.a("start, obj:" + this);
        this.f9177b.b();
        this.f9178c.b();
        this.f9179d.b();
        return this;
    }
}
