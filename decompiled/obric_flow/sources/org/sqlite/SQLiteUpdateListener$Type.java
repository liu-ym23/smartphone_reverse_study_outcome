package org.sqlite;

/* JADX INFO: loaded from: classes3.dex */
public final enum SQLiteUpdateListener$Type extends Enum<SQLiteUpdateListener$Type> {
    public static final SQLiteUpdateListener$Type DELETE = null;
    public static final SQLiteUpdateListener$Type INSERT = null;
    public static final SQLiteUpdateListener$Type UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SQLiteUpdateListener$Type[] f21055a = null;

    static {
        SQLiteUpdateListener$Type r5 = new SQLiteUpdateListener$Type("INSERT", 0);
        INSERT = r5;
        SQLiteUpdateListener$Type r10 = new SQLiteUpdateListener$Type("DELETE", 1);
        DELETE = r10;
        SQLiteUpdateListener$Type r11 = new SQLiteUpdateListener$Type("UPDATE", 2);
        UPDATE = r11;
        f21055a = new SQLiteUpdateListener$Type[]{r5, r10, r11};
    }

    public static SQLiteUpdateListener$Type valueOf(String r5) {
        return (SQLiteUpdateListener$Type) Enum.valueOf(SQLiteUpdateListener$Type.class, r5);
    }

    public static SQLiteUpdateListener$Type[] values() {
        return (SQLiteUpdateListener$Type[]) f21055a.clone();
    }
}
