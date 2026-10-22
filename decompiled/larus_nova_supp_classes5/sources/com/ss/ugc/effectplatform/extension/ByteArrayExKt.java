package com.ss.ugc.effectplatform.extension;

import bytekn.foundation.io.file.ContentEncoding;
import java.nio.charset.Charset;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ByteArrayExKt {
    public static final byte[] a(String r1) {
        return r1.getBytes(Charsets.UTF_8);
    }

    public static final String b(byte[] r1, int r2, int r3, final ContentEncoding r4) {
        return new String(r1, r2, r3, (Charset) new ByteArrayExKt$toString$charset$1(r4).invoke());
    }
}
