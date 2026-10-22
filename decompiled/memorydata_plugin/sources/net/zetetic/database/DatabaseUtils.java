package net.zetetic.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.Collator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import net.zetetic.database.sqlcipher.SQLiteProgram;
import net.zetetic.database.sqlcipher.SQLiteStatement;

/* JADX INFO: loaded from: classes6.dex */
public class DatabaseUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f17871a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Collator f17872b;

    @Deprecated
    public static class InsertHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SQLiteDatabase f17873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f17874b;
        private HashMap<String, Integer> c;
        private String d;
        private SQLiteStatement e;
        private SQLiteStatement f;
        private SQLiteStatement g;

        public InsertHelper(SQLiteDatabase r2, String r3) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.f17873a = r2;
            this.f17874b = r3;
        }

        private long a(ContentValues r6, boolean r7) {
            this.f17873a.beginTransactionNonExclusive();
            SQLiteStatement r8 = a(r7);     // Catch: Throwable -> L10 SQLException -> L12
            r8.clearBindings();     // Catch: Throwable -> L10 SQLException -> L12
            Iterator<Map.Entry<String, Object>> r1 = r6.valueSet().iterator();     // Catch: Throwable -> L10 SQLException -> L12
        L5:
            if (r1.hasNext() == false) goto L7;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10 SQLException -> L12
            DatabaseUtils.a(r8, a((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin")), r2.getValue());     // Catch: Throwable -> L10 SQLException -> L12
            goto L5
        L7:
            long r0 = r8.executeInsert();     // Catch: Throwable -> L10 SQLException -> L12
            this.f17873a.setTransactionSuccessful();     // Catch: Throwable -> L10 SQLException -> L12
            this.f17873a.endTransaction();
            return r0;
        L12:
            e = move-exception;
            Log.e("DatabaseUtils", "Error inserting " + r6 + " into table  " + this.f17874b, e);     // Catch: Throwable -> L10
            this.f17873a.endTransaction();
            return -1;
        L10:
            th = move-exception;
            this.f17873a.endTransaction();
            throw th;
        }

        private SQLiteStatement a(boolean r3) {
            if (r3 == false) goto L12;
            if (this.f != null) goto L10;
            if (this.d != null) goto L8;
            a();
        L8:
            this.f = this.f17873a.compileStatement("INSERT OR REPLACE" + this.d.substring(6));
        L10:
            return this.f;
        L12:
            if (this.e != null) goto L18;
            if (this.d != null) goto L16;
            a();
        L16:
            this.e = this.f17873a.compileStatement(this.d);
        L18:
            return this.e;
        }

        private void a() {
            StringBuilder r2 = new StringBuilder(128);
            r2.append("INSERT INTO ");
            r2.append(this.f17874b);
            r2.append(" (");
            StringBuilder r4 = new StringBuilder(128);
            r4.append("VALUES (");
            Cursor r3 = null;
            r3 = this.f17873a.rawQuery("PRAGMA table_info(" + this.f17874b + ")", null);     // Catch: Throwable -> L24
            this.c = new HashMap(r3.getCount());     // Catch: Throwable -> L24
            int r6 = 1;
        L4:
            if (r3.moveToNext() == false) goto L20;
            String r7 = r3.getString(1);     // Catch: Throwable -> L24
            String r8 = r3.getString(4);     // Catch: Throwable -> L24
            this.c.put(r7, Integer.valueOf(r6));     // Catch: Throwable -> L24
            r2.append("'");     // Catch: Throwable -> L24
            r2.append(r7);     // Catch: Throwable -> L24
            r2.append("'");     // Catch: Throwable -> L24
            if (r8 != null) goto L9;
            r4.append("?");     // Catch: Throwable -> L24
        L11:
            String r9 = ", ";
            if (r6 != r3.getCount()) goto L14;
            String r10 = ") ";
        L15:
            r2.append(r10);     // Catch: Throwable -> L24
            if (r6 != r3.getCount()) goto L18;
            r9 = ");";
        L18:
            r4.append(r9);     // Catch: Throwable -> L24
            r6 = r6 + 1;
            goto L4
        L14:
            r10 = ", ";
            goto L15
        L9:
            r4.append("COALESCE(?, ");     // Catch: Throwable -> L24
            r4.append(r8);     // Catch: Throwable -> L24
            r4.append(")");     // Catch: Throwable -> L24
            goto L11
        L20:
            if (r3 == null) goto L22;
            r3.close();
        L22:
            r2.append(r4);
            this.d = r2.toString();
            return;
        L24:
            th = move-exception;
            if (r3 == null) goto L27;
            r3.close();
        L27:
            throw th;
        }

        public int a(String r3) {
            a(false);
            Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.c.get(r3), Integer.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            return r2.intValue();
        L7:
            throw new IllegalArgumentException("column '" + r3 + "' is invalid");
        }

        public long insert(ContentValues r2) {
            return a(r2, false);
        }
    }

    static {
        f17871a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f17872b = null;
    }

    public DatabaseUtils() {
    }

    public static int a(int r0, int r1) {
        return Math.max(r0 - (r1 / 3), 0);
    }

    public static int a(Object r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        if ((r1 instanceof byte[]) == false) goto L10;
        return 4;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == false) goto L12;
        return 2;
    L12:
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == false) goto L15;
        return 2;
    L15:
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L17;
        return 1;
    L17:
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == false) goto L19;
        return 1;
    L19:
        if (ZeusTransformUtils.instanceOf(r1, Short.class) == false) goto L21;
        return 1;
    L21:
        if (ZeusTransformUtils.instanceOf(r1, Byte.class) == true) goto L31;
        return 3;
    L31:
        return 1;
    }

    public static int a(String r3) {
        String r4 = r3.trim();
        if (r4.length() >= 3) goto L5;
        return 99;
    L5:
        String r5 = r4.substring(0, 3).toUpperCase(Locale.ROOT);
        if (r5.equals("SEL") == false) goto L10;
        return 1;
    L10:
        if (r5.equals("INS") == false) goto L12;
        return 2;
    L12:
        if (r5.equals("UPD") == false) goto L14;
        return 2;
    L14:
        if (r5.equals("REP") == false) goto L16;
        return 2;
    L16:
        if (r5.equals("DEL") == false) goto L19;
        return 2;
    L19:
        if (r5.equals("ATT") == false) goto L22;
        return 3;
    L22:
        if (r5.equals("COM") == false) goto L25;
        return 5;
    L25:
        if (r5.equals("END") == false) goto L28;
        return 5;
    L28:
        if (r5.equals("ROL") == false) goto L32;
        return 6;
    L32:
        if (r5.equals("BEG") == false) goto L36;
        return 4;
    L36:
        if (r5.equals("PRA") == false) goto L40;
        return 7;
    L40:
        if (r5.equals("CRE") == false) goto L42;
        return 8;
    L42:
        if (r5.equals("DRO") == false) goto L44;
        return 8;
    L44:
        if (r5.equals("ALT") == false) goto L47;
        return 8;
    L47:
        if (r5.equals("ANA") == false) goto L49;
        return 9;
    L49:
        if (r5.equals("DET") == true) goto L58;
        return 99;
    L58:
        return 9;
    }

    public static long a(SQLiteDatabase r0, String r1, String[] r2) {
        SQLiteStatement r3 = r0.compileStatement(r1);
        long r4 = a(r3, r2);     // Catch: Throwable -> L6
        r3.close();
        return r4;
    L6:
        th = move-exception;
        r3.close();
        throw th;
    }

    public static long a(SQLiteStatement r0, String[] r1) {
        r0.bindAllArgsAsStrings(r1);
        return r0.simpleQueryForLong();
    }

    public static void a(SQLiteProgram r2, int r3, Object r4) {
        if (r4 != null) goto L5;
        r2.bindNull(r3);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L7;
    L23:
        r2.bindDouble(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue());
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == true) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L14;
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue();
    L12:
        r2.bindLong(r3, r0);
        return;
    L14:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L20;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L18;
        r0 = 1;
        goto L12
    L18:
        r0 = 0;
        goto L12
    L20:
        if ((r4 instanceof byte[]) == false) goto L22;
        r2.bindBlob(r3, (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
        return;
    L22:
        r2.bindString(r3, r4.toString());
    }
}
