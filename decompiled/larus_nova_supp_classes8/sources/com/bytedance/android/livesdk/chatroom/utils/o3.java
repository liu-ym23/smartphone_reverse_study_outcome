package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o3 {
    public static final com.bytedance.android.livesdk.chatroom.t a() {
        return IRoomContextService.a.c(jc1.k.n(IRoomContextService.class), null, 3);
    }

    public static final MiddlewareRoomContext b() {
        return MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
    }

    public static final com.bytedance.android.livesdk.chatroom.u d() {
        return jc1.k.n(IRoomContextService.class).getRoomMultiLinkService(null, 0);
    }

    public static final com.bytedance.android.livesdk.chatroom.o f() {
        return IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), null, 0, 3);
    }

    public static final MiddlewareRoomContext c(DataCenter r4) {
        return MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r4, 0, 2);
    }

    public static final com.bytedance.android.livesdk.chatroom.u e(RealTimeChorusMainViewWidget r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiLinkContext");
        return jc1.k.n(IRoomContextService.class).getRoomMultiLinkService(r1.getRoomContext());
    }

    public static final com.bytedance.android.livesdk.chatroom.o g(MiddlewareRoomWidget r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$roomContext");
        return jc1.k.n(IRoomContextService.class).getRoomDataContext(r1.getRoomContext());
    }

    public static /* synthetic */ com.bytedance.android.livesdk.chatroom.o j(DataCenter r2) {
        return i(r2, 0L);
    }

    public static final com.bytedance.android.livesdk.chatroom.o h(MiddlewareRoomWidget r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$roomContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        return IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), r4, 0, 2);
    }

    public static final com.bytedance.android.livesdk.chatroom.o i(DataCenter r3, Long r4) {
        IRoomContextService r0 = jc1.k.n(IRoomContextService.class);
        if (r4 == null) goto L5;
        long r1 = r4.longValue();
    L7:
        return r0.getRoomDataContext(r3, r1);
    L5:
        r1 = 0;
        goto L7
    }
}
