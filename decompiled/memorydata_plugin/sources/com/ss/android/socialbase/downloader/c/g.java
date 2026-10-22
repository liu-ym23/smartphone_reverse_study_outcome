package com.ss.android.socialbase.downloader.c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.utils.i;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f15332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15333b;
    private final String[] c;
    private final String[] d;
    private SQLiteStatement e;
    private SQLiteStatement f;
    private SQLiteStatement g;
    private SQLiteStatement h;

    public g(SQLiteDatabase r1, String r2, String[] r3, String[] r4) {
        this.f15332a = r1;
        this.f15333b = r2;
        this.c = r3;
        this.d = r4;
    }

    public SQLiteStatement a() {
        if (this.e != null) goto L17;
        String r0 = i.a("INSERT INTO ", this.f15333b, this.c);
        SQLiteStatement r1 = this.f15332a.compileStatement(r0);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.e != null) goto L9;
        this.e = r1;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.e == r1) goto L17;
        r1.close();
    L17:
        return this.e;
    }

    public SQLiteStatement b() {
        if (this.g != null) goto L17;
        String r0 = i.a(this.f15333b, this.d);
        SQLiteStatement r1 = this.f15332a.compileStatement(r0);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.g != null) goto L9;
        this.g = r1;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.g == r1) goto L17;
        r1.close();
    L17:
        return this.g;
    }

    public SQLiteStatement c() {
        if (this.f != null) goto L17;
        String r0 = i.a(this.f15333b, this.c, this.d);
        SQLiteStatement r1 = this.f15332a.compileStatement(r0);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f != null) goto L9;
        this.f = r1;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.f == r1) goto L17;
        r1.close();
    L17:
        return this.f;
    }

    public SQLiteStatement d() {
        if (this.h != null) goto L17;
        String r0 = i.b(this.f15333b, this.c, this.d);
        SQLiteStatement r1 = this.f15332a.compileStatement(r0);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.h != null) goto L9;
        this.h = r1;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.h == r1) goto L17;
        r1.close();
    L17:
        return this.h;
    }
}
