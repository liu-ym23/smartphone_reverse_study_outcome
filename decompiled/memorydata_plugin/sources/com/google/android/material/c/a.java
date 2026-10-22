package com.google.android.material.c;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int a(int r0, int r1) {
        return ColorUtils.compositeColors(r1, r0);
    }

    public static int a(int r1, int r2, float r3) {
        return a(r1, ColorUtils.setAlphaComponent(r2, Math.round(Color.alpha(r2) * r3)));
    }

    public static int a(Context r2, int r3, int r4) {
        TypedValue r5 = b.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        if (r5 != null) goto L5;
        return r4;
    L5:
        return r5.data;
    }

    public static int a(Context r2, int r3, String r4) {
        return b.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static int a(View r0, int r1) {
        return b.a(r0, r1);
    }

    public static int a(View r2, int r3, int r4) {
        return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static int a(View r0, int r1, int r2, float r3) {
        return a(a(r0, r1), a(r0, r2), r3);
    }

    public static boolean a(int r4) {
        if (r4 != 0) goto L4;
    L6:
        return false;
    L4:
        if (ColorUtils.calculateLuminance(r4) <= 0.5d) goto L6;
        return true;
    }

    public static int b(int r1, int r2) {
        return ColorUtils.setAlphaComponent(r1, (Color.alpha(r1) * r2) / 255);
    }
}
