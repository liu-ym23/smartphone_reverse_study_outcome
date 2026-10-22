package com.bytedance.android.live.effect.composer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o extends SQLiteOpenHelper {

    public static final class a {
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r2) {
        System.currentTimeMillis();
        if (r2 == null) goto L5;
        r2.execSQL("CREATE TABLE IF NOT EXISTS live_composer_node (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,panel TEXT,effect_id TEXT,resource_id TEXT,path TEXT,update_time INTEGER,use INTEGER,is_high_cost INTEGER)");
    L5:
        if (r2 == null) goto L8;
        r2.execSQL("CREATE TABLE IF NOT EXISTS live_composer_tag_node(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,tag TEXT,value REAL,node_id INTEGER)");
        return;
    }

    public o(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dbName");
        super(r3, r4, null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.execSQL("Drop Table if exists live_composer_node");
        r1.execSQL("Drop Table if exists live_composer_tag_node");
        onCreate(r1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        if (r2 >= 2) goto L7;
        if (r1 == null) goto L7;
        r1.execSQL("ALTER TABLE live_composer_node ADD COLUMN resource_id TEXT DEFAULT \"\" NOT NULL;");
    L7:
        if (r2 >= 3) goto L11;
        if (r1 == null) goto L12;
        r1.execSQL("ALTER TABLE live_composer_node ADD COLUMN is_high_cost INTEGER DEFAULT 0 NOT NULL;");
        return;
    L12:
        return;
    }
}
