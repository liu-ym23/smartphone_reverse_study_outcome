package cv;

import ai.j0;
import com.google.common.reflect.w;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import dv.f;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends bv.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f16510q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f16511r = null;
    public static final Pattern s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f16512t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f16513u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final HashMap f16514v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f16515w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f16516x = null;

    static {
        InputStream r5 = null;
        r5 = b.class.getClassLoader().getResourceAsStream("sqlite-jdbc.properties");     // Catch: Throwable -> L8 Exception -> L12
        if (r5 == null) goto L11;
        Properties r10 = new Properties();     // Catch: Throwable -> L8 Exception -> L12
        r10.load(r5);     // Catch: Throwable -> L8 Exception -> L12
        f16510q = r10.getProperty("name");     // Catch: Throwable -> L8 Exception -> L12
        f16511r = r10.getProperty("version");     // Catch: Throwable -> L8 Exception -> L12
    L26:
        r5.close();     // Catch: Exception -> L20
    L15:
        s = Pattern.compile(".*(INT|BOOL).*");
        f16512t = Pattern.compile(".*(CHAR|CLOB|TEXT|BLOB).*");
        f16513u = Pattern.compile(".*(REAL|FLOA|DOUB|DEC|NUM).*");
        HashMap r11 = new HashMap();
        f16514v = r11;
        androidx.room.jarjarred.org.antlr.runtime.a.z(3, r11, "NO ACTION", 0, "CASCADE");
        androidx.room.jarjarred.org.antlr.runtime.a.z(1, r11, "RESTRICT", 2, "SET NULL");
        r11.put("SET DEFAULT", 4);
        f16515w = Pattern.compile(".*PRIMARY\\s+KEY\\s*\\((.*?)\\).*", 34);
        f16516x = Pattern.compile(".*CONSTRAINT\\s*(.*?)\\s*PRIMARY\\s+KEY\\s*\\((.*?)\\).*", 34);
        return;
    L11:
        throw new IOException("Cannot load sqlite-jdbc.properties from jar");     // Catch: Throwable -> L8 Exception -> L12
    L12:
        f16510q = "SQLite JDBC";     // Catch: Throwable -> L8
        f16511r = "3.0.0-UNKNOWN";     // Catch: Throwable -> L8
        if (0 == 0) goto L15;
    L8:
        th = move-exception;
        if (0 != 0) goto L23;
    L19:
        throw th;
    L23:
        r5.close();     // Catch: Exception -> L21
        goto L19
    }

    public static void c(StringBuilder r5) {
        r5.append("select -1 as ks, '' as ptn, '' as fcn, '' as pcn, ");
        r5.append(3);
        r5.append(" as ur, ");
        r5.append(3);
        androidx.constraintlayout.motion.widget.a.C(r5, " as dr, ", " '' as fkn, ", " '' as pkn ", ") limit 0;");
    }

    public static String d(String r5) {
        if (r5 != null) goto L4;
        return r5;
    L4:
        String r10 = r5.trim();
        if (r10.length() > 2) goto L7;
        return r10;
    L7:
        if (r10.startsWith("`") == false) goto L11;
        if (r10.endsWith("`") == false) goto L11;
    L19:
        return androidx.constraintlayout.motion.widget.a.n(r10, 1, 1);
    L11:
        if (r10.startsWith("\"") == false) goto L15;
        if (r10.endsWith("\"") == true) goto L19;
    L15:
        if (r10.startsWith("[") == true) goto L17;
        return r10;
    L17:
        if (r10.endsWith("]") == true) goto L19;
        return r10;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean allProceduresAreCallable() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean allTablesAreSelectable() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean dataDefinitionCausesTransactionCommit() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean dataDefinitionIgnoredInTransactions() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean deletesAreDetected(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean doesMaxRowSizeIncludeBlobs() {
        return false;
    }

    public final void finalize() {
        close();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getAttributes(String r5, String r10, String r11, String r12) {
        if (this.f1007l != null) goto L6;
        this.f1007l = this.f1000a.prepareStatement("select null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as ATTR_NAME, null as DATA_TYPE, null as ATTR_TYPE_NAME, null as ATTR_SIZE, null as DECIMAL_DIGITS, null as NUM_PREC_RADIX, null as NULLABLE, null as REMARKS, null as ATTR_DEF, null as SQL_DATA_TYPE, null as SQL_DATETIME_SUB, null as CHAR_OCTET_LENGTH, null as ORDINAL_POSITION, null as IS_NULLABLE, null as SCOPE_CATALOG, null as SCOPE_SCHEMA, null as SCOPE_TABLE, null as SOURCE_DATA_TYPE limit 0;");
    L6:
        return this.f1007l.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getBestRowIdentifier(String r5, String r10, String r11, int r12, boolean r13) {
        if (this.f1008m != null) goto L6;
        this.f1008m = this.f1000a.prepareStatement("select null as SCOPE, null as COLUMN_NAME, null as DATA_TYPE, null as TYPE_NAME, null as COLUMN_SIZE, null as BUFFER_LENGTH, null as DECIMAL_DIGITS, null as PSEUDO_COLUMN limit 0;");
    L6:
        return this.f1008m.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final String getCatalogSeparator() {
        return ".";
    }

    @Override // java.sql.DatabaseMetaData
    public final String getCatalogTerm() {
        return "catalog";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getCatalogs() {
        if (this.d != null) goto L6;
        this.d = this.f1000a.prepareStatement("select null as TABLE_CAT limit 0;");
    L6:
        return this.d.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getColumnPrivileges(String r5, String r10, String r11, String r12) {
        if (this.f1010o != null) goto L6;
        this.f1010o = this.f1000a.prepareStatement("select null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as COLUMN_NAME, null as GRANTOR, null as GRANTEE, null as PRIVILEGE, null as IS_GRANTABLE limit 0;");
    L6:
        return this.f1010o.executeQuery();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    @Override // java.sql.DatabaseMetaData
    public final ResultSet getColumns(String r19, String r20, String r21, String r22) {
        if (this.f1000a == null) goto L108;
        ?? r5 = androidx.constraintlayout.motion.widget.a.x(700, "select null as TABLE_CAT, null as TABLE_SCHEM, tblname as TABLE_NAME, cn as COLUMN_NAME, ct as DATA_TYPE, tn as TYPE_NAME, 2000000000 as COLUMN_SIZE, 2000000000 as BUFFER_LENGTH, 10   as DECIMAL_DIGITS, 10   as NUM_PREC_RADIX, colnullable as NULLABLE, null as REMARKS, colDefault as COLUMN_DEF, 0    as SQL_DATA_TYPE, 0    as SQL_DATETIME_SUB, 2000000000 as CHAR_OCTET_LENGTH, ordpos as ORDINAL_POSITION, (case colnullable when 0 then 'NO' when 1 then 'YES' else '' end)    as IS_NULLABLE, null as SCOPE_CATLOG, null as SCOPE_SCHEMA, null as SCOPE_TABLE, null as SOURCE_DATA_TYPE, (case colautoincrement when 0 then 'NO' when 1 then 'YES' else '' end) as IS_AUTOINCREMENT, '' as IS_GENERATEDCOLUMN from (");
        ResultSet r10 = getTables(r19, r20, r21, new String[]{"TABLE", "VIEW"});     // Catch: Throwable -> L99
        boolean r11 = false;
    L125:
    L17:
        th = move-exception;
        Throwable r12 = th;
        ResultSet r13 = r10;
    L101:
        if (r13 == null) goto L152;
        r13.close();     // Catch: Exception -> L104
        throw r12;
    L104:
        e = move-exception;
        e.printStackTrace();
        throw r12;
    L152:
        throw r12;
    L8:
        if (r10.next() == false) goto L115;
        int r14 = 3;
        String r15 = r10.getString(3);     // Catch: Throwable -> L17
        Statement r16 = this.f1000a.createStatement();     // Catch: Throwable -> L17
        r16 = this.f1000a.createStatement();     // Catch: Throwable -> L75
        ResultSet r17 = r16.executeQuery("SELECT LIKE('%autoincrement%', LOWER(sql)) FROM sqlite_master WHERE LOWER(name) = LOWER('" + bv.a.a(r15) + "') AND TYPE IN ('table', 'view')");     // Catch: Throwable -> L75
        r17.next();     // Catch: Throwable -> L73
        if (r17.getInt(1) != 1) goto L14;
        boolean r18 = true;
    L113:
        r17.close();     // Catch: Throwable -> L17 Exception -> L19
    L136:
        r16.close();     // Catch: Throwable -> L17 Exception -> L24
    L27:
        Statement r110 = this.f1000a.createStatement();     // Catch: Throwable -> L17
        ResultSet r111 = r110.executeQuery("PRAGMA table_info('" + bv.a.a(r15) + "')");     // Catch: Throwable -> L66
        int r23 = 0;
    L130:
        if (r111.next() == false) goto L121;
        String r112 = r111.getString(2);     // Catch: Throwable -> L35
        String r113 = r111.getString(r14);     // Catch: Throwable -> L35
        String r24 = r111.getString(4);     // Catch: Throwable -> L35
        String r25 = r111.getString(5);     // Catch: Throwable -> L35
        int r114 = 6;
        boolean r26 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.equals(r111.getString(6));     // Catch: Throwable -> L35
        if (r24 == null) goto L37;
        ?? r27 = r24.equals("0");     // Catch: Throwable -> L35
    L38:
        if (r11 == false) goto L40;
        r5.append(" union all ");     // Catch: Throwable -> L35
    L40:
        if (r113 != null) goto L42;
        String r28 = "TEXT";
    L43:
        if (r26 == false) goto L46;
        if (r18 == false) goto L46;
        int r29 = 1;
    L48:
        if (s.matcher(r28).find() == false) goto L51;
        r114 = 4;
    L55:
        r5.append("select ");     // Catch: Throwable -> L35
        r23 = r23 + 1;     // Catch: Throwable -> L35
        r5.append(r23);     // Catch: Throwable -> L35
        r5.append(" as ordpos, ");     // Catch: Throwable -> L35
        r5.append(r27);     // Catch: Throwable -> L35
        r5.append(" as colnullable,");     // Catch: Throwable -> L35
        r5.append("'");     // Catch: Throwable -> L35
        r5.append(r114);     // Catch: Throwable -> L35
        r5.append("' as ct, ");     // Catch: Throwable -> L35
        r5.append("'");     // Catch: Throwable -> L35
        r5.append(r15);     // Catch: Throwable -> L35
        r5.append("' as tblname, ");     // Catch: Throwable -> L35
        r5.append("'");     // Catch: Throwable -> L35
        r5.append(bv.a.a(r112));     // Catch: Throwable -> L35
        r5.append("' as cn, ");     // Catch: Throwable -> L35
        r5.append("'");     // Catch: Throwable -> L35
        r5.append(bv.a.a(r28));     // Catch: Throwable -> L35
        r5.append("' as tn, ");     // Catch: Throwable -> L35
        if (r25 != null) goto L58;
        String r30 = null;
    L59:
        r5.append(bv.a.b(r30));     // Catch: Throwable -> L35
        r5.append(" as colDefault,");     // Catch: Throwable -> L35
        r5.append(r29);     // Catch: Throwable -> L35
        r5.append(" as colautoincrement");     // Catch: Throwable -> L35
        if (r22 == null) goto L62;
        r5.append(" where upper(cn) like upper('");     // Catch: Throwable -> L35
        r5.append(bv.a.a(r22));     // Catch: Throwable -> L35
        r5.append("')");     // Catch: Throwable -> L35
    L62:
        r11 = true;
        r14 = 3;
        goto L130
    L58:
        r30 = bv.a.a(r25);     // Catch: Throwable -> L35
        goto L59
    L51:
        if (f16512t.matcher(r28).find() == false) goto L54;
    L52:
        r114 = 12;
        goto L55
    L54:
        if (f16513u.matcher(r28).find() == false) goto L52;
    L46:
        r29 = 0;
        goto L48
    L42:
        r28 = r113.toUpperCase();     // Catch: Throwable -> L35
        goto L43
    L37:
        r27 = 2;
        goto L38
    L121:
        r111.close();     // Catch: Throwable -> L17 SQLException -> L110
    L142:
        r110.close();     // Catch: SQLException -> L109 Throwable -> L17
    L35:
        th = th;
        ResultSet r31 = r111;
    L68:
        if (r31 != null) goto L134;
    L70:
        if (r110 == null) goto L148;
        r110.close();     // Catch: Throwable -> L17 SQLException -> L112
        throw th;     // Catch: Throwable -> L17
    L149:
        throw th;     // Catch: Throwable -> L17
    L148:
        throw th;     // Catch: Throwable -> L17
    L134:
        r31.close();     // Catch: Throwable -> L17 SQLException -> L111
    L66:
        th = th;
        r31 = null;
        goto L68
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        goto L136
    L14:
        r18 = false;
    L73:
        th = move-exception;
        Throwable r32 = th;
        ResultSet r33 = r17;
    L77:
        if (r33 != null) goto L126;
    L83:
        if (r16 == null) goto L150;
        r16.close();     // Catch: Throwable -> L17 Exception -> L86
    L151:
        throw r32;     // Catch: Throwable -> L17
    L86:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        throw r32;     // Catch: Throwable -> L17
    L150:
        throw r32;     // Catch: Throwable -> L17
    L126:
        r33.close();     // Catch: Throwable -> L17 Exception -> L80
    L80:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L75:
        th = move-exception;
        r32 = th;
        r33 = null;
        goto L77
    L115:
        r10.close();     // Catch: Exception -> L92
    L94:
        if (r11 == false) goto L96;
        r5.append(") order by TABLE_SCHEM, TABLE_NAME, ORDINAL_POSITION;");
    L98:
        return ((f) this.f1000a.createStatement()).e(r5.toString());
    L96:
        r5.append("select null as ordpos, null as colnullable, null as ct, null as tblname, null as cn, null as tn, null as colDefault, null as colautoincrement) limit 0;");
    L92:
        e = move-exception;
        e.printStackTrace();
    L99:
        th = move-exception;
        r12 = th;
        r13 = null;
        goto L101
    L108:
        throw new SQLException("connection closed");
    }

    @Override // java.sql.DatabaseMetaData
    public final Connection getConnection() {
        return this.f1000a;
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getCrossReference(String r5, String r10, String r11, String r12, String r13, String r14) {
        if (r11 == null) goto L4;
        if (r14 != null) goto L9;
        return getImportedKeys(r5, r10, r11);
    L9:
        return ((f) this.f1000a.createStatement()).e("select " + bv.a.b(r5) + " as PKTABLE_CAT, " + bv.a.b(r10) + " as PKTABLE_SCHEM, " + bv.a.b(r11) + " as PKTABLE_NAME, '' as PKCOLUMN_NAME, " + bv.a.b(r12) + " as FKTABLE_CAT, " + bv.a.b(r13) + " as FKTABLE_SCHEM, " + bv.a.b(r14) + " as FKTABLE_NAME, '' as FKCOLUMN_NAME, -1 as KEY_SEQ, 3 as UPDATE_RULE, 3 as DELETE_RULE, '' as FK_NAME, '' as PK_NAME, " + Integer.toString(5) + " as DEFERRABILITY limit 0 ");
    L4:
        return getExportedKeys(r12, r13, r14);
    }

    @Override // java.sql.DatabaseMetaData
    public final int getDatabaseMajorVersion() {
        return Integer.valueOf(this.f1000a.m().split("\\.")[0]).intValue();
    }

    @Override // java.sql.DatabaseMetaData
    public final int getDatabaseMinorVersion() {
        return Integer.valueOf(this.f1000a.m().split("\\.")[1]).intValue();
    }

    @Override // java.sql.DatabaseMetaData
    public final String getDatabaseProductName() {
        return "SQLite";
    }

    @Override // java.sql.DatabaseMetaData
    public final String getDatabaseProductVersion() {
        return this.f1000a.m();
    }

    @Override // java.sql.DatabaseMetaData
    public final int getDefaultTransactionIsolation() {
        return 8;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getDriverMajorVersion() {
        return Integer.valueOf(f16511r.split("\\.")[0]).intValue();
    }

    @Override // java.sql.DatabaseMetaData
    public final int getDriverMinorVersion() {
        return Integer.valueOf(f16511r.split("\\.")[1]).intValue();
    }

    @Override // java.sql.DatabaseMetaData
    public final String getDriverName() {
        return f16510q;
    }

    @Override // java.sql.DatabaseMetaData
    public final String getDriverVersion() {
        return f16511r;
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getExportedKeys(String r21, String r22, String r23) {
        b r5 = this;
        w r10 = new w(r5, r23, 22);
        String[] r11 = (String[]) r10.f9377c;
        Statement r12 = r5.f1000a.createStatement();
        String r13 = null;
        if (r21 == null) goto L5;
        String r14 = bv.a.b(r21);
    L6:
        if (r22 == null) goto L8;
        String r15 = bv.a.b(r22);
    L9:
        StringBuilder r16 = new StringBuilder(512);
        if (r11 == null) goto L71;
        ResultSet r17 = r12.executeQuery("select name from sqlite_master where type = 'table'");
        ArrayList r18 = new ArrayList();
    L13:
        if (r17.next() == false) goto L17;
        String r19 = r17.getString(1);
        r18.add(r19);
        if (r19.equalsIgnoreCase(r23) == false) goto L13;
        r13 = r19;
        goto L13
    L17:
        r17.close();
        Iterator r20 = r18.iterator();
        int r110 = 0;
    L19:
        if (r20.hasNext() == false) goto L70;
        String r111 = (String) r20.next();
        Iterator r24 = ((ArrayList) new w(r5, r111, 21).f9377c).iterator();     // Catch: Throwable -> L51
    L23:
        if (r24.hasNext() == false) goto L65;
        a r112 = (a) r24.next();     // Catch: Throwable -> L51
        String r113 = r112.f16508b;     // Catch: Throwable -> L51
        if (r113 == null) goto L64;
        if (r113.equalsIgnoreCase(r13) == false) goto L64;
        int r114 = 0;
    L30:
        ArrayList r25 = r112.d;
        Iterator r26 = r20;
        if (r114 >= r25.size()) goto L62;
        int r27 = r114 + 1;     // Catch: Throwable -> L51
        String r115 = r13;
        String[] r28 = {(String) r25.get(r114), (String) r112.e.get(r114)};     // Catch: Throwable -> L51
        String r29 = r28[1];     // Catch: Throwable -> L51
        String r116 = "";
        if (r29 != null) goto L38;
        r29 = "";
    L38:
        String r30 = r28[0];     // Catch: Throwable -> L51
        if (r30 != null) goto L41;
        r30 = "";
    L41:
        Iterator r117 = r24;
        int r118 = 0;
    L43:
        if (r118 >= r11.length) goto L54;
        String r31 = r11[r118];     // Catch: Throwable -> L51
        if (r31 == null) goto L53;
        if (r31.equalsIgnoreCase(r29) == false) goto L53;
        String r32 = (String) r10.f9376b;     // Catch: Throwable -> L51
        if (r32 == null) goto L54;
        r116 = r32;
    L53:
        r118 = r118 + 1;     // Catch: Throwable -> L51
    L54:
        if (r110 <= 0) goto L56;
        String r33 = " union all select ";
    L57:
        r16.append(r33);     // Catch: Throwable -> L51
        r16.append(Integer.toString(r27));     // Catch: Throwable -> L51
        r16.append(" as ks, '");     // Catch: Throwable -> L51
        r16.append(bv.a.a(r111));     // Catch: Throwable -> L51
        r16.append("' as fkt, '");     // Catch: Throwable -> L51
        r16.append(bv.a.a(r30));     // Catch: Throwable -> L51
        r16.append("' as fcn, '");     // Catch: Throwable -> L51
        r16.append(bv.a.a(r29));     // Catch: Throwable -> L51
        r16.append("' as pcn, '");     // Catch: Throwable -> L51
        r16.append(bv.a.a(r116));     // Catch: Throwable -> L51
        r16.append("' as pkn, ");     // Catch: Throwable -> L51
        HashMap r34 = f16514v;     // Catch: Throwable -> L51
        r16.append(r34.get(r112.f));     // Catch: Throwable -> L51
        r16.append(" as ur, ");     // Catch: Throwable -> L51
        r16.append(r34.get(r112.g));     // Catch: Throwable -> L51
        r16.append(" as dr, ");     // Catch: Throwable -> L51
        String r35 = r112.f16507a;     // Catch: Throwable -> L51
        if (r35 == null) goto L60;
        r16.append("'");     // Catch: Throwable -> L51
        r16.append(bv.a.a(r35));     // Catch: Throwable -> L51
        r16.append("' as fkn");     // Catch: Throwable -> L51
    L61:
        r110 = r110 + 1;
        r114 = r27;
        r13 = r115;
        r24 = r117;
        r20 = r26;
        goto L30
    L60:
        r16.append("'' as fkn");     // Catch: Throwable -> L51
        goto L61
    L56:
        r33 = "select ";
        goto L57
    L62:
        r20 = r26;
    L64:
        r20 = r20;
        r13 = r13;
        r24 = r24;
        goto L23
    L65:
        Iterator r210 = r20;
        String r119 = r13;
        r17.close();     // Catch: SQLException -> L111
    L67:
        r5 = this;
        r20 = r210;
        r13 = r119;
    L51:
        th = move-exception;
        r17.close();     // Catch: SQLException -> L112
    L69:
        throw th;
    L70:
        boolean r120 = false;
    L72:
        if (r110 <= 0) goto L74;
        boolean r121 = true;
    L75:
        StringBuilder r36 = new StringBuilder(512);
        r36.append("select ");
        r36.append(r14);
        r36.append(" as PKTABLE_CAT, ");
        r36.append(r15);
        r36.append(" as PKTABLE_SCHEM, ");
        r36.append(bv.a.b(r13));
        r36.append(" as PKTABLE_NAME, ");
        String r37 = "''";
        if (r121 == false) goto L78;
        String r38 = "pcn";
    L79:
        androidx.constraintlayout.motion.widget.a.C(r36, r38, " as PKCOLUMN_NAME, ", r14, " as FKTABLE_CAT, ");
        r36.append(r15);
        r36.append(" as FKTABLE_SCHEM, ");
        if (r121 == false) goto L82;
        String r39 = "fkt";
    L83:
        r36.append(r39);
        r36.append(" as FKTABLE_NAME, ");
        if (r121 == false) goto L86;
        String r40 = "fcn";
    L87:
        r36.append(r40);
        r36.append(" as FKCOLUMN_NAME, ");
        if (r121 == false) goto L90;
        String r41 = "ks";
    L91:
        r36.append(r41);
        r36.append(" as KEY_SEQ, ");
        String r42 = "3";
        if (r121 == false) goto L94;
        String r43 = "ur";
    L95:
        r36.append(r43);
        r36.append(" as UPDATE_RULE, ");
        if (r121 == false) goto L98;
        r42 = "dr";
    L98:
        r36.append(r42);
        r36.append(" as DELETE_RULE, ");
        if (r121 == false) goto L101;
        String r44 = "fkn";
    L102:
        r36.append(r44);
        r36.append(" as FK_NAME, ");
        if (r121 == false) goto L105;
        r37 = "pkn";
    L105:
        r36.append(r37);
        r36.append(" as PK_NAME, ");
        r36.append(Integer.toString(5));
        r36.append(" as DEFERRABILITY ");
        if (r121 == false) goto L108;
        r36.append("from (");
        r36.append(r16);
        r36.append(") ORDER BY FKTABLE_CAT, FKTABLE_SCHEM, FKTABLE_NAME, KEY_SEQ");
    L110:
        return ((f) r12).e(r36.toString());
    L108:
        r36.append("limit 0");
        goto L110
    L101:
        r44 = "''";
        goto L102
    L94:
        r43 = "3";
        goto L95
    L90:
        r41 = "-1";
        goto L91
    L86:
        r40 = "''";
        goto L87
    L82:
        r39 = "''";
        goto L83
    L78:
        r38 = "''";
        goto L79
    L74:
        r121 = r120;
        goto L75
    L71:
        r120 = false;
        r110 = 0;
        goto L72
    L8:
        r15 = null;
        goto L9
    L5:
        r14 = null;
        goto L6
    }

    @Override // java.sql.DatabaseMetaData
    public final String getExtraNameCharacters() {
        return "";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getFunctionColumns(String r5, String r10, String r11, String r12) {
        throw new SQLException("Not yet implemented by SQLite JDBC driver");
    }

    @Override // java.sql.DatabaseMetaData
    public final String getIdentifierQuoteString() {
        return "\"";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getImportedKeys(String r17, String r18, String r19) {
        Statement r5 = this.f1000a.createStatement();
        StringBuilder r10 = androidx.constraintlayout.motion.widget.a.x(700, "select ");
        r10.append(bv.a.b(r17));
        r10.append(" as PKTABLE_CAT, ");
        r10.append(bv.a.b(r18));
        r10.append(" as PKTABLE_SCHEM, ptn as PKTABLE_NAME, pcn as PKCOLUMN_NAME, ");
        r10.append(bv.a.b(r17));
        r10.append(" as FKTABLE_CAT, ");
        r10.append(bv.a.b(r18));
        r10.append(" as FKTABLE_SCHEM, ");
        r10.append(bv.a.b(r19));
        r10.append(" as FKTABLE_NAME, fcn as FKCOLUMN_NAME, ks as KEY_SEQ, ur as UPDATE_RULE, dr as DELETE_RULE, fkn as FK_NAME, pkn as PK_NAME, ");
        int r11 = 5;
        r10.append(Integer.toString(5));
        r10.append(" as DEFERRABILITY from (");
        ResultSet r12 = r5.executeQuery("pragma foreign_key_list('" + bv.a.a(r19) + "');");     // Catch: SQLException -> L31
        ArrayList r13 = (ArrayList) new w(this, r19, 21).f9377c;
        char r14 = 0;
        int r15 = 0;
    L6:
        if (r12.next() == false) goto L26;
        int r16 = r12.getInt(2) + 1;
        int r110 = r12.getInt(1);
        String r111 = r12.getString(3);
        String r112 = r12.getString(4);
        String r113 = r12.getString(r11);
        w r114 = new w(this, r111, 22);
        String r115 = (String) r114.f9376b;
        if (r113 != null) goto L10;
        r113 = ((String[]) r114.f9377c)[r14];
    L10:
        String r116 = r12.getString(6);
        String r20 = r12.getString(7);
        if (r15 <= 0) goto L14;
        r10.append(" union all ");
    L14:
        if (r13.size() <= r110) goto L16;
        String r21 = ((a) r13.get(r110)).f16507a;
    L17:
        r10.append("select ");
        r10.append(r16);
        r10.append(" as ks,'");
        r10.append(bv.a.a(r111));
        r10.append("' as ptn, '");
        r10.append(bv.a.a(r112));
        r10.append("' as fcn, '");
        r10.append(bv.a.a(r113));
        r10.append("' as pcn,case '");
        r10.append(bv.a.a(r116));
        r10.append("' when 'NO ACTION' then 3 when 'CASCADE' then 0 when 'RESTRICT' then 1 when 'SET NULL' then 2 when 'SET DEFAULT' then 4 end as ur, case '");
        r10.append(bv.a.a(r20));
        r10.append("' when 'NO ACTION' then 3 when 'CASCADE' then 0 when 'RESTRICT' then 1 when 'SET NULL' then 2 when 'SET DEFAULT' then 4 end as dr, ");
        String r22 = "''";
        if (r21 != null) goto L20;
        String r23 = "''";
    L21:
        r10.append(r23);
        r10.append(" as fkn, ");
        if (r115 == null) goto L25;
        r22 = bv.a.b(r115);
    L25:
        r10.append(r22);
        r10.append(" as pkn");
        r15 = r15 + 1;
        r11 = 5;
        r14 = 0;
        goto L6
    L20:
        r23 = bv.a.b(r21);
        goto L21
    L16:
        r21 = null;
        goto L17
    L26:
        r12.close();
        if (r15 != 0) goto L29;
        c(r10);
    L29:
        r10.append(") ORDER BY PKTABLE_CAT, PKTABLE_SCHEM, PKTABLE_NAME, KEY_SEQ;");
        return ((f) r5).e(r10.toString());
    L31:
        c(r10);
        return ((f) r5).e(r10.toString());
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getIndexInfo(String r10, String r11, String r12, boolean r13, boolean r14) {
        Statement r15 = this.f1000a.createStatement();
        StringBuilder r16 = androidx.constraintlayout.motion.widget.a.x(500, "select null as TABLE_CAT, null as TABLE_SCHEM, '");
        r16.append(bv.a.a(r12));
        r16.append("' as TABLE_NAME, un as NON_UNIQUE, null as INDEX_QUALIFIER, n as INDEX_NAME, ");
        r16.append(Integer.toString(3));
        r16.append(" as TYPE, op as ORDINAL_POSITION, cn as COLUMN_NAME, null as ASC_OR_DESC, 0 as CARDINALITY, 0 as PAGES, null as FILTER_CONDITION from (");
        ResultSet r17 = r15.executeQuery("pragma index_list('" + bv.a.a(r12) + "');");
        ArrayList r18 = new ArrayList();
    L4:
        if (r17.next() == false) goto L6;
        r18.add(new ArrayList());
        ((ArrayList) r18.get(r18.size() - 1)).add(r17.getString(2));
        ((ArrayList) r18.get(r18.size() - 1)).add(Integer.valueOf(r17.getInt(3)));
        goto L4
    L6:
        r17.close();
        if (r18.size() != 0) goto L10;
        r16.append("select null as un, null as n, null as op, null as cn) limit 0;");
        return ((f) r15).e(r16.toString());
    L10:
        Iterator r19 = r18.iterator();
        ArrayList r110 = new ArrayList();
    L12:
        if (r19.hasNext() == false) goto L22;
        ArrayList r5 = (ArrayList) r19.next();
        String r20 = r5.get(0).toString();
        ResultSet r21 = r15.executeQuery("pragma index_info('" + bv.a.a(r20) + "');");
    L15:
        if (r21.next() == false) goto L21;
        StringBuilder r22 = new StringBuilder("select ");
        String r23 = r21.getString(3);
        r22.append(Integer.toString(1 - ((Integer) r5.get(1)).intValue()));
        r22.append(" as un,'");
        r22.append(bv.a.a(r20));
        r22.append("' as n,");
        r22.append(Integer.toString(r21.getInt(1) + 1));
        r22.append(" as op,");
        if (r23 != null) goto L19;
        r22.append("null");
    L20:
        r22.append(" as cn");
        r110.add(r22.toString());
        goto L15
    L19:
        r22.append("'");
        r22.append(bv.a.a(r23));
        r22.append("'");
        goto L20
    L21:
        r21.close();
        goto L12
    L22:
        r16.append(f4.b.m(r110, " union all "));
        r16.append(");");
        return ((f) r15).e(r16.toString());
    }

    @Override // java.sql.DatabaseMetaData
    public final int getJDBCMajorVersion() {
        return 2;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getJDBCMinorVersion() {
        return 1;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxBinaryLiteralLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxCatalogNameLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxCharLiteralLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxColumnNameLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxColumnsInGroupBy() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxColumnsInIndex() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxColumnsInOrderBy() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxColumnsInSelect() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxColumnsInTable() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxConnections() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxCursorNameLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxIndexLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxProcedureNameLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxRowSize() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxSchemaNameLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxStatementLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxStatements() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxTableNameLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxTablesInSelect() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final int getMaxUserNameLength() {
        return 0;
    }

    @Override // java.sql.DatabaseMetaData
    public final String getNumericFunctions() {
        return "";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getPrimaryKeys(String r5, String r10, String r11) {
        w r12 = new w(this, r11, 22);
        String[] r13 = (String[]) r12.f9377c;
        Statement r14 = this.f1000a.createStatement();
        StringBuilder r15 = androidx.constraintlayout.motion.widget.a.x(512, "select null as TABLE_CAT, null as TABLE_SCHEM, '");
        r15.append(bv.a.a(r11));
        r15.append("' as TABLE_NAME, cn as COLUMN_NAME, ks as KEY_SEQ, pk as PK_NAME from (");
        if (r13 != null) goto L6;
        r15.append("select null as cn, null as pk, 0 as ks) limit 0;");
        return ((f) r14).e(r15.toString());
    L6:
        String r16 = (String) r12.f9376b;
        if (r16 == null) goto L9;
        r16 = j0.k("'", r16, "'");
    L9:
        int r17 = 0;
    L11:
        if (r17 >= r13.length) goto L15;
        if (r17 <= 0) goto L14;
        r15.append(" union ");
    L14:
        r15.append("select ");
        r15.append(r16);
        r15.append(" as pk, '");
        r15.append(bv.a.a(d(r13[r17])));
        r15.append("' as cn, ");
        r17 = r17 + 1;
        r15.append(r17);
        r15.append(" as ks");
        goto L11
    L15:
        r15.append(") order by cn;");
        return ((f) r14).e(r15.toString());
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getProcedureColumns(String r5, String r10, String r11, String r12) {
        if (this.f1006k != null) goto L6;
        this.f1006k = this.f1000a.prepareStatement("select null as PROCEDURE_CAT, null as PROCEDURE_SCHEM, null as PROCEDURE_NAME, null as COLUMN_NAME, null as COLUMN_TYPE, null as DATA_TYPE, null as TYPE_NAME, null as PRECISION, null as LENGTH, null as SCALE, null as RADIX, null as NULLABLE, null as REMARKS limit 0;");
    L6:
        return this.f1006k.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final String getProcedureTerm() {
        return "not_implemented";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getProcedures(String r5, String r10, String r11) {
        if (this.f1005j != null) goto L6;
        this.f1005j = this.f1000a.prepareStatement("select null as PROCEDURE_CAT, null as PROCEDURE_SCHEM, null as PROCEDURE_NAME, null as UNDEF1, null as UNDEF2, null as UNDEF3, null as REMARKS, null as PROCEDURE_TYPE limit 0;");
    L6:
        return this.f1005j.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final int getResultSetHoldability() {
        return 2;
    }

    @Override // java.sql.DatabaseMetaData
    public final String getSQLKeywords() {
        return "ABORT,ACTION,AFTER,ANALYZE,ATTACH,AUTOINCREMENT,BEFORE,CASCADE,CONFLICT,DATABASE,DEFERRABLE,DEFERRED,DESC,DETACH,EXCLUSIVE,EXPLAIN,FAIL,GLOB,IGNORE,INDEX,INDEXED,INITIALLY,INSTEAD,ISNULL,KEY,LIMIT,NOTNULL,OFFSET,PLAN,PRAGMA,QUERY,RAISE,REGEXP,REINDEX,RENAME,REPLACE,RESTRICT,TEMP,TEMPORARY,TRANSACTION,VACUUM,VIEW,VIRTUAL";
    }

    @Override // java.sql.DatabaseMetaData
    public final int getSQLStateType() {
        return 2;
    }

    @Override // java.sql.DatabaseMetaData
    public final String getSchemaTerm() {
        return "schema";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getSchemas() {
        if (this.e != null) goto L6;
        this.e = this.f1000a.prepareStatement("select null as TABLE_SCHEM, null as TABLE_CATALOG limit 0;");
    L6:
        return this.e.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final String getSearchStringEscape() {
        return null;
    }

    @Override // java.sql.DatabaseMetaData
    public final String getStringFunctions() {
        return "";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getSuperTables(String r5, String r10, String r11) {
        if (this.f1003h != null) goto L6;
        this.f1003h = this.f1000a.prepareStatement("select null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as SUPERTABLE_NAME limit 0;");
    L6:
        return this.f1003h.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getSuperTypes(String r5, String r10, String r11) {
        if (this.g != null) goto L6;
        this.g = this.f1000a.prepareStatement("select null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME, null as SUPERTYPE_CAT, null as SUPERTYPE_SCHEM, null as SUPERTYPE_NAME limit 0;");
    L6:
        return this.g.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final String getSystemFunctions() {
        return "";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getTablePrivileges(String r5, String r10, String r11) {
        if (this.f1004i != null) goto L6;
        this.f1004i = this.f1000a.prepareStatement("select  null as TABLE_CAT, null as TABLE_SCHEM, null as TABLE_NAME, null as GRANTOR, null GRANTEE,  null as PRIVILEGE, null as IS_GRANTABLE limit 0;");
    L6:
        return this.f1004i.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getTableTypes() {
        dv.a r5 = this.f1000a;
        if (r5 == null) goto L10;
        if (this.f1001b != null) goto L7;
        this.f1001b = r5.prepareStatement("SELECT 'TABLE' AS TABLE_TYPE UNION SELECT 'VIEW' AS TABLE_TYPE UNION SELECT 'SYSTEM TABLE' AS TABLE_TYPE UNION SELECT 'GLOBAL TEMPORARY' AS TABLE_TYPE;");
    L7:
        this.f1001b.clearParameters();
        return this.f1001b.executeQuery();
    L10:
        throw new SQLException("connection closed");
    }

    @Override // java.sql.DatabaseMetaData
    public final synchronized ResultSet getTables(String r5, String r10, String r11, String[] r12) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f1000a == null) goto L27;
        if (r11 != null) goto L7;
    L12:
        String r13 = "%";
    L13:
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L10
        r14.append("SELECT");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NULL AS TABLE_CAT,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NULL AS TABLE_SCHEM,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NAME AS TABLE_NAME,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  TYPE AS TABLE_TYPE,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NULL AS REMARKS,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NULL AS TYPE_CAT,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NULL AS TYPE_SCHEM,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NULL AS TYPE_NAME,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NULL AS SELF_REFERENCING_COL_NAME,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  NULL AS REF_GENERATION");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("FROM");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  (");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    SELECT");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      NAME,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      UPPER(TYPE) AS TYPE");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    FROM");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      sqlite_master");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    WHERE");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      NAME NOT LIKE 'sqlite\\_%' ESCAPE '\\'");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      AND UPPER(TYPE) IN ('TABLE', 'VIEW')");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    UNION ALL");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    SELECT");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      NAME,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      'GLOBAL TEMPORARY' AS TYPE");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    FROM");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      sqlite_temp_master");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    UNION ALL");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    SELECT");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      NAME,");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      'SYSTEM TABLE' AS TYPE");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    FROM");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      sqlite_master");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("    WHERE");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("      NAME LIKE 'sqlite\\_%' ESCAPE '\\'");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append("  )");     // Catch: Throwable -> L10
        r14.append("\n");     // Catch: Throwable -> L10
        r14.append(" WHERE TABLE_NAME LIKE '");     // Catch: Throwable -> L10
        r14.append(r13);     // Catch: Throwable -> L10
        r14.append("' AND TABLE_TYPE IN (");     // Catch: Throwable -> L10
        if (r12 != null) goto L16;
    L22:
        r14.append("'TABLE','VIEW'");     // Catch: Throwable -> L10
    L23:
        r14.append(") ORDER BY TABLE_TYPE, TABLE_NAME;");     // Catch: Throwable -> L10
        ResultSet r15 = ((f) this.f1000a.createStatement()).e(r14.toString());     // Catch: Throwable -> L10
        monitor-exit(this);
        return r15;
    L16:
        if (r12.length == 0) goto L22;
        r14.append("'");     // Catch: Throwable -> L10
        r14.append(r12[0].toUpperCase());     // Catch: Throwable -> L10
        r14.append("'");     // Catch: Throwable -> L10
        int r16 = 1;
    L20:
        if (r16 >= r12.length) goto L23;
        r14.append(",'");     // Catch: Throwable -> L10
        r14.append(r12[r16].toUpperCase());     // Catch: Throwable -> L10
        r14.append("'");     // Catch: Throwable -> L10
        r16 = r16 + 1;     // Catch: Throwable -> L10
        goto L20
    L7:
        if ("".equals(r11) == true) goto L12;
        r13 = bv.a.a(r11);     // Catch: Throwable -> L10
        goto L13
    L27:
        throw new SQLException("connection closed");     // Catch: Throwable -> L10
    }

    @Override // java.sql.DatabaseMetaData
    public final String getTimeDateFunctions() {
        return "DATE,TIME,DATETIME,JULIANDAY,STRFTIME";
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getTypeInfo() {
        if (this.f1002c != null) goto L5;
        this.f1002c = this.f1000a.prepareStatement("select tn as TYPE_NAME, dt as DATA_TYPE, 0 as PRECISION, null as LITERAL_PREFIX, null as LITERAL_SUFFIX, null as CREATE_PARAMS, 1 as NULLABLE, 1 as CASE_SENSITIVE, 3 as SEARCHABLE, 0 as UNSIGNED_ATTRIBUTE, 0 as FIXED_PREC_SCALE, 0 as AUTO_INCREMENT, null as LOCAL_TYPE_NAME, 0 as MINIMUM_SCALE, 0 as MAXIMUM_SCALE, 0 as SQL_DATA_TYPE, 0 as SQL_DATETIME_SUB, 10 as NUM_PREC_RADIX from (    select 'BLOB' as tn, 2004 as dt union    select 'NULL' as tn, 0 as dt union    select 'REAL' as tn, 7 as dt union    select 'TEXT' as tn, 12 as dt union    select 'INTEGER' as tn, 4 as dt) order by TYPE_NAME;");
    L5:
        this.f1002c.clearParameters();
        return this.f1002c.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getUDTs(String r5, String r10, String r11, int[] r12) {
        if (this.f != null) goto L5;
        this.f = this.f1000a.prepareStatement("select  null as TYPE_CAT, null as TYPE_SCHEM, null as TYPE_NAME,  null as CLASS_NAME,  null as DATA_TYPE, null as REMARKS, null as BASE_TYPE limit 0;");
    L5:
        this.f.clearParameters();
        return this.f.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final String getURL() {
        return this.f1000a.f16711a.f1020a;
    }

    @Override // java.sql.DatabaseMetaData
    public final String getUserName() {
        return null;
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getVersionColumns(String r5, String r10, String r11) {
        if (this.f1009n != null) goto L6;
        this.f1009n = this.f1000a.prepareStatement("select null as SCOPE, null as COLUMN_NAME, null as DATA_TYPE, null as TYPE_NAME, null as COLUMN_SIZE, null as BUFFER_LENGTH, null as DECIMAL_DIGITS, null as PSEUDO_COLUMN limit 0;");
    L6:
        return this.f1009n.executeQuery();
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean insertsAreDetected(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean isCatalogAtStart() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean isReadOnly() {
        return this.f1000a.isReadOnly();
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean locatorsUpdateCopy() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean nullPlusNonNullIsNull() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean nullsAreSortedAtEnd() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean nullsAreSortedAtStart() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean nullsAreSortedHigh() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean nullsAreSortedLow() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean othersDeletesAreVisible(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean othersInsertsAreVisible(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean othersUpdatesAreVisible(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean ownDeletesAreVisible(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean ownInsertsAreVisible(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean ownUpdatesAreVisible(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean storesLowerCaseIdentifiers() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean storesLowerCaseQuotedIdentifiers() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean storesMixedCaseIdentifiers() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean storesMixedCaseQuotedIdentifiers() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean storesUpperCaseIdentifiers() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean storesUpperCaseQuotedIdentifiers() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsANSI92EntryLevelSQL() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsANSI92FullSQL() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsANSI92IntermediateSQL() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsAlterTableWithAddColumn() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsAlterTableWithDropColumn() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsBatchUpdates() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsCatalogsInDataManipulation() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsCatalogsInIndexDefinitions() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsCatalogsInPrivilegeDefinitions() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsCatalogsInProcedureCalls() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsCatalogsInTableDefinitions() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsColumnAliasing() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsConvert() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsCoreSQLGrammar() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsCorrelatedSubqueries() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsDataDefinitionAndDataManipulationTransactions() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsDataManipulationTransactionsOnly() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsDifferentTableCorrelationNames() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsExpressionsInOrderBy() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsExtendedSQLGrammar() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsFullOuterJoins() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsGetGeneratedKeys() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsGroupBy() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsGroupByBeyondSelect() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsGroupByUnrelated() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsIntegrityEnhancementFacility() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsLikeEscapeClause() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsLimitedOuterJoins() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsMinimumSQLGrammar() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsMixedCaseIdentifiers() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsMixedCaseQuotedIdentifiers() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsMultipleOpenResults() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsMultipleResultSets() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsMultipleTransactions() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsNamedParameters() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsNonNullableColumns() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsOpenCursorsAcrossCommit() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsOpenCursorsAcrossRollback() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsOpenStatementsAcrossCommit() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsOpenStatementsAcrossRollback() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsOrderByUnrelated() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsOuterJoins() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsPositionedDelete() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsPositionedUpdate() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsResultSetConcurrency(int r5, int r10) {
        if (r5 == 1003) goto L5;
    L7:
        return false;
    L5:
        if (r10 != 1007) goto L7;
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsResultSetHoldability(int r5) {
        if (r5 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsResultSetType(int r5) {
        if (r5 != 1003) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSavepoints() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSchemasInDataManipulation() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSchemasInIndexDefinitions() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSchemasInPrivilegeDefinitions() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSchemasInProcedureCalls() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSchemasInTableDefinitions() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSelectForUpdate() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsStatementPooling() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsStoredProcedures() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSubqueriesInComparisons() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSubqueriesInExists() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSubqueriesInIns() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsSubqueriesInQuantifieds() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsTableCorrelationNames() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsTransactionIsolationLevel(int r5) {
        if (r5 != 8) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsTransactions() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsUnion() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsUnionAll() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean updatesAreDetected(int r5) {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean usesLocalFilePerTable() {
        return false;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean usesLocalFiles() {
        return true;
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsConvert(int r5, int r10) {
        return false;
    }
}
