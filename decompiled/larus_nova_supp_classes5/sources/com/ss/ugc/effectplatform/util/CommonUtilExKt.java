package com.ss.ugc.effectplatform.util;

import bytekn.foundation.io.file.ContentEncoding;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CommonUtilExKt {
    public static final String a(byte[] r1, final ContentEncoding r2) {
        return new String(r1, (Charset) new CommonUtilExKt$convertToEncoding$charset$1(r2).invoke());
    }
}
