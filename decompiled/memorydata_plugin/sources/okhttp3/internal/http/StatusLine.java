package okhttp3.internal.http;

import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.Response;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/StatusLine;", "", "protocol", "Lokhttp3/Protocol;", "code", "", "message", "", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class StatusLine {
    public static final Companion Companion = null;
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "()V", "HTTP_CONTINUE", "", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "get", "Lokhttp3/internal/http/StatusLine;", ChatMessage.TYPE_RESPONSE, "Lokhttp3/Response;", "parse", "statusLine", "", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final StatusLine get(Response r3) {
            Intrinsics.checkParameterIsNotNull(r3, ChatMessage.TYPE_RESPONSE);
            return new StatusLine(r3.protocol(), r3.code(), r3.message());
        }

        public final StatusLine parse(String r9) {
            Intrinsics.checkParameterIsNotNull(r9, "statusLine");
            int r5 = 9;
            if (StringsKt.startsWith$default(r9, "HTTP/1.", false, 2, null) == false) goto L19;
            if (r9.length() < 9) goto L17;
            if (r9.charAt(8) != ' ') goto L17;
            int r8 = r9.charAt(7) - '0';
            if (r8 != 0) goto L12;
            Protocol r10 = Protocol.HTTP_1_0;
        L21:
            int r1 = r5 + 3;
            if (r9.length() < r1) goto L37;
            String r0 = r9.substring(r5, r1);     // Catch: NumberFormatException -> L34
            Intrinsics.checkExpressionValueIsNotNull(r0, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: NumberFormatException -> L34
            int r2 = Integer.parseInt(r0);     // Catch: NumberFormatException -> L34
            if (r9.length() > r1) goto L27;
            String r11 = "";
        L33:
            return new StatusLine(r10, r2, r11);
        L27:
            if (r9.charAt(r1) != ' ') goto L30;
            r11 = r9.substring(r5 + 4);
            Intrinsics.checkExpressionValueIsNotNull(r11, "(this as java.lang.String).substring(startIndex)");
            goto L33
        L30:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Unexpected status line: " + r9), Throwable.class, "com.obric.memorydata.plugin"));
        L35:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Unexpected status line: " + r9), Throwable.class, "com.obric.memorydata.plugin"));
        L37:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Unexpected status line: " + r9), Throwable.class, "com.obric.memorydata.plugin"));
        L12:
            if (r8 != 1) goto L15;
            r10 = Protocol.HTTP_1_1;
            goto L21
        L15:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Unexpected status line: " + r9), Throwable.class, "com.obric.memorydata.plugin"));
        L17:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Unexpected status line: " + r9), Throwable.class, "com.obric.memorydata.plugin"));
        L19:
            if (StringsKt.startsWith$default(r9, "ICY ", false, 2, null) == false) goto L39;
            r10 = Protocol.HTTP_1_0;
            r5 = 4;
            goto L21
        L39:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ProtocolException("Unexpected status line: " + r9), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StatusLine(Protocol r2, int r3, String r4) {
        Intrinsics.checkParameterIsNotNull(r2, "protocol");
        Intrinsics.checkParameterIsNotNull(r4, "message");
        this.protocol = r2;
        this.code = r3;
        this.message = r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.protocol != Protocol.HTTP_1_0) goto L5;
        String r1 = "HTTP/1.0";
    L6:
        r0.append(r1);
        r0.append(' ').append(this.code);
        r0.append(' ').append(this.message);
        String r4 = r0.toString();
        Intrinsics.checkExpressionValueIsNotNull(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    L5:
        r1 = "HTTP/1.1";
        goto L6
    }
}
