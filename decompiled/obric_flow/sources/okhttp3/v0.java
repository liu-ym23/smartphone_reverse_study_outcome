package okhttp3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 {
    public static u0 a(String r10, h0 r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$toResponseBody");
        Charset r5 = Charsets.UTF_8;
        if (r11 == null) goto L8;
        Pattern r12 = h0.e;
        Charset r13 = r11.a(null);
        if (r13 != null) goto L7;
        r11 = z.j(r11 + "; charset=utf-8");
        goto L8
    L7:
        r5 = r13;
    L8:
        nu.j r14 = new nu.j();
        Intrinsics.checkNotNullParameter(r10, "string");
        Intrinsics.checkNotNullParameter(r5, "charset");
        int r15 = r10.length();
        Intrinsics.checkNotNullParameter(r10, "string");
        Intrinsics.checkNotNullParameter(r5, "charset");
        if (r15 < 0) goto L25;
        if (r15 <= r10.length()) goto L13;
        StringBuilder r16 = ai.j0.s(r15, "endIndex > string.length: ", " > ");
        r16.append(r10.length());
        throw new IllegalArgumentException(r16.toString().toString());
    L13:
        if (Intrinsics.areEqual(r5, Charsets.UTF_8) == false) goto L15;
        r14.a0(0, r15, r10);
    L19:
        return b(r14, r11, r14.f20328b);
    L15:
        String r17 = r10.substring(0, r15);
        if (r17 == null) goto L21;
        byte[] r18 = r17.getBytes(r5);
        r14.S(r18, 0, r18.length);
        goto L19
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L25:
        throw new IllegalArgumentException(ai.j0.f(r15, 0, "endIndex < beginIndex: ", " < ").toString());
    }

    public static u0 b(nu.l r5, h0 r10, long r11) {
        Intrinsics.checkNotNullParameter(r5, "$this$asResponseBody");
        return new u0(r5, r10, r11);
    }

    public static u0 c(byte[] r5, h0 r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$toResponseBody");
        nu.j r11 = new nu.j();
        r11.R(r5);
        return b(r11, r10, r5.length);
    }
}
