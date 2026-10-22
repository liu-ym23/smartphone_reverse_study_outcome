package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface ItemTouchUIUtil {
    @SuppressLint({"UnknownNullness"})
    void clearView(View r5);

    @SuppressLint({"UnknownNullness"})
    void onDraw(Canvas r5, RecyclerView r10, View r11, float r12, float r13, int r14, boolean r15);

    @SuppressLint({"UnknownNullness"})
    void onDrawOver(Canvas r5, RecyclerView r10, View r11, float r12, float r13, int r14, boolean r15);

    @SuppressLint({"UnknownNullness"})
    void onSelected(View r5);
}
