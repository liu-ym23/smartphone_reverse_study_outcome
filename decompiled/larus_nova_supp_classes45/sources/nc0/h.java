package nc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements ey.i {
    public final com.bytedance.android.live.revenuelink.connect.l a;

    public h(com.bytedance.android.live.revenuelink.connect.l r2) {
        Intrinsics.checkNotNullParameter(r2, "real");
        this.a = r2;
    }

    @Override // ey.i
    public final void a(fy.h r2) {
        Intrinsics.checkNotNullParameter(r2, "leaveParams");
        this.a.a(r2);
    }

    @Override // ey.i
    public final void b(fy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "finishParams");
        this.a.b(r2);
    }

    @Override // ey.i
    public final void c(fy.f r2) {
        Intrinsics.checkNotNullParameter(r2, "joinChannelParams");
        this.a.c(r2);
    }
}
