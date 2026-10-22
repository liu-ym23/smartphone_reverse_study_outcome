package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RenderNodeCompat {
    private static boolean sEnable;

    public RenderNodeCompat() {
    }

    public static void enable(boolean r5) {
        sEnable = r5;
    }

    public static boolean supportRenderNode() {
        return sEnable;
    }

    public abstract Canvas beginRecording(int r5, int r10);

    public abstract void drawRenderNode(Canvas r5);

    public abstract void drawRenderNode(Canvas r5, Object r10);

    public abstract void endRecording(Canvas r5);

    public abstract Object getRenderNode();

    public abstract boolean hasDisplayList();

    public abstract void init();

    public abstract void setPosition(int r5, int r10, int r11, int r12);
}
