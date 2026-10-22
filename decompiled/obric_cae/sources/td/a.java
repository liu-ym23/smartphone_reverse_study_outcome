package td;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.Logger;
import r5.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12370b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f12371c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f12372a;

    /* JADX INFO: renamed from: td.a$a, reason: collision with other inner class name */
    public static class C0167a extends SQLiteOpenHelper {
        public C0167a(Context r8) {
            super(r8, "ss_push_log.db", null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r8) {
            r8.execSQL("CREATE TABLE event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT )");     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Logger.e("PushLog", "create db exception " + e);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r8, int r10, int r11) {
        }
    }

    static {
        f12370b = new Object();
    }

    public a(Context r8) {
        this.f12372a = new C0167a(r8).getWritableDatabase();
    }

    public final synchronized void a(b r8) {
        monitor-enter(this);
        SQLiteDatabase r10 = this.f12372a;     // Catch: Throwable -> L20
        if (r10 != null) goto L6;
    L17:
        Logger.w("PushLog", "db not establish and open");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L6:
        if (r10.isOpen() == false) goto L17;
        ContentValues r11 = new ContentValues();     // Catch: Throwable -> L20
        r11.put("category", r8.f12373a);     // Catch: Throwable -> L20
        r11.put(LocationMonitorConst.TAG, r8.f12374b);     // Catch: Throwable -> L20
        if (f.b(r8.f12375c) == true) goto L11;
        r11.put("label", r8.f12375c);     // Catch: Throwable -> L20
    L11:
        r11.put("value", Long.valueOf(r8.f12376d));     // Catch: Throwable -> L20
        r11.put("ext_value", Long.valueOf(r8.f12377e));     // Catch: Throwable -> L20
        if (f.b(r8.f12378f) == true) goto L14;
        r11.put("ext_json", r8.f12378f);     // Catch: Throwable -> L20
    L14:
        this.f12372a.insert("event", null, r11);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
