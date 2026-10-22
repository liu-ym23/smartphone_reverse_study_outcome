package nt1;

import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livesdk.dislike.layout.RecommendToFriendsLayout;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements ILiveRecommendToFriendsCallback {
    public final /* synthetic */ RecommendToFriendsLayout a;

    public final void onFailed() {
    }

    public d(RecommendToFriendsLayout r1) {
        this.a = r1;
    }

    public final void onLiveRecommendSuccess(long r2) {
        int r0 = RecommendLiveHelper.a;
        boolean r3 = RecommendLiveHelper.b(r2);
        RecommendToFriendsLayout.a(this.a, r3);
        this.a.b(r3);
    }

    public final void onSuccess(long r2) {
        int r0 = RecommendLiveHelper.a;
        boolean r3 = RecommendLiveHelper.b(r2);
        RecommendToFriendsLayout.a(this.a, r3);
        this.a.b(r3);
    }
}
