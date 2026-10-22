package com.google.common.base;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f8658a = null;

    static {
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
        f8658a = Charset.forName("UTF-8");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-16");
    }
}
