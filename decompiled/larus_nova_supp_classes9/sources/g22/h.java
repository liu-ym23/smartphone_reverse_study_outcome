package g22;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.livesdk.i18n.db.I18nDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements e {
    public final RoomDatabase a;
    public final f b;
    public final g c;

    @Override // g22.e
    public final void empty() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.c.acquire();
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        this.c.release(r0);
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        this.c.release(r0);
        throw th;
    }

    @Override // g22.e
    public final List<d> getAll() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM translation", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.a, r0, false, null);
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "key");     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "value");     // Catch: Throwable -> L18
        ArrayList r5 = new ArrayList(r1.getCount());     // Catch: Throwable -> L18
    L4:
        if (r1.moveToNext() == false) goto L16;
        d r6 = new d();     // Catch: Throwable -> L18
        if (r1.isNull(r2) == false) goto L9;
        r6.a = null;     // Catch: Throwable -> L18
    L11:
        if (r1.isNull(r4) == false) goto L13;
        r6.b = null;     // Catch: Throwable -> L18
    L14:
        r5.add(r6);     // Catch: Throwable -> L18
        goto L4
    L13:
        r6.b = r1.getString(r4);     // Catch: Throwable -> L18
        goto L14
    L9:
        r6.a = r1.getString(r2);     // Catch: Throwable -> L18
        goto L11
    L16:
        r1.close();
        r0.release();
        return r5;
    L18:
        th = move-exception;
        r1.close();
        r0.release();
        throw th;
    }

    public h(I18nDatabase r2) {
        this.a = r2;
        this.b = new f(r2);
        this.c = new g(r2);
    }

    @Override // g22.e
    public void insert(List<d> r2) {
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
