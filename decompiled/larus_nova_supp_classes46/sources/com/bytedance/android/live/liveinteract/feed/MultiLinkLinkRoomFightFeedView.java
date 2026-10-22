package com.bytedance.android.live.liveinteract.feed;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/feed/MultiLinkLinkRoomFightFeedView;", "Lcom/bytedance/android/live/liveinteract/feed/CommonMultiLinkFeedView;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkLinkRoomFightFeedView extends CommonMultiLinkFeedView {
    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public /* bridge */ /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.CommonMultiLinkFeedView
    public final com.bytedance.android.live.liveinteract.videotalk.utils.h o(com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "config");
        float r0 = s1.f(14);
        r4.q(r6);
        int r1 = ((Number) ug0.b.b(r4.m(), r4.getUiLayout(), r5, r6).getFirst()).intValue();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = getLayoutConfig();
        if (r2 == null) goto L6;
        r2.s(r1, r6);
    L6:
        return new com.bytedance.android.live.liveinteract.videotalk.utils.h((int) r0, r5, r6, r4);
    }

    public MultiLinkLinkRoomFightFeedView(Context r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, r11, null, 0);
    }
}
