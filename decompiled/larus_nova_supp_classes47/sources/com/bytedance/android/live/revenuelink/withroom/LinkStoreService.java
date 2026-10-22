package com.bytedance.android.live.revenuelink.withroom;

import com.bytedance.android.live.revenuelink.connect.ConnectDataContext;
import com.bytedance.android.live.revenuelink.connect.e;
import com.bytedance.android.live.revenuelink.connect.k;
import com.bytedance.android.live.revenuelink.j;
import com.bytedance.android.live.revenuelink.rtc.AnchorRtcManager;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.f;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LinkStoreService implements a, o {
    public ConnectDataContext a;
    public AnchorRtcManager b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final g h;
    public final c i;
    public final f j;
    public final p11.c k;

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.connect.o z8() {
        return (com.bytedance.android.live.revenuelink.connect.o) this.f.getValue();
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.connect.g getAnchorConnectUtils() {
        return (com.bytedance.android.live.revenuelink.connect.a) this.c.getValue();
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.f getRevenueLinkTraceMonitor() {
        return (j) this.e.getValue();
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.rtc.f m0() {
        return (com.bytedance.android.live.revenuelink.rtc.f) this.g.getValue();
    }

    public final void onStart() {
        if (this.h.isAnchor() == false) goto L11;
        this.a = new ConnectDataContext(this, this.j, this.h);
        IRoom r1 = this.h.mo444getRoom();
        if (r1 == null) goto L10;
        this.b = new AnchorRtcManager(r1, this, this.k, this.h);
        if (((Boolean) com.bytedance.android.live.revenuelink.a.b.getValue(null, com.bytedance.android.live.revenuelink.a.a[0])).booleanValue() == false) goto L12;
        c r0 = this.i;
        Intrinsics.checkNotNullParameter(r0, "revRoomService");
        r0.getRoomContext().setRevnueLinkHasLoad(true);
        return;
    L12:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoomKt /* = com.bytedance.android.livesdkapi.depend.model.live.IRoom */");
    }

    public final void onStop() {
        ConnectDataContext r0 = this.a;
        if (r0 == null) goto L5;
        r0.onStop();
    L5:
        AnchorRtcManager r1 = this.b;
        if (r1 == null) goto L9;
        r1.t();
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final k z0() {
        return (e) this.d.getValue();
    }

    @Override // com.bytedance.android.live.revenuelink.withroom.a
    public final com.bytedance.android.live.revenuelink.connect.f Z0() {
        return this.a;
    }

    public LinkStoreService(g r2, c r3, f r4, p11.c r5) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "revRoomService");
        Intrinsics.checkNotNullParameter(r4, "messageService");
        Intrinsics.checkNotNullParameter(r5, "pkService");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.c = LazyKt.lazy(new LinkStoreService$anchorConnectUtils$2(this));
        this.d = LazyKt.lazy(new LinkStoreService$connectStateMonitor$2(this));
        this.e = LazyKt.lazy(new LinkStoreService$revenueLinkTraceMonitor$2(this));
        this.f = LazyKt.lazy(new LinkStoreService$multiChannelMonitor$2(this));
        this.g = LazyKt.lazy(new LinkStoreService$anchorLinkRtcService$2(this));
    }
}
