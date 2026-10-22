package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

/* JADX INFO: loaded from: classes6.dex */
public class l extends k {
    public l(String r1, boolean r2) {
        super(a(r1, r2));
    }

    private static Properties a(String r4, boolean r5) {
        Properties r0 = new Properties();
        Iterator<URL> r6 = g.a(r4, r5).iterator();
    L4:
        if (r6.hasNext() == false) goto L22;
        URL r7 = (URL) ZeusTransformUtils.preCheckCast(r6.next(), URL.class, "com.obric.memorydata.plugin");
        InputStream r1 = r7.openStream();     // Catch: IOException -> L20
        r0.load(r1);     // Catch: Throwable -> L11
    L8:
        if (r1 == null) goto L4;
        r1.close();     // Catch: IOException -> L20
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r1 != null) goto L25;
    L19:
        throw th;     // Catch: IOException -> L20
    L25:
        r1.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        h.a("Unable to read " + r7, e);
        goto L4
    L22:
        return r0;
    }
}
