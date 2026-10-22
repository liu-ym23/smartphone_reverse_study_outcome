package com.bytedance.security.dbcipher;

import android.content.Context;
import com.bytedance.security.dbcipher.utils.CipherConfig;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SqliteCipherDB {
    public SqliteCipherDB() {
    }

    public abstract int getVersion();

    public abstract SQLiteDatabase openOrCreateDatabase(Context r1, String r2, String r3, CipherConfig r4);
}
