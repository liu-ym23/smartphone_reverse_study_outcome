package androidx.recyclerview.widget;

import android.R;
import android.annotation.SuppressLint;
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

    @SuppressLint({"UnknownNullness"})
    public DividerItemDecoration(Context r5, int r10) {
        this.mBounds = new Rect();
        TypedArray r11 = r5.obtainStyledAttributes(ATTRS);
        Drawable r12 = r11.getDrawable(0);
        this.mDivider = r12;
        if (r12 != null) goto L5;
        Log.w(TAG, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
    L5:
        r11.recycle();
        setOrientation(r10);
    }

    private void drawHorizontal(Canvas r10, RecyclerView r11) {
        r10.save();
        int r5 = 0;
        if (r11.getClipToPadding() == false) goto L5;
        int r12 = r11.getPaddingTop();
        int r13 = r11.getHeight() - r11.getPaddingBottom();
        r10.clipRect(r11.getPaddingLeft(), r12, r11.getWidth() - r11.getPaddingRight(), r13);
    L6:
        int r14 = r11.getChildCount();
    L7:
        if (r5 >= r14) goto L9;
        View r15 = r11.getChildAt(r5);
        r11.getLayoutManager().getDecoratedBoundsWithMargins(r15, this.mBounds);
        int r16 = Math.round(r15.getTranslationX()) + this.mBounds.right;
        this.mDivider.setBounds(r16 - this.mDivider.getIntrinsicWidth(), r12, r16, r13);
        this.mDivider.draw(r10);
        r5 = r5 + 1;
        goto L7
    L9:
        r10.restore();
        return;
    L5:
        r13 = r11.getHeight();
        r12 = 0;
        goto L6
    }

    private void drawVertical(Canvas r10, RecyclerView r11) {
        r10.save();
        int r5 = 0;
        if (r11.getClipToPadding() == false) goto L5;
        int r12 = r11.getPaddingLeft();
        int r13 = r11.getWidth() - r11.getPaddingRight();
        r10.clipRect(r12, r11.getPaddingTop(), r13, r11.getHeight() - r11.getPaddingBottom());
    L6:
        int r14 = r11.getChildCount();
    L7:
        if (r5 >= r14) goto L9;
        View r15 = r11.getChildAt(r5);
        r11.getDecoratedBoundsWithMargins(r15, this.mBounds);
        int r16 = Math.round(r15.getTranslationY()) + this.mBounds.bottom;
        this.mDivider.setBounds(r12, r16 - this.mDivider.getIntrinsicHeight(), r13, r16);
        this.mDivider.draw(r10);
        r5 = r5 + 1;
        goto L7
    L9:
        r10.restore();
        return;
    L5:
        r13 = r11.getWidth();
        r12 = 0;
        goto L6
    }

    @Nullable
    public Drawable getDrawable() {
        return this.mDivider;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect r5, View r10, RecyclerView r11, RecyclerView.State r12) {
        Drawable r13 = this.mDivider;
        if (r13 != null) goto L7;
        r5.set(0, 0, 0, 0);
        return;
    L7:
        if (this.mOrientation != 1) goto L9;
        r5.set(0, 0, 0, r13.getIntrinsicHeight());
        return;
    L9:
        r5.set(0, 0, r13.getIntrinsicWidth(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas r5, RecyclerView r10, RecyclerView.State r11) {
        if (r10.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.mDivider != null) goto L8;
        return;
    L8:
        if (this.mOrientation != 1) goto L10;
        drawVertical(r5, r10);
        return;
    L10:
        drawHorizontal(r5, r10);
    }

    public void setDrawable(@NonNull Drawable r5) {
        if (r5 == null) goto L6;
        this.mDivider = r5;
        return;
    L6:
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int r5) {
        if (r5 != 0) goto L4;
    L8:
        this.mOrientation = r5;
        return;
    L4:
        if (r5 == 1) goto L8;
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
}
