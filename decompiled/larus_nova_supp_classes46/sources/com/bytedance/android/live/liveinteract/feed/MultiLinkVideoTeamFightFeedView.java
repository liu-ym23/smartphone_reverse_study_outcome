package com.bytedance.android.live.liveinteract.feed;

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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feed/MultiLinkVideoTeamFightFeedView;", "Lcom/bytedance/android/live/liveinteract/feed/CommonMultiLinkFeedView;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVideoTeamFightFeedView extends CommonMultiLinkFeedView {
    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    public MultiLinkVideoTeamFightFeedView(Context r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, r11, null, 0);
        FrameLayout r12 = (FrameLayout) findViewById(2131372816);
        if (r12 == null) goto L10;
        r12.removeAllViews();
        LayoutInflater.from(getContext()).inflate(2131567145, r12, true);
        FrameLayout r13 = (FrameLayout) findViewById(2131392394);
        if (r13 == null) goto L9;
        r13.setVisibility(8);
        return;
    L9:
        return;
    }
}
