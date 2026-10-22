package b1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.room.o;
import ge.r;
import he.i;
import he.j;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements a1.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f2970b = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f2971m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f2972a;

    public static final class a extends j implements r<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a1.e f2973a;

        public a(a1.e r8) {
            this.f2973a = r8;
            super(4);
        }

        @Override // ge.r
        public final SQLiteCursor d(SQLiteDatabase r8, SQLiteCursorDriver r10, String r11, SQLiteQuery r12) {
            SQLiteQuery r13 = r12;
            i.c(r13);
            o r14 = new o(r13);
            this.f2973a.i(r14);
            return new SQLiteCursor(r10, r11, r13);
        }
    }

    static {
        f2970b = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        f2971m = new String[0];
    }

    public c(SQLiteDatabase r8) {
        i.f(r8, "delegate");
        this.f2972a = r8;
    }

    @Override // a1.b
    public final Cursor M(final a1.e r8, CancellationSignal r10) {
        i.f(r8, "query");
        String r11 = r8.a();
        String[] r12 = f2971m;
        i.c(r10);
        SQLiteDatabase.CursorFactory r13 = new b1.a(r8);
        SQLiteDatabase r14 = this.f2972a;
        i.f(r14, "sQLiteDatabase");
        i.f(r11, "sql");
        Cursor r15 = r14.rawQueryWithFactory(r13, r11, r12, null, r10);
        i.e(r15, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
        return r15;
    }

    @Override // a1.b
    public final a1.f S(String r8) {
        i.f(r8, "sql");
        SQLiteStatement r10 = this.f2972a.compileStatement(r8);
        i.e(r10, "delegate.compileStatement(sql)");
        return new g(r10);
    }

    public final void a(String r8, Object[] r10) {
        i.f(r8, "sql");
        i.f(r10, "bindArgs");
        this.f2972a.execSQL(r8, r10);
    }

    @Override // a1.b
    public final Cursor a0(String r8) {
        i.f(r8, "query");
        return q(new a1.a(r8));
    }

    @Override // a1.b
    public final void c() {
        this.f2972a.beginTransaction();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f2972a.close();
    }

    @Override // a1.b
    public final void e(String r8) {
        i.f(r8, "sql");
        this.f2972a.execSQL(r8);
    }

    public final List<Pair<String, String>> i() {
        return this.f2972a.getAttachedDbs();
    }

    @Override // a1.b
    public final boolean isOpen() {
        return this.f2972a.isOpen();
    }

    @Override // a1.b
    public final boolean j0() {
        return this.f2972a.inTransaction();
    }

    public final String k() {
        return this.f2972a.getPath();
    }

    @Override // a1.b
    public final boolean k0() {
        SQLiteDatabase r8 = this.f2972a;
        i.f(r8, "sQLiteDatabase");
        return r8.isWriteAheadLoggingEnabled();
    }

    @Override // a1.b
    public final void m() {
        this.f2972a.setTransactionSuccessful();
    }

    public final int n(String r8, int r10, ContentValues r11, String r12, Object[] r13) {
        i.f(r8, "table");
        i.f(r11, "values");
        int r14 = 0;
        if (r11.size() == 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L29;
        int r16 = r11.size();
        if (r13 != null) goto L10;
        int r17 = r16;
    L11:
        Object[] r18 = new Object[r17];
        StringBuilder r19 = new StringBuilder("UPDATE ");
        r19.append(f2970b[r10]);
        r19.append(r8);
        r19.append(" SET ");
        Iterator<String> r20 = r11.keySet().iterator();
    L13:
        if (r20.hasNext() == false) goto L19;
        String r21 = r20.next();
        if (r14 <= 0) goto L17;
        String r22 = ",";
    L18:
        r19.append(r22);
        r19.append(r21);
        r18[r14] = r11.get(r21);
        r19.append("=?");
        r14 = r14 + 1;
        goto L13
    L17:
        r22 = "";
        goto L18
    L19:
        if (r13 == null) goto L24;
        int r23 = r16;
    L21:
        if (r23 >= r17) goto L24;
        r18[r23] = r13[r23 - r16];
        r23 = r23 + 1;
    L24:
        if (TextUtils.isEmpty(r12) == true) goto L26;
        r19.append(" WHERE ");
        r19.append(r12);
    L26:
        String r24 = r19.toString();
        i.e(r24, "StringBuilder().apply(builderAction).toString()");
        Closeable r25 = S(r24);
        a1.a.C0000a.a((o) r25, r18);
        return ((g) r25).g();
    L10:
        r17 = r13.length + r16;
        goto L11
    L29:
        throw new IllegalArgumentException("Empty values".toString());
    L5:
        r15 = false;
        goto L6
    }

    @Override // a1.b
    public final void o() {
        this.f2972a.beginTransactionNonExclusive();
    }

    @Override // a1.b
    public final Cursor q(a1.e r8) {
        i.f(r8, "query");
        final a r10 = new a(r8);
        SQLiteDatabase.CursorFactory r11 = new b(r10);
        String r12 = r8.a();
        String[] r13 = f2971m;
        Cursor r14 = this.f2972a.rawQueryWithFactory(r11, r12, r13, null);
        i.e(r14, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return r14;
    }

    @Override // a1.b
    public final void t() {
        this.f2972a.endTransaction();
    }
}
