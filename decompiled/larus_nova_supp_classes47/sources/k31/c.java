package k31;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public boolean e;
    public int f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L18;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (this.f == r4.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
        boolean r1 = this.e;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((r0 + r2) * 31) + this.f;
    }

    public final String toString() {
        return "width = " + this.a + ", height = " + this.b + ", topMargin = " + this.c + ", leftMargin = " + this.d;
    }

    public final h a(f r23) {
        Intrinsics.checkNotNullParameter(r23, "seiCache");
        i.a r3 = i.g;
        int r4 = this.a;
        int r5 = this.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r23, "seiCache");
        n0 r2 = r23.a;
        p0 r6 = r23.b;
        if (r6 == null) goto L31;
        List r7 = r6.e();
        if (r7 == null) goto L31;
        if (r2 != null) goto L20;
        double r9 = n11.a.d(r7);
        double r12 = n11.a.a(r7);
        if (r9 <= 0.0d) goto L31;
        if (r12 <= 0.0d) goto L31;
        int r8 = (int) (((double) r4) / r9);
        int r10 = (int) (((double) r5) / r12);
        double r13 = n11.a.d(r7);
        double r14 = n11.a.a(r7);
        if (r13 <= 0.0d) goto L31;
        if (r14 <= 0.0d) goto L31;
        double r15 = r8;
        double r16 = r10;
        i r17 = new i(r8, r10, (int) (n11.a.b(r7) * r15), (int) (n11.a.c(r7) * r16), (int) (r13 * r15), (int) (r16 * r14));
    L32:
        if (r17 != null) goto L36;
        return null;
    L36:
        if (this.e == false) goto L53;
        b03.a r1 = b03.a.a;
        int r18 = s1.w() - s1.A();
        if (b03.a.a() == false) goto L42;
        int r19 = this.f;
        if (r19 == 0) goto L42;
        int r20 = r19;
    L43:
        int r22 = (r20 * 9) / 16;
        p0 r24 = r23.b;
        if (r24 == null) goto L48;
        q0 r25 = r24.getCanvas();
        if (r25 == null) goto L48;
        r22 = (r25.b() * r20) / r25.a();
    L48:
        int r26 = r22;
        GravityDef r27 = GravityDef.LEFT;
        int r28 = (s1.y() - r26) / 2;
        if (r26 <= s1.y()) goto L52;
        r27 = GravityDef.RIGHT;
        r28 = s1.y() - r26;
    L52:
        return new h(r26, r20, 0, r28, r27);
    L42:
        r20 = r18;
        goto L43
    L53:
        p0 r29 = r23.b;
        if (r29 == null) goto L71;
        m0 r30 = r29.f();
        if (r30 == null) goto L71;
        Intrinsics.checkNotNullParameter(r30, "$this$toLayoutType");
        if (r30.e() == 1) goto L60;
    L62:
        int r32 = r30.c();
    L64:
        if (r32 != UILayout.FULL_RECORD.ordinal()) goto L71;
        b03.a r33 = b03.a.a;
        int r34 = s1.w();
        int r35 = (r34 * 9) / 16;
        int r36 = (s1.y() - r35) / 2;
        if (r35 <= s1.y()) goto L69;
        r36 = s1.y() - r35;
    L69:
        return new h(r35, r34, 0, r36, GravityDef.CENTER_HORIZONTAL);
    L60:
        if (r30.c() != UILayout.FULL.ordinal()) goto L62;
        r32 = UILayout.FULL_RECORD.ordinal();
    L71:
        return new h(r17.a, r17.b, this.c - r17.d, this.d - r17.c, GravityDef.LEFT_TOP);
    L20:
        double r0 = n11.a.d(r7);
        double r37 = n11.a.a(r7);
        if (r0 <= 0.0d) goto L31;
        if (r37 <= 0.0d) goto L31;
        int r110 = (int) (((((double) r4) / r0) * ((double) r2.f())) / ((double) r2.b()));
        int r111 = (int) (((((double) r5) / r37) * ((double) r2.e())) / ((double) r2.a()));
        double r38 = n11.a.d(r7);
        double r39 = n11.a.a(r7);
        if (r38 <= 0.0d) goto L31;
        if (r39 <= 0.0d) goto L31;
        float r40 = r110;
        int r42 = (int) ((r2.b() * r40) / r2.f());
        float r43 = r111;
        int r112 = (int) ((r2.a() * r43) / r2.e());
        int r44 = (int) ((r40 * r2.c()) / r2.f());
        double r113 = r44;
        double r45 = r42;
        double r46 = r112;
        r17 = new i(r110, r111, (int) (r113 + (n11.a.b(r7) * r45)), (int) (((double) ((int) ((r43 * r2.d()) / r2.e()))) + (n11.a.c(r7) * r46)), (int) (r38 * r45), (int) (r46 * r39));
    L31:
        r17 = null;
        goto L32
    }

    public c(int r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = false;
        this.f = 0;
    }
}
