package xh8;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class f$a extends SQLiteOpenHelper {
    public final d[] a;
    public final SupportSQLiteOpenHelper.Callback b;
    public boolean c;

    public class a implements DatabaseErrorHandler {
        public final /* synthetic */ SupportSQLiteOpenHelper.Callback a;
        public final /* synthetic */ d[] b;

        @Override // android.database.DatabaseErrorHandler
        public final void onCorruption(SQLiteDatabase r5) {
            SupportSQLiteOpenHelper.Callback r0 = this.a;
            d[] r1 = this.b;
            d r3 = r1[0];
            if (r3 != null) goto L5;
        L9:
            r1[0] = new d(r5);
        L10:
            r0.onCorruption(r1[0]);
            return;
        L5:
            if (r3.a != r5) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L10;
        L7:
            r4 = false;
            goto L8
        }

        public a(SupportSQLiteOpenHelper.Callback r1, d[] r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final synchronized SupportSQLiteDatabase a() {
        monitor-enter(this);
        this.c = false;     // Catch: Throwable -> L17
        SQLiteDatabase r0 = getReadableDatabase();     // Catch: SQLiteException -> L7 Throwable -> L17
    L10:
        if (this.c == false) goto L14;
        close();     // Catch: Throwable -> L17
        SupportSQLiteDatabase r1 = a();     // Catch: Throwable -> L17
        monitor-exit(this);
        return r1;
    L14:
        d r2 = b(r0);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r2;
    L7:
        e = move-exception;
        e.a(e, "getReadableSupportDatabase");     // Catch: Throwable -> L17
        FLogger.a.e("OpenHelper", "getReadableSupportDatabase err", e);     // Catch: Throwable -> L17
        r0 = c.a().a;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized SupportSQLiteDatabase c() {
        monitor-enter(this);
        this.c = false;     // Catch: Throwable -> L17
        SQLiteDatabase r0 = getWritableDatabase();     // Catch: SQLiteException -> L7 Throwable -> L17
    L10:
        if (this.c == false) goto L14;
        close();     // Catch: Throwable -> L17
        SupportSQLiteDatabase r1 = c();     // Catch: Throwable -> L17
        monitor-exit(this);
        return r1;
    L14:
        d r2 = b(r0);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r2;
    L7:
        e = move-exception;
        e.a(e, "getWritableSupportDatabase");     // Catch: Throwable -> L17
        FLogger.a.e("OpenHelper", "getWritableSupportDatabase err", e);     // Catch: Throwable -> L17
        r0 = c.a().a;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        super.close();     // Catch: Throwable -> L6
        this.a[0] = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final d b(SQLiteDatabase r4) {
        d[] r0 = this.a;
        d r2 = r0[0];
        if (r2 != null) goto L5;
    L9:
        r0[0] = new d(r4);
    L11:
        return r0[0];
    L5:
        if (r2.a != r4) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
    L7:
        r3 = false;
        goto L8
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase r2) {
        this.b.onConfigure(b(r2));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r2) {
        this.b.onCreate(b(r2));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase r2) {
        if (this.c == true) goto L6;
        this.b.onOpen(b(r2));
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r2, int r3, int r4) {
        this.c = true;
        this.b.onDowngrade(b(r2), r3, r4);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
        this.c = true;
        this.b.onUpgrade(b(r2), r3, r4);
    }

    public f$a(Context r7, String r8, d[] r9, SupportSQLiteOpenHelper.Callback r10) {
        super(r7, r8, null, r10.version, new a(r10, r9));
        this.b = r10;
        this.a = r9;
    }
}
