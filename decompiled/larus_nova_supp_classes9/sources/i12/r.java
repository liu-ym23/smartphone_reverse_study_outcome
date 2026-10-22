package i12;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r extends e33.j implements e, e33.h<cy0.e> {
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;
    public final cy0.e j;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.core.scope.__ScopeImpl_GiftScope";
    }

    @Override // i12.e
    public Context getContext() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (Context) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        Object r0 = this.f;
        if (r0 == null) goto L7;
        return (DataCenter) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        Object r0 = this.g;
        if (r0 == null) goto L7;
        return (com.bytedance.android.livesdk.revenue.room.a) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final g i() {
        Object r0 = this.i;
        if (r0 == null) goto L7;
        return (g) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r0 = this.h;
        if (r0 == null) goto L7;
        return ((Boolean) r0).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final com.bytedance.android.scope.j r() {
        return this.j;
    }

    public r(cy0.e r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.j = r2;
        Object r3 = e33.k.a;
        this.e = r3;
        this.f = r3;
        this.g = r3;
        this.h = r3;
        this.i = r3;
    }
}
