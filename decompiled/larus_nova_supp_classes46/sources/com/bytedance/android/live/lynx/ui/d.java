package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.base.LLog;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements AlphaPlayerAction {
    public final /* synthetic */ LiveLynxAlphaPlayer a;

    public final void a() {
        LLog.i("x-alpha-video", "start action, url is " + this.a.g);
        LiveLynxAlphaPlayer r0 = this.a;
        r0.sendEvent("start", r0.P(1, "start video", null));
        LiveLynxAlphaPlayer.M(this.a).setMIsShowPoster(false);
        LiveLynxAlphaPlayer.M(this.a).d = null;
        LiveLynxAlphaPlayer.M(this.a).invalidate();
    }

    public final void b() {
        LLog.i("x-alpha-video", "endAction action, url is " + this.a.g);
        LiveLynxAlphaPlayer.M(this.a).setMIsShowLastFrame(true);
        LiveLynxAlphaPlayer.M(this.a).setMLastFrame(this.a.f);
        LiveLynxAlphaPlayer.M(this.a).setMPoster(null);
        LiveLynxAlphaPlayer.M(this.a).setMIsShowPoster(false);
        LiveLynxAlphaPlayer.M(this.a).c = null;
        LiveLynxAlphaPlayer.M(this.a).invalidate();
        LiveLynxAlphaPlayer r0 = this.a;
        r0.sendEvent("completion", r0.P(2, "play video success", null));
        IPlayerController r1 = this.a.a;
        if (r1 == null) goto L6;
        r1.stop();
        return;
    }

    public d(LiveLynxAlphaPlayer r1) {
        this.a = r1;
    }

    public final void c(int r3, int r4, DataSource.ScaleType r5) {
        Intrinsics.checkNotNullParameter(r5, "scaleType");
        LLog.i("x-alpha-video", "onVideoSizeChange: videoWidth = " + r3 + " videoHeight = " + r4 + " scaleType = " + r5.name());
    }
}
