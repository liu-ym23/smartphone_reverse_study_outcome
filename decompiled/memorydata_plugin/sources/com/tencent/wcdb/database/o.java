package com.tencent.wcdb.database;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface o {

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f15867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f15868b;
        public final int c;

        a(T r1, long r2, int r4) {
            this.f15867a = r1;
            this.f15868b = r2;
            this.c = r4;
        }
    }

    void a(SQLiteDatabase r1);

    void a(SQLiteDatabase r1, String r2, int r3, long r4);

    void a(SQLiteDatabase r1, String r2, long r3, boolean r5);

    void a(SQLiteDatabase r1, String r2, long r3, boolean r5, List<a<String>> r6, List<a<StackTraceElement[]>> r7);
}
