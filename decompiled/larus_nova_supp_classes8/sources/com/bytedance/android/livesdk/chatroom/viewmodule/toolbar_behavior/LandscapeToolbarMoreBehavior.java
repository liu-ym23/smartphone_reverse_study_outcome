package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.p9;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LandscapeToolbarMoreBehavior extends AbsToolbarMoreBehavior {
    public static final /* synthetic */ int T = 0;
    public final View.OnClickListener L;
    public View M;
    public LottieAnimationView N;
    public yo2.e O;
    public final float P;
    public final float Q;
    public Disposable R;
    public final a S;

    public class a implements Observer<Integer> {
        public final /* synthetic */ LandscapeToolbarMoreBehavior a;

        public a(LandscapeToolbarMoreBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            LandscapeToolbarMoreBehavior r0 = this.a;
            if (r0.N == null) goto L7;
            r0.s(r4);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 i() {
        return (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3) com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.i(this.g);
    }

    public final void q() {
        if (VSMediaUIConfigHelper.b(this.g) == true) goto L5;
        return;
    L5:
        if (ht2.g.e(this.q, 8) == false) goto L31;
        this.N.setImageResource(0);
        Room r0 = this.q;
        View r2 = this.M;
        if (r0 == null) goto L32;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r0.getActivityRoomSkinInfo() == null) goto L35;
        ActivityRoomSkinInfo r3 = r0.getActivityRoomSkinInfo();
        py.k r4 = null;
        if (r3 == null) goto L18;
        Map r5 = r3.getHorizontalImages();
        if (r5 == null) goto L18;
        py.k r6 = (py.k) r5.get(8);
    L19:
        if (r6 == null) goto L36;
        ActivityRoomSkinInfo r1 = r0.getActivityRoomSkinInfo();
        if (r1 == null) goto L26;
        Map r7 = r1.getHorizontalImages();
        if (r7 == null) goto L26;
        r4 = (py.k) r7.get(8);
    L26:
        int r8 = ht2.k.a;
        Observable r9 = com.bytedance.android.livesdk.chatroom.utils.a1.k(r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new ht2.c(r2)).doOnError(ht2.d.a);
        if (r9 == null) goto L33;
        r9.subscribe();
        return;
    L33:
        return;
    L36:
        return;
    L18:
        r6 = null;
        goto L19
    L35:
        return;
    L32:
        return;
    }

    public final void r() {
        yo2.e r0 = this.O;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.h() == false) goto L11;
        this.O.d();
        RoomContext.a r1 = RoomContext.Companion;
        DataCenter r2 = this.g;
        r1.getClass();
        RoomContext r3 = RoomContext.a.a(r2, 0);
        if (r3 == null) goto L12;
        r3.getToolbarBubbleManager().c(new m0());
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
        super.dv(r1);
        if ((r1 instanceof pp1.j) == false) goto L6;
        o();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior
    public final void k(KVData r6) {
        super.k(r6);
        if (r6 != null) goto L5;
        return;
    L5:
        String r7 = r6.getKey();
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case 170235087: goto L17;
            case 220810209: goto L13;
            case 774252942: goto L9;
            default: goto L20;
        };
    L20:
        switch(r4) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L23;
            default: goto L37;
        };
    L30:
        r();
        return;
    L31:
        s((Integer) ((ge1.a) hd0.c.f()).b);
        return;
    L37:
        return;
    L23:
        if (tb1.c.c == false) goto L26;
        return;
    L26:
        if (this.M == null) goto L33;
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        HashMap r8 = new HashMap();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_connection_guide_show", r8, new Object[]{am2.x.class, Room.class});
        r();
        View r9 = LayoutInflater.from(this.N.getContext()).inflate(2131567814, null);
        ((TextView) r9.findViewById(2131363198)).setOnClickListener(new r0(this));
        yo2.e r3 = new yo2.e(this.N.getContext());
        ((yo2.d) r3).d = r9;
        ((yo2.d) r3).e = 0;
        ((yo2.d) r3).n = true;
        ((yo2.d) r3).m = 5;
        ((yo2.d) r3).l = true;
        ((yo2.d) r3).b = new s0(this);
        r3.a();
        this.O = r3;
        this.M.post(new t0(this));
        this.g.put("cmd_send_show_apply_popup_success", Boolean.TRUE);
        RoomContext.a r10 = RoomContext.Companion;
        DataCenter r0 = this.g;
        r10.getClass();
        RoomContext r11 = RoomContext.a.a(r0, 0);
        if (r11 == null) goto L34;
        r11.getToolbarBubbleManager().c(new n0());
        return;
    L34:
        return;
    L33:
        return;
    L9:
        if (r7.equals("cmd_apply_tips") == false) goto L20;
        r4 = 2;
        goto L20
    L13:
        if (r7.equals("cmd_dismiss_apply_popup") == false) goto L20;
        r4 = 1;
        goto L20
    L17:
        if (r7.equals("data_more_dialog_is_show_interact_more") == false) goto L20;
        r4 = 0;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        k((KVData) r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (ILoginGuideService.-CC.ins().intercept(new q61.c(new q61.b.a(cz.c.i.c))) == false) goto L5;
        return;
    L5:
        View.OnClickListener r0 = this.L;
        if (r0 == null) goto L8;
        r0.onClick(r4);
    L8:
        super.onClick(r4);
    }

    public final void s(Integer r8) {
        int r1 = 2131251247;
        if (((Boolean) this.g.get("data_more_dialog_is_show_interact_more", Boolean.FALSE)).booleanValue() == true) goto L13;
        this.N.setBackgroundResource(0);
        LottieAnimationView r9 = this.N;
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.g) == false) goto L7;
    L10:
        r9.setImageResource(r1);
        q();
        return;
    L7:
        if (VSMediaUIConfigHelper.b(this.g) == true) goto L10;
        r1 = 2131251244;
        goto L10
    L13:
        if (r8.intValue() != 1) goto L16;
        long r0 = com.bytedance.android.livesdk.config.o.a.getValue().interactIcWaitingId;
        LottieAnimationView r10 = this.N;
        q0 r5 = new q0(this, r10.getContext(), r10);
        jc1.k.f(IGiftServiceExternal.class).getAssetsManager().j4(r0, r5, 2);
        this.N.setBackgroundResource(2131250014);
    L29:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.g) == false) goto L31;
    L32:
        this.N.setBackgroundResource(0);
    L33:
        q();
        return;
    L31:
        if (VSMediaUIConfigHelper.b(this.g) == false) goto L33;
    L16:
        if (r8.intValue() != 2) goto L18;
        long r2 = com.bytedance.android.livesdk.config.o.a.getValue().interactIcCallingId;
        LottieAnimationView r11 = this.N;
        q0 r6 = new q0(this, r11.getContext(), r11);
        jc1.k.f(IGiftServiceExternal.class).getAssetsManager().j4(r2, r6, 2);
        this.N.setBackgroundResource(2131250014);
        goto L29
    L18:
        Disposable r12 = this.R;
        if (r12 == null) goto L21;
        r12.dispose();
    L21:
        this.N.clearAnimation();
        this.N.setBackgroundResource(0);
        LottieAnimationView r13 = this.N;
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.g) == false) goto L24;
    L27:
        r13.setImageResource(r1);
        goto L29
    L24:
        if (VSMediaUIConfigHelper.b(this.g) == true) goto L27;
        r1 = 2131251244;
        goto L27
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r1, DataCenter r2) {
        super.R9(r1, r2);
        hd0.c.f().e(this.S);
        r();
        this.g.removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r5, DataCenter r6) {
        super.p4(r5, r6);
        p9 r0 = new p9(this.l, false, true);
        r0.a = this.f;
        List<ToolbarButton> r1 = this.d;
        Intrinsics.checkNotNullParameter(r1, "stableAreaStateConfigList");
        r0.b = r1;
        Dialog r2 = r0.a();
        this.h = r2;
        r2.setOnDismissListener(new l0());
        this.h.setDataCenter(this.g);
        this.M = r5;
        LottieAnimationView r7 = r5.findViewById(2131380329);
        this.N = r7;
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r6) == false) goto L5;
    L8:
        int r8 = 2131251247;
    L9:
        r7.setImageResource(r8);
        hd0.c.f().c(this.S);
        this.g.observe("cmd_apply_tips", this);
        this.g.observe("cmd_dismiss_apply_popup", this);
        this.g.observe("data_more_dialog_is_show_interact_more", this);
        q();
        return;
    L5:
        if (VSMediaUIConfigHelper.b(r6) == true) goto L8;
        r8 = 2131251248;
        goto L9
    }

    public LandscapeToolbarMoreBehavior(Context r1, DataCenter r2, View.OnClickListener r3) {
        super(r1, r2);
        this.P = 2.0f;
        this.Q = 5.0f;
        this.S = new a(this);
        this.L = r3;
    }
}
