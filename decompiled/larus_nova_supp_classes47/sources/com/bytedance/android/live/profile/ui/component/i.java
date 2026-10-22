package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.DslTemplate;
import com.bytedance.android.live.base.model.user.EcomInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileOpenArea;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.LiveExternalScene;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements com.bytedance.android.live.profile.ui.base.g {
    public final com.bytedance.android.live.profile.a a;
    public final Fragment b;
    public final FrameLayout c;
    public yt1.k d;
    public yt1.o e;
    public boolean f;
    public boolean g;
    public final com.bytedance.android.live.profile.ui.base.l h;

    public static final class a implements yt1.m {
        public final /* synthetic */ i a;
        public final /* synthetic */ yt1.n b;
        public final /* synthetic */ FrameLayout c;

        public final void onFetchSuccess() {
        }

        public a(i r1, yt1.n r2, FrameLayout r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(com.bytedance.android.livesdk.dslservice.a r1, boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "loadFrom");
            Intrinsics.checkNotNullParameter(r3, "loadFrom");
            i r4 = this.a;
            r4.g = true;
            if (r4.f == false) goto L8;
            yt1.k r5 = r4.d;
            if (r5 == null) goto L9;
            r5.b(au1.a.c.b, true);
            return;
        L9:
            return;
        }

        public final void b(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, "reason");
            yt1.m.a.a(r1, r2);
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void e(ProfileSkin r1) {
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void f() {
    }

    public final void a() {
        FrameLayout r0 = this.c;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        yt1.o r1 = this.e;
        if (r1 == null) goto L18;
        yt1.q r2 = r1.b;
        if (r2 == null) goto L18;
        IRoomContextService r3 = jc1.k.f(IRoomContextService.class);
        if (r3 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.q r4 = IRoomContextService.a.b(r3, null, 3);
        if (r4 == null) goto L18;
        com.bytedance.live.datacontext.j r5 = r4.E1();
        if (r5 == null) goto L18;
        yt1.n r6 = (yt1.n) r5.getValue();
        if (r6 == null) goto L18;
        r6.a(r2, this.d);
    L18:
        this.e = null;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.DSLShopComponent.INSTANCE;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        a();
    }

    public i(com.bytedance.android.live.profile.ui.base.l r2) {
        Intrinsics.checkNotNullParameter(r2, "hostBehavior");
        this.h = r2;
        this.a = r2.a();
        this.b = r2.getHostFragment();
        Fragment r3 = r2.getHostFragment();
        if (r3 == null) goto L7;
        View r4 = r3.getView();
        if (r4 == null) goto L7;
        FrameLayout r5 = (FrameLayout) r4.findViewById(2131380847);
    L8:
        this.c = r5;
        if (r5 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r5);
        return;
    L12:
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r4) {
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter(r4, "user");
        this.f = true;
        if (this.g == false) goto L7;
        yt1.k r1 = this.d;
        if (r1 == null) goto L7;
        r1.b(au1.a.c.b, true);
    L7:
        EcomInfo r5 = r4.ecomInfo;
        if (r5 == null) goto L10;
        int r6 = r5.getEcomType();
        this.h.a().showShopEntrance(r6, "live_personal_button");
    L10:
        this.h.b().recordBusinessShow(TrackArea.BottomOperatingArea, "shop");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r12) {
        Intrinsics.checkNotNullParameter(r12, "user");
        com.bytedance.android.live.profile.profilecontext.a r0 = this.h.b();
        if (r0 == null) goto L7;
        ProfileMonitor r1 = r0.getProfileMonitor();
        if (r1 == null) goto L7;
        r1.d(DataType.IsShopDSL, DataType.TRUE);
    L7:
        FrameLayout r2 = this.c;
        if (r2 != null) goto L10;
        return;
    L10:
        IRoomContextService r3 = jc1.k.f(IRoomContextService.class);
        if (r3 == null) goto L113;
        final Integer r4 = null;
        com.bytedance.android.livesdk.chatroom.q r5 = IRoomContextService.a.b(r3, null, 3);
        if (r5 == null) goto L114;
        com.bytedance.live.datacontext.j r6 = r5.E1();
        if (r6 == null) goto L115;
        yt1.n r7 = (yt1.n) r6.getValue();
        if (r7 == null) goto L116;
        Context r8 = this.h.getHostFragment().getContext();
        if (r8 != null) goto L23;
        r8 = r2.getContext();
    L23:
        if (r8 != null) goto L25;
        yt1.r r9 = null;
    L47:
        Integer r10 = (Integer) j0.a.getValue();
        String r13 = "";
        if (r10 != null) goto L51;
    L69:
        DslTemplate r14 = r12.ecomBottomCardDsl;
        if (r14 == null) goto L96;
        String r15 = r14.template;
        if (r15 != null) goto L74;
        r15 = "";
    L74:
        Integer r16 = (Integer) ev1.e.a.getValue();
        if (r16 != null) goto L78;
    L80:
        yt1.o.a r17 = yt1.o.e;
        String r18 = r14.template_hash;
        if (r18 != null) goto L83;
        r18 = "";
    L83:
        r17.getClass();
        yt1.o r19 = yt1.o.a.a("shop_card_slice", r18, r15);
    L84:
        this.e = r19;
        String r20 = r14.data;
        if (r20 == null) goto L88;
        r13 = r20;
    L88:
        Context r22 = this.h.getHostFragment().getContext();
        if (r22 != null) goto L91;
        r22 = r2.getContext();
    L91:
        yt1.k r23 = r7.c(r19, r13, r22, r9, null);
        this.d = r23;
        if (r23 == null) goto L96;
        View r24 = r23.getView();
        if (r24 == null) goto L96;
        r2.addView(r24);
        goto L96
    L78:
        if (r16.intValue() != 2) goto L80;
        String r25 = ns0.d.a;
        yt1.o.e.getClass();
        Intrinsics.checkNotNullParameter("shop_card_slice", "id");
        Intrinsics.checkNotNullParameter(r25, "url");
        r19 = new yt1.o(new yt1.q("shop_card_slice", r25), new yt1.p(null, r25, 1), "LynxAir");
    L96:
        EcomInfo r110 = r12.ecomInfo;
        if (r110 == null) goto L99;
        r4 = Integer.valueOf(r110.getEcomType());
    L99:
        yt1.k r111 = this.d;
        View r26 = r2;
        if (r111 == null) goto L105;
        View r112 = r111.getView();
        r26 = r2;
        if (r112 == null) goto L105;
        r26 = r112;
    L105:
        if (r4 == null) goto L117;
        r26.setOnClickListener(new w0(new ProfileDSLShopComponent$bindClick$1(this, r4), 500));
        return;
    L117:
        return;
    L51:
        if (r10.intValue() != 1) goto L69;
        a1.k(r2, -2);
        ProfileOpenArea r113 = r12.openArea;
        if (r113 == null) goto L109;
        LiveDSLModel r114 = r113.ecomCardModel;
        if (r114 == null) goto L110;
        yt1.o.e.getClass();
        yt1.o r27 = yt1.o.a.b(r114);
        this.e = r27;
        String r115 = r114.getDslData();
        if (r115 == null) goto L60;
        r13 = r115;
    L60:
        Context r116 = this.h.getHostFragment().getContext();
        if (r116 != null) goto L63;
        r116 = r2.getContext();
    L63:
        yt1.k r117 = r7.c(r27, r13, r116, r9, new a(this, r7, r2));
        this.d = r117;
        if (r117 == null) goto L111;
        View r118 = r117.getView();
        if (r118 == null) goto L112;
        r2.addView(r118);
        return;
    L112:
        return;
    L111:
        return;
    L110:
        return;
    L109:
        return;
    L25:
        com.bytedance.android.live.profile.ui.base.l r28 = this.h;
        if (r28 == null) goto L32;
        com.bytedance.android.live.profile.profilecontext.a r29 = r28.b();
        if (r29 == null) goto L32;
        DataCenter r30 = r29.getRoomDataCenter();
        if (r30 == null) goto L32;
        IExternalConfigJudger r32 = (IExternalConfigJudger) r30.get("data_live_exter_config_judger", null);
    L33:
        if (r32 == null) goto L35;
        int r33 = r32.getCurIndex();
    L37:
        if (r32 == null) goto L45;
        LiveExternalScene r34 = r32.getExternalScene();
        if (r34 == null) goto L45;
        String r35 = r34.getScene();
        if (r35 == null) goto L45;
        if (r35.equals("SCENE_ECOM_SHOP_MULTI") != true) goto L45;
        boolean r36 = true;
    L46:
        j r37 = new j(this, r36, r8);
        yt1.r r38 = new yt1.r();
        r38.a.add(r37);
        r38.c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ecom_shop_live_tab", Boolean.valueOf(r36)), TuplesKt.to("current_room_index", Integer.valueOf(r33))});
        Unit r39 = Unit.INSTANCE;
        r9 = r38;
    L45:
        r36 = false;
        goto L46
    L35:
        r33 = -1;
    L32:
        r32 = null;
        goto L33
    L116:
        return;
    L115:
        return;
    L114:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "newUser");
        a();
        g(r2);
    }
}
