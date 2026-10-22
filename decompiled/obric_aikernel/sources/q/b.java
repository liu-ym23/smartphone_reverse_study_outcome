package q;

import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f12393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f12394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f12396d;

    b(String r10) {
        this.f12395c = r10;
        this.f12396d = com.bytedance.apm.d.I();
        this.f12393a = ActivityLifeObserver.getInstance().isForeground();
        this.f12394b = s.a.e(com.bytedance.apm.d.g());
    }

    @Override // q.l
    public void a(boolean r10) {
        c(this.f12393a, r10);
    }

    @Override // q.l
    public void b(boolean r10) {
        c(this.f12393a, r10);
        this.f12393a = false;
    }

    protected abstract void c(boolean r10, boolean r11);

    @Override // q.l
    public void d(boolean r10, boolean r11) {
        c(this.f12393a, r11);
        this.f12394b = r10;
    }

    @Override // q.l
    public void f(boolean r10) {
        c(this.f12393a, r10);
        this.f12393a = true;
    }

    protected boolean g() {
        return this.f12396d;
    }

    void h(boolean r11, long r12, String r14) {
        if (r12 < 0) goto L5;
        p.a.h().l(new b0.a(r11, System.currentTimeMillis(), this.f12395c, this.f12394b, r12, r14));
        return;
    L5:
        if (com.bytedance.apm.d.D() == false) goto L7;
        e0.e.d(e0.b.f8548b, new String[]{"AbsBatteryValueStats value error: " + r12 + " type:" + this.f12395c});
    L7:
        e0.a.d("APM-Battery", "AbsBatteryValueStats value error: " + r12 + " type:" + this.f12395c);
    }
}
