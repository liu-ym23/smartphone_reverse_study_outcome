package com.tencent.wcdb.database;

import com.tencent.wcdb.support.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteDebug {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f15846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ArrayList<IOTraceStats> f15847b;

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

    public static class IOTraceStats {
        public String dbName;
        public String journalMode;
        public long lastJournalReadOffset;
        public byte[] lastJournalReadPage;
        public long lastJournalWriteOffset;
        public byte[] lastJournalWritePage;
        public long lastReadOffset;
        public byte[] lastReadPage;
        public long lastWriteOffset;
        public byte[] lastWritePage;
        public long pageCount;
        public long pageSize;
        public String path;

        public IOTraceStats() {
        }

        public String toString() {
            return String.format("[%s | %s] pageSize: %d, pageCount: %d, journal: %s, lastRead: %d, lastWrite: %d, lastJournalRead: %d, lastJournalWrite: %d", new Object[]{this.dbName, this.path, Long.valueOf(this.pageSize), Long.valueOf(this.pageCount), this.journalMode, Long.valueOf(this.lastReadOffset), Long.valueOf(this.lastWriteOffset), Long.valueOf(this.lastJournalReadOffset), Long.valueOf(this.lastJournalWriteOffset)});
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
        SQLiteGlobal.a();
    }

    private SQLiteDebug() {
    }

    static void a(SQLiteConnection r6) {
        f15846a = nativeGetLastErrorLine();     // Catch: RuntimeException -> L7
        ArrayList<IOTraceStats> r0 = new ArrayList();     // Catch: RuntimeException -> L7
        long r2 = r6.a(null);     // Catch: RuntimeException -> L7
        if (r2 == 0) goto L5;
        nativeGetIOTraceStats(r2, r0);     // Catch: RuntimeException -> L7
        r6.a(null);     // Catch: RuntimeException -> L7
    L5:
        f15847b = r0;     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        Log.a("WCDB.SQLiteDebug", "Cannot collect I/O trace statistics: " + e.getMessage());
    }

    static void a(SQLiteDatabase r5) {
        f15846a = nativeGetLastErrorLine();     // Catch: RuntimeException -> L7
        ArrayList<IOTraceStats> r0 = new ArrayList();     // Catch: RuntimeException -> L7
        long r1 = r5.a("collectIoStat", false, false);     // Catch: RuntimeException -> L7
        if (r1 == 0) goto L5;
        nativeGetIOTraceStats(r1, r0);     // Catch: RuntimeException -> L7
    L5:
        r5.a(r1, null);     // Catch: RuntimeException -> L7
        f15847b = r0;     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        Log.a("WCDB.SQLiteDebug", "Cannot collect I/O trace statistics: " + e.getMessage());
    }

    public static final boolean a(long r2) {
        if (r2 <= 300) goto L5;
        return true;
    L5:
        return false;
    }

    private static native void nativeGetIOTraceStats(long r0, ArrayList<IOTraceStats> r2);

    private static native int nativeGetLastErrorLine();

    private static native void nativeGetPagerStats(PagerStats r0);

    private static native void nativeSetIOTraceFlags(int r0);
}
