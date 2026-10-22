package n4a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x extends SQLiteOpenHelper {
    public final v a;

    public x(Context r3, String r4, v r5) {
        super(r3, r4, null, 1);
        this.a = r5;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r2) {
        this.a.a(r2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }
}
