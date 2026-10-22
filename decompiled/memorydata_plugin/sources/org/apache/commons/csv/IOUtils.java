package org.apache.commons.csv;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes6.dex */
class IOUtils {
    static long copy(Reader r2, Appendable r3) {
        return copy(r2, (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin"), CharBuffer.allocate(4096));
    }

    static long copy(Reader r4, Appendable r5, CharBuffer r6) {
        Appendable r7 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r5, Appendable.class, "com.obric.memorydata.plugin");
        long r0 = 0;
    L3:
        int r3 = r4.read(r6);
        if ((-1) == r3) goto L6;
        r6.flip();
        r7.append(r6, 0, r3);
        r0 = r0 + ((long) r3);
        goto L3
    L6:
        return r0;
    }

    static long copyLarge(Reader r1, Writer r2) {
        return copyLarge(r1, r2, new char[4096]);
    }

    static long copyLarge(Reader r4, Writer r5, char[] r6) {
        long r0 = 0;
    L3:
        int r3 = r4.read(r6);
        if ((-1) == r3) goto L6;
        r5.write(r6, 0, r3);
        r0 = r0 + ((long) r3);
        goto L3
    L6:
        return r0;
    }
}
