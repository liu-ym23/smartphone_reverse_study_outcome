package l72;

import com.bytedance.android.live.core.utils.q2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.logical.CommentLpHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c {
    public final float c;
    public final float d;
    public final int e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "VSAudienceRoomHeightAdjustStrategy";
    }

    public d() {
        s1.e(114.0f);
        this.c = s1.e(4.0f);
        this.d = s1.e(36.0f);
        this.e = (int) s1.e(8.0f);
        s1.e(102.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r27, int r28, e r29, Room r30, LiveRoomEnvStateHolder r31) {
        Intrinsics.checkNotNullParameter(r29, "uiContext");
        Intrinsics.checkNotNullParameter(r30, "room");
        Intrinsics.checkNotNullParameter(r31, "roomStatus");
        if (r29.g1() == false) goto L12;
        RoomContext.a r5 = RoomContext.Companion;
        long r9 = r30.getRoomId();
        r5.getClass();
        RoomContext r10 = RoomContext.a.a(null, r9);
        if (r10 != null) goto L8;
    L10:
        int r11 = r29.pT();
        int r13 = r29.WN();
        if (r13 <= 0) goto L12;
        if (r13 >= ((((double) r11) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c r14 = null;
    L49:
        if (r14 == null) goto L51;
        return r14;
    L51:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r4 = CommentLpHelper.c(r29, r28, r30, r31);
        if (r4 == null) goto L54;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c r15 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c((((r29.pT() - r29.WN()) - r28) + 0) - com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.a.b, r4.a, 0, 0, null, 28);
    L55:
        if (r15 == null) goto L57;
        return r15;
    L57:
        long r1 = r30.getRoomId();
        int r7 = y.a();
        int r8 = r7 + com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.a.a;
        InteractionWidgetsPosContext r2 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r1, 1);
        if (r2 == null) goto L63;
        m r3 = r2.getVsGiftTrayPos();
        if (r3 == null) goto L63;
        r3.setValue(new ok1.a(-10086, 0));
    L63:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c(r8, r7, 0, 0, null, 28);
    L54:
        r15 = null;
        goto L55
    L19:
        float r16 = this.c;
        boolean r17 = r31.h0();     // Catch: Exception -> L30
        RoomContext r18 = RoomContext.a.c(r5, null, 0, 3);     // Catch: Exception -> L30
        if (r18 == null) goto L25;
        if (r18.isVSVerticalStream() == true) goto L31;
    L25:
        if (RoomKt.hasMultiCamera(r30) == true) goto L28;
        if (q2.a(r30) == false) goto L31;
    L28:
        if (r17 == true) goto L31;
        boolean r19 = true;
    L32:
        if (r19 == false) goto L34;
        float r20 = this.d;
    L35:
        InteractionWidgetsPosContext.a r21 = InteractionWidgetsPosContext.Companion;
        r21.getClass();
        InteractionWidgetsPosContext r23 = InteractionWidgetsPosContext.a.a();
        if (r23 == null) goto L42;
        m r24 = r23.getVsChorusConcertHeight();
        if (r24 == null) goto L42;
        Integer r25 = (Integer) r24.getValue();
        if (r25 == null) goto L42;
        int r26 = r25.intValue();
    L43:
        InteractionWidgetsPosContext r33 = InteractionWidgetsPosContext.a.c(r21, null, r30.getRoomId(), 1);
        if (r33 == null) goto L48;
        m r34 = r33.getVsGiftTrayPos();
        if (r34 == null) goto L48;
        float r110 = (((r11 - r13) - this.c) - r28) - r20;
        int r111 = i72.a.a;
        r34.setValue(new ok1.a(((int) (r110 - s1.j(2131168727))) - r26, 2));
    L48:
        int r35 = r11 - r13;
        int r36 = (int) r20;
        float r37 = (((r35 - r16) - r28) - r36) - r26;
        int r210 = ((r35 - r28) - ((this.e + r36) + r26)) - com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.a.b;
        boolean r38 = TextMessageTracer.a;
        TextMessageTracer.A("calculate new container height, interactHeight is " + r11 + ", videoBottom is " + r13 + ", videoGap is " + r16 + ", currentMarginBottom is " + r28 + ", time is " + System.currentTimeMillis());
        r14 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.c(r210, (int) r37, 0, 0, null, 28);
    L42:
        r26 = 0;
        goto L43
    L34:
        r20 = 0.0f;
    L31:
        r19 = false;
        goto L32
    L16:
        r6 = false;
        goto L17
    L8:
        if (r10.isVSVerticalStream() != true) goto L10;
    L12:
        r14 = null;
        goto L49
    }
}
