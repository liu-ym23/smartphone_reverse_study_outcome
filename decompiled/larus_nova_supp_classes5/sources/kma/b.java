package kma;

import android.R;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final int[] d = null;
    public static final com.obric.oui.color.b[] e = null;
    public final int[][] a;
    public final com.obric.oui.color.b[][] b;
    public final com.obric.oui.color.b[] c;

    static {
        d = new int[]{R.attr.state_enabled};
        e = new com.obric.oui.color.b[]{new com.obric.oui.color.b(0, BlendMode.SRC_OVER)};
    }

    public final b b() {
        int[][] r0 = new int[this.a.length][];
        int r1 = 0;
        int r2 = 0;
    L3:
        int[][] r3 = this.a;
        if (r2 >= r3.length) goto L6;
        int[] r4 = r3[r2];
        r0[r2] = Arrays.copyOf(r4, r4.length);
        r2 = r2 + 1;
        goto L3
    L6:
        com.obric.oui.color.b[][] r5 = new com.obric.oui.color.b[this.b.length][];
        int r6 = 0;
    L7:
        com.obric.oui.color.b[][] r7 = this.b;
        if (r6 >= r7.length) goto L14;
        com.obric.oui.color.b[] r8 = r7[r6];
        com.obric.oui.color.b[] r9 = new com.obric.oui.color.b[r8.length];
        int r10 = 0;
    L11:
        if (r10 >= r8.length) goto L13;
        com.obric.oui.color.b r11 = r8[r10];
        r11.getClass();
        r9[r10] = new com.obric.oui.color.b(r11.a, r11.b);
        r10 = r10 + 1;
        goto L11
    L13:
        r5[r6] = r9;
        r6 = r6 + 1;
        goto L7
    L14:
        com.obric.oui.color.b[] r12 = this.c;
        com.obric.oui.color.b[] r13 = new com.obric.oui.color.b[r12.length];
    L16:
        if (r1 >= r12.length) goto L19;
        com.obric.oui.color.b r14 = r12[r1];
        r14.getClass();
        r13[r1] = new com.obric.oui.color.b(r14.a, r14.b);
        r1 = r1 + 1;
        goto L16
    L19:
        return new b(r0, r5, r13);
    }

    public static com.obric.oui.color.b[] a(com.obric.oui.color.b[] r1, com.obric.oui.color.b r2) {
        com.obric.oui.color.b[] r0 = (com.obric.oui.color.b[]) Arrays.copyOf(r1, r1.length + 1);
        r0[r1.length] = r2;
        return r0;
    }

    public b(int[][] r3, com.obric.oui.color.b[][] r4, com.obric.oui.color.b[] r5) {
        if (r3.length != r4.length) goto L11;
        if (r3.length == 0) goto L9;
        this.a = r3;
        this.b = r4;
        this.c = r5;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r3.length + ") must equal configs.size(" + r4.length + ")");
    }

    public static b c(com.obric.oui.color.b[] r8, com.obric.oui.color.b[] r9, com.obric.oui.color.b r10) {
        com.obric.oui.color.b r7 = e[0];
        return d(r8, r9, r10, r7, r7, r7);
    }

    public static b d(com.obric.oui.color.b[] r20, com.obric.oui.color.b[] r21, com.obric.oui.color.b r22, com.obric.oui.color.b r23, com.obric.oui.color.b r24, com.obric.oui.color.b r25) {
        com.obric.oui.color.b r2 = new com.obric.oui.color.b(0, r22.b);
        com.obric.oui.color.b[] r3 = a(r20, r2);
        com.obric.oui.color.b[] r4 = a(r21, r2);
        com.obric.oui.color.b[] r5 = a(r20, r24);
        com.obric.oui.color.b[] r6 = a(r20, r25);
        com.obric.oui.color.b[] r1 = a(r20, r22);
        com.obric.oui.color.b[] r7 = a(r20, r23);
        return new b(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new com.obric.oui.color.b[][]{r6, r6, r5, r5, r1, r7, r6, r5, r4, r3}, r20);
    }
}
