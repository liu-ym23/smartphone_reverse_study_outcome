package okio;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    public static final byte[] a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r11 = r10.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).getBytes(charset)");
        return r11;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new String(r10, Charsets.UTF_8);
    }
}
