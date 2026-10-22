package d88;

import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "target");
        return StringsKt.padStart(new BigInteger(1, MessageDigest.getInstance("MD5").digest(r3.getBytes(Charsets.UTF_8))).toString(16), 32, '0');
    }
}
