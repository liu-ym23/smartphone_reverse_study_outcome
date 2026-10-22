package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.core.math.MathUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static Typeface a(Context r2, Typeface r3) {
        return a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration(), r3);
    }

    public static Typeface a(Configuration r2, Typeface r3) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        return null;
    L5:
        if (r2.fontWeightAdjustment != Integer.MAX_VALUE) goto L7;
        return null;
    L7:
        if (r2.fontWeightAdjustment != 0) goto L9;
        return null;
    L9:
        return Typeface.create(r3, MathUtils.clamp(r3.getWeight() + r2.fontWeightAdjustment, 1, 1000), r3.isItalic());
    }
}
