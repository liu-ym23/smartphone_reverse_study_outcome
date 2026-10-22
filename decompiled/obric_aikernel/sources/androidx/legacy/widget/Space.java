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
    public Space(@NonNull Context r10) {
        this(r10, null);
    }

    @Deprecated
    public Space(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    @Deprecated
    public Space(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        if (getVisibility() != 0) goto L6;
        setVisibility(4);
        return;
    }

    private static int getDefaultSize2(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        if (r12 == Integer.MIN_VALUE) goto L9;
        if (r12 == 1073741824) goto L10;
        return r10;
    L10:
        return r13;
    L9:
        return Math.min(r10, r13);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    @Deprecated
    public void draw(Canvas r10) {
    }

    @Override // android.view.View
    @Deprecated
    protected void onMeasure(int r10, int r11) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), r10), getDefaultSize2(getSuggestedMinimumHeight(), r11));
    }
}
