package okhttp3.internal.http2;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ.\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lokhttp3/internal/http2/Http2;", "", "()V", "BINARY", "", "", "[Ljava/lang/String;", "CONNECTION_PREFACE", "Lokio/ByteString;", "FLAGS", "FLAG_ACK", "", "FLAG_COMPRESSED", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_END_STREAM", "FLAG_NONE", "FLAG_PADDED", "FLAG_PRIORITY", "FRAME_NAMES", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "TYPE_DATA", "TYPE_GOAWAY", "TYPE_HEADERS", "TYPE_PING", "TYPE_PRIORITY", "TYPE_PUSH_PROMISE", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_WINDOW_UPDATE", "formatFlags", "type", "flags", "frameLog", "inbound", "", "streamId", XSDatatype.FACET_LENGTH, "okhttp"}, k = 1, mv = {1, 1, 15})
public final class Http2 {
    private static final String[] BINARY = null;
    public static final ByteString CONNECTION_PREFACE = null;
    private static final String[] FLAGS = null;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = null;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = null;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        INSTANCE = new Http2();
        CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] r1 = new String[256];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 256) goto L6;
        String r5 = Integer.toBinaryString(r3);
        Intrinsics.checkExpressionValueIsNotNull(r5, "Integer.toBinaryString(it)");
        r1[r3] = StringsKt.replace$default(Util.format("%8s", new Object[]{r5}), ' ', '0', false, 4, null);
        r3 = r3 + 1;
        goto L4
    L6:
        BINARY = r1;
        String[] r0 = FLAGS;
        r0[0] = "";
        r0[1] = "END_STREAM";
        int[] r4 = {1};
        r0[8] = "PADDED";
        int r6 = 0;
    L8:
        if (r6 >= 1) goto L10;
        int r7 = r4[r6];
        String[] r8 = FLAGS;
        r8[r7 | 8] = Intrinsics.stringPlus(r8[r7], "|PADDED");
        r6 = r6 + 1;
        goto L8
    L10:
        String[] r9 = FLAGS;
        r9[4] = "END_HEADERS";
        r9[32] = "PRIORITY";
        r9[36] = "END_HEADERS|PRIORITY";
        int[] r10 = {4, 32, 36};
        int r11 = 0;
    L11:
        if (r11 >= 3) goto L16;
        int r12 = r10[r11];
        int r13 = 0;
    L13:
        if (r13 >= 1) goto L15;
        int r14 = r4[r13];
        String[] r15 = FLAGS;
        int r16 = r14 | r12;
        r15[r16] = r15[r14] + "|" + r15[r12];
        r15[r16 | 8] = r15[r14] + "|" + r15[r12] + "|PADDED";
        r13 = r13 + 1;
        goto L13
    L15:
        r11 = r11 + 1;
        goto L11
    L16:
        int r17 = FLAGS.length;
    L17:
        if (r2 >= r17) goto L22;
        String[] r18 = FLAGS;
        if (r18[r2] != null) goto L21;
        r18[r2] = BINARY[r2];
    L21:
        r2 = r2 + 1;
        goto L17
    }

    private Http2() {
    }

    public final String formatFlags(int r7, int r8) {
        if (r8 != 0) goto L6;
        return "";
    L6:
        if (r7 == 2) goto L40;
        if (r7 == 3) goto L40;
        if (r7 == 4) goto L35;
        if (r7 == 6) goto L35;
        if (r7 == 7) goto L40;
        if (r7 == 8) goto L40;
        String[] r6 = FLAGS;
        if (r8 >= r6.length) goto L22;
        String r9 = r6[r8];
        if (r9 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        String r0 = r9;
        if (r7 == 5) goto L26;
    L29:
        if (r7 == 0) goto L31;
        return r0;
    L31:
        if ((r8 & 32) == 0) goto L42;
        boolean r3 = false;
        int r4 = 4;
        Object r5 = null;
        String r1 = "PRIORITY";
        String r2 = "COMPRESSED";
    L33:
        return StringsKt.replace$default(r0, r1, r2, r3, r4, r5);
    L42:
        return r0;
    L26:
        if ((r8 & 4) == 0) goto L29;
        r3 = false;
        r4 = 4;
        r5 = null;
        r1 = "HEADERS";
        r2 = "PUSH_PROMISE";
        goto L33
    L22:
        r9 = BINARY[r8];
    L35:
        if (r8 != 1) goto L38;
        return "ACK";
    L38:
        return BINARY[r8];
    L40:
        return BINARY[r8];
    }

    public final String frameLog(boolean r5, int r6, int r7, int r8, int r9) {
        String[] r0 = FRAME_NAMES;
        if (r8 >= r0.length) goto L5;
        String r1 = r0[r8];
    L6:
        String r4 = formatFlags(r8, r9);
        if (r5 == false) goto L9;
        String r10 = "<<";
    L11:
        return Util.format("%s 0x%08x %5d %-13s %s", new Object[]{r10, Integer.valueOf(r6), Integer.valueOf(r7), r1, r4});
    L9:
        r10 = ">>";
        goto L11
    L5:
        r1 = Util.format("0x%02x", new Object[]{Integer.valueOf(r8)});
        goto L6
    }
}
