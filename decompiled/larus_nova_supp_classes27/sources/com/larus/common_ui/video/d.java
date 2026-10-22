package com.larus.common_ui.video;

import com.larus.platform.api.IVideoController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ VideoPlayView a;
    public final /* synthetic */ long b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ d(VideoPlayView r1, long r2, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPlayView r0 = this.a;
        long r1 = this.b;
        boolean r3 = this.c;
        int r4 = VideoPlayView.y1;
        if (r0.h(r1) == false) goto L13;
        IVideoController r2 = r0.C;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.d() != IVideoController.PlayType.PAUSE) goto L12;
        r0.x1 = r3;
        r0.i(false);
        r2.play();
        return;
    L12:
        return;
    }
}
