package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface ItemTouchUIUtil {
    void clearView(View r10);

    void onDraw(Canvas r10, RecyclerView r11, View r12, float r13, float r14, int r15, boolean r16);

    void onDrawOver(Canvas r10, RecyclerView r11, View r12, float r13, float r14, int r15, boolean r16);

    void onSelected(View r10);
}
