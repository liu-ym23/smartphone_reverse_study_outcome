package com.bytedance.android.live.openplatform.impl.miniappcommon.debug;

import android.util.Base64;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.t;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/debug/MiniAppDebugContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniAppDebugContextService extends OpenPlatformContextService {
    public String a;
    public String b;

    public static final class a {
    }

    static {
    }

    public MiniAppDebugContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = "";
        this.b = "";
    }

    public final boolean f(long r4, String r6, int r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r6, "appId");
        Intrinsics.checkNotNullParameter(r8, "sign");
        StringBuilder r1 = new StringBuilder();
        r1.append(String.valueOf(r4));
        r1.append(r6);
        r1.append(String.valueOf(r7));
        int r5 = t.a;
        byte[] r10 = Base64.decode("MWVlMTExZmVjZmZjMTJkMTcxOWE5NzBkZDE3N2UxZGE=", 0);
        Charset r11 = Charsets.UTF_8;
        r1.append(new String(r10, r11));
        String r12 = r1.toString();
        if (r9 != 8) goto L22;
        String r13 = new String(Base64.decode("TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUFzY1BaL08vek00MjV3N1BLYXU5cHYzVUtZL0I2VmtzaHhjMlpodW02Vm12Q082dTVHeXl2R0dWUHlsWWF6Wi9lNFQ2a1orOVBEc0V6UHZUbzVRb0ZDaTdkZTZlcktEa0o5VW4wY3NwbWFKKzlnT0JiaHZodEw4d2xYREVVUDBlMzRpdmJXMWw3NGNFelJjT1hNTUJIYVNWNlZWZEJteVZhemdVYzFtZmFKK09rT3BLRFdveDFwOXUvU3BlVXJEQ2pzZXJvajJ1aldwYjArYW92bnd4M2VOSVR5ZnJuN2NkNFlSYnFTMXkwalk3U3BhMTVJaFVWTkdlU1VabGFkbkZmbUZZaXRhb2JEdGttQ2h4UWo1OG5BZ1ZrTnBwZHF1VXBza1g5Zk1tNURINUI4QUppSzJTaGhQNUJQa2FjYUVERllHdkNhdzBQMWVsdkNjbmZnbHlDSHdJREFRQUI=", 0), r11);
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "senderPublicKey");
        Intrinsics.checkNotNullParameter(r8, "sign");
        byte[] r14 = Base64.decode(r13, 0);     // Catch: Throwable -> L20
        KeyFactory r15 = KeyFactory.getInstance("RSA");     // Catch: Throwable -> L20
        if (r15 == null) goto L13;
        PublicKey r16 = r15.generatePublic(new X509EncodedKeySpec(r14));     // Catch: Throwable -> L20
        if (r16 == null) goto L12;
        RSAPublicKey r17 = (RSAPublicKey) r16;     // Catch: Throwable -> L20
    L14:
        if (r17 != null) goto L16;
        boolean r18 = false;
    L17:
        if (r18 == false) goto L23;
        return true;
    L23:
        return false;
    L16:
        Signature r19 = Signature.getInstance("SHA256withRSA");
        r19.initVerify(r17);
        r19.update(r12.getBytes(Charsets.UTF_8));
        r18 = r19.verify(Base64.decode(r8, 0));
        goto L17
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");     // Catch: Throwable -> L20
    L13:
        r17 = null;
        goto L14
    L22:
        return false;
    }
}
