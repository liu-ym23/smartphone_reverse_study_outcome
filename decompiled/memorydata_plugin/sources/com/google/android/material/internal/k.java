package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.TintTypedArray;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f3980a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f3981b = null;

    static {
        f3980a = new int[]{ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary")};
        f3981b = new int[]{ZeusTransformUtils.mapRes(R.attr.colorPrimaryVariant, "attr", "colorPrimaryVariant")};
    }

    public static TypedArray a(Context r8, AttributeSet r9, int[] r10, int r11, int r12, int... r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        a(r14, r15, r11, r12);
        c(r14, r15, r10, r11, r12, r13);
        return r14.obtainStyledAttributes(r15, r10, r11, r12);
    }

    public static void a(Context r2) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), f3980a, "Theme.AppCompat");
    }

    private static void a(Context r2, AttributeSet r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        TypedArray r7 = r6.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.ThemeEnforcement, r4, r5);
        boolean r8 = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ThemeEnforcement_enforceMaterialTheme, "styleable", "ThemeEnforcement_enforceMaterialTheme"), false);
        r7.recycle();
        if (r8 == false) goto L11;
        TypedValue r9 = new TypedValue();
        if (r6.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.isMaterialTheme, "attr", "isMaterialTheme"), r9, true) == true) goto L7;
    L10:
        b(r6);
        goto L11
    L7:
        if (r9.type != 18) goto L11;
        if (r9.data == 0) goto L10;
    L11:
        a(r6);
    }

    private static void a(Context r2, int[] r3, String r4) {
        if (a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + r4 + " (or a descendant).");
    }

    private static boolean a(Context r3, int[] r4) {
        TypedArray r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r4);
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L10;
        if (r5.hasValue(r1) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        r5.recycle();
        return false;
    L10:
        r5.recycle();
        return true;
    }

    public static TintTypedArray b(Context r8, AttributeSet r9, int[] r10, int r11, int r12, int... r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        a(r14, r15, r11, r12);
        c(r14, r15, r10, r11, r12, r13);
        return TintTypedArray.obtainStyledAttributes(r14, r15, r10, r11, r12);
    }

    public static void b(Context r2) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), f3981b, "Theme.MaterialComponents");
    }

    private static void c(Context r8, AttributeSet r9, int[] r10, int r11, int r12, int... r13) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r14 = r2.obtainStyledAttributes(r3, R.styleable.ThemeEnforcement, r11, r12);
        boolean r1 = false;
        if (r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ThemeEnforcement_enforceTextAppearance, "styleable", "ThemeEnforcement_enforceTextAppearance"), false) == true) goto L6;
        r14.recycle();
        return;
    L6:
        if (r13 == null) goto L12;
        if (r13.length == 0) goto L12;
        boolean r15 = d(r2, r3, r10, r11, r12, r13);
    L15:
        r14.recycle();
        if (r15 == false) goto L19;
        return;
    L19:
        throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    L12:
        if (r14.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ThemeEnforcement_android_textAppearance, "styleable", "ThemeEnforcement_android_textAppearance"), -1) == (-1)) goto L14;
        r1 = true;
    L14:
        r15 = r1;
        goto L15
    }

    private static boolean d(Context r2, AttributeSet r3, int[] r4, int r5, int r6, int... r7) {
        TypedArray r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        int r9 = r7.length;
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L9;
        if (r8.getResourceId(r7[r10], -1) == (-1)) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        r8.recycle();
        return false;
    L9:
        r8.recycle();
        return true;
    }
}
