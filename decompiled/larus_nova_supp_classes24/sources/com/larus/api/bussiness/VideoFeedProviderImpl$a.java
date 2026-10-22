package com.larus.api.bussiness;

import androidx.fragment.app.Fragment;
import com.larus.platform.model.video.business.VideoFeedConfigure;
import com.larus.utils.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class VideoFeedProviderImpl$a implements pr9.h {
    public final VideoFeedConfigure a;
    public final VideoChatFragment b;

    public final void N7() {
        this.b.N7();
    }

    public final void V5() {
        this.b.V5();
    }

    public final Fragment f() {
        VideoChatFragment r0 = this.b;
        l.c(r0, "VideoFeedConfigure", this.a);
        return r0;
    }

    public final boolean onBackPressed() {
        return this.b.onBackPressed();
    }

    public VideoFeedProviderImpl$a(VideoFeedConfigure r2) {
        Intrinsics.checkNotNullParameter(r2, "videoFragmentType");
        this.a = r2;
        this.b = new VideoChatFragment();
    }

    public final void xQ(pr9.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.xQ(r2);
    }
}
