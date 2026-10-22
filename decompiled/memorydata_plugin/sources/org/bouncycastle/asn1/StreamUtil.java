package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes7.dex */
class StreamUtil {
    static int findLimit(InputStream r4) {
        if (ZeusTransformUtils.instanceOf(r4, LimitedInputStream.class) == false) goto L7;
        return ((LimitedInputStream) ZeusTransformUtils.preCheckCast(r4, LimitedInputStream.class, "com.obric.memorydata.plugin")).getLimit();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ASN1InputStream.class) == false) goto L11;
        return ((ASN1InputStream) ZeusTransformUtils.preCheckCast(r4, ASN1InputStream.class, "com.obric.memorydata.plugin")).getLimit();
    L11:
        if (ZeusTransformUtils.instanceOf(r4, ByteArrayInputStream.class) == false) goto L15;
        return ((ByteArrayInputStream) ZeusTransformUtils.preCheckCast(r4, ByteArrayInputStream.class, "com.obric.memorydata.plugin")).available();
    L15:
        if (ZeusTransformUtils.instanceOf(r4, FileInputStream.class) == true) goto L32;
    L25:
        long r0 = Runtime.getRuntime().maxMemory();
        if (r0 <= 2147483647L) goto L30;
        return Integer.MAX_VALUE;
    L30:
        return (int) r0;
    L32:
        FileChannel r5 = ((FileInputStream) ZeusTransformUtils.preCheckCast(r4, FileInputStream.class, "com.obric.memorydata.plugin")).getChannel();     // Catch: IOException -> L31
        if (r5 == null) goto L20;
        long r1 = r5.size();     // Catch: IOException -> L31
    L22:
        if (r1 >= 2147483647L) goto L25;
        return (int) r1;
    L20:
        r1 = 2147483647L;
        goto L22
    }
}
