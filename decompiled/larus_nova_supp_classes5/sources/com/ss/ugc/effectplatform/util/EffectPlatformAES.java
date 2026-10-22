package com.ss.ugc.effectplatform.util;

import android.util.Log;
import bytekn.foundation.encryption.Padding;
import bytekn.foundation.io.file.ContentEncoding;
import bytekn.foundation.logger.Logger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class EffectPlatformAES {
    public static final String a = null;
    public static final a0.b<klc.a> b = null;
    public static final Lazy c = null;

    public EffectPlatformAES() {
    }

    static {
        int r0 = n.a;
        a = "760.0.0.269-alpha.24";
        b = new a0.b(null);
        c = LazyKt.lazy(EffectPlatformAES$defaultCryptKey$2.INSTANCE);
    }

    public static String a(String r9, byte[] r10) {
        if (r9 == null) goto L20;
        String r1 = "";
        if (StringsKt.isBlank(r9) == false) goto L6;
        return "";
    L6:
        RuntimeException r0 = new RuntimeException();
        bytekn.foundation.encryption.a.a r2 = bytekn.foundation.encryption.a.r;     // Catch: Exception -> L9
        byte[] r3 = d0.a.a(r9);     // Catch: Exception -> L9
        Padding r4 = Padding.PKCS7Padding;     // Catch: Exception -> L9
        r2.getClass();     // Catch: Exception -> L9
        return CommonUtilExKt.a(bytekn.foundation.encryption.a.a.a(r3, r10, r10, r4), ContentEncoding.Utf8);
    L9:
        e = move-exception;
        Logger r5 = Logger.INSTANCE;
        StringBuilder r6 = new StringBuilder("decrypt failed!, content: ");
        r6.append(r9);
        r6.append(", platformVersion: ");
        String r7 = a;
        r6.append(r7);
        r5.e("EffectPlatformAES", r6.toString(), e);
        int r8 = n.a;
        boolean r11 = Intrinsics.areEqual(r7, "760.0.0.269-alpha.24");
        klc.a r12 = (klc.a) b.a;
        if (r12 == null) goto L20;
        String r13 = e.getMessage();
        String r14 = Log.getStackTraceString(r0);
        int r15 = !Arrays.equals((byte[]) c.getValue(), r10) ? 1 : 0;
        Pair[] r16 = new Pair[6];
        r16[0] = TuplesKt.to("content", r9);
        if (r13 != null) goto L16;
        r13 = "";
    L16:
        r16[1] = TuplesKt.to("error_msg", r13);
        r16[2] = TuplesKt.to("stack_trace", r14);
        r16[3] = TuplesKt.to("effect_platform_type", Integer.valueOf(r11 ? 1 : 0));
        if (r7 == null) goto L19;
        r1 = r7;
    L19:
        r16[4] = TuplesKt.to(EffectConfiguration.KEY_PLATFORM_SDK_VERSION, r1);
        r16[5] = TuplesKt.to("is_third_party_business", Integer.valueOf(r15));
        r12.monitorStatusRate("effectplatform_decrypt_fail", 1, MapsKt.mutableMapOf(r16));
    L20:
        return null;
    }
}
