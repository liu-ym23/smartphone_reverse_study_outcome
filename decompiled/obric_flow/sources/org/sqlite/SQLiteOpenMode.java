package org.sqlite;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteOpenMode extends Enum<SQLiteOpenMode> {
    public static final SQLiteOpenMode CREATE = null;
    public static final SQLiteOpenMode DELETEONCLOSE = null;
    public static final SQLiteOpenMode EXCLUSIVE = null;
    public static final SQLiteOpenMode FULLMUTEX = null;
    public static final SQLiteOpenMode MAIN_DB = null;
    public static final SQLiteOpenMode MAIN_JOURNAL = null;
    public static final SQLiteOpenMode MASTER_JOURNAL = null;
    public static final SQLiteOpenMode NOMUTEX = null;
    public static final SQLiteOpenMode OPEN_MEMORY = null;
    public static final SQLiteOpenMode OPEN_URI = null;
    public static final SQLiteOpenMode PRIVATECACHE = null;
    public static final SQLiteOpenMode READONLY = null;
    public static final SQLiteOpenMode READWRITE = null;
    public static final SQLiteOpenMode SHAREDCACHE = null;
    public static final SQLiteOpenMode SUBJOURNAL = null;
    public static final SQLiteOpenMode TEMP_DB = null;
    public static final SQLiteOpenMode TEMP_JOURNAL = null;
    public static final SQLiteOpenMode TRANSIENT_DB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteOpenMode[] f21054a = null;
    public final int flag;

    static {
        SQLiteOpenMode r5 = new SQLiteOpenMode("READONLY", 0, 1);
        READONLY = r5;
        SQLiteOpenMode r10 = new SQLiteOpenMode("READWRITE", 1, 2);
        READWRITE = r10;
        SQLiteOpenMode r11 = new SQLiteOpenMode("CREATE", 2, 4);
        CREATE = r11;
        SQLiteOpenMode r12 = new SQLiteOpenMode("DELETEONCLOSE", 3, 8);
        DELETEONCLOSE = r12;
        SQLiteOpenMode r13 = new SQLiteOpenMode("EXCLUSIVE", 4, 16);
        EXCLUSIVE = r13;
        SQLiteOpenMode r14 = new SQLiteOpenMode("OPEN_URI", 5, 64);
        OPEN_URI = r14;
        SQLiteOpenMode r15 = new SQLiteOpenMode("OPEN_MEMORY", 6, 128);
        OPEN_MEMORY = r15;
        SQLiteOpenMode r16 = new SQLiteOpenMode("MAIN_DB", 7, 256);
        MAIN_DB = r16;
        SQLiteOpenMode r17 = new SQLiteOpenMode("TEMP_DB", 8, 512);
        TEMP_DB = r17;
        SQLiteOpenMode r18 = new SQLiteOpenMode("TRANSIENT_DB", 9, 1024);
        TRANSIENT_DB = r18;
        SQLiteOpenMode r19 = new SQLiteOpenMode("MAIN_JOURNAL", 10, 2048);
        MAIN_JOURNAL = r19;
        SQLiteOpenMode r110 = new SQLiteOpenMode("TEMP_JOURNAL", 11, 4096);
        TEMP_JOURNAL = r110;
        SQLiteOpenMode r111 = new SQLiteOpenMode("SUBJOURNAL", 12, 8192);
        SUBJOURNAL = r111;
        SQLiteOpenMode r20 = new SQLiteOpenMode("MASTER_JOURNAL", 13, 16384);
        MASTER_JOURNAL = r20;
        SQLiteOpenMode r21 = new SQLiteOpenMode("NOMUTEX", 14, 32768);
        NOMUTEX = r21;
        SQLiteOpenMode r22 = new SQLiteOpenMode("FULLMUTEX", 15, 65536);
        FULLMUTEX = r22;
        SQLiteOpenMode r23 = new SQLiteOpenMode("SHAREDCACHE", 16, 131072);
        SHAREDCACHE = r23;
        SQLiteOpenMode r24 = new SQLiteOpenMode("PRIVATECACHE", 17, 262144);
        PRIVATECACHE = r24;
        f21054a = new SQLiteOpenMode[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24};
    }

    public SQLiteOpenMode(String r5, int r10, int r11) {
        super(r5, r10);
        this.flag = r11;
    }

    public static SQLiteOpenMode valueOf(String r5) {
        return (SQLiteOpenMode) Enum.valueOf(SQLiteOpenMode.class, r5);
    }

    public static SQLiteOpenMode[] values() {
        return (SQLiteOpenMode[]) f21054a.clone();
    }
}
