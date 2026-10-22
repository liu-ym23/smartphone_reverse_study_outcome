package g2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import c2.k;

/* JADX INFO: loaded from: classes.dex */
public final class a extends SQLiteOpenHelper {
    public a(Context r8, String r10) {
        super(r8, r10, null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r8) {
        r8.execSQL("CREATE TABLE t_battery ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, front Integer, timestamp Integer, type TEXT, status Integer, scene TEXT, accumulation Integer, source TEXT, delete_flag Integer DEFAULT 0, process TEXT, main_process Integer, sid TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )");     // Catch: Exception -> L4
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
        if (k.d() == false) goto L6;
        q3.a.a("DBHelper", "Updating table from " + r10 + " to " + r11);
    L6:
        if (r10 >= 2) goto L12;
        r8.execSQL("DROP TABLE IF EXISTS local_monitor_log");     // Catch: Exception -> L9
        r8.execSQL("DROP TABLE IF EXISTS t_apiall");     // Catch: Exception -> L9
        r8.execSQL("DROP TABLE IF EXISTS local_monitor_version");     // Catch: Exception -> L9
        return;
    L13:
        return;
    }
}
