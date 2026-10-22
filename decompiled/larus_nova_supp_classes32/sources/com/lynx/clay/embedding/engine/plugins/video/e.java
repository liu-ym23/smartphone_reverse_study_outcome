package com.lynx.clay.embedding.engine.plugins.video;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.android.FlutterSurfaceView;
import com.lynx.clay.embedding.android.FlutterTextureView;
import com.lynx.clay.embedding.android.FlutterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements d {
    public FlutterView a;
    public View b;
    public a c;

    public e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final int c() {
        return 0;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void detach() {
        View r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        this.b = null;
        this.a = null;
        a r1 = this.c;
        if (r1 == null) goto L11;
        r1.c();
        this.c = null;
        return;
    L11:
        return;
    L5:
        if (r0.getParent() == null) goto L7;
        ((ViewGroup) r0.getParent()).removeView(r0);
        goto L7
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void dispose() {
        detach();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void a(FlutterView r3, a r4) {
        this.a = r3;
        View r0 = r4.createView(r3.getContext());
        this.b = r0;
        if (r0 == null) goto L11;
        ViewParent r1 = r0.getParent();
        if (r1 == r3) goto L11;
        if (r1 == null) goto L10;
        ((ViewGroup) r1).removeView(r0);
    L10:
        r3.addView(r0, -1);
    L11:
        View r5 = r3.getChildAt(0);
        if ((r5 instanceof FlutterSurfaceView) == false) goto L14;
    L15:
        r5.bringToFront();
    L16:
        this.c = r4;
        return;
    L14:
        if ((r5 instanceof FlutterTextureView) == false) goto L16;
        goto L15
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.d
    public final void b(int r2, int r3, int r4, int r5) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.b == null) goto L23;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(r4, r5);     // Catch: Throwable -> L13
        r0.leftMargin = r2;     // Catch: Throwable -> L13
        r0.topMargin = r3;     // Catch: Throwable -> L13
        this.b.setLayoutParams(r0);     // Catch: Throwable -> L13
        View r6 = this.a.getChildAt(0);     // Catch: Throwable -> L13
        if ((r6 instanceof FlutterSurfaceView) == false) goto L9;
    L10:
        r6.bringToFront();     // Catch: Throwable -> L13
    L11:
        this.b.setVisibility(0);     // Catch: Throwable -> L13
    L15:
        a r7 = this.c;
        if (r7 == null) goto L18;
        r7.e();
    L18:
        this.b.requestLayout();
        return;
    L9:
        if ((r6 instanceof FlutterTextureView) == false) goto L11;
    L13:
        th = move-exception;
        c5a.c.d(6, "VideoRendererHybrid", "onDisplay " + th);
        goto L15
    }
}
