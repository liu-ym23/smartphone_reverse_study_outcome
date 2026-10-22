package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IDrawChildHook {

    public interface IDrawChildHookBinding {
        void bindDrawChildHook(IDrawChildHook r1);
    }

    void afterDispatchDraw(Canvas r1);

    void afterDraw(Canvas r1);

    void afterDrawChild(Canvas r1, View r2, long r3);

    void beforeDispatchDraw(Canvas r1);

    void beforeDraw(Canvas r1);

    Rect beforeDrawChild(Canvas r1, View r2, long r3);

    int getChildDrawingOrder(int r1, int r2);

    boolean hasOverlappingRendering();

    void performLayoutChildrenUI();

    void performMeasureChildrenUI();
}
