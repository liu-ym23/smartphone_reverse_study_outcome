package org.sqlite;

import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$LockingMode extends Enum<SQLiteConfig$LockingMode> implements e {
    public static final SQLiteConfig$LockingMode EXCLUSIVE = null;
    public static final SQLiteConfig$LockingMode NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$LockingMode[] f21046a = null;

    static {
        SQLiteConfig$LockingMode r5 = new SQLiteConfig$LockingMode("NORMAL", 0);
        NORMAL = r5;
        SQLiteConfig$LockingMode r10 = new SQLiteConfig$LockingMode("EXCLUSIVE", 1);
        EXCLUSIVE = r10;
        f21046a = new SQLiteConfig$LockingMode[]{r5, r10};
    }

    public static SQLiteConfig$LockingMode valueOf(String r5) {
        return (SQLiteConfig$LockingMode) Enum.valueOf(SQLiteConfig$LockingMode.class, r5);
    }

    public static SQLiteConfig$LockingMode[] values() {
        return (SQLiteConfig$LockingMode[]) f21046a.clone();
    }

    @Override // av.e
    public String getValue() {
        return name();
    }
}
