package com.google.zxing.common;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f5070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f5071b = null;
    private static final Charset c = null;
    private static final Charset d = null;
    private static final boolean e = false;

    static {
        c = Charset.defaultCharset();
        Charset r0 = null;
        Charset r1 = Charset.forName("SJIS");     // Catch: UnsupportedCharsetException -> L5
    L6:
        f5070a = r1;
        Charset r2 = Charset.forName("GB2312");     // Catch: UnsupportedCharsetException -> L9
    L10:
        f5071b = r2;
        r0 = Charset.forName("EUC_JP");     // Catch: UnsupportedCharsetException -> L23
    L12:
        d = r0;
        Charset r3 = f5070a;
        if (r3 != null) goto L15;
    L16:
        if (r0 != null) goto L18;
    L20:
        boolean r4 = false;
    L21:
        e = r4;
        return;
    L18:
        if (r0.equals(c) == false) goto L20;
    L19:
        r4 = true;
        goto L21
    L15:
        if (r3.equals(c) == true) goto L19;
    L9:
        r2 = null;
    L5:
        r1 = null;
        goto L6
    }
}
