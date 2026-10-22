package com.lynx.tasm.utils;

import android.graphics.PointF;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class GradientUtils {
    public static PointF a(int r5, int r10, float r11, float r12, float r13, float r14) {
        float[] r15 = nativeGetRadialRadius(r5, r10, r11, r12, r13, r14);
        return new PointF(r15[0], r15[1]);
    }

    private static native ReadableMapBuffer nativeGetGradientArray(String r5, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17);

    private static native float[] nativeGetRadialRadius(int r5, int r10, float r11, float r12, float r13, float r14);
}
