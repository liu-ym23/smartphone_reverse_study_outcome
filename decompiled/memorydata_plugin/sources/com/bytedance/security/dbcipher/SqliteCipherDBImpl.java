package com.bytedance.security.dbcipher;

import android.content.Context;
import android.util.Log;
import com.bytedance.security.dbcipher.utils.CipherConfig;
import com.bytedance.security.dbcipher.utils.DBCipherUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public class SqliteCipherDBImpl extends SqliteCipherDB {
    private static final String TAG = null;

    static {
        System.loadLibrary("sqlcipher");
        TAG = SqliteCipherDBImpl.class.getSimpleName();
    }

    public SqliteCipherDBImpl() {
    }

    @Override // com.bytedance.security.dbcipher.SqliteCipherDB
    public int getVersion() {
        return 1;
    }

    @Override // com.bytedance.security.dbcipher.SqliteCipherDB
    public SQLiteDatabase openOrCreateDatabase(Context r2, String r3, String r4, CipherConfig r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L27;
        if (r3 == null) goto L27;
        if (r3.isEmpty() == true) goto L27;
        if (r4 == null) goto L27;
        if (r5 == null) goto L27;
        String r6 = r1.getDatabasePath(r3).getPath();
        if (r5.isPlaintext() != true) goto L15;
        return SQLiteDatabase.openOrCreateDatabase(r6, null);
    L15:
        if (DBCipherUtils.passPhraseCheck(r4) == 0) goto L28;
        String r7 = TAG;
        String r8 = "Invalid passPhrase.";
    L17:
        Log.e(r7, r8);
        return null;
    L28:
    L30:
        return SQLiteDatabase.openOrCreateDatabase(r6, r4, null, null, DBCipherUtils.getHookByCipherConfig(r5));
    L23:
        e = move-exception;
        String r9 = TAG;
        StringBuilder r10 = new StringBuilder().append("SQLException: ");
        String r11 = e.getMessage();
    L25:
        Log.e(r9, r10.append(r11).toString());
        return null;
    L21:
        e = move-exception;
        r9 = TAG;
        r10 = new StringBuilder().append("other Exception: ");
        r11 = e.getMessage();
    L27:
        r7 = TAG;
        r8 = "Invalid params.";
        goto L17
    }
}
