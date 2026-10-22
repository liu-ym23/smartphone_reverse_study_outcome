package com.bytedance.sdk.account.save.c;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {
    public a(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "account_db", null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE IF NOT EXISTS login_info (time integer primary key , type integer , info text , uid integer , avatar_url text , screen_name text , platform_avatar_url text, platform_screen_name text,sec_uid text,ext text);");     // Catch: SQLException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        if (r2 >= 2) goto L6;
        r1.execSQL("alter TABLE login_info add COLUMN sec_uid text ");
        r1.execSQL("alter TABLE login_info add COLUMN ext text ");
        Logger.d("DBHelper", "update db ");
        return;
    }
}
