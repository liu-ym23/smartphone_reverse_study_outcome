package com.ss.ugc.effectplatform.extension;

import bytekn.foundation.io.file.ContentEncoding;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import com.ss.ugc.effectplatform.util.CommonUtilExKt;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final String a(ByteReadStream r5) {
        if (r5.available() == true) goto L6;
        return "";
    L6:
        bytekn.foundation.io.file.a r0 = new bytekn.foundation.io.file.a(32);
        byte[] r2 = new byte[1024];
        int r4 = r5.read(r2, 0, 1024);
    L7:
        if (r4 < 0) goto L9;
        r0.a(r2, 0, r4);
        r4 = r5.read(r2, 0, 1024);
        goto L7
    L9:
        r5.close();
        return CommonUtilExKt.a(Arrays.copyOf(r0.a, r0.b), ContentEncoding.Utf8);
    }
}
