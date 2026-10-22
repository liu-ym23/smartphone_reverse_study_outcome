package kma;

import android.graphics.Color;
import android.util.StateSet;
import com.obric.oui.color.c;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public final b a;

    /* JADX INFO: renamed from: kma.a$a, reason: collision with other inner class name */
    public static final class C0021a {
        public C0021a() {
        }

        @JvmStatic
        public static a c(com.obric.oui.color.a[] r6) {
            Intrinsics.checkNotNullParameter(r6, "configs");
            com.obric.oui.color.b[] r7 = c.b(r6);
            return new a(new b(new int[][]{b.d}, new com.obric.oui.color.b[][]{r7}, r7));
        }

        @JvmStatic
        public static com.obric.oui.color.a[] a(com.obric.oui.color.a[] r16, com.obric.oui.color.a[] r17, float r18) {
            Intrinsics.checkNotNullParameter(r16, "fromConfigs");
            Intrinsics.checkNotNullParameter(r17, "toConfigs");
            com.obric.oui.color.b[] r0 = c.b(r16);
            com.obric.oui.color.b[] r1 = c.b(r17);
            int[] r2 = b.d;
            float r3 = 1.0f;
            float r4 = 0.0f;
            float r5 = Math.max(0.0f, Math.min(1.0f, r18));
            int r6 = 0;
            if (r5 > 0.0f) goto L9;
            com.obric.oui.color.b[] r7 = new com.obric.oui.color.b[r0.length];
        L6:
            if (r6 >= r0.length) goto L51;
            com.obric.oui.color.b r8 = r0[r6];
            r7[r6] = new com.obric.oui.color.b(r8.a, r8.b);
            r6 = r6 + 1;
        L51:
            return c.a(r7);
        L9:
            if (r5 < 1.0f) goto L15;
            com.obric.oui.color.b[] r9 = new com.obric.oui.color.b[r1.length];
        L12:
            if (r6 >= r1.length) goto L14;
            com.obric.oui.color.b r10 = r1[r6];
            r9[r6] = new com.obric.oui.color.b(r10.a, r10.b);
            r6 = r6 + 1;
            goto L12
        L14:
            r7 = r9;
            goto L51
        L15:
            int r11 = Math.max(r0.length, r1.length);
            if (r11 != 0) goto L19;
            r7 = new com.obric.oui.color.b[0];
            goto L51
        L19:
            if (r0.length == r11) goto L26;
            com.obric.oui.color.b[] r12 = (com.obric.oui.color.b[]) Arrays.copyOf(r0, r11);
            int r13 = r0.length;
        L22:
            if (r13 >= r11) goto L24;
            r12[r13] = new com.obric.oui.color.b(0, BlendMode.SRC_OVER);
            r13 = r13 + 1;
            goto L22
        L24:
            r0 = r12;
        L26:
            if (r1.length == r11) goto L32;
            com.obric.oui.color.b[] r14 = (com.obric.oui.color.b[]) Arrays.copyOf(r1, r11);
            int r15 = r1.length;
        L29:
            if (r15 >= r11) goto L31;
            r14[r15] = new com.obric.oui.color.b(0, BlendMode.SRC_OVER);
            r15 = r15 + 1;
            goto L29
        L31:
            r1 = r14;
        L32:
            com.obric.oui.color.b[] r19 = new com.obric.oui.color.b[r11];
        L33:
            if (r6 >= r11) goto L49;
            com.obric.oui.color.b r20 = r0[r6];
            com.obric.oui.color.b r21 = r1[r6];
            float r110 = Math.max(r4, Math.min(r3, r5));
            if (r110 > r4) goto L38;
            com.obric.oui.color.b r22 = new com.obric.oui.color.b(r20.a, r20.b);
        L48:
            r19[r6] = r22;
            r6 = r6 + 1;
            r3 = 1.0f;
            r4 = 0.0f;
            goto L33
        L38:
            if (r110 < r3) goto L40;
            r22 = new com.obric.oui.color.b(r21.a, r21.b);
            goto L48
        L40:
            int r111 = r20.a;
            int r112 = r21.a;
            float r113 = r3 - r110;
            int r23 = Color.argb((int) ((Color.alpha(r111) * r113) + (Color.alpha(r112) * r110)), (int) ((Color.red(r111) * r113) + (Color.red(r112) * r110)), (int) ((Color.green(r111) * r113) + (Color.green(r112) * r110)), (int) ((Color.blue(r111) * r113) + (Color.blue(r112) * r110)));
            int r24 = r20.b;
            int r25 = r21.b;
            if (r24 != r25) goto L44;
        L47:
            r22 = new com.obric.oui.color.b(r23, r24);
            goto L48
        L44:
            if (r110 < 0.5f) goto L47;
            r24 = r25;
            goto L47
        L49:
            r7 = r19;
            goto L51
        }

        public static a b(com.obric.oui.color.a[] r9, com.obric.oui.color.a r10, com.obric.oui.color.a r11, int r12) {
            int r0 = a.b;
            if ((r12 & 1) == 0) goto L5;
            r9 = new com.obric.oui.color.a[]{com.obric.oui.color.a.c};
        L5:
            com.obric.oui.color.a r1 = null;
            if ((r12 & 2) == 0) goto L8;
            com.obric.oui.color.a[] r2 = r9;
        L10:
            if ((r12 & 4) == 0) goto L13;
            r10 = com.obric.oui.color.a.c;
        L13:
            if ((r12 & 8) == 0) goto L15;
            com.obric.oui.color.a r3 = com.obric.oui.color.a.c;
        L17:
            if ((r12 & 16) == 0) goto L20;
            r11 = com.obric.oui.color.a.c;
        L20:
            if ((r12 & 32) == 0) goto L22;
            r1 = r11;
        L22:
            Intrinsics.checkNotNullParameter(r9, "normal");
            Intrinsics.checkNotNullParameter(r2, "disabled");
            Intrinsics.checkNotNullParameter(r10, "pressedOverlay");
            Intrinsics.checkNotNullParameter(r3, "hoveredOverlay");
            Intrinsics.checkNotNullParameter(r11, "activatedOverlay");
            Intrinsics.checkNotNullParameter(r1, "checkedOverlay");
            com.obric.oui.color.b[] r4 = c.b(r9);
            com.obric.oui.color.b[] r5 = c.b(r2);
            r10.getClass();
            com.obric.oui.color.b r6 = new com.obric.oui.color.b(r10.a, r10.b);
            r3.getClass();
            com.obric.oui.color.b r7 = new com.obric.oui.color.b(r3.a, r3.b);
            r11.getClass();
            com.obric.oui.color.b r8 = new com.obric.oui.color.b(r11.a, r11.b);
            r1.getClass();
            return new a(b.d(r4, r5, r6, r7, r8, new com.obric.oui.color.b(r1.a, r1.b)));
        L15:
            r3 = null;
            goto L17
        L8:
            r2 = null;
            goto L10
        }
    }

    static {
        new C0021a();
    }

    public a(b r1) {
        this.a = r1;
    }

    public static com.obric.oui.color.a[] a(a r4, int[] r5) {
        com.obric.oui.color.a[] r0 = c.a(r4.a.c);
        Intrinsics.checkNotNullParameter(r5, "stateSet");
        Intrinsics.checkNotNullParameter(r0, "defaultConfig");
        b r6 = r4.a;
        com.obric.oui.color.b[] r1 = c.b(r0);
        int r2 = 0;
    L3:
        int[][] r3 = r6.a;
        if (r2 >= r3.length) goto L10;
        if (StateSet.stateSetMatches(r3[r2], r5) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        r1 = r6.b[r2];
    L10:
        return c.a(r1);
    }
}
