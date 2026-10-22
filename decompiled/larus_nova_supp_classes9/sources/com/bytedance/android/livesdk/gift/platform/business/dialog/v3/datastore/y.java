package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y extends BaseMVIDataStore<y> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] h = null;
    public final ReadOnlyProperty e;
    public final com.bytedance.android.anya.t f;
    public final CompositeDisposable g;

    static {
        h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(y.class, "currentPayGrade", "getCurrentPayGrade()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(y.class, "_currentPayGrade", "get_currentPayGrade()Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", 0))};
    }

    public y() {
        com.bytedance.android.live.profit.privilege.a r1 = yt0.c.i();
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.m r2 = r1.getPayGrade();
        if (r2 == null) goto L8;
        PayGrade r3 = (PayGrade) r2.getValue();
        if (r3 == null) goto L8;
    L9:
        com.bytedance.android.anya.internal.k r4 = i(r3).a();
        KProperty[] r5 = h;
        com.bytedance.android.anya.internal.h r6 = r4.a(r5[0]);
        this.e = r6;
        this.f = (com.bytedance.android.anya.t) r6.getValue(this, r5[0]);
        this.g = new CompositeDisposable();
        return;
    L8:
        r3 = new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
        goto L9
    }

    public final void onStop() {
        this.g.clear();
    }

    public final void onStart() {
        com.bytedance.android.live.profit.privilege.a r0 = yt0.c.i();
        if (r0 == null) goto L6;
        RxUtilKt.c(RxUtilKt.h(r0.getPayGrade().a().subscribeOn(Schedulers.io())).subscribe(new x(this)), this.g);
        return;
    }
}
