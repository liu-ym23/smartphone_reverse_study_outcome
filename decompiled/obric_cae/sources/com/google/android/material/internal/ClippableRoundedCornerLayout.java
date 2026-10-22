package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {
    public ClippableRoundedCornerLayout(Context r8, AttributeSet r10) {
        super(r8, r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r8) {
        super.dispatchDraw(r8);
    }

    public float getCornerRadius() {
        return 0.0f;
    }
}
