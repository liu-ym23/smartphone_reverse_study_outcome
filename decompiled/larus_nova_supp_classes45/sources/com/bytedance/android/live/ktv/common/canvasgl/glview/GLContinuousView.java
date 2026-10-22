package com.bytedance.android.live.ktv.common.canvasgl.glview;

import android.content.Context;
import android.util.AttributeSet;
import eb0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class GLContinuousView extends GLView {
    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.GLView
    public abstract void onGLDraw(c r1);

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.GLView
    public void init() {
        super.init();
        setRenderMode(0);
    }

    public GLContinuousView(Context r1) {
        super(r1);
    }

    public GLContinuousView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
