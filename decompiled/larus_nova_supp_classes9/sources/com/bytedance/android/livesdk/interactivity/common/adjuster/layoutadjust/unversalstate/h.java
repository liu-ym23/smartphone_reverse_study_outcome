package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final int c = 0;
    public static final h d = null;

    public h() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PkHeightAdjust";
    }

    static {
        d = new h();
        c = UtilityKotlinExtentionsKt.i(138);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        return r2.t;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r7, int r8, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r9, Room r10, LiveRoomEnvStateHolder r11) {
        Intrinsics.checkNotNullParameter(r9, "uiContext");
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r11, "roomStatus");
        if (r10.isMediaRoom() == true) goto L43;
        if (r9.g1() == false) goto L43;
        if (r11.t == false) goto L10;
        j.c.d("on manage pk opt, env : request margin " + r11.C + ", video bottom " + r9.WN());
        int r13 = r11.u;
        if (r11.v == false) goto L35;
        InteractionWidgetsPosContext.a r14 = InteractionWidgetsPosContext.Companion;
        r14.getClass();
        int r0 = InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp();
        int r15 = r9.pT();
        long r3 = r10.getRoomId();
        int r16 = (((r15 - r13) - InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp()) - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp()) + InteractionWidgetsPosContext.access$getMULTI_PK_OFFSET_HEIGHT$cp();
        int r17 = (InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r16) - InteractionWidgetsPosContext.access$getSMALL_GIFT_TRAY_HEIGHT$cp();
        if (r16 < c) goto L20;
        InteractionWidgetsPosContext r18 = InteractionWidgetsPosContext.a.c(r14, null, r3, 1);
        if (r18 == null) goto L34;
        m r19 = r18.getRevenuePkGiftTrayPos();
        if (r19 == null) goto L34;
        r19.setValue(new ok1.a(r17, 2));
    L34:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r16, r0, 12);
    L20:
        int r20 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.b;
        if (r16 <= r20) goto L27;
        InteractionWidgetsPosContext r21 = InteractionWidgetsPosContext.a.c(r14, null, r3, 1);
        if (r21 == null) goto L34;
        m r23 = r21.getRevenuePkGiftTrayPos();
        if (r23 == null) goto L34;
        r23.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r16) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
        goto L34
    L27:
        InteractionWidgetsPosContext r24 = InteractionWidgetsPosContext.a.c(r14, null, r3, 1);
        if (r24 == null) goto L32;
        m r25 = r24.getRevenuePkGiftTrayPos();
        if (r25 == null) goto L32;
        r25.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r20) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
    L32:
        r16 = r20;
        goto L34
    L35:
        int r26 = (r9.pT() - r13) + UtilityKotlinExtentionsKt.i(44);
        InteractionWidgetsPosContext r110 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r10.getRoomId(), 1);
        if (r110 == null) goto L41;
        m r111 = r110.getRevenuePkGiftTrayPos();
        if (r111 == null) goto L41;
        r111.setValue(new ok1.a(r26, 1));
    L41:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(((r9.pT() - r13) - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp()) - UtilityKotlinExtentionsKt.i(38), 0, 14);
    L10:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r7, 0, 14);
    L43:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r7, 0, 14);
    }
}
