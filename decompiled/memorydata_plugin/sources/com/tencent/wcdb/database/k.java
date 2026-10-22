package com.tencent.wcdb.database;

import android.text.TextUtils;
import com.tencent.wcdb.support.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f15859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f15860b;
    private String c;
    private StringBuilder d;
    private boolean e;
    private SQLiteDatabase.a f;
    private boolean g;

    static {
        f15859a = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    public static String a(boolean r2, String r3, String[] r4, String r5, String r6, String r7, String r8, String r9) {
        if (TextUtils.isEmpty(r6) == false) goto L10;
        if (TextUtils.isEmpty(r7) == true) goto L10;
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    L10:
        if (TextUtils.isEmpty(r9) == false) goto L12;
    L16:
        StringBuilder r0 = new StringBuilder(120);
        r0.append("SELECT ");
        if (r2 == false) goto L19;
        r0.append("DISTINCT ");
    L19:
        if (r4 != null) goto L21;
    L23:
        r0.append("* ");
    L24:
        r0.append("FROM ");
        r0.append(r3);
        a(r0, " WHERE ", r5);
        a(r0, " GROUP BY ", r6);
        a(r0, " HAVING ", r7);
        a(r0, " ORDER BY ", r8);
        a(r0, " LIMIT ", r9);
        return r0.toString();
    L21:
        if (r4.length == 0) goto L23;
        a(r0, r4);
        goto L24
    L12:
        if (f15859a.matcher(r9).matches() == true) goto L16;
        throw new IllegalArgumentException("invalid LIMIT clauses:" + r9);
    }

    private void a(SQLiteDatabase r2, String r3, com.tencent.wcdb.support.a r4) {
        r2.c().a(r3, r2.a(true), r4, null);
    }

    private static void a(StringBuilder r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.append(r2);
        r1.append(r3);
        return;
    }

    public static void a(StringBuilder r4, String[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        String r2 = r5[r1];
        if (r2 == null) goto L9;
        if (r1 <= 0) goto L8;
        r4.append(", ");
    L8:
        r4.append(r2);
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        r4.append(' ');
    }

    private String[] a(String[] r8) {
        int r0 = 0;
        if (r8 != null) goto L5;
    L25:
        Map<String, String> r7 = this.f15860b;
        if (r7 == null) goto L35;
        Set<Map.Entry<String, String>> r9 = r7.entrySet();
        String[] r10 = new String[r9.size()];
        Iterator<Map.Entry<String, String>> r11 = r9.iterator();
    L29:
        if (r11.hasNext() == false) goto L34;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")).equals("_count") == true) goto L29;
        r10[r0] = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin");
        r0 = r0 + 1;
        goto L29
    L34:
        return r10;
    L35:
        return null;
    L5:
        if (r8.length <= 0) goto L25;
        if (this.f15860b == null) goto L24;
        String[] r3 = new String[r8.length];
        int r4 = r8.length;
    L9:
        if (r0 >= r4) goto L23;
        String r5 = r8[r0];
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.f15860b.get(r5), String.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L14;
        r3[r0] = r6;
    L20:
        r0 = r0 + 1;
        goto L9
    L14:
        if (this.g == true) goto L22;
        if (r5.contains(" AS ") == false) goto L18;
    L19:
        r3[r0] = r5;
        goto L20
    L18:
        if (r5.contains(" as ") == true) goto L19;
    L22:
        throw new IllegalArgumentException("Invalid column " + r8[r0]);
    L23:
        return r3;
    L24:
        return r8;
    }

    public String a(String[] r9, String r10, String r11, String r12, String r13, String r14) {
        String[] r2 = a(r9);
        StringBuilder r15 = new StringBuilder();
        StringBuilder r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        r15.append(this.d.toString());
        r15.append(')');
    L11:
        if (r10 == null) goto L18;
        if (r10.length() <= 0) goto L18;
        if (r1 == false) goto L16;
        r15.append(" AND ");
    L16:
        r15.append('(');
        r15.append(r10);
        r15.append(')');
    L18:
        return a(this.e, this.c, r2, r15.toString(), r11, r12, r13, r14);
    L5:
        if (r0.length() <= 0) goto L7;
        r1 = true;
        goto L9
    }

    public com.tencent.wcdb.f query(SQLiteDatabase r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17) {
        return query(r11, r12, r13, r14, r15, r16, r17, null, null);
    }

    public com.tencent.wcdb.f query(SQLiteDatabase r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17, String r18) {
        return query(r11, r12, r13, r14, r15, r16, r17, r18, null);
    }

    public com.tencent.wcdb.f query(SQLiteDatabase r12, String[] r13, String r14, String[] r15, String r16, String r17, String r18, String r19, com.tencent.wcdb.support.a r20) {
        if (this.c != null) goto L7;
        return null;
    L7:
        if (this.g == false) goto L13;
        if (r14 == null) goto L13;
        if (r14.length() <= 0) goto L13;
        a(r12, a(r13, "(" + r14 + ")", r16, r17, r18, r19), r20);
    L13:
        String r3 = a(r13, r14, r16, r17, r18, r19);
        Log.d("WCDB.SQLiteQueryBuilder", "Performing query: " + r3);
        return r12.a(this.f, r3, r15, SQLiteDatabase.a(this.c), r20);
    }
}
