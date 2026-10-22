package com.obric.capabilitykit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fJ&\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f0\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u001bJ\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010#\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0014H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityDBHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "db", "Landroid/database/sqlite/SQLiteDatabase;", "kotlin.jvm.PlatformType", "convertActionType", "Lcom/obric/capabilitykit/entity/ActionType;", EventBody.KEY_VALUE, "", "deleteBulkEntityHistory", "", "indexIds", "", "", "deleteEarliestEntityHistory", "entityId", "entityType", "", "actionType", "deleteEntityHistory", "indexId", "deleteMatchedEntityHistory", "", "getEarliestEntityHistory", "Lcom/obric/capabilitykit/entity/EntityHistoryDao;", "getUnprocessedEntityHistory", "insertBulkEntityHistory", "Lkotlin/Pair;", "daoList", "insertEntityHistory", "dao", "onCreate", "onUpgrade", "oldVersion", "newVersion", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class n extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7596b = null;
    private static final String c = "EntityDBHelper";
    private static final String d = "EntityHistory.db";
    private static final int e = 1;
    private static final String f = "EntityHistory";
    private static final String g = "id";
    private static final String h = "entity_id";
    private static final String i = "entity_data";
    private static final String j = "entity_type";
    private static final String k = "entity_action";
    private static n l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f7597a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityDBHelper$Companion;", "", "()V", "COLUMN_ACTION", "", "COLUMN_ENTITY_DATA", "COLUMN_ENTITY_ID", "COLUMN_ENTITY_TYPE", "COLUMN_ID", "DATABASE_NAME", "DATABASE_VERSION", "", "TABLE_NAME", "TAG", "instance", "Lcom/obric/capabilitykit/entity/EntityDBHelper;", "getInstance", "context", "Landroid/content/Context;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final n a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            n r0 = n.a();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = n.a();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new n(r4, null);     // Catch: Throwable -> L10
            a r5 = n.f7596b;     // Catch: Throwable -> L10
            n.a(r0);     // Catch: Throwable -> L10
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
        f7596b = new a(null);
    }

    private n(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), d, null, 1);
        this.f7597a = getWritableDatabase();
    }

    public /* synthetic */ n(Context r2, DefaultConstructorMarker r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    private final m a(String r1) {
        return m.f7594b.a(r1);
    }

    public static final /* synthetic */ n a() {
        return l;
    }

    public static final /* synthetic */ void a(n r0) {
        l = r0;
    }

    private final boolean a(long r6) {
        int r5 = this.f7597a.delete(f, "id = ?", new String[]{String.valueOf(r6)});
        if (r5 > 0) goto L5;
        Logger.INSTANCE.e(c, "delete error: " + r6);
    L5:
        if (r5 <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    private final o b(String r22, int r23, String r24) {
        Cursor r1 = this.f7597a.query(f, new String[]{"id", h, i, "entity_type", k}, "entity_id = ? AND entity_type = ? AND entity_action = ?", new String[]{r22, String.valueOf(r23), r24}, null, null, "id ASC", "1");
        if (r1.moveToFirst() == false) goto L7;
        String r2 = r1.getString(r1.getColumnIndexOrThrow(k));
        Intrinsics.checkNotNullExpressionValue(r2, "cursor.getString(cursor.…UMN_ACTION\n            ))");
        m r20 = a(r2);
        if (r20 == null) goto L7;
        long r15 = r1.getLong(r1.getColumnIndexOrThrow("id"));
        String r3 = r1.getString(r1.getColumnIndexOrThrow(h));
        Intrinsics.checkNotNullExpressionValue(r3, "cursor.getString(cursor.…rThrow(COLUMN_ENTITY_ID))");
        String r4 = r1.getString(r1.getColumnIndexOrThrow(i));
        Intrinsics.checkNotNullExpressionValue(r4, "cursor.getString(cursor.…hrow(COLUMN_ENTITY_DATA))");
        o r0 = new o(r15, r3, r4, r1.getInt(r1.getColumnIndexOrThrow("entity_type")), r20);
    L8:
        r1.close();
        return r0;
    L7:
        r0 = null;
        goto L8
    }

    public final void a(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        this.f7597a.delete(f, "entity_id = ? AND entity_type = ?", new String[]{r3, String.valueOf(r4)});
    }

    public final boolean a(o r5) {
        Intrinsics.checkNotNullParameter(r5, "dao");
        SQLiteDatabase r4 = getWritableDatabase();
        ContentValues r0 = new ContentValues();
        r0.put(h, r5.h());
        r0.put(i, r5.g());
        r0.put("entity_type", Integer.valueOf(r5.j()));
        r0.put(k, r5.f().b());
        long r1 = r4.insert(f, null, r0);
        if (r1 != (-1)) goto L5;
        Logger.INSTANCE.e(c, "insert error: " + r5);
    L5:
        if (r1 == (-1)) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean a(String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "entityId");
        Intrinsics.checkNotNullParameter(r5, "actionType");
        o r6 = b(r3, r4, r5);
        if (r6 == null) goto L5;
        this.f7597a.delete(f, "id = ?", new String[]{String.valueOf(r6.i())});
    L5:
        return true;
    }

    public final boolean a(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "indexIds");
        this.f7597a.beginTransaction();
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L16
    L4:
        boolean r2 = true;
    L6:
        if (r8.hasNext() == false) goto L13;
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L16
        if (r2 == false) goto L12;
        if (a(r3) == true) goto L4;
    L12:
        r2 = false;
        goto L6
    L13:
        this.f7597a.setTransactionSuccessful();     // Catch: Throwable -> L16
        this.f7597a.endTransaction();
        return r2;
    L16:
        th = move-exception;
        this.f7597a.endTransaction();
        throw th;
    }

    public final List<o> b() {
        ArrayList r6 = new ArrayList();
        Long r0 = null;
    L4:
        if (r0 == null) goto L6;
        String[] r15 = {String.valueOf(r0.longValue())};
        String r14 = "id < ?";
    L7:
        String r1 = "id";
        Cursor r11 = this.f7597a.query(f, new String[]{"id", h, i, "entity_type", k}, r14, r15, null, null, "id DESC", "300");
        Long r12 = null;
    L43:
        if (r11.moveToNext() == false) goto L16;
        String r13 = r11.getString(r11.getColumnIndexOrThrow(k));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        Intrinsics.checkNotNullExpressionValue(r13, "cursor.getString(\n      …                        )");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        m r28 = a(r13);     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        r12 = Long.valueOf(r11.getLong(r11.getColumnIndexOrThrow(r1)));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        if (r28 == null) goto L15;
        long r23 = r12.longValue();     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        String r16 = r11.getString(r11.getColumnIndexOrThrow(h));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        Intrinsics.checkNotNullExpressionValue(r16, "cursor.getString(cursor.…rThrow(COLUMN_ENTITY_ID))");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        String r17 = r11.getString(r11.getColumnIndexOrThrow(i));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        Intrinsics.checkNotNullExpressionValue(r17, "cursor.getString(cursor.…hrow(COLUMN_ENTITY_DATA))");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        r6.add(new o(r23, r16, r17, r11.getInt(r11.getColumnIndexOrThrow("entity_type")), r28));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
    L15:
        r1 = r1;
        goto L43
    L16:
        r11.close();
        r0 = r12;
        boolean r8 = false;
    L32:
        if (r8 == true) goto L36;
        if (r0 != null) goto L4;
    L36:
        return CollectionsKt.reversed(r6);
    L19:
        e = move-exception;
        Logger r7 = Logger.INSTANCE;     // Catch: Throwable -> L17
        r7.w(c, "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L17
        Log.w(c, "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L17
        int r2 = this.f7597a.delete(f, null, null);     // Catch: Throwable -> L17 Exception -> L25
        r7.w(c, "EntityHistory cleared, deleted=" + r2);     // Catch: Throwable -> L17 Exception -> L25
        Log.w(c, "EntityHistory cleared, deleted=" + r2);     // Catch: Throwable -> L17 Exception -> L25
    L30:
        r6.clear();     // Catch: Throwable -> L17
        r11.close();
        r0 = r12;
        r8 = true;
    L25:
        e = e;
    L29:
        Logger.INSTANCE.w(c, "EntityHistory clear failed", e);     // Catch: Throwable -> L17
        Log.w(c, "EntityHistory clear failed", e);     // Catch: Throwable -> L17
    L27:
        e = e;
    L17:
        th = move-exception;
        r11.close();
        throw th;
    L6:
        r14 = null;
        r15 = null;
        goto L7
    }

    public final Pair<Boolean, List<o>> b(List<o> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "daoList");
        ArrayList r0 = new ArrayList();
        this.f7597a.beginTransaction();
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L20
    L5:
        if (r10.hasNext() == false) goto L17;
        o r2 = (o) ZeusTransformUtils.preCheckCast(r10.next(), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        ContentValues r3 = new ContentValues();     // Catch: Throwable -> L20
        r3.put(h, r2.h());     // Catch: Throwable -> L20
        r3.put(i, r2.g());     // Catch: Throwable -> L20
        r3.put("entity_type", Integer.valueOf(r2.j()));     // Catch: Throwable -> L20
        r3.put(k, r2.f().b());     // Catch: Throwable -> L20
        if (this.f7597a.insert(f, null, r3) == (-1)) goto L5;
        r0.add(r2);     // Catch: Throwable -> L20
        goto L5
    L17:
        this.f7597a.setTransactionSuccessful();     // Catch: Throwable -> L20
        this.f7597a.endTransaction();
        return new Pair(Boolean.valueOf(!r0.isEmpty()), r0);
    L20:
        th = move-exception;
        this.f7597a.endTransaction();
        throw th;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        Intrinsics.checkNotNullParameter(r1, "db");
        r1.execSQL(StringsKt.trimIndent("\n            CREATE TABLE EntityHistory (\n                id INTEGER PRIMARY KEY AUTOINCREMENT,\n                entity_id TEXT,\n                entity_data TEXT,\n                entity_type INTEGER,\n                entity_action TEXT\n            )\n        "));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "db");
        Logger.INSTANCE.i(c, "oldVersion: " + r5 + "  newVersion:" + r6);
        if (r5 != r6) goto L5;
        return;
    L5:
        int r3 = r5;
    L6:
        if (r3 >= r6) goto L8;
        Logger.INSTANCE.i(c, "upgrade database form version " + r5 + " to version " + r6);
        r3 = r3 + 1;
        goto L6
    }
}
