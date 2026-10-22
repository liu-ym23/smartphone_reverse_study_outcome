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
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$styleable;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class CenterIconButton extends AppCompatButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f13195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13197c;
    public int d;
    public int e;

    public CenterIconButton(Context r5) {
        super(r5);
        this.f13196b = 0;
        a(r5, null);
    }

    private int getTextWidth() {
        if (this.f13195a != null) goto L5;
        this.f13195a = new Rect();
    L5:
        TextPaint r5 = getPaint();
        String r10 = getText().toString();
        if (r10.isEmpty() == false) goto L8;
        String r11 = "";
    L28:
        Log.d("CenterIconButton", "text:" + r11);
        r5.getTextBounds(r11, 0, r11.length(), this.f13195a);
        Log.d("CenterIconButton", "textHeight" + this.f13195a.height());
        return this.f13195a.width();
    L8:
        ArrayList r12 = new ArrayList();
        StringTokenizer r13 = new StringTokenizer(r10, "\n", false);
    L10:
        if (r13.hasMoreTokens() == false) goto L13;
        r12.add(r13.nextToken());
        goto L10
    L13:
        if (r12.size() == 1) goto L15;
        r11 = (String) r12.get(0);
        int r14 = 0;
    L20:
        if (r14 >= (r12.size() - 1)) goto L26;
        int r15 = r14 + 1;
        if (((String) r12.get(r15)).length() <= ((String) r12.get(r14)).length()) goto L24;
        r11 = (String) r12.get(r15);
    L24:
        r14 = r15;
        goto L20
    L26:
        if (isAllCaps() == false) goto L28;
        r11 = r11.toUpperCase();
        goto L28
    L15:
        if (isAllCaps() == false) goto L17;
        r11 = ((String) r12.get(0)).toUpperCase();
        goto L28
    L17:
        r11 = (String) r12.get(0);
        goto L28
    }

    public final void a(Context r10, AttributeSet r11) {
        if (r11 == null) goto L27;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OCenterIconButton);
        this.f13196b = r12.getColor(R$styleable.OCenterIconButton_oui_drawableTint, 0);
        this.e = r12.getDimensionPixelSize(R$styleable.OCenterIconButton_oui_drawableSize, a.u(12));
        setCompoundDrawablePadding((int) r12.getDimension(R$styleable.OCenterIconButton_android_drawablePadding, a.u(4)));
        if (this.f13196b == 0) goto L6;
    L7:
        Drawable[] r13 = getCompoundDrawables();
        if (r13.length != 4) goto L26;
        Drawable[] r5 = new Drawable[4];
        int r14 = 0;
    L11:
        if (r14 >= 4) goto L23;
        Drawable r15 = r13[r14];
        if (r15 == null) goto L21;
        if (this.f13196b == 0) goto L18;
        r15 = DrawableCompat.wrap(r15).mutate();
        DrawableCompat.setTint(r15, this.f13196b);
    L18:
        if (this.e <= 0) goto L20;
        Rect r16 = r15.getBounds();
        int r17 = this.e;
        r16.set(0, 0, r17, r17);
    L20:
        r5[r14] = r15;
    L21:
        r14 = r14 + 1;
        goto L11
    L23:
        if (this.e <= 0) goto L25;
        setCompoundDrawables(r5[0], r5[1], r5[2], r5[3]);
        goto L26
    L25:
        setCompoundDrawablesWithIntrinsicBounds(r5[0], r5[1], r5[2], r5[3]);
    L26:
        r12.recycle();
        goto L27
    L6:
        if (this.e == (-1)) goto L26;
    L27:
        this.f13197c = getPaddingLeft();
        this.d = getPaddingRight();
    }

    public final void b(int r10) {
        if (r10 != 0) goto L4;
        return;
    L4:
        Drawable[] r5 = getCompoundDrawables();
        if (r5.length == 4) goto L7;
        return;
    L7:
        Drawable r11 = r5[0];
        Drawable r12 = r5[2];
        if (r11 != null) goto L11;
        if (r12 != null) goto L11;
        return;
    L11:
        int r13 = getTextWidth();
        int r14 = Math.max(getCompoundDrawablePadding(), 1);
        if (r11 != null) goto L14;
        int r15 = 0;
    L15:
        if (r12 != null) goto L17;
        int r16 = 0;
    L18:
        if (r11 == null) goto L21;
        if (r12 == null) goto L21;
        int r17 = ((((r10 - r15) - r16) - r13) - (r14 * 4)) / 2;
    L24:
        Log.d("CenterIconButton", "paddingSize:" + r17);
        Log.d("CenterIconButton", "leftPadding:" + this.f13197c);
        Log.d("CenterIconButton", "rightPadding:" + this.d);
        setIncludeFontPadding(false);
        Log.d("CenterIconButton", "paddingLeft:" + Math.max(this.f13197c, r17));
        Log.d("CenterIconButton", "paddingTop:" + getPaddingTop());
        Log.d("CenterIconButton", "paddingRight:" + Math.max(r17, this.d));
        Log.d("CenterIconButton", "paddingBottom:" + getPaddingBottom());
        super.setPadding(Math.max(this.f13197c, r17), getPaddingTop(), Math.max(r17, this.d), getPaddingBottom());
        return;
    L21:
        if (r11 == null) goto L23;
        r17 = (((r10 - r15) - r14) - r13) / 2;
        goto L24
    L23:
        r17 = (((r10 - r16) - r14) - r13) / 2;
        goto L24
    L17:
        r16 = r12.getBounds().width();
        goto L18
    L14:
        r15 = r11.getBounds().width();
        goto L15
    }

    @Override // android.widget.TextView
    public final boolean isAllCaps() {
        TransformationMethod r5 = getTransformationMethod();
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.getClass().getSimpleName().equals("AllCapsTransformationMethod");
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        b(r5);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r5, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r5, r10, r11, r12);
        b(getMeasuredWidth());
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable r5, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesWithIntrinsicBounds(r5, r10, r11, r12);
        b(getMeasuredWidth());
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r5, int r10, int r11, int r12) {
        super.setPadding(r5, r10, r11, r12);
        this.f13197c = r5;
        this.d = r11;
        b(getMeasuredWidth());
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r5, TextView.BufferType r10) {
        super.setText(r5, r10);
        b(getMeasuredWidth());
    }

    public CenterIconButton(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f13196b = 0;
        a(r5, r10);
    }

    public CenterIconButton(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f13196b = 0;
        a(r5, r10);
    }
}
