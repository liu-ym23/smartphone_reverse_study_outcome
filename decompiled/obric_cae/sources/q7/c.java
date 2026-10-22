package q7;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f10183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f10184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f10185h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static c f10186i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f10189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SQLiteDatabase f10190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10191e;

    static {
        f10185h = new String[]{"_id", "data"};
        f10186i = null;
    }

    public c(Context r8) {
        this.f10187a = new HashMap(2);
        this.f10188b = 0;
        this.f10191e = "INSERT INTO monitor_log(aid,type,type2,time,data) VALUES ( ?, ?, ?, ?, ?)";
        this.f10189c = r8;
        this.f10190d = a.a(r8).getWritableDatabase();
    }

    public static void e(Cursor r8) {
        if (r8 == null) goto L10;
        if (r8.isClosed() == true) goto L11;
        r8.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final void a(int r8, String r10) {
        HashMap r11 = this.f10187a;
        if (r11.containsKey(r10) == true) goto L6;
        if (r8 <= 0) goto L6;
    L7:
        r11.put(r10, Integer.valueOf(r8));
        return;
    L6:
        r8 = Math.max(0, ((Integer) r11.get(r10)).intValue() + r8);
        goto L7
    }

    public final synchronized int b() {
        monitor-enter(this);
        SQLiteDatabase r8 = this.f10190d;     // Catch: Throwable -> L20
        int r10 = -1;
        if (r8 != null) goto L6;
    L18:
        monitor-exit(this);
        return -1;
    L6:
        if (r8.isOpen() == false) goto L18;
        Cursor r11 = null;
        r11 = this.f10190d.rawQuery("SELECT count(*) FROM monitor_log", null);     // Catch: Exception -> L23 Throwable -> L13
        if (r11.moveToNext() == false) goto L12;
        r10 = r11.getInt(0);     // Catch: Exception -> L23 Throwable -> L13
    L13:
        th = move-exception;
        e(r11);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L12:
        e(r11);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r10;
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized int c(String r8) {
        monitor-enter(this);
        SQLiteDatabase r10 = this.f10190d;     // Catch: Throwable -> L21
        int r11 = -1;
        if (r10 != null) goto L6;
    L19:
        monitor-exit(this);
        return -1;
    L6:
        if (r10.isOpen() == false) goto L19;
        Cursor r12 = null;
        r12 = this.f10190d.rawQuery("SELECT count(*) FROM monitor_log WHERE aid = ?", new String[]{r8});     // Catch: Exception -> L24 Throwable -> L14
        if (r12.moveToNext() == false) goto L13;
        r11 = r12.getInt(0);     // Catch: Exception -> L24 Throwable -> L14
        goto L13
    L14:
        th = move-exception;
        e(r12);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L13:
        e(r12);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r11;
    L21:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(String r8, LinkedList r10) {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (this.f10190d != null) goto L6;
    L38:
        monitor-exit(this);
        return;
    L6:
        if (r10.size() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L38;
        f();     // Catch: Throwable -> L40
        this.f10190d.beginTransaction();     // Catch: Throwable -> L40
        SQLiteStatement r12 = this.f10190d.compileStatement(this.f10191e);     // Catch: Throwable -> L28 Exception -> L30
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L28 Exception -> L30
    L14:
        if (r13.hasNext() == false) goto L25;
        s7.a r14 = (s7.a) r13.next();     // Catch: Throwable -> L28 Exception -> L30
        r12.bindString(1, String.valueOf(r14.f12043b));     // Catch: Throwable -> L28 Exception -> L30
        String r15 = r14.f12044c;     // Catch: Throwable -> L28 Exception -> L30
        if (r15 != null) goto L18;
        r15 = "";
    L18:
        r12.bindString(2, r15);     // Catch: Throwable -> L28 Exception -> L30
        String r16 = r14.f12045d;     // Catch: Throwable -> L28 Exception -> L30
        if (r16 != null) goto L21;
        r16 = "";
    L21:
        r12.bindString(3, r16);     // Catch: Throwable -> L28 Exception -> L30
        r12.bindLong(4, r14.f12047f);     // Catch: Throwable -> L28 Exception -> L30
        String r17 = r14.f12046e;     // Catch: Throwable -> L28 Exception -> L30
        if (r17 != null) goto L24;
        r17 = "";
    L24:
        r12.bindString(5, r17);     // Catch: Throwable -> L28 Exception -> L30
        r12.executeInsert();     // Catch: Throwable -> L28 Exception -> L30
        goto L14
    L25:
        this.f10190d.setTransactionSuccessful();     // Catch: Throwable -> L28 Exception -> L30
        a(r10.size(), r8);     // Catch: Throwable -> L28 Exception -> L30
    L33:
        this.f10190d.endTransaction();     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        this.f10190d.endTransaction();     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        goto L33
    L8:
        r11 = false;
        goto L9
    }

    public final synchronized void f() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (f10184g == true) goto L9;
        f10184g = true;     // Catch: Throwable -> L16
        if (b() < 5000) goto L9;
        g();     // Catch: Throwable -> L16
    L9:
        if (f10183f == true) goto L14;
        f10183f = true;     // Catch: Throwable -> L16
        File r8 = this.f10189c.getDatabasePath("psdkmon.db");     // Catch: Exception -> L19 Throwable -> L16
        if (r8.exists() == false) goto L14;
        r8.delete();     // Catch: Exception -> L19 Throwable -> L16
    L14:
        monitor-exit(this);
    }

    public final synchronized void g() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f10190d != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        this.f10190d.execSQL(" DELETE FROM monitor_log WHERE _id IN (SELECT _id FROM monitor_log ORDER BY _id ASC LIMIT 500)");     // Catch: Exception -> L7 Throwable -> L13
    L9:
        monitor-exit(this);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L9
    }
}
