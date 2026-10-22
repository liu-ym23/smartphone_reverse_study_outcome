package pq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m {
    public static final boolean a(l r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7.a != null) goto L5;
        boolean r0 = true;
    L7:
        if (r7.b != null) goto L9;
        boolean r3 = true;
    L11:
        if (r7.c != null) goto L13;
        boolean r4 = true;
    L15:
        if (r7.d != null) goto L17;
        boolean r5 = true;
    L18:
        String r6 = r7.e;
        if (r6 != null) goto L21;
    L24:
        boolean r8 = true;
    L25:
        String r9 = r7.f;
        if (r9 != null) goto L28;
    L31:
        boolean r10 = true;
    L32:
        if (r0 == false) goto L40;
        if (r3 == false) goto L41;
        if (r4 == false) goto L42;
        if (r5 == false) goto L43;
        if (r8 == false) goto L44;
        if (r10 == false) goto L45;
        return true;
    L45:
        return false;
    L44:
        return false;
    L43:
        return false;
    L42:
        return false;
    L41:
        return false;
    L40:
        return false;
    L28:
        if (r9.length() == 0) goto L31;
        r10 = false;
        goto L32
    L21:
        if (r6.length() == 0) goto L24;
        r8 = false;
        goto L25
    L17:
        r5 = false;
        goto L18
    L13:
        r4 = false;
        goto L15
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }
}
