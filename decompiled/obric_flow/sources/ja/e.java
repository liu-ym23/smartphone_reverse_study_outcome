package ja;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f18304b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e f18305c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f18306a;

    static {
        f18304b = new String[]{"_id", "value", "type", "timestamp", "retry_count", "retry_time"};
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

    public final synchronized void a(int r5, String r10, long r11) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (c() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r12 = System.currentTimeMillis() - r11;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r10) == false) goto L13;
        String r13 = "timestamp <= ? ";
        String[] r14 = {String.valueOf(r12)};     // Catch: Throwable -> L11
    L24:
        this.f18306a.delete("queue", r13, r14);     // Catch: Throwable -> L11 Exception -> L16
    L18:
        monitor-exit(this);
        return;
    L16:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L11
        goto L18
    L13:
        r13 = "(timestamp <= ? OR retry_count > " + r5 + ") and type = ?";     // Catch: Throwable -> L11
        r14 = new String[]{String.valueOf(r12), r10};     // Catch: Throwable -> L11
        goto L24
    }

    public final synchronized long b(String r5, byte[] r10) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (c() == false) goto L14;
        if (r10 == null) goto L14;
        if (r10.length <= 0) goto L14;
        ContentValues r11 = new ContentValues();     // Catch: Throwable -> L12
        r11.put("value", r10);     // Catch: Throwable -> L12
        r11.put("type", r5);     // Catch: Throwable -> L12
        r11.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L12
        r11.put("retry_count", 0);     // Catch: Throwable -> L12
        r11.put("retry_time", 0L);     // Catch: Throwable -> L12
        long r12 = this.f18306a.insert("queue", null, r11);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r12;
    L14:
        monitor-exit(this);
        return -1;
    }

    public final synchronized boolean c() {
        monitor-enter(this);
        SQLiteDatabase r5 = this.f18306a;     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        if (r5.isOpen() == false) goto L13;
        monitor-exit(this);
        return true;
    L13:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean d(long r13, long r15, int r17, boolean r18) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (c() == true) goto L7;
    L42:
        monitor-exit(this);
        return false;
    L7:
        if (r13 <= 0) goto L42;
        String[] r5 = {String.valueOf(r13)};     // Catch: Throwable -> L17
        if (r18 == true) goto L47;
        Cursor r11 = null;
        SQLiteDatabase r10 = this.f18306a;     // Catch: Throwable -> L27 Exception -> L29
        r11 = r10.query("queue", new String[]{"timestamp", "retry_count"}, "_id = ?", r5, null, null, null);     // Catch: Throwable -> L27 Exception -> L29
        if (r11.moveToNext() == true) goto L19;
        f(r11);     // Catch: Throwable -> L17
        monitor-exit(this);
        return false;
    L19:
        long r12 = r11.getLong(0);     // Catch: Throwable -> L27 Exception -> L29
        int r14 = r11.getInt(1);     // Catch: Throwable -> L27 Exception -> L29
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L27 Exception -> L29
        if ((r16 - r12) < r15) goto L22;
    L31:
        f(r11);     // Catch: Throwable -> L17
        goto L47
    L22:
        if (r14 >= r17) goto L31;
        ContentValues r19 = new ContentValues();     // Catch: Throwable -> L27 Exception -> L29
        r19.put("retry_count", Integer.valueOf(r14 + 1));     // Catch: Throwable -> L27 Exception -> L29
        r19.put("retry_time", Long.valueOf(r16));     // Catch: Throwable -> L27 Exception -> L29
        this.f18306a.update("queue", r19, "_id = ?", r5);     // Catch: Throwable -> L27 Exception -> L29
        f(r11);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L27:
        th = move-exception;
        f(null);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L29:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L27
        f(r11);     // Catch: Throwable -> L17
        return false;
    L47:
        this.f18306a.delete("queue", "_id = ?", r5);     // Catch: Throwable -> L46
    L40:
        monitor-exit(this);
        return false;
    }

    public final synchronized void e() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (c() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f18306a.execSQL("DROP TABLE IF EXISTS queue");     // Catch: Throwable -> L9 Exception -> L11
        this.f18306a.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");     // Catch: Throwable -> L9 Exception -> L11
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L9
        goto L13
    }
}
