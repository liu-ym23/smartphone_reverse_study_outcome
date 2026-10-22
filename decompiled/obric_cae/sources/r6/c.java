package r6;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class c extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f11533a;

    public c(Context r8) {
        super(r8, "secret_item.db", null, 1);
    }

    public static c i(Context r8) {
        if (f11533a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11533a != null) goto L9;
        f11533a = new c(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f11533a;
    }

    public final a a(String r11, String r12) {
        Log.i("a", "queryData, alias: " + r11 + ", pkgName: " + r12);
        Cursor r10 = getReadableDatabase().query("secret_item", null, "alias =? AND pkg_name =? ", new String[]{r11, r12}, null, null, null);
        if (r10 != null) goto L7;
        Log.e("a", "queryData cursor is null");
        return null;
    L7:
        if (r10.getCount() != 0) goto L10;
        Log.e("a", "queryData cursor count is 0");
        r10.close();
        return null;
    L10:
        a r13 = new a();
        if (r10.moveToFirst() == false) goto L13;
        r13.f11524c = r10.getString(r10.getColumnIndex("associate"));
        r13.f11523b = r10.getString(r10.getColumnIndex("data_type"));
        r13.f11525d = r10.getString(r10.getColumnIndex("public_data"));
        r13.f11526e = r10.getString(r10.getColumnIndex("private_data"));
        r13.f11527f = r10.getString(r10.getColumnIndex("secret_data"));
        r13.f11528g = r10.getString(r10.getColumnIndex("ext_info"));
        r13.f11529h = r10.getString(r10.getColumnIndex("search_info"));
        r13.f11530i = r10.getString(r10.getColumnIndex("create_time"));
        r13.f11531j = r10.getString(r10.getColumnIndex("latest_time"));
        r10.getString(r10.getColumnIndex("access_limit"));
        r10.getString(r10.getColumnIndex("auth_limit"));
        r10.getInt(r10.getColumnIndex("sync_limit"));
        r13.f11522a = r11;
    L13:
        r10.close();
        return r13;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r8) {
        r8.execSQL("CREATE TABLE key_item (alias TEXT NOT NULL PRIMARY KEY, version INTEGER, cipher TEXT, iv TEXT,extra TEXT)");
        r8.execSQL("CREATE TABLE secret_item (alias TEXT NOT NULL, pkg_name TEXT NOT NULL, public_data TEXT, private_data TEXT, secret_data TEXT, data_type TEXT, associate TEXT, access_limit TEXT, auth_limit TEXT, sync_limit INTEGER, sync_status INTEGER, global_id TEXT, status INTEGER, search_info TEXT, ext_info TEXT, create_time TEXT, latest_time TEXT, PRIMARY KEY (alias, pkg_name))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
    }
}
