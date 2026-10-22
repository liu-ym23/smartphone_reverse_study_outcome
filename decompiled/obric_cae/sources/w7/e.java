package w7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f13047b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f13048c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f13049a;

    static {
        f13047b = new String[]{"_id", "value", "type", "timestamp", "retry_count", "retry_time"};
    }

    public e(Context r8) {
        if (r8 != null) goto L8;
        return;
    L8:
        this.f13049a = q7.a.a(r8).getWritableDatabase();     // Catch: Throwable -> L7
        return;
    }

    public static void f(Cursor r8) {
        if (r8 == null) goto L10;
        if (r8.isClosed() == true) goto L11;
        r8.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final synchronized void a(int r8, String r10, long r11) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (c() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r12 = System.currentTimeMillis() - r11;     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r10) == false) goto L11;
        String r13 = "timestamp <= ? ";
        String[] r14 = {String.valueOf(r12)};     // Catch: Throwable -> L19
    L24:
        this.f13049a.delete("queue", r13, r14);     // Catch: Exception -> L15 Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L19
        goto L17
    L11:
        r13 = "(timestamp <= ? OR retry_count > " + r8 + ") and type = ?";     // Catch: Throwable -> L19
        r14 = new String[]{String.valueOf(r12), r10};     // Catch: Throwable -> L19
        goto L24
    }

    public final synchronized long b(String r8, byte[] r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (c() == false) goto L12;
        if (r10 == null) goto L12;
        if (r10.length <= 0) goto L12;
        ContentValues r11 = new ContentValues();     // Catch: Throwable -> L15
        r11.put("value", r10);     // Catch: Throwable -> L15
        r11.put("type", r8);     // Catch: Throwable -> L15
        r11.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L15
        r11.put("retry_count", 0);     // Catch: Throwable -> L15
        r11.put("retry_time", 0L);     // Catch: Throwable -> L15
        long r12 = this.f13049a.insert("queue", null, r11);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r12;
    L12:
        monitor-exit(this);
        return -1;
    }

    public final synchronized boolean c() {
        monitor-enter(this);
        SQLiteDatabase r8 = this.f13049a;     // Catch: Throwable -> L14
        if (r8 == null) goto L11;
        if (r8.isOpen() == false) goto L11;
        monitor-exit(this);
        return true;
    L11:
        monitor-exit(this);
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean d(long r14, boolean r16, long r17, int r19) {
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L5:
        if (c() == true) goto L7;
    L41:
        monitor-exit(this);
        return false;
    L7:
        if (r14 <= 0) goto L41;
        boolean r8 = true;
        String[] r11 = {String.valueOf(r14)};     // Catch: Throwable -> L43
        if (r16 == true) goto L34;
        Cursor r12 = null;
        r12 = this.f13049a.query("queue", new String[]{"timestamp", "retry_count"}, "_id = ?", r11, null, null, null);     // Catch: Throwable -> L27 Exception -> L29
        if (r12.moveToNext() == true) goto L17;
        f(r12);     // Catch: Throwable -> L43
        monitor-exit(this);
        return false;
    L17:
        long r10 = r12.getLong(0);     // Catch: Throwable -> L27 Exception -> L29
        int r13 = r12.getInt(1);     // Catch: Throwable -> L27 Exception -> L29
        long r15 = System.currentTimeMillis();     // Catch: Throwable -> L27 Exception -> L29
        if ((r15 - r10) < r17) goto L20;
    L25:
        f(r12);     // Catch: Throwable -> L43
        goto L34
    L20:
        if (r13 >= r19) goto L25;
        ContentValues r18 = new ContentValues();     // Catch: Throwable -> L27 Exception -> L29
        r18.put("retry_count", Integer.valueOf(r13 + 1));     // Catch: Throwable -> L27 Exception -> L29
        r18.put("retry_time", Long.valueOf(r15));     // Catch: Throwable -> L27 Exception -> L29
        this.f13049a.update("queue", r18, "_id = ?", r11);     // Catch: Throwable -> L27 Exception -> L29
        f(r12);     // Catch: Throwable -> L43
        monitor-exit(this);
        return true;
    L27:
        th = move-exception;
        f(r12);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L29:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L27
        f(r12);     // Catch: Throwable -> L43
        r8 = false;
    L34:
        if (r8 == true) goto L49;
        monitor-exit(this);
        return false;
    L49:
        this.f13049a.delete("queue", "_id = ?", r11);     // Catch: Throwable -> L46
    L37:
        monitor-exit(this);
        return false;
    }

    public final synchronized void e() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (c() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f13049a.execSQL("DROP TABLE IF EXISTS queue");     // Catch: Exception -> L9 Throwable -> L13
        this.f13049a.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L13
        goto L11
    }
}
