package xh8;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static volatile c b;
    public final SQLiteDatabase a;

    public class a implements SQLiteDatabase.CursorFactory {
        public a() {
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase r1, SQLiteCursorDriver r2, String r3, SQLiteQuery r4) {
            return new SQLiteCursor(r2, r3, r4);
        }
    }

    public static c a() {
        if (b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public c() {
        this.a = SQLiteDatabase.create(new a());
    }
}
