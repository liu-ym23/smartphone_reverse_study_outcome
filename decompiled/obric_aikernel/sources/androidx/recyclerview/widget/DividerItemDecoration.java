package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = null;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "DividerItem";
    public static final int VERTICAL = 1;
    private final Rect mBounds;
    private Drawable mDivider;
    private int mOrientation;

    static {
        ATTRS = new int[]{R.attr.listDivider};
    }

    public DividerItemDecoration(Context r10, int r11) {
        this.mBounds = new Rect();
        TypedArray r12 = r10.obtainStyledAttributes(ATTRS);
        Drawable r13 = r12.getDrawable(0);
        this.mDivider = r13;
        if (r13 != null) goto L5;
        Log.w(TAG, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
    L5:
        r12.recycle();
        setOrientation(r11);
    }

    private void drawHorizontal(Canvas r10, RecyclerView r11) {
        r10.save();
        int r12 = 0;
        if (r11.getClipToPadding() == false) goto L5;
        int r13 = r11.getPaddingTop();
        int r14 = r11.getHeight() - r11.getPaddingBottom();
        r10.clipRect(r11.getPaddingLeft(), r13, r11.getWidth() - r11.getPaddingRight(), r14);
    L6:
        int r15 = r11.getChildCount();
    L7:
        if (r12 >= r15) goto L9;
        View r16 = r11.getChildAt(r12);
        r11.getLayoutManager().getDecoratedBoundsWithMargins(r16, this.mBounds);
        int r17 = this.mBounds.right + Math.round(r16.getTranslationX());
        this.mDivider.setBounds(r17 - this.mDivider.getIntrinsicWidth(), r13, r17, r14);
        this.mDivider.draw(r10);
        r12 = r12 + 1;
        goto L7
    L9:
        r10.restore();
        return;
    L5:
        r14 = r11.getHeight();
        r13 = 0;
        goto L6
    }

    private void drawVertical(Canvas r10, RecyclerView r11) {
        r10.save();
        int r12 = 0;
        if (r11.getClipToPadding() == false) goto L5;
        int r13 = r11.getPaddingLeft();
        int r14 = r11.getWidth() - r11.getPaddingRight();
        r10.clipRect(r13, r11.getPaddingTop(), r14, r11.getHeight() - r11.getPaddingBottom());
    L6:
        int r15 = r11.getChildCount();
    L7:
        if (r12 >= r15) goto L9;
        View r16 = r11.getChildAt(r12);
        r11.getDecoratedBoundsWithMargins(r16, this.mBounds);
        int r17 = this.mBounds.bottom + Math.round(r16.getTranslationY());
        this.mDivider.setBounds(r13, r17 - this.mDivider.getIntrinsicHeight(), r14, r17);
        this.mDivider.draw(r10);
        r12 = r12 + 1;
        goto L7
    L9:
        r10.restore();
        return;
    L5:
        r14 = r11.getWidth();
        r13 = 0;
        goto L6
    }

    @Nullable
    public Drawable getDrawable() {
        return this.mDivider;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        Drawable r14 = this.mDivider;
        if (r14 != null) goto L7;
        r10.set(0, 0, 0, 0);
        return;
    L7:
        if (this.mOrientation != 1) goto L9;
        r10.set(0, 0, 0, r14.getIntrinsicHeight());
        return;
    L9:
        r10.set(0, 0, r14.getIntrinsicWidth(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        if (r11.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.mDivider != null) goto L8;
        return;
    L8:
        if (this.mOrientation != 1) goto L10;
        drawVertical(r10, r11);
        return;
    L10:
        drawHorizontal(r10, r11);
    }

    public void setDrawable(@NonNull Drawable r10) {
        if (r10 == null) goto L6;
        this.mDivider = r10;
        return;
    L6:
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int r10) {
        if (r10 != 0) goto L4;
    L8:
        this.mOrientation = r10;
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
}
