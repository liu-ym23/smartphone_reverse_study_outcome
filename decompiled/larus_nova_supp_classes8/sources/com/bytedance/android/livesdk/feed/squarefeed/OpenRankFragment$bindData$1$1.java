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
final /* synthetic */ class OpenRankFragment$bindData$1$1 extends FunctionReferenceImpl implements Function1<NetworkStat, Unit> {
    public OpenRankFragment$bindData$1$1(OpenRankFragment r8) {
        super(1, r8, OpenRankFragment.class, "onRefreshStateChanged", "onRefreshStateChanged(Lcom/bytedance/android/live/core/network/NetworkStat;)V", 0);
    }

    public final void invoke(NetworkStat r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        OpenRankFragment r0 = (OpenRankFragment) ((CallableReference) this).receiver;
        int r1 = OpenRankFragment.C;
        r0.getClass();
        if (r5.isLoading() == false) goto L12;
        BannerSwipeRefreshLayout r2 = r0.Z90();
        if (r2 == null) goto L12;
        if (((I18nSwipeRefreshLayout) r2).d == true) goto L12;
        BannerSwipeRefreshLayout r3 = r0.Z90();
        if (r3 == null) goto L20;
        r3.setRefreshing(true);
    L20:
        NetworkStat.Status r4 = NetworkStat.Status.RUNNING;
        if (r5.isLoading() == true) goto L23;
        return;
    L23:
        if (((Boolean) LiveSettingKeys.LIVE_IS_LOAD_GIFT_AFTER_FEED_END.getValue()).booleanValue() == true) goto L25;
        return;
    L25:
        if (r0.v == true) goto L32;
        r0.v = true;
        if (TTLiveService.getLiveService() == null) goto L33;
        TTLiveSDK.initGiftResource();
        return;
    L33:
        return;
    L32:
        return;
    L12:
        if (r5.isLoading() == true) goto L20;
        BannerSwipeRefreshLayout r6 = r0.Z90();
        if (r6 == null) goto L20;
        if (((I18nSwipeRefreshLayout) r6).d != true) goto L20;
        BannerSwipeRefreshLayout r7 = r0.Z90();
        if (r7 == null) goto L20;
        r7.setRefreshing(false);
        goto L20
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((NetworkStat) r1);
        return Unit.INSTANCE;
    }
}
