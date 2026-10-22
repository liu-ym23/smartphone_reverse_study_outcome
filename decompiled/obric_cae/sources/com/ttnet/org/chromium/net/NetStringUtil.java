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
    private static String convertToUnicode(ByteBuffer r8, String r10) {
        return Charset.forName(r10).newDecoder().decode(r8).toString();
    L4:
        return null;
    }

    @CalledByNative
    private static String convertToUnicodeAndNormalize(ByteBuffer r8, String r10) {
        String r11 = convertToUnicode(r8, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return Normalizer.normalize(r11, Normalizer.Form.NFC);
    }

    @CalledByNative
    private static String convertToUnicodeWithSubstitutions(ByteBuffer r8, String r10) {
        CharsetDecoder r11 = Charset.forName(r10).newDecoder();     // Catch: Exception -> L4
        r11.onMalformedInput(CodingErrorAction.REPLACE);     // Catch: Exception -> L4
        r11.onUnmappableCharacter(CodingErrorAction.REPLACE);     // Catch: Exception -> L4
        r11.replaceWith("�");     // Catch: Exception -> L4
        return r11.decode(r8).toString();
    L4:
        return null;
    }

    @CalledByNative
    private static String toUpperCase(String r8) {
        return r8.toUpperCase(Locale.getDefault());
    L4:
        return null;
    }
}
