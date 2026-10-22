package com.bytedance.android.livesdk.feed.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/feed/viewmodel/SingleFeedTabViewModel;", "Lcom/bytedance/android/livesdk/feed/viewmodel/FeedTabViewModel;", "Lcom/bytedance/android/livesdk/feed/j;", "feedRepository", "Lcom/bytedance/android/livesdk/feed/k;", "Lcom/bytedance/android/livesdk/feed/feed/e;", "feedDataParams", "Lhw1/a;", "userCenter", "<init>", "(Lcom/bytedance/android/livesdk/feed/j;Lcom/bytedance/android/livesdk/feed/k;Lhw1/a;)V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleFeedTabViewModel extends FeedTabViewModel {
    public SingleFeedTabViewModel(com.bytedance.android.livesdk.feed.j r2, com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> r3, hw1.a r4) {
        Intrinsics.checkNotNullParameter(r2, "feedRepository");
        Intrinsics.checkNotNullParameter(r3, "feedDataParams");
        Intrinsics.checkNotNullParameter(r4, "userCenter");
        super(r2, r3, r4);
    }
}
