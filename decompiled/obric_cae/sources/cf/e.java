package cf;

import com.sdk.bwdl.StateMachine.BWDLDataStructure;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jf.g f3485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f3486b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f3487c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f3488d = null;

    static {
        f3485a = jf.g.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f3486b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f3487c = new String[64];
        f3488d = new String[256];
        int r8 = 0;
        int r10 = 0;
    L3:
        String[] r11 = f3488d;
        if (r10 >= r11.length) goto L6;
        r11[r10] = xe.c.n("%8s", new Object[]{Integer.toBinaryString(r10)}).replace(' ', '0');
        r10 = r10 + 1;
        goto L3
    L6:
        String[] r12 = f3487c;
        r12[0] = "";
        r12[1] = "END_STREAM";
        int[] r13 = {1};
        r12[8] = "PADDED";
        int r14 = r13[0];
        r12[r14 | 8] = android.aimedia.a.i(new StringBuilder(), r12[r14], "|PADDED");
        r12[4] = "END_HEADERS";
        r12[32] = "PRIORITY";
        r12[36] = "END_HEADERS|PRIORITY";
        int[] r15 = {4, 32, 36};
        int r16 = 0;
    L8:
        if (r16 >= 3) goto L10;
        int r17 = r15[r16];
        int r18 = r13[0];
        String[] r19 = f3487c;
        int r20 = r18 | r17;
        r19[r20] = r19[r18] + '|' + r19[r17];
        StringBuilder r110 = new StringBuilder();
        r110.append(r19[r18]);
        r110.append('|');
        r19[r20 | 8] = android.aimedia.a.i(r110, r19[r17], "|PADDED");
        r16 = r16 + 1;
    L10:
        String[] r21 = f3487c;
        if (r8 >= r21.length) goto L16;
        if (r21[r8] != null) goto L15;
        r21[r8] = f3488d[r8];
    L15:
        r8 = r8 + 1;
        goto L10
    }

    public e() {
    }

    public static String a(boolean r10, int r11, int r12, byte r13, byte r14) {
        String[] r8 = f3486b;
        if (r13 >= r8.length) goto L5;
        String r15 = r8[r13];
    L7:
        if (r14 != 0) goto L9;
        String r16 = "";
    L37:
        Object[] r17 = new Object[5];
        if (r10 == false) goto L40;
        String r18 = "<<";
    L41:
        r17[0] = r18;
        r17[1] = Integer.valueOf(r11);
        r17[2] = Integer.valueOf(r12);
        r17[3] = r15;
        r17[4] = r16;
        return xe.c.n("%s 0x%08x %5d %-13s %s", r17);
    L40:
        r18 = ">>";
        goto L41
    L9:
        String[] r19 = f3488d;
        if (r13 == 2) goto L36;
        if (r13 == 3) goto L36;
        if (r13 != 4) goto L14;
    L33:
        if (r14 != 1) goto L35;
        r16 = "ACK";
        goto L37
    L35:
        r16 = r19[r14];
        goto L37
    L14:
        if (r13 == 6) goto L33;
        if (r13 == 7) goto L36;
        if (r13 == 8) goto L36;
        String[] r20 = f3487c;
        if (r14 >= r20.length) goto L22;
        String r21 = r20[r14];
    L23:
        if (r13 == 5) goto L25;
    L27:
        if (r13 == 0) goto L29;
    L32:
        r16 = r21;
        goto L37
    L29:
        if ((r14 & BWDLDataStructure.DataLinkParamStructure.BT_SPP) == 0) goto L32;
        String r110 = "PRIORITY";
        String r111 = "COMPRESSED";
    L31:
        r16 = r21.replace(r110, r111);
        goto L37
    L25:
        if ((r14 & 4) == 0) goto L27;
        r110 = "HEADERS";
        r111 = "PUSH_PROMISE";
        goto L31
    L22:
        r21 = r19[r14];
    L36:
        r16 = r19[r14];
        goto L37
    L5:
        r15 = xe.c.n("0x%02x", new Object[]{Byte.valueOf(r13)});
        goto L7
    }

    public static void b(String r8, Object... r10) {
        throw new IOException(xe.c.n(r8, r10));
    }
}
