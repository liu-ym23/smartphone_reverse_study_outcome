package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.profit.privilege.model.touch.GrowthTouchData;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.configmodel.a1;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftLynxGrowthTouchState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectGiftHonorData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.updateLynxTopView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVILynxGrowthTouchView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftLynxGrowthTouchState, GiftAction> {
    public ViewGroup m;
    public zy0.b n;
    public final CompositeDisposable o;
    public boolean p;
    public final a1 q;
    public final DataCenter r;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131566143;
    }

    public final void i() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L15
        r0.put("visible", false);     // Catch: JSONException -> L15
        zy0.b r1 = this.n;     // Catch: JSONException -> L15
        if (r1 == null) goto L7;
        xy0.a r2 = r1.g();     // Catch: JSONException -> L15
        if (r2 == null) goto L7;
        r2.sendJsEvent("H5_visibilityChange", r0);     // Catch: JSONException -> L15
    L7:
        ViewGroup r3 = this.m;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L10:
        r3.removeAllViews();
        zy0.b r4 = this.n;
        if (r4 == null) goto L13;
        r4.dispose();
    L13:
        this.o.clear();
    }

    public final Uri t() {
        x0 r1 = new x0(this.q.b());
        x0 r0 = r1.d("url");
        DataCenter r2 = this.r;
        IBaseUser r3 = null;
        if (r2 == null) goto L5;
        IRoom r4 = (IRoom) r2.get("data_room", null);
    L6:
        DataCenter r5 = this.r;
        if (r5 == null) goto L9;
        r3 = (IBaseUser) r5.get("data_user_in_room", null);
    L9:
        r0.b("position", String.valueOf(GrowthTouchData.Position.PositionGiftPanelTop.getValue()));
        r0.b("freq_duration", String.valueOf(this.q.a()));
        String r6 = BuildConfig.FLAVOR;
        if (r4 == null) goto L13;
        String r7 = String.valueOf(r4.getId());
        if (r7 == null) goto L13;
    L14:
        r0.b("room_id", r7);
        if (r3 == null) goto L18;
        String r8 = r3.getIdString();
        if (r8 == null) goto L18;
    L19:
        r0.b("user_id", r8);
        if (r4 == null) goto L25;
        String r9 = r4.getAnchorId();
        if (r9 == null) goto L25;
        r6 = r9;
    L25:
        r0.b("anchor_id", r6);
        return r1.c();
    L18:
        r8 = BuildConfig.FLAVOR;
    L13:
        r7 = BuildConfig.FLAVOR;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    public final void g() {
        this.m = (ViewGroup) r().findViewById(2131373759);
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVILynxGrowthTouchView$bindToParent$1 r0 = GiftMVILynxGrowthTouchView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((r3 instanceof updateLynxTopView) == false) goto L11;
        JSONObject r4 = new JSONObject();
        zy0.b r0 = this.n;
        if (r0 == null) goto L13;
        xy0.a r1 = r0.g();
        if (r1 == null) goto L14;
        r1.sendJsEvent("H5_sendGiftSucceed", r4);
        return true;
    L14:
        return true;
    L13:
        return true;
    L11:
        return false;
    }

    public final void u(Map<String, Object> r5) {
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L8;
        if (this.n == null) goto L8;
        return;
    L8:
        if (com.bytedance.android.live.revenue.common.b0.a().j() == false) goto L10;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r0 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(getContext(), t(), null);
    L11:
        this.n = r0;
        if (r0 == null) goto L20;
        ViewGroup r2 = this.m;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L16:
        r2.addView(r0.c());
        xy0.a r1 = r0.g();
        if (r1 == null) goto L21;
        r1.load(null, r5);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        r0 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), t(), null);
        goto L11
    }

    public final void b(com.bytedance.android.anya.k r10, MVIState r11) {
        GiftLynxGrowthTouchState r13 = (GiftLynxGrowthTouchState) r11;
        Intrinsics.checkNotNullParameter(r10, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r13, "state");
        r0<GiftLynxGrowthTouchState, SelectGiftHonorData> r0 = r13.getGiftSelectData();
        Object r1 = r10.c.a(r0);
        if (r1 == null) goto L11;
        r10.b.a.invoke(r0);
        SelectGiftHonorData r2 = (SelectGiftHonorData) r1;
        JSONObject r3 = new JSONObject();
        if (r2.getShowScore() <= 0) goto L11;
        r3.put("diamond", r2.getShowScore());
        zy0.b r4 = this.n;
        if (r4 == null) goto L11;
        xy0.a r5 = r4.g();
        if (r5 == null) goto L11;
        r5.sendJsEvent("H5_onGiftSelected", r3);
    L11:
        r0<GiftLynxGrowthTouchState, String> r6 = r13.getTouchPositionsStr();
        Object r7 = r10.c.a(r6);
        GsonMap r8 = null;
        if (r7 == null) goto L31;
        r10.b.a.invoke(r6);
        String r9 = (String) r7;
        if (r9.length() <= 0) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == false) goto L31;
        Map r15 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("touch_positions_str", r9)});
        zy0.b r16 = this.n;
        if (r16 != null) goto L28;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r17 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), t(), null);
        if (r17 == null) goto L31;
        this.n = r17;
        ViewGroup r18 = this.m;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L25:
        r18.addView((View) ((BaseHybridComponentContainer) r17).d);
        xy0.a r19 = r17.g();
        if (r19 == null) goto L31;
        r19.load(null, r15);
        goto L31
    L28:
        xy0.a r20 = r16.g();
        if (r20 == null) goto L31;
        r20.updateData(r15);
        goto L31
    L16:
        r14 = false;
    L31:
        r0<GiftLynxGrowthTouchState, Map<String, Object>> r21 = r13.getUserHonorMap();
        Object r23 = r10.c.a(r21);
        if (r23 == null) goto L36;
        r10.b.a.invoke(r21);
        final Map r24 = (Map) r23;
        if ((!r24.isEmpty()) == false) goto L36;
        v02.b.a(0, this.p, new GiftMVILynxGrowthTouchView$handleDiff$$inlined$select$lambda$1(r24, this), 3);
    L36:
        r0<GiftLynxGrowthTouchState, PayGrade> r110 = r13.getPayGrade();
        Object r25 = r10.c.a(r110);
        if (r25 == null) goto L54;
        r10.b.a.invoke(r110);
        PayGrade r26 = (PayGrade) r25;
        if (r26.getScore() <= 0) goto L54;
        if (this.n == null) goto L54;
        Pair[] r111 = new Pair[1];
        JsonElement r112 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r26);
        if ((r112 instanceof JsonObject) == true) goto L45;
        r112 = null;
    L45:
        JsonObject r113 = (JsonObject) r112;
        if (r113 == null) goto L48;
        r8 = UtilsKt.i(r113);
    L48:
        r111[0] = TuplesKt.to("payGrade", r8);
        Map<String, Object> r114 = MapsKt.mutableMapOf(r111);
        zy0.b r115 = this.n;
        if (r115 != null) goto L51;
        u(r114);
        goto L54
    L51:
        xy0.a r116 = r115.g();
        if (r116 == null) goto L54;
        r116.sendJsEvent("H5_updateUserHonor", r114);
    L54:
        this.p = false;
    }

    public GiftMVILynxGrowthTouchView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.r = r4;
        this.o = new CompositeDisposable();
        this.p = true;
        this.q = (a1) nz1.a.v.getValue(null, nz1.a.a[20]);
    }
}
