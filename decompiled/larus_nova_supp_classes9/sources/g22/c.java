package g22;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements b {
    public final RoomDatabase a;
    public final a b;

    public class a extends EntityInsertionAdapter<g22.a> {
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `information` (`key`,`value`) VALUES (?,?)";
        }

        public a(RoomDatabase r1) {
            super(r1);
        }

        public final void bind(SupportSQLiteStatement r3, Object r4) {
            g22.a r5 = (g22.a) r4;
            String r0 = r5.a;
            if (r0 != null) goto L5;
            r3.bindNull(1);
        L6:
            String r6 = r5.b;
            if (r6 != null) goto L9;
            r3.bindNull(2);
            return;
        L9:
            r3.bindString(2, r6);
            return;
        L5:
            r3.bindString(1, r0);
            goto L6
        }
    }

    public c(RoomDatabase r2) {
        this.a = r2;
        this.b = new a(r2);
    }

    @Override // g22.b
    public final g22.a get(String r7) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM information WHERE `key` = ?", 1);
        r0.bindString(1, r7);
        this.a.assertNotSuspendingTransaction();
        g22.a r2 = null;
        Cursor r8 = DBUtil.query(this.a, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r8, "key");     // Catch: Throwable -> L16
        int r3 = CursorUtil.getColumnIndexOrThrow(r8, "value");     // Catch: Throwable -> L16
        if (r8.moveToFirst() == false) goto L14;
        g22.a r4 = new g22.a();     // Catch: Throwable -> L16
        if (r8.isNull(r1) == false) goto L8;
        r4.a = null;     // Catch: Throwable -> L16
    L10:
        if (r8.isNull(r3) == false) goto L12;
        r4.b = null;     // Catch: Throwable -> L16
    L13:
        r2 = r4;
        goto L14
    L12:
        r4.b = r8.getString(r3);     // Catch: Throwable -> L16
        goto L13
    L8:
        r4.a = r8.getString(r1);     // Catch: Throwable -> L16
    L14:
        r8.close();
        r0.release();
        return r2;
    L16:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    }

    @Override // g22.b
    public void insert(g22.a r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        this.b.insert(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }
}
