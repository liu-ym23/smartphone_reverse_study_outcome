package com.larus.community.impl.detail.video;

import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p implements PlayerProgressView.a {
    public double a;
    public final /* synthetic */ CreationDetailVideoView b;
    public final /* synthetic */ PlayerProgressView c;

    @Override // com.larus.common_ui.video.progress.PlayerProgressView.a
    public final void b() {
        CreationDetailVideoView r0 = this.b;
        r0.u = false;
        r0.v = System.currentTimeMillis();
        FLogger.a.d("CreationDetailVideoView", "[IProgressChangedListener] onProgressChanged, userDragProgress:" + this.a);
        double r2 = (double) 100;
        double r1 = Math.ceil(this.a * r2) / r2;
        VideoPlayView r3 = this.b.d.d;
        if (r3 == null) goto L15;
        int r4 = (int) (r3.getDuration() * r1);
        VideoPlayView r5 = this.b.d.d;
        if (r5 == null) goto L7;
        r5.J(r4);
    L7:
        PlayerProgressView r6 = this.c;
        nr9.g r7 = this.b.g;
        if (r7 == null) goto L12;
        Double r8 = r7.e;
        if (r8 == null) goto L12;
        double r9 = r8.doubleValue();
    L13:
        r6.n6(r4, (int) (r9 * ((double) 1000)));
        return;
    L12:
        r9 = 0.0d;
        goto L13
    }

    @Override // com.larus.common_ui.video.progress.PlayerProgressView.a
    public final void c() {
        this.b.u = true;
    }

    @Override // com.larus.common_ui.video.progress.PlayerProgressView.a
    public final void a(double r9) {
        double r0 = 100;
        double r10 = Math.ceil(r9 * r0) / r0;
        VideoPlayView r1 = this.b.d.d;
        long r2 = 0;
        if (r1 == null) goto L5;
        long r3 = r1.getDuration();
    L6:
        double r5 = 0.0d;
        if (r3 <= 0) goto L11;
        VideoPlayView r4 = this.b.d.d;
        if (r4 == null) goto L18;
        r2 = r4.getDuration();
    L18:
        int r11 = (int) (r2 * r10);
        PlayerProgressView r12 = this.c;
        nr9.g r6 = this.b.g;
        if (r6 == null) goto L23;
        Double r7 = r6.e;
        if (r7 == null) goto L23;
        r5 = r7.doubleValue();
    L23:
        r12.n6(r11, (int) (r5 * ((double) 1000)));
        return;
    L11:
        nr9.g r8 = this.b.g;
        if (r8 == null) goto L16;
        Double r13 = r8.e;
        if (r13 == null) goto L16;
        double r14 = r13.doubleValue();
    L17:
        r2 = (long) (r14 * ((double) 1000));
    L16:
        r14 = 0.0d;
        goto L17
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.larus.common_ui.video.progress.PlayerProgressView.a
    public final void onProgressChanged(double r1) {
        this.a = r1;
    }

    public p(CreationDetailVideoView r1, PlayerProgressView r2) {
        this.b = r1;
        this.c = r2;
        this.a = 1.0d;
    }
}
