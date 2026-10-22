package com.obric.oui.material;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000bJ!\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/material/OMaterialRadiusUtils;", "", "()V", "figmaPhysicalPx", "", "obricRadiusPx", "toPx", "", "context", "Landroid/content/Context;", "figmaBlur1x", "(Landroid/content/Context;F)Ljava/lang/Float;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;F)Ljava/lang/Float;", "density", "(FF)Ljava/lang/Float;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f14025a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f14026b = null;
    private static final float[] c = null;

    static {
        f14025a = new m();
        f14026b = new float[]{0.0f, 2.0f, 3.5f, 4.0f, 7.0f, 8.0f, 10.5f, 14.0f, 16.0f, 17.5f, 21.0f, 24.5f, 28.0f, 31.5f, 32.0f, 35.0f, 38.5f, 42.0f, 45.5f, 48.0f, 49.0f, 52.5f, 56.0f, 59.5f, 63.0f, 64.0f, 66.5f, 70.0f, 73.5f, 77.0f, 80.0f, 80.5f, 84.0f, 87.5f, 91.0f, 94.5f, 96.0f, 98.0f, 101.5f, 105.0f, 108.5f, 112.0f, 113.0f, 114.0f, 115.0f, 115.5f, 116.0f, 119.0f, 122.5f, 126.0f, 128.0f, 129.5f, 133.0f, 136.5f, 140.0f, 143.5f, 147.0f, 150.5f, 154.0f, 157.5f, 160.0f, 161.0f, 164.5f, 168.0f, 171.5f, 175.0f, 178.5f, 182.0f, 185.5f, 189.0f, 192.0f, 192.5f, 196.0f, 199.5f, 203.0f, 206.5f, 210.0f, 213.5f, 217.0f, 220.5f, 224.0f, 256.0f};
        c = new float[]{0.0f, 0.4375f, 0.629f, 0.6884f, 1.0f, 1.0625f, 1.25f, 1.5f, 1.7032f, 1.9375f, 2.375f, 2.8125f, 3.1875f, 3.625f, 3.6875f, 4.0625f, 4.5f, 4.9375f, 5.374f, 5.6875f, 5.7488f, 6.1875f, 6.625f, 7.0f, 7.4375f, 7.5625f, 7.8125f, 8.1875f, 8.625f, 9.0f, 9.375f, 9.4375f, 9.875f, 10.25f, 10.6875f, 11.0864f, 11.25f, 11.5625f, 12.5625f, 13.0625f, 13.5f, 13.9375f, 14.125f, 14.1875f, 14.3125f, 14.3125f, 14.5f, 14.9375f, 15.3125f, 15.875f, 16.1875f, 16.3125f, 16.875f, 17.4375f, 17.75f, 18.25f, 18.6875f, 19.3125f, 19.625f, 20.125f, 20.375f, 20.625f, 21.0f, 21.5f, 22.0f, 22.3125f, 22.875f, 23.375f, 23.875f, 24.25f, 24.5625f, 24.75f, 25.3125f, 25.8125f, 26.125f, 26.75f, 27.0625f, 27.5f, 28.0f, 28.5625f, 28.875f, 32.625f};
    }

    private m() {
    }

    @JvmStatic
    public static final Float a(float r10, float r11) {
        boolean r1 = false;
        if (Float.isInfinite(r10) == false) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L11;
    L41:
        return null;
    L11:
        if (r10 < 0.0f) goto L41;
        if (Float.isInfinite(r11) == false) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L41;
        if (r11 <= 0.0f) goto L41;
        float r12 = r10 * r11;
        if (Float.isInfinite(r12) == false) goto L26;
    L28:
        if (r1 == true) goto L30;
        return null;
    L30:
        float[] r13 = f14026b;
        if (r12 < ArraysKt.first(r13)) goto L41;
        if (r12 > ArraysKt.last(r13)) goto L41;
        int r2 = ArraysKt.binarySearch$default(r13, r12, 0, 0, 6, null);
        if (r2 >= 0) goto L38;
        int r3 = (-r2) - 1;
        int r5 = r3 - 1;
        float r6 = r13[r5];
        float r14 = r13[r3];
        float[] r7 = c;
        float r8 = r7[r5];
        return Float.valueOf(r8 + (((r12 - r6) / (r14 - r6)) * (r7[r3] - r8)));
    L38:
        return Float.valueOf(c[r2]);
    L26:
        if (Float.isNaN(r12) == true) goto L28;
        r1 = true;
        goto L28
    L16:
        if (Float.isNaN(r11) == true) goto L18;
        r4 = true;
        goto L19
    L5:
        if (Float.isNaN(r10) == true) goto L7;
        r0 = true;
        goto L9
    }

    @JvmStatic
    public static final Float a(Context r2, float r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        Resources r5 = null;
    L7:
        return a(r5, r3);
    L5:
        r5 = ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin");
        goto L7
    }

    @JvmStatic
    public static final Float a(Resources r1, float r2) {
        if (r1 != null) goto L5;
    L4:
        Float r3 = null;
    L9:
        if (r3 != null) goto L12;
        return null;
    L12:
        return a(r2, r3.floatValue());
    L5:
        DisplayMetrics r4 = r1.getDisplayMetrics();
        if (r4 == null) goto L4;
        r3 = Float.valueOf(r4.density);
        goto L9
    }
}
