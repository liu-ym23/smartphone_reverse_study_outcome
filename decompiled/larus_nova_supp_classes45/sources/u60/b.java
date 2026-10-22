package u60;

import cy0.e;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends j implements a, h<e> {
    public Object e;
    public final e f;

    public final String toString() {
        return "com.bytedance.android.live.core.scope.__ScopeImpl_LiveRoomScope";
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (com.bytedance.live.kmp.core.a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    public final com.bytedance.android.scope.j r() {
        return this.f;
    }

    public b(cy0.j r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.f = r2;
        this.e = k.a;
    }
}
