package com.lynx.tasm.utils;

import android.graphics.PointF;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class GradientUtils {
    public GradientUtils() {
    }

    private static native ReadableMapBuffer nativeGetGradientArray(String r0, float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8);

    private static native float[] nativeGetRadialRadius(int r0, int r1, float r2, float r3, float r4, float r5);

    public static com.lynx.react.bridge.mapbuffer.e a(String r9, float r10, float r11, float r12, float r13, float r14) {
        ReadableMapBuffer r15 = nativeGetGradientArray(r9, r10, 1.0f, 1.0f, r11, r12, 1.0f, r13, r14);
        if (r15 != null) goto L5;
        return null;
    L5:
        Iterator<MapBuffer.a> r16 = r15.iterator();
        if (r16.hasNext() == true) goto L8;
        return null;
    L8:
        return new com.lynx.react.bridge.mapbuffer.e(r16.next().f());
    }

    public static PointF b(int r0, int r1, float r2, float r3, float r4, float r5) {
        float[] r6 = nativeGetRadialRadius(r0, r1, r2, r3, r4, r5);
        return new PointF(r6[0], r6[1]);
    }
}
