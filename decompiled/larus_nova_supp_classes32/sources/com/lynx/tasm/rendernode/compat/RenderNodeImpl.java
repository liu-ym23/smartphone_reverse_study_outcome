package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RenderNodeImpl extends RenderNodeCompat {
    private RenderNode renderNode;

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        this.renderNode = new RenderNode(NameKeys.UnloadStrategy_No_Strategy);
    }

    public RenderNodeImpl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.renderNode;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r2) {
        ((RecordingCanvas) r2).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r1) {
        this.renderNode.endRecording();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public RecordingCanvas beginRecording(int r1, int r2) {
        return this.renderNode.beginRecording();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r1, Object r2) {
        r1.drawRenderNode((RenderNode) r2);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r1, int r2) {
        return beginRecording(r1, r2);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r2, int r3, int r4, int r5) {
        this.renderNode.setPosition(r2, r3, r4, r5);
    }
}
