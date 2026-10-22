package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

/* JADX INFO: loaded from: classes.dex */
class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = null;

    static {
        INSTANCE = new ItemTouchUIUtilImpl();
    }

    public ItemTouchUIUtilImpl() {
    }

    private static float findMaxElevation(RecyclerView r5, View r10) {
        int r11 = r5.getChildCount();
        float r12 = 0.0f;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L11;
        View r14 = r5.getChildAt(r13);
        if (r14 == r10) goto L10;
        float r15 = ViewCompat.getElevation(r14);
        if (r15 <= r12) goto L10;
        r12 = r15;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        return r12;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(@NonNull View r5) {
        Object r10 = r5.getTag(R.id.item_touch_helper_previous_elevation);
        if ((r10 instanceof Float) == false) goto L5;
        ViewCompat.setElevation(r5, ((Float) r10).floatValue());
    L5:
        r5.setTag(R.id.item_touch_helper_previous_elevation, null);
        r5.setTranslationX(0.0f);
        r5.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(@NonNull Canvas r5, @NonNull RecyclerView r10, @NonNull View r11, float r12, float r13, int r14, boolean r15) {
        if (r15 == true) goto L4;
    L6:
        r11.setTranslationX(r12);
        r11.setTranslationY(r13);
        return;
    L4:
        if (r11.getTag(R.id.item_touch_helper_previous_elevation) != null) goto L6;
        Float r16 = Float.valueOf(ViewCompat.getElevation(r11));
        ViewCompat.setElevation(r11, findMaxElevation(r10, r11) + 1.0f);
        r11.setTag(R.id.item_touch_helper_previous_elevation, r16);
        goto L6
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(@NonNull Canvas r5, @NonNull RecyclerView r10, @NonNull View r11, float r12, float r13, int r14, boolean r15) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(@NonNull View r5) {
    }
}
