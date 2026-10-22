package com.obric.oui.b;

import android.R;
import android.util.StateSet;
import com.obric.oui.color.f;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13323a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[][] f13324b;
    private final f[] c;
    private final f d;

    static {
        f13323a = new int[]{R.attr.state_enabled};
    }

    private d(int[][] r3, f[] r4, f r5) {
        if (r3.length != r4.length) goto L11;
        if (r3.length == 0) goto L9;
        this.f13324b = r3;
        this.c = r4;
        this.d = r5;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r3.length + ") must equal strokes.size(" + r4.length + ")");
    }

    public static d a(f r5) {
        return new d(new int[][]{f13323a}, new f[]{r5}, r5);
    }

    public static d a(f r9, f r10, f r11, f r12, f r13, f r14) {
        if (a(r9, r10) == false) goto L15;
        if (a(r9, r11) == false) goto L15;
        if (a(r9, r12) == false) goto L15;
        if (a(r9, r13) == false) goto L15;
        if (a(r9, r14) == false) goto L15;
        return a(r9);
    L15:
        return new d(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new f[]{r12, r13, r11, r10, r14, r9}, r9);
    }

    public static f a(f r0, f r1, float r2) {
        return f.a(r0, r1, r2);
    }

    private static boolean a(f r4, f r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        if (r4.a() != r5.a()) goto L17;
        if (r4.b() != r5.b()) goto L17;
        if (r4.c() != r5.c()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public f a() {
        return this.d;
    }

    public f a(int[] r4, f r5) {
        int r0 = 0;
    L3:
        int[][] r1 = this.f13324b;
        if (r0 >= r1.length) goto L10;
        if (StateSet.stateSetMatches(r1[r0], r4) == true) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return this.c[r0];
    L10:
        return r5;
    }

    public d b() {
        int[][] r0 = new int[this.f13324b.length][];
        int r1 = 0;
        int r2 = 0;
    L3:
        int[][] r3 = this.f13324b;
        if (r2 >= r3.length) goto L6;
        r0[r2] = Arrays.copyOf(r3[r2], r3[r2].length);
        r2 = r2 + 1;
        goto L3
    L6:
        f[] r4 = new f[this.c.length];
    L7:
        f[] r5 = this.c;
        if (r1 >= r5.length) goto L11;
        r4[r1] = f.a(r5[r1]);
        r1 = r1 + 1;
        goto L7
    L11:
        return new d(r0, r4, f.a(this.d));
    }
}
