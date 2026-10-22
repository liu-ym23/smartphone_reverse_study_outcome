package com.tom_roush.pdfbox.util;

import com.bytedance.rpc.internal.RpcUtils;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f16297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f16298b = null;
    public static final Charset c = null;
    public static final Charset d = null;
    public static final Charset e = null;
    public static final Charset f = null;

    static {
        f16297a = Charset.forName("US-ASCII");
        f16298b = Charset.forName("UTF-16BE");
        c = Charset.forName("UTF-16LE");
        d = Charset.forName("ISO-8859-1");
        e = Charset.forName("Windows-1252");
        f = Charset.forName(RpcUtils.CHARSET_UTF8);
    }
}
