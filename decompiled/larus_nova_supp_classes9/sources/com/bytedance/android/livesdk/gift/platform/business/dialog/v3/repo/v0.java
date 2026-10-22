package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.configmodel.m1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LynxTouchViewVisibleChange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.QueryUserHonorMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v0 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final i12.e b;
    public final uz1.a c;

    public final void onStop() {
        this.a.clear();
    }

    public final void a() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L30;
        this.c.a(new LynxTouchViewVisibleChange(true, true));
    L30:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == false) goto L10;
        GiftPanelBizBoostUtils.E.getClass();     // Catch: Exception -> L25
        if (GiftPanelBizBoostUtils.d().r0() == true) goto L26;
    L10:
        py.d r0 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getUserHonor();     // Catch: Exception -> L25
        GsonMap r4 = null;
        m1 r2 = (m1) nz1.a.i.getValue(null, nz1.a.a[7]);     // Catch: Exception -> L25
        Pair[] r3 = new Pair[2];     // Catch: Exception -> L25
        JsonElement r1 = GsonHelper.getDefault().toJsonTree(r0);     // Catch: Exception -> L25
        if ((r1 instanceof JsonObject) == true) goto L13;
        r1 = null;
    L13:
        JsonObject r5 = (JsonObject) r1;     // Catch: Exception -> L25
        if (r5 == null) goto L16;
        GsonMap r6 = UtilsKt.i(r5);     // Catch: Exception -> L25
    L17:
        r3[0] = TuplesKt.to("payGrade", r6);     // Catch: Exception -> L25
        JsonElement r7 = GsonHelper.getDefault().toJsonTree(r2);     // Catch: Exception -> L25
        if ((r7 instanceof JsonObject) == true) goto L20;
        r7 = null;
    L20:
        JsonObject r8 = (JsonObject) r7;     // Catch: Exception -> L25
        if (r8 == null) goto L23;
        r4 = UtilsKt.i(r8);     // Catch: Exception -> L25
    L23:
        r3[1] = TuplesKt.to("honorSetting", r4);     // Catch: Exception -> L25
        this.c.a(new QueryUserHonorMap(MapsKt.mutableMapOf(r3)));     // Catch: Exception -> L25
        goto L26
    L16:
        r6 = null;
    L26:
        com.bytedance.android.live.profit.privilege.a r9 = yt0.c.i();
        if (r9 == null) goto L32;
        this.a.add(r9.getTouchPositionData().a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s0(this)));
        return;
    }

    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.m() == false) goto L5;
        a();
        return;
    L5:
        this.a.add(vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).pl().filter(t0.a).subscribe(new u0(this)));
    }

    public v0(i12.e r2, uz1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "giftMVIFacade");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
