package okhttp3;

import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {
    public static o0 a(String r5, h0 r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$toRequestBody");
        Charset r11 = Charsets.UTF_8;
        if (r10 == null) goto L8;
        Pattern r12 = h0.e;
        Charset r13 = r10.a(null);
        if (r13 != null) goto L7;
        r10 = z.j(r10 + "; charset=utf-8");
        goto L8
    L7:
        r11 = r13;
    L8:
        byte[] r14 = r5.getBytes(r11);
        return b(r14, r10, 0, r14.length);
    }

    public static o0 b(byte[] r10, h0 r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$toRequestBody");
        Util.checkOffsetAndCount(r10.length, r12, r13);
        return new o0(r10, r11, r13, r12);
    }

    public static /* synthetic */ o0 c(p0 r5, byte[] r10, h0 r11, int r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = 0;
    L8:
        int r14 = r10.length;
        r5.getClass();
        return b(r10, r11, r12, r14);
    }
}
