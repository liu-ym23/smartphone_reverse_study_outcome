package f00;

import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h extends j implements b, e33.h<c> {
    public Object e;
    public final i00.c f;
    public final c g;

    public final String toString() {
        return "com.bytedance.android.live.broadcast.api.scope.__ScopeImpl_BroadcastInLiveInstanceScope";
    }

    @Override // f00.c
    public final i00.c d() {
        i00.c r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.scope.instance.ILiveBroadcastInstance");
    }

    @Override // f00.b
    public final i00.a e() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (i00.a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.scope.instance.IBroadcastInLiveInstance");
    }

    public final com.bytedance.android.scope.j r() {
        return this.g;
    }

    public h(c r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.g = r2;
        this.e = k.a;
        this.f = r2.d();
    }
}
