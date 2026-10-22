package com.ss.android.socialbase.downloader.utils;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
public class i {
    public static String a(String r2, String r3, String[] r4) {
        StringBuilder r0 = new StringBuilder(r2);
        r0.append(Typography.quote).append(r3).append(Typography.quote).append(" (");
        a(r0, r4);
        r0.append(") VALUES (");
        a(r0, r4.length);
        r0.append(')');
        return r0.toString();
    }

    public static String a(String r2, String[] r3) {
        String r4 = Typography.quote + r2 + Typography.quote;
        StringBuilder r0 = new StringBuilder("DELETE FROM ");
        r0.append(r4);
        if (r3 == null) goto L8;
        if (r3.length <= 0) goto L8;
        r0.append(" WHERE ");
        a(r0, r4, r3);
    L8:
        return r0.toString();
    }

    public static String a(String r3, String[] r4, String[] r5) {
        String r6 = Typography.quote + r3 + Typography.quote;
        StringBuilder r0 = new StringBuilder("UPDATE ");
        r0.append(r6).append(" SET ");
        b(r0, r4);
        if (r5 == null) goto L8;
        if (r5.length <= 0) goto L8;
        r0.append(" WHERE ");
        a(r0, r6, r5);
    L8:
        return r0.toString();
    }

    public static StringBuilder a(StringBuilder r2, int r3) {
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L9;
        if (r0 >= (r3 - 1)) goto L7;
        r2.append("?,");
    L8:
        r0 = r0 + 1;
        goto L3
    L7:
        r2.append('?');
        goto L8
    L9:
        return r2;
    }

    public static StringBuilder a(StringBuilder r2, String r3) {
        r2.append(Typography.quote).append(r3).append(Typography.quote);
        return r2;
    }

    public static StringBuilder a(StringBuilder r1, String r2, String r3) {
        r1.append(r2).append(".\"").append(r3).append(Typography.quote);
        return r1;
    }

    public static StringBuilder a(StringBuilder r3, String r4, String[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L9;
        a(r3, r4, r5[r0]).append("=?");
        if (r0 >= (r5.length - 1)) goto L8;
        r3.append(',');
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r3;
    }

    public static StringBuilder a(StringBuilder r5, String[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        r5.append(Typography.quote).append(r6[r1]).append(Typography.quote);
        if (r1 >= (r0 - 1)) goto L7;
        r5.append(',');
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r5;
    }

    public static String b(String r2, String[] r3, String[] r4) {
        StringBuilder r5 = new StringBuilder("INSERT OR REPLACE INTO ");
        r5.append(Typography.quote + r2 + Typography.quote).append(" (");
        a(r5, r3);
        r5.append(") VALUES (");
        a(r5, r3.length);
        r5.append(')');
        return r5.toString();
    }

    public static StringBuilder b(StringBuilder r3, String[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L9;
        a(r3, r4[r0]).append("=?");
        if (r0 >= (r4.length - 1)) goto L8;
        r3.append(',');
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r3;
    }
}
