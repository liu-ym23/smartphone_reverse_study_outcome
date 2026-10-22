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
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements c {
    public static final float c = 0.0f;
    public static final b d = null;

    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadMediaAudienceRoomHeightStrategy";
    }

    static {
        d = new b();
        c = s1.e(36.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final d a(int r16, int r17, e r18, Room r19, LiveRoomEnvStateHolder r20) {
        Intrinsics.checkNotNullParameter(r18, "uiContext");
        Intrinsics.checkNotNullParameter(r19, "room");
        Intrinsics.checkNotNullParameter(r20, "roomStatus");
        if (w32.a.a() == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L54;
        int r2 = r18.pT();
        int r14 = r18.WN();
        if (r14 >= ((((double) r2) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L16;
    L44:
        d r3 = null;
    L45:
        if (r3 == null) goto L53;
        int r4 = r3.a;
        InteractionWidgetsPosContext r6 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r19.getRoomId(), 1);
        if (r6 == null) goto L51;
        m r7 = r6.getMediaGiftTrayPos();
        if (r7 == null) goto L51;
        r7.setValue(new ok1.a(r4 + r17, 1));
    L51:
        return r3;
    L53:
        return new d(y.a(), 0, 14);
    L16:
        if (r18.g1() == false) goto L44;
        if (r14 <= 0) goto L44;
        int r8 = UtilityKotlinExtentionsKt.i(4);
        boolean r9 = r20.h0();     // Catch: Exception -> L29
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Exception -> L29
        if (r10 == null) goto L24;
        if (r10.isVSVerticalStream() == true) goto L30;
    L24:
        if (RoomKt.hasMultiCamera(r19) == true) goto L27;
        if (q2.a(r19) == false) goto L30;
    L27:
        if (r9 == true) goto L30;
        boolean r11 = true;
    L31:
        if (r11 == false) goto L33;
        float r13 = c;
    L34:
        RoomAuthStatus r15 = r19.getRoomAuthStatus();
        if (r15 != null) goto L37;
    L39:
        boolean r21 = false;
    L40:
        if (r21 == false) goto L42;
        InteractionWidgetsPosContext.Companion.getClass();
        int r23 = InteractionWidgetsPosContext.access$getGIFT_TRAY_HEIGHT$cp();
    L43:
        r3 = new d((int) (((((r2 - r14) - r8) - r13) - r23) - r17), 0, 14);
        goto L45
    L42:
        r23 = 0;
        goto L43
    L37:
        if (r15.getEnableGift() != true) goto L39;
        r21 = true;
        goto L40
    L33:
        r13 = 0.0f;
    L30:
        r11 = false;
        goto L31
    L13:
        r5 = false;
        goto L14
    L54:
        int r24 = r18.pT();
        int r25 = r18.WN();
        if (r25 < ((((double) r24) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L57;
    L59:
        boolean r26 = false;
    L60:
        if (r26 == false) goto L76;
        if (r18.g1() == false) goto L76;
        if (r25 <= 0) goto L76;
        float r27 = ((r24 - r25) - CommentLpHelper.a) - r17;
        if (((Boolean) us0.a.getValue()).booleanValue() == false) goto L74;
        int r0 = r17 + ((int) r27);
        InteractionWidgetsPosContext r28 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r19.getRoomId(), 1);
        if (r28 == null) goto L72;
        m r29 = r28.getMediaGiftTrayPos();
        if (r29 == null) goto L72;
        int r30 = i72.a.a;
        r29.setValue(new ok1.a(r0 - s1.j(2131168728), 2));
    L72:
        return new d(r0, 0, 14);
    L74:
        return new d((int) r27, 0, 14);
    L76:
        return new d((int) (((double) s1.w()) * 0.28d), 0, 14);
    L57:
        if (e5.n() == true) goto L59;
        r26 = true;
        goto L60
    L5:
        if (((Boolean) d80.a.getValue()).booleanValue() == false) goto L7;
        r1 = true;
        goto L9
    }
}
