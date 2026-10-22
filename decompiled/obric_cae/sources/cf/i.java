package cf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends xe.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3540b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ List f3541m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ g f3542n;

    public i(g r8, Object[] r10, int r11, ArrayList r12, boolean r13) {
        this.f3542n = r8;
        this.f3540b = r11;
        this.f3541m = r12;
        super("OkHttp %s Push Headers[%s]", r10);
    }

    @Override // xe.b
    public final void a() {
        this.f3542n.f3508t.getClass();
        this.f3542n.F.w(this.f3540b, b.f3455q);     // Catch: IOException -> L12
        g r8 = this.f3542n;     // Catch: IOException -> L12
        monitor-enter(r8);     // Catch: IOException -> L12
        this.f3542n.H.remove(Integer.valueOf(this.f3540b));     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        goto L16
    L11:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: IOException -> L12
    }
}
