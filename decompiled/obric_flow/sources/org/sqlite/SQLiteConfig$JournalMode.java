package org.sqlite;

import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$JournalMode extends Enum<SQLiteConfig$JournalMode> implements e {
    public static final SQLiteConfig$JournalMode DELETE = null;
    public static final SQLiteConfig$JournalMode MEMORY = null;
    public static final SQLiteConfig$JournalMode OFF = null;
    public static final SQLiteConfig$JournalMode PERSIST = null;
    public static final SQLiteConfig$JournalMode TRUNCATE = null;
    public static final SQLiteConfig$JournalMode WAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$JournalMode[] f21045a = null;

    static {
        SQLiteConfig$JournalMode r5 = new SQLiteConfig$JournalMode("DELETE", 0);
        DELETE = r5;
        SQLiteConfig$JournalMode r10 = new SQLiteConfig$JournalMode("TRUNCATE", 1);
        TRUNCATE = r10;
        SQLiteConfig$JournalMode r11 = new SQLiteConfig$JournalMode("PERSIST", 2);
        PERSIST = r11;
        SQLiteConfig$JournalMode r12 = new SQLiteConfig$JournalMode("MEMORY", 3);
        MEMORY = r12;
        SQLiteConfig$JournalMode r13 = new SQLiteConfig$JournalMode("WAL", 4);
        WAL = r13;
        SQLiteConfig$JournalMode r14 = new SQLiteConfig$JournalMode("OFF", 5);
        OFF = r14;
        f21045a = new SQLiteConfig$JournalMode[]{r5, r10, r11, r12, r13, r14};
    }

    public static SQLiteConfig$JournalMode valueOf(String r5) {
        return (SQLiteConfig$JournalMode) Enum.valueOf(SQLiteConfig$JournalMode.class, r5);
    }

    public static SQLiteConfig$JournalMode[] values() {
        return (SQLiteConfig$JournalMode[]) f21045a.clone();
    }

    @Override // av.e
    public String getValue() {
        return name();
    }
}
