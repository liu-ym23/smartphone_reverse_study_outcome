package com.bytedance.android.live.platformplayer.layout;

import android.animation.ValueAnimator;
import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements com.bytedance.android.live.core.utils.p0 {
    public final /* synthetic */ LivePlayerWidget a;
    public final /* synthetic */ HSImageView b;
    public final /* synthetic */ HSImageView c;
    public final /* synthetic */ com.bytedance.android.live.base.model.message.y0 d;
    public final /* synthetic */ long e;

    public static final class a extends com.bytedance.android.live.core.utils.q0 {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        public final void f(py.k r1, Exception r2) {
            this.a.c.setVisibility(0);
            this.a.b.setVisibility(8);
        }

        public final void h(py.k r3, int r4, int r5) {
            LivePlayerWidget r6 = this.a.a;
            r6.Q = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            ValueAnimator r7 = this.a.a.Q;
            if (r7 == null) goto L5;
            r7.addUpdateListener(new j(this));
        L5:
            l r8 = this.a;
            ValueAnimator r9 = r8.a.Q;
            if (r9 == null) goto L8;
            r9.setDuration(r8.e);
        L8:
            ValueAnimator r10 = this.a.a.Q;
            if (r10 == null) goto L11;
            r10.addListener(new k(this));
        L11:
            l r11 = this.a;
            LivePlayerWidget r12 = r11.a;
            r12.R = r11.d.getImage();
            ValueAnimator r13 = this.a.a.Q;
            if (r13 == null) goto L15;
            r13.start();
            return;
        }
    }

    public l(LivePlayerWidget r1, HSImageView r2, HSImageView r3, com.bytedance.android.live.base.model.message.y0 r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void b(py.k r1, Exception r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
        this.b.setVisibility(0);
        this.b.setAlpha(1.0f);
        this.c.setAlpha(0.0f);
        ImageLoader.bindImage(this.c, this.d.getImage(), new a(this));
    }
}
