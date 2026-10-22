package kc;

import java.net.ProtocolException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f10188d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final Protocol f10189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final int f10190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final String f10191c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final k a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "statusLine");
            int r11 = 9;
            if (StringsKt.startsWith$default(r10, "HTTP/1.", false, 2, null) == false) goto L19;
            if (r10.length() < 9) goto L17;
            if (r10.charAt(8) != ' ') goto L17;
            int r12 = r10.charAt(7) - '0';
            if (r12 != 0) goto L11;
            Protocol r13 = Protocol.HTTP_1_0;
        L21:
            int r14 = r11 + 3;
            if (r10.length() < r14) goto L37;
            String r15 = r10.substring(r11, r14);     // Catch: NumberFormatException -> L34
            Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: NumberFormatException -> L34
            int r16 = Integer.parseInt(r15);     // Catch: NumberFormatException -> L34
            if (r10.length() > r14) goto L27;
            String r17 = "";
        L33:
            return new k(r13, r16, r17);
        L27:
            if (r10.charAt(r14) != ' ') goto L30;
            r17 = r10.substring(r11 + 4);
            Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).substring(startIndex)");
            goto L33
        L30:
            throw new ProtocolException("Unexpected status line: " + r10);
        L35:
            throw new ProtocolException("Unexpected status line: " + r10);
        L37:
            throw new ProtocolException("Unexpected status line: " + r10);
        L11:
            if (r12 != 1) goto L14;
            r13 = Protocol.HTTP_1_1;
            goto L21
        L14:
            throw new ProtocolException("Unexpected status line: " + r10);
        L17:
            throw new ProtocolException("Unexpected status line: " + r10);
        L19:
            if (StringsKt.startsWith$default(r10, "ICY ", false, 2, null) == false) goto L39;
            r13 = Protocol.HTTP_1_0;
            r11 = 4;
            goto L21
        L39:
            throw new ProtocolException("Unexpected status line: " + r10);
        }
    }

    static {
        f10188d = new a(null);
    }

    public k(Protocol r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "protocol");
        Intrinsics.checkNotNullParameter(r12, "message");
        this.f10189a = r10;
        this.f10190b = r11;
        this.f10191c = r12;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.f10189a != Protocol.HTTP_1_0) goto L5;
        String r11 = "HTTP/1.0";
    L6:
        r10.append(r11);
        r10.append(' ');
        r10.append(this.f10190b);
        r10.append(' ');
        r10.append(this.f10191c);
        String r12 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    L5:
        r11 = "HTTP/1.1";
        goto L6
    }
}
