package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.view.DisplayList;
import android.view.HardwareCanvas;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes2.dex */
class RenderNodeV16Impl extends RenderNodeV14Impl {
    public RenderNodeV16Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int r5, int r10) {
        HardwareCanvas r11 = this.displayList.start();
        setViewport(r5, r10, r11);
        r11.onPreDraw(null);
        return r11;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5) {
        drawRenderNode(r5, this.displayList);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r5) {
        ((HardwareCanvas) r5).onPostDraw();
        this.displayList.end();
        this.displayList.setCaching(true);
        this.displayList.setLeftTopRightBottom(this.left, this.top, this.right, this.bottom);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.displayList.isValid();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.sGLESConstructor != null) goto L7;
        Constructor<?> r5 = Class.forName("android.view.GLES20DisplayList").getDeclaredConstructor(new Class[]{String.class});     // Catch: Exception -> L5
        this.sGLESConstructor = r5;     // Catch: Exception -> L5
        r5.setAccessible(true);     // Catch: Exception -> L5
    L7:
        this.displayList = (DisplayList) this.sGLESConstructor.newInstance(new Object[]{""});     // Catch: Exception -> L5
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5, Object r10) {
        ((HardwareCanvas) r5).drawDisplayList((DisplayList) r10, null, 1);
    }
}
