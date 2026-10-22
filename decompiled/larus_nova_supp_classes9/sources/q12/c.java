package q12;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import e33.h;
import e33.j;
import e33.k;
import i12.e;
import i12.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends j implements a, h<e> {
    public final Object e;
    public final DataCenter f;
    public final Object g;
    public final com.bytedance.android.livesdk.revenue.room.a h;
    public final g i;
    public final e j;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.format.__ScopeImpl_FormatGiftPanelScope";
    }

    @Override // q12.a, i12.e
    public Context getContext() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (Context) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        DataCenter r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final g i() {
        g r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r0 = this.g;
        if (r0 == null) goto L7;
        return ((Boolean) r0).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final com.bytedance.android.scope.j r() {
        return this.j;
    }

    public c(e r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.j = r2;
        Object r0 = k.a;
        this.e = r2.getContext();
        this.f = r2.getDataCenter();
        this.g = Boolean.valueOf(r2.m());
        this.h = r2.getRoomContext();
        this.i = r2.i();
    }
}
