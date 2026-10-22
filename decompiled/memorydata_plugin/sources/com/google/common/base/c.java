package com.google.common.base;

import com.bytedance.rpc.internal.RpcUtils;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f4295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f4296b = null;
    public static final Charset c = null;
    public static final Charset d = null;
    public static final Charset e = null;
    public static final Charset f = null;

    static {
        f4295a = Charset.forName("US-ASCII");
        f4296b = Charset.forName("ISO-8859-1");
        c = Charset.forName(RpcUtils.CHARSET_UTF8);
        d = Charset.forName("UTF-16BE");
        e = Charset.forName("UTF-16LE");
        f = Charset.forName("UTF-16");
    }
}
