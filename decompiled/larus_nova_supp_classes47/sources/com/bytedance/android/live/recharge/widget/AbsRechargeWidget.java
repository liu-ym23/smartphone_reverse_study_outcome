package com.bytedance.android.live.recharge.widget;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/recharge/widget/AbsRechargeWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsRechargeWidget extends LiveRecyclableWidget {
    public String a;
    public String b;
    public long c;
    public final CompositeDisposable d;
    public final com.bytedance.android.live.recharge.a0 e;
    public int f;
    public com.bytedance.android.live.recharge.model.d g;
    public final RechargeDialogContext h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AbsRechargeWidget a;

        public a(AbsRechargeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            AbsRechargeWidget r0 = this.a;
            r0.xq((com.bytedance.android.live.recharge.deal.i) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AbsRechargeWidget a;

        public b(AbsRechargeWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.yq(((Long) r4).longValue());
        }
    }

    public void onInit(Object[] r1) {
    }

    public abstract void xq(com.bytedance.android.live.recharge.deal.i r1);

    public abstract void yq(long r1);

    public final int wq() {
        return ((Boolean) this.h.getRepository().y.a).booleanValue() ? 1 : 0;
    }

    public void onDestroy() {
        super.onDestroy();
        this.d.clear();
        mz0.d.c("FirstRechargeSendLogFilter");
    }

    public AbsRechargeWidget(RechargeDialogContext r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogContext");
        this.h = r2;
        this.d = new CompositeDisposable();
        this.e = r2.getRepository();
        com.bytedance.android.live.recharge.model.d r3 = com.bytedance.android.live.recharge.model.d.p;
        this.g = com.bytedance.android.live.recharge.model.d.p;
    }

    public void onLoad(Object[] r3) {
        com.bytedance.android.live.recharge.model.d r4 = this.h.getMDialogEntranceParams();
        this.g = r4;
        this.c = r4.d;
        this.a = r4.b;
        this.b = r4.h;
        com.bytedance.android.live.recharge.model.f r5 = r4.k;
        if (r5 == null) goto L5;
        int r6 = r5.c;
    L6:
        this.f = r6;
        RxUtilKt.c(this.h.getRepository().E.observeOn(AndroidSchedulers.mainThread()).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this)), this.d);
        RxUtilKt.c(this.h.getRepository().F.observeOn(AndroidSchedulers.mainThread()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this)), this.d);
        mz0.d.a("FirstRechargeSendLogFilter", new com.bytedance.android.live.recharge.widget.a(this));
        return;
    L5:
        r6 = 0;
        goto L6
    }
}
