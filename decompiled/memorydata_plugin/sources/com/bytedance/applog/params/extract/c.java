package com.bytedance.applog.params.extract;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.applog.log.q;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\rJ \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\rJ \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/applog/params/extract/ParamsExtractDao;", "", "context", "Landroid/content/Context;", "helper", "Lcom/bytedance/applog/params/extract/ParamsExtractDbHelper;", "(Landroid/content/Context;Lcom/bytedance/applog/params/extract/ParamsExtractDbHelper;)V", "deleteHistoryExcludeCurrentSessionStmt", "Landroid/database/sqlite/SQLiteStatement;", "insertStmt", "deleteHistoryExcludeCurrentSession", "", ObricMemoryConstants.KEY_SESSION_ID, "", "ensureStatements", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "get", "Lorg/json/JSONObject;", "cpId", "getByIds", "", "ids", "", "getRecord", "Lcom/bytedance/applog/params/extract/ParamsExtractDao$ParamsExtractRecord;", "insert", "", "json", "listHistoryIdsByCurrentSession", "ParamsExtractRecord", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f1771b;
    private SQLiteStatement c;
    private SQLiteStatement d;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/applog/params/extract/ParamsExtractDao$ParamsExtractRecord;", "", "cpId", "", ObricMemoryConstants.KEY_SESSION_ID, "json", "Lorg/json/JSONObject;", "createdAt", "", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;J)V", "getCpId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getJson", "()Lorg/json/JSONObject;", "getSessionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f1773b;
        private final JSONObject c;
        private final long d;

        public a(String r2, String r3, JSONObject r4, long r5) {
            Intrinsics.checkNotNullParameter(r2, "cpId");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_SESSION_ID);
            Intrinsics.checkNotNullParameter(r4, "json");
            this.f1772a = r2;
            this.f1773b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final JSONObject a() {
            return this.c;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f1772a, r8.f1772a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f1773b, r8.f1773b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r8.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f1772a.hashCode() * 31) + this.f1773b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "ParamsExtractRecord(cpId=" + this.f1772a + ", sessionId=" + this.f1773b + ", json=" + this.c + ", createdAt=" + this.d + ')';
        }
    }

    public c(Context r3, e r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "helper");
        this.f1770a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.f1771b = r4;
    }

    private final void a(SQLiteDatabase r2) {
        if (this.c != null) goto L6;
        this.c = r2.compileStatement("INSERT OR ABORT INTO cp_entries(cp_id, session_id, json, created_at) VALUES(?, ?, ?, ?)");
    L6:
        if (this.d != null) goto L9;
        this.d = r2.compileStatement("DELETE FROM cp_entries WHERE session_id!=?");
        return;
    }

    public final List<String> a(String r13) {
        Intrinsics.checkNotNullParameter(r13, ObricMemoryConstants.KEY_SESSION_ID);
        SQLiteDatabase r1 = this.f1771b.getReadableDatabase();
        ArrayList r12 = new ArrayList();
        Cursor r11 = null;
        r11 = r1.query("cp_entries", new String[]{"cp_id"}, "session_id!=?", new String[]{r13}, null, null, null);     // Catch: Throwable -> L11 Exception -> L13
    L5:
        if (r11.moveToNext() == false) goto L8;
        r12.add(r11.getString(r11.getColumnIndexOrThrow("cp_id")));     // Catch: Throwable -> L11 Exception -> L13
    L8:
        if (r11 == null) goto L18;
    L27:
        r11.close();     // Catch: Exception -> L22
    L18:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    L11:
        th = move-exception;
        if (r11 != null) goto L25;
    L21:
        throw th;
    L25:
        r11.close();     // Catch: Exception -> L23
    L13:
        e = move-exception;
        q.a().c(d.a(), "DB listIdsBySession failed for session=" + r13, new Object[]{e});     // Catch: Throwable -> L11
        if (r11 == null) goto L18;
        goto L27
    }

    public final Map<String, JSONObject> a(List<String> r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "ids");
        if (r0.isEmpty() == true) goto L5;
        SQLiteDatabase r2 = this.f1771b.getReadableDatabase();
        Cursor r3 = null;
        HashMap r4 = new HashMap(r0.size());
        String r7 = "SELECT cp_id, json FROM cp_entries WHERE cp_id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(ParamsExtractDao$getByIds$placeholders$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 30, null) + ')';     // Catch: Throwable -> L23 Exception -> L25
        Object[] r1 = ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);     // Catch: Throwable -> L23 Exception -> L25
        if (r1 == null) goto L22;
        r3 = r2.rawQuery(r7, (String[]) ZeusTransformUtils.preCheckCast(r1, String[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23 Exception -> L25
    L11:
        if (r3.moveToNext() == false) goto L18;
        String r5 = r3.getString(r3.getColumnIndexOrThrow("cp_id"));     // Catch: Throwable -> L23 Exception -> L25
        JSONObject r8 = new JSONObject(r3.getString(r3.getColumnIndexOrThrow("json")));     // Catch: Exception -> L15 Throwable -> L23
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15 Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r5, "cpId");     // Catch: Exception -> L15 Throwable -> L23
        r6.put(r5, r8);     // Catch: Exception -> L15 Throwable -> L23
    L15:
        e = move-exception;
        q.a().c(d.a(), "Invalid JSON for cp_id=" + r5 + " in batch getByIds, skipping", new Object[]{e});     // Catch: Throwable -> L23 Exception -> L25
        goto L11
    L18:
        if (r3 == null) goto L30;
    L38:
        r3.close();     // Catch: Exception -> L34
    L30:
        return (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L23 Exception -> L25
    L25:
        e = move-exception;
        q.a().c(d.a(), "DB batch query failed in getByIds", new Object[]{e});     // Catch: Throwable -> L23
        if (0 == 0) goto L30;
    L23:
        th = move-exception;
        if (0 != 0) goto L40;
    L33:
        throw th;
    L40:
        r3.close();     // Catch: Exception -> L35
        goto L33
    L5:
        return MapsKt.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int b(String r10) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_SESSION_ID);
        SQLiteDatabase r0 = this.f1771b.getWritableDatabase();
        Intrinsics.checkNotNullExpressionValue(r0, "db");
        a(r0);
        r0.beginTransaction();
        SQLiteStatement r3 = this.d;     // Catch: Throwable -> L12 Exception -> L14
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L12 Exception -> L14
        r3.bindString(1, r10);     // Catch: Throwable -> L12 Exception -> L14
        int r4 = r3.executeUpdateDelete();     // Catch: Throwable -> L12 Exception -> L14
        r0.setTransactionSuccessful();     // Catch: Exception -> L10 Throwable -> L12
        r0.endTransaction();     // Catch: Exception -> L27
    L6:
        SQLiteStatement r9 = this.d;     // Catch: Exception -> L28
        SQLiteStatement r11 = r9;
        c this = r9;
        if (r9 == null) goto L36;
    L8:
        r11.clearBindings();     // Catch: Exception -> L28
        this = r11;
    L36:
    L10:
        e = e;
    L16:
        q.a().c(d.a(), "DB deleteHistoryByCurrentSession failed for session=" + r10, new Object[]{e});     // Catch: Throwable -> L12
        r0.endTransaction();     // Catch: Exception -> L29
    L18:
        SQLiteStatement r12 = this.d;     // Catch: Exception -> L28
        r11 = r12;
        this = r12;
        if (r12 == null) goto L36;
    L12:
        th = move-exception;
        r0.endTransaction();     // Catch: Exception -> L30
    L32:
        SQLiteStatement r13 = this.d;     // Catch: Exception -> L31
        if (r13 == null) goto L48;
        r13.clearBindings();     // Catch: Exception -> L31
        throw th;
    L48:
        throw th;
    L49:
        throw th;
    L14:
        e = e;
        r4 = 0;
    L21:
        return r4;
    }

    public boolean insert(String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "cpId");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r8, "json");
        long r0 = System.currentTimeMillis();
        SQLiteDatabase r2 = this.f1771b.getWritableDatabase();
        Intrinsics.checkNotNullExpressionValue(r2, "db");
        a(r2);
        SQLiteStatement r5 = this.c;
        Intrinsics.checkNotNull(r5);
        boolean r3 = false;
        r5.bindString(1, r6);     // Catch: Throwable -> L9 Exception -> L11
        r5.bindString(2, r7);     // Catch: Throwable -> L9 Exception -> L11
        r5.bindString(3, r8);     // Catch: Throwable -> L9 Exception -> L11
        r5.bindLong(4, r0);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r5.executeInsert() == (-1)) goto L21;
        r3 = true;
    L21:
        r5.clearBindings();     // Catch: Exception -> L17
    L14:
        return r3;
    L9:
        th = move-exception;
        r5.clearBindings();     // Catch: Exception -> L18
    L16:
        throw th;
    L11:
        e = move-exception;
        q.a().c(d.a(), "DB insert failed for cp_id=" + r6, new Object[]{e});     // Catch: Throwable -> L9
        goto L21
    }
}
