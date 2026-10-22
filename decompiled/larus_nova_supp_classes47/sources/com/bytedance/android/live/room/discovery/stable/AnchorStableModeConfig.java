package com.bytedance.android.live.room.discovery.stable;

import com.bytedance.android.live.broadcast.api.stable.AbsAnchorFactor;
import com.bytedance.android.live.broadcast.api.stable.AnchorStrategy;
import com.bytedance.android.live.broadcast.api.stable.AnchorStrategyConfig;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.l3;
import com.bytedance.android.livesdk.config.yc;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorStableModeConfig {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AnchorStrategyConfig a(final DataCenter r6, final Function1 r7) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "onLevelChange");
        final AnchorStrategyConfig r0 = new AnchorStrategyConfig(AnchorStrategy.StableMode);
        Intrinsics.checkNotNullParameter(new AnchorStableModeConfig$create$$inlined$apply$lambda$1(r6, r7), "<set-?>");
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        if (r1 == null) goto L7;
        m r2 = r1.isAnchorStableMode();
        if (r2 == null) goto L7;
        r2.a();
    L7:
        Intrinsics.checkNotNullParameter(new AnchorStableModeConfig$create$$inlined$apply$lambda$2(r0, r6, r7), "<set-?>");
        yc r8 = yc.a;
        ((l3) r8.getValue()).getClass();
        ((l3) r8.getValue()).getClass();
        AbsAnchorFactor[] r9 = {new AnchorStreamFPSLevelFactor(r6)};
        Intrinsics.checkNotNullParameter(r9, "factors");
        r0.a.add(r9[0]);
        return r0;
    }
}
