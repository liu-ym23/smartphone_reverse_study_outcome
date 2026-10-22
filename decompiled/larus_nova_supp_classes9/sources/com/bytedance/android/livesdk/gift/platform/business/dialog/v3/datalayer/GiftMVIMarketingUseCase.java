package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datalayer;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.t;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.scope.o;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIMarketingUseCase extends BaseMVIDataStore<GiftMVIMarketingUseCase> implements o {
    public static final /* synthetic */ KProperty[] h = null;
    public final Pair<IGiftMarketingInfo, Boolean> e;
    public final ReadOnlyProperty f;
    public final GiftExtraRepo g;

    static {
        h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftMVIMarketingUseCase.class, "marketingInfo", "getMarketingInfo()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0))};
    }

    public final t<GiftMVIMarketingUseCase, Pair<IGiftMarketingInfo, Boolean>> k() {
        return (t) this.f.getValue(this, h[0]);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean f() {
        x.e.getClass();
        return x.a();
    }

    public GiftMVIMarketingUseCase(GiftExtraRepo r3) {
        Intrinsics.checkNotNullParameter(r3, "giftExtraRepo");
        this.g = r3;
        IGiftMarketingInfo.Companion.getClass();
        Pair<IGiftMarketingInfo, Boolean> r4 = new Pair((IGiftMarketingInfo) IGiftMarketingInfo.Companion.a.getValue(), Boolean.FALSE);
        this.e = r4;
        this.f = i(r4).a().a(h[0]);
    }

    public final void n(long r3, final boolean r5) {
        g0 r4 = this.g.q(r3);
        if (r4 == null) goto L6;
        final IGiftMarketingInfo r6 = r4.getGiftMarketingInfo();
        if (r6 == null) goto L6;
    L8:
        if (Intrinsics.areEqual(this.e, new Pair(r6, Boolean.valueOf(r5))) == false) goto L12;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.A.f5() == false) goto L12;
        return;
    L12:
        g("marketingInfoChanged", new GiftMVIMarketingUseCase$marketingInfoChanged$1(this, r6, r5));
        return;
    L6:
        IGiftMarketingInfo.Companion.getClass();
        r6 = (IGiftMarketingInfo) IGiftMarketingInfo.Companion.a.getValue();
        goto L8
    }
}
