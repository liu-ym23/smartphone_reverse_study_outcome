package com.bytedance.android.alog;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public static long a;
    public static long b;
    public static ArrayList<String> c;
    public static String d;

    public static File[] a(String r9, String r10, String r11, long r12, long r14) {
        a = r12;
        b = r14;
        d = null;
        c = null;
        if (r12 <= r14) goto L6;
        d = "time interval is invalid";
        return new File[0];
    L6:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r9);
        if (r1.exists() == true) goto L9;
    L30:
        d = "log dir not exists";
        return new File[0];
    L9:
        if (r1.isDirectory() == false) goto L30;
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r10 = r10.replace(':', '-');
    L14:
        StringBuilder r13 = new StringBuilder("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r3 = "\\S+";
        if (TextUtils.isEmpty(r10) == false) goto L17;
        String r15 = "\\S+";
    L18:
        r13.append(r15);
        r13.append("__");
        if (TextUtils.isEmpty(r11) == true) goto L22;
        r3 = Pattern.quote(r11);
    L22:
        r13.append(r3);
        r13.append("\\.alog\\.hot$");
        Pattern r4 = PatternProtector.compile(r13.toString());
        ArrayList<String> r16 = new ArrayList();
        File[] r17 = r1.listFiles(new a(r16, r4, r14, r12));
        if (r17 != null) goto L25;
    L26:
        d = "log file not found";
        c = r16;
    L27:
        if (r17 == null) goto L29;
        return r17;
    L29:
        return new File[0];
    L25:
        if (r17.length != 0) goto L27;
    L17:
        r15 = Pattern.quote(r10);
        goto L18
    }
}
