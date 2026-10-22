package com.bytedance.android.livesdk.feed.squarefeed;

import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.uikit.refresh.I18nSwipeRefreshLayout;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdkapi.TTLiveService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/core/network/NetworkStat;", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class OpenFeedFragment$bindData$1$1 extends FunctionReferenceImpl implements Function1<NetworkStat, Unit> {
    public OpenFeedFragment$bindData$1$1(OpenFeedFragment r8) {
        super(1, r8, OpenFeedFragment.class, "onRefreshStateChanged", "onRefreshStateChanged(Lcom/bytedance/android/live/core/network/NetworkStat;)V", 0);
    }

    public final void invoke(NetworkStat r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        OpenFeedFragment r0 = (OpenFeedFragment) ((CallableReference) this).receiver;
        int r1 = OpenFeedFragment.C;
        r0.getClass();
        if (r5.isLoading() == false) goto L12;
        BannerSwipeRefreshLayout r2 = r0.Z90();
        if (r2 == null) goto L12;
        if (((I18nSwipeRefreshLayout) r2).d == true) goto L12;
        BannerSwipeRefreshLayout r3 = r0.Z90();
        if (r3 == null) goto L21;
        r3.setRefreshing(true);
    L21:
        if (r5.mStatus != NetworkStat.Status.SUCCESS) goto L24;
        r0.da0();
    L24:
        if (r5.isLoading() == true) goto L26;
        return;
    L26:
        if (((Boolean) LiveSettingKeys.LIVE_IS_LOAD_GIFT_AFTER_FEED_END.getValue()).booleanValue() == true) goto L28;
        return;
    L28:
        if (r0.u == true) goto L35;
        r0.u = true;
        if (TTLiveService.getLiveService() == null) goto L36;
        TTLiveSDK.initGiftResource();
        return;
    L36:
        return;
    L35:
        return;
    L12:
        if (r5.isLoading() == true) goto L21;
        BannerSwipeRefreshLayout r4 = r0.Z90();
        if (r4 == null) goto L21;
        if (((I18nSwipeRefreshLayout) r4).d != true) goto L21;
        BannerSwipeRefreshLayout r6 = r0.Z90();
        if (r6 == null) goto L21;
        r6.setRefreshing(false);
        goto L21
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((NetworkStat) r1);
        return Unit.INSTANCE;
    }
}
