package nuc;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import luc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h2 {
    public static final int a(luc.f r7, luc.f[] r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "typeParams");
        int r1 = (r7.f().hashCode() * 31) + Arrays.hashCode(r8);
        Intrinsics.checkNotNullParameter(r7, "<this>");
        int r9 = r7.d();
        int r2 = 1;
    L3:
        int r3 = 0;
        if (r9 <= 0) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L12;
        int r5 = r9 - 1;
        int r6 = r2 * 31;
        String r10 = r7.h(r7.d() - r9).f();
        if (r10 == null) goto L11;
        r3 = r10.hashCode();
    L11:
        r2 = r6 + r3;
        r9 = r5;
        goto L3
    L12:
        int r11 = r7.d();
        int r12 = 1;
    L13:
        if (r11 <= 0) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == false) goto L23;
        int r14 = r11 - 1;
        int r15 = r12 * 31;
        o r16 = r7.h(r7.d() - r11).getKind();
        if (r16 == null) goto L20;
        int r17 = r16.hashCode();
    L21:
        r12 = r15 + r17;
        r11 = r14;
        goto L13
    L20:
        r17 = 0;
        goto L21
    L23:
        return (((r1 * 31) + r2) * 31) + r12;
    L15:
        r13 = false;
        goto L16
    L6:
        r4 = false;
        goto L7
    }
}
