package org.sqlite;

import av.e;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteConfig$DatePrecision extends Enum<SQLiteConfig$DatePrecision> implements e {
    public static final SQLiteConfig$DatePrecision MILLISECONDS = null;
    public static final SQLiteConfig$DatePrecision SECONDS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteConfig$DatePrecision[] f21042a = null;

    static {
        SQLiteConfig$DatePrecision r5 = new SQLiteConfig$DatePrecision("SECONDS", 0);
        SECONDS = r5;
        SQLiteConfig$DatePrecision r10 = new SQLiteConfig$DatePrecision("MILLISECONDS", 1);
        MILLISECONDS = r10;
        f21042a = new SQLiteConfig$DatePrecision[]{r5, r10};
    }

    public static SQLiteConfig$DatePrecision getPrecision(String r5) {
        return valueOf(r5.toUpperCase());
    }

    public static SQLiteConfig$DatePrecision valueOf(String r5) {
        return (SQLiteConfig$DatePrecision) Enum.valueOf(SQLiteConfig$DatePrecision.class, r5);
    }

    public static SQLiteConfig$DatePrecision[] values() {
        return (SQLiteConfig$DatePrecision[]) f21042a.clone();
    }

    @Override // av.e
    public String getValue() {
        return name();
    }
}
