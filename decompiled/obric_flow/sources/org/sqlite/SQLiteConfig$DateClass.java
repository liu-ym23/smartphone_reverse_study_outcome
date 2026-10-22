package org.sqlite;

import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$DateClass extends Enum<SQLiteConfig$DateClass> implements e {
    public static final SQLiteConfig$DateClass INTEGER = null;
    public static final SQLiteConfig$DateClass REAL = null;
    public static final SQLiteConfig$DateClass TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$DateClass[] f21041a = null;

    static {
        SQLiteConfig$DateClass r5 = new SQLiteConfig$DateClass("INTEGER", 0);
        INTEGER = r5;
        SQLiteConfig$DateClass r10 = new SQLiteConfig$DateClass("TEXT", 1);
        TEXT = r10;
        SQLiteConfig$DateClass r11 = new SQLiteConfig$DateClass("REAL", 2);
        REAL = r11;
        f21041a = new SQLiteConfig$DateClass[]{r5, r10, r11};
    }

    public static SQLiteConfig$DateClass getDateClass(String r5) {
        return valueOf(r5.toUpperCase());
    }

    public static SQLiteConfig$DateClass valueOf(String r5) {
        return (SQLiteConfig$DateClass) Enum.valueOf(SQLiteConfig$DateClass.class, r5);
    }

    public static SQLiteConfig$DateClass[] values() {
        return (SQLiteConfig$DateClass[]) f21041a.clone();
    }

    @Override // av.e
    public String getValue() {
        return name();
    }
}
