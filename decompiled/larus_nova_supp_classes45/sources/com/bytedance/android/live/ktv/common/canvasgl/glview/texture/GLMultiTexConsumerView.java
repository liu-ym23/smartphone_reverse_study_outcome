package com.bytedance.android.live.ktv.common.canvasgl.glview.texture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class GLMultiTexConsumerView extends BaseGLCanvasTextureView {
    public final List<b> k;

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView
    public final void c() {
    }

    public abstract void i();

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView
    public final void f() {
        super.f();
        ((ArrayList) this.k).clear();
    }

    public GLMultiTexConsumerView(Context r1) {
        super(r1);
        this.k = new ArrayList();
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLCanvasTextureView
    public final void h(eb0.c r2) {
        Iterator r3 = ((ArrayList) this.k).iterator();
        if (r3.hasNext() == true) goto L6;
        i();
        return;
    L6:
        ((b) r3.next()).getClass();
        throw null;
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView
    public /* bridge */ /* synthetic */ void setRenderer(c r1) {
        super.setRenderer(r1);
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView, android.view.TextureView
    public /* bridge */ /* synthetic */ void setSurfaceTextureListener(TextureView.SurfaceTextureListener r1) {
        super.setSurfaceTextureListener(r1);
    }

    public GLMultiTexConsumerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.k = new ArrayList();
    }

    public GLMultiTexConsumerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.k = new ArrayList();
    }
}
