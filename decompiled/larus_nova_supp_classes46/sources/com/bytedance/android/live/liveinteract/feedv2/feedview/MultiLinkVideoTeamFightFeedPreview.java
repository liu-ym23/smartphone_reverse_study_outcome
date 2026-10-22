package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkVideoTeamFightFeedPreview;", "Lcom/bytedance/android/live/liveinteract/feedv2/feedview/MultiLinkCommonVideoFeedPreview;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVideoTeamFightFeedPreview extends MultiLinkCommonVideoFeedPreview {
    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkCommonVideoFeedPreview
    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public MultiLinkVideoTeamFightFeedPreview(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        FrameLayout r5 = (FrameLayout) findViewById(2131372816);
        r5.removeAllViews();
        LayoutInflater.from(getContext()).inflate(2131567145, r5, true);
        ((FrameLayout) findViewById(2131392394)).setVisibility(8);
    }
}
