package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class CommonAudienceWidthAdjustStrategy implements i {
    public final int c;
    public final int d;
    public final Lazy e;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "CommonAudienceWidthAdjust";
    }

    public final int f() {
        return ((Number) this.e.getValue()).intValue();
    }

    public CommonAudienceWidthAdjustStrategy() {
        this.c = s1.j(2131168920);
        this.d = s1.f(8.0f);
        this.e = LazyKt.lazy(new CommonAudienceWidthAdjustStrategy$screenRightMargin$2(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i
    public final k b(com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r8, Room r9, LiveRoomEnvStateHolder r10) {
        Intrinsics.checkNotNullParameter(r8, "uiContext");
        Intrinsics.checkNotNullParameter(r9, "room");
        Intrinsics.checkNotNullParameter(r10, "roomStatus");
        boolean r11 = false;
        if (r8.g1() == false) goto L5;
        int r13 = f();
        if (r10.c == false) goto L9;
    L20:
        int r0 = r10.r0();
        boolean r3 = us1.e.a;
        if (r0 <= 0) goto L24;
        r13 = s1.f(r0 * 1.0f);
    L33:
        boolean r1 = iy.b.a;
        iy.b.d("CommonAudienceWidthAdjustStrategy onChange isNewVideoLink = " + r10.Y() + " changeWidth = " + r10.r0());
        if (r10.Y() == false) goto L39;
        int r2 = r10.r0();
        if (r2 <= 0) goto L39;
        r13 = s1.f(r2 * 1.0f);
    L39:
        if (r10.E() == false) goto L42;
        boolean r4 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by common cast", "msg");
        r13 = Math.max(r13, (this.d + s1.f(100.0f)) + f());
    L42:
        if (r10.y() == false) goto L45;
        boolean r5 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by banner", "msg");
        r13 = Math.max(r13, (this.d + s1.f(112.0f)) + f());
    L45:
        if (r10.s() == false) goto L48;
        boolean r6 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by anchor play video", "msg");
        r13 = Math.max(r13, (this.d + s1.f(129.0f)) + f());
    L48:
        if (r10.e == false) goto L51;
        boolean r7 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by shop shown", "msg");
        r13 = Math.max(r13, (this.d + s1.f(112.0f)) + f());
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant.ConditionType.SHOW_CARD));
    L51:
        if (r10.h == false) goto L54;
        boolean r14 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by ticket card shown", "msg");
        r13 = Math.max(r13, (this.d + s1.f(112.0f)) + f());
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant.ConditionType.SHOW_CARD));
    L54:
        if (r10.i == false) goto L57;
        boolean r15 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by activity interactive shown", "msg");
        r13 = Math.max(r13, (this.d + s1.f(130.0f)) + f());
    L57:
        if (r10.p0() <= 0) goto L60;
        int r16 = (r10.p0() + this.d) + f();
        j.c.d("adjust width by mini app : " + r16);
        r13 = Math.max(r13, r16);
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant.ConditionType.SHOW_CARD));
    L60:
        if (r10.R() == false) goto L62;
    L63:
        boolean r17 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by ktv", "msg");
        r13 = Math.max(r13, (r10.o0() + this.d) + f());
    L65:
        if (r13 != f()) goto L68;
        boolean r18 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by follow move down", "msg");
        r13 = r13 + s1.f(48.0f);
    L68:
        if (r10.k == false) goto L70;
        boolean r19 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by bottomRightCardShown", "msg");
        r13 = Math.max(r13, (this.d + r10.l) + f());
    L70:
        Integer r20 = h72.b.a();
        if (r20 == null) goto L74;
        int r21 = r20.intValue();
        boolean r23 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by handleAudioRoomShortVideoCase", "msg");
        r13 = Math.max(r13, r21);
    L74:
        if (r10.c0() == false) goto L77;
        boolean r24 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by payPerformTicketForTempWatch", "msg");
        r13 = Math.max(r13, (this.d + s1.f(112.0f)) + f());
    L77:
        if (r10.j == false) goto L80;
        boolean r25 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by bottomRightWelfareCard", "msg");
        r13 = Math.max(r13, (this.d + s1.f(112.0f)) + f());
    L80:
        if (r10.u() == false) goto L83;
        boolean r26 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by bottomRightAppWidgetGuide", "msg");
        r13 = Math.max(r13, (this.d + s1.f(130.0f)) + f());
    L83:
        if (r10.z() == false) goto L86;
        boolean r27 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by feedback card shown", "msg");
        r13 = Math.max(r13, (this.d + s1.f(112.0f)) + f());
    L86:
        if (r10.b0() == false) goto L89;
        boolean r28 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by paid share ticket card", "msg");
        r13 = Math.max(r13, (this.d + s1.f(112.0f)) + f());
    L89:
        if (r10.f0() == false) goto L92;
        boolean r29 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by scoreboard", "msg");
        r13 = Math.max(r13, (this.d + r10.p()) + f());
    L92:
        if (r10.K() == false) goto L95;
        boolean r30 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by group_container", "msg");
        r13 = Math.max(r13, (this.d + r10.l()) + f());
    L95:
        if (r10.o == true) goto L97;
    L99:
        as0.a r110 = LivePlatformPlayerManager.b();
        if (r110 == null) goto L104;
        ILivePlayerClient r111 = r110.player();
        if (r111 == null) goto L104;
        ILivePlayerExtraRenderController r112 = r111.extraRenderController();
    L105:
        if (r112 == null) goto L112;
        ILivePlayerExtraRenderController.EventHub r31 = r112.eventHub();
        if (r31 == null) goto L112;
        MutableLiveData r33 = r31.getExtraViewWidth();
        if (r33 == null) goto L112;
        Integer r34 = (Integer) r33.getValue();
        if (r34 == null) goto L112;
    L113:
        int r35 = r34.intValue();
        if (r112 == null) goto L120;
        PlayerExtraRenderInfo r36 = r112.renderInfo();
        if (r36 == null) goto L120;
        if (r36.isUgcLayout() != true) goto L120;
        r11 = true;
    L120:
        if (r112 == null) goto L127;
        if (r112.isUgcRoom() != true) goto L127;
        if (r35 == 0) goto L127;
        if (r11 == false) goto L127;
        boolean r37 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by player extra render view", "msg");
        r13 = Math.max(r13, (this.d + r35) + f());
    L127:
        return g.a(r13);
    L112:
        r34 = 0;
    L104:
        r112 = null;
        goto L105
    L97:
        if (r10.U() == false) goto L99;
        r13 = Math.max(r13, r10.s);
        goto L99
    L62:
        if (r10.a0() == false) goto L65;
    L24:
        if (r10.I() == false) goto L26;
        r13 = f();
        goto L33
    L26:
        int r38 = r10.d;
        if (r38 > 0) goto L30;
        r38 = s1.f(100.0f) + f();
    L30:
        if (r10.t == false) goto L32;
        r38 = 0;
    L32:
        j.c.d("adjust width by linkin view : " + r38);
        r13 = Math.max(r13, this.d + r38);
        goto L33
    L9:
        if (r10.k0() == true) goto L20;
        if (r10.m0() == true) goto L20;
        if (r10.v() == true) goto L20;
        if (r10.q() == true) goto L20;
        if (r10.F() == true) goto L20;
        if (r10.L() == false) goto L33;
    L5:
        return new k(0, 0, 7);
    }
}
