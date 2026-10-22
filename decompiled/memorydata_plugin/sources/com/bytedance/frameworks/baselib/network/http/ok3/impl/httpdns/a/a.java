package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2475a = "a";

    static {
    }

    public a() {
    }

    public static String a(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
    L8:
        if (r2 >= r6.size()) goto L14;
        r0.append((String) ZeusTransformUtils.preCheckCast(r6.get(r2), String.class, "com.obric.memorydata.plugin"));
        if (r2 == (r6.size() - 1)) goto L12;
        r0.append(',');
    L12:
        r2 = r2 + 1;
        goto L8
    L14:
        return r0.toString();
    }

    public static boolean a(String r5) {
        if (r5 == null) goto L31;
        char[] r6 = r5.toCharArray();
        if (r6.length <= 0) goto L31;
        if (r6.length > 255) goto L31;
        int r1 = r6.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L29;
        char r3 = r6[r2];
        if (r3 < 'A') goto L16;
        if (r3 > 'Z') goto L16;
    L28:
        r2 = r2 + 1;
    L16:
        if (r3 < 'a') goto L20;
        if (r3 <= 'z') goto L28;
    L20:
        if (r3 < '0') goto L24;
        if (r3 <= '9') goto L28;
    L24:
        if (r3 == '.') goto L28;
        if (r3 == '-') goto L28;
        return false;
    L29:
        return true;
    L31:
        return false;
    }
}
