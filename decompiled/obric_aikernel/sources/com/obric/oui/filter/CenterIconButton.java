package com.obric.oui.filter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.oui.common.util.f;
import java.util.ArrayList;
import java.util.StringTokenizer;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
public class CenterIconButton extends AppCompatButton {
    private static final String DELIMITERS = "\n";
    private static final int DRAWABLES_LENGTH = 4;
    private static final int DRAWABLE_BOTTOM_POSITION = 3;
    private static final int DRAWABLE_LEFT_POSITION = 0;
    private static final int DRAWABLE_RIGHT_POSITION = 2;
    private static final int DRAWABLE_TOP_POSITION = 1;
    protected int mDrawableSize;
    protected int mLeftPadding;
    protected int mRightPadding;

    @ColorInt
    protected int mTintColor;
    private Rect textBoundsRect;

    public CenterIconButton(Context r10) {
        super(r10);
        this.mTintColor = 0;
        init(r10, null);
    }

    public CenterIconButton(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mTintColor = 0;
        init(r10, r11);
    }

    public CenterIconButton(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mTintColor = 0;
        init(r10, r11);
    }

    private String divideText() {
        String r10 = getText().toString();
        if (r10.isEmpty() == false) goto L6;
        return "";
    L6:
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        StringTokenizer r13 = new StringTokenizer(r10, DELIMITERS, false);
    L8:
        if (r13.hasMoreTokens() == false) goto L11;
        r11.add(r13.nextToken());
        goto L8
    L11:
        if (r11.size() == 1) goto L13;
        String r14 = (String) r11.get(0);
    L19:
        if (r12 >= (r11.size() - 1)) goto L25;
        int r15 = r12 + 1;
        if (((String) r11.get(r15)).length() <= ((String) r11.get(r12)).length()) goto L23;
        r14 = (String) r11.get(r15);
    L23:
        r12 = r15;
        goto L19
    L25:
        if (isAllCaps() == true) goto L27;
        return r14;
    L27:
        return r14.toUpperCase();
    L13:
        if (isAllCaps() == false) goto L16;
        return ((String) r11.get(0)).toUpperCase();
    L16:
        return (String) r11.get(0);
    }

    private int getTextWidth() {
        if (this.textBoundsRect != null) goto L5;
        this.textBoundsRect = new Rect();
    L5:
        TextPaint r10 = getPaint();
        String r11 = divideText();
        Log.d("CenterIconButton", "text:" + r11);
        r10.getTextBounds(r11, 0, r11.length(), this.textBoundsRect);
        Log.d("CenterIconButton", "textHeight" + this.textBoundsRect.height());
        return this.textBoundsRect.width();
    }

    @NonNull
    private Drawable getTintedDrawable(@NonNull Drawable r10) {
        Drawable r11 = DrawableCompat.wrap(r10).mutate();
        DrawableCompat.setTint(r11, this.mTintColor);
        return r11;
    }

    private void init(Context r10, AttributeSet r11) {
        if (r11 == null) goto L4;
        TypedArray r12 = r10.obtainStyledAttributes(r11, l.OCenterIconButton);
        this.mTintColor = r12.getColor(l.OCenterIconButton_oui_drawableTint, 0);
        this.mDrawableSize = r12.getDimensionPixelSize(l.OCenterIconButton_oui_drawableSize, f.b(12));
        setCompoundDrawablePadding((int) r12.getDimension(l.OCenterIconButton_android_drawablePadding, f.b(4)));
        updateDrawables();
        r12.recycle();
    L4:
        this.mLeftPadding = getPaddingLeft();
        this.mRightPadding = getPaddingRight();
    }

    @NonNull
    private Drawable updateDrawableBounds(@NonNull Drawable r10) {
        Rect r11 = r10.getBounds();
        int r12 = this.mDrawableSize;
        r11.set(0, 0, r12, r12);
        return r10;
    }

    private void updatePadding() {
        updatePadding(getMeasuredWidth());
    }

    private void updatePadding(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        Drawable[] r11 = getCompoundDrawables();
        if (r11.length == 4) goto L7;
        return;
    L7:
        Drawable r12 = r11[0];
        Drawable r13 = r11[2];
        if (r12 != null) goto L11;
        if (r13 != null) goto L11;
        return;
    L11:
        int r14 = getTextWidth();
        int r15 = Math.max(getCompoundDrawablePadding(), 1);
        if (r12 != null) goto L14;
        int r16 = 0;
    L15:
        if (r13 != null) goto L17;
        int r17 = 0;
    L18:
        if (r12 == null) goto L21;
        if (r13 == null) goto L21;
        int r18 = (((r10 - r16) - r17) - r14) - (r15 * 4);
    L25:
        int r19 = r18 / 2;
        Log.d("CenterIconButton", "paddingSize:" + r19);
        Log.d("CenterIconButton", "leftPadding:" + this.mLeftPadding);
        Log.d("CenterIconButton", "rightPadding:" + this.mRightPadding);
        setIncludeFontPadding(false);
        Log.d("CenterIconButton", "paddingLeft:" + Math.max(this.mLeftPadding, r19));
        Log.d("CenterIconButton", "paddingTop:" + getPaddingTop());
        Log.d("CenterIconButton", "paddingRight:" + Math.max(r19, this.mRightPadding));
        Log.d("CenterIconButton", "paddingBottom:" + getPaddingBottom());
        super.setPadding(Math.max(this.mLeftPadding, r19), getPaddingTop(), Math.max(r19, this.mRightPadding), getPaddingBottom());
        return;
    L21:
        if (r12 == null) goto L23;
        int r110 = r10 - r16;
    L24:
        r18 = (r110 - r15) - r14;
        goto L25
    L23:
        r110 = r10 - r17;
        goto L24
    L17:
        r17 = r13.getBounds().width();
        goto L18
    L14:
        r16 = r12.getBounds().width();
        goto L15
    }

    @Override // android.widget.TextView
    public boolean isAllCaps() {
        TransformationMethod r10 = getTransformationMethod();
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.getClass().getSimpleName().equals("AllCapsTransformationMethod");
    }

    @Override // android.view.View
    protected void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        updatePadding(r10);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        updatePadding();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        super.setCompoundDrawablesWithIntrinsicBounds(r10, r11, r12, r13);
        updatePadding();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        super.setPadding(r10, r11, r12, r13);
        this.mLeftPadding = r10;
        this.mRightPadding = r12;
        updatePadding();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r10, TextView.BufferType r11) {
        super.setText(r10, r11);
        updatePadding();
    }

    public void updateDrawables() {
        if (this.mTintColor == 0) goto L5;
    L6:
        Drawable[] r10 = getCompoundDrawables();
        if (r10.length == 4) goto L9;
        return;
    L9:
        Drawable[] r11 = new Drawable[4];
        int r12 = 0;
    L10:
        if (r12 >= 4) goto L22;
        Drawable r13 = r10[r12];
        if (r13 == null) goto L20;
        if (this.mTintColor == 0) goto L17;
        r13 = getTintedDrawable(r13);
    L17:
        if (this.mDrawableSize <= 0) goto L19;
        r13 = updateDrawableBounds(r13);
    L19:
        r11[r12] = r13;
    L20:
        r12 = r12 + 1;
        goto L10
    L22:
        if (this.mDrawableSize <= 0) goto L24;
        setCompoundDrawables(r11[0], r11[1], r11[2], r11[3]);
        return;
    L24:
        setCompoundDrawablesWithIntrinsicBounds(r11[0], r11[1], r11[2], r11[3]);
        return;
    L5:
        if (this.mDrawableSize != (-1)) goto L6;
    }
}
