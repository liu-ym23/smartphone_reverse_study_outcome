package mc;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final ByteString f11104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f11105c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f11106d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f11107e = null;

    static {
        f11103a = new b();
        f11104b = ByteString.Companion.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f11105c = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f11106d = new String[64];
        String[] r10 = new String[256];
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= 256) goto L6;
        String r13 = Integer.toBinaryString(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "toBinaryString(it)");
        r10[r12] = StringsKt.replace$default(hc.e.t("%8s", new Object[]{r13}), ' ', '0', false, 4, null);
        r12 = r12 + 1;
        goto L4
    L6:
        f11107e = r10;
        String[] r14 = f11106d;
        r14[0] = "";
        r14[1] = "END_STREAM";
        int[] r15 = {1};
        r14[8] = "PADDED";
        int r16 = 0;
    L8:
        if (r16 >= 1) goto L10;
        int r17 = r15[r16];
        String[] r18 = f11106d;
        r18[r17 | 8] = r18[r17] + "|PADDED";
        r16 = r16 + 1;
        goto L8
    L10:
        String[] r19 = f11106d;
        r19[4] = "END_HEADERS";
        r19[32] = "PRIORITY";
        r19[36] = "END_HEADERS|PRIORITY";
        int[] r20 = {4, 32, 36};
        int r21 = 0;
    L11:
        if (r21 >= 3) goto L16;
        int r22 = r20[r21];
        int r23 = 0;
    L13:
        if (r23 >= 1) goto L15;
        int r110 = r15[r23];
        String[] r111 = f11106d;
        int r112 = r110 | r22;
        r111[r112] = r111[r110] + '|' + r111[r22];
        r111[r112 | 8] = r111[r110] + '|' + r111[r22] + "|PADDED";
        r23 = r23 + 1;
        goto L13
    L15:
        r21 = r21 + 1;
        goto L11
    L16:
        int r24 = f11106d.length;
    L17:
        if (r11 >= r24) goto L22;
        String[] r25 = f11106d;
        if (r25[r11] != null) goto L21;
        r25[r11] = f11107e[r11];
    L21:
        r11 = r11 + 1;
        goto L17
    }

    private b() {
    }

    public final String a(int r10, int r11) {
        if (r11 != 0) goto L6;
        return "";
    L6:
        if (r10 == 2) goto L38;
        if (r10 == 3) goto L38;
        if (r10 == 4) goto L33;
        if (r10 == 6) goto L33;
        if (r10 == 7) goto L38;
        if (r10 == 8) goto L38;
        String[] r12 = f11106d;
        if (r11 >= r12.length) goto L20;
        String r13 = r12[r11];
        Intrinsics.checkNotNull(r13);
    L21:
        String r14 = r13;
        if (r10 == 5) goto L24;
    L27:
        if (r10 == 0) goto L29;
        return r14;
    L29:
        if ((r11 & 32) == 0) goto L40;
        boolean r15 = false;
        int r16 = 4;
        Object r17 = null;
        String r18 = "PRIORITY";
        String r19 = "COMPRESSED";
    L31:
        return StringsKt.replace$default(r14, r18, r19, r15, r16, r17);
    L40:
        return r14;
    L24:
        if ((r11 & 4) == 0) goto L27;
        r15 = false;
        r16 = 4;
        r17 = null;
        r18 = "HEADERS";
        r19 = "PUSH_PROMISE";
        goto L31
    L20:
        r13 = f11107e[r11];
    L33:
        if (r11 != 1) goto L36;
        return "ACK";
    L36:
        return f11107e[r11];
    L38:
        return f11107e[r11];
    }

    public final String b(int r10) {
        String[] r11 = f11105c;
        if (r10 >= r11.length) goto L6;
        return r11[r10];
    L6:
        return hc.e.t("0x%02x", new Object[]{Integer.valueOf(r10)});
    }

    public final String c(boolean r10, int r11, int r12, int r13, int r14) {
        String r15 = b(r13);
        String r16 = a(r13, r14);
        if (r10 == false) goto L5;
        String r17 = "<<";
    L7:
        return hc.e.t("%s 0x%08x %5d %-13s %s", new Object[]{r17, Integer.valueOf(r11), Integer.valueOf(r12), r15, r16});
    L5:
        r17 = ">>";
        goto L7
    }
}
