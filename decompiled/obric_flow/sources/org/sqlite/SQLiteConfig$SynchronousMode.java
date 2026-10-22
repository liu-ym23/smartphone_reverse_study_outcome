package org.sqlite;

import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$SynchronousMode extends Enum<SQLiteConfig$SynchronousMode> implements e {
    public static final SQLiteConfig$SynchronousMode FULL = null;
    public static final SQLiteConfig$SynchronousMode NORMAL = null;
    public static final SQLiteConfig$SynchronousMode OFF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$SynchronousMode[] f21048a = null;

    static {
        SQLiteConfig$SynchronousMode r5 = new SQLiteConfig$SynchronousMode("OFF", 0);
        OFF = r5;
        SQLiteConfig$SynchronousMode r10 = new SQLiteConfig$SynchronousMode("NORMAL", 1);
        NORMAL = r10;
        SQLiteConfig$SynchronousMode r11 = new SQLiteConfig$SynchronousMode("FULL", 2);
        FULL = r11;
        f21048a = new SQLiteConfig$SynchronousMode[]{r5, r10, r11};
    }

    public static SQLiteConfig$SynchronousMode valueOf(String r5) {
        return (SQLiteConfig$SynchronousMode) Enum.valueOf(SQLiteConfig$SynchronousMode.class, r5);
    }

    public static SQLiteConfig$SynchronousMode[] values() {
        return (SQLiteConfig$SynchronousMode[]) f21048a.clone();
    }

    @Override // av.e
    public String getValue() {
        return name();
    }
}
