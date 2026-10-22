package com.ss.android.socialbase.downloader.db;

import ai.j0;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.room.jarjarred.org.antlr.runtime.a;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public class TableStatements {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f15477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f15479c;
    public final String[] d;
    public SQLiteStatement e;
    public SQLiteStatement f;
    public SQLiteStatement g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SQLiteStatement f15480h;

    public TableStatements(SQLiteDatabase r5, String r10, String[] r11, String[] r12) {
        this.f15477a = r5;
        this.f15478b = r10;
        this.f15479c = r11;
        this.d = r12;
    }

    public final SQLiteStatement a() {
        if (this.g != null) goto L27;
        String r5 = this.f15478b;
        String[] r10 = this.d;
        String r11 = a.p("\"", Typography.quote, r5);
        StringBuilder r12 = new StringBuilder("DELETE FROM ");
        r12.append(r11);
        if (r10.length <= 0) goto L13;
        r12.append(" WHERE ");
        int r13 = 0;
    L8:
        if (r13 >= r10.length) goto L13;
        androidx.constraintlayout.motion.widget.a.C(r12, r11, ".\"", r10[r13], "\"=?");
        if (r13 >= (r10.length - 1)) goto L12;
        r12.append(',');
    L12:
        r13 = r13 + 1;
    L13:
        SQLiteStatement r14 = this.f15477a.compileStatement(r12.toString());
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L16:
        if (this.g != null) goto L20;
        this.g = r14;     // Catch: Throwable -> L18
    L20:
        monitor-exit(this);     // Catch: Throwable -> L18
        if (this.g == r14) goto L27;
        r14.close();
    L27:
        return this.g;
    }

    public final SQLiteStatement b() {
        if (this.f15480h != null) goto L31;
        String r5 = this.f15478b;
        String[] r10 = this.f15479c;
        StringBuilder r11 = new StringBuilder("INSERT OR REPLACE INTO ");
        r11.append("\"" + r5 + Typography.quote);
        r11.append(" (");
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L10;
        r11.append(Typography.quote);
        r11.append(r10[r14]);
        r11.append(Typography.quote);
        if (r14 >= (r12 - 1)) goto L9;
        r11.append(',');
    L9:
        r14 = r14 + 1;
        goto L5
    L10:
        r11.append(") VALUES (");
        int r15 = r10.length;
    L11:
        if (r13 >= r15) goto L17;
        if (r13 >= (r15 - 1)) goto L15;
        r11.append("?,");
    L16:
        r13 = r13 + 1;
        goto L11
    L15:
        r11.append('?');
        goto L16
    L17:
        r11.append(')');
        SQLiteStatement r16 = this.f15477a.compileStatement(r11.toString());
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L20:
        if (this.f15480h != null) goto L24;
        this.f15480h = r16;     // Catch: Throwable -> L22
    L24:
        monitor-exit(this);     // Catch: Throwable -> L22
        if (this.f15480h == r16) goto L31;
        r16.close();
    L31:
        return this.f15480h;
    }

    public final SQLiteStatement c() {
        if (this.e != null) goto L31;
        String r5 = this.f15478b;
        String[] r10 = this.f15479c;
        StringBuilder r11 = j0.x("INSERT INTO \"", r5, "\" (");
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L10;
        r11.append(Typography.quote);
        r11.append(r10[r14]);
        r11.append(Typography.quote);
        if (r14 >= (r12 - 1)) goto L9;
        r11.append(',');
    L9:
        r14 = r14 + 1;
        goto L5
    L10:
        r11.append(") VALUES (");
        int r15 = r10.length;
    L11:
        if (r13 >= r15) goto L17;
        if (r13 >= (r15 - 1)) goto L15;
        r11.append("?,");
    L16:
        r13 = r13 + 1;
        goto L11
    L15:
        r11.append('?');
        goto L16
    L17:
        r11.append(')');
        SQLiteStatement r16 = this.f15477a.compileStatement(r11.toString());
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L20:
        if (this.e != null) goto L24;
        this.e = r16;     // Catch: Throwable -> L22
    L24:
        monitor-exit(this);     // Catch: Throwable -> L22
        if (this.e == r16) goto L31;
        r16.close();
    L31:
        return this.e;
    }

    public final SQLiteStatement d() {
        if (this.f != null) goto L34;
        String r5 = this.f15478b;
        String[] r10 = this.f15479c;
        String[] r11 = this.d;
        String r12 = a.p("\"", Typography.quote, r5);
        StringBuilder r13 = j0.x("UPDATE ", r12, " SET ");
        int r14 = 0;
        int r15 = 0;
    L6:
        if (r15 >= r10.length) goto L12;
        String r16 = r10[r15];
        r13.append(Typography.quote);
        r13.append(r16);
        r13.append("\"=?");
        if (r15 >= (r10.length - 1)) goto L10;
        r13.append(',');
    L10:
        r15 = r15 + 1;
        goto L6
    L12:
        if (r11.length <= 0) goto L20;
        r13.append(" WHERE ");
    L15:
        if (r14 >= r11.length) goto L20;
        androidx.constraintlayout.motion.widget.a.C(r13, r12, ".\"", r11[r14], "\"=?");
        if (r14 >= (r11.length - 1)) goto L19;
        r13.append(',');
    L19:
        r14 = r14 + 1;
    L20:
        SQLiteStatement r17 = this.f15477a.compileStatement(r13.toString());
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L23:
        if (this.f != null) goto L27;
        this.f = r17;     // Catch: Throwable -> L25
    L27:
        monitor-exit(this);     // Catch: Throwable -> L25
        if (this.f == r17) goto L34;
        r17.close();
    L34:
        return this.f;
    }
}
