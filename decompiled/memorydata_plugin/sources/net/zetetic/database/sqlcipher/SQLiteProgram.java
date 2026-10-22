package net.zetetic.database.sqlcipher;

import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {
    private static final String[] EMPTY_STRING_ARRAY = null;
    private final Object[] mBindArgs;
    private final String[] mColumnNames;
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    private final boolean mReadOnly;
    private final String mSql;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    SQLiteProgram(SQLiteDatabase r5, String r6, Object[] r7, CancellationSignal r8) {
        this.mDatabase = r5;
        String r9 = r6.trim();
        this.mSql = r9;
        int r0 = DatabaseUtils.getSqlStatementType(r9);
        if (r0 != 4) goto L5;
    L13:
        this.mReadOnly = false;
        this.mColumnNames = EMPTY_STRING_ARRAY;
        this.mNumParameters = 0;
    L14:
        if (r7 != null) goto L16;
    L20:
        int r10 = this.mNumParameters;
        if (r10 == 0) goto L25;
        Object[] r11 = new Object[r10];
        this.mBindArgs = r11;
        if (r7 == null) goto L27;
        System.arraycopy(r7, 0, r11, 0, r7.length);
        return;
    L27:
        return;
    L25:
        this.mBindArgs = null;
        return;
    L16:
        if (r7.length <= this.mNumParameters) goto L20;
        throw new IllegalArgumentException("Too many bind arguments.  " + r7.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
    L5:
        if (r0 == 5) goto L13;
        if (r0 == 6) goto L13;
        boolean r1 = true;
        if (r0 == 1) goto L12;
        r1 = false;
    L12:
        SQLiteStatementInfo r2 = new SQLiteStatementInfo();
        r5.getThreadSession().prepare(r9, r5.getThreadDefaultConnectionFlags(r1), r8, r2);
        this.mReadOnly = r2.readOnly;
        this.mColumnNames = r2.columnNames;
        this.mNumParameters = r2.numParameters;
        goto L14
    }

    private void bind(int r3, Object r4) {
        if (r3 < 1) goto L9;
        if (r3 > this.mNumParameters) goto L9;
        this.mBindArgs[r3 - 1] = r4;
        return;
    L9:
        throw new IllegalArgumentException("Cannot bind argument at index " + r3 + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
    }

    public void bindAllArgs(Object... r4) {
        if (r4 == null) goto L10;
        int r0 = r4.length;
    L4:
        if (r0 == 0) goto L13;
        int r1 = r0 - 1;
        if (r4[r1] == null) goto L9;
        bind(r0, r4[r1]);
        r0 = r0 - 1;
        goto L4
    L9:
        throw new IllegalArgumentException("the bind value at index " + r0 + " is null");
    L13:
        return;
    }

    public void bindAllArgsAsStrings(String[] r3) {
        if (r3 == null) goto L6;
        int r0 = r3.length;
    L4:
        if (r0 == 0) goto L8;
        bindString(r0, r3[r0 - 1]);
        r0 = r0 - 1;
        goto L4
    L8:
        return;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r2, byte[] r3) {
        if (r3 == null) goto L6;
        bind(r2, r3);
        return;
    L6:
        throw new IllegalArgumentException("the bind value at index " + r2 + " is null");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r1, double r2) {
        bind(r1, Double.valueOf(r2));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r1, long r2) {
        bind(r1, Long.valueOf(r2));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r2) {
        bind(r2, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r2, String r3) {
        if (r3 == null) goto L6;
        bind(r2, r3);
        return;
    L6:
        throw new IllegalArgumentException("the bind value at index " + r2 + " is null");
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Object[] r1 = this.mBindArgs;
        if (r1 == null) goto L6;
        Arrays.fill(r1, null);
        return;
    }

    final Object[] getBindArgs() {
        return this.mBindArgs;
    }

    final String[] getColumnNames() {
        return this.mColumnNames;
    }

    public final int getConnectionFlags() {
        return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
    }

    final SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    public final SQLiteSession getSession() {
        return this.mDatabase.getThreadSession();
    }

    String getSql() {
        return this.mSql;
    }

    @Deprecated
    public final int getUniqueId() {
        return -1;
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public void onAllReferencesReleased() {
        clearBindings();
    }

    public final void onCorruption() {
        this.mDatabase.onCorruption();
    }
}
