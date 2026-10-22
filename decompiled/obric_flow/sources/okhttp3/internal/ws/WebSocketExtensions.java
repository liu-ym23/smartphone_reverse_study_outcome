package okhttp3.internal.ws;

import ai.j0;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.c0;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketExtensions {
    public static final Companion Companion = null;
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    @JvmField
    public final Integer clientMaxWindowBits;

    @JvmField
    public final boolean clientNoContextTakeover;

    @JvmField
    public final boolean perMessageDeflate;

    @JvmField
    public final Integer serverMaxWindowBits;

    @JvmField
    public final boolean serverNoContextTakeover;

    @JvmField
    public final boolean unknownValues;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "<init>", "()V", "Lokhttp3/c0;", "responseHeaders", "Lokhttp3/internal/ws/WebSocketExtensions;", "parse", "(Lokhttp3/c0;)Lokhttp3/internal/ws/WebSocketExtensions;", "", "HEADER_WEB_SOCKET_EXTENSION", "Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final WebSocketExtensions parse(c0 r20) throws IOException {
            Intrinsics.checkNotNullParameter(r20, "responseHeaders");
            int r5 = r20.size();
            int r10 = 0;
            boolean r11 = false;
            Integer r12 = null;
            boolean r13 = false;
            Integer r14 = null;
            boolean r15 = false;
            boolean r16 = false;
        L3:
            if (r10 >= r5) goto L58;
            if (StringsKt.l(r20.c(r10), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION) == false) goto L56;
            String r17 = r20.e(r10);
            int r18 = 0;
        L9:
            if (r18 >= r17.length()) goto L56;
            int r19 = r18;
            int r110 = Util.delimiterOffset$default(r17, ',', r18, 0, 4, null);
            int r111 = Util.delimiterOffset(r17, ';', r19, r110);
            String r21 = Util.trimSubstring(r17, r19, r111);
            int r112 = r111 + 1;
            if (StringsKt.l(r21, "permessage-deflate") == false) goto L55;
            if (r11 == false) goto L14;
            r16 = true;
        L14:
            if (r112 >= r110) goto L53;
            int r22 = Util.delimiterOffset(r17, ';', r112, r110);
            int r23 = Util.delimiterOffset(r17, '=', r112, r22);
            String r24 = Util.trimSubstring(r17, r112, r23);
            if (r23 >= r22) goto L18;
            String r25 = StringsKt.C(Util.trimSubstring(r17, r23 + 1, r22));
        L19:
            r112 = r22 + 1;
            if (StringsKt.l(r24, "client_max_window_bits") == true) goto L21;
            if (StringsKt.l(r24, "client_no_context_takeover") == true) goto L31;
            if (StringsKt.l(r24, "server_max_window_bits") == true) goto L38;
            if (StringsKt.l(r24, "server_no_context_takeover") == true) goto L48;
            r16 = true;
            goto L14
        L48:
            if (r15 == false) goto L50;
            r16 = true;
        L50:
            if (r25 == null) goto L52;
            r16 = true;
        L52:
            r15 = true;
            goto L14
        L38:
            if (r14 == null) goto L40;
            r16 = true;
        L40:
            if (r25 == null) goto L42;
            Integer r26 = StringsKt.toIntOrNull(r25);
        L43:
            r14 = r26;
            if (r26 != null) goto L14;
            r16 = true;
            goto L14
        L42:
            r26 = null;
            goto L43
        L31:
            if (r13 == false) goto L33;
            r16 = true;
        L33:
            if (r25 == null) goto L35;
            r16 = true;
        L35:
            r13 = true;
            goto L14
        L21:
            if (r12 == null) goto L23;
            r16 = true;
        L23:
            if (r25 == null) goto L25;
            Integer r27 = StringsKt.toIntOrNull(r25);
        L26:
            r12 = r27;
            if (r27 != null) goto L14;
            r16 = true;
            goto L14
        L25:
            r27 = null;
            goto L26
        L18:
            r25 = null;
            goto L19
        L53:
            r11 = true;
        L54:
            r18 = r112;
            goto L9
        L55:
            r16 = true;
        L56:
            r10 = r10 + 1;
            goto L3
        L58:
            return new WebSocketExtensions(r11, r12, r13, r14, r15, r16);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WebSocketExtensions() {
        boolean r5 = false;
        Integer r10 = null;
        boolean r11 = false;
        Integer r12 = null;
        boolean r13 = false;
        boolean r14 = false;
        this(r5, r10, r11, r12, r13, r14, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions r5, boolean r10, Integer r11, boolean r12, Integer r13, boolean r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.perMessageDeflate;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.clientMaxWindowBits;
    L8:
        Integer r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.clientNoContextTakeover;
    L11:
        boolean r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.serverMaxWindowBits;
    L14:
        Integer r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.serverNoContextTakeover;
    L17:
        boolean r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.unknownValues;
    L20:
        boolean r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean r10, Integer r11, boolean r12, Integer r13, boolean r14, boolean r15) {
        return new WebSocketExtensions(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof WebSocketExtensions) == false) goto L18;
        WebSocketExtensions r10 = (WebSocketExtensions) r5;
        if (this.perMessageDeflate == r10.perMessageDeflate) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.clientMaxWindowBits, r10.clientMaxWindowBits) == true) goto L10;
        return false;
    L10:
        if (this.clientNoContextTakeover == r10.clientNoContextTakeover) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.serverMaxWindowBits, r10.serverMaxWindowBits) == true) goto L14;
        return false;
    L14:
        if (this.serverNoContextTakeover == r10.serverNoContextTakeover) goto L16;
        return false;
    L16:
        if (this.unknownValues == r10.unknownValues) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean r5 = this.perMessageDeflate;
        ?? r10 = 1;
        ?? r11 = r5;
        if (r5 == false) goto L5;
        r11 = 1;
    L5:
        int r12 = r11 * 31;
        Integer r13 = this.clientMaxWindowBits;
        int r14 = 0;
        if (r13 == null) goto L8;
        int r15 = r13.hashCode();
    L9:
        int r16 = (r12 + r15) * 31;
        boolean r17 = this.clientNoContextTakeover;
        ?? r18 = r17;
        if (r17 == false) goto L12;
        r18 = 1;
    L12:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.serverMaxWindowBits;
        if (r20 == null) goto L15;
        r14 = r20.hashCode();
    L15:
        int r21 = (r19 + r14) * 31;
        boolean r22 = this.serverNoContextTakeover;
        ?? r23 = r22;
        if (r22 == false) goto L18;
        r23 = 1;
    L18:
        int r24 = (r21 + r23) * 31;
        boolean r25 = this.unknownValues;
        if (r25 == true) goto L23;
        r10 = r25;
    L23:
        return r24 + r10;
    L8:
        r15 = 0;
        goto L9
    }

    public final boolean noContextTakeover(boolean r5) {
        if (r5 == false) goto L5;
        return this.clientNoContextTakeover;
    L5:
        return this.serverNoContextTakeover;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("WebSocketExtensions(perMessageDeflate=");
        r5.append(this.perMessageDeflate);
        r5.append(", clientMaxWindowBits=");
        r5.append(this.clientMaxWindowBits);
        r5.append(", clientNoContextTakeover=");
        r5.append(this.clientNoContextTakeover);
        r5.append(", serverMaxWindowBits=");
        r5.append(this.serverMaxWindowBits);
        r5.append(", serverNoContextTakeover=");
        r5.append(this.serverNoContextTakeover);
        r5.append(", unknownValues=");
        return j0.r(r5, this.unknownValues, ")");
    }

    public WebSocketExtensions(boolean r5, Integer r10, boolean r11, Integer r12, boolean r13, boolean r14) {
        this.perMessageDeflate = r5;
        this.clientMaxWindowBits = r10;
        this.clientNoContextTakeover = r11;
        this.serverMaxWindowBits = r12;
        this.serverNoContextTakeover = r13;
        this.unknownValues = r14;
    }

    public /* synthetic */ WebSocketExtensions(boolean r5, Integer r10, boolean r11, Integer r12, boolean r13, boolean r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r11 = false;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r12 = null;
    L15:
        if ((r15 & 16) == 0) goto L18;
        r13 = false;
    L18:
        if ((r15 & 32) == 0) goto L20;
        r14 = false;
    L20:
        this(r5, r10, r11, r12, r13, r14);
    }
}
