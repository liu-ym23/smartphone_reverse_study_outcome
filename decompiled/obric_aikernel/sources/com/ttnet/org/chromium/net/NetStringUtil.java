package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.Normalizer;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class NetStringUtil {
    public NetStringUtil() {
    }

    @CalledByNative
    private static String convertToUnicode(ByteBuffer r10, String r11) {
        return Charset.forName(r11).newDecoder().decode(r10).toString();
    L4:
        return null;
    }

    @CalledByNative
    private static String convertToUnicodeAndNormalize(ByteBuffer r10, String r11) {
        String r12 = convertToUnicode(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return Normalizer.normalize(r12, Normalizer.Form.NFC);
    }

    @CalledByNative
    private static String convertToUnicodeWithSubstitutions(ByteBuffer r10, String r11) {
        CharsetDecoder r12 = Charset.forName(r11).newDecoder();     // Catch: Exception -> L4
        r12.onMalformedInput(CodingErrorAction.REPLACE);     // Catch: Exception -> L4
        r12.onUnmappableCharacter(CodingErrorAction.REPLACE);     // Catch: Exception -> L4
        r12.replaceWith("�");     // Catch: Exception -> L4
        return r12.decode(r10).toString();
    L4:
        return null;
    }

    @CalledByNative
    private static String toUpperCase(String r10) {
        return r10.toUpperCase(Locale.getDefault());
    L4:
        return null;
    }
}
