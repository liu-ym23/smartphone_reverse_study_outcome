package o10;

import android.util.Base64;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "senderPublicKey");
        Intrinsics.checkNotNullParameter(r5, OpenPlatformBaseDebugger.SIGN);
        byte[] r6 = Base64.decode(r4, 0);     // Catch: Throwable -> L16
        KeyFactory r1 = KeyFactory.getInstance("RSA");     // Catch: Throwable -> L16
        if (r1 == null) goto L11;
        PublicKey r7 = r1.generatePublic(new X509EncodedKeySpec(r6));     // Catch: Throwable -> L16
        if (r7 == null) goto L10;
        RSAPublicKey r8 = (RSAPublicKey) r7;     // Catch: Throwable -> L16
    L12:
        if (r8 != null) goto L14;
        return false;
    L14:
        Signature r2 = Signature.getInstance("SHA256withRSA");
        r2.initVerify(r8);
        r2.update(r3.getBytes(Charsets.UTF_8));
        return r2.verify(Base64.decode(r5, 0));
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");     // Catch: Throwable -> L16
    L11:
        r8 = null;
        goto L12
    }
}
