package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public final class de {
    public static void a(Throwable r1) {
        if (cx.f5415a == false) goto L6;
        b(r1);
        return;
    }

    private static String b(Throwable r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        Throwable r1 = r3;
    L6:
        if (r1 == null) goto L11;
        if (ZeusTransformUtils.instanceOf(r1, UnknownHostException.class) == true) goto L9;
        r1 = r1.getCause();
        goto L6
    L9:
        return "";
    L11:
        StringWriter r0 = new StringWriter();
        PrintWriter r2 = new PrintWriter(r0);
        r3.printStackTrace(r2);
        r2.flush();
        return r0.toString();
    }
}
