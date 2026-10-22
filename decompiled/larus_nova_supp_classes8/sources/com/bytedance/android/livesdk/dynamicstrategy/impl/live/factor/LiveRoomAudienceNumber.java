package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveRoomAudienceNumber extends DynamicFactor<Long> implements vlc.l {
    public Disposable b;
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> c;
    public vlc.d d;
    public long e;
    public final DataCenter f;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_room_acu";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Long b() {
        return Long.valueOf(com.bytedance.android.live.core.utils.a0.n(this.f).getUserCount());
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, this.f, 0, 2);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.j r2 = r1.getMessageManager();
        if (r2 == null) goto L9;
        r2.c(new LiveRoomAudienceNumber$onBind$1(this));
    L9:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r3 = this.c;
        if (r3 == null) goto L13;
        r3.c(new LiveRoomAudienceNumber$onBind$2(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        vlc.d r0 = this.d;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.d = null;
        Disposable r1 = this.b;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public LiveRoomAudienceNumber(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.f = r3;
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(r3, 1);
        if (r0 == null) goto L5;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r1 = r0.getPublicScreenContext();
    L6:
        this.c = r1;
        this.e = Long.valueOf(com.bytedance.android.live.core.utils.a0.n(r3).getUserCount()).longValue();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof mk) == false) goto L6;
        this.e = ((mk) r3).getDisplayValue();
        return;
    }
}
