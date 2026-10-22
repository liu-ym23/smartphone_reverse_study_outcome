package com.ss.android.socialbase.downloader.utils;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static StringBuilder a(StringBuilder r10, String r11) {
        r10.append(Typography.quote);
        r10.append(r11);
        r10.append(Typography.quote);
        return r10;
    }

    public static StringBuilder b(StringBuilder r10, String r11, String r12) {
        r10.append(r11);
        r10.append(".\"");
        r10.append(r12);
        r10.append(Typography.quote);
        return r10;
    }

    public static StringBuilder c(StringBuilder r10, String[] r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        r10.append(Typography.quote);
        r10.append(r11[r13]);
        r10.append(Typography.quote);
        if (r13 >= (r12 - 1)) goto L7;
        r10.append(',');
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r10;
    }

    public static StringBuilder d(StringBuilder r10, String r11, String[] r12) {
        int r13 = 0;
    L4:
        if (r13 >= r12.length) goto L9;
        b(r10, r11, r12[r13]).append("=?");
        if (r13 >= (r12.length - 1)) goto L8;
        r10.append(',');
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r10;
    }

    public static StringBuilder e(StringBuilder r10, String[] r11) {
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L9;
        a(r10, r11[r12]).append("=?");
        if (r12 >= (r11.length - 1)) goto L8;
        r10.append(',');
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        return r10;
    }

    public static StringBuilder f(StringBuilder r10, int r11) {
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r12 >= (r11 - 1)) goto L7;
        r10.append("?,");
    L8:
        r12 = r12 + 1;
        goto L3
    L7:
        r10.append('?');
        goto L8
    L9:
        return r10;
    }

    public static String g(String r10, String[] r11) {
        String r12 = Typography.quote + r10 + Typography.quote;
        StringBuilder r13 = new StringBuilder("DELETE FROM ");
        r13.append(r12);
        if (r11 == null) goto L8;
        if (r11.length <= 0) goto L8;
        r13.append(" WHERE ");
        d(r13, r12, r11);
    L8:
        return r13.toString();
    }

    public static String h(String r10, String r11, String[] r12) {
        StringBuilder r13 = new StringBuilder(r10);
        r13.append(Typography.quote);
        r13.append(r11);
        r13.append(Typography.quote);
        r13.append(" (");
        c(r13, r12);
        r13.append(") VALUES (");
        f(r13, r12.length);
        r13.append(')');
        return r13.toString();
    }

    public static String i(String r10, String[] r11, String[] r12) {
        StringBuilder r13 = new StringBuilder("INSERT OR REPLACE INTO ");
        r13.append(Typography.quote + r10 + Typography.quote);
        r13.append(" (");
        c(r13, r11);
        r13.append(") VALUES (");
        f(r13, r11.length);
        r13.append(')');
        return r13.toString();
    }

    public static String j(String r10, String[] r11, String[] r12) {
        String r13 = Typography.quote + r10 + Typography.quote;
        StringBuilder r14 = new StringBuilder("UPDATE ");
        r14.append(r13);
        r14.append(" SET ");
        e(r14, r11);
        if (r12 == null) goto L8;
        if (r12.length <= 0) goto L8;
        r14.append(" WHERE ");
        d(r14, r13, r12);
    L8:
        return r14.toString();
    }
}
