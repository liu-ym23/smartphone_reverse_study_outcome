package ou1;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Iterator;
import java.util.Map;
import ju1.h;
import ju1.n;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import lu1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements nu1.f<ju1.f> {
    public final nu1.b a;

    public static final class a {
    }

    static {
    }

    public d() {
        nu1.a r0 = nu1.a.a;
        Intrinsics.checkNotNullParameter(r0, "expressionExecutor");
        this.a = r0;
    }

    public static double b(double r4, ju1.d r6) {
        return Math.pow(r6.h() + (r4 * r6.e()), r6.a());
    }

    public static double c(String r0, Map r1) {
        Object r2 = r1.get(r0);
        if ((r2 instanceof Number) == true) goto L5;
        r2 = null;
    L5:
        Number r3 = (Number) r2;
        if (r3 != null) goto L10;
        return 0.0d;
    L10:
        return r3.doubleValue();
    }

    @Override // nu1.f
    public final n a(h r20, Map r21) {
        ju1.f r1 = (ju1.f) r20;
        Intrinsics.checkNotNullParameter(r1, "strategy");
        Intrinsics.checkNotNullParameter(r21, "stateMap");
        Iterator r2 = CollectionsKt.filterNotNull(r1.j()).iterator();
        double r5 = 1.0d;
    L4:
        if (r2.hasNext() == false) goto L40;
        ju1.d r7 = (ju1.d) r2.next();
        String r8 = r7.d();
        switch(r8.hashCode()) {
            case -1795452264: goto L27;
            case 107332: goto L19;
            case 3526476: goto L16;
            case 102977278: goto L9;
            default: goto L33;
        };
    L33:
        double r9 = 1.0d;
    L35:
        if (r7.i() == true) goto L36;
        if (r9 == 0.0d) goto L4;
        r5 = r5 / r9;
        goto L4
    L36:
        r5 = r5 * r9;
        goto L4
    L9:
        if (r8.equals("liner") == false) goto L33;
        double r10 = c(r7.c(), r21);
        int r14 = m.a;
        double r15 = r7.f();
        double r16 = r7.g();
        if (r15 != r16) goto L13;
        ALogger.e("LinearNormalization", "pMax==pMin, divide zero exception");
        double r11 = 0.0d;
    L14:
        double r12 = b(r11, r7);
    L25:
        r9 = r12;
        goto L35
    L13:
        r11 = (Math.min(r10, r15) - r16) / (r15 - r16);
        goto L14
    L16:
        if (r8.equals("self") == false) goto L33;
        r12 = b(c(r7.c(), r21), r7);
        goto L25
    L19:
        if (r8.equals("log") == false) goto L33;
        double r13 = c(r7.c(), r21);
        int r17 = m.a;
        double r18 = MathKt.log2(Math.max(1.0d, r13));
        double r19 = r7.f();
        double r110 = r7.g();
        if (r19 != r110) goto L23;
        ALogger.e("LinearNormalization", "pMax==pMin, divide zero exception");
        double r22 = 0.0d;
    L24:
        r12 = b(r22, r7);
        goto L25
    L23:
        r22 = (Math.min(r18, r19) - r110) / (r19 - r110);
        goto L24
    L27:
        if (r8.equals("expression") == false) goto L33;
        if (Intrinsics.areEqual(this.a.a(r7.b(), r21), Boolean.TRUE) == false) goto L31;
        double r23 = 1.0d;
    L32:
        r9 = b(r23, r7);
        goto L35
    L31:
        r23 = 0.0d;
        goto L32
    L40:
        Iterator r3 = CollectionsKt.filterNotNull(r1.k()).iterator();
    L41:
        Integer r24 = null;
        if (r3.hasNext() == false) goto L49;
        Object r4 = r3.next();
        if (r5 < ((ju1.e) r4).b()) goto L46;
        boolean r111 = true;
    L47:
        if (r111 == false) goto L41;
    L50:
        ju1.e r6 = (ju1.e) r4;
        if (r6 == null) goto L53;
        r24 = Integer.valueOf(r6.a());
    L53:
        if (r24 == null) goto L56;
        r24.intValue();
        return new ju1.g(r24.intValue(), false, r21, r1.i());
    L56:
        return new ju1.g(r1.g(), true, r21, r1.i());
    L46:
        r111 = false;
        goto L47
    L49:
        r4 = null;
        goto L50
    }
}
