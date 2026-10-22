package com.larus.doc.impl.video;

import com.larus.doc.biz.impl.databinding.LarusDocVideoPlayLayoutBinding;
import com.larus.doc.impl.video.widget.PlayerProgressView;
import com.larus.doc.impl.video.widget.VideoPlayView;
import com.larus.platform.api.IVideoController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l implements PlayerProgressView.a {
    public double a;
    public final /* synthetic */ VideoDetailFragment b;
    public final /* synthetic */ PlayerProgressView c;

    @Override // com.larus.doc.impl.video.widget.PlayerProgressView.a
    public final void b() {
        VideoDetailFragment r0 = this.b;
        r0.d = false;
        r0.e = System.currentTimeMillis();
        double r4 = 100;
        double r2 = Math.ceil(this.a * r4) / r4;
        LarusDocVideoPlayLayoutBinding r1 = this.b.k;
        if (r1 == null) goto L18;
        VideoPlayView r3 = r1.f;
        if (r3 == null) goto L19;
        int r5 = (int) (r3.getDuration() * r2);
        LarusDocVideoPlayLayoutBinding r6 = this.b.k;
        if (r6 == null) goto L16;
        VideoPlayView r7 = r6.f;
        if (r7 == null) goto L16;
        IVideoController r8 = r7.l;
        if (r8 == null) goto L16;
        if (r8.d() == IVideoController.PlayType.PLAY) goto L15;
        r8.play();
    L15:
        r8.A(r5, null);
    L16:
        this.c.Z5(r5, 0);
        return;
    L19:
        return;
    }

    @Override // com.larus.doc.impl.video.widget.PlayerProgressView.a
    public final void a(double r6) {
        double r0 = 100;
        double r7 = Math.ceil(r6 * r0) / r0;
        LarusDocVideoPlayLayoutBinding r1 = this.b.k;
        long r2 = 0;
        if (r1 == null) goto L7;
        VideoPlayView r3 = r1.f;
        if (r3 == null) goto L7;
        long r4 = r3.getDuration();
    L9:
        if (r4 <= 0) goto L15;
        LarusDocVideoPlayLayoutBinding r5 = this.b.k;
        if (r5 == null) goto L15;
        VideoPlayView r8 = r5.f;
        if (r8 == null) goto L15;
        r2 = r8.getDuration();
    L15:
        this.c.Z5((int) (r2 * r7), 0);
        return;
    L7:
        r4 = 0;
        goto L9
    }

    @Override // com.larus.doc.impl.video.widget.PlayerProgressView.a
    public final void onProgressChanged(double r1) {
        this.a = r1;
    }

    public l(VideoDetailFragment r1, PlayerProgressView r2) {
        this.b = r1;
        this.c = r2;
        this.a = 1.0d;
    }
}
