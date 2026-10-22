package com.bytedance.android.alog;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1005a = 9;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f1006b;
    private static long c;
    private static ArrayList<String> d;
    private static String e;

    static {
    }

    static File[] a(String r9, String r10, String r11, final long r12, final long r14) {
        f1006b = r12;
        c = r14;
        e = null;
        d = null;
        if (r12 <= r14) goto L7;
        String r13 = "time interval is invalid";
    L5:
        e = r13;
        return new File[0];
    L7:
        File r0 = new File(r9);
        if (r0.exists() == true) goto L10;
    L31:
        r13 = "log dir not exists";
        goto L5
    L10:
        if (r0.isDirectory() == false) goto L31;
        if (TextUtils.isEmpty(r10) == true) goto L15;
        r10 = r10.replace(':', '-');
    L15:
        StringBuilder r15 = new StringBuilder().append("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r3 = "\\S+";
        if (TextUtils.isEmpty(r10) == false) goto L18;
        String r16 = "\\S+";
    L19:
        StringBuilder r17 = r15.append(r16).append("__");
        if (TextUtils.isEmpty(r11) == true) goto L23;
        r3 = Pattern.quote(r11);
    L23:
        final Pattern r4 = Pattern.compile(r17.append(r3).append("\\.alog\\.hot$").toString());
        final ArrayList<String> r18 = new ArrayList();
        File[] r19 = r0.listFiles(new AnonymousClass1(r18, r4, r14, r12));
        if (r19 != null) goto L26;
    L27:
        e = "log file not found";
        d = r18;
    L28:
        if (r19 == null) goto L30;
        return r19;
    L30:
        return new File[0];
    L26:
        if (r19.length != 0) goto L28;
    L18:
        r16 = Pattern.quote(r10);
        goto L19
    }
}
