package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ClippableRoundedCornerLayout extends FrameLayout {
    private float cornerRadius;

    @Nullable
    private Path path;

    public ClippableRoundedCornerLayout(@NonNull Context r5) {
        super(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r5) {
        if (this.path != null) goto L6;
        super.dispatchDraw(r5);
        return;
    L6:
        int r10 = r5.save();
        r5.clipPath(this.path);
        super.dispatchDraw(r5);
        r5.restoreToCount(r10);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void resetClipBoundsAndCornerRadius() {
        this.path = null;
        this.cornerRadius = 0.0f;
        invalidate();
    }

    public void updateClipBoundsAndCornerRadius(@NonNull Rect r10, float r11) {
        updateClipBoundsAndCornerRadius(r10.left, r10.top, r10.right, r10.bottom, r11);
    }

    public void updateCornerRadius(float r10) {
        updateClipBoundsAndCornerRadius(getLeft(), getTop(), getRight(), getBottom(), r10);
    }

    public ClippableRoundedCornerLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
    }

    public void updateClipBoundsAndCornerRadius(float r5, float r10, float r11, float r12, float r13) {
        updateClipBoundsAndCornerRadius(new RectF(r5, r10, r11, r12), r13);
    }

    public ClippableRoundedCornerLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }

    public void updateClipBoundsAndCornerRadius(@NonNull RectF r5, float r10) {
        if (this.path != null) goto L5;
        this.path = new Path();
    L5:
        this.cornerRadius = r10;
        this.path.reset();
        this.path.addRoundRect(r5, r10, r10, Path.Direction.CW);
        this.path.close();
        invalidate();
    }
}
