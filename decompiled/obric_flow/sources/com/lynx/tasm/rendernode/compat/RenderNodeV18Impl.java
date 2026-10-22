package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes2.dex */
public class RenderNodeV18Impl extends RenderNodeV16Impl {
    public RenderNodeV18Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int r5, int r10) {
        return this.displayList.start(r5, r10);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void drawRenderNode(Canvas r5) {
        super.drawRenderNode(r5);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r5) {
        this.displayList.end();
        this.displayList.setCaching(true);
        this.displayList.setLeftTopRightBottom(this.left, this.top, this.right, this.bottom);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Object getRenderNode() {
        return super.getRenderNode();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ boolean hasDisplayList() {
        return super.hasDisplayList();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void init() {
        super.init();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void setPosition(int r5, int r10, int r11, int r12) {
        super.setPosition(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void drawRenderNode(Canvas r5, Object r10) {
        super.drawRenderNode(r5, r10);
    }
}
