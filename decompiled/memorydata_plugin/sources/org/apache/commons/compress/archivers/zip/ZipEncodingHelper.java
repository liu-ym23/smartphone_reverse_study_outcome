package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ZipEncodingHelper {
    static final ZipEncoding UTF8_ZIP_ENCODING = null;

    static {
        UTF8_ZIP_ENCODING = getZipEncoding("UTF8");
    }

    public static ZipEncoding getZipEncoding(String r2) {
        Charset r0 = Charset.defaultCharset();
        if (r2 == null) goto L6;
        r0 = Charset.forName(r2);     // Catch: UnsupportedCharsetException -> L7
    L6:
        return new NioZipEncoding(r0, isUTF8(r0.name()));
    }

    static ByteBuffer growBufferBy(ByteBuffer r1, int r2) {
        r1.limit(r1.position());
        r1.rewind();
        ByteBuffer r3 = ByteBuffer.allocate(r1.capacity() + r2);
        r3.put(r1);
        return r3;
    }

    static boolean isUTF8(String r5) {
        if (r5 != null) goto L5;
        r5 = Charset.defaultCharset().name();
    L5:
        if (StandardCharsets.UTF_8.name().equalsIgnoreCase(r5) == false) goto L7;
        return true;
    L7:
        Iterator<String> r0 = StandardCharsets.UTF_8.aliases().iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin")).equalsIgnoreCase(r5) == false) goto L9;
        return true;
    L13:
        return false;
    }
}
