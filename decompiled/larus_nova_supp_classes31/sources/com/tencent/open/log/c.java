package com.tencent.open.log;

import com.tencent.connect.common.Constants;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class c {
    public static int a = 60;
    public static int b = 60;
    public static String c = "OpenSDK.Client.File.Tracer";
    public static String d;
    public static String e;
    public static long f;
    public static int g;
    public static int h;
    public static int i;
    public static String j;
    public static String k;
    public static String l;
    public static int m;
    public static long n;
    public static String o;

    static {
        StringBuilder r0 = new StringBuilder("Tencent");
        String r1 = File.separator;
        r0.append(r1);
        r0.append("msflogs");
        r0.append(r1);
        r0.append("com");
        r0.append(r1);
        r0.append("tencent");
        r0.append(r1);
        r0.append("mobileqq");
        r0.append(r1);
        d = r0.toString();
        e = ".log";
        f = 8388608;
        g = 262144;
        h = 1024;
        i = 10000;
        j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000;
        o = Constants.APP_SPECIFIC_ROOT + r1 + "logs";
    }
}
