package org.sqlite;

import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$TempStore extends Enum<SQLiteConfig$TempStore> implements e {
    public static final SQLiteConfig$TempStore DEFAULT = null;
    public static final SQLiteConfig$TempStore FILE = null;
    public static final SQLiteConfig$TempStore MEMORY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$TempStore[] f21049a = null;

    static {
        SQLiteConfig$TempStore r5 = new SQLiteConfig$TempStore("DEFAULT", 0);
        DEFAULT = r5;
        SQLiteConfig$TempStore r10 = new SQLiteConfig$TempStore("FILE", 1);
        FILE = r10;
        SQLiteConfig$TempStore r11 = new SQLiteConfig$TempStore("MEMORY", 2);
        MEMORY = r11;
        f21049a = new SQLiteConfig$TempStore[]{r5, r10, r11};
    }

    public static SQLiteConfig$TempStore valueOf(String r5) {
        return (SQLiteConfig$TempStore) Enum.valueOf(SQLiteConfig$TempStore.class, r5);
    }

    public static SQLiteConfig$TempStore[] values() {
        return (SQLiteConfig$TempStore[]) f21049a.clone();
    }

    @Override // av.e
    public String getValue() {
        return name();
    }
}
