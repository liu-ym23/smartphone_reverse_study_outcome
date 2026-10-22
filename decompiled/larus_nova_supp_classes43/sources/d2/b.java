package d2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends SQLiteOpenHelper {
    public b(Context r10) {
        super(r10, "policy.db", null, 1);
    }

    public void delete(String r10) {
        getWritableDatabase().delete("policies", "app_id=?", new String[]{r10});     // Catch: Exception -> L5
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r10) {
        r10.execSQL("CREATE TABLE policies (app_id TEXT PRIMARY KEY, content TEXT, version INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r10, int r11) {
        r1.execSQL("DROP TABLE IF EXISTS policies");
        r1.execSQL("CREATE TABLE policies (app_id TEXT PRIMARY KEY, content TEXT, version INTEGER)");
    }
}
