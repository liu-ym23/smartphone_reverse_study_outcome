package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends BaseMVIDataStore<m> implements com.bytedance.android.scope.o {
    public static final /* synthetic */ KProperty[] n = null;
    public final ReadOnlyProperty e;
    public final ReadOnlyProperty f;
    public final ReadOnlyProperty g;
    public final com.bytedance.android.anya.t h;
    public final com.bytedance.android.anya.t i;
    public final com.bytedance.android.anya.t j;
    public final BehaviorSubject<String> k;
    public final BehaviorSubject<PayGrade> l;
    public final CompositeDisposable m;

    static {
        n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(m.class, "currentPayGrade", "getCurrentPayGrade()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "touchPositionsStr", "getTouchPositionsStr()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "needShowDetail", "getNeedShowDetail()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "_touchPositionsStr", "get_touchPositionsStr()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "_currentPayGarde", "get_currentPayGarde()Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", 0)), Reflection.property1(new PropertyReference1Impl(m.class, "_needShowDetail", "get_needShowDetail()Z", 0))};
    }

    public m() {
        com.bytedance.android.live.profit.privilege.a r1 = yt0.c.i();
        String r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m r3 = r1.getPayGrade();
        if (r3 == null) goto L7;
        PayGrade r4 = (PayGrade) r3.getValue();
    L8:
        if (r4 != null) goto L10;
    L13:
        py.d r5 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getUserHonor();
        if (r5 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "$this$toPayGrade");
        long r6 = r5.getScore();
        Intrinsics.checkNotNullParameter(r5, "$this$levelKt");
        long r7 = r5.getLevel();
        long r11 = r5.getThisGradeMaxDiamond();
        r4 = new PayGrade(r6, r7, r5.getThisGradeMinDiamond(), r11, r5.getGradeDescribe(), r5.getNewImIconWithLevel(), r5.getNewLiveIcon(), r5.getBuffInfo(), r5.getGradeDescribeShining(), 0, null, 0, null, null, null, null, 0, 0, null, 523264, null);
    L17:
        com.bytedance.android.anya.internal.k r8 = i(r4).a();
        KProperty[] r9 = n;
        com.bytedance.android.anya.internal.h r10 = r8.a(r9[0]);
        this.e = r10;
        com.bytedance.android.live.profit.privilege.a r13 = yt0.c.i();
        if (r13 == null) goto L24;
        com.bytedance.live.datacontext.m r14 = r13.getTouchPositionData();
        if (r14 == null) goto L24;
        TouchPositionData r15 = (TouchPositionData) r14.getValue();
        if (r15 == null) goto L24;
        r2 = r15.getTouchPositionsStr();
    L24:
        com.bytedance.android.anya.internal.h r16 = j(r2).a().a(r9[1]);
        this.f = r16;
        com.bytedance.android.live.profit.privilege.a r17 = yt0.c.i();
        if (r17 == null) goto L31;
        com.bytedance.live.datacontext.m r18 = r17.getTouchPositionData();
        if (r18 == null) goto L31;
        TouchPositionData r19 = (TouchPositionData) r18.getValue();
        if (r19 == null) goto L31;
        boolean r20 = r19.getNeedShowTopDetail();
    L32:
        com.bytedance.android.anya.internal.h r21 = i(Boolean.valueOf(r20)).a().a(r9[2]);
        this.g = r21;
        this.h = (com.bytedance.android.anya.t) r16.getValue(this, r9[1]);
        this.i = (com.bytedance.android.anya.t) r10.getValue(this, r9[0]);
        this.j = (com.bytedance.android.anya.t) r21.getValue(this, r9[2]);
        this.k = BehaviorSubject.create();
        this.l = BehaviorSubject.create();
        this.m = new CompositeDisposable();
        return;
    L31:
        r20 = true;
        goto L32
    L16:
        r4 = new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
        goto L17
    L10:
        if (r4.getLevel() != 0) goto L17;
        if (r4.getScore() != 0) goto L17;
    L7:
        r4 = null;
        goto L8
    }

    public final void onStop() {
        this.m.clear();
    }

    public final void k() {
        com.bytedance.android.live.profit.privilege.a r0 = yt0.c.i();
        if (r0 == null) goto L5;
        r0.Te();
    L5:
        com.bytedance.android.live.profit.privilege.a r1 = yt0.c.i();
        if (r1 == null) goto L8;
        RxUtilKt.c(r1.getTouchPositionData().a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this)), this.m);
    L8:
        com.bytedance.android.live.profit.privilege.a r2 = yt0.c.i();
        if (r2 == null) goto L12;
        RxUtilKt.c(RxUtilKt.h(r2.getPayGrade().a().subscribeOn(Schedulers.io())).subscribe(new i(this)), this.m);
        return;
    }

    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.m() == false) goto L5;
        k();
        return;
    L5:
        this.m.add(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).pl().filter(k.a).subscribe(new l(this)));
    }
}
