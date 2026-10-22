package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m {
    public static final IGameDataService a() {
        return jc1.k.f(IGameDataService.class);
    }

    public static final t b() {
        return IRoomContextService.a.c(jc1.k.n(IRoomContextService.class), null, 3);
    }

    public static final u d() {
        return jc1.k.n(IRoomContextService.class).getRoomMultiLinkService(null, 0);
    }

    public static final com.bytedance.android.livesdk.chatroom.o i() {
        return IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3);
    }

    public static final boolean c() {
        com.bytedance.live.datacontext.m r0 = i().getRoom();
        if (r0 == null) goto L8;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L8;
        String r2 = r1.getAnchorAbValue("audio_radio_v2");
        if (r2 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r2, "1") == false) goto L18;
        com.bytedance.live.datacontext.m r3 = i().getRoom();
        if (r3 == null) goto L18;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L18;
        if (r4.isLiveTypeAudio() != true) goto L18;
        return true;
    L18:
        return false;
    L8:
        r2 = "0";
        goto L10
    }

    public static final u e(MiddlewareRoomWidget r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiLinkContext");
        return jc1.k.n(IRoomContextService.class).getRoomMultiLinkService(r1.getRoomContext());
    }

    public static final u g(DataContext r1) {
        return jc1.k.n(IRoomContextService.class).getRoomMultiLinkService(r1);
    }

    public static final com.bytedance.android.livesdk.chatroom.o j(MiddlewareRoomWidget r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$roomContext");
        return jc1.k.n(IRoomContextService.class).getRoomDataContext(r1.getRoomContext());
    }

    public static final com.bytedance.android.livesdk.chatroom.o m(DataContext r1) {
        return jc1.k.n(IRoomContextService.class).getRoomDataContext(r1);
    }

    public static com.bytedance.android.livesdk.chatroom.k o(DataCenter r4) {
        long r0 = 0;
        Long r2 = 0L;
        IRoomContextService r3 = jc1.k.n(IRoomContextService.class);
        if (r2 == null) goto L6;
        r0 = r2.longValue();
    L6:
        return r3.getBottomToolbarService(r4, r0);
    }

    public static final u f(DataCenter r3, Long r4) {
        IRoomContextService r0 = jc1.k.n(IRoomContextService.class);
        if (r4 == null) goto L5;
        long r1 = r4.longValue();
    L7:
        return r0.getRoomMultiLinkService(r3, r1);
    L5:
        r1 = 0;
        goto L7
    }

    public static final com.bytedance.android.livesdk.chatroom.o k(MiddlewareRoomWidget r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$roomContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        return IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), r4, 0, 2);
    }

    public static final com.bytedance.android.livesdk.chatroom.o l(DataCenter r3, Long r4) {
        IRoomContextService r0 = jc1.k.n(IRoomContextService.class);
        if (r4 == null) goto L5;
        long r1 = r4.longValue();
    L7:
        return r0.getRoomDataContext(r3, r1);
    L5:
        r1 = 0;
        goto L7
    }

    public static /* synthetic */ u h(DataCenter r1, Long r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 0L;
    L9:
        return f(r1, r2);
    }

    public static /* synthetic */ com.bytedance.android.livesdk.chatroom.o n(DataCenter r1, Long r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 0L;
    L9:
        return l(r1, r2);
    }
}
