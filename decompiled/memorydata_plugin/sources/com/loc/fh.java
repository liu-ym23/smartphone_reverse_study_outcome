package com.loc;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes3.dex */
public class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Charset> f5534a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<CharsetDecoder> f5535b = null;
    private static final ThreadLocal<CharBuffer> c = null;

    static {
        f5535b = new AnonymousClass1();
        f5534a = new AnonymousClass2();
        c = new ThreadLocal();
    }
}
