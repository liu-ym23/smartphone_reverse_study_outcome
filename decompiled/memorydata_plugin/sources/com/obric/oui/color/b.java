package com.obric.oui.color;

import android.graphics.Color;
import com.obric.oui.graphic.BlendMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13470a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13471b;
    private int c;

    static {
        f13470a = new b(0, BlendMode.SRC_OVER);
    }

    public b(int r1, int r2) {
        this.f13471b = r1;
        this.c = r2;
    }

    public b(int r1, BlendMode r2) {
        this(r1, BlendMode.mapToLegacyObricBlend(r2));
    }

    private static float a(float r0, float r1, float r2) {
        return Math.max(r1, Math.min(r2, r0));
    }

    public static int a(int r5, int r6, float r7) {
        float r0 = 1.0f - r7;
        return Color.argb((int) ((Color.alpha(r5) * r0) + (Color.alpha(r6) * r7)), (int) ((Color.red(r5) * r0) + (Color.red(r6) * r7)), (int) ((Color.green(r5) * r0) + (Color.green(r6) * r7)), (int) ((Color.blue(r5) * r0) + (Color.blue(r6) * r7)));
    }

    public static b a(b r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new b(r2.f13471b, r2.c);
    }

    public static b a(b r2, b r3, float r4) {
        float r5 = a(r4, 0.0f, 1.0f);
        if (r5 > 0.0f) goto L7;
        return new b(r2.f13471b, r2.c);
    L7:
        if (r5 >= 1.0f) goto L9;
        int r0 = a(r2.f13471b, r3.f13471b, r5);
        int r6 = r2.c;
        int r7 = r3.c;
        if (r6 == r7) goto L18;
        if (r5 < 0.5f) goto L18;
        r6 = r7;
    L18:
        return new b(r0, r6);
    L9:
        return new b(r3.f13471b, r3.c);
    }

    public static b[] a(int[] r7) {
        int r0 = 0;
        if (r7 == null) goto L15;
        if (r7.length == 0) goto L15;
        if ((r7.length % 2) != 0) goto L15;
        b[] r1 = new b[r7.length / 2];
        int r2 = 0;
    L11:
        if (r0 >= (r7.length - 1)) goto L13;
        r1[r2] = new b(r7[r0], BlendMode.mapToLegacyObricBlend(r7[r0 + 1]));
        r0 = r0 + 2;
        r2 = r2 + 1;
        goto L11
    L13:
        return r1;
    L15:
        return new b[0];
    }

    public static b[] a(b[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        b[] r0 = new b[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = a(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    private static b[] a(b[] r4, int r5) {
        if (r4.length != r5) goto L5;
        return r4;
    L5:
        b[] r0 = (b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r4, r5), b[].class, "com.obric.memorydata.plugin");
        int r6 = r4.length;
    L6:
        if (r6 >= r5) goto L8;
        r0[r6] = new b(0, BlendMode.SRC_OVER);
        r6 = r6 + 1;
        goto L6
    L8:
        return r0;
    }

    public static b[] a(b[] r5, b[] r6, float r7) {
        float r8 = a(r7, 0.0f, 1.0f);
        if (r8 > 0.0f) goto L7;
        return b(r5);
    L7:
        if (r8 >= 1.0f) goto L9;
        int r0 = Math.max(r5.length, r6.length);
        int r1 = 0;
        if (r0 == 0) goto L13;
        b[] r9 = a(r5, r0);
        b[] r10 = a(r6, r0);
        b[] r2 = new b[r0];
    L15:
        if (r1 >= r0) goto L17;
        r2[r1] = a(r9[r1], r10[r1], r8);
        r1 = r1 + 1;
        goto L15
    L17:
        return r2;
    L13:
        return new b[0];
    L9:
        return b(r6);
    }

    private static b[] b(b[] r5) {
        b[] r0 = new b[r5.length];
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        r0[r1] = new b(r5[r1].f13471b, r5[r1].c);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public int a() {
        return this.f13471b;
    }

    public int b() {
        return this.c;
    }

    public b c() {
        return a(this);
    }

    public String toString() {
        return String.format(Locale.US, "BlendConfig#%d(color=#%08X, blendMode=%d)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.f13471b), Integer.valueOf(this.c)});
    }
}
