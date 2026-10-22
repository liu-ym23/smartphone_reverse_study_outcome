package androidx.sqlite.db;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteQuery {
    void bindTo(SupportSQLiteProgram r10);

    int getArgCount();

    String getSql();
}
