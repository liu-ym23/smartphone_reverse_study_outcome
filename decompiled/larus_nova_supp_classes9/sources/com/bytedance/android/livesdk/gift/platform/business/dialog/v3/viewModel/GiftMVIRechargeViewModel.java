package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import android.content.Context;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelTouchData;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.j0;
import com.bytedance.android.livesdk.gift.platform.business.anchor.AnchorGiftPanelSource;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickRechargeView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftRechargeViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenAnchorGiftPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeIconParams;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeInfoChange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeViewParams;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIRechargeViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftRechargeViewState, GiftAction> implements o {
    public boolean u;
    public final Set<BaseMVIDataStore<?>> v;
    public final DataCenter w;
    public final OpenDialogService x;
    public final u1 y;
    public final GiftDialogStateDataStore z;

    public final void onStop() {
    }

    public static long s1() {
        IRechargeService r0 = jc1.k.f(IRechargeService.class);
        if (r0 == null) goto L7;
        zv0.f r1 = r0.rechargeCenter();
        if (r1 == null) goto L7;
        return r1.getAvailableDiamonds();
    L7:
        return 0;
    }

    public final boolean h1() {
        boolean r0 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin();
        if (((Boolean) nz1.a.n.getValue(null, nz1.a.a[12])).booleanValue() == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (s1() <= 0) goto L11;
    L12:
        if (r0 == false) goto L14;
        if (r1 == true) goto L14;
        return false;
    L14:
        return true;
    L11:
        if (this.u == false) goto L14;
    L5:
        if (u.p() == true) goto L7;
        r1 = true;
        goto L9
    }

    public static boolean e1() {
        yz0.k r0 = u.h();
        if (r0 != null) goto L5;
    L6:
        yz0.k r1 = u.h();
        if (r1 == null) goto L11;
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L11;
        String r3 = r2.getIdString();
    L12:
        yz0.k r4 = u.h();
        if (r4 == null) goto L17;
        IRoom r5 = r4.getRoom();
        if (r5 == null) goto L17;
        String r6 = r5.getAnchorId();
    L19:
        if (Intrinsics.areEqual(r3, r6) == false) goto L26;
    L20:
        ReadOnlyProperty r7 = com.bytedance.android.livesdk.gift.platform.business.anchor.b.b;
        KProperty[] r8 = com.bytedance.android.livesdk.gift.platform.business.anchor.b.a;
        if (((Boolean) r7.getValue(null, r8[0])).booleanValue() == true) goto L23;
        return false;
    L23:
        if ((!StringsKt.isBlank((String) com.bytedance.android.livesdk.gift.platform.business.anchor.b.c.getValue(null, r8[1]))) == false) goto L28;
        return true;
    L28:
        return false;
    L26:
        return false;
    L17:
        r6 = null;
    L11:
        r3 = null;
        goto L12
    L5:
        if (r0.isAnchor() == true) goto L20;
        goto L6
    }

    public static GiftPanelTouchData.a t1() {
        com.bytedance.android.live.profit.privilege.a r0 = yt0.c.i();
        if (r0 == null) goto L9;
        m r1 = r0.getGiftPanelTouchData();
        if (r1 == null) goto L9;
        GiftPanelTouchData r2 = (GiftPanelTouchData) r1.getValue();
        if (r2 == null) goto L9;
        return r2.getRechargeButton();
    L9:
        return null;
    }

    public final void onStart() {
        if (v.e() == true) goto L10;
        u1 r0 = this.y;
        long r1 = s1();
        GiftPanelTouchData.a r3 = t1();
        if (r3 == null) goto L7;
        Map<String, String> r4 = r3.c;
    L8:
        r0.T0(0, r1, r4);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final RechargeIconParams u1() {
        if (h1() == true) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.config.j r0 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r1 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        Object r2 = r0.c(r1, DiamondConfig.a.a());
        if ((r2 instanceof DiamondConfig) == true) goto L9;
        r2 = null;
    L9:
        DiamondConfig r3 = (DiamondConfig) r2;
        if (this.u == false) goto L12;
        int r5 = 8;
    L14:
        if (r3 == null) goto L17;
        py.k r4 = r3.a;
        if (r4 == null) goto L17;
    L19:
        return new RechargeIconParams(r4, 0, r5, 2, null);
    L17:
        r4 = vh7.f.c(py.k.class);
        goto L19
    L12:
        r5 = 0;
        goto L14
    L5:
        return new RechargeIconParams(null, 0, 0, 7, null);
    }

    public final RechargeViewParams w1() {
        if (e1() == false) goto L6;
        return new RechargeViewParams(null, 0, 0.0f, null, true, 15, null);
    L6:
        if (h1() == true) goto L20;
        int r1 = j0.a;
        String r2 = j0.a(s1());
        boolean r3 = this.u;
        if (r3 == false) goto L11;
        float r4 = 14.0f;
    L12:
        if (r3 == false) goto L16;
        GiftPanelTouchData.a r5 = t1();
        if (r5 == null) goto L16;
        a5 r6 = r5.a;
    L18:
        return new RechargeViewParams(r2, 2131107549, r4, r6, false, 16, null);
    L16:
        r6 = null;
        goto L18
    L11:
        r4 = 16.0f;
        goto L12
    L20:
        return new RechargeViewParams(e4.a(), ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_BOTTOM_RECHARGE_COLOR, 2131107550)).intValue(), 14.0f, null, false, 24, null);
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.v;
    }

    public final MVIState F(l0 r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$createState");
        GiftRechargeViewState r0 = new GiftRechargeViewState();
        if (e1() == true) goto L26;
        DataCenter r1 = this.w;
        Boolean r2 = Boolean.TRUE;
        Boolean r3 = (Boolean) r1.get("data_is_portrait", r2);
        boolean r4 = false;
        if (r3 == null) goto L7;
        boolean r5 = r3.booleanValue();
    L9:
        if (u.k(r5) != 2) goto L11;
        r0<GiftRechargeViewState, Boolean> r6 = r0.getShowIncomeToCoins();
        r7.getClass();
        l0.h(r6, r2);
    L11:
        Boolean r8 = (Boolean) this.w.get("data_is_portrait", r2);
        if (r8 == null) goto L14;
        boolean r9 = r8.booleanValue();
    L16:
        if (u.k(r9) == 2) goto L26;
        boolean r10 = vh6.c.b(dr2.a.class).wc();
        zv0.i r11 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), zv0.i.class);
        if (r11 == null) goto L20;
        boolean r13 = r11.h1();
    L21:
        if (r10 == false) goto L24;
        if (r13 == false) goto L24;
        r4 = true;
    L24:
        if (r4 == false) goto L26;
        r0<GiftRechargeViewState, Boolean> r14 = r0.getShowExchangeDouyinDiamond();
        r7.getClass();
        l0.h(r14, r2);
        goto L26
    L20:
        r13 = false;
        goto L21
    L14:
        r9 = false;
        goto L16
    L7:
        r5 = false;
    L26:
        r0<GiftRechargeViewState, RechargeViewParams> r15 = r0.getRechargeViewParams();
        RechargeViewParams r16 = w1();
        r7.getClass();
        l0.h(r15, r16);
        l0.h(r0.getIconViewParams(), u1());
        return r0;
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIRechargeViewModel$bindToParent$1 r0 = GiftMVIRechargeViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r3, MVIState r4) {
        final GiftRechargeViewState r5 = (GiftRechargeViewState) r4;
        Intrinsics.checkNotNullParameter(r3, "$this$reduce");
        Intrinsics.checkNotNullParameter(r5, "state");
        r3.e(this.z.o(), new GiftMVIRechargeViewModel$reduce$2(this, r5));
    }

    public final void y0(l0 r4, MVIState r5, p r6) {
        GiftRechargeViewState r7 = (GiftRechargeViewState) r5;
        GiftAction r8 = (GiftAction) r6;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r8, "action");
        r8.getTag();
        if ((r8 instanceof ClickRechargeView) == false) goto L12;
        OpenDialogService r9 = this.x;
        x2 r10 = new x2("click", "gift_recharge");
        int r11 = OpenDialogService.r;
        Map<String, String> r1 = null;
        r9.i(r10, true, false, null);
        u1 r13 = this.y;
        r13.getClass();
        if (u.p() == false) goto L7;
        r13.p1("dou_coin_click", new LinkedHashMap(), true);
    L7:
        u1 r14 = this.y;
        long r15 = s1();
        GiftPanelTouchData.a r2 = t1();
        if (r2 == null) goto L10;
        r1 = r2.c;
    L10:
        r14.T0(1, r15, r1);
        return;
    L12:
        if ((r8 instanceof RechargeInfoChange) == false) goto L15;
        r0<GiftRechargeViewState, RechargeViewParams> r16 = r7.getRechargeViewParams();
        RechargeViewParams r0 = w1();
        r4.getClass();
        l0.h(r16, r0);
        l0.h(r7.getIconViewParams(), u1());
        return;
    L15:
        if ((r8 instanceof OpenAnchorGiftPanel) == false) goto L24;
        yz0.k r17 = u.h();
        if (r17 == null) goto L25;
        Context r18 = r17.getContext();
        if (r18 == null) goto L26;
        ((com.bytedance.android.livesdk.gift.platform.business.anchor.a) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.business.anchor.a.class)).a(r18, AnchorGiftPanelSource.UserGiftPanel, GiftMVIRechargeViewModel$reduce$1$1.INSTANCE, GiftMVIRechargeViewModel$reduce$1$2.INSTANCE);
        return;
    L26:
        return;
    L25:
        return;
    }

    public GiftMVIRechargeViewModel(DataCenter r2, OpenDialogService r3, u1 r4, GiftDialogStateDataStore r5) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "openDialogService");
        Intrinsics.checkNotNullParameter(r4, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r5, "giftDialogStateDataStore");
        this.w = r2;
        this.x = r3;
        this.y = r4;
        this.z = r5;
        this.v = SetsKt.setOf(r5);
    }
}
