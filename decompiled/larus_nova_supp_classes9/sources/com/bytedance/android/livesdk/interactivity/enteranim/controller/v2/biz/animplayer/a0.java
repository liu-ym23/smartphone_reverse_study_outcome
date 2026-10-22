package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCombinedAnimTrayView;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenCommonAnimTrayView;
import com.bytedance.android.livesdk.interactivity.common.enterAnim.WindScreenRebirthAnimTrayView;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.BottomEnterAnimHelper;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.EmergeComboEnterAnimHelper;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.NormalComboEnterAnimHelper;
import com.bytedance.android.livesdk.message.model.pg;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 extends AnimPlayer<k32.d> {
    public final com.bytedance.android.livesdk.interactivity.enteranim.utils.k c;

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.WindScreen;
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final boolean a(k32.d r2) {
        if (r2 == null) goto L13;
        h3 r0 = r2.t;
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.M() != null) goto L8;
        return true;
    L8:
        if (TextUtils.equals(r2.t.M().getScene(), "sell_well") == true) goto L10;
        return true;
    L10:
        if (c() == false) goto L18;
        return false;
    L18:
        return true;
    L13:
        return true;
    }

    public a0(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
        this.c = new com.bytedance.android.livesdk.interactivity.enteranim.utils.k(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.interactivity.common.enterAnim.BaseWindScreenAnimEnterTrayView] */
    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(k32.a r21, Context r23, AnimPlayer.a r24, ViewGroup r25, a r26) {
        final k32.d r9 = (k32.d) r21;
        final h3 r4 = r9.t;
        if (r4 != null) goto L9;
        v72.c r0 = ((v72.c.a) r26).a;
        int r1 = r0.n;
        if (r1 != 1) goto L90;
        r0.n = r1 - 1;
    L90:
        return;
    L9:
        if (r4.M() == null) goto L36;
        if (r4.M().getScene() == null) goto L36;
        if ("purchase_live_ticket".equals(r4.M().getScene()) == false) goto L36;
        DataCenter r2 = this.b;
        if (com.bytedance.android.livesdk.chatroom.paidlive.e.f(r2) == false) goto L32;
        if (r2 == null) goto L29;
        IRoom r3 = (IRoom) r2.get("data_room", null);
        if (r3 == null) goto L29;
        long r6 = 0;
        com.bytedance.android.livesdk.chatroom.o r5 = IRoomContextService.a.a(jc1.k.n(IRoomContextService.class), r2, 0, 2);
        if (r5 == null) goto L28;
        com.bytedance.live.datacontext.m r7 = r5.getCameraId();
        if (r7 == null) goto L28;
        Long r8 = (Long) r7.getValue();
        if (r8 == null) goto L28;
        r6 = r8.longValue();
    L28:
        boolean r10 = com.bytedance.android.livesdk.chatroom.paidlive.e.c(r3, Long.valueOf(r6));
    L30:
        if (r10 == true) goto L32;
        boolean r11 = true;
    L33:
        if (r11 == true) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == false) goto L42;
        v72.c r14 = ((v72.c.a) r26).a;
        int r15 = r14.n;
        if (r15 != 1) goto L91;
        r14.n = r15 - 1;
        return;
    L91:
        return;
    L42:
        if (com.bytedance.android.livesdk.interactivity.common.enterAnim.f.b(r9) == false) goto L46;
        WindScreenRebirthAnimTrayView r16 = new WindScreenRebirthAnimTrayView(r25.getContext());
        r16.setOnSchemaHandleListener(new x(r9));
        Object r17 = r16;
    L44:
        ?? r18 = r17;
        r18.R5(r9);
        r18.setOnClickListener(r24.c);
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
        r19.gravity = 80;
        r25.addView(r18, r19);
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r18.getLayoutParams();
        r20.bottomMargin = r24.a;
        r18.setLayoutParams(r20);
        pg.b r27 = r4.getDynamicConfig();
        if (r27 == null) goto L52;
        int r110 = r27.b();
    L53:
        z r28 = new z(this, r26, r4, r27, r25, r18);
        float r29 = 40.0f;
        if (com.bytedance.android.livesdk.interactivity.common.enterAnim.f.b(r9) == true) goto L56;
    L67:
        if (r110 == 1) goto L77;
        if (r110 == 2) goto L77;
        if (r110 != 3) goto L76;
        int r30 = com.bytedance.android.livesdk.padutils.d.a;
        if (PadConfigUtils.c() == false) goto L75;
        r29 = com.bytedance.android.livesdk.padutils.d.a;
    L75:
        r18.setX(r29);
        r18.setY(s1.f(3.0f));
        r18.setAlpha(0.0f);
        BottomEnterAnimHelper r31 = new BottomEnterAnimHelper(r18, r18, r28);
        ((q4.b) r31.c.getValue()).c();
        ((v72.c.a) r26).a.i = r31.h;
    L81:
        h3 r33 = r9.t;
        if (r33 != null) goto L84;
    L88:
        RevenueUtils.a("WindScreenCommon", r25, r9, r24.b);
        return;
    L84:
        if (r33.M() == null) goto L88;
        if (TextUtils.equals(r9.t.M().getScene(), "sell_well") == false) goto L88;
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant.ConditionType.SHOW_SALE));
        goto L88
    L76:
        r18.setX(r25.getWidth());
        r18.setY(s1.f(3.0f));
        NormalComboEnterAnimHelper r34 = new NormalComboEnterAnimHelper(r18, r18, r28, (6 * s1.y()) / 375, c());
        ((q4.b) r34.c.getValue()).c();
        ((v72.c.a) r26).a.i = r34.h;
    L77:
        int r35 = com.bytedance.android.livesdk.padutils.d.a;
        if (PadConfigUtils.c() == false) goto L80;
        r29 = com.bytedance.android.livesdk.padutils.d.a;
    L80:
        r18.setX(r29);
        r18.setY(s1.f(3.0f));
        r18.setAlpha(0.0f);
        EmergeComboEnterAnimHelper r36 = new EmergeComboEnterAnimHelper(r18, r18, r28);
        ((q4.b) r36.c.getValue()).c();
        ((v72.c.a) r26).a.i = r36.h;
        goto L81
    L56:
        if ((r18 instanceof WindScreenRebirthAnimTrayView) == false) goto L67;
        int r37 = com.bytedance.android.livesdk.padutils.d.a;
        if (PadConfigUtils.c() == false) goto L60;
        r29 = com.bytedance.android.livesdk.padutils.d.a;
    L60:
        r18.setX(r29);
        r18.setY(s1.f(3.0f));
        WindScreenRebirthAnimTrayView r111 = (WindScreenRebirthAnimTrayView) r18;
        Intrinsics.checkNotNullParameter(r28, "comboBridge");
        r111.j = r28;
        h3 r38 = r111.i;
        if (r38 == null) goto L65;
        pg.a r39 = r38.getBackground();
        if (r39 == null) goto L65;
        py.k r40 = r39.a();
    L66:
        int r41 = a3.d;
        a3.a.a(r111.c, r40, new com.bytedance.android.livesdk.interactivity.common.enterAnim.g(r111, r28), 0.0f);
        ((v72.c.a) r26).a.i = r111.getDelegateReleaseAnimator();
    L65:
        r40 = null;
        goto L66
    L52:
        r110 = 0;
        goto L53
    L46:
        if (r9.a() == false) goto L48;
        WindScreenCombinedAnimTrayView r43 = new WindScreenCombinedAnimTrayView(r25.getContext());
        r43.setConfigSceneInterceptor(new com.bytedance.android.livesdk.interactivity.common.enterAnim.b());
        r43.setOnSchemaHandleListener(new y(r4, r9));
        r17 = r43;
        goto L44
    L48:
        r17 = new WindScreenCommonAnimTrayView(r25.getContext());
    L29:
        r10 = false;
    L32:
        r11 = false;
    L36:
        r13 = false;
        goto L37
    }
}
