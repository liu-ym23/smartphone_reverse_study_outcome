package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g {
    public static final int c = 0;
    public static final d d = null;

    public d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "MultiAnchorConnect";
    }

    static {
        d = new d();
        c = UtilityKotlinExtentionsKt.i(138);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final boolean c(LiveRoomEnvStateHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "roomStatus");
        return r2.o;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.g
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r6, int r7, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r8, Room r9, LiveRoomEnvStateHolder r10) {
        Intrinsics.checkNotNullParameter(r8, "uiContext");
        Intrinsics.checkNotNullParameter(r9, "room");
        Intrinsics.checkNotNullParameter(r10, "roomStatus");
        int r11 = ((r8.pT() - (r10.p + ((int) s1.e(46.0f)))) + 0) - r7;
        if (r11 >= ((int) s1.e(135.0f))) goto L6;
        r11 = (int) s1.e(135.0f);
    L6:
        if (ok1.d.a() == false) goto L45;
        InteractionWidgetsPosContext.a r13 = InteractionWidgetsPosContext.Companion;
        r13.getClass();
        int r14 = InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp();
        int r0 = r10.p;
        int r15 = r8.pT();
        long r1 = r9.getRoomId();
        int r16 = (((r15 - r0) - InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp()) - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp()) + InteractionWidgetsPosContext.access$getMULTI_PK_OFFSET_HEIGHT$cp();
        if (r10.U() == false) goto L11;
        r16 = (int) s1.e(160.0f);
    L11:
        if (ArraysKt.contains(ok1.d.a, Integer.valueOf(ok1.d.b())) == false) goto L13;
        int r17 = InteractionWidgetsPosContext.access$getSMALL_GIFT_TRAY_HEIGHT$cp();
    L14:
        Integer[] r18 = ok1.d.b;
        if (ArraysKt.contains(r18, Integer.valueOf(ok1.d.b())) == false) goto L17;
        int r2 = 2;
    L19:
        if (ArraysKt.contains(r18, Integer.valueOf(ok1.d.b())) == false) goto L21;
        int r19 = (InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r16) - r17;
    L23:
        if (r16 < c) goto L29;
        InteractionWidgetsPosContext r20 = InteractionWidgetsPosContext.a.c(r13, null, r1, 1);
        if (r20 == null) goto L43;
        m r21 = r20.getMultiPkGiftTrayPos();
        if (r21 == null) goto L43;
        r21.setValue(new ok1.a(r19, r2));
    L43:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r16, r14, 12);
    L29:
        int r23 = com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.b.b;
        if (r16 <= r23) goto L36;
        InteractionWidgetsPosContext r24 = InteractionWidgetsPosContext.a.c(r13, null, r1, 1);
        if (r24 == null) goto L43;
        m r25 = r24.getMultiPkGiftTrayPos();
        if (r25 == null) goto L43;
        r25.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r16) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
        goto L43
    L36:
        InteractionWidgetsPosContext r26 = InteractionWidgetsPosContext.a.c(r13, null, r1, 1);
        if (r26 == null) goto L41;
        m r27 = r26.getMultiPkGiftTrayPos();
        if (r27 == null) goto L41;
        r27.setValue(new ok1.a((InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r23) + InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp(), 1));
    L41:
        r16 = r23;
        goto L43
    L21:
        int r28 = InteractionWidgetsPosContext.access$getTOOLBAR_HEIGHT$cp() + r16;
        r19 = InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp() + r28;
        goto L23
    L17:
        r2 = 1;
        goto L19
    L13:
        r17 = InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp();
        goto L14
    L45:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r11, 0, 14);
    }
}
