package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datalayer;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.l3;
import com.bytedance.android.livesdk.gift.model.m3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.x;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVISeriesUseCase extends BaseMVIDataStore<GiftMVISeriesUseCase> implements o {
    public static final /* synthetic */ KProperty[] h = null;
    public final ReadOnlyProperty e;
    public l3 f;
    public final GiftExtraRepo g;

    static {
        h = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftMVISeriesUseCase.class, "seriesGiftsInfo", "getSeriesGiftsInfo()Lcom/bytedance/android/anya/MVIExternalDataProperty;", 0))};
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean f() {
        x.e.getClass();
        return x.a();
    }

    public GiftMVISeriesUseCase(GiftExtraRepo r3) {
        Intrinsics.checkNotNullParameter(r3, "giftExtraRepo");
        this.g = r3;
        this.e = i(f.c(l3.class)).a().a(h[0]);
        this.f = (l3) f.c(l3.class);
    }

    public final void k(final l3 r2) {
        Intrinsics.checkNotNullParameter(r2, "series");
        if (m3.a(r2, this.f) == false) goto L7;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.A.w5() == false) goto L7;
        return;
    L7:
        g("refreshGiftSeries", new GiftMVISeriesUseCase$refreshGiftSeriesData$1(this, r2));
    }

    public final void n(long r2) {
        g0 r3 = this.g.q(r2);
        if (r3 == null) goto L6;
        final l3 r4 = r3.getSeriesGift();
        if (r4 == null) goto L6;
    L8:
        if (m3.a(r4, this.f) == false) goto L12;
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.A.w5() == false) goto L12;
        return;
    L12:
        g("selectSeriesGiftChange", new GiftMVISeriesUseCase$selectGiftChange$1(this, r4));
        return;
    L6:
        r4 = (l3) f.c(l3.class);
        goto L8
    }
}
