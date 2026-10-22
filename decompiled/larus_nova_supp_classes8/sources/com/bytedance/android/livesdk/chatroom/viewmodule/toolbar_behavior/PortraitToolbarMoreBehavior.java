package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.p9;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoadResultType;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleController;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.config.ic;
import com.bytedance.android.livesdk.config.jv;
import com.bytedance.android.livesdk.config.kc;
import com.bytedance.android.livesdk.config.kv;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class PortraitToolbarMoreBehavior extends AbsToolbarMoreBehavior {
    public static final /* synthetic */ int v1 = 0;
    public f0 H0;
    public View L;
    public boolean L0;
    public LottieAnimationView M;
    public TextView N;
    public boolean O;
    public yo2.e P;
    public BubbleController P0;
    public final float Q;
    public final float R;
    public Disposable S;
    public boolean T;
    public RevPkState U;
    public int V;
    public final CompositeDisposable V0;
    public boolean W;
    public boolean X;
    public Disposable Y;
    public Disposable Z;
    public String b1;
    public final b g1;
    public final c h1;
    public SimpleDraweeView k0;
    public final d k1;
    public FrameLayout p0;
    public Disposable p1;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ PortraitToolbarMoreBehavior a;

        public a(PortraitToolbarMoreBehavior r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            this.a.M.clearAnimation();
            this.a.k0.setBackgroundResource(0);
            PortraitToolbarMoreBehavior r5 = this.a;
            r5.M.setImageResource(r5.v());
            this.a.M.removeAllAnimatorListeners();
            com.bytedance.android.live.core.utils.h.c(this.a.M, new float[]{1.0f}).setDuration(500).start();
        }
    }

    public class b implements Observer<Integer> {
        public final /* synthetic */ PortraitToolbarMoreBehavior a;

        public b(PortraitToolbarMoreBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            PortraitToolbarMoreBehavior r0 = this.a;
            if (r0.M == null) goto L7;
            r0.y(r4);
            return;
        }
    }

    public class c implements com.ss.android.ugc.aweme.compat.nullable.Observer<RevPkState> {
        public final /* synthetic */ PortraitToolbarMoreBehavior a;

        public c(PortraitToolbarMoreBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            RevPkState r4 = (RevPkState) r3;
            PortraitToolbarMoreBehavior r0 = this.a;
            r0.U = r4;
            if (r4 == RevPkState.DISABLE) goto L24;
            if (r4 == RevPkState.FINISHED) goto L24;
            if (r4 != RevPkState.PK) goto L27;
            Room r5 = r0.q;
            if (r5 != null) goto L12;
        L14:
            Room r6 = jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().b();
            if (r6 != null) goto L17;
        L19:
            r0.X = false;
        L21:
            if (r0.L0 == true) goto L28;
            jc1.k.f(IHostBusiness.class).fetchLivePkFansGroupList();
            r0.L0 = true;
            return;
        L28:
            return;
        L17:
            if (r6.getRoomSecretStatus() != 1) goto L19;
            r0.X = true;
            goto L21
        L12:
            if (r5.getRoomSecretStatus() != 1) goto L14;
            r0.X = true;
            goto L21
        L27:
            return;
        L24:
            if (r0.W == false) goto L30;
            r0.u();
            return;
        }
    }

    public class d implements com.ss.android.ugc.aweme.compat.nullable.Observer<Long> {
        public final /* synthetic */ PortraitToolbarMoreBehavior a;

        public d(PortraitToolbarMoreBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Long r7 = (Long) r6;
            kv r0 = kv.a;
            if (r0.getValue().b() == true) goto L6;
            return;
        L6:
            if (this.a.U == RevPkState.PK) goto L9;
            return;
        L9:
            if (r7.longValue() != r0.getValue().a()) goto L40;
            PortraitToolbarMoreBehavior r8 = this.a;
            if (((Boolean) r8.g.get("data_is_anchor", Boolean.FALSE)).booleanValue() == true) goto L14;
            return;
        L14:
            if (r8.X == false) goto L16;
            return;
        L16:
            if (r8.k0 != null) goto L18;
            return;
        L18:
            if (r8.T == false) goto L20;
            return;
        L20:
            if (r8.W == false) goto L23;
            return;
        L23:
            if (r8.V == jv.a.getValue().g()) goto L49;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 r1 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r8.g);
            if ((r1 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) == true) goto L28;
        L30:
            r8.k0.setController(Fresco.newDraweeControllerBuilder().setUri(com.bytedance.android.livesdk.chatroom.utils.i2.c("/share/fansgroup/fast_share_start_animation.webp")).setAutoPlayAnimations(true).setControllerListener(new q1(r8)).build());
            LottieAnimationView r2 = r8.M;
            if (r2 == null) goto L33;
            r2.setVisibility(8);
        L33:
            r8.k0.setVisibility(0);
            r8.l(8);
            r8.W = true;
            if (r8.O == false) goto L38;
            TextView r3 = r8.N;
            if (r3 == null) goto L38;
            r3.setText(2131922489);
        L38:
            r8.V++;
            return;
        L28:
            if (r1.s(ExtendedToolbarButton.e(ToolbarButton.SHARE)) != null) goto L30;
            ALogger.d("PortraitToolbarMoreBehavior", "fans_group_share_behavior_is_null");
            return;
        L49:
            return;
        }
    }

    public class e extends BaseControllerListener<Object> {
        public final /* synthetic */ PortraitToolbarMoreBehavior a;

        public class a extends BaseAnimationListener {
            public int a;
            public final /* synthetic */ Animatable b;
            public final /* synthetic */ e c;

            public final void onAnimationStop(AnimatedDrawable2 r2) {
                SimpleDraweeView r3 = this.c.a.k0;
                if (r3 == null) goto L5;
                r3.setVisibility(8);
            L5:
                LottieAnimationView r4 = this.c.a.M;
                if (r4 == null) goto L8;
                r4.setVisibility(0);
            L8:
                this.c.a.l(0);
                PortraitToolbarMoreBehavior r5 = this.c.a;
                r5.W = false;
                if (r5.O == false) goto L14;
                TextView r6 = r5.N;
                if (r6 == null) goto L15;
                r6.setText(2131914887);
                return;
            L15:
                return;
            }

            public a(e r1, Animatable r2) {
                this.c = r1;
                this.b = r2;
                this.a = -1;
            }

            public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
                if (r2 >= this.a) goto L5;
                this.b.stop();
            L5:
                this.a = r2;
            }
        }

        public e(PortraitToolbarMoreBehavior r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, @Nullable Object r2, @Nullable Animatable r3) {
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            ((AnimatedDrawable2) r3).setAnimationListener(new a(this, r3));
            return;
        }
    }

    public class f implements com.bytedance.android.livesdk.chatroom.utils.a4 {
        public final /* synthetic */ PortraitToolbarMoreBehavior a;

        @Override // com.bytedance.android.livesdk.chatroom.utils.a4
        public final void a(Disposable r1) {
        }

        public f(PortraitToolbarMoreBehavior r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a4
        public final void b(SkinLoadResultType r1, String r2) {
            if (r1 != SkinLoadResultType.START) goto L6;
            this.a.M.setImageResource(0);
            return;
        L6:
            if (r1 != SkinLoadResultType.ERROR) goto L10;
            PortraitToolbarMoreBehavior r3 = this.a;
            r3.M.setImageResource(r3.v());
            return;
        }
    }

    private void w() {
        HashMap r0 = new HashMap();
        if (this.m == false) goto L5;
        String r1 = SourceType.ANCHOR;
    L6:
        r0.put("user_type", r1);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_show_more_function_button", r0, new Object[0]);
        return;
    L5:
        r1 = "user";
        goto L6
    }

    public final void q() {
        FrameLayout r0 = this.p0;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        LottieAnimationView r1 = this.M;
        if (r1 != null) goto L8;
    L11:
        this.T = false;
        if (this.O == false) goto L16;
        TextView r2 = this.N;
        if (r2 == null) goto L16;
        r2.setText(2131914887);
    L16:
        o();
        return;
    L8:
        if (r1.getVisibility() != 8) goto L10;
        this.M.setVisibility(0);
    L10:
        this.M.setBackgroundResource(0);
        this.M.setImageResource(v());
        goto L11
    }

    public final void s() {
        if (ht2.g.f(this.q, 8, true) == false) goto L6;
        this.M.setImageResource(0);
        ht2.g.c(8, this.q, this.L);
    L6:
        if (this.q == null) goto L21;
        SkinLoader.c.getClass();
        if (SkinLoader.a.b() == false) goto L22;
        SkinLoader r0 = SkinLoader.a.d(24, this.q, true);
        ResKeyEnum r1 = ResKeyEnum.STATIC_ICON;
        com.bytedance.android.livesdk.chatroom.utils.x2 r2 = com.bytedance.android.livesdk.chatroom.utils.y2.b(r1);
        Intrinsics.checkNotNullParameter(r2, "resKey");
        Map<String, com.bytedance.android.livesdk.chatroom.utils.v2> r3 = r0.a;
        if (r3 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.utils.v2 r4 = r3.get(r2.a.getKey());
        if (r4 == null) goto L13;
    L14:
        com.bytedance.android.livesdk.chatroom.utils.z2 r5 = SkinLoader.a(r4);
        if (r5 == null) goto L17;
        Observable<Drawable> r6 = r5.a();
    L18:
        if (r6 == null) goto L23;
        r0.c(com.bytedance.android.livesdk.chatroom.utils.y2.b(r1), this.L, new f(this));
        return;
    L23:
        return;
    L17:
        r6 = null;
    L13:
        r4 = r2.b;
        goto L14
    L22:
        return;
    }

    public final void t() {
        yo2.e r0 = this.P;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.h() == false) goto L11;
        this.P.d();
        RoomContext.a r1 = RoomContext.Companion;
        DataCenter r2 = this.g;
        r1.getClass();
        RoomContext r3 = RoomContext.a.a(r2, 0);
        if (r3 == null) goto L12;
        r3.getToolbarBubbleManager().c(new d1());
        return;
    L12:
        return;
    }

    public final void u() {
        if (this.k0 != null) goto L5;
        return;
    L5:
        AbstractDraweeController r0 = Fresco.newDraweeControllerBuilder().setUri(com.bytedance.android.livesdk.chatroom.utils.i2.c("/share/fansgroup/fast_share_end_animation.webp")).setAutoPlayAnimations(true).setControllerListener(new e(this)).setOldController(this.k0.getController()).build();
        this.k0.setController(r0);
    }

    public final int v() {
        Room r0 = this.q;
        boolean r1 = this.m;
        int r2 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.b.a;
        boolean r3 = false;
        if (r1 == false) goto L5;
    L48:
        if (r3 == false) goto L52;
        return 2131253001;
    L52:
        if (this.m == false) goto L54;
    L57:
        int r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.b(Boolean.valueOf(this.m)) == false) goto L61;
        return 2131251249;
    L61:
        return 2131251245;
    L54:
        if (((Boolean) j40.h4.a.getValue()).booleanValue() == false) goto L57;
        return 2131243766;
    L5:
        if (MoreMixSharePanelUtils.INSTANCE.isSettingChangeMoreIcon() == false) goto L48;
        if (r0 == null) goto L48;
        LiveToolbarData r5 = r0.getToolbarData();
        if (r5 == null) goto L48;
        List r6 = r5.getToolbarDataList();
        if (r6 == null) goto L48;
        Iterator r7 = r6.iterator();
    L13:
        Integer r8 = null;
        if (r7.hasNext() == false) goto L21;
        Object r9 = r7.next();
        if (((IToolbarComponentData) r9).getId() != 24) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L13;
    L22:
        IToolbarComponentData r11 = (IToolbarComponentData) r9;
        if (r11 == null) goto L48;
        JsonElement r12 = GsonHelper.parser().parse(r11.getExtraData());     // Catch: Exception -> L47
        if (r12 == null) goto L28;
        JsonObject r13 = r12.getAsJsonObject();     // Catch: Exception -> L47
    L29:
        if (r13 == null) goto L33;
        JsonElement r14 = r13.get("version");     // Catch: Exception -> L47
        if (r14 == null) goto L33;
        Integer r15 = Integer.valueOf(r14.getAsInt());     // Catch: Exception -> L47
    L34:
        if (r13 == null) goto L38;
        JsonElement r16 = r13.get("share_icon");     // Catch: Exception -> L47
        if (r16 == null) goto L38;
        r8 = Integer.valueOf(r16.getAsInt());     // Catch: Exception -> L47
    L38:
        if (r15 == null) goto L48;
        if (r15.intValue() != 1) goto L48;
        if (r8 == null) goto L48;
        if (r8.intValue() != 1) goto L48;
        r3 = true;
    L33:
        r15 = null;
        goto L34
    L28:
        r13 = null;
        goto L29
    L18:
        r10 = false;
        goto L19
    L21:
        r9 = null;
        goto L22
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r5) {
        super.dv(r5);
        if ((r5 instanceof pp1.h) == false) goto L8;
        if (this.k == null) goto L8;
        ((pp1.h) r5).getClass();
        o();
    L8:
        if ((r5 instanceof pp1.c) == false) goto L25;
        Map<String, String> r0 = ((pp1.c) r5).j;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.isEmpty() == false) goto L15;
        return;
    L15:
        if ("new_task".equals(r0.get("from")) == true) goto L17;
        return;
    L17:
        String r1 = r0.get("button");
        ToolbarButton r2 = ToolbarButton.BROADCAST_SHARE;
        if (r2.name().equals(r1) == false) goto L20;
        r(r2);
        goto L25
    L20:
        ToolbarButton r3 = ToolbarButton.BGM;
        if (r3.name().equals(r1) == false) goto L25;
        r(r3);
    L25:
        if ((r5 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.l) == true) goto L27;
        return;
    L27:
        if (this.P0 == null) goto L53;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.l r6 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.l) r5;
        if (ev1.p.c(this.g) == true) goto L56;
        final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r7 = r6.a;
        this.b1 = "null";
        BubbleController r4 = this.P0;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "bubble");
        List r8 = (List) r4.c.getValue();
        if ((r8 instanceof Collection) == true) goto L34;
    L36:
        Iterator r9 = r8.iterator();
    L38:
        if (r9.hasNext() == false) goto L42;
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.j) r9.next()).a(r7) == false) goto L38;
        boolean r10 = true;
    L43:
        if (r10 == true) goto L54;
        Function1 r11 = new c1(this, r7);
        RoomContext.a r12 = RoomContext.Companion;
        DataCenter r13 = this.g;
        r12.getClass();
        RoomContext r14 = RoomContext.a.a(r13, 0);
        if (r14 == null) goto L55;
        r14.getToolbarBubbleManager().c(r11);
        return;
    L55:
        return;
    L54:
        return;
    L42:
        r10 = false;
        goto L43
    L34:
        if (r8.isEmpty() == false) goto L36;
    L56:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior
    public final void k(KVData r7) {
        super.k(r7);
        if (r7 != null) goto L5;
        return;
    L5:
        String r0 = r7.getKey();
        r0.getClass();
        byte r5 = -1;
        switch(r0.hashCode()) {
            case 170235087: goto L25;
            case 220810209: goto L21;
            case 774252942: goto L17;
            case 860779896: goto L13;
            case 1120089041: goto L9;
            default: goto L28;
        };
    L28:
        switch(r5) {
            case 0: goto L48;
            case 1: goto L47;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            default: goto L59;
        };
    L33:
        z((pp1.c) r7.getData());
        return;
    L47:
        t();
        return;
    L48:
        y((Integer) ((ge1.a) hd0.c.f()).b);
        return;
    L59:
        return;
    L31:
        if (this.m == true) goto L52;
        z((pp1.c) r7.getData());
        return;
    L52:
        return;
    L35:
        if (tb1.c.c == false) goto L38;
        return;
    L38:
        if (this.L == null) goto L55;
        com.bytedance.android.livesdk.chatroom.utils.p.b.getClass();
        HashMap r8 = new HashMap();
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_connection_guide_show", r8, new Object[]{am2.x.class, Room.class});
        t();
        View r9 = LayoutInflater.from(this.M.getContext()).inflate(2131567814, null);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        ((TextView) r9.findViewById(2131363198)).setOnClickListener(new l1(this));
        yo2.e r1 = new yo2.e(this.M.getContext());
        ((yo2.d) r1).d = r9;
        ((yo2.d) r1).e = 0;
        ((yo2.d) r1).m = 5;
        ((yo2.d) r1).l = true;
        ((yo2.d) r1).b = new m1(this);
        r1.a();
        this.P = r1;
        this.L.post(new n1(this));     // Catch: Exception -> L42
    L44:
        this.g.put("cmd_send_show_apply_popup_success", Boolean.TRUE);
        RoomContext.a r10 = RoomContext.Companion;
        DataCenter r2 = this.g;
        r10.getClass();
        RoomContext r11 = RoomContext.a.a(r2, 0);
        if (r11 == null) goto L56;
        r11.getToolbarBubbleManager().c(new i1());
        return;
    L56:
        return;
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L55:
        return;
    L9:
        if (r0.equals("cmd_show_self_bubble_on_openplatform_behavior") == false) goto L28;
        r5 = 4;
        goto L28
    L13:
        if (r0.equals("cmd_show_self_bubble_on_more") == false) goto L28;
        r5 = 3;
        goto L28
    L17:
        if (r0.equals("cmd_apply_tips") == false) goto L28;
        r5 = 2;
        goto L28
    L21:
        if (r0.equals("cmd_dismiss_apply_popup") == false) goto L28;
        r5 = 1;
        goto L28
    L25:
        if (r0.equals("data_more_dialog_is_show_interact_more") == false) goto L28;
        r5 = 0;
        goto L28
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        k((KVData) r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, android.view.View.OnClickListener
    public final void onClick(View r6) {
        ILoginGuideService r0 = ILoginGuideService.-CC.ins();
        q61.b.a r1 = new q61.b.a(cz.c.i.c);
        r1.a("bubble_type", this.b1);
        if (r0.intercept(new q61.c(r1)) == false) goto L6;
        return;
    L6:
        if (this.m == true) goto L11;
        f0 r2 = this.H0;
        if (r2 == null) goto L11;
        boolean r3 = r2.e;
    L13:
        if (r3 == false) goto L28;
        if (this.H0 == null) goto L64;
        DataCenter r7 = this.g;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(r7).t(ToolbarButton.SHARE);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r8 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r7);
        if ((r8 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) == true) goto L19;
        r8 = null;
    L19:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3 r9 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) r8;
        if (r9 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r10 = r9.t(ToolbarButton.SHARE);
    L23:
        if (r4 == null) goto L25;
        r4.onClick(null);
        return;
    L25:
        if (r10 == null) goto L66;
        r10.onClick(null);
        return;
    L66:
        return;
    L22:
        r10 = null;
        goto L23
    L64:
        return;
    L28:
        if (this.T == false) goto L38;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 r11 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g);
        if ((r11 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) == false) goto L33;
        r11.s(ExtendedToolbarButton.e(ToolbarButton.SHARE)).onClick(null);
        com.bytedance.android.livesdk.log.u.l().d("livesdk_share_guide_click", new Object[]{Room.class});
    L33:
        if (kc.a.getValue().booleanValue() == false) goto L68;
        Disposable r12 = this.Z;
        if (r12 == null) goto L69;
        r12.dispose();
        this.Z = null;
        q();
        return;
    L69:
        return;
    L68:
        return;
    L38:
        if (this.W == false) goto L60;
        com.bytedance.android.livesdk.log.u.l().b("livesdk_live_quickshareicon_click");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3 r13 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g);
        if ((r13 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) == false) goto L71;
        DataCenter r5 = this.g;
        Boolean r14 = Boolean.TRUE;
        r5.put("data_is_fans_group_share", r14);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r15 = r13.s(ExtendedToolbarButton.e(ToolbarButton.SHARE));
        if (r15 == null) goto L44;
        r15.onClick(null);
    L45:
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.b.r;
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r14);
        SimpleDraweeView r17 = this.k0;
        if (r17 == null) goto L48;
        r17.setVisibility(8);
    L48:
        LottieAnimationView r18 = this.M;
        if (r18 == null) goto L51;
        r18.setVisibility(0);
    L51:
        l(0);
        Disposable r19 = this.Y;
        if (r19 == null) goto L54;
        r19.dispose();
        this.Y = null;
    L54:
        this.Y = Observable.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j1(this), new g60.c());
        this.W = false;
        if (this.O == false) goto L72;
        TextView r20 = this.N;
        if (r20 == null) goto L73;
        r20.setText(2131914887);
        return;
    L73:
        return;
    L72:
        return;
    L44:
        ALogger.d("PortraitToolbarMoreBehavior", "fans_group_share_behavior_is_null");
        goto L45
    L71:
        return;
    L60:
        if (this.h != null) goto L62;
        p9 r21 = new p9(this.l, ((Boolean) this.g.get("data_is_anchor", Boolean.FALSE)).booleanValue(), false);
        r21.a = this.f;
        List<ToolbarButton> r22 = this.d;
        Intrinsics.checkNotNullParameter(r22, "stableAreaStateConfigList");
        r21.b = r22;
        List<ToolbarButton> r23 = this.e;
        Intrinsics.checkNotNullParameter(r23, "interactConfigList");
        r21.c = r23;
        com.bytedance.android.livesdk.utils.y1 r24 = r21.a();
        this.h = r24;
        r24.setDataCenter(this.g);
    L62:
        super.onClick(r6);
        return;
    L11:
        r3 = false;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior
    public final void onMessage(tlc.d r7) {
        if ((r7 instanceof com.bytedance.android.livesdk.message.model.l) == false) goto L27;
        if (this.q.getBaseOwner().getSecret() != 1) goto L8;
        return;
    L8:
        if (((com.bytedance.android.livesdk.message.model.l) r7).E().b() == 1) goto L10;
        return;
    L10:
        if (this.W == false) goto L13;
        return;
    L13:
        if (this.M == null) goto L46;
        RoomContext.a r8 = RoomContext.Companion;
        DataCenter r0 = this.g;
        long r2 = this.q.getId();
        r8.getClass();
        RoomContext r9 = RoomContext.a.a(r0, r2);
        if (r9 != null) goto L18;
    L20:
        this.M.setRepeatCount(0);
        this.M.setAnimation("share/guide.json");
        this.M.setBackgroundResource(2131250014);
        this.M.playAnimation();
        this.M.addAnimatorListener(new r1(this));
        this.T = true;
        if (this.O == false) goto L25;
        TextView r10 = this.N;
        if (r10 == null) goto L25;
        r10.setText(2131922489);
    L25:
        l(8);
        com.bytedance.android.livesdk.log.u.l().d("livesdk_share_guide_show", new Object[]{Room.class});
        return;
    L18:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r9.getVoiceTalkRoomSubScene().getValue()).t().a != 10) goto L20;
        return;
    L46:
        return;
    L27:
        if ((r7 instanceof com.bytedance.android.livesdk.message.model.l5) == false) goto L40;
        com.bytedance.android.livesdk.message.model.l5 r11 = (com.bytedance.android.livesdk.message.model.l5) r7;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(this.m) == false) goto L48;
        this.i = r11.G();
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.g.a;
        Long r3 = Long.valueOf(r11.G());
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r3);
        com.bytedance.android.livesdk.chatroom.model.interact.c r4 = r11.E();
        com.bytedance.android.livesdk.sharedpref.e r5 = com.bytedance.android.livesdk.sharedpref.g.b;
        if (r4 == null) goto L34;
        long r6 = r4.a();
    L35:
        Long r12 = Long.valueOf(r6);
        r5.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r12);
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.g.c;
        if (r4 == null) goto L38;
        ImageModel r14 = r4.b();
    L39:
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r14);
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.g.d;
        List r16 = r11.getGiftIds();
        r15.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r15, r16);
        long r17 = System.currentTimeMillis() / 1000;
        com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.g.e;
        Long r19 = Long.valueOf(r17);
        r18.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r18, r19);
        x(true);
        o();
        w();
        return;
    L38:
        r14 = new ImageModel();
        goto L39
    L34:
        r6 = -1;
        goto L35
    L48:
        return;
    L40:
        super.onMessage(r7);
    }

    public final void r(ToolbarButton r4) {
        if (this.M != null) goto L5;
        return;
    L5:
        if (this.k0 == null) goto L10;
        this.M.setImageResource(r4.getBroadcastDrawableFolded());
        this.k0.setBackgroundResource(2131250014);
        AnimatorSet r5 = com.bytedance.android.live.core.utils.h.c(this.M, new float[]{0.1f}).setDuration(500);
        r5.setStartDelay(1000);
        r5.addListener(new a(this));
        r5.start();
        return;
    }

    public final void x(boolean r5) {
        Set<ToolbarButton> r0 = this.c;
        HashSet r1 = (HashSet) r0;
        if (r1.contains(ToolbarButton.BROADCAST_GIFT) == false) goto L6;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.g).b(ToolbarButton.BROADCAST_GIFT, new pp1.j(r5, this.m));
        return;
    }

    public final void y(Integer r7) {
        if (this.M != null) goto L6;
        return;
    L6:
        if (((Boolean) this.g.get("data_more_dialog_is_show_interact_more", Boolean.FALSE)).booleanValue() == true) goto L10;
        this.M.setBackgroundResource(0);
        this.M.setImageResource(v());
        s();
        return;
    L10:
        if (r7.intValue() != 1) goto L13;
        long r0 = com.bytedance.android.livesdk.config.o.a.getValue().interactIcWaitingId;
        LottieAnimationView r8 = this.M;
        w1 r5 = new w1(this, r8.getContext(), r8);
        jc1.k.f(IGiftServiceExternal.class).getAssetsManager().j4(r0, r5, 2);
        this.M.setBackgroundResource(2131250014);
    L19:
        s();
        return;
    L13:
        if (r7.intValue() != 2) goto L15;
        long r1 = com.bytedance.android.livesdk.config.o.a.getValue().interactIcCallingId;
        LottieAnimationView r9 = this.M;
        w1 r6 = new w1(this, r9.getContext(), r9);
        jc1.k.f(IGiftServiceExternal.class).getAssetsManager().j4(r1, r6, 2);
        this.M.setBackgroundResource(2131250014);
        goto L19
    L15:
        Disposable r10 = this.S;
        if (r10 == null) goto L18;
        r10.dispose();
    L18:
        this.M.clearAnimation();
        this.M.setBackgroundResource(0);
        this.M.setImageResource(v());
        goto L19
    }

    public final void z(pp1.c r7) {
        if (RoomContext.getShared(this.g) != null) goto L5;
        return;
    L5:
        if (RoomContext.getShared(this.g).getToolbarBubbleManager().getValue() == null) goto L9;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0) RoomContext.getShared(this.g).getToolbarBubbleManager().getValue()).addBubbleLocal(r7, r7.k, new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.q2(this.g, this.l, this.L), new e1());
        return;
    }

    public PortraitToolbarMoreBehavior(Context r1, DataCenter r2) {
        super(r1, r2);
        this.Q = 2.0f;
        this.R = 5.0f;
        this.L0 = false;
        this.V0 = new CompositeDisposable();
        this.b1 = "null";
        this.g1 = new b(this);
        this.h1 = new c(this);
        this.k1 = new d(this);
        this.p1 = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r3, DataCenter r4) {
        super.R9(r3, r4);
        t();
        hd0.c.f().e(this.g1);
        this.g.removeObserver(this);
        if (jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal() == null) goto L5;
        jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().c(this.h1);
        jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().f(this.k1);
    L5:
        f0 r5 = this.H0;
        if (r5 == null) goto L8;
        r5.e = false;
        r5.c.clear();
    L8:
        Disposable r6 = this.S;
        if (r6 == null) goto L11;
        r6.dispose();
    L11:
        this.h = null;
        if (this.M != null) goto L14;
    L16:
        BubbleController r7 = this.P0;
        if (r7 == null) goto L24;
        Iterator<T> r0 = r7.a().iterator();
    L20:
        if (r0.hasNext() == false) goto L22;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h) r0.next()).onUnload();
        goto L20
    L22:
        r7.d.clear();
        this.P0 = null;
    L24:
        if (this.m == false) goto L38;
        Disposable r8 = this.p1;
        if (r8 == null) goto L31;
        if (r8.isDisposed() == true) goto L31;
        this.p1.dispose();
        this.p1 = null;
    L31:
        if (kc.a.getValue().booleanValue() == false) goto L38;
        if (jc1.k.f(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.e.class) == null) goto L35;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.e) jc1.k.f(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.e.class)).S4();
    L35:
        Disposable r9 = this.Z;
        if (r9 == null) goto L38;
        r9.dispose();
        this.Z = null;
    L38:
        this.V0.clear();
        return;
    L14:
        if (((Boolean) r4.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L16;
        this.M.removeAllAnimatorListeners();
        goto L16
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.AbsToolbarMoreBehavior, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r12, final DataCenter r13) {
        super.p4(r12, r13);
        this.V = 0;
        boolean r1 = ((Boolean) r13.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(r1) == false) goto L9;
        long r5 = ((Long) com.bytedance.android.livesdk.sharedpref.g.a.getValue()).longValue();
        this.i = r5;
        if (r5 < 0) goto L7;
        x(true);
        w();
        goto L9
    L7:
        x(false);
    L9:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4.b(r1) == false) goto L17;
        long r6 = ((Long) com.bytedance.android.livesdk.sharedpref.g.e.getValue()).longValue();
        long r7 = System.currentTimeMillis() / 1000;
        if (r6 <= 0) goto L17;
        if ((r7 - r6) < 604800) goto L17;
        if (this.i < 0) goto L17;
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.g.a;
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, -1L);
    L17:
        p9 r3 = new p9(this.l, r1, false);
        r3.a = this.f;
        List<ToolbarButton> r0 = this.d;
        Intrinsics.checkNotNullParameter(r0, "stableAreaStateConfigList");
        r3.b = r0;
        List<ToolbarButton> r4 = this.e;
        Intrinsics.checkNotNullParameter(r4, "interactConfigList");
        r3.c = r4;
        com.bytedance.android.livesdk.utils.y1 r8 = r3.a();
        this.h = r8;
        r8.setDataCenter(this.g);
        this.L = r12;
        this.M = r12.findViewById(2131380329);
        this.k0 = r12.findViewById(2131380330);
        this.p0 = (FrameLayout) r12.findViewById(2131363653);
        s();
        if (r1 == false) goto L20;
    L25:
        hd0.c.f().c(this.g1);
        this.g.observe("cmd_apply_tips", this);
        this.g.observe("cmd_dismiss_apply_popup", this);
        this.g.observe("data_more_dialog_is_show_interact_more", this);
        this.g.observe("cmd_show_self_bubble_on_more", this);
        vlc.d r14 = (vlc.d) this.g.get("data_message_manager");
        if (r14 == null) goto L30;
        if (r1 == false) goto L30;
        r14.addMessageListener(MessageType.ANCHOR_BOOST_MESSAGE.getIntType(), this);
        r14.addMessageListener(MessageType.GIFT_CYCLE_RELEASE_MESSAGE.getIntType(), this);
    L30:
        if (jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal() == null) goto L32;
        jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().a(this.h1);
        jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().E(this.k1);
    L32:
        if (r1 == true) goto L34;
        r13.observe("cmd_show_self_bubble_on_openplatform_behavior", this);
    L34:
        boolean r15 = ic.a.getValue().booleanValue();
        this.O = r15;
        if (r15 == false) goto L39;
        View r16 = this.L;
        if (r16 == null) goto L39;
        this.N = (TextView) r16.findViewById(2131389066);
    L39:
        RoomContext.a r9 = RoomContext.Companion;
        r9.getClass();
        BubbleController r17 = new BubbleController(new BubbleEnv(RoomContext.a.c(r9, r13, 0, 2), r13));
        this.P0 = r17;
        MorePanelDynamicControllerViewModel.Companion r18 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r10 = r17.e.c;
        r18.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k r19 = MorePanelDynamicControllerViewModel.Companion.a(r10);
        if (r19 == null) goto L42;
        r19.setBubbleEnv(r17.e);
    L42:
        if (r19 == null) goto L48;
        Observable<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> r11 = r19.getOnGuideButtonClick();
        if (r11 == null) goto L48;
        Disposable r20 = r11.subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.d(r17));
        if (r20 == null) goto L48;
        RxUtilKt.c(r20, r17.d);
    L48:
        if (r19 == null) goto L54;
        Observable<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b> r110 = r19.getOnGuideEffectShow();
        if (r110 == null) goto L54;
        Disposable r111 = r110.subscribe(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.e(r17));
        if (r111 == null) goto L54;
        RxUtilKt.c(r111, r17.d);
    L54:
        this.L.post(new g1(this));
        if (r1 == true) goto L57;
        return;
    L57:
        if (kc.a.getValue().booleanValue() == true) goto L59;
        return;
    L59:
        if (jc1.k.f(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.e.class) == null) goto L64;
        this.p1 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.e) jc1.k.f(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.e.class)).R2().observeOn(AndroidSchedulers.mainThread()).subscribe(new h1(this));
        return;
    L64:
        return;
    L20:
        if (com.bytedance.android.livesdk.config.setting.o.b() == false) goto L25;
        final View r112 = r12.findViewById(2131380324);
        if (this.M == null) goto L25;
        if (r112 == null) goto L25;
        r112.post(new f1(this, r13, r112));
        goto L25
    }
}
