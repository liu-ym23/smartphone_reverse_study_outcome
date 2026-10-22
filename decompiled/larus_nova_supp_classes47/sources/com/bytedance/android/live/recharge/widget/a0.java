package com.bytedance.android.live.recharge.widget;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.service.IHostApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdkapi.depend.model.IPreRenderDataInfo;
import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoKt;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 implements IHostApi {
    public final RechargeDialogContext a;
    public final Context b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ a0 a;
        public final /* synthetic */ com.bytedance.android.live.recharge.deal.f b;

        public a(a0 r1, com.bytedance.android.live.recharge.deal.f r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Map r4 = ((IQueryPrePayCashierData) r3).getRenderData();
            if (r4 == null) goto L7;
            IPreRenderDataInfo r5 = (IPreRenderDataInfo) r4.get(Long.valueOf(this.b.g()));
            if (r5 == null) goto L7;
            JSONObject r6 = IRenderDataInfoKt.getRenderData(r5);
        L9:
            if (r6 != null) goto L11;
            ALogger.e("cjComponent", "fetchRenderData：render data is null!");
            this.a.a.getRepository().a();
            this.a.a.getDealsSelectedEvent().onNext(Unit.INSTANCE);
        L14:
            this.a.a.getRepository().R.onNext(12);
            this.a.a.isPreQueryInfo().a(Boolean.FALSE);
            return;
        L11:
            if (com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).w(r6) == true) goto L14;
            ALogger.e("cjComponent", "fetchRenderData：refresh failed!");
            this.a.a.getRepository().a();
            this.a.a.getDealsSelectedEvent().onNext(Unit.INSTANCE);
        L7:
            r6 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a0 a;

        public b(a0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ALogger.e("cjComponent", "fetchRenderData: fetch error: " + ((Throwable) r3));
            this.a.a.getRepository().R.onNext(12);
            this.a.a.getRepository().a();
            this.a.a.getDealsSelectedEvent().onNext(Unit.INSTANCE);
            this.a.a.isPreQueryInfo().a(Boolean.FALSE);
        }
    }

    public final void clickConfirmBtn() {
        this.a.getPopUpOrHideRechargePageEvent().onNext(Boolean.FALSE);
        this.a.getClickRechargeBtn().onNext(Unit.INSTANCE);
    }

    public final void fetchRenderData() {
        com.bytedance.android.live.recharge.deal.f r0 = this.a.getSelectedDeal();
        if (r0 != null) goto L5;
        return;
    L5:
        this.a.getRepository().R.onNext(11);
        this.a.isPreQueryInfo().a(Boolean.TRUE);
        RxUtilKt.c(this.a.getPrePayCashierInfoParams(CollectionsKt.listOf(Long.valueOf(r0.g())), 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r0), new b(this)), this.a.getCd());
    }

    public Activity getContext() {
        Context r0 = this.b;
        if (r0 == null) goto L7;
        return (Activity) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final int getPageHeight() {
        return (int) s1.G(this.a.getDialogHeight());
    }

    public final boolean changePayTypeAnimUp() {
        return IHostApi.DefaultImpls.changePayTypeAnimUp(this);
    }

    public final boolean changePayTypeNeedMask() {
        return IHostApi.DefaultImpls.changePayTypeNeedMask(this);
    }

    public a0(RechargeDialogContext r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dialogContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }
}
