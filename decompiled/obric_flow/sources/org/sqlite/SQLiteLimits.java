package org.sqlite;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteLimits extends Enum<SQLiteLimits> {
    public static final SQLiteLimits SQLITE_LIMIT_ATTACHED = null;
    public static final SQLiteLimits SQLITE_LIMIT_COLUMN = null;
    public static final SQLiteLimits SQLITE_LIMIT_COMPOUND_SELECT = null;
    public static final SQLiteLimits SQLITE_LIMIT_EXPR_DEPTH = null;
    public static final SQLiteLimits SQLITE_LIMIT_FUNCTION_ARG = null;
    public static final SQLiteLimits SQLITE_LIMIT_LENGTH = null;
    public static final SQLiteLimits SQLITE_LIMIT_LIKE_PATTERN_LENGTH = null;
    public static final SQLiteLimits SQLITE_LIMIT_PAGE_COUNT = null;
    public static final SQLiteLimits SQLITE_LIMIT_SQL_LENGTH = null;
    public static final SQLiteLimits SQLITE_LIMIT_TRIGGER_DEPTH = null;
    public static final SQLiteLimits SQLITE_LIMIT_VARIABLE_NUMBER = null;
    public static final SQLiteLimits SQLITE_LIMIT_VDBE_OP = null;
    public static final SQLiteLimits SQLITE_LIMIT_WORKER_THREADS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteLimits[] f21052a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f21053id;

    static {
        SQLiteLimits r5 = new SQLiteLimits("SQLITE_LIMIT_LENGTH", 0, 0);
        SQLITE_LIMIT_LENGTH = r5;
        SQLiteLimits r10 = new SQLiteLimits("SQLITE_LIMIT_SQL_LENGTH", 1, 1);
        SQLITE_LIMIT_SQL_LENGTH = r10;
        SQLiteLimits r11 = new SQLiteLimits("SQLITE_LIMIT_COLUMN", 2, 2);
        SQLITE_LIMIT_COLUMN = r11;
        SQLiteLimits r12 = new SQLiteLimits("SQLITE_LIMIT_EXPR_DEPTH", 3, 3);
        SQLITE_LIMIT_EXPR_DEPTH = r12;
        SQLiteLimits r13 = new SQLiteLimits("SQLITE_LIMIT_COMPOUND_SELECT", 4, 4);
        SQLITE_LIMIT_COMPOUND_SELECT = r13;
        SQLiteLimits r14 = new SQLiteLimits("SQLITE_LIMIT_VDBE_OP", 5, 5);
        SQLITE_LIMIT_VDBE_OP = r14;
        SQLiteLimits r15 = new SQLiteLimits("SQLITE_LIMIT_FUNCTION_ARG", 6, 6);
        SQLITE_LIMIT_FUNCTION_ARG = r15;
        SQLiteLimits r16 = new SQLiteLimits("SQLITE_LIMIT_ATTACHED", 7, 7);
        SQLITE_LIMIT_ATTACHED = r16;
        SQLiteLimits r17 = new SQLiteLimits("SQLITE_LIMIT_LIKE_PATTERN_LENGTH", 8, 8);
        SQLITE_LIMIT_LIKE_PATTERN_LENGTH = r17;
        SQLiteLimits r18 = new SQLiteLimits("SQLITE_LIMIT_VARIABLE_NUMBER", 9, 9);
        SQLITE_LIMIT_VARIABLE_NUMBER = r18;
        SQLiteLimits r19 = new SQLiteLimits("SQLITE_LIMIT_TRIGGER_DEPTH", 10, 10);
        SQLITE_LIMIT_TRIGGER_DEPTH = r19;
        SQLiteLimits r110 = new SQLiteLimits("SQLITE_LIMIT_WORKER_THREADS", 11, 11);
        SQLITE_LIMIT_WORKER_THREADS = r110;
        SQLiteLimits r111 = new SQLiteLimits("SQLITE_LIMIT_PAGE_COUNT", 12, 12);
        SQLITE_LIMIT_PAGE_COUNT = r111;
        f21052a = new SQLiteLimits[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
    }

    public SQLiteLimits(String r5, int r10, int r11) {
        super(r5, r10);
        this.f21053id = r11;
    }

    public static SQLiteLimits valueOf(String r5) {
        return (SQLiteLimits) Enum.valueOf(SQLiteLimits.class, r5);
    }

    public static SQLiteLimits[] values() {
        return (SQLiteLimits[]) f21052a.clone();
    }

    public int getId() {
        return this.f21053id;
    }
}
