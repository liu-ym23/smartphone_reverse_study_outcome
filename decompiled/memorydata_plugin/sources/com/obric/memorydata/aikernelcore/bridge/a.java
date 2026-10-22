package com.obric.memorydata.aikernelcore.bridge;

import android.database.Cursor;
import android.database.SQLException;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.database.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014J\u0018\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J-\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bH\u0002¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/DatabaseBatchExecutor;", "", "<init>", "()V", "MAX_BYTES", "", "MAX_ROWS", "invoke", "", "dbName", "payload", "requireAccount", "", "uid", "execute", "Lorg/json/JSONArray;", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "statements", "requireAccess", "Lkotlin/Function0;", "executeStatement", "statement", "Lorg/json/JSONObject;", ChatMessage.TYPE_QUERY, "sql", "args", "", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)Lorg/json/JSONArray;", "failure", "code", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8466a = null;

    static {
        f8466a = new a();
    }

    private a() {
    }

    private final Object a(SupportSQLiteDatabase r13, JSONObject r14) {
        SupportSQLiteDatabase r15 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r13, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        String r0 = r14.getString("sql");
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        JSONArray r2 = r14.optJSONArray("args");
        if (r2 != null) goto L5;
        r2 = new JSONArray();
    L5:
        int r3 = r2.length();
        Object[] r4 = new Object[r3];
        boolean r5 = false;
        int r6 = 0;
    L6:
        Object r7 = null;
        boolean r9 = true;
        if (r6 >= r3) goto L26;
        Object r10 = r2.opt(r6);
        if (Intrinsics.areEqual(r10, JSONObject.NULL) == false) goto L11;
    L18:
        if (r9 == false) goto L25;
        if (Intrinsics.areEqual(r10, JSONObject.NULL) == true) goto L23;
        r7 = r10;
    L23:
        r4[r6] = r7;
        r6 = r6 + 1;
        goto L6
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L11:
        if (ZeusTransformUtils.instanceOf(r10, String.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r10, Number.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r10, Boolean.class) == true) goto L18;
        r9 = false;
        goto L18
    L26:
        String r8 = r14.getString(MemoryInfoSectionEditActivity.EXTRA_KIND);
        if (Intrinsics.areEqual(r8, ChatMessage.TYPE_QUERY) == false) goto L34;
        if (new Regex("(?is)^SELECT\\s+.*").matches((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L32;
        Object r12 = query(r15, r1, r4);
    L43:
        if (r14.has("expected_rows") == true) goto L45;
    L55:
        return r12;
    L45:
        if (ZeusTransformUtils.instanceOf(r12, JSONArray.class) == false) goto L47;
        int r11 = ((JSONArray) ZeusTransformUtils.preCheckCast(r12, JSONArray.class, "com.obric.memorydata.plugin")).length();
    L49:
        if (r11 != r14.getInt("expected_rows")) goto L51;
        r5 = true;
    L51:
        if (r5 == true) goto L55;
        throw new IllegalStateException("ROW_COUNT_MISMATCH".toString());
    L47:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");
        r11 = ((Integer) ZeusTransformUtils.preCheckCast(r12, Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L49
    L32:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L34:
        if (Intrinsics.areEqual(r8, "execute") == false) goto L66;
        if (new Regex("(?is)^(INSERT|UPDATE|DELETE)\\s+.*").matches((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L64;
        r15.execSQL(r1, r4);
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15.query("SELECT changes()"), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r17 = (Cursor) ZeusTransformUtils.preCheckCast(r16, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        if (r17.moveToFirst() == false) goto L57;
        Integer r18 = Integer.valueOf(r17.getInt(0));     // Catch: Throwable -> L58
        CloseableKt.closeFinally(r16, null);
        r12 = r18;
        goto L43
    L57:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L64:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L66:
        throw new IllegalArgumentException("INVALID_KIND");
    }

    private static final Unit a(String r2, JSONObject r3) {
        a r0 = f8466a;
        Intrinsics.checkNotNull(r2);
        r0.a(r2);
        if (r3.isNull("deadline_ms") == true) goto L13;
        if (System.currentTimeMillis() >= r3.getLong("deadline_ms")) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L13;
        throw new IllegalStateException("Check failed.".toString());
    L7:
        r4 = false;
    L13:
        return Unit.INSTANCE;
    }

    private final void a(String r5) {
        boolean r0 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L9:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L29;
        i r6 = com.obric.memorydata.middleware.database.b.f11646a.a();
        if (r6.c() == false) goto L15;
    L19:
        r0 = false;
    L20:
        if (r0 == false) goto L27;
        if (Intrinsics.areEqual(com.obric.memorydata.middleware.database.b.f11646a.b(MemoryDbEngine.USER_LOGIC_DB_NAME), com.obric.memorydata.middleware.database.b.f11646a.c(MemoryDbEngine.USER_LOGIC_DB_NAME)) == false) goto L25;
        return;
    L25:
        throw new IllegalStateException("Check failed.".toString());
    L27:
        throw new IllegalStateException("Check failed.".toString());
    L15:
        if (Intrinsics.areEqual(r6.b(), r5) == false) goto L19;
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r5) == false) goto L19;
    L29:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        if (UserSettings.INSTANCE.hasAgreePrivacy() == false) goto L9;
        if (AppContext.INSTANCE.isLogin() == false) goto L9;
        r4 = true;
        goto L11
    }

    private final String b(String r3) {
        String r2 = new JSONObject().put("code", 1).put("message", r3).toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }

    public static /* synthetic */ Unit lambda$Kr_Bkapa4fD28BPYGfPza_OEi_o(String r0, JSONObject r1) {
        return a(r0, r1);
    }

    private final JSONArray query(SupportSQLiteDatabase r13, String r14, Object[] r15) {
        SupportSQLiteDatabase r12 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r13, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        JSONArray r16 = new JSONArray();
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r12.query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r14, r15), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r18 = (Cursor) ZeusTransformUtils.preCheckCast(r17, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
    L5:
        if (r18.moveToNext() == false) goto L38;
        boolean r2 = false;
        if (r16.length() >= 200) goto L10;
        boolean r19 = true;
    L12:
        if (r19 == false) goto L37;
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L41
        String[] r4 = r18.getColumnNames();     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r4, "getColumnNames(...)");     // Catch: Throwable -> L41
        Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        int r6 = r5.length;     // Catch: Throwable -> L41
        int r7 = 0;
        int r8 = 0;
    L14:
        if (r7 >= r6) goto L29;
        int r9 = r8 + 1;     // Catch: Throwable -> L41
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5[r7], String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        int r11 = r18.getType(r8);     // Catch: Throwable -> L41
        if (r11 == 0) goto L27;
        if (r11 != 1) goto L19;
        Object r20 = Long.valueOf(r18.getLong(r8));     // Catch: Throwable -> L41
    L28:
        r110.put(r10, r20);     // Catch: Throwable -> L41
        r7 = r7 + 1;     // Catch: Throwable -> L41
        r8 = r9;
        goto L14
    L19:
        if (r11 != 2) goto L21;
        r20 = Double.valueOf(r18.getDouble(r8));     // Catch: Throwable -> L41
        goto L28
    L21:
        if (r11 != 3) goto L24;
        r20 = r18.getString(r8);     // Catch: Throwable -> L41
        goto L28
    L24:
        throw new IllegalArgumentException("BLOB_NOT_SUPPORTED");     // Catch: Throwable -> L41
    L27:
        r20 = JSONObject.NULL;     // Catch: Throwable -> L41
        goto L28
    L29:
        r16.put(r110);     // Catch: Throwable -> L41
        String r111 = r16.toString();     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r111, "toString(...)");     // Catch: Throwable -> L41
        byte[] r112 = r111.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L41
        Intrinsics.checkNotNullExpressionValue(r112, "getBytes(...)");     // Catch: Throwable -> L41
        if (r112.length > 262144) goto L32;
        r2 = true;
    L32:
        if (r2 == true) goto L5;
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L41
    L37:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L41
    L10:
        r19 = false;
        goto L12
    L38:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L41
        CloseableKt.closeFinally(r17, null);
        return r16;
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    }

    public final String a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "dbName");
        Intrinsics.checkNotNullParameter(r6, "payload");
        byte[] r0 = r6.getBytes(Charsets.UTF_8);     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        Intrinsics.checkNotNullExpressionValue(r0, "getBytes(...)");     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        if (r0.length > 262144) goto L7;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        if (SetsKt.setOf(new String[]{MemoryDbEngine.USER_LOGIC_DB_NAME, MemoryDbEngine.ENCRYPT_DB_NAME}).contains(r5) == false) goto L18;
        final JSONObject r2 = new JSONObject(r6);     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        final String r7 = r2.getString("expected_uid");     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        Intrinsics.checkNotNull(r7);     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        a(r7);     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        SupportSQLiteDatabase r8 = com.obric.memorydata.middleware.database.c.f11648a.b(r5);     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        if (r8 == null) goto L16;
        JSONArray r3 = r2.getJSONArray("statements");     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        Intrinsics.checkNotNullExpressionValue(r3, "getJSONArray(...)");     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        String r9 = new JSONObject().put("code", 0).put("message", "").put("data", a(r8, r3, new $$Lambda$a$Kr_Bkapa4fD28BPYGfPza_OEi_o(r7, r2))).toString();     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        Intrinsics.checkNotNull(r9);     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
        return r9;
    L16:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
    L18:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: SQLException -> L21 JSONException -> L22 IllegalStateException -> L23 IllegalArgumentException -> L24
    L7:
        r1 = false;
    L21:
        String r10 = "DATABASE_ERROR";
    L26:
        return b(r10);
    L24:
        r10 = "INVALID_ARGUMENT";
    L23:
        r10 = "ACCESS_OR_STATE_UNAVAILABLE";
    L22:
        r10 = "INVALID_PROTOCOL";
        goto L26
    }

    public final JSONArray a(SupportSQLiteDatabase r8, JSONArray r9, Function0<Unit> r10) {
        SupportSQLiteDatabase r11 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "db");
        Intrinsics.checkNotNullParameter(r9, "statements");
        Intrinsics.checkNotNullParameter(r12, "requireAccess");
        int r0 = r9.length();
        if (1 <= r0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L27;
        r12.invoke();
        r11.beginTransaction();
        r12.invoke();     // Catch: Throwable -> L23
        JSONArray r2 = new JSONArray();     // Catch: Throwable -> L23
        int r3 = r9.length();     // Catch: Throwable -> L23
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L20;
        r12.invoke();     // Catch: Throwable -> L23
        JSONObject r5 = r9.getJSONObject(r4);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r5, "getJSONObject(...)");     // Catch: Throwable -> L23
        r2.put(a(r11, r5));     // Catch: Throwable -> L23
        String r6 = r2.toString();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");     // Catch: Throwable -> L23
        byte[] r7 = r6.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r7, "getBytes(...)");     // Catch: Throwable -> L23
        if (r7.length > 262144) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == false) goto L19;
        r4 = r4 + 1;     // Catch: Throwable -> L23
        goto L11
    L19:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L23
    L15:
        r13 = false;
        goto L16
    L20:
        r12.invoke();     // Catch: Throwable -> L23
        r11.setTransactionSuccessful();     // Catch: Throwable -> L23
        r11.endTransaction();
        return r2;
    L23:
        th = move-exception;
        r11.endTransaction();
        throw th;
    L27:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        if (r0 >= 33) goto L7;
        r1 = true;
        goto L8
    }
}
