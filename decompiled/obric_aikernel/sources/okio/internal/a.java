package okio.internal;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.b0;
import okio.j0;
import okio.w;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "-Buffer")
@SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/internal/-Buffer\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1730:1\n112#1,20:1753\n112#1,20:1786\n112#1:1806\n114#1,18:1808\n112#1,20:1826\n74#2:1731\n74#2:1732\n74#2:1733\n74#2:1734\n74#2:1735\n74#2:1736\n74#2:1737\n74#2:1738\n74#2:1739\n74#2:1740\n74#2:1741\n74#2:1742\n83#2:1743\n83#2:1744\n77#2:1745\n77#2:1746\n77#2:1747\n77#2:1748\n77#2:1749\n77#2:1750\n77#2:1751\n77#2:1752\n86#2:1773\n89#2:1775\n74#2:1776\n74#2:1777\n74#2:1778\n74#2:1779\n74#2:1780\n74#2:1781\n74#2:1782\n74#2:1783\n74#2:1784\n74#2:1785\n89#2:1807\n86#2:1846\n1#3:1774\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/internal/-Buffer\n*L\n415#1:1753,20\n1292#1:1786,20\n1323#1:1806\n1323#1:1808,18\n1357#1:1826,20\n178#1:1731\n202#1:1732\n321#1:1733\n326#1:1734\n349#1:1735\n350#1:1736\n351#1:1737\n352#1:1738\n358#1:1739\n359#1:1740\n360#1:1741\n361#1:1742\n385#1:1743\n386#1:1744\n392#1:1745\n393#1:1746\n394#1:1747\n395#1:1748\n396#1:1749\n397#1:1750\n398#1:1751\n399#1:1752\n427#1:1773\n888#1:1775\n906#1:1776\n908#1:1777\n912#1:1778\n914#1:1779\n918#1:1780\n920#1:1781\n924#1:1782\n926#1:1783\n946#1:1784\n949#1:1785\n1336#1:1807\n1676#1:1846\n*E\n"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f12237a = null;

    static {
        f12237a = j0.a("0123456789abcdef");
    }

    public static final byte[] a() {
        return f12237a;
    }

    public static final String b(okio.d r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 <= 0) goto L7;
        long r12 = r11 - 1;
        if (r10.r(r12) != 13) goto L7;
        String r13 = r10.e(r12);
        r10.skip(2);
        return r13;
    L7:
        String r14 = r10.e(r11);
        r10.skip(1);
        return r14;
    }

    public static final int c(okio.d r17, w r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "options");
        b0 r10 = r17.f12197c;
        if (r10 != null) goto L8;
        if (r19 == false) goto L7;
        return -2;
    L7:
        return -1;
    L8:
        byte[] r11 = r10.f12172a;
        int r12 = r10.f12173b;
        int r13 = r10.f12174c;
        int[] r14 = r18.d();
        b0 r15 = r10;
        int r16 = -1;
        int r20 = 0;
    L9:
        int r110 = r20 + 1;
        int r21 = r14[r20];
        int r111 = r110 + 1;
        int r112 = r14[r110];
        if (r112 == (-1)) goto L12;
        r16 = r112;
    L12:
        if (r15 == null) goto L28;
        if (r21 >= 0) goto L36;
        int r113 = r111 + (r21 * (-1));
    L17:
        int r22 = r12 + 1;
        int r114 = r111 + 1;
        if ((r11[r12] & 255) != r14[r111]) goto L19;
        if (r114 != r113) goto L22;
        boolean r23 = true;
    L23:
        if (r22 != r13) goto L32;
        Intrinsics.checkNotNull(r15);
        b0 r24 = r15.f12177f;
        Intrinsics.checkNotNull(r24);
        int r25 = r24.f12173b;
        byte[] r26 = r24.f12172a;
        int r27 = r24.f12174c;
        if (r24 != r10) goto L31;
        if (r23 == false) goto L28;
        r11 = r26;
        b0 r28 = null;
    L33:
        if (r23 == true) goto L34;
        r12 = r25;
        r13 = r27;
        r111 = r114;
        r15 = r28;
        goto L17
    L34:
        int r29 = r14[r114];
        int r115 = r25;
        r13 = r27;
        r15 = r28;
    L46:
        if (r29 >= 0) goto L47;
        r20 = -r29;
        r12 = r115;
        goto L9
    L47:
        return r29;
    L31:
        r28 = r24;
        r11 = r26;
        goto L33
    L32:
        b0 r116 = r15;
        r27 = r13;
        r25 = r22;
        r28 = r116;
        goto L33
    L22:
        r23 = false;
        goto L23
    L19:
        return r16;
    L36:
        r115 = r12 + 1;
        int r30 = r11[r12] & 255;
        int r117 = r111 + r21;
    L37:
        if (r111 == r117) goto L38;
        if (r30 == r14[r111]) goto L41;
        r111 = r111 + 1;
        goto L37
    L41:
        r29 = r14[r111 + r21];
        if (r115 != r13) goto L46;
        r15 = r15.f12177f;
        Intrinsics.checkNotNull(r15);
        int r31 = r15.f12173b;
        r115 = r31;
        r11 = r15.f12172a;
        r13 = r15.f12174c;
        if (r15 != r10) goto L46;
        r15 = null;
        goto L46
    L38:
        return r16;
    L28:
        if (r19 == false) goto L30;
        return -2;
    L30:
        return r16;
    }

    public static /* synthetic */ int d(okio.d r10, w r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        return c(r10, r11, r12);
    }
}
