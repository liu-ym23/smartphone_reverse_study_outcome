package cf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends xe.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3537b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ List f3538m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ g f3539n;

    public h(g r8, Object[] r10, int r11, ArrayList r12) {
        this.f3539n = r8;
        this.f3537b = r11;
        this.f3538m = r12;
        super("OkHttp %s Push Request[%s]", r10);
    }

    @Override // xe.b
    public final void a() {
        this.f3539n.f3508t.getClass();
        this.f3539n.F.w(this.f3537b, b.f3455q);     // Catch: IOException -> L12
        g r8 = this.f3539n;     // Catch: IOException -> L12
        monitor-enter(r8);     // Catch: IOException -> L12
        this.f3539n.H.remove(Integer.valueOf(this.f3537b));     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        goto L16
    L11:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: IOException -> L12
    }
}
