package wia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.obric.capabilitykit.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v extends SQLiteOpenHelper {
    public static final a b = null;
    public static v c;
    public final SQLiteDatabase a;

    public static final class a {
        public a() {
        }

        public final v a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            v r0 = v.c;
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = v.c;     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new v(r2);     // Catch: Throwable -> L10
            v.c = r0;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        b = new a();
    }

    public final void b(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        this.a.delete("EntityHistory", "entity_id = ? AND entity_type = ?", new String[]{r3, String.valueOf(r4)});
    }

    public final void d(List r4) {
        Intrinsics.checkNotNullParameter(r4, "indexIds");
        this.a.beginTransaction();
        Iterator r5 = ((ArrayList) r4).iterator();     // Catch: Throwable -> L16
    L4:
        boolean r0 = true;
    L6:
        if (r5.hasNext() == false) goto L13;
        long r1 = ((Number) r5.next()).longValue();     // Catch: Throwable -> L16
        if (r0 == false) goto L12;
        if (e(r1) == true) goto L4;
    L12:
        r0 = false;
        goto L6
    L13:
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L16
        this.a.endTransaction();
        return;
    L16:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final boolean e(long r7) {
        int r1 = this.a.delete("EntityHistory", "id = ?", new String[]{String.valueOf(r7)});
        if (r1 > 0) goto L5;
        Logger.INSTANCE.e("EntityDBHelper", "delete error: " + r7);
    L5:
        if (r1 > 0) goto L9;
        return false;
    L9:
        return true;
    }

    public final List<w> f() {
        v r1 = this;
        ArrayList r3 = new ArrayList();
        Long r0 = null;
    L4:
        if (r0 == null) goto L6;
        String[] r9 = {String.valueOf(r0.longValue())};
        String r8 = "id < ?";
    L7:
        Cursor r5 = r1.a.query("EntityHistory", new String[]{"id", "entity_id", "entity_data", "entity_type", "entity_action"}, r8, r9, null, null, "id DESC", "300");
        Long r6 = null;
    L49:
        if (r5.moveToNext() == false) goto L14;
        com.obric.capabilitykit.m r26 = a(r5.getString(r5.getColumnIndexOrThrow("entity_action")));     // Catch: Throwable -> L15 SQLiteBlobTooBigException -> L17
        r6 = Long.valueOf(r5.getLong(r5.getColumnIndexOrThrow("id")));     // Catch: Throwable -> L15 SQLiteBlobTooBigException -> L17
        if (r26 == null) goto L49;
        r3.add(new w(r6.longValue(), r5.getString(r5.getColumnIndexOrThrow("entity_id")), r5.getString(r5.getColumnIndexOrThrow("entity_data")), r5.getInt(r5.getColumnIndexOrThrow("entity_type")), r26));     // Catch: Throwable -> L15 SQLiteBlobTooBigException -> L17
    L14:
        r5.close();
        v r4 = this;
        r0 = r6;
        boolean r14 = false;
    L37:
        if (r14 == true) goto L41;
        if (r0 == null) goto L41;
        r1 = r4;
    L41:
        return CollectionsKt.reversed(r3);
    L17:
        e = move-exception;
        Logger r2 = Logger.INSTANCE;     // Catch: Throwable -> L15
        r2.w("EntityDBHelper", "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L15
        r4 = this;
    L47:
        r2.w("EntityDBHelper", "EntityHistory cleared, deleted=" + r4.a.delete("EntityHistory", null, null));     // Catch: Exception -> L26 Throwable -> L28
    L35:
        r3.clear();     // Catch: Throwable -> L28
        r5.close();
        r0 = r6;
        r14 = true;
    L26:
        e = e;
    L34:
        Logger.INSTANCE.w("EntityDBHelper", "EntityHistory clear failed", e);     // Catch: Throwable -> L28
    L30:
        e = e;
    L28:
        th = th;
    L43:
        r5.close();
        throw th;
    L15:
        th = th;
        goto L43
    L6:
        r8 = null;
        r9 = null;
        goto L7
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "db");
        r2.execSQL(StringsKt.trimIndent("\n            CREATE TABLE EntityHistory (\n                id INTEGER PRIMARY KEY AUTOINCREMENT,\n                entity_id TEXT,\n                entity_data TEXT,\n                entity_type INTEGER,\n                entity_action TEXT\n            )\n        "));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "db");
        Logger.INSTANCE.i("EntityDBHelper", "oldVersion: " + r6 + "  newVersion:" + r7);
        if (r6 != r7) goto L5;
        return;
    L5:
        int r8 = r6;
    L6:
        if (r8 >= r7) goto L8;
        Logger.INSTANCE.i("EntityDBHelper", "upgrade database form version " + r6 + " to version " + r7);
        r8 = r8 + 1;
        goto L6
    }

    public v(Context r4) {
        super(r4, "EntityHistory.db", null, 1);
        this.a = getWritableDatabase();
    }

    public static com.obric.capabilitykit.m a(String r4) {
        com.obric.capabilitykit.m.b.getClass();
        Intrinsics.checkNotNullParameter(r4, "value");
        com.obric.capabilitykit.m[] r0 = com.obric.capabilitykit.m.values();
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L9;
        com.obric.capabilitykit.m r2 = r0[r1];
        if (Intrinsics.areEqual(r2.b(), r4) == true) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return r2;
    L9:
        return null;
    }

    public final void c(String r18, int r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "entityId");
        Intrinsics.checkNotNullParameter(r20, "actionType");
        Cursor r2 = this.a.query("EntityHistory", new String[]{"id", "entity_id", "entity_data", "entity_type", "entity_action"}, "entity_id = ? AND entity_type = ? AND entity_action = ?", new String[]{r18, String.valueOf(r19), r20}, null, null, "id ASC", "1");
        if (r2.moveToFirst() == false) goto L7;
        com.obric.capabilitykit.m r10 = a(r2.getString(r2.getColumnIndexOrThrow("entity_action")));
        if (r10 == null) goto L7;
        w r1 = new w(r2.getLong(r2.getColumnIndexOrThrow("id")), r2.getString(r2.getColumnIndexOrThrow("entity_id")), r2.getString(r2.getColumnIndexOrThrow("entity_data")), r2.getInt(r2.getColumnIndexOrThrow("entity_type")), r10);
    L8:
        r2.close();
        if (r1 == null) goto L12;
        this.a.delete("EntityHistory", "id = ?", new String[]{String.valueOf(r1.a)});
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L8
    }
}
