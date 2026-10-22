package com.bytedance.android.livesdk.gift.fastgift;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends BaseAnimationListener {
    public int a;
    public final /* synthetic */ v b;
    public final /* synthetic */ int c;

    public final void onAnimationStart(AnimatedDrawable2 r1) {
        this.a = -1;
    }

    public u(v r1, int r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r4, int r5) {
        int r0 = this.a;
        if (r0 == 0) goto L5;
    L6:
        if (r0 > r5) goto L8;
        this.a = r5;
        return;
    L8:
        if (r4 == null) goto L10;
        r4.stop();
    L10:
        v r6 = this.b;
        if (r6.b != 1) goto L15;
        AutoRTLImageView r7 = r6.a.a(2131372145);
        if (r7 == null) goto L15;
        r7.setVisibility(0);
    L15:
        HSImageView r8 = this.b.a.a(2131382756);
        if (r8 == null) goto L18;
        r8.setVisibility(8);
    L18:
        HSImageView r9 = this.b.a.a(2131382756);
        if (r9 == null) goto L23;
        r9.setController(null);
        return;
    L23:
        return;
    L5:
        if (this.c <= 1) goto L8;
        goto L6
    }
}
