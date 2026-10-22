package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;

/* JADX INFO: loaded from: classes2.dex */
public class RenderNodeImpl extends RenderNodeCompat {
    private RenderNode renderNode;

    public RenderNodeImpl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r5, int r10) {
        return beginRecording(r5, r10);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5) {
        ((RecordingCanvas) r5).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r5) {
        this.renderNode.endRecording();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.renderNode;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        this.renderNode = new RenderNode("");
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r5, int r10, int r11, int r12) {
        this.renderNode.setPosition(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public RecordingCanvas beginRecording(int r5, int r10) {
        return this.renderNode.beginRecording();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r5, Object r10) {
        r5.drawRenderNode((RenderNode) r10);
    }
}
