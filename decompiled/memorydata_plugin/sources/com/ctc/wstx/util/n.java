package com.ctc.wstx.util;

import com.bytedance.rpc.internal.RpcUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f3711a = null;

    static {
        f3711a = Pattern.compile("^file:///\\p{Alpha}|.*$");
    }

    public static InputStream a(URL r2) {
        if ("file".equals(r2.getProtocol()) == false) goto L14;
        String r0 = r2.getHost();
        if (r0 != null) goto L7;
    L8:
        String r3 = r2.getPath();
        if (r3.indexOf(37) < 0) goto L12;
        r3 = URLDecoder.decode(r3, RpcUtils.CHARSET_UTF8);
    L12:
        return new FileInputStream(r3);
    L7:
        if (r0.length() == 0) goto L8;
    L14:
        return r2.openStream();
    }

    public static URL a() {
        return a(new File("a").getAbsoluteFile().getParentFile());
    }

    public static URL a(File r0) {
        return r0.toURI().toURL();
    }

    public static URL a(String r4) {
        String r5 = c(r4);     // Catch: MalformedURLException -> L18
        int r0 = r5.indexOf(58, 0);     // Catch: MalformedURLException -> L18
        if (r0 >= 3) goto L5;
    L8:
        String r1 = new File(r5).getAbsolutePath();     // Catch: MalformedURLException -> L18
        char r2 = File.separatorChar;     // Catch: MalformedURLException -> L18
        if (r2 == '/') goto L12;
        r1 = r1.replace(r2, '/');     // Catch: MalformedURLException -> L18
    L12:
        if (r1.length() <= 0) goto L17;
        if (r1.charAt(0) == '/') goto L17;
        r1 = "/" + r1;     // Catch: MalformedURLException -> L18
    L17:
        return new URL("file", "", r1);
    L5:
        if (r0 > 8) goto L8;
        return new URL(r5);
    L18:
        e = move-exception;
        a(e, r4);
        return null;
    }

    public static URL a(String r1, URL r2) {
        if (r2 == null) goto L4;
        r1 = c(r1);     // Catch: MalformedURLException -> L7
        return new URL(r2, r1);
    L7:
        e = move-exception;
        a(e, r1);
        return null;
    L4:
        return a(r1);
    }

    private static void a(Exception r2, String r3) {
        throw g.a("[resolving systemId '" + r3 + "']: " + r2.toString(), r2);
    }

    public static URI b(String r5) {
    L25:
        e = move-exception;
        a(e, r5);
        return null;
    L4:
        if (r5.indexOf(124, 0) > 0) goto L6;
    L9:
        int r1 = r5.indexOf(58, 0);     // Catch: URISyntaxException -> L25
        if (r1 >= 3) goto L12;
    L15:
        String r2 = new File(r5).getAbsolutePath();     // Catch: URISyntaxException -> L25
        char r3 = File.separatorChar;     // Catch: URISyntaxException -> L25
        if (r3 == '/') goto L19;
        r2 = r2.replace(r3, '/');     // Catch: URISyntaxException -> L25
    L19:
        if (r2.length() <= 0) goto L24;
        if (r2.charAt(0) == '/') goto L24;
        r2 = "/" + r2;     // Catch: URISyntaxException -> L25
    L24:
        return new URI("file", r2, null);
    L12:
        if (r1 > 8) goto L15;
        return new URI(r5);
    L6:
        if (f3711a.matcher(r5).matches() == false) goto L9;
        return new URI(r5.replace('|', ':'));
    }

    private static String c(String r2) {
        int r0 = r2.indexOf(124);
        if (r0 > 0) goto L5;
        return r2;
    L5:
        if (f3711a.matcher(r2).matches() == false) goto L9;
        StringBuilder r1 = new StringBuilder(r2);
        r1.setCharAt(r0, ':');
        return r1.toString();
    L9:
        return r2;
    }
}
