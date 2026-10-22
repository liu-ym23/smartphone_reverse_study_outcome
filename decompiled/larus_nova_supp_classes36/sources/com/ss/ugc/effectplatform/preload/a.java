package com.ss.ugc.effectplatform.preload;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import bytekn.foundation.logger.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends SQLiteOpenHelper {
    public a(Context r7) {
        super(r7, "effect_platform_db", null, 1, null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r2) {
        if (r2 == null) goto L5;
        r2.execSQL("create table if not exists preload_table(file_name TEXT primary key,resource_key TEXT,uri TEXT,res_name TEXT,last_access_time INTEGER,busi_key_list TEXT)");
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
        Logger.INSTANCE.d("JKL", "onUpgrade，newVersion is " + r5);
        if (r3 != null) goto L5;
        return;
    L5:
        r3.beginTransaction();
        r3.setTransactionSuccessful();     // Catch: Throwable -> L8 Exception -> L10
    L7:
        r3.endTransaction();
        return;
    L8:
        th = move-exception;
        r3.endTransaction();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L7
    }
}
