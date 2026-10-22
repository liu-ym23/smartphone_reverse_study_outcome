package net.zetetic.database.sqlcipher;

/* JADX INFO: loaded from: classes6.dex */
public interface SQLiteDatabaseHook {
    void postKey(SQLiteConnection r1);

    void preKey(SQLiteConnection r1);
}
