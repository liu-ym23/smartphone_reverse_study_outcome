package qa;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class k3 implements u {
    public k3() {
    }

    @Override // qa.u
    public final void a() {
    }

    @Override // qa.u
    public final void a(SQLiteDatabase r8) {
        r8.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        t3.g("SdCardDbCreator", "onCreate", th);
    }
}
