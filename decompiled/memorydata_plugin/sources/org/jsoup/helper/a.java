package org.jsoup.helper;

import com.bytedance.rpc.internal.RpcUtils;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f18245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f18246b = null;
    private static final Pattern c = null;
    private static final char[] d = null;

    static {
        c = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");
        Charset r0 = Charset.forName(RpcUtils.CHARSET_UTF8);
        f18245a = r0;
        f18246b = r0.name();
        d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }
}
