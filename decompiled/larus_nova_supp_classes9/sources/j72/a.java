package j72;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.q2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.d80;
import com.bytedance.android.livesdk.config.us0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c;
import com.bytedance.android.livesdk.interactivity.common.adjuster.logical.CommentLpHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements c {
    public final float c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "MediaAudienceRoomHeightStrategy";
    }

    public a() {
        this.c = s1.e(36.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final d a(int r19, int r20, e r21, Room r23, LiveRoomEnvStateHolder r24) {
        Intrinsics.checkNotNullParameter(r21, "uiContext");
        Intrinsics.checkNotNullParameter(r23, "room");
        Intrinsics.checkNotNullParameter(r24, "roomStatus");
        if (w32.a.a() == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L59;
        int r5 = r21.pT();
        int r9 = r21.WN();
        if (r9 >= ((((double) r5) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == true) goto L15;
    L43:
        d r3 = null;
    L44:
        if (r3 == null) goto L51;
        int r1 = r3.a;
        InteractionWidgetsPosContext r2 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r23.getRoomId(), 1);
        if (r2 == null) goto L50;
        m r6 = r2.getMediaGiftTrayPos();
        if (r6 == null) goto L50;
        r6.setValue(new ok1.a(r1 + r20, 1));
    L50:
        return r3;
    L51:
        InteractionWidgetsPosContext r0 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r23.getRoomId(), 1);
        if (r0 == null) goto L56;
        m r8 = r0.getMediaGiftTrayPos();
        if (r8 == null) goto L56;
        int r10 = 0;
        r8.setValue(new ok1.a(-10086, 0));
    L58:
        return new d(y.a(), r10, 14);
    L56:
        r10 = 0;
        goto L58
    L15:
        if (r21.g1() == false) goto L43;
        if (r9 <= 0) goto L43;
        int r11 = UtilityKotlinExtentionsKt.i(4);
        boolean r13 = r24.h0();     // Catch: Exception -> L28
        RoomContext r14 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Exception -> L28
        if (r14 == null) goto L23;
        if (r14.isVSVerticalStream() == true) goto L29;
    L23:
        if (RoomKt.hasMultiCamera(r23) == true) goto L26;
        if (q2.a(r23) == false) goto L29;
    L26:
        if (r13 == true) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == false) goto L32;
        float r16 = this.c;
    L33:
        RoomAuthStatus r17 = r23.getRoomAuthStatus();
        if (r17 != null) goto L36;
    L38:
        boolean r18 = false;
    L39:
        if (r18 == false) goto L41;
        InteractionWidgetsPosContext.Companion.getClass();
        int r25 = InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp();
    L42:
        r3 = new d((int) (((((r5 - r9) - r11) - r16) - r25) - r20), 0, 14);
        goto L44
    L41:
        r25 = 0;
        goto L42
    L36:
        if (r17.getEnableGift() != true) goto L38;
        r18 = true;
        goto L39
    L32:
        r16 = 0.0f;
    L29:
        r15 = false;
        goto L30
    L12:
        r7 = false;
        goto L13
    L59:
        d r26 = CommentLpHelper.c(r21, r20, r23, r24);
        if (r26 == null) goto L71;
        if (((Boolean) us0.a.getValue()).booleanValue() == false) goto L74;
        int r27 = r26.a;
        int r28 = r20 + r27;
        InteractionWidgetsPosContext r29 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r23.getRoomId(), 1);
        if (r29 == null) goto L69;
        m r30 = r29.getMediaGiftTrayPos();
        if (r30 == null) goto L69;
        int r31 = i72.a.a;
        r30.setValue(new ok1.a(r28 - s1.j(2131168727), 2));
    L69:
        return new d(r28, 0, 14);
    L74:
        return r26;
    L71:
        return new d(y.a(), 0, 14);
    L5:
        if (((Boolean) d80.a.getValue()).booleanValue() == false) goto L7;
        r4 = true;
        goto L8
    }
}
