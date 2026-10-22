package ea;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static boolean f;
    public static boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f16804h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static c f16805i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f16806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f16808c;
    public SQLiteDatabase d;
    public String e;

    static {
        f16804h = new String[]{"_id", "data"};
        f16805i = null;
    }

    public static c b(Context r5) {
        if (f16805i != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f16805i != null) goto L11;
        c r10 = new c();     // Catch: Throwable -> L9
        r10.f16806a = new HashMap(2);     // Catch: Throwable -> L9
        r10.f16807b = 0;     // Catch: Throwable -> L9
        r10.e = "INSERT INTO monitor_log(aid,type,type2,time,data) VALUES ( ?, ?, ?, ?, ?)";     // Catch: Throwable -> L9
        r10.f16808c = r5;     // Catch: Throwable -> L9
        r10.d = a.e(r5).getWritableDatabase();     // Catch: Throwable -> L9
        f16805i = r10;     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f16805i;
    }

    public static void f(Cursor r5) {
        if (r5 == null) goto L10;
        if (r5.isClosed() == true) goto L11;
        r5.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final void a(int r5, String r10) {
        HashMap r11 = this.f16806a;
        if (r11.containsKey(r10) == true) goto L6;
        if (r5 <= 0) goto L6;
        r11.put(r10, Integer.valueOf(r5));
        return;
    L6:
        r11.put(r10, Integer.valueOf(Math.max(0, ((Integer) r11.get(r10)).intValue() + r5)));
    }

    public final synchronized int c() {
        monitor-enter(this);
        SQLiteDatabase r5 = this.d;     // Catch: Throwable -> L16
        int r10 = -1;
        if (r5 != null) goto L6;
    L22:
        monitor-exit(this);
        return -1;
    L6:
        if (r5.isOpen() == false) goto L22;
        Cursor r11 = null;
        r11 = this.d.rawQuery("SELECT count(*) FROM monitor_log", null);     // Catch: Throwable -> L13 Exception -> L26
        if (r11.moveToNext() == false) goto L15;
        r10 = r11.getInt(0);     // Catch: Throwable -> L13 Exception -> L26
    L13:
        th = move-exception;
        f(r11);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L15:
        f(r11);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r10;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized int d(String r5) {
        monitor-enter(this);
        SQLiteDatabase r10 = this.d;     // Catch: Throwable -> L16
        int r11 = -1;
        if (r10 != null) goto L6;
    L22:
        monitor-exit(this);
        return -1;
    L6:
        if (r10.isOpen() == false) goto L22;
        Cursor r12 = null;
        r12 = this.d.rawQuery("SELECT count(*) FROM monitor_log WHERE aid = ?", new String[]{r5});     // Catch: Throwable -> L13 Exception -> L26
        if (r12.moveToNext() == false) goto L15;
        r11 = r12.getInt(0);     // Catch: Throwable -> L13 Exception -> L26
    L13:
        th = move-exception;
        f(r12);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L15:
        f(r12);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r11;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized void e(String r10, LinkedList r11) {
        monitor-enter(this);
    L33:
        th = move-exception;
        throw th;
    L4:
        if (this.d != null) goto L6;
    L42:
        monitor-exit(this);
        return;
    L6:
        if (r11.size() != 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L42;
        g();     // Catch: Throwable -> L33
        this.d.beginTransaction();     // Catch: Throwable -> L33
        SQLiteStatement r12 = this.d.compileStatement(this.e);     // Catch: Throwable -> L18 Exception -> L20
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L18 Exception -> L20
    L14:
        if (r13.hasNext() == false) goto L29;
        ga.a r14 = (ga.a) r13.next();     // Catch: Throwable -> L18 Exception -> L20
        r12.bindString(1, String.valueOf(r14.f17075b));     // Catch: Throwable -> L18 Exception -> L20
        String r15 = r14.f17076c;     // Catch: Throwable -> L18 Exception -> L20
        if (r15 != null) goto L22;
        r15 = "";
    L22:
        r12.bindString(2, r15);     // Catch: Throwable -> L18 Exception -> L20
        String r16 = r14.d;     // Catch: Throwable -> L18 Exception -> L20
        if (r16 != null) goto L25;
        r16 = "";
    L25:
        r12.bindString(3, r16);     // Catch: Throwable -> L18 Exception -> L20
        r12.bindLong(4, r14.f);     // Catch: Throwable -> L18 Exception -> L20
        String r17 = r14.e;     // Catch: Throwable -> L18 Exception -> L20
        if (r17 != null) goto L28;
        r17 = "";
    L28:
        r12.bindString(5, r17);     // Catch: Throwable -> L18 Exception -> L20
        r12.executeInsert();     // Catch: Throwable -> L18 Exception -> L20
        goto L14
    L29:
        this.d.setTransactionSuccessful();     // Catch: Throwable -> L18 Exception -> L20
        a(r11.size(), r10);     // Catch: Throwable -> L18 Exception -> L20
        SQLiteDatabase r18 = this.d;     // Catch: Throwable -> L33
    L31:
        r18.endTransaction();     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        this.d.endTransaction();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        r18 = this.d;     // Catch: Throwable -> L33
        goto L31
    L8:
        r5 = false;
        goto L9
    }

    public final synchronized void g() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (g == true) goto L25;
        g = true;     // Catch: Throwable -> L22
        if (c() < 5000) goto L25;
        monitor-enter(this);     // Catch: Throwable -> L22
        SQLiteDatabase r5 = this.d;     // Catch: Throwable -> L12
        if (r5 != null) goto L35;
        monitor-exit(this);     // Catch: Throwable -> L22
        goto L25
    L35:
        r5.execSQL(" DELETE FROM monitor_log WHERE _id IN (SELECT _id FROM monitor_log ORDER BY _id ASC LIMIT 500)");     // Catch: Throwable -> L12 Exception -> L14
    L16:
        monitor-exit(this);     // Catch: Throwable -> L22
        goto L25
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L25:
        if (f == true) goto L30;
        f = true;     // Catch: Throwable -> L22
        File r10 = this.f16808c.getDatabasePath("psdkmon.db");     // Catch: Throwable -> L22 Exception -> L34
        if (r10.exists() == false) goto L30;
        r10.delete();     // Catch: Throwable -> L22 Exception -> L34
    L30:
        monitor-exit(this);
    }
}
