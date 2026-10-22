package cy0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends e33.j implements a, e33.h<com.bytedance.android.scope.j> {
    public Object e;
    public final com.bytedance.android.scope.j f;

    public final String toString() {
        return "com.bytedance.android.live.revenue.core.scope.__ScopeImpl_LivePlayScope";
    }

    @Override // cy0.a
    public final b y() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (b) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.LivePlayScopeInstance");
    }

    public final com.bytedance.android.scope.j r() {
        return this.f;
    }

    public h(com.bytedance.android.scope.j r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.f = r2;
        this.e = e33.k.a;
    }
}
