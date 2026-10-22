package hb;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.utils.i;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f9266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f9268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f9269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SQLiteStatement f9270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SQLiteStatement f9271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SQLiteStatement f9272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SQLiteStatement f9273h;

    public g(SQLiteDatabase r10, String r11, String[] r12, String[] r13) {
        this.f9266a = r10;
        this.f9267b = r11;
        this.f9268c = r12;
        this.f9269d = r13;
    }

    public SQLiteStatement a() {
        if (this.f9272g != null) goto L17;
        String r10 = i.g(this.f9267b, this.f9269d);
        SQLiteStatement r11 = this.f9266a.compileStatement(r10);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f9272g != null) goto L9;
        this.f9272g = r11;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.f9272g == r11) goto L17;
        r11.close();
    L17:
        return this.f9272g;
    }

    public SQLiteStatement b() {
        if (this.f9273h != null) goto L17;
        String r10 = i.i(this.f9267b, this.f9268c, this.f9269d);
        SQLiteStatement r11 = this.f9266a.compileStatement(r10);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f9273h != null) goto L9;
        this.f9273h = r11;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.f9273h == r11) goto L17;
        r11.close();
    L17:
        return this.f9273h;
    }

    public SQLiteStatement c() {
        if (this.f9270e != null) goto L17;
        String r10 = i.h("INSERT INTO ", this.f9267b, this.f9268c);
        SQLiteStatement r11 = this.f9266a.compileStatement(r10);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f9270e != null) goto L9;
        this.f9270e = r11;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.f9270e == r11) goto L17;
        r11.close();
    L17:
        return this.f9270e;
    }

    public SQLiteStatement d() {
        if (this.f9271f != null) goto L17;
        String r10 = i.j(this.f9267b, this.f9268c, this.f9269d);
        SQLiteStatement r11 = this.f9266a.compileStatement(r10);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f9271f != null) goto L9;
        this.f9271f = r11;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.f9271f == r11) goto L17;
        r11.close();
    L17:
        return this.f9271f;
    }
}
