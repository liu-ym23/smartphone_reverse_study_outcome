package org.sqlite;

import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$HexKeyMode extends Enum<SQLiteConfig$HexKeyMode> implements e {
    public static final SQLiteConfig$HexKeyMode NONE = null;
    public static final SQLiteConfig$HexKeyMode SQLCIPHER = null;
    public static final SQLiteConfig$HexKeyMode SSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$HexKeyMode[] f21044a = null;

    static {
        SQLiteConfig$HexKeyMode r5 = new SQLiteConfig$HexKeyMode("NONE", 0);
        NONE = r5;
        SQLiteConfig$HexKeyMode r10 = new SQLiteConfig$HexKeyMode("SSE", 1);
        SSE = r10;
        SQLiteConfig$HexKeyMode r11 = new SQLiteConfig$HexKeyMode("SQLCIPHER", 2);
        SQLCIPHER = r11;
        f21044a = new SQLiteConfig$HexKeyMode[]{r5, r10, r11};
    }

    public static SQLiteConfig$HexKeyMode valueOf(String r5) {
        return (SQLiteConfig$HexKeyMode) Enum.valueOf(SQLiteConfig$HexKeyMode.class, r5);
    }

    public static SQLiteConfig$HexKeyMode[] values() {
        return (SQLiteConfig$HexKeyMode[]) f21044a.clone();
    }

    @Override // av.e
    public String getValue() {
        return name();
    }
}
