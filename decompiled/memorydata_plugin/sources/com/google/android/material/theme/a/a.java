package com.google.android.material.theme.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.ContextThemeWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f4181a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f4182b = null;

    static {
        f4181a = new int[]{R.attr.theme, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.theme, "attr", "theme")};
        f4182b = new int[]{ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.materialThemeOverlay, "attr", "materialThemeOverlay")};
    }

    private static int a(Context r2, AttributeSet r3) {
        TypedArray r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), f4181a);
        int r0 = r4.getResourceId(0, 0);
        int r5 = r4.getResourceId(1, 0);
        r4.recycle();
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return r5;
    }

    public static Context a(Context r2, AttributeSet r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        int r8 = b(r6, r7, r4, r5);
        if (ZeusTransformUtils.instanceOf(r6, ContextThemeWrapper.class) == true) goto L5;
    L7:
        boolean r9 = false;
    L8:
        if (r8 == 0) goto L15;
        if (r9 == true) goto L15;
        ContextThemeWrapper r10 = new ContextThemeWrapper(r6, r8);
        int r11 = a(r6, r7);
        if (r11 == 0) goto L14;
        r10.getTheme().applyStyle(r11, true);
    L14:
        return r10;
    L15:
        return r6;
    L5:
        if (((ContextThemeWrapper) ZeusTransformUtils.preCheckCast(r6, ContextThemeWrapper.class, "com.obric.memorydata.plugin")).getThemeResId() != r8) goto L7;
        r9 = true;
        goto L8
    }

    private static int b(Context r2, AttributeSet r3, int r4, int r5) {
        TypedArray r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"), f4182b, r4, r5);
        int r7 = r6.getResourceId(0, 0);
        r6.recycle();
        return r7;
    }
}
