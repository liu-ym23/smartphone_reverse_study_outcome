package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.y;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c {
    public static final a c = null;

    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "CommonAnchorHeightAdjust";
    }

    static {
        c = new a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r10, int r11, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r13, Room r14, LiveRoomEnvStateHolder r15) {
        Intrinsics.checkNotNullParameter(r13, "uiContext");
        Intrinsics.checkNotNullParameter(r14, "room");
        Intrinsics.checkNotNullParameter(r15, "roomStatus");
        int r16 = r13.pT();
        int r17 = r13.lV();
        int r0 = r13.WN();
        if (r0 >= ((((double) r16) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L5;
        boolean r1 = true;
    L6:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r3 = null;
        if (r17 <= 0) goto L14;
        int r18 = ((r16 - r17) - UtilityKotlinExtentionsKt.i(6)) - (y.d - UtilityKotlinExtentionsKt.i(12));
        InteractionWidgetsPosContext r19 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r14.getRoomId(), 1);
        if (r19 == null) goto L13;
        m r110 = r19.getPlatformGiftTrayPos();
        if (r110 == null) goto L13;
        r110.setValue(new ok1.a(r18 + r17, 2));
    L13:
        r3 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r18, r17 + UtilityKotlinExtentionsKt.i(6), 12);
    L24:
        if (r3 == null) goto L27;
        return r3;
    L27:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y.a(), UtilityKotlinExtentionsKt.i(60), 12);
    L14:
        InteractionWidgetsPosContext r111 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r14.getRoomId(), 1);
        if (r111 == null) goto L19;
        m r112 = r111.getPlatformGiftTrayPos();
        if (r112 == null) goto L19;
        r112.setValue(new ok1.a(-10086, 0));
    L19:
        if (r1 == false) goto L24;
        if (r13.g1() == false) goto L24;
        if (r0 <= 0) goto L24;
        r3 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) (((r16 - r0) - s1.e(80.0f)) - r11), 0, 14);
        goto L24
    L5:
        r1 = false;
        goto L6
    }
}
