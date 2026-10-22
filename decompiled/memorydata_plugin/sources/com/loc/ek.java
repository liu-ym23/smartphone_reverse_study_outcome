package com.loc;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public class ek implements t {
    public ek() {
    }

    @Override // com.loc.t
    public final String a() {
        return "alsn20170807.db";
    }

    @Override // com.loc.t
    public final void a(SQLiteDatabase r2) {
        r2.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "SdCardDbCreator", "onCreate");
    }
}
