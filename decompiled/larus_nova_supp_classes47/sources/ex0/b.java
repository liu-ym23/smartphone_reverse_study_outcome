package ex0;

import com.bytedance.android.live.recharge.core.g;
import com.bytedance.android.live.recharge.panel.context.c;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends j implements a, h<com.bytedance.android.live.recharge.core.b> {
    public Object e;
    public final com.bytedance.android.live.recharge.core.b f;

    public final String toString() {
        return "com.bytedance.android.live.recharge.platform.core.scope.__ScopeImpl_RechargePanelScope";
    }

    @Override // ex0.a
    public final c c() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (c) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.context.ICommonPanelContext");
    }

    public final com.bytedance.android.scope.j r() {
        return this.f;
    }

    public b(g r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.f = r2;
        this.e = k.a;
    }
}
