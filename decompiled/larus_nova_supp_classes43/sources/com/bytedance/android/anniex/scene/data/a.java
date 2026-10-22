package com.bytedance.android.anniex.scene.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.anniex.scene.core.h;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends SQLiteOpenHelper {
    public static final C0097a a = null;
    public static volatile a b;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.scene.data.a$a, reason: collision with other inner class name */
    public static final class C0097a {
        public C0097a() {
        }
    }

    static {
        a = new C0097a();
    }

    public a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, "scene_recognition.db", null, 9);
    }

    public final Pair<Integer, Integer> a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sceneId");
        Cursor r11 = getReadableDatabase().rawQuery("SELECT count, repeat_count FROM scenes WHERE scene_id = ?", new String[]{r10});
        Cursor r0 = r11;     // Catch: Throwable -> L9
        if (r0.moveToFirst() == false) goto L6;
        Pair<Integer, Integer> r12 = new Pair(Integer.valueOf(r0.getInt(0)), Integer.valueOf(r0.getInt(1)));     // Catch: Throwable -> L9
    L7:
        CloseableKt.closeFinally(r11, null);
        return r12;
    L6:
        r12 = new Pair(0, 0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public final void b(h r15) {
        Intrinsics.checkNotNullParameter(r15, "scene");
        SQLiteDatabase r0 = getWritableDatabase();     // Catch: Exception -> L41
        if (((Number) a(r15.a).getFirst()).intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        long r10 = 0;
        String r11 = "";
        if (r1 == false) goto L25;
        SQLiteStatement r12 = r0.compileStatement(StringsKt.trimIndent("\n            UPDATE scenes SET\n                count = count + 1,\n                timestamp = ?,\n                attach_scene = ?,\n                origin = ?,\n                view_count = ?,\n                client_component = ?,\n                repeat_count = repeat_count + ?\n            WHERE scene_id = ?\n            "));     // Catch: Exception -> L41
        r12.bindLong(1, r15.c);     // Catch: Exception -> L41
        String r13 = r15.e;     // Catch: Exception -> L41
        if (r13 != null) goto L13;
        r13 = "";
    L13:
        r12.bindString(2, r13);     // Catch: Exception -> L41
        r12.bindString(3, r15.d.name());     // Catch: Exception -> L41
        Integer r14 = r15.h;     // Catch: Exception -> L41
        if (r14 == null) goto L16;
        long r16 = r14.intValue();     // Catch: Exception -> L41
    L17:
        r12.bindLong(4, r16);     // Catch: Exception -> L41
        String r17 = r15.g;     // Catch: Exception -> L41
        if (r17 == null) goto L21;
        r11 = r17;
    L21:
        r12.bindString(5, r11);     // Catch: Exception -> L41
        Integer r18 = r15.k;     // Catch: Exception -> L41
        if (r18 == null) goto L24;
        r10 = r18.intValue();     // Catch: Exception -> L41
    L24:
        r12.bindLong(6, r10);     // Catch: Exception -> L41
        r12.bindString(7, r15.a);     // Catch: Exception -> L41
        r12.executeUpdateDelete();     // Catch: Exception -> L41
        r12.close();     // Catch: Exception -> L41
        return;
    L16:
        r16 = 0;
        goto L17
    L25:
        SQLiteStatement r19 = r0.compileStatement(StringsKt.trimIndent("\n            INSERT INTO scenes\n            (scene_id, attach_scene, \n             timestamp, origin, \n             count, view_count,\n             client_component, repeat_count)\n            VALUES (?, ?, ?, ?, 1, ?, ?, ?)\n            "));     // Catch: Exception -> L41
        r19.bindString(1, r15.a);     // Catch: Exception -> L41
        String r20 = r15.e;     // Catch: Exception -> L41
        if (r20 != null) goto L28;
        r20 = "";
    L28:
        r19.bindString(2, r20);     // Catch: Exception -> L41
        r19.bindLong(3, r15.c);     // Catch: Exception -> L41
        r19.bindString(4, r15.d.name());     // Catch: Exception -> L41
        Integer r21 = r15.h;     // Catch: Exception -> L41
        if (r21 == null) goto L31;
        long r22 = r21.intValue();     // Catch: Exception -> L41
    L32:
        r19.bindLong(5, r22);     // Catch: Exception -> L41
        String r23 = r15.g;     // Catch: Exception -> L41
        if (r23 == null) goto L36;
        r11 = r23;
    L36:
        r19.bindString(6, r11);     // Catch: Exception -> L41
        Integer r110 = r15.k;     // Catch: Exception -> L41
        if (r110 == null) goto L39;
        r10 = r110.intValue();     // Catch: Exception -> L41
    L39:
        r19.bindLong(7, r10);     // Catch: Exception -> L41
        r19.executeInsert();     // Catch: Exception -> L41
        r19.close();     // Catch: Exception -> L41
        return;
    L31:
        r22 = 0;
        goto L32
    L7:
        r1 = false;
    L41:
        e = move-exception;
        HybridLogger r24 = HybridLogger.a;
        SceneManager r25 = SceneManager.n;
        HybridLogger.i("AnnieXSceneManager", "saveScene sqlite error: " + e.getMessage(), null, 12);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        r10.execSQL(StringsKt.trimIndent("\n            CREATE TABLE scenes (\n                scene_id TEXT PRIMARY KEY,\n                timestamp INTEGER,\n                origin TEXT,\n                attach_scene TEXT,\n                count INTEGER DEFAULT 1,\n                view_count INTEGER DEFAULT 0,\n                client_component TEXT,\n                repeat_count INTEGER DEFAULT 0\n            )\n        "));     // Catch: Exception -> L5
        r10.execSQL(StringsKt.trimIndent("\n            CREATE TABLE transitions (\n                from_scene_id TEXT,\n                to_scene_id TEXT,\n                count INTEGER DEFAULT 1,\n                avg_duration INTEGER,\n                last_update INTEGER,\n                PRIMARY KEY (from_scene_id, to_scene_id)\n            )\n        "));     // Catch: Exception -> L5
        r10.execSQL(StringsKt.trimIndent("\n            CREATE INDEX idx_from_id ON transitions(from_scene_id)\n        "));     // Catch: Exception -> L5
        r10.execSQL(StringsKt.trimIndent("\n                CREATE TABLE IF NOT EXISTS url_records_table (\n                url TEXT NOT NULL,\n                count REAL NOT NULL,\n                status INTEGER NOT NULL,\n                last_visit_ts INTEGER NOT NULL,\n                PRIMARY KEY (url)\n            )\n            "));     // Catch: Exception -> L5
        r10.execSQL("CREATE INDEX IF NOT EXISTS idx_url_records_count ON url_records_table(count DESC)");     // Catch: Exception -> L5
        r10.execSQL("CREATE INDEX IF NOT EXISTS idx_url_records_status ON url_records_table(status DESC)");     // Catch: Exception -> L5
        r10.execSQL("CREATE INDEX IF NOT EXISTS idx_url_records_last_visit ON url_records_table(last_visit_ts DESC)");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        HybridLogger r0 = HybridLogger.a;
        SceneManager r1 = SceneManager.n;
        HybridLogger.i("AnnieXSceneManager", "onCreate sqlite error: " + e.getMessage(), null, 12);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "db");
        if (r11 >= 8) goto L8;
        r10.execSQL("DROP TABLE IF EXISTS url_records");     // Catch: Exception -> L5
        r10.execSQL(StringsKt.trimIndent("\n                CREATE TABLE IF NOT EXISTS url_records_table (\n                url TEXT NOT NULL,\n                count REAL NOT NULL,\n                status INTEGER NOT NULL,\n                last_visit_ts INTEGER NOT NULL,\n                PRIMARY KEY (url)\n            )\n            "));     // Catch: Exception -> L5
        r10.execSQL("CREATE INDEX IF NOT EXISTS idx_url_records_count ON url_records_table(count DESC)");     // Catch: Exception -> L5
        r10.execSQL("CREATE INDEX IF NOT EXISTS idx_url_records_status ON url_records_table(status DESC)");     // Catch: Exception -> L5
        r10.execSQL("CREATE INDEX IF NOT EXISTS idx_url_records_last_visit ON url_records_table(last_visit_ts DESC)");     // Catch: Exception -> L5
    L5:
        e = move-exception;
        HybridLogger r13 = HybridLogger.a;
        SceneManager r14 = SceneManager.n;
        HybridLogger.i("AnnieXSceneManager", "onUpgrade sqlite error: " + e.getMessage(), null, 12);
        return;
    L8:
        if (r11 >= 9) goto L15;
        r10.execSQL("ALTER TABLE scenes ADD COLUMN repeat_count INTEGER DEFAULT 0");     // Catch: Exception -> L5
        return;
    }
}
