package com.bytedance.android.live.recharge;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.platform.business.IExchangeStatusService;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.live.kmp.core.KmpEnv;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import zg1.w2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class RechargeService implements IRechargeService {
    private com.bytedance.android.live.recharge.platform.service.v mPayCancelRecoverService;
    private RechargeCurrentCacheData rechargeCurrentCacheData;

    public static /* synthetic */ Map g(WeakReference r0, n56.a r1) {
        return lambda$getRechargeJsFactory$0(r0, r1);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public void clearCurrentRechargeCacheDataObject() {
        this.rechargeCurrentCacheData = null;
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService, com.bytedance.android.live.recharge.k
    public RechargeCurrentCacheData getCurrentRechargeCacheDataObject() {
        if (this.rechargeCurrentCacheData != null) goto L6;
        this.rechargeCurrentCacheData = new RechargeCurrentCacheData();
    L6:
        return this.rechargeCurrentCacheData;
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public k.b getRechargeJsFactory() {
        return new s0();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public boolean isRechargeDialogShowing() {
        boolean r0 = com.bytedance.android.live.recharge.utils.l.a;
        return com.bytedance.android.live.recharge.utils.l.a;
    }

    public RechargeService() {
        jc1.k.l(IRechargeService.class, this);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public IAutoExchangeService getExchangeUtils() {
        IAutoExchangeService r0 = com.bytedance.android.live.recharge.core.f.a(RechargeServices.b());
        if (r0 == null) goto L6;
        return r0;
    L6:
        return com.bytedance.android.live.recharge.utils.a.a;
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService, com.bytedance.android.live.recharge.k
    public zv0.f rechargeCenter() {
        return RechargeCenter.getInstance();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public zv0.a getCJExternalService() {
        return com.bytedance.android.live.wallet.c.a;
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService, com.bytedance.android.live.recharge.k
    public Object getRechargeLynxBehavior() {
        return kx0.d.a;
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService, com.bytedance.android.live.recharge.k
    public void fetchAutoExchangeStatus(int r4) {
        com.bytedance.android.live.recharge.platform.service.z r0 = RechargeFacadeUtilsKt.a();
        r0.getClass();
        if (com.bytedance.android.live.recharge.platform.service.z.a() != null) goto L5;
        boolean r1 = false;
    L6:
        KmpEnv r2 = KmpEnv.a;
        if (KmpEnv.b() == false) goto L14;
        if (r1 == false) goto L16;
        com.bytedance.android.live.recharge.core.b r3 = r0.f();
        IExchangeStatusService r5 = (IExchangeStatusService) com.bytedance.android.scope.m.e.d(r3, IExchangeStatusService.class);
        if (r5 == null) goto L15;
        r5.fetchExchangeStatus(r4);
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    L5:
        r1 = com.bytedance.android.live.recharge.platform.service.z.a().a6();
        goto L6
    }

    private static /* synthetic */ Map lambda$getRechargeJsFactory$0(WeakReference r2, n56.a r3) {
        HashMap r0 = new HashMap();
        r0.put("crossplatformOpenLiveRecharge", new fx0.h(r2, r3));
        return r0;
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public void showPayCancelChargePanel(Context r18, w2 r19) {
        if (this.mPayCancelRecoverService != null) goto L5;
        this.mPayCancelRecoverService = new com.bytedance.android.live.recharge.platform.service.v();
    L5:
        com.bytedance.android.live.recharge.platform.service.v r3 = this.mPayCancelRecoverService;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "event");
        int r4 = ToastUtil.a;
        ToastUtil.b(s1.B(2131921213), WebcastRedirectException.UNKNOWN);
        if (r3.a == true) goto L17;
        r3.a = true;
        Ref.LongRef r5 = new Ref.LongRef();
        r5.element = 0;
        String r6 = r19.a;
        if (StringUtils.isEmpty(r6) == false) goto L11;
        ToastUtil.b(s1.B(2131921212), 0);
        return;
    L11:
        tz0.b r7 = tz0.b.a;
        uz0.c r8 = new uz0.c();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "$this$beforeConfigureRequest");
        Map<String, String> r9 = r8.b;
        Intrinsics.checkNotNullParameter(r9, "queriesMap");
        Intrinsics.checkNotNullParameter("order_id", "$this$setTo");
        if (r6 == null) goto L14;
        r9.put("order_id", r6);
    L14:
        com.bytedance.android.live.revenue.common.x.a(r8, false);
        Intrinsics.checkNotNullParameter(r8, "$this$afterConfigureRequest");
        ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/wallet_api/query_order/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.wallet.model.queryorder.a.class)), com.bytedance.android.live.recharge.platform.model.g.class, r8.d, r8.a, r8.b, r8.c).flatMap(new com.bytedance.android.live.recharge.platform.service.s(r3, r5, r6)).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.recharge.platform.service.t(r3, r5, r19, r18), new com.bytedance.android.live.recharge.platform.service.u(r3));
        return;
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public DialogFragment showRechargeDialogFragment(Context r22, Bundle r23, k.a r24) {
        if ((r22 instanceof FragmentActivity) == true) goto L6;
        return null;
    L6:
        Intrinsics.checkNotNullParameter(r23, "bundle");
        String r3 = r23.getString("KEY_CHARGE_REASON");
        if (r3 != null) goto L9;
        String r6 = "";
    L10:
        String r4 = r23.getString("key_charge_scene");
        if (r4 != null) goto L13;
        String r12 = "";
    L14:
        String r5 = r23.getString("KEY_REQUEST_PAGE");
        if (r5 != null) goto L17;
        r5 = "live_detail";
    L17:
        String r7 = r5;
        String r8 = r23.getString("key_show_type");
        if (r8 != null) goto L20;
        String r13 = "";
    L21:
        long r10 = r23.getLong("key_bundle_lack_money_number", 0);
        if (r23.getLong("key_bundle_lack_money_number", 0) <= 0) goto L24;
        boolean r9 = true;
    L25:
        int r14 = r23.getInt("KEY_CHARGE_ORDER_SOURCE", -1);
        String r15 = r6;
        return RechargeDialogFactoryImpl.a(r22, new com.bytedance.android.live.recharge.model.d(false, r15, r7, r10, r9, r23.getInt("KEY_CHARGE_ORDER_BUSINESS_SCENE", -1), r14, r12, r13, null, null, null, null, 32256), r24);
    L24:
        r9 = false;
        goto L25
    L20:
        r13 = r8;
        goto L21
    L13:
        r12 = r4;
        goto L14
    L9:
        r6 = r3;
        goto L10
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public DialogFragment showRechargeDialogFragment(Context r2, com.bytedance.android.live.recharge.model.d r3, k.a r4) {
        if ((r2 instanceof FragmentActivity) == true) goto L7;
        return null;
    L7:
        return RechargeDialogFactoryImpl.a(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeService
    public zv0.b getCashExchangeDelegate(View r9, List<View> r10, TextView r12, Function1<Integer, Unit> r13, int r14, Context r15) {
        RechargeFacadeUtilsKt.a().getClass();
        ww0.a r1 = com.bytedance.android.live.recharge.platform.service.z.a();
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.Ge(r9, r10, r12, r14, r15, r13);
    }
}
