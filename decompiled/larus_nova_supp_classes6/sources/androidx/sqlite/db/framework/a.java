package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {
    public final /* synthetic */ SupportSQLiteQuery a;

    public /* synthetic */ a(SupportSQLiteQuery r1) {
        this.a = r1;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase r2, SQLiteCursorDriver r3, String r4, SQLiteQuery r5) {
        return FrameworkSQLiteDatabase.a(this.a, r2, r3, r4, r5);
    }
}
