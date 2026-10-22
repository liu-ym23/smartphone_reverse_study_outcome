package ea;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.android.anniex.scene.core.SceneOrigin;
import com.bytedance.android.anniex.scene.core.f;
import com.bytedance.apm.j;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f16795b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16796a;

    public /* synthetic */ a(Context r5, String r10, SQLiteDatabase.CursorFactory r11, int r12, int r13) {
        this.f16796a = r13;
        super(r5, r10, r11, r12);
    }

    public static a e(Context r10) {
        if (f16795b != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f16795b != null) goto L11;
        f16795b = new a(r10, f4.a.i(r10) + "sdkmon_v2.db", null, 1, 0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f16795b;
    }

    private final void f(SQLiteDatabase r5, int r10, int r11) {
    }

    public int b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sceneId");
        Cursor r10 = getReadableDatabase().rawQuery("SELECT count FROM scenes WHERE scene_id = ?", new String[]{r5});
        int r11 = 0;
        if (r10.moveToFirst() == false) goto L9;
        r11 = r10.getInt(0);     // Catch: Throwable -> L7
    L9:
        CloseableKt.closeFinally(r10, null);
        return r11;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    }

    public void d(f r13) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        SQLiteDatabase r5 = getWritableDatabase();
        String r10 = r13.f3391a;
        int r12 = b(r10);
        String r11 = "";
        SceneOrigin r14 = r13.d;
        long r15 = r13.f3393c;
        if (r12 <= 0) goto L10;
        SQLiteStatement r16 = r5.compileStatement(StringsKt.trimIndent("\n            UPDATE scenes SET\n                count = count + 1,\n                timestamp = ?,\n                attach_scene = ?,\n                origin = ?,\n                view_count = ?,\n                client_component = ?\n            WHERE scene_id = ?\n            "));
        r16.bindLong(1, r15);
        r16.bindString(2, "");
        r16.bindString(3, r14.name());
        r16.bindLong(4, r13.f.intValue());
        String r17 = r13.e;
        if (r17 == null) goto L8;
        r11 = r17;
    L8:
        r16.bindString(5, r11);
        r16.bindString(6, r10);
        r16.executeUpdateDelete();
        r16.close();
        return;
    L10:
        SQLiteStatement r18 = r5.compileStatement(StringsKt.trimIndent("\n            INSERT INTO scenes\n            (scene_id, attach_scene, \n             timestamp, origin, \n             count, view_count,\n             client_component)\n            VALUES (?, ?, ?, ?, 1, ?, ?)\n            "));
        r18.bindString(1, r10);
        r18.bindString(2, "");
        r18.bindLong(3, r15);
        r18.bindString(4, r14.name());
        r18.bindLong(5, r13.f.intValue());
        String r19 = r13.e;
        if (r19 == null) goto L14;
        r11 = r19;
    L14:
        r18.bindString(6, r11);
        r18.executeInsert();
        r18.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r5) {
        switch(this.f16796a) {
            case 0: goto L14;
            case 1: goto L6;
            default: goto L12;
        };
    L6:
        Intrinsics.checkNotNullParameter(r5, "db");
        r5.execSQL(StringsKt.trimIndent("\n            CREATE TABLE scenes (\n                scene_id TEXT PRIMARY KEY,\n                timestamp INTEGER,\n                origin TEXT,\n                attach_scene TEXT,\n                count INTEGER DEFAULT 1,\n                view_count INTEGER DEFAULT 0,\n                client_component TEXT\n            )\n        "));
        r5.execSQL(StringsKt.trimIndent("\n            CREATE TABLE transitions (\n                from_scene_id TEXT,\n                to_scene_id TEXT,\n                count INTEGER DEFAULT 1,\n                avg_duration INTEGER,\n                last_update INTEGER,\n                PRIMARY KEY (from_scene_id, to_scene_id)\n            )\n        "));
        r5.execSQL(StringsKt.trimIndent("\n            CREATE INDEX idx_from_id ON transitions(from_scene_id)\n        "));
        return;
    L12:
        r5.execSQL("CREATE TABLE t_battery ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, front Integer, timestamp Integer, type TEXT, status Integer, scene TEXT, accumulation Integer, source TEXT, delete_flag Integer DEFAULT 0, process TEXT, main_process Integer, sid TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )");     // Catch: Exception -> L10
        return;
    L16:
        return;
    L14:
        r5.execSQL("CREATE TABLE monitor_log ( _id Integer PRIMARY KEY AUTOINCREMENT, aid Integer, type VARCHAR, type2 VARCHAR, time Integer, data TEXT, data2 TEXT, data3 TEXT  )");     // Catch: Exception -> L11
        r5.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");     // Catch: Exception -> L11
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r5, int r10, int r11) {
        switch(this.f16796a) {
            case 0: goto L18;
            case 1: goto L11;
            default: goto L5;
        };
    L11:
        Intrinsics.checkNotNullParameter(r5, "db");
        return;
    L18:
        return;
    L5:
        if (j.f3887a == false) goto L8;
        io.reactivex.exceptions.a.m("DBHelper", "Updating table from " + r10 + " to " + r11);
    L8:
        if (r10 >= 2) goto L16;
        r5.execSQL("DROP TABLE IF EXISTS local_monitor_log");     // Catch: Exception -> L13
        r5.execSQL("DROP TABLE IF EXISTS t_apiall");     // Catch: Exception -> L13
        r5.execSQL("DROP TABLE IF EXISTS local_monitor_version");     // Catch: Exception -> L13
        return;
    L17:
        return;
    }
}
