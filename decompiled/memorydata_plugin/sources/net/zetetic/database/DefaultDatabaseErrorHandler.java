package net.zetetic.database;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import net.zetetic.database.sqlcipher.SQLiteDatabaseConfiguration;

/* JADX INFO: loaded from: classes6.dex */
public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    public DefaultDatabaseErrorHandler() {
    }

    private void a(String r3) {
        if (r3.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH) == false) goto L5;
        return;
    L5:
        if (r3.trim().length() == 0) goto L16;
        Log.e("DefaultDatabaseErrorHandler", "deleting the database file: " + r3);
        SQLiteDatabase.deleteDatabase(new File(r3));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.w("DefaultDatabaseErrorHandler", "delete failed: " + e.getMessage());
        return;
    }

    @Override // net.zetetic.database.DatabaseErrorHandler
    public void a(SQLiteDatabase r5) {
        Log.e("DefaultDatabaseErrorHandler", "Corruption reported by sqlite on database: " + r5.getPath());
        if (SQLiteDatabase.hasCodec() == false) goto L6;
        return;
    L6:
        if (r5.isOpen() == true) goto L9;
        a(r5.getPath());
        return;
    L9:
        List<Pair<String, String>> r1 = null;
        r1 = r5.getAttachedDbs();     // Catch: Throwable -> L12 SQLiteException -> L30
    L12:
        th = move-exception;
        if (r1 == null) goto L21;
        Iterator<Pair<String, String>> r6 = r1.iterator();
    L19:
        if (r6.hasNext() == false) goto L22;
        a((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin")).second, String.class, "com.obric.memorydata.plugin"));
    L22:
        throw th;
    L21:
        a(r5.getPath());
    L35:
        r5.close();     // Catch: Throwable -> L12 SQLiteException -> L31
    L23:
        if (r1 == null) goto L28;
        Iterator<Pair<String, String>> r7 = r1.iterator();
    L26:
        if (r7.hasNext() == false) goto L38;
        a((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin")).second, String.class, "com.obric.memorydata.plugin"));
        goto L26
    L38:
        return;
    L28:
        a(r5.getPath());
    }
}
