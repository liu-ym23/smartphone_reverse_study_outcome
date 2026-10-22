package com.bytedance.security.dbcipher;

import android.content.Context;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.security.dbcipher.utils.CipherConfig;
import com.bytedance.security.dbcipher.utils.DBCipherUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.StandardCharsets;
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory;

/* JADX INFO: loaded from: classes2.dex */
public class RoomCipherDBImpl extends RoomCipherDB {
    private static final String TAG = null;

    static {
        System.loadLibrary("sqlcipher");
        TAG = RoomCipherDBImpl.class.getSimpleName();
    }

    public RoomCipherDBImpl() {
    }

    @Override // com.bytedance.security.dbcipher.RoomCipherDB
    public int getVersion() {
        return 1;
    }

    @Override // com.bytedance.security.dbcipher.RoomCipherDB
    public SupportSQLiteOpenHelper.Factory preOpenOrCreateDb(Context r2, String r3, String r4, CipherConfig r5) {
        if (((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")) == null) goto L21;
        if (r3 == null) goto L21;
        if (r3.isEmpty() == true) goto L21;
        if (r4 == null) goto L21;
        if (r5 == null) goto L21;
        if (r5.isPlaintext() != true) goto L15;
        return new SupportOpenHelperFactory(new byte[0]);
    L15:
        if (DBCipherUtils.passPhraseCheck(r4) == 0) goto L20;
        String r1 = TAG;
        String r6 = "Invalid passPhrase.";
    L17:
        Log.e(r1, r6);
        return null;
    L20:
        return new SupportOpenHelperFactory(r4.getBytes(StandardCharsets.UTF_8), DBCipherUtils.getHookByCipherConfig(r5), false);
    L21:
        r1 = TAG;
        r6 = "Invalid params.";
        goto L17
    }
}
