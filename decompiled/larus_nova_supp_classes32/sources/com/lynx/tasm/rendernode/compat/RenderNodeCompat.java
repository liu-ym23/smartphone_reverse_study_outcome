package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class RenderNodeCompat {
    private static boolean sEnable;

    public RenderNodeCompat() {
    }

    public abstract Canvas beginRecording(int r1, int r2);

    public abstract void drawRenderNode(Canvas r1);

    public abstract void drawRenderNode(Canvas r1, Object r2);

    public abstract void endRecording(Canvas r1);

    public abstract Object getRenderNode();

    public abstract boolean hasDisplayList();

    public abstract void init();

    public abstract void setPosition(int r1, int r2, int r3, int r4);

    public static boolean supportRenderNode() {
        return sEnable;
    }

    public static void enable(boolean r0) {
        sEnable = r0;
    }
}
