package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f3879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f3880b;
    private final ColorStateList c;
    private final ColorStateList d;
    private final int e;
    private final l f;

    private a(ColorStateList r2, ColorStateList r3, ColorStateList r4, int r5, l r6, Rect r7) {
        Preconditions.checkArgumentNonnegative(r7.left);
        Preconditions.checkArgumentNonnegative(r7.top);
        Preconditions.checkArgumentNonnegative(r7.right);
        Preconditions.checkArgumentNonnegative(r7.bottom);
        this.f3879a = r7;
        this.f3880b = r3;
        this.c = r2;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    static a a(Context r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        if (r14 == 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray r16 = r15.obtainStyledAttributes(r14, R.styleable.MaterialCalendarItem);
        Rect r12 = new Rect(r16.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_android_insetLeft, "styleable", "MaterialCalendarItem_android_insetLeft"), 0), r16.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_android_insetTop, "styleable", "MaterialCalendarItem_android_insetTop"), 0), r16.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_android_insetRight, "styleable", "MaterialCalendarItem_android_insetRight"), 0), r16.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_android_insetBottom, "styleable", "MaterialCalendarItem_android_insetBottom"), 0));
        ColorStateList r7 = com.google.android.material.resources.c.a(r15, r16, ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemFillColor, "styleable", "MaterialCalendarItem_itemFillColor"));
        ColorStateList r8 = com.google.android.material.resources.c.a(r15, r16, ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemTextColor, "styleable", "MaterialCalendarItem_itemTextColor"));
        ColorStateList r9 = com.google.android.material.resources.c.a(r15, r16, ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemStrokeColor, "styleable", "MaterialCalendarItem_itemStrokeColor"));
        int r10 = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemStrokeWidth, "styleable", "MaterialCalendarItem_itemStrokeWidth"), 0);
        l r11 = l.a(r15, r16.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemShapeAppearance, "styleable", "MaterialCalendarItem_itemShapeAppearance"), 0), r16.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, "styleable", "MaterialCalendarItem_itemShapeAppearanceOverlay"), 0)).a();
        r16.recycle();
        return new a(r7, r8, r9, r10, r11, r12);
    L5:
        r1 = false;
        goto L6
    }

    int a() {
        return this.f3879a.top;
    }

    void a(TextView r11) {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        r0.setShapeAppearanceModel(this.f);
        r1.setShapeAppearanceModel(this.f);
        r0.setFillColor(this.c);
        r0.setStroke(this.e, this.d);
        r11.setTextColor(this.f3880b);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Drawable r5 = new RippleDrawable(this.f3880b.withAlpha(30), r0, r1);
    L6:
        ViewCompat.setBackground(r11, new InsetDrawable(r5, this.f3879a.left, this.f3879a.top, this.f3879a.right, this.f3879a.bottom));
        return;
    L5:
        r5 = r0;
        goto L6
    }

    int b() {
        return this.f3879a.bottom;
    }
}
