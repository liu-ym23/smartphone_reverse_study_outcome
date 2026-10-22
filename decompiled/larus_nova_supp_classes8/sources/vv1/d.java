package vv1;

import com.bytedance.android.livesdk.feed.drawerfeed.DrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements LiveDrawerFeedRepository.c {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String NX(String r2) {
        Intrinsics.checkNotNullParameter(r2, "backUrl");
        return r2;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final boolean VF() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final Integer s40() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final long u20() {
        return -1;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.repository.LiveDrawerFeedRepository.c
    public final String mg(boolean r2) {
        return DrawerFeedLiveFragment.la0().concat("-drawer_cover");
    }
}
