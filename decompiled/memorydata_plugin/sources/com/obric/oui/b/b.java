package com.obric.oui.b;

import android.R;
import android.util.StateSet;
import com.obric.oui.graphic.BlendMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.oui.color.b[] f13320b = null;
    private final int[][] c;
    private final com.obric.oui.color.b[][] d;
    private final com.obric.oui.color.b[] e;

    static {
        f13319a = new int[]{R.attr.state_enabled};
        f13320b = new com.obric.oui.color.b[]{new com.obric.oui.color.b(0, BlendMode.SRC_OVER)};
    }

    private b(int[][] r3, com.obric.oui.color.b[][] r4, com.obric.oui.color.b[] r5) {
        if (r3.length != r4.length) goto L11;
        if (r3.length == 0) goto L9;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r3.length + ") must equal configs.size(" + r4.length + ")");
    }

    public static b a(com.obric.oui.color.b[] r5) {
        return new b(new int[][]{f13319a}, new com.obric.oui.color.b[][]{r5}, r5);
    }

    public static b a(com.obric.oui.color.b[] r2, com.obric.oui.color.b[] r3, com.obric.oui.color.b r4) {
        return a(r2, r3, r4, f13320b[0]);
    }

    public static b a(com.obric.oui.color.b[] r2, com.obric.oui.color.b[] r3, com.obric.oui.color.b r4, com.obric.oui.color.b r5) {
        return a(r2, r3, r4, r5, f13320b[0]);
    }

    public static b a(com.obric.oui.color.b[] r6, com.obric.oui.color.b[] r7, com.obric.oui.color.b r8, com.obric.oui.color.b r9, com.obric.oui.color.b r10) {
        return a(r6, r7, r8, r9, r10, r10);
    }

    public static b a(com.obric.oui.color.b[] r4, com.obric.oui.color.b[] r5, com.obric.oui.color.b r6, com.obric.oui.color.b r7, com.obric.oui.color.b r8, com.obric.oui.color.b r9) {
        com.obric.oui.color.b r0 = new com.obric.oui.color.b(0, r6.b());
        com.obric.oui.color.b[] r1 = a(r4, r0);
        com.obric.oui.color.b[] r10 = a(r5, r0);
        com.obric.oui.color.b[] r11 = a(r4, r8);
        com.obric.oui.color.b[] r12 = a(r4, r9);
        com.obric.oui.color.b[] r13 = a(r4, r6);
        com.obric.oui.color.b[] r14 = a(r4, r7);
        return new b(c(), new com.obric.oui.color.b[][]{r12, r12, r11, r11, r13, r14, r12, r11, r10, r1}, r4);
    }

    public static b a(int[][] r4, com.obric.oui.color.b[][] r5) {
        if (r4.length != r5.length) goto L20;
        if (r4.length == 0) goto L18;
        com.obric.oui.color.b[] r0 = null;
        int r2 = 0;
    L8:
        if (r2 >= r4.length) goto L13;
        if (r4[r2].length == 0) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        r0 = r5[r2];
    L13:
        if (r0 != null) goto L16;
        r0 = r5[0];
    L16:
        return new b(r4, r5, r0);
    L18:
        throw new IllegalArgumentException("states must not be empty");
    L20:
        throw new IllegalArgumentException("states.size(" + r4.length + ") must equal configs.size(" + r5.length + ")");
    }

    private static com.obric.oui.color.b[] a(com.obric.oui.color.b[] r3, com.obric.oui.color.b r4) {
        com.obric.oui.color.b[] r0 = (com.obric.oui.color.b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length + 1), com.obric.oui.color.b[].class, "com.obric.memorydata.plugin");
        r0[r3.length] = r4;
        return r0;
    }

    public static com.obric.oui.color.b[] a(com.obric.oui.color.b[] r0, com.obric.oui.color.b[] r1, float r2) {
        return com.obric.oui.color.b.a(r0, r1, r2);
    }

    private static com.obric.oui.color.b[] b(com.obric.oui.color.b[] r3) {
        com.obric.oui.color.b[] r0 = new com.obric.oui.color.b[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = r3[r1].c();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private static int[][] c() {
        return new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    public com.obric.oui.color.b[] a() {
        return this.e;
    }

    public com.obric.oui.color.b[] a(int[] r4, com.obric.oui.color.b[] r5) {
        int r0 = 0;
    L3:
        int[][] r1 = this.c;
        if (r0 >= r1.length) goto L10;
        if (StateSet.stateSetMatches(r1[r0], r4) == true) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return this.d[r0];
    L10:
        return r5;
    }

    public b b() {
        int[][] r0 = new int[this.c.length][];
        int r1 = 0;
        int r2 = 0;
    L3:
        int[][] r3 = this.c;
        if (r2 >= r3.length) goto L6;
        r0[r2] = Arrays.copyOf(r3[r2], r3[r2].length);
        r2 = r2 + 1;
        goto L3
    L6:
        com.obric.oui.color.b[][] r4 = new com.obric.oui.color.b[this.d.length][];
    L7:
        com.obric.oui.color.b[][] r5 = this.d;
        if (r1 >= r5.length) goto L11;
        r4[r1] = b(r5[r1]);
        r1 = r1 + 1;
        goto L7
    L11:
        return new b(r0, r4, b(this.e));
    }
}
