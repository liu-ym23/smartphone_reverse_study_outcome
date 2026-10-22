package com.bytedance.android.live.ktv.common.canvasgl.glview.texture;

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLES20;
import android.util.AttributeSet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fb0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
abstract class BaseGLCanvasTextureView extends BaseGLTextureView implements c, lb0.c {
    public eb0.b h;
    public boolean i;
    public long j;

    public abstract void h(eb0.c r1);

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c
    public final void a() {
        this.h = new eb0.b();
        this.j = ThreadMethodProxy.currentThread().getId();
        gb0.a.d();
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c
    public final void b() {
        gb0.a r0 = gb0.a.c();
        if (this.i == false) goto L6;
        if (r0 == null) goto L6;
        requestRender();
        gb0.a.b r3 = r0.e;
        long r4 = r0.a;
        r3.postDelayed(new gb0.a.c(r3, this, r4), r4);
        this.i = false;
    L6:
        eb0.b r1 = this.h;
        r1.d[1] = Color.red(0) / 255.0f;
        r1.d[2] = Color.green(0) / 255.0f;
        r1.d[3] = Color.blue(0) / 255.0f;
        r1.d[0] = Color.alpha(0) / 255.0f;
        fb0.c r2 = r1.b;
        float[] r5 = r1.d;
        ((e) r2).getClass();
        GLES20.glClearColor(r5[1], r5[2], r5[3], r5[0]);
        GLES20.glClear(16384);
        h(this.h);
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView
    public final void e() {
        super.e();
        setOpaque(false);
        setRenderer(this);
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        long r0 = this.j;
        gb0.a r2 = gb0.a.k.get(Long.valueOf(r0));
        if (r2 != null) goto L5;
        r2 = gb0.a.l.get(Long.valueOf(r0));
    L5:
        if (r2 == null) goto L7;
        r2.e();
    L7:
        this.i = true;
    }

    public BaseGLCanvasTextureView(Context r1) {
        super(r1);
        this.i = true;
    }

    public BaseGLCanvasTextureView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.i = true;
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c
    public final void onSurfaceChanged(int r2, int r3) {
        eb0.b r0 = this.h;
        r0.e = r2;
        r0.f = r3;
        ((e) r0.b).c(r2, r3);
    }

    public BaseGLCanvasTextureView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.i = true;
    }
}
