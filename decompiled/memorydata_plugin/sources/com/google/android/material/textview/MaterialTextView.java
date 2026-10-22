package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.resources.b;
import com.google.android.material.resources.c;
import com.google.android.material.theme.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public MaterialTextView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), R.attr.textViewStyle);
    }

    public MaterialTextView(Context r3, AttributeSet r4, int r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, 0);
    }

    public MaterialTextView(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r7, r8, r5, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8, r5);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (canApplyTextAppearanceLineHeight(r9) == false) goto L10;
        Resources.Theme r0 = r9.getTheme();
        if (viewAttrsHasLineHeight(r9, r0, r8, r5, r6) == true) goto L11;
        int r10 = findViewAppearanceResourceId(r0, r8, r5, r6);
        if (r10 == (-1)) goto L12;
        applyLineHeightFromViewAppearance(r0, r10);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void applyLineHeightFromViewAppearance(Resources.Theme r5, int r6) {
        TypedArray r7 = r5.obtainStyledAttributes(r6, com.obric.memorydata.plugin.R.styleable.MaterialTextAppearance);
        int r8 = readFirstAvailableDimension((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7, new int[]{ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialTextAppearance_android_lineHeight, "styleable", "MaterialTextAppearance_android_lineHeight"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialTextAppearance_lineHeight, "styleable", "MaterialTextAppearance_lineHeight")});
        r7.recycle();
        if (r8 < 0) goto L6;
        setLineHeight(r8);
        return;
    }

    private static boolean canApplyTextAppearanceLineHeight(Context r3) {
        return b.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.textAppearanceLineHeightEnabled, "attr", "textAppearanceLineHeightEnabled"), true);
    }

    private static int findViewAppearanceResourceId(Resources.Theme r2, AttributeSet r3, int r4, int r5) {
        TypedArray r6 = r2.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), com.obric.memorydata.plugin.R.styleable.MaterialTextView, r4, r5);
        int r7 = r6.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialTextView_android_textAppearance, "styleable", "MaterialTextView_android_textAppearance"), -1);
        r6.recycle();
        return r7;
    }

    private static int readFirstAvailableDimension(Context r4, TypedArray r5, int... r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        int r2 = -1;
    L4:
        if (r1 >= r6.length) goto L7;
        if (r2 >= 0) goto L7;
        r2 = c.a(r7, r5, r6[r1], -1);
        r1 = r1 + 1;
    L7:
        return r2;
    }

    private static boolean viewAttrsHasLineHeight(Context r2, Resources.Theme r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        TypedArray r8 = r3.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), com.obric.memorydata.plugin.R.styleable.MaterialTextView, r5, r6);
        int r9 = readFirstAvailableDimension(r7, r8, new int[]{ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialTextView_android_lineHeight, "styleable", "MaterialTextView_android_lineHeight"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.MaterialTextView_lineHeight, "styleable", "MaterialTextView_lineHeight")});
        r8.recycle();
        if (r9 != (-1)) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super.setTextAppearance(r5, r4);
        if (canApplyTextAppearanceLineHeight(r5) == false) goto L6;
        applyLineHeightFromViewAppearance(r5.getTheme(), r4);
        return;
    }
}
