package com.bytedance.android.live.core.utils;

import android.content.ClipData;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ClipPrimaryUtil {
    private static final Cert CERT = null;
    private static CharSequence perString;

    static {
        CERT = TokenCert.with("bpea-clipprimaryutil_clipboard");
    }

    private ClipPrimaryUtil() {
    }

    public static void setPrimaryText(CharSequence r0, Cert r1) throws Exception {
        perString = r0;
        g80.d.c(ClipData.newPlainText(r0, r0), r1);
    }
}
