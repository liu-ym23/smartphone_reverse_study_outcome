package com.bytedance.frameworks.baselib.network.http.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f2540a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f2541b = null;
    private static final Pattern c = null;

    static {
        f2540a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f2541b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r1) {
        return f2540a.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean b(String r1) {
        return f2541b.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean c(String r1) {
        return c.matcher(r1).matches();
    L4:
        return false;
    }
}
