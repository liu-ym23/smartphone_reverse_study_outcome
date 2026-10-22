package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

/* JADX INFO: loaded from: classes.dex */
class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = null;

    static {
        INSTANCE = new ItemTouchUIUtilImpl();
    }

    ItemTouchUIUtilImpl() {
    }

    private static float findMaxElevation(RecyclerView r10, View r11) {
        int r12 = r10.getChildCount();
        float r13 = 0.0f;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L11;
        View r15 = r10.getChildAt(r14);
        if (r15 == r11) goto L10;
        float r16 = ViewCompat.getElevation(r15);
        if (r16 <= r13) goto L10;
        r13 = r16;
    L10:
        r14 = r14 + 1;
        goto L3
    L11:
        return r13;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View r10) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        int r11 = R.id.item_touch_helper_previous_elevation;
        Object r12 = r10.getTag(r11);
        if ((r12 instanceof Float) == false) goto L7;
        ViewCompat.setElevation(r10, ((Float) r12).floatValue());
    L7:
        r10.setTag(r11, null);
    L8:
        r10.setTranslationX(0.0f);
        r10.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas r10, RecyclerView r11, View r12, float r13, float r14, int r15, boolean r16) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        if (r16 == false) goto L8;
        int r17 = R.id.item_touch_helper_previous_elevation;
        if (r12.getTag(r17) != null) goto L8;
        Float r18 = Float.valueOf(ViewCompat.getElevation(r12));
        ViewCompat.setElevation(r12, findMaxElevation(r11, r12) + 1.0f);
        r12.setTag(r17, r18);
    L8:
        r12.setTranslationX(r13);
        r12.setTranslationY(r14);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas r10, RecyclerView r11, View r12, float r13, float r14, int r15, boolean r16) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View r10) {
    }
}
