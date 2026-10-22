package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class RenderNodeV23Impl extends RenderNodeCompat {
    private RenderNode renderNode;

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        this.renderNode = RenderNode.create(NameKeys.UnloadStrategy_No_Strategy, null);
    }

    public RenderNodeV23Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.renderNode;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r2) {
        ((DisplayListCanvas) r2).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r2) {
        this.renderNode.end((DisplayListCanvas) r2);
    }

    /* JADX INFO: renamed from: beginRecording, reason: collision with other method in class */
    public DisplayListCanvas m27beginRecording(int r2, int r3) {
        return this.renderNode.start(r2, r3);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r1, Object r2) {
        ((DisplayListCanvas) r1).drawRenderNode((RenderNode) r2);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r1, int r2) {
        return m27beginRecording(r1, r2);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r2, int r3, int r4, int r5) {
        this.renderNode.setLeftTopRightBottom(r2, r3, r4, r5);
    }
}
