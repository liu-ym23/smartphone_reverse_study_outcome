package com.bytedance.android.live.effect.composer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends SQLiteOpenHelper {

    public static final class a {
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }

    public j(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter("live_composer_mode.db", "dbName");
        super(r4, "live_composer_mode.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r2) {
        System.currentTimeMillis();
        if (r2 == null) goto L5;
        r2.execSQL("CREATE TABLE IF NOT EXISTS live_composer_node_by_mode (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,mode TEXT, panel TEXT,effect_id TEXT,resource_id TEXT,path TEXT,update_time INTEGER,use INTEGER,is_high_cost INTEGER)");
    L5:
        if (r2 == null) goto L8;
        r2.execSQL("CREATE TABLE IF NOT EXISTS live_composer_tag_node_by_mode(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,tag TEXT,value REAL,node_id INTEGER)");
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.execSQL("Drop Table if exists live_composer_node_by_mode");
        r1.execSQL("Drop Table if exists live_composer_tag_node_by_mode");
        onCreate(r1);
    }
}
