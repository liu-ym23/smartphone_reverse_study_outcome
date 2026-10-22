package cf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends xe.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f3549b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ g.h f3550m;

    public l(g.h r8, Object[] r10, o r11) {
        this.f3550m = r8;
        this.f3549b = r11;
        super("OkHttp %s stream %d", r10);
    }

    @Override // xe.b
    public final void a() {
        o r8 = this.f3549b;
        g.h r10 = this.f3550m;
        r10.f3535m.f3500b.b(r8);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        df.f.f7097a.l(4, e, "Http2Connection.Listener failure for " + r10.f3535m.f3502n);
        r8.f(b.f3451m);     // Catch: IOException -> L9
        return;
    }
}
