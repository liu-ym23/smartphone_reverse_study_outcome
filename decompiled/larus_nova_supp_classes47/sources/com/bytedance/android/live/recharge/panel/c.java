package com.bytedance.android.live.recharge.panel;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.core.RechargeServices;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements HybridDialog.a {
    public final CompositeDisposable a;
    public volatile boolean b;
    public final WeakReference<RechargeDialogContext> c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            tw0.g r3 = (tw0.g) r2;
            this.a.b = true;
            jy0.b.d("Recharge/CustomRechargePanelUtils", "onBuyDiamond called");
        }
    }

    public final /* synthetic */ void onScroll(int r1) {
    }

    public final void onDismiss() {
        jy0.b.d("Recharge/CustomRechargePanelUtils", "panel onDismiss");
        if (this.b == true) goto L11;
        jy0.b.d("Recharge/CustomRechargePanelUtils", "back to recharge panel");
        if (d.c == true) goto L11;
        RechargeDialogContext r0 = this.c.get();
        if (r0 == null) goto L11;
        PublishSubject<Boolean> r1 = r0.getPopUpOrHideRechargePageEvent();
        if (r1 == null) goto L11;
        r1.onNext(Boolean.FALSE);
    L11:
        RechargeDialogContext r2 = this.c.get();
        if (r2 == null) goto L16;
        PublishSubject<Unit> r3 = r2.getCustomRechargePageHideEvent();
        if (r3 == null) goto L16;
        r3.onNext(Unit.INSTANCE);
    L16:
        this.a.dispose();
    }

    public final void onShow() {
        if (d.c == true) goto L9;
        RechargeDialogContext r0 = this.c.get();
        if (r0 == null) goto L9;
        PublishSubject<Boolean> r1 = r0.getPopUpOrHideRechargePageEvent();
        if (r1 == null) goto L9;
        r1.onNext(Boolean.TRUE);
    L9:
        jy0.b.d("Recharge/CustomRechargePanelUtils", "panel onShow");
    }

    public c(WeakReference<RechargeDialogContext> r4) {
        Intrinsics.checkNotNullParameter(r4, "dialogContext");
        this.c = r4;
        CompositeDisposable r5 = new CompositeDisposable();
        this.a = r5;
        com.bytedance.android.live.recharge.core.d r0 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r0, "$this$aioRechargeOrderService");
        RxUtilKt.c(((tw0.b) r0.f(Reflection.getOrCreateKotlinClass(tw0.b.class))).c.take(1).subscribe(new a(this)), r5);
    }
}
