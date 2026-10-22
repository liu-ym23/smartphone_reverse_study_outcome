package androidx.legacy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Space extends View {
    @Deprecated
    public Space(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        if (getVisibility() != 0) goto L6;
        setVisibility(4);
        return;
    }

    private static int getDefaultSize2(int r5, int r10) {
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        if (r11 == Integer.MIN_VALUE) goto L9;
        if (r11 == 1073741824) goto L10;
        return r5;
    L10:
        return r12;
    L9:
        return Math.min(r5, r12);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas r5) {
    }

    @Override // android.view.View
    @Deprecated
    public void onMeasure(int r5, int r10) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), r5), getDefaultSize2(getSuggestedMinimumHeight(), r10));
    }

    @Deprecated
    public Space(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    @Deprecated
    public Space(@NonNull Context r5) {
        this(r5, null);
    }
}
