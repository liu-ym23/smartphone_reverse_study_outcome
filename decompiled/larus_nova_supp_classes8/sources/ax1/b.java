package ax1;

import com.bytedance.android.livesdk.feed.context.LiveFeedContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements hw1.a {
    public b() {
    }

    @Override // hw1.a
    public final a m() {
        return new a();
    }

    @Override // hw1.a
    public final boolean isLogin() {
        return LiveFeedContext.hostService().user().isLogin();
    }
}
