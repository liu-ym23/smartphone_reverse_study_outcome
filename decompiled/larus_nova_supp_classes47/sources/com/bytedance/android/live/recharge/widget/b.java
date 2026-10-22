package com.bytedance.android.live.recharge.widget;

import com.android.ttcjpaysdk.base.service.IErrorInfo;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.PayMsg;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.livesdkapi.depend.model.IQueryPrePayCashierData;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements IPayLifecycle {
    public final RechargeDialogContext a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Map r5 = ((IQueryPrePayCashierData) r4).getRenderData();
            if (r5 == null) goto L8;
            Iterator<T> r6 = r5.entrySet().iterator();
        L6:
            if (r6.hasNext() == false) goto L9;
            Map.Entry r0 = (Map.Entry) r6.next();
            ((Map) this.a.a.getRepository().s.a).put(r0.getKey(), r0.getValue());
        L9:
            PropertyOwner<Boolean> r7 = this.a.a.isBatchQueryLoading();
            Boolean r1 = Boolean.FALSE;
            r7.onNext(r1);
            this.a.a.isPreQueryInfo().a(r1);
            return;
        L8:
            this.a.a.getRepository().a();
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.widget.b$b, reason: collision with other inner class name */
    public static final class C0081b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0081b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ALogger.e("cjComponent", "onPayMethodChange: request failed: " + ((Throwable) r3));
            PropertyOwner<Boolean> r4 = this.a.a.isBatchQueryLoading();
            Boolean r0 = Boolean.FALSE;
            r4.onNext(r0);
            this.a.a.getRepository().a();
            this.a.a.isPreQueryInfo().a(r0);
        }
    }

    public final void onInitStart() {
        ALogger.d("cjComponent", "onInitStart");
    }

    public final void onPayMethodChange() {
        boolean r0 = ((Boolean) this.a.getRepository().w.a).booleanValue();
        ALogger.i("cjComponent", "onPayMethodChange: needBatchQueryCashierInfo=" + r0);
        if (r0 == false) goto L25;
        com.bytedance.android.live.recharge.deal.f r1 = this.a.getSelectedDeal();
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.b());
    L8:
        Iterable r3 = (Iterable) this.a.getRepository().k.a;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L9:
        boolean r6 = true;
        if (r5.hasNext() == false) goto L20;
        Object r7 = r5.next();
        long r8 = ((com.bytedance.android.live.recharge.deal.f) r7).b();
        if (r2 != null) goto L15;
    L18:
        if (r6 == false) goto L9;
        r4.add(r7);
        goto L9
    L15:
        if (r8 != r2.longValue()) goto L18;
        r6 = false;
        goto L18
    L20:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r10 = r4.iterator();
    L22:
        if (r10.hasNext() == false) goto L24;
        r9.add(Long.valueOf(((com.bytedance.android.live.recharge.deal.f) r10.next()).g()));
        goto L22
    L24:
        this.a.isPreQueryInfo().a(Boolean.FALSE);
        RxUtilKt.c(this.a.getPrePayCashierInfoParams(r9, 1).subscribe(new a(this), new C0081b(this)), this.a.getCd());
    L26:
        this.a.getRepository().R.onNext(13);
        return;
    L7:
        r2 = null;
        goto L8
    L25:
        ((Map) this.a.getRepository().s.a).clear();
        goto L26
    }

    public final void onRefreshStart() {
        ALogger.d("cjComponent", "onRefreshStart");
    }

    public b(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogContext");
        this.a = r2;
    }

    public final void onConfirm(IErrorInfo r3) {
        if (r3 != null) goto L4;
    L5:
        StringBuilder r0 = new StringBuilder("onConfirm: 打开收银台失败,退回两步提单, msg:");
        if (r3 == null) goto L8;
        String r4 = r3.getMsg();
    L9:
        r0.append(r4);
        ALogger.i("cjComponent", r0.toString());
        this.a.getRepository().a();
        this.a.getDealsSelectedEvent().onNext(Unit.INSTANCE);
        return;
    L8:
        r4 = null;
        goto L9
    L4:
        if (r3.getCode() != 0) goto L5;
    }

    public final void onInitEnd(IErrorInfo r4) {
        StringBuilder r0 = new StringBuilder("onInitEnd: errorCode: ");
        String r1 = null;
        if (r4 == null) goto L5;
        Integer r2 = Integer.valueOf(r4.getCode());
    L6:
        r0.append(r2);
        r0.append(", errorMsg: ");
        if (r4 == null) goto L9;
        r1 = r4.getMsg();
    L9:
        r0.append(r1);
        ALogger.d("cjComponent", r0.toString());
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onPayMsgUpdate(Map<PayMsg, ? extends Object> r6) {
        ALogger.i("cjComponent", "onPayMsgUpdate: " + r6);
        HashMap r0 = new HashMap();
        PayMsg r1 = PayMsg.BTN_DESC;
        Object r2 = null;
        if (r6 == null) goto L5;
        Object r3 = r6.get(r1);
    L7:
        if ((r3 instanceof String) == true) goto L9;
        r3 = null;
    L9:
        String r4 = (String) r3;
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r0.put(r1, r4);
        PayMsg r7 = PayMsg.PAY_AMOUNT;
        if (r6 == null) goto L15;
        Object r8 = r6.get(r7);
    L17:
        if ((r8 instanceof String) == false) goto L20;
        r2 = r8;
    L20:
        String r9 = (String) r2;
        if (r9 == null) goto L24;
        r5 = r9;
    L24:
        r0.put(r7, r5);
        this.a.getBtnContent().a(r0);
        return;
    L15:
        r8 = null;
        goto L17
    L5:
        r3 = null;
        goto L7
    }

    public final void onRefreshEnd(IErrorInfo r4) {
        StringBuilder r0 = new StringBuilder("onRefreshEnd: errorCode: ");
        String r1 = null;
        if (r4 == null) goto L5;
        Integer r2 = Integer.valueOf(r4.getCode());
    L6:
        r0.append(r2);
        r0.append(", errorMsg: ");
        if (r4 == null) goto L9;
        r1 = r4.getMsg();
    L9:
        r0.append(r1);
        ALogger.d("cjComponent", r0.toString());
        return;
    L5:
        r2 = null;
        goto L6
    }
}
