package com.larus.bmhome.video.fragment;

import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.video.progress.PlayerProgressView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v implements PlayerProgressView.a {
    public double a;
    public final /* synthetic */ BaseVideoDetailFragment<ViewBinding> b;
    public final /* synthetic */ PlayerProgressView c;

    public final void b() {
        BaseVideoDetailFragment<ViewBinding> r0 = this.b;
        boolean r1 = false;
        r0.j = false;
        r0.ba0();
        this.b.k = System.currentTimeMillis();
        FLogger.a.d(this.b.tag(), "[IProgressChangedListener] onProgressChanged, userDragProgress:" + this.a);
        double r4 = (double) 100;
        double r2 = Math.ceil(this.a * r4) / r4;
        VideoPlayView r3 = this.b.q;
        if (r3 == null) goto L22;
        int r5 = (int) (r3.getDuration() * r2);
        VideoPlayView r6 = this.b.q;
        if (r6 == null) goto L7;
        r6.J(r5);
    L7:
        VideoPlayView r7 = this.b.q;
        if (r7 != null) goto L10;
    L12:
        if (r1 == true) goto L14;
        this.b.ca0(true);
    L14:
        PlayerProgressView r8 = this.c;
        nr9.g r9 = this.b.e;
        if (r9 == null) goto L19;
        Double r10 = r9.e;
        if (r10 == null) goto L19;
        double r11 = r10.doubleValue();
    L20:
        r8.n6(r5, (int) (r11 * ((double) GuidePriority.COMMERCE_CREDIT_PRIORITY)));
        return;
    L19:
        r11 = 0.0d;
        goto L20
    L10:
        if (r7.r() != true) goto L12;
        r1 = true;
        goto L12
    }

    public final void c() {
        BaseVideoDetailFragment<ViewBinding> r0 = this.b;
        r0.j = true;
        r0.aa0();
    }

    public final void a(double r9) {
        double r0 = 100;
        double r10 = Math.ceil(r9 * r0) / r0;
        VideoPlayView r1 = this.b.q;
        long r2 = 0;
        if (r1 == null) goto L5;
        long r3 = r1.getDuration();
    L6:
        double r5 = 0.0d;
        if (r3 <= 0) goto L11;
        VideoPlayView r4 = this.b.q;
        if (r4 == null) goto L18;
        r2 = r4.getDuration();
    L18:
        int r11 = (int) (r2 * r10);
        PlayerProgressView r12 = this.c;
        nr9.g r6 = this.b.e;
        if (r6 == null) goto L23;
        Double r7 = r6.e;
        if (r7 == null) goto L23;
        r5 = r7.doubleValue();
    L23:
        r12.n6(r11, (int) (r5 * ((double) GuidePriority.COMMERCE_CREDIT_PRIORITY)));
        return;
    L11:
        nr9.g r8 = this.b.e;
        if (r8 == null) goto L16;
        Double r13 = r8.e;
        if (r13 == null) goto L16;
        double r14 = r13.doubleValue();
    L17:
        r2 = (long) (r14 * ((double) GuidePriority.COMMERCE_CREDIT_PRIORITY));
    L16:
        r14 = 0.0d;
        goto L17
    L5:
        r3 = 0;
        goto L6
    }

    public final void onProgressChanged(double r1) {
        this.a = r1;
    }

    public v(BaseVideoDetailFragment<ViewBinding> r1, PlayerProgressView r2) {
        this.b = r1;
        this.c = r2;
        this.a = 1.0d;
    }
}
