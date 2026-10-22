package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RewardMsgContainer extends FrameLayout {
    public static final /* synthetic */ int h = 0;
    public h a;
    public com.bytedance.android.live.broadcastgame.opengame.t b;
    public com.bytedance.android.live.broadcastgame.opengame.panel.h c;
    public View d;
    public View e;
    public final View f;
    public RewardMsgContainer$startHideCountdown$2 g;

    public static final class a {
    }

    static {
    }

    public final void c() {
        h r0 = this.a;
        if (r0 == null) goto L45;
        final m0 r1 = r0.poll();
        if (r1 != null) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, onNewMsg = " + r1);
    L10:
        if (d() == false) goto L31;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L14;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, 已有老的，新的替换老的");
    L14:
        KeyEvent.Callback r2 = this.d;
        if (r2 == null) goto L29;
        ((g) r2).k(new RewardMsgContainer$onNewMsg$3(this));
        KeyEvent.Callback r3 = this.e;
        if (r3 == null) goto L27;
        ((g) r3).setReward(r1);
        KeyEvent.Callback r4 = this.e;
        if (r4 == null) goto L25;
        ((g) r4).o(new RewardMsgContainer$onNewMsg$4(this, r1));
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L23;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, 新老 Item 互换");
    L23:
        View r5 = this.d;
        this.d = this.e;
        this.e = r5;
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    L31:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L33;
        Logger.d("RewardMsgContainer", "RewardMsgContainer,  没有老的，新的直接展示");
    L33:
        com.bytedance.android.live.broadcastgame.opengame.panel.h r6 = this.c;
        if (r6 == null) goto L36;
        r6.M(0);
    L36:
        z.b(this.f);
        KeyEvent.Callback r7 = this.d;
        if (r7 == null) goto L44;
        ((g) r7).setReward(r1);
        KeyEvent.Callback r8 = this.d;
        if (r8 == null) goto L42;
        ((g) r8).j(new RewardMsgContainer$onNewMsg$7(this, r1));
        return;
    L42:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.view.IRewardItemView");
    }

    public final boolean d() {
        if (this.d.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L9;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, 老 item 正在展示: " + r0);
    L9:
        return r0;
    L5:
        r0 = false;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, cancelHideCountdown");
    L5:
        RewardMsgContainer$startHideCountdown$2 r0 = this.g;
        if (r0 == null) goto L9;
        removeCallbacks(r0);
        return;
    }

    public RewardMsgContainer(final PluginContext r11) {
        Intrinsics.checkNotNullParameter(r11, "pluginContext");
        super(r11.getContext());
        this.d = new RewardItemView(getContext(), new RewardMsgContainer$oldItem$1(r11));
        this.e = new RewardItemView(getContext(), new RewardMsgContainer$newItem$1(r11));
        View r12 = View.inflate(getContext(), 2131567097, this);
        this.f = r12;
        setBackground(getResources().getDrawable(2131249681));
        ConstraintLayout r1 = r12.findViewById(2131380004);
        ConstraintSet r2 = new ConstraintSet();
        r2.clone(r1);
        this.d.setId(View.generateViewId());
        r12.findViewById(2131380004).addView(this.d);
        r2.connect(this.d.getId(), 6, r1.getId(), 6);
        r2.connect(this.d.getId(), 3, r1.getId(), 3);
        r2.connect(this.d.getId(), 4, r1.getId(), 4);
        r2.connect(this.d.getId(), 7, r1.getId(), 7);
        r2.applyTo(r1);
        this.e.setId(View.generateViewId());
        r12.findViewById(2131380004).addView(this.e);
        r2.connect(this.e.getId(), 6, r1.getId(), 6);
        r2.connect(this.e.getId(), 3, r1.getId(), 3);
        r2.connect(this.e.getId(), 4, r1.getId(), 4);
        r2.connect(this.e.getId(), 7, r1.getId(), 7);
        r2.applyTo(r1);
        r12.setVisibility(4);
        this.d.setVisibility(4);
        this.e.setVisibility(4);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.live.broadcastgame.opengame.view.RewardMsgContainer$startHideCountdown$2] */
    public static final void b(final RewardMsgContainer r3) {
        r3.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        Logger.d("RewardMsgContainer", "RewardMsgContainer, startHideCountdown");
    L6:
        if (r3.g != null) goto L8;
        r3.g = new RewardMsgContainer$startHideCountdown$2(r3);
    L8:
        r3.postDelayed(r3.g, n5.DEFAULT_SHOW_DURATION);
    }

    public static final void a(RewardMsgContainer r6, int r7) {
        r6.getClass();
        int r0 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.live.broadcastgame.opengame.t r1 = r6.b;
        String r2 = "";
        if (r1 == null) goto L5;
        String r3 = r1.b(false);
    L6:
        com.bytedance.android.live.broadcastgame.opengame.t r8 = r6.b;
        if (r8 == null) goto L12;
        String r9 = String.valueOf(r8.h);
        if (r9 == null) goto L12;
        r2 = r9;
    L12:
        String r11 = jc1.k.n(IUserService.class).user().n();
        String r12 = String.valueOf(r7);
        Intrinsics.checkNotNullParameter(r3, "programName");
        Intrinsics.checkNotNullParameter(r2, "programId");
        Intrinsics.checkNotNullParameter(r11, "userId");
        Intrinsics.checkNotNullParameter(r12, "amount");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_program_prop_message_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("program_id", r2), TuplesKt.to("program_name", r3), TuplesKt.to("user_id", r11), TuplesKt.to("prop_amount", r12)}), new Object[]{Room.class});
        return;
    L5:
        r3 = "";
        goto L6
    }
}
