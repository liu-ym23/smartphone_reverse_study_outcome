package okhttp3.internal.http;

import ai.j0;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.s0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/StatusLine;", "", "protocol", "Lokhttp3/Protocol;", "code", "", "message", "", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class StatusLine {
    public static final Companion Companion = null;
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;

    @JvmField
    public final int code;

    @JvmField
    public final String message;

    @JvmField
    public final Protocol protocol;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "<init>", "()V", "Lokhttp3/s0;", "response", "Lokhttp3/internal/http/StatusLine;", "get", "(Lokhttp3/s0;)Lokhttp3/internal/http/StatusLine;", "", "statusLine", "parse", "(Ljava/lang/String;)Lokhttp3/internal/http/StatusLine;", "", "HTTP_CONTINUE", "I", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final StatusLine get(s0 r5) {
            Intrinsics.checkNotNullParameter(r5, "response");
            return new StatusLine(r5.f20747c, r5.e, r5.d);
        }

        public final StatusLine parse(String r10) throws IOException {
            Intrinsics.checkNotNullParameter(r10, "statusLine");
            if (StringsKt.P(r10, "HTTP/1.") == false) goto L19;
            int r5 = 9;
            if (r10.length() < 9) goto L17;
            if (r10.charAt(8) != ' ') goto L17;
            int r11 = r10.charAt(7) - '0';
            if (r11 != 0) goto L12;
            Protocol r12 = Protocol.HTTP_1_0;
        L21:
            int r13 = r5 + 3;
            if (r10.length() < r13) goto L37;
            int r14 = Integer.parseInt(r10.substring(r5, r13));     // Catch: NumberFormatException -> L34
            if (r10.length() > r13) goto L27;
            String r15 = "";
        L33:
            return new StatusLine(r12, r14, r15);
        L27:
            if (r10.charAt(r13) != ' ') goto L30;
            r15 = r10.substring(r5 + 4);
            goto L33
        L30:
            throw new ProtocolException("Unexpected status line: ".concat(r10));
        L35:
            throw new ProtocolException("Unexpected status line: ".concat(r10));
        L37:
            throw new ProtocolException("Unexpected status line: ".concat(r10));
        L12:
            if (r11 != 1) goto L15;
            r12 = Protocol.HTTP_1_1;
            goto L21
        L15:
            throw new ProtocolException("Unexpected status line: ".concat(r10));
        L17:
            throw new ProtocolException("Unexpected status line: ".concat(r10));
        L19:
            if (StringsKt.P(r10, "ICY ") == false) goto L39;
            r12 = Protocol.HTTP_1_0;
            r5 = 4;
            goto L21
        L39:
            throw new ProtocolException(j0.C("Unexpected status line: ", r10));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StatusLine(Protocol r5, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "protocol");
        Intrinsics.checkNotNullParameter(r11, "message");
        this.protocol = r5;
        this.code = r10;
        this.message = r11;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.protocol != Protocol.HTTP_1_0) goto L5;
        r5.append("HTTP/1.0");
    L6:
        r5.append(' ');
        r5.append(this.code);
        r5.append(' ');
        r5.append(this.message);
        return r5.toString();
    L5:
        r5.append("HTTP/1.1");
        goto L6
    }
}
