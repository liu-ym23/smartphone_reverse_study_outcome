package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RenderNodeV18Impl extends RenderNodeV16Impl {
    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Object getRenderNode() {
        return super.getRenderNode();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ boolean hasDisplayList() {
        return super.hasDisplayList();
    }

    public RenderNodeV18Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void init() {
        super.init();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void drawRenderNode(Canvas r1) {
        super.drawRenderNode(r1);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r5) {
        this.displayList.end();
        this.displayList.setCaching(true);
        this.displayList.setLeftTopRightBottom(this.left, this.top, this.right, this.bottom);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int r2, int r3) {
        return this.displayList.start(r2, r3);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV16Impl, com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void drawRenderNode(Canvas r1, Object r2) {
        super.drawRenderNode(r1, r2);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ void setPosition(int r1, int r2, int r3, int r4) {
        super.setPosition(r1, r2, r3, r4);
    }
}
