package cf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends xe.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3543b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ jf.d f3544m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f3545n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ g f3546o;

    public j(g r8, Object[] r10, int r11, jf.d r12, int r13, boolean r14) {
        this.f3546o = r8;
        this.f3543b = r11;
        this.f3544m = r12;
        this.f3545n = r13;
        super("OkHttp %s Push Data[%s]", r10);
    }

    @Override // xe.b
    public final void a() {
        r.a r8 = this.f3546o.f3508t;     // Catch: IOException -> L11
        jf.d r10 = this.f3544m;     // Catch: IOException -> L11
        int r11 = this.f3545n;     // Catch: IOException -> L11
        r8.getClass();     // Catch: IOException -> L11
        r10.skip(r11);     // Catch: IOException -> L11
        this.f3546o.F.w(this.f3543b, b.f3455q);     // Catch: IOException -> L11
        g r12 = this.f3546o;     // Catch: IOException -> L11
        monitor-enter(r12);     // Catch: IOException -> L11
        this.f3546o.H.remove(Integer.valueOf(this.f3543b));     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        goto L15
    L10:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: IOException -> L11
    }
}
