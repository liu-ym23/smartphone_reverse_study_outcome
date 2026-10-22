package okhttp3;

import java.nio.charset.Charset;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    static {
        new n();
    }

    private n() {
    }

    @JvmStatic
    @JvmOverloads
    public static final String a(String r10, String r11, Charset r12) {
        Intrinsics.checkNotNullParameter(r10, "username");
        Intrinsics.checkNotNullParameter(r11, "password");
        Intrinsics.checkNotNullParameter(r12, "charset");
        return "Basic " + ByteString.Companion.c(r10 + ':' + r11, r12).base64();
    }
}
