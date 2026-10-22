package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    void afterDispatchDraw(Canvas r5);

    void afterDraw(Canvas r5);

    void afterDrawChild(Canvas r5, View r10, long r11);

    void beforeDispatchDraw(Canvas r5);

    void beforeDraw(Canvas r5);

    Rect beforeDrawChild(Canvas r5, View r10, long r11);

    int getChildDrawingOrder(int r5, int r10);

    boolean hasOverlappingRendering();

    void performLayoutChildrenUI();

    void performMeasureChildrenUI();
}
