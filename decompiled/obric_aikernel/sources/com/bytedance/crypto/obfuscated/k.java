package com.bytedance.crypto.obfuscated;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class k extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile k f1502a;

    public k(Context r10) {
        super(r10, "secret_item.db", null, 1);
    }

    public static k a(Context r10) {
        if (f1502a != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1502a != null) goto L9;
        f1502a = new k(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f1502a;
    }

    public final i a(String r11, String r12) {
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
        i r13 = new i();
        if (r10.moveToFirst() == false) goto L13;
        r13.f1490c = r10.getString(r10.getColumnIndex("associate"));
        r13.f1489b = r10.getString(r10.getColumnIndex("data_type"));
        r13.f1491d = r10.getString(r10.getColumnIndex("public_data"));
        r13.f1492e = r10.getString(r10.getColumnIndex("private_data"));
        r13.f1493f = r10.getString(r10.getColumnIndex("secret_data"));
        r13.f1494g = r10.getString(r10.getColumnIndex("ext_info"));
        r13.f1495h = r10.getString(r10.getColumnIndex("search_info"));
        r13.f1499l = r10.getString(r10.getColumnIndex("create_time"));
        r13.f1500m = r10.getString(r10.getColumnIndex("latest_time"));
        r13.f1496i = r10.getString(r10.getColumnIndex("access_limit"));
        r13.f1497j = r10.getString(r10.getColumnIndex("auth_limit"));
        r13.f1498k = r10.getInt(r10.getColumnIndex("sync_limit"));
        r13.f1488a = r11;
    L13:
        r10.close();
        return r13;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r10) {
        r10.execSQL("CREATE TABLE key_item (alias TEXT NOT NULL PRIMARY KEY, version INTEGER, cipher TEXT, iv TEXT,extra TEXT)");
        r10.execSQL("CREATE TABLE secret_item (alias TEXT NOT NULL, pkg_name TEXT NOT NULL, public_data TEXT, private_data TEXT, secret_data TEXT, data_type TEXT, associate TEXT, access_limit TEXT, auth_limit TEXT, sync_limit INTEGER, sync_status INTEGER, global_id TEXT, status INTEGER, search_info TEXT, ext_info TEXT, create_time TEXT, latest_time TEXT, PRIMARY KEY (alias, pkg_name))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
    }
}
