package bn0;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends j implements b, h<u60.a> {
    public final com.bytedance.live.kmp.core.a e;
    public final u60.a f;

    public final String toString() {
        return "com.bytedance.android.live.multilink.external.api.core.scope.__ScopeImpl_MultiLinkRoomScope";
    }

    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    public final com.bytedance.android.scope.j r() {
        return this.f;
    }

    public c(u60.a r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.f = r2;
        Object r0 = k.a;
        this.e = r2.i();
    }
}
