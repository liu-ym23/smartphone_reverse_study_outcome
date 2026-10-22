package com.ss.android.socialbase.downloader.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class SqlUtils {
    public SqlUtils() {
    }

    public static StringBuilder appendColumn(StringBuilder r1, String r2) {
        r1.append('\"');
        r1.append(r2);
        r1.append('\"');
        return r1;
    }

    public static StringBuilder appendColumns(StringBuilder r4, String[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        r4.append('\"');
        r4.append(r5[r1]);
        r4.append('\"');
        if (r1 >= (r0 - 1)) goto L7;
        r4.append(',');
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r4;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder r3, String[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L9;
        appendColumn(r3, r4[r0]).append("=?");
        if (r0 >= (r4.length - 1)) goto L8;
        r3.append(',');
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r3;
    }

    public static StringBuilder appendPlaceholders(StringBuilder r2, int r3) {
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

    public static String createSqlDelete(String r2, String[] r3) {
        String r4 = "\"" + r2 + '\"';
        StringBuilder r0 = new StringBuilder("DELETE FROM ");
        r0.append(r4);
        if (r3 == null) goto L8;
        if (r3.length <= 0) goto L8;
        r0.append(" WHERE ");
        appendColumnsEqValue(r0, r4, r3);
    L8:
        return r0.toString();
    }

    public static StringBuilder appendColumn(StringBuilder r0, String r1, String r2) {
        r0.append(r1);
        r0.append(".\"");
        r0.append(r2);
        r0.append('\"');
        return r0;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder r3, String r4, String[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L9;
        appendColumn(r3, r4, r5[r0]).append("=?");
        if (r0 >= (r5.length - 1)) goto L8;
        r3.append(',');
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r3;
    }

    public static String createSqlInsert(String r1, String r2, String[] r3) {
        StringBuilder r0 = new StringBuilder(r1);
        r0.append('\"');
        r0.append(r2);
        r0.append("\" (");
        appendColumns(r0, r3);
        r0.append(") VALUES (");
        appendPlaceholders(r0, r3.length);
        r0.append(')');
        return r0.toString();
    }

    public static String createSqlInsertOrReplace(String r2, String[] r3, String[] r4) {
        StringBuilder r5 = new StringBuilder("INSERT OR REPLACE INTO ");
        r5.append("\"" + r2 + '\"');
        r5.append(" (");
        appendColumns(r5, r3);
        r5.append(") VALUES (");
        appendPlaceholders(r5, r3.length);
        r5.append(')');
        return r5.toString();
    }

    public static String createSqlUpdate(String r2, String[] r3, String[] r4) {
        String r5 = "\"" + r2 + '\"';
        StringBuilder r0 = new StringBuilder("UPDATE ");
        r0.append(r5);
        r0.append(" SET ");
        appendColumnsEqualPlaceholders(r0, r3);
        if (r4 == null) goto L8;
        if (r4.length <= 0) goto L8;
        r0.append(" WHERE ");
        appendColumnsEqValue(r0, r5, r4);
    L8:
        return r0.toString();
    }
}
