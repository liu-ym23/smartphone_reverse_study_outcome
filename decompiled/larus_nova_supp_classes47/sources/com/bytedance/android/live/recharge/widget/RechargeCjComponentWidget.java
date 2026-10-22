package com.bytedance.android.live.recharge.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoBase;
import com.bytedance.android.livesdkapi.depend.model.IRenderDataInfoKt;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.kmp.core.KmpEnv;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/RechargeCjComponentWidget;", "Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "Landroid/view/View$OnClickListener;", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeCjComponentWidget extends AbsRechargeWidget implements View.OnClickListener {
    public static final /* synthetic */ int k = 0;
    public final Lazy i;
    public View j;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ RechargeCjComponentWidget a;

        public b(RechargeCjComponentWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RechargeCjComponentWidget r0 = this.a;     // Catch: Throwable -> L7
            ConstraintLayout r1 = ((Widget) r0).contentView;     // Catch: Throwable -> L7
            if (r1 == null) goto L6;
            r1.addView(r0.j);     // Catch: Throwable -> L7
            return;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RechargeCjComponentWidget a;

        public c(RechargeCjComponentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Unit r7 = (Unit) r6;
            com.bytedance.android.live.recharge.deal.f r8 = this.a.h.getSelectedDeal();
            if (r8 == null) goto L19;
            final RechargeCjComponentWidget r0 = this.a;
            int r1 = RechargeCjComponentWidget.k;
            if (r0.d() == false) goto L22;
            JSONObject r2 = r0.Aq(r8.g());
            StringBuilder r3 = new StringBuilder("onDealSelected: renderData is null: ");
            if (r2 != null) goto L10;
            boolean r4 = true;
        L11:
            r3.append(r4);
            ALogger.i("cjComponent", r3.toString());
            if (r2 != null) goto L15;
            r0.h.getRepository().R.onNext(11);
            List<Long> r5 = CollectionsKt.listOf(Long.valueOf(r8.g()));
            r0.h.isPreQueryInfo().a(Boolean.TRUE);
            RxUtilKt.c(r0.h.getPrePayCashierInfoParams(r5, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(r0, r8), new i(r0)), r0.d);
            return;
        L15:
            if (r0.j != null) goto L17;
            r0.Bq(r2);
            return;
        L17:
            r0.h.getRepository().R.onNext(11);
            RechargeCjComponentWidget.Cq(r2, new RechargeCjComponentWidget$onDealSelected$3(r0));
            r0.h.getRepository().R.onNext(12);
            return;
        L10:
            r4 = false;
            goto L11
        L22:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RechargeCjComponentWidget a;

        public d(RechargeCjComponentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            this.a.h.getRepository().t.a(Boolean.FALSE);
            ((Widget) this.a).containerView.setVisibility(8);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ RechargeCjComponentWidget a;

        public e(RechargeCjComponentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L6;
            this.a.h.getRepository().R.onNext(12);
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567259;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onInit(Object[] r1) {
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void yq(long r1) {
    }

    public final boolean d() {
        if (((Boolean) this.h.getRepository().u.a).booleanValue() == true) goto L5;
        return false;
    L5:
        if (((Boolean) this.h.getRepository().e.a).booleanValue() == false) goto L7;
        return false;
    L7:
        if (((Boolean) this.h.getRepository().q.a).booleanValue() == true) goto L14;
        return true;
    L14:
        return false;
    }

    public final void onUnload() {
        if (this.h.isComponentLoad() == false) goto L6;
        com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).a("recharge_panel");
        return;
    }

    public final void zq() {
        this.h.getRepository().a();
        this.h.getDealsSelectedEvent().onNext(Unit.INSTANCE);
    }

    public RechargeCjComponentWidget(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.i = LazyKt.lazy(RechargeCjComponentWidget$isPadABOn$2.INSTANCE);
    }

    public final JSONObject Aq(long r2) {
        IRenderDataInfoBase r3 = (IRenderDataInfoBase) ((Map) this.h.getRepository().s.a).get(Long.valueOf(r2));
        if (r3 != null) goto L7;
        return null;
    L7:
        return IRenderDataInfoKt.getRenderData(r3);
    }

    public final void Bq(JSONObject r12) {
        long r3 = System.currentTimeMillis();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L31
        ITTCJPayComponent r7 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).L(new com.bytedance.android.live.recharge.widget.b(this.h), new a0(this.h, ((Widget) this).context));     // Catch: Throwable -> L31
        if (r7 == null) goto L6;
        com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).s1("recharge_panel", r7);     // Catch: Throwable -> L31
        View r13 = r7.getPayView(r12);     // Catch: Throwable -> L31
    L7:
        this.j = r13;     // Catch: Throwable -> L31
        this.h.setComponentLoad(true);     // Catch: Throwable -> L31
        if (this.j != null) goto L10;
        zq();     // Catch: Throwable -> L31
    L22:
        ALogger.i("cjComponent", "initCjComponentView: view(" + this.j + ')');     // Catch: Throwable -> L31
        int r14 = com.bytedance.android.live.recharge.utils.m.a;     // Catch: Throwable -> L31
        View r15 = this.j;     // Catch: Throwable -> L31
        if (r15 != null) goto L25;
        int r2 = 1;
    L26:
        if (r15 != null) goto L28;
        String r16 = "cj view is null";
    L29:
        com.bytedance.android.live.recharge.utils.m.e("load", r2, r16, System.currentTimeMillis() - r3);     // Catch: Throwable -> L31
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L38;
        ALogger.e("cjComponent", "initCjComponentView: failed. errorMsg: " + r18.getMessage());
        int r1 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.e("load", 1, "财经组件初始化异常" + r18.getMessage(), System.currentTimeMillis() - r3);
        return;
    L38:
        return;
    L28:
        r16 = "";
        goto L29
    L25:
        r2 = 0;
        goto L26
    L10:
        if (((Boolean) this.i.getValue()).booleanValue() == true) goto L12;
    L13:
        KmpEnv r19 = KmpEnv.a;     // Catch: Throwable -> L31
        if (KmpEnv.b() == false) goto L16;
    L15:
        ((Widget) this).contentView.post(new b(this));     // Catch: Throwable -> L31
        goto L22
    L16:
        ConstraintLayout r110 = ((Widget) this).contentView;     // Catch: Throwable -> L31
        if (r110 == null) goto L20;
        r110.addView(this.j);     // Catch: Throwable -> L31
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");     // Catch: Throwable -> L31
    L12:
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.C.getValue(null, com.bytedance.android.live.recharge.utils.j.a[26])).booleanValue() == true) goto L15;
    L6:
        r13 = null;
    L31:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void onLoad(Object[] r2) {
        super.onLoad(r2);
        RxUtilKt.c(this.h.getDealsSelectedEvent().subscribe(new c(this)), this.h.getCd());
        RxUtilKt.c(this.h.getRepository().J.compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this)), this.h.getCd());
        RxUtilKt.c(this.h.isBatchQueryLoading().compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this)), this.h.getCd());
    }

    @Override // com.bytedance.android.live.recharge.widget.AbsRechargeWidget
    public final void xq(com.bytedance.android.live.recharge.deal.i r2) {
        Intrinsics.checkNotNullParameter(r2, "dealSet");
        if (d() == true) goto L5;
        ((Widget) this).containerView.setVisibility(8);
        return;
    L5:
        ((Widget) this).containerView.setVisibility(0);
    }

    public static boolean Cq(JSONObject r5, Function0 r6) {
        long r0 = System.currentTimeMillis();
        boolean r7 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).w(r5);
        if (r7 == true) goto L5;
        r6.invoke();
    L5:
        ALogger.i("cjComponent", "onDealSelected：refresh component status: " + r7);
        int r8 = com.bytedance.android.live.recharge.utils.m.a;
        int r9 = !r7 ? 1 : 0;
        if (r7 == false) goto L8;
        String r2 = "";
    L9:
        com.bytedance.android.live.recharge.utils.m.e("update", r9, r2, System.currentTimeMillis() - r0);
        return r7;
    L8:
        r2 = "refresh failed";
        goto L9
    }
}
