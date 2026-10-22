package lp0;

import android.content.Context;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends j implements a, h<com.bytedance.android.scope.j> {
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public final com.bytedance.android.scope.j i;

    public final String toString() {
        return "com.bytedance.android.live.openplatform.impl.miniappanchor.choose.scope.__ScopeImpl_MiniAppChooseScope";
    }

    @Override // lp0.a
    public final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b getContainer() {
        Object r0 = this.h;
        if (r0 == null) goto L7;
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.IMiniAppChooseContainer");
    }

    @Override // lp0.a
    public Context getContext() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (Context) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // lp0.a
    public final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a getRoot() {
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a) this.g;
    }

    @Override // lp0.a
    public final so0.a w() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (so0.a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.base.miniappanchor.IMiniAppAnchorService");
    }

    public final com.bytedance.android.scope.j r() {
        return this.i;
    }

    public c(com.bytedance.android.scope.j r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.i = r2;
        Object r3 = k.a;
        this.e = r3;
        this.f = r3;
        this.g = r3;
        this.h = r3;
    }
}
