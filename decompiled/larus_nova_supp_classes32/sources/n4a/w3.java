package n4a;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w3 implements v {
    public w3() {
    }

    @Override // n4a.v
    public final void a() {
    }

    @Override // n4a.v
    public final void a(SQLiteDatabase r3) {
        r3.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "SdCardDbCreator", "onCreate");
    }
}
