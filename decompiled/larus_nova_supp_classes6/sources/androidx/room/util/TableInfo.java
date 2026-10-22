package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    public static final class Column {
        public final int affinity;
        public final String defaultValue;
        private final int mCreatedFrom;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public int hashCode() {
            int r0 = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.primaryKeyPosition;
        L5:
            r1 = 1237;
            goto L7
        }

        public boolean isPrimaryKey() {
            if (this.primaryKeyPosition <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "Column{name='" + this.name + "', type='" + this.type + "', affinity='" + this.affinity + "', notNull=" + this.notNull + ", primaryKeyPosition=" + this.primaryKeyPosition + ", defaultValue='" + this.defaultValue + "'}";
        }

        private static boolean containsSurroundingParenthesis(String r6) {
            if (r6.length() != 0) goto L5;
            return false;
        L5:
            int r0 = 0;
            int r2 = 0;
        L7:
            if (r0 >= r6.length()) goto L22;
            char r3 = r6.charAt(r0);
            if (r0 != 0) goto L12;
            if (r3 == '(') goto L12;
            return false;
        L12:
            if (r3 != '(') goto L15;
            r2 = r2 + 1;
        L21:
            r0 = r0 + 1;
            goto L7
        L15:
            if (r3 != ')') goto L21;
            r2 = r2 - 1;
            if (r2 != 0) goto L21;
            if (r0 == (r6.length() - 1)) goto L21;
            return false;
        L22:
            if (r2 != 0) goto L32;
            return true;
        L32:
            return false;
        }

        private static int findAffinity(String r2) {
            if (r2 != null) goto L5;
            return 5;
        L5:
            String r3 = r2.toUpperCase(Locale.US);
            if (r3.contains("INT") == false) goto L10;
            return 3;
        L10:
            if (r3.contains("CHAR") == false) goto L12;
            return 2;
        L12:
            if (r3.contains("CLOB") == false) goto L14;
            return 2;
        L14:
            if (r3.contains("TEXT") == false) goto L17;
            return 2;
        L17:
            if (r3.contains("BLOB") == false) goto L20;
            return 5;
        L20:
            if (r3.contains("REAL") == false) goto L22;
            return 4;
        L22:
            if (r3.contains("FLOA") == false) goto L24;
            return 4;
        L24:
            if (r3.contains("DOUB") == true) goto L33;
            return 1;
        L33:
            return 4;
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof Column) == true) goto L8;
            return false;
        L8:
            Column r7 = (Column) r6;
            if (this.primaryKeyPosition == r7.primaryKeyPosition) goto L12;
            return false;
        L12:
            if (this.name.equals(r7.name) == true) goto L15;
            return false;
        L15:
            if (this.notNull == r7.notNull) goto L18;
            return false;
        L18:
            if (this.mCreatedFrom != 1) goto L27;
            if (r7.mCreatedFrom != 2) goto L27;
            String r1 = this.defaultValue;
            if (r1 == null) goto L27;
            if (defaultValueEquals(r1, r7.defaultValue) == true) goto L27;
            return false;
        L27:
            if (this.mCreatedFrom == 2) goto L29;
        L35:
            int r2 = this.mCreatedFrom;
            if (r2 == 0) goto L48;
            if (r2 != r7.mCreatedFrom) goto L48;
            String r3 = this.defaultValue;
            if (r3 == null) goto L45;
            if (defaultValueEquals(r3, r7.defaultValue) == true) goto L48;
        L46:
            return false;
        L45:
            if (r7.defaultValue != null) goto L46;
        L48:
            if (this.affinity == r7.affinity) goto L52;
            return false;
        L52:
            return true;
        L29:
            if (r7.mCreatedFrom != 1) goto L35;
            String r4 = r7.defaultValue;
            if (r4 == null) goto L35;
            if (defaultValueEquals(r4, this.defaultValue) == true) goto L35;
            return false;
        }

        public static boolean defaultValueEquals(String r3, String r4) {
            if (r4 != null) goto L6;
            return false;
        L6:
            if (r3.equals(r4) == false) goto L9;
            return true;
        L9:
            if (containsSurroundingParenthesis(r3) == true) goto L11;
            return false;
        L11:
            return r3.substring(1, r3.length() - 1).trim().equals(r4);
        }

        public Column(String r8, String r9, boolean r10, int r11) {
            this(r8, r9, r10, r11, null, 0);
        }

        public Column(String r1, String r2, boolean r3, int r4, String r5, int r6) {
            this.name = r1;
            this.type = r2;
            this.notNull = r3;
            this.primaryKeyPosition = r4;
            this.affinity = findAffinity(r2);
            this.defaultValue = r5;
            this.mCreatedFrom = r6;
        }
    }

    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + "', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof ForeignKey) == true) goto L8;
            return false;
        L8:
            ForeignKey r5 = (ForeignKey) r4;
            if (this.referenceTable.equals(r5.referenceTable) == true) goto L12;
            return false;
        L12:
            if (this.onDelete.equals(r5.onDelete) == true) goto L15;
            return false;
        L15:
            if (this.onUpdate.equals(r5.onUpdate) == true) goto L18;
            return false;
        L18:
            if (this.columnNames.equals(r5.columnNames) == true) goto L21;
            return false;
        L21:
            return this.referenceColumnNames.equals(r5.referenceColumnNames);
        }

        public ForeignKey(String r1, String r2, String r3, List<String> r4, List<String> r5) {
            this.referenceTable = r1;
            this.onDelete = r2;
            this.onUpdate = r3;
            this.columnNames = Collections.unmodifiableList(r4);
            this.referenceColumnNames = Collections.unmodifiableList(r5);
        }
    }

    public static final class Index {
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public final List<String> orders;
        public final boolean unique;

        public int hashCode() {
            if (this.name.startsWith(DEFAULT_PREFIX) == false) goto L5;
            int r0 = -1184239155;
        L7:
            return (((((r0 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
        L5:
            r0 = this.name.hashCode();
            goto L7
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + '}';
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Index) == true) goto L8;
            return false;
        L8:
            Index r5 = (Index) r4;
            if (this.unique == r5.unique) goto L12;
            return false;
        L12:
            if (this.columns.equals(r5.columns) == true) goto L15;
            return false;
        L15:
            if (this.orders.equals(r5.orders) == true) goto L18;
            return false;
        L18:
            if (this.name.startsWith(DEFAULT_PREFIX) == false) goto L22;
            return r5.name.startsWith(DEFAULT_PREFIX);
        L22:
            return this.name.equals(r5.name);
        }

        public Index(String r2, boolean r3, List<String> r4) {
            this(r2, r3, r4, null);
        }

        public Index(String r1, boolean r2, List<String> r3, List<String> r4) {
            this.name = r1;
            this.unique = r2;
            this.columns = r3;
            if (r4 != null) goto L5;
        L6:
            r4 = Collections.nCopies(r3.size(), androidx.room.Index.Order.ASC.name());
        L7:
            this.orders = r4;
            return;
        L5:
            if (r4.size() != 0) goto L7;
            goto L6
        }
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Column> r4 = this.columns;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Set<ForeignKey> r7 = this.foreignKeys;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    private static List<ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor r12) {
        int r0 = r12.getColumnIndex("id");
        int r1 = r12.getColumnIndex("seq");
        int r2 = r12.getColumnIndex("from");
        int r3 = r12.getColumnIndex("to");
        int r4 = r12.getCount();
        ArrayList r5 = new ArrayList();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L5;
        r12.moveToPosition(r6);
        r5.add(new ForeignKeyWithSequence(r12.getInt(r0), r12.getInt(r1), r12.getString(r2), r12.getString(r3)));
        r6 = r6 + 1;
        goto L3
    L5:
        Collections.sort(r5);
        return r5;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TableInfo) == true) goto L8;
        return false;
    L8:
        TableInfo r6 = (TableInfo) r5;
        String r1 = this.name;
        if (r1 == null) goto L14;
        if (r1.equals(r6.name) == false) goto L15;
    L16:
        Map<String, Column> r2 = this.columns;
        if (r2 == null) goto L22;
        if (r2.equals(r6.columns) == false) goto L23;
    L24:
        Set<ForeignKey> r3 = this.foreignKeys;
        if (r3 == null) goto L30;
        if (r3.equals(r6.foreignKeys) == false) goto L31;
    L32:
        Set<Index> r4 = this.indices;
        if (r4 == null) goto L39;
        Set<Index> r7 = r6.indices;
        if (r7 == null) goto L39;
        return r4.equals(r7);
    L39:
        return true;
    L31:
        return false;
    L30:
        if (r6.foreignKeys == null) goto L32;
    L23:
        return false;
    L22:
        if (r6.columns == null) goto L24;
    L15:
        return false;
    L14:
        if (r6.name == null) goto L16;
        goto L15
    }

    public static TableInfo read(SupportSQLiteDatabase r3, String r4) {
        return new TableInfo(r4, readColumns(r3, r4), readForeignKeys(r3, r4), readIndices(r3, r4));
    }

    private static Map<String, Column> readColumns(SupportSQLiteDatabase r14, String r15) {
        Cursor r16 = r14.query("PRAGMA table_info(`" + r15 + "`)");
        HashMap r17 = new HashMap();
    L16:
        th = move-exception;
        r16.close();
        throw th;
    L4:
        if (r16.getColumnCount() <= 0) goto L14;
        int r0 = r16.getColumnIndex("name");     // Catch: Throwable -> L16
        int r1 = r16.getColumnIndex("type");     // Catch: Throwable -> L16
        int r2 = r16.getColumnIndex("notnull");     // Catch: Throwable -> L16
        int r3 = r16.getColumnIndex("pk");     // Catch: Throwable -> L16
        int r4 = r16.getColumnIndex("dflt_value");     // Catch: Throwable -> L16
    L7:
        if (r16.moveToNext() == false) goto L14;
        String r5 = r16.getString(r0);     // Catch: Throwable -> L16
        String r8 = r16.getString(r1);     // Catch: Throwable -> L16
        if (r16.getInt(r2) == 0) goto L11;
        boolean r9 = true;
    L12:
        r17.put(r5, new Column(r5, r8, r9, r16.getInt(r3), r16.getString(r4), 2));     // Catch: Throwable -> L16
        goto L7
    L11:
        r9 = false;
    L14:
        r16.close();
        return r17;
    }

    private static Set<ForeignKey> readForeignKeys(SupportSQLiteDatabase r18, String r19) {
        HashSet r0 = new HashSet();
        Cursor r1 = r18.query("PRAGMA foreign_key_list(`" + r19 + "`)");
        int r2 = r1.getColumnIndex("id");     // Catch: Throwable -> L18
        int r3 = r1.getColumnIndex("seq");     // Catch: Throwable -> L18
        int r4 = r1.getColumnIndex("table");     // Catch: Throwable -> L18
        int r5 = r1.getColumnIndex("on_delete");     // Catch: Throwable -> L18
        int r6 = r1.getColumnIndex("on_update");     // Catch: Throwable -> L18
        List<ForeignKeyWithSequence> r7 = readForeignKeyFieldMappings(r1);     // Catch: Throwable -> L18
        int r8 = r1.getCount();     // Catch: Throwable -> L18
        int r9 = 0;
    L4:
        if (r9 >= r8) goto L16;
        r1.moveToPosition(r9);     // Catch: Throwable -> L18
        if (r1.getInt(r3) != 0) goto L15;
        int r10 = r1.getInt(r2);     // Catch: Throwable -> L18
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L18
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<ForeignKeyWithSequence> r11 = r7.iterator();     // Catch: Throwable -> L18
    L10:
        if (r11.hasNext() == false) goto L14;
        ForeignKeyWithSequence r12 = r11.next();     // Catch: Throwable -> L18
        if (r12.mId != r10) goto L10;
        r15.add(r12.mFrom);     // Catch: Throwable -> L18
        r14.add(r12.mTo);     // Catch: Throwable -> L18
        goto L10
    L14:
        r0.add(new ForeignKey(r1.getString(r4), r1.getString(r5), r1.getString(r6), r15, r14));     // Catch: Throwable -> L18
    L15:
        r9 = r9 + 1;
        goto L4
    L16:
        r1.close();
        return r0;
    L18:
        th = move-exception;
        r1.close();
        throw th;
    }

    private static Set<Index> readIndices(SupportSQLiteDatabase r8, String r9) {
        Cursor r10 = r8.query("PRAGMA index_list(`" + r9 + "`)");
        int r0 = r10.getColumnIndex("name");     // Catch: Throwable -> L28
        int r1 = r10.getColumnIndex("origin");     // Catch: Throwable -> L28
        int r2 = r10.getColumnIndex("unique");     // Catch: Throwable -> L28
        if (r0 == (-1)) goto L26;
        if (r1 == (-1)) goto L26;
        if (r2 == (-1)) goto L26;
        HashSet r4 = new HashSet();     // Catch: Throwable -> L28
    L10:
        if (r10.moveToNext() == false) goto L24;
        if ("c".equals(r10.getString(r1)) == false) goto L10;
        String r5 = r10.getString(r0);     // Catch: Throwable -> L28
        boolean r7 = true;
        if (r10.getInt(r2) == 1) goto L18;
        r7 = false;
    L18:
        Index r6 = readIndex(r8, r5, r7);     // Catch: Throwable -> L28
        if (r6 == null) goto L20;
        r4.add(r6);     // Catch: Throwable -> L28
        goto L10
    L20:
        r10.close();
        return null;
    L24:
        r10.close();
        return r4;
    L26:
        r10.close();
        return null;
    L28:
        th = move-exception;
        r10.close();
        throw th;
    }

    public TableInfo(String r2, Map<String, Column> r3, Set<ForeignKey> r4) {
        this(r2, r3, r4, Collections.emptySet());
    }

    private static Index readIndex(SupportSQLiteDatabase r10, String r11, boolean r12) {
        Cursor r13 = r10.query("PRAGMA index_xinfo(`" + r11 + "`)");
        int r0 = r13.getColumnIndex("seqno");     // Catch: Throwable -> L25
        int r1 = r13.getColumnIndex("cid");     // Catch: Throwable -> L25
        int r2 = r13.getColumnIndex("name");     // Catch: Throwable -> L25
        int r3 = r13.getColumnIndex("desc");     // Catch: Throwable -> L25
        if (r0 == (-1)) goto L23;
        if (r1 == (-1)) goto L23;
        if (r2 == (-1)) goto L23;
        if (r3 == (-1)) goto L23;
        TreeMap r4 = new TreeMap();     // Catch: Throwable -> L25
        TreeMap r5 = new TreeMap();     // Catch: Throwable -> L25
    L11:
        if (r13.moveToNext() == false) goto L20;
        if (r13.getInt(r1) < 0) goto L11;
        int r6 = r13.getInt(r0);     // Catch: Throwable -> L25
        String r7 = r13.getString(r2);     // Catch: Throwable -> L25
        if (r13.getInt(r3) <= 0) goto L18;
        String r8 = "DESC";
    L19:
        r4.put(Integer.valueOf(r6), r7);     // Catch: Throwable -> L25
        r5.put(Integer.valueOf(r6), r8);     // Catch: Throwable -> L25
        goto L11
    L18:
        r8 = "ASC";
        goto L19
    L20:
        ArrayList r9 = new ArrayList(r4.size());     // Catch: Throwable -> L25
        r9.addAll(r4.values());     // Catch: Throwable -> L25
        ArrayList r14 = new ArrayList(r5.size());     // Catch: Throwable -> L25
        r14.addAll(r5.values());     // Catch: Throwable -> L25
        Index r15 = new Index(r11, r12, r9, r14);     // Catch: Throwable -> L25
        r13.close();
        return r15;
    L23:
        r13.close();
        return null;
    L25:
        th = move-exception;
        r13.close();
        throw th;
    }

    public TableInfo(String r1, Map<String, Column> r2, Set<ForeignKey> r3, Set<Index> r4) {
        this.name = r1;
        this.columns = Collections.unmodifiableMap(r2);
        this.foreignKeys = Collections.unmodifiableSet(r3);
        if (r4 != null) goto L5;
        Set<Index> r5 = null;
    L6:
        this.indices = r5;
        return;
    L5:
        r5 = Collections.unmodifiableSet(r4);
        goto L6
    }
}
