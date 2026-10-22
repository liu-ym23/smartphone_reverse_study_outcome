package okhttp3.internal.http2;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nu.m;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0000¢\u0006\u0002\b#J.\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lokhttp3/internal/http2/Http2;", "", "()V", "BINARY", "", "", "[Ljava/lang/String;", "CONNECTION_PREFACE", "Lokio/ByteString;", "FLAGS", "FLAG_ACK", "", "FLAG_COMPRESSED", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_END_STREAM", "FLAG_NONE", "FLAG_PADDED", "FLAG_PRIORITY", "FRAME_NAMES", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "TYPE_DATA", "TYPE_GOAWAY", "TYPE_HEADERS", "TYPE_PING", "TYPE_PRIORITY", "TYPE_PUSH_PROMISE", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_WINDOW_UPDATE", "formatFlags", "type", "flags", "formattedType", "formattedType$okhttp", "frameLog", "inbound", "", "streamId", "length", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2 {
    private static final String[] BINARY = null;

    @JvmField
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
        ByteString.Companion.getClass();
        CONNECTION_PREFACE = m.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] r5 = new String[256];
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= 256) goto L6;
        r5[r11] = StringsKt.E(Util.format("%8s", new Object[]{Integer.toBinaryString(r11)}), ' ', '0');
        r11 = r11 + 1;
        goto L4
    L6:
        BINARY = r5;
        String[] r12 = FLAGS;
        r12[0] = "";
        r12[1] = "END_STREAM";
        int[] r13 = {1};
        r12[8] = "PADDED";
        int r14 = r13[0];
        r12[r14 | 8] = Intrinsics.stringPlus(r12[r14], "|PADDED");
        r12[4] = "END_HEADERS";
        r12[32] = "PRIORITY";
        r12[36] = "END_HEADERS|PRIORITY";
        int[] r15 = {4, 32, 36};
        int r16 = 0;
    L8:
        if (r16 >= 3) goto L10;
        int r17 = r15[r16];
        int r18 = r13[0];
        String[] r19 = FLAGS;
        int r20 = r18 | r17;
        r19[r20] = r19[r18] + "|" + r19[r17];
        StringBuilder r110 = new StringBuilder();
        r110.append(r19[r18]);
        r110.append("|");
        r19[r20 | 8] = j0.q(r110, r19[r17], "|PADDED");
        r16 = r16 + 1;
        goto L8
    L10:
        int r21 = FLAGS.length;
    L11:
        if (r10 >= r21) goto L16;
        String[] r22 = FLAGS;
        if (r22[r10] != null) goto L15;
        r22[r10] = BINARY[r10];
    L15:
        r10 = r10 + 1;
        goto L11
    }

    private Http2() {
    }

    public final String formatFlags(int r5, int r10) {
        if (r10 != 0) goto L6;
        return "";
    L6:
        if (r5 == 2) goto L37;
        if (r5 == 3) goto L37;
        if (r5 == 4) goto L32;
        if (r5 == 6) goto L32;
        if (r5 == 7) goto L37;
        if (r5 == 8) goto L37;
        String[] r11 = FLAGS;
        if (r10 >= r11.length) goto L20;
        String r12 = r11[r10];
        Intrinsics.checkNotNull(r12);
    L22:
        if (r5 == 5) goto L24;
    L26:
        if (r5 == 0) goto L28;
        return r12;
    L28:
        if ((r10 & 32) != 0) goto L30;
        return r12;
    L30:
        return StringsKt.F(r12, "PRIORITY", "COMPRESSED");
    L24:
        if ((r10 & 4) == 0) goto L26;
        return StringsKt.F(r12, "HEADERS", "PUSH_PROMISE");
    L20:
        r12 = BINARY[r10];
    L32:
        if (r10 != 1) goto L35;
        return "ACK";
    L35:
        return BINARY[r10];
    L37:
        return BINARY[r10];
    }

    public final String formattedType$okhttp(int r5) {
        String[] r10 = FRAME_NAMES;
        if (r5 >= r10.length) goto L6;
        return r10[r5];
    L6:
        return Util.format("0x%02x", new Object[]{Integer.valueOf(r5)});
    }

    public final String frameLog(boolean r5, int r10, int r11, int r12, int r13) {
        String r14 = formattedType$okhttp(r12);
        String r15 = formatFlags(r12, r13);
        if (r5 == false) goto L5;
        String r16 = "<<";
    L7:
        return Util.format("%s 0x%08x %5d %-13s %s", new Object[]{r16, Integer.valueOf(r10), Integer.valueOf(r11), r14, r15});
    L5:
        r16 = ">>";
        goto L7
    }
}
