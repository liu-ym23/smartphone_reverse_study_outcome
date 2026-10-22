package net.zetetic.database.sqlcipher;

import android.util.Log;
import android.util.Printer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteDebug {
    public static final boolean DEBUG_LOG_SLOW_QUERIES = false;
    public static final boolean DEBUG_SQL_LOG = false;
    public static final boolean DEBUG_SQL_STATEMENTS = false;
    public static final boolean DEBUG_SQL_TIME = false;

    public static class DbStats {
        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String r5, long r6, long r8, int r10, int r11, int r12, int r13) {
            this.dbName = r5;
            this.pageSize = r8 / 1024;
            this.dbSize = (r6 * r8) / 1024;
            this.lookaside = r10;
            this.cache = r11 + "/" + r12 + "/" + r13;
        }
    }

    public static class PagerStats {
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;

        public PagerStats() {
        }
    }

    static {
        DEBUG_SQL_LOG = Log.isLoggable("SQLiteLog", 2);
        DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
        DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);
    }

    private SQLiteDebug() {
    }

    public static void dump(Printer r5, String[] r6) {
        Printer r7 = (Printer) ZeusTransformUtils.wrapperContextForParams(r5, Printer.class, "com.obric.memorydata.plugin");
        int r0 = r6.length;
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        if (r6[r1].equals("-v") == false) goto L7;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        SQLiteDatabase.dumpAll(r7, r2);
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats r0 = new PagerStats();
        nativeGetPagerStats(r0);
        r0.dbStats = SQLiteDatabase.getDbStats();
        return r0;
    }

    private static native void nativeGetPagerStats(PagerStats r0);

    public static final boolean shouldLogSlowQuery(long r2) {
        int r0 = Integer.parseInt(System.getProperty("db.log.slow_query_threshold", "10000"));
        if (r0 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r2 < r0) goto L7;
        return true;
    }
}
