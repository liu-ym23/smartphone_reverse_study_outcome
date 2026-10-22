package org.sqlite;

import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$TransactionMode extends Enum<SQLiteConfig$TransactionMode> implements e {
    public static final SQLiteConfig$TransactionMode DEFERRED = null;

    @Deprecated
    public static final SQLiteConfig$TransactionMode DEFFERED = null;
    public static final SQLiteConfig$TransactionMode EXCLUSIVE = null;
    public static final SQLiteConfig$TransactionMode IMMEDIATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$TransactionMode[] f21050a = null;

    static {
        SQLiteConfig$TransactionMode r5 = new SQLiteConfig$TransactionMode("DEFFERED", 0);
        DEFFERED = r5;
        SQLiteConfig$TransactionMode r10 = new SQLiteConfig$TransactionMode("DEFERRED", 1);
        DEFERRED = r10;
        SQLiteConfig$TransactionMode r11 = new SQLiteConfig$TransactionMode("IMMEDIATE", 2);
        IMMEDIATE = r11;
        SQLiteConfig$TransactionMode r12 = new SQLiteConfig$TransactionMode("EXCLUSIVE", 3);
        EXCLUSIVE = r12;
        f21050a = new SQLiteConfig$TransactionMode[]{r5, r10, r11, r12};
    }

    public static SQLiteConfig$TransactionMode getMode(String r5) {
        if ("DEFFERED".equalsIgnoreCase(r5) == false) goto L7;
        return DEFERRED;
    L7:
        return valueOf(r5.toUpperCase());
    }

    public static SQLiteConfig$TransactionMode valueOf(String r5) {
        return (SQLiteConfig$TransactionMode) Enum.valueOf(SQLiteConfig$TransactionMode.class, r5);
    }

    public static SQLiteConfig$TransactionMode[] values() {
        return (SQLiteConfig$TransactionMode[]) f21050a.clone();
    }

    @Override // av.e
    public String getValue() {
        return name();
    }
}
