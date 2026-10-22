package net.zetetic.database.sqlcipher;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class SQLiteQueryBuilder {
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = null;
    private boolean mDistinct;
    private SQLiteDatabase.CursorFactory mFactory;
    private Map<String, String> mProjectionMap;
    private boolean mStrict;
    private String mTables;
    private StringBuilder mWhereClause;

    static {
        sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    public SQLiteQueryBuilder() {
        this.mProjectionMap = null;
        this.mTables = "";
        this.mWhereClause = null;
        this.mDistinct = false;
        this.mFactory = null;
    }

    private static void appendClause(StringBuilder r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.append(r2);
        r1.append(r3);
        return;
    }

    public static void appendColumns(StringBuilder r4, String[] r5) {
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

    public static String buildQueryString(boolean r2, String r3, String[] r4, String r5, String r6, String r7, String r8, String r9) {
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
        appendClause(r0, " WHERE ", r5);
        appendClause(r0, " GROUP BY ", r6);
        appendClause(r0, " HAVING ", r7);
        appendClause(r0, " ORDER BY ", r8);
        appendClause(r0, " LIMIT ", r9);
        return r0.toString();
    L21:
        if (r4.length == 0) goto L23;
        appendColumns(r0, r4);
        goto L24
    L12:
        if (sLimitPattern.matcher(r9).matches() == true) goto L16;
        throw new IllegalArgumentException("invalid LIMIT clauses:" + r9);
    }

    private String[] computeProjection(String[] r8) {
        int r0 = 0;
        if (r8 != null) goto L5;
    L25:
        Map<String, String> r7 = this.mProjectionMap;
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
        if (this.mProjectionMap == null) goto L24;
        String[] r3 = new String[r8.length];
        int r4 = r8.length;
    L9:
        if (r0 >= r4) goto L23;
        String r5 = r8[r0];
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.mProjectionMap.get(r5), String.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L14;
        r3[r0] = r6;
    L20:
        r0 = r0 + 1;
        goto L9
    L14:
        if (this.mStrict == true) goto L22;
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

    public void appendWhere(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mWhereClause != null) goto L6;
        this.mWhereClause = new StringBuilder(r4.length() + 16);
    L6:
        if (this.mWhereClause.length() != 0) goto L8;
        this.mWhereClause.append('(');
    L8:
        this.mWhereClause.append(r4);
    }

    public void appendWhereEscapeString(String r3) {
        if (this.mWhereClause != null) goto L6;
        this.mWhereClause = new StringBuilder(r3.length() + 16);
    L6:
        if (this.mWhereClause.length() != 0) goto L8;
        this.mWhereClause.append('(');
    L8:
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, r3);
    }

    public String buildQuery(String[] r9, String r10, String r11, String r12, String r13, String r14) {
        String[] r2 = computeProjection(r9);
        StringBuilder r15 = new StringBuilder();
        StringBuilder r0 = this.mWhereClause;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        r15.append(this.mWhereClause.toString());
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
        return buildQueryString(this.mDistinct, this.mTables, r2, r15.toString(), r11, r12, r13, r14);
    L5:
        if (r0.length() <= 0) goto L7;
        r1 = true;
        goto L9
    }

    @Deprecated
    public String buildQuery(String[] r8, String r9, String[] r10, String r11, String r12, String r13, String r14) {
        return buildQuery(r8, r9, r11, r12, r13, r14);
    }

    public String buildUnionQuery(String[] r5, String r6, String r7) {
        StringBuilder r0 = new StringBuilder(128);
        int r1 = r5.length;
        if (this.mDistinct == false) goto L5;
        String r4 = " UNION ";
    L6:
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L11;
        if (r2 <= 0) goto L10;
        r0.append(r4);
    L10:
        r0.append(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L11:
        appendClause(r0, " ORDER BY ", r6);
        appendClause(r0, " LIMIT ", r7);
        return r0.toString();
    L5:
        r4 = " UNION ALL ";
        goto L6
    }

    public String buildUnionSubQuery(String r12, String[] r13, Set<String> r14, int r15, String r16, String r17, String r18, String r19) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin");
        int r3 = r13.length;
        String[] r5 = new String[r3];
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L16;
        String r6 = r13[r4];
        if (r6.equals(r12) == false) goto L8;
        r5[r4] = "'" + r16 + "' AS " + r12;
    L14:
        r4 = r4 + 1;
        goto L3
    L8:
        if (r4 > r15) goto L10;
    L13:
        r5[r4] = r6;
        goto L14
    L10:
        if (r2.contains(r6) == true) goto L13;
        r5[r4] = "NULL AS " + r6;
        goto L14
    L16:
        return buildQuery(r5, r17, r18, r19, null, null);
    }

    @Deprecated
    public String buildUnionSubQuery(String r11, String[] r12, Set<String> r13, int r14, String r15, String r16, String[] r17, String r18, String r19) {
        return buildUnionSubQuery(r11, r12, (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.memorydata.plugin"), r14, r15, r16, r18, r19);
    }

    public String getTables() {
        return this.mTables;
    }

    public Cursor query(SQLiteDatabase r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17) {
        return query(r11, r12, r13, r14, r15, r16, r17, null, null);
    }

    public Cursor query(SQLiteDatabase r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17, String r18) {
        return query(r11, r12, r13, r14, r15, r16, r17, r18, null);
    }

    public Cursor query(SQLiteDatabase r12, String[] r13, String r14, String[] r15, String r16, String r17, String r18, String r19, CancellationSignal r20) {
        if (this.mTables != null) goto L7;
        return null;
    L7:
        if (this.mStrict == false) goto L13;
        if (r14 == null) goto L13;
        if (r14.length() <= 0) goto L13;
        r12.validateSql(buildQuery(r13, "(" + r14 + ")", r16, r17, r18, r19), r20);
    L13:
        String r3 = buildQuery(r13, r14, r16, r17, r18, r19);
        if (Log.isLoggable(TAG, 3) == false) goto L17;
        Log.d(TAG, "Performing query: " + r3);
    L17:
        return r12.rawQueryWithFactory(this.mFactory, r3, r15, SQLiteDatabase.findEditTable(this.mTables), r20);
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory r3) {
        this.mFactory = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin");
    }

    public void setDistinct(boolean r1) {
        this.mDistinct = r1;
    }

    public void setProjectionMap(Map<String, String> r3) {
        this.mProjectionMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void setStrict(boolean r1) {
        this.mStrict = r1;
    }

    public void setTables(String r1) {
        this.mTables = r1;
    }
}
