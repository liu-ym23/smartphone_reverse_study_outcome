package com.bytedance.android.live.effect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h extends SQLiteOpenHelper {
    public long a;

    public static final class a {
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }

    public h(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, "live_effect.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r3) {
        this.a = System.currentTimeMillis();
        if (r3 == null) goto L5;
        r3.execSQL("CREATE TABLE IF NOT EXISTS live_effect_count (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,effect_id TEXT,count INTEGER)");
    L5:
        ALogger.d("LiveUxTracer", new i(this, "onCreate"));
    }
}
