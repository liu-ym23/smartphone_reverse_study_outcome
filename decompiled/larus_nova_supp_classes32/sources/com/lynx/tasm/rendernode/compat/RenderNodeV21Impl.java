package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.view.HardwareCanvas;
import android.view.RenderNode;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class RenderNodeV21Impl extends RenderNodeCompat {
    private static Method sStartMethod;
    private RenderNode renderNode;

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
        this.renderNode = RenderNode.create(NameKeys.UnloadStrategy_No_Strategy, null);
    }

    public RenderNodeV21Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.renderNode;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r2) {
        ((HardwareCanvas) r2).drawRenderNode(this.renderNode);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r2) {
        this.renderNode.end((HardwareCanvas) r2);
    }

    /* JADX INFO: renamed from: beginRecording, reason: collision with other method in class */
    public HardwareCanvas m26beginRecording(int r8, int r9) {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sStartMethod != null) goto L5;
        Class r6 = Integer.TYPE;     // Catch: Exception -> L7
        Method r0 = RenderNode.class.getDeclaredMethod("start", new Class[]{r6, r6});     // Catch: Exception -> L7
        sStartMethod = r0;     // Catch: Exception -> L7
        r0.setAccessible(true);     // Catch: Exception -> L7
    L5:
        return (HardwareCanvas) sStartMethod.invoke(this.renderNode, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9)});
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r1, Object r2) {
        ((HardwareCanvas) r1).drawRenderNode((RenderNode) r2);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public /* bridge */ /* synthetic */ Canvas beginRecording(int r1, int r2) {
        return m26beginRecording(r1, r2);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r2, int r3, int r4, int r5) {
        this.renderNode.setLeftTopRightBottom(r2, r3, r4, r5);
    }
}
