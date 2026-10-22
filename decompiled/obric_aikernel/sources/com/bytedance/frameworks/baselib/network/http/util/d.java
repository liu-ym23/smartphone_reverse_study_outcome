package com.bytedance.frameworks.baselib.network.http.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f1870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f1871b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f1872c = null;

    static {
        f1870a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f1871b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f1872c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r10) {
        return f1870a.matcher(r10).matches();
    L4:
        return false;
    }

    public static boolean b(String r10) {
        return f1872c.matcher(r10).matches();
    L4:
        return false;
    }

    public static boolean c(String r10) {
        return f1871b.matcher(r10).matches();
    L4:
        return false;
    }
}
