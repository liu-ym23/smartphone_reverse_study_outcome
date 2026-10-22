package fu0;

import cy0.f;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends j implements a, h<f> {
    public final com.bytedance.android.live.revenue.core.a e;
    public final com.bytedance.android.live.revenue.core.b f;
    public final com.bytedance.live.kmp.core.a g;
    public final f h;

    public final String toString() {
        return "com.bytedance.android.live.profit.fansclub.widget.entrance.scope.__ScopeImpl_EntranceScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    public final com.bytedance.android.scope.j r() {
        return this.h;
    }

    public c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.h = r2;
        Object r0 = k.a;
        this.e = r2.F();
        this.f = r2.A();
        this.g = r2.i();
    }
}
