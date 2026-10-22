package ou;

import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import nu.j;
import nu.u;
import nu.y;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f21306a = null;

    static {
        Intrinsics.checkNotNullParameter("0123456789abcdef", "$this$asUtf8ToByteArray");
        f21306a = "0123456789abcdef".getBytes(Charsets.UTF_8);
    }

    public static final String a(j r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$readUtf8Line");
        if (r11 <= 0) goto L7;
        long r5 = r11 - 1;
        if (r10.m(r5) != ((byte) 13)) goto L7;
        String r12 = r10.L(r5, Charsets.UTF_8);
        r10.skip(2);
        return r12;
    L7:
        r10.getClass();
        String r13 = r10.L(r11, Charsets.UTF_8);
        r10.skip(1);
        return r13;
    }

    public static final int b(j r18, u r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "$this$selectPrefix");
        Intrinsics.checkNotNullParameter(r19, "options");
        y r5 = r18.f20327a;
        if (r5 == null) goto L47;
        int r10 = r5.f20353b;
        int r11 = r5.f20354c;
        int[] r12 = r19.f20342b;
        byte[] r13 = r5.f20352a;
        y r14 = r5;
        int r15 = -1;
        int r16 = 0;
    L5:
        int r17 = r16 + 1;
        int r110 = r12[r16];
        int r21 = r16 + 2;
        int r111 = r12[r17];
        if (r111 == (-1)) goto L8;
        r15 = r111;
    L8:
        if (r14 == null) goto L23;
        if (r110 >= 0) goto L32;
        int r112 = (r110 * (-1)) + r21;
    L13:
        int r113 = r10 + 1;
        int r114 = r21 + 1;
        if ((r13[r10] & UByte.MAX_VALUE) != r12[r21]) goto L15;
        if (r114 != r112) goto L18;
        boolean r22 = true;
    L19:
        if (r113 != r11) goto L28;
        Intrinsics.checkNotNull(r14);
        y r23 = r14.f;
        Intrinsics.checkNotNull(r23);
        int r24 = r23.f20353b;
        int r25 = r23.f20354c;
        byte[] r26 = r23.f20352a;
        if (r23 != r5) goto L27;
        if (r22 == false) goto L23;
        r11 = r25;
        y r27 = null;
    L29:
        if (r22 == true) goto L30;
        r10 = r24;
        r13 = r26;
        r14 = r27;
        r21 = r114;
        goto L13
    L30:
        int r28 = r12[r114];
        int r115 = r24;
        int r29 = r11;
        int r30 = r115;
        byte[] r116 = r26;
        r14 = r27;
        byte[] r31 = r116;
    L43:
        if (r28 >= 0) goto L44;
        byte[] r117 = r31;
        r16 = -r28;
        r10 = r30;
        r11 = r29;
        r13 = r117;
        goto L5
    L44:
        return r28;
    L27:
        r27 = r23;
        r11 = r25;
        goto L29
    L28:
        r27 = r14;
        r26 = r13;
        r24 = r113;
        goto L29
    L18:
        r22 = false;
        goto L19
    L15:
        return r15;
    L32:
        int r118 = r10 + 1;
        int r32 = r13[r10] & UByte.MAX_VALUE;
        int r119 = r21 + r110;
    L33:
        if (r21 == r119) goto L34;
        if (r32 == r12[r21]) goto L37;
        r21 = r21 + 1;
        goto L33
    L37:
        r28 = r12[r21 + r110];
        if (r118 != r11) goto L42;
        r14 = r14.f;
        Intrinsics.checkNotNull(r14);
        r30 = r14.f20353b;
        r29 = r14.f20354c;
        r31 = r14.f20352a;
        if (r14 != r5) goto L43;
        r14 = null;
        goto L43
    L42:
        r31 = r13;
        r29 = r11;
        r30 = r118;
        goto L43
    L34:
        return r15;
    L23:
        if (r20 == false) goto L25;
        return -2;
    L25:
        return r15;
    L47:
        if (r20 == false) goto L50;
        return -2;
    L50:
        return -1;
    }
}
