package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.view.DisplayListCanvas;
import android.view.RenderNode;

/* JADX INFO: loaded from: classes2.dex */
class RenderNodeV23Impl extends RenderNodeCompat {
    private RenderNode renderNode;

    public RenderNodeV23Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r5, int r10) {
        return m102beginRecording(r5, r10);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5) {
        ((DisplayListCanvas) r5).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r5) {
        this.renderNode.end((DisplayListCanvas) r5);
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
    public DisplayListCanvas m102beginRecording(int r5, int r10) {
        return this.renderNode.start(r5, r10);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5, Object r10) {
        ((DisplayListCanvas) r5).drawRenderNode((RenderNode) r10);
    }
}
