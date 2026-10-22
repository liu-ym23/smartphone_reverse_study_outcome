package cs;

import android.util.StateSet;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f16500a;

    static {
    }

    public a(b r5) {
        this.f16500a = r5;
    }

    public static com.obric.oui.color.a[] b(a r5, int[] r10) {
        com.obric.oui.color.a[] r11 = r5.f16500a.f16503c;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "stateSet");
        Intrinsics.checkNotNullParameter(r11, "defaultConfig");
        int r12 = 0;
    L3:
        b r13 = r5.f16500a;
        int[][] r14 = r13.f16501a;
        if (r12 >= r14.length) goto L12;
        if (StateSet.stateSetMatches(r14[r12], r10) == true) goto L9;
        r12 = r12 + 1;
        goto L3
    L9:
        return r13.f16502b[r12];
    L12:
        return r11;
    }

    public static final a c(com.obric.oui.color.a[] r5, com.obric.oui.color.a[] r10, com.obric.oui.color.a r11) {
        Intrinsics.checkNotNullParameter(r5, "normal");
        Intrinsics.checkNotNullParameter(r10, "disabled");
        Intrinsics.checkNotNullParameter(r11, "pressedOverlay");
        return s6.b.h(r5, r10, r11, 56);
    }

    public final a a() {
        b r12 = this.f16500a;
        int[][] r5 = r12.f16501a;
        int[][] r10 = new int[r5.length][];
        int r11 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r5.length) goto L6;
        int[] r14 = r5[r13];
        r10[r13] = Arrays.copyOf(r14, r14.length);
        r13 = r13 + 1;
        goto L4
    L6:
        com.obric.oui.color.a[][] r15 = r12.f16502b;
        com.obric.oui.color.a[][] r16 = new com.obric.oui.color.a[r15.length][];
        int r17 = 0;
    L8:
        if (r17 >= r15.length) goto L14;
        com.obric.oui.color.a[] r18 = r15[r17];
        com.obric.oui.color.a[] r19 = new com.obric.oui.color.a[r18.length];
        int r20 = 0;
    L11:
        if (r20 >= r18.length) goto L13;
        com.obric.oui.color.a r21 = r18[r20];
        r19[r20] = new com.obric.oui.color.a(r21.f12398a, r21.f12399b);
        r20 = r20 + 1;
        goto L11
    L13:
        r16[r17] = r19;
        r17 = r17 + 1;
        goto L8
    L14:
        com.obric.oui.color.a[] r110 = r12.f16503c;
        com.obric.oui.color.a[] r22 = new com.obric.oui.color.a[r110.length];
    L16:
        if (r11 >= r110.length) goto L19;
        com.obric.oui.color.a r23 = r110[r11];
        r22[r11] = new com.obric.oui.color.a(r23.f12398a, r23.f12399b);
        r11 = r11 + 1;
        goto L16
    L19:
        return new a(new b(r10, r16, r22));
    }
}
