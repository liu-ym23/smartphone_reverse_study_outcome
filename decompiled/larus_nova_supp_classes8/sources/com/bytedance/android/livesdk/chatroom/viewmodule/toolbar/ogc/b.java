package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc;

import android.view.View;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends BaseAnimationListener {
    public int a;
    public final /* synthetic */ c b;
    public final /* synthetic */ int c;

    public final void onAnimationStart(AnimatedDrawable2 r2) {
        this.a = -1;
        View r3 = this.b.a.g;
        if (r3 == null) goto L6;
        r3.setBackground(null);
        return;
    }

    public final void onAnimationStop(AnimatedDrawable2 r2) {
        OgcVSWebActivityBehavior r3 = this.b.a;
        View r0 = r3.g;
        if (r0 == null) goto L5;
        r0.setBackground(r3.h);
    L5:
        this.b.b.setVisibility(8);
    }

    public b(c r1, int r2) {
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
        this.b.b.setVisibility(8);
        this.b.b.setController(null);
        return;
    L5:
        if (this.c <= 1) goto L8;
        goto L6
    }
}
