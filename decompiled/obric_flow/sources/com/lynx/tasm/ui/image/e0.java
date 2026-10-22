package com.lynx.tasm.ui.image;

import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {
    public static ScalingUtils.AbstractScaleType a(String r5) {
        if ("aspectFit".equals(r5) == false) goto L7;
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7895c;
    L7:
        if ("aspectFill".equals(r5) == false) goto L11;
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.g;
    L11:
        if ("scaleToFill".equals(r5) == false) goto L15;
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7893a;
    L15:
        if ("center".equals(r5) == true) goto L17;
        if (r5 == null) goto L27;
        if (r5.equals("none") == true) goto L27;
        if (r5.length() == 0) goto L27;
        throw new RuntimeException(com.lynx.tasm.utils.g.d("Invalid resize mode: '", r5, "'"));
    L27:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.f7893a;
    L17:
        return (ScalingUtils.AbstractScaleType) ScalingUtils.ScaleType.e;
    }

    public static ScalingUtils.ScaleType b(ScalingUtils.ScaleType r5) {
        if (r5 != ScalingUtils.ScaleType.f7895c) goto L7;
        return y0.f11148j;
    L7:
        if (r5 != ScalingUtils.ScaleType.g) goto L11;
        return x0.f11147j;
    L11:
        if (r5 != ScalingUtils.ScaleType.e) goto L15;
        return w0.f11143j;
    L15:
        if (r5 == ScalingUtils.ScaleType.f7893a) goto L17;
        return r5;
    L17:
        return z0.f11150j;
    }
}
