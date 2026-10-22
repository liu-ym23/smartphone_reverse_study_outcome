package com.bytedance.security.dbcipher;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.security.dbcipher.utils.CipherConfig;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RoomCipherDB {
    public RoomCipherDB() {
    }

    public abstract int getVersion();

    public abstract SupportSQLiteOpenHelper.Factory preOpenOrCreateDb(Context r1, String r2, String r3, CipherConfig r4);
}
