package knb;

import android.util.Base64;
import com.ss.android.lark.log.Log;
import java.nio.charset.Charset;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Charset r0 = Charsets.UTF_8;     // Catch: Exception -> L5
        return new String(Base64.encode(r2.getBytes(r0), 0), r0);
    L5:
        e = move-exception;
        Log.e("EncryptUtil", "encode Base64 exception: " + e.getMessage());
        return null;
    }
}
