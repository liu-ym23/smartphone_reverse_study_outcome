package i12;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends e33.j implements d, e33.h<e> {
    public Object e;
    public Object f;
    public final Object g;
    public final DataCenter h;
    public final com.bytedance.android.livesdk.revenue.room.a i;
    public final Object j;
    public final g k;
    public final e l;

    public final String toString() {
        return "com.bytedance.android.livesdk.gift.platform.core.scope.__ScopeImpl_GiftPanelScope";
    }

    @Override // i12.d
    public final LocateGiftInfo C() {
        Object r0 = this.e;
        if (r0 == null) goto L7;
        return (LocateGiftInfo) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo");
    }

    @Override // i12.d, i12.e
    public Context getContext() {
        Object r0 = this.g;
        if (r0 == null) goto L7;
        return (Context) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // i12.e
    public final DataCenter getDataCenter() {
        DataCenter r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.DataCenter");
    }

    @Override // i12.e
    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.room.IRevRoomContext");
    }

    @Override // i12.e
    public final g i() {
        g r0 = this.k;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.core.scope.IJsLiveRoomInstance");
    }

    @Override // i12.e
    public final boolean m() {
        Object r0 = this.j;
        if (r0 == null) goto L7;
        return ((Boolean) r0).booleanValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // i12.d
    public final Bundle q() {
        return (Bundle) this.f;
    }

    public final com.bytedance.android.scope.j r() {
        return this.l;
    }

    public q(e r2) {
        Intrinsics.checkNotNullParameter(r2, "__parentScope");
        this.l = r2;
        Object r0 = e33.k.a;
        this.e = r0;
        this.f = r0;
        this.g = r2.getContext();
        this.h = r2.getDataCenter();
        this.i = r2.getRoomContext();
        this.j = Boolean.valueOf(r2.m());
        this.k = r2.i();
    }
}
