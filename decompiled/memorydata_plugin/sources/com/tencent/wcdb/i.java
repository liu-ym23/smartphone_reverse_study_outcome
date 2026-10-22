package com.tencent.wcdb;

import android.util.Pair;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.o;
import com.tencent.wcdb.support.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import net.zetetic.database.sqlcipher.SQLiteDatabaseConfiguration;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f15872b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f15873a;

    static {
        f15872b = new String[]{"", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1"};
    }

    public i() {
        this.f15873a = false;
    }

    public i(boolean r1) {
        this.f15873a = r1;
    }

    private void a(String r7) {
        if (r7.equalsIgnoreCase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH) == false) goto L5;
        return;
    L5:
        if (r7.trim().length() == 0) goto L21;
        Log.a("WCDB.DefaultDatabaseErrorHandler", "Remove database file: " + r7);
        int r0 = 0;
        if (this.f15873a == true) goto L15;
        File r6 = new File(r7);
        File r2 = new File(r6.getParentFile(), "corrupted");
        if (r2.mkdirs() == true) goto L12;
        Log.a("WCDB.DefaultDatabaseErrorHandler", "Could not create directory for corrupted database. Corruption backup may be unavailable.");
    L12:
        String r8 = r2.getPath() + "/" + r6.getName();
        String[] r1 = f15872b;
        int r3 = r1.length;
    L13:
        if (r0 >= r3) goto L22;
        String r4 = r1[r0];
        a(r7 + r4, r8 + r4);
        r0 = r0 + 1;
        goto L13
    L22:
        return;
    L15:
        String[] r9 = f15872b;
        int r5 = r9.length;
    L16:
        if (r0 >= r5) goto L23;
        b(r7 + r9[r0]);
        r0 = r0 + 1;
        goto L16
    L23:
        return;
    }

    private static boolean a(String r1, String r2) {
        File r0 = new File(r1);
        boolean r3 = r0.renameTo(new File(r2));
        if (r3 == true) goto L5;
        r0.delete();
    L5:
        return r3;
    }

    private static boolean b(String r1) {
        return new File(r1).delete();
    }

    @Override // com.tencent.wcdb.g
    public void a(SQLiteDatabase r5) {
        Log.a("WCDB.DefaultDatabaseErrorHandler", "Corruption reported by sqlite on database: " + r5.l());
        if (r5.k() == true) goto L6;
        a(r5.l());
        return;
    L6:
        List<Pair<String, String>> r1 = null;
        r1 = r5.o();     // Catch: SQLiteException -> L32
    L8:
        o r2 = r5.n();
        if (r2 == null) goto L35;
        r2.a(r5);
    L35:
        r5.close();     // Catch: Throwable -> L18 SQLiteException -> L26
        if (r1 == null) goto L17;
        Iterator<Pair<String, String>> r6 = r1.iterator();
    L15:
        if (r6.hasNext() == false) goto L40;
        a((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin")).second, String.class, "com.obric.memorydata.plugin"));
        goto L15
    L40:
        return;
    L17:
        a(r5.l());
        return;
    L26:
        if (r1 == null) goto L17;
        Iterator<Pair<String, String>> r7 = r1.iterator();
    L29:
        if (r7.hasNext() == false) goto L41;
        a((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin")).second, String.class, "com.obric.memorydata.plugin"));
        goto L29
    L41:
        return;
    L18:
        th = move-exception;
        if (r1 == null) goto L24;
        Iterator<Pair<String, String>> r8 = r1.iterator();
    L22:
        if (r8.hasNext() == false) goto L25;
        a((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r8.next(), Pair.class, "com.obric.memorydata.plugin")).second, String.class, "com.obric.memorydata.plugin"));
    L25:
        throw th;
    L24:
        a(r5.l());
        goto L25
    }
}
