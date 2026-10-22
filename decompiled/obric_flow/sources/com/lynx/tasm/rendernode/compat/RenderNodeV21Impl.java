package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.view.HardwareCanvas;
import android.view.RenderNode;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class RenderNodeV21Impl extends RenderNodeCompat {
    private static Method sStartMethod;
    private RenderNode renderNode;

    public RenderNodeV21Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r5, int r10) {
        return m101beginRecording(r5, r10);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5) {
        ((HardwareCanvas) r5).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r5) {
        this.renderNode.end((HardwareCanvas) r5);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.renderNode;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        this.renderNode = RenderNode.create("", null);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r5, int r10, int r11, int r12) {
        this.renderNode.setLeftTopRightBottom(r5, r10, r11, r12);
    }

    /* JADX INFO: renamed from: beginRecording, reason: collision with other method in class */
    public HardwareCanvas m101beginRecording(int r5, int r10) {
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sStartMethod != null) goto L7;
        Class r11 = Integer.TYPE;     // Catch: Exception -> L5
        Method r12 = RenderNode.class.getDeclaredMethod("start", new Class[]{r11, r11});     // Catch: Exception -> L5
        sStartMethod = r12;     // Catch: Exception -> L5
        r12.setAccessible(true);     // Catch: Exception -> L5
    L7:
        return (HardwareCanvas) sStartMethod.invoke(this.renderNode, new Object[]{Integer.valueOf(r5), Integer.valueOf(r10)});
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5, Object r10) {
        ((HardwareCanvas) r5).drawRenderNode((RenderNode) r10);
    }
}
