package com.larus.avlink.gallery;

import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r implements PlayerProgressView.a {
    public double a;
    public final /* synthetic */ VideoVH b;
    public final /* synthetic */ PlayerProgressView c;

    public final void b() {
        VideoVH r0 = this.b;
        r0.m = false;
        r0.n = System.currentTimeMillis();
        double r2 = 100;
        final int r1 = (int) (this.b.p.getDuration() * (Math.ceil(this.a * r2) / r2));
        VideoVH r3 = this.b;
        VideoVH.PlayState r4 = r3.k;
        VideoVH.PlayState r5 = VideoVH.PlayState.PLAYING;
        if (r4 != r5) goto L6;
        r3.p.J(r1);
    L11:
        PlayerProgressView r6 = this.c;
        Double r7 = this.b.o.e;
        if (r7 == null) goto L14;
        double r8 = r7.doubleValue();
    L15:
        r6.n6(r1, (int) (r8 - ((double) 500)));
        return;
    L14:
        r8 = 0.0d;
        goto L15
    L6:
        if (r4 == VideoVH.PlayState.DATA_READY) goto L8;
    L10:
        FLogger.a.w("VideoVH", "Cannot seek in current state: " + this.b.k);
        goto L11
    L8:
        if (this.c.isSelected() == false) goto L10;
        FLogger.a.i("VideoVH", "Seeking while not playing, starting playback first");
        VideoVH r9 = this.b;
        r9.k = r5;
        r9.p.M();
        final VideoVH r10 = this.b;
        r10.p.postDelayed(new q(r10, r1), 100);
        goto L11
    }

    public final void c() {
        this.b.m = true;
    }

    public final void a(double r8) {
        double r0 = 100;
        double r9 = Math.ceil(r8 * r0) / r0;
        double r4 = 0.0d;
        if (this.b.p.getDuration() <= 0) goto L5;
        long r1 = this.b.p.getDuration();
    L12:
        int r10 = (int) (r1 * r9);
        PlayerProgressView r11 = this.c;
        nr9.g r2 = this.b.o;
        if (r2 == null) goto L17;
        Double r3 = r2.e;
        if (r3 == null) goto L17;
        r4 = r3.doubleValue();
    L17:
        r11.n6(r10, (int) (r4 - ((double) 500)));
        FLogger.a.d("VideoVH", "[IProgressChangedListener] onProgressChanged, updateTimeLine:" + r10);
        return;
    L5:
        nr9.g r5 = this.b.o;
        if (r5 == null) goto L10;
        Double r6 = r5.e;
        if (r6 == null) goto L10;
        double r7 = r6.doubleValue();
    L11:
        r1 = (long) (r7 * ((double) 1000));
    L10:
        r7 = 0.0d;
        goto L11
    }

    public final void onProgressChanged(double r1) {
        this.a = r1;
    }

    public r(VideoVH r1, PlayerProgressView r2) {
        this.b = r1;
        this.c = r2;
        this.a = 1.0d;
    }
}
