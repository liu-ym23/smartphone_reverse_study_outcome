package com.obric.memorydata.database.manager;

import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdinstall.Api;
import com.google.gson.JsonObject;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\u0015\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\bJ\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u00020\b*\u00020 2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0014\u0010#\u001a\u00020$*\u00020 2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0014\u0010%\u001a\u00020\u0005*\u00020 2\u0006\u0010\"\u001a\u00020\bH\u0002J\f\u0010&\u001a\u00020\b*\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/manager/ScreenObservationRawObservationMigration90;", "", "<init>", "()V", "LEGACY_STATE_FINISHED", "", "MIGRATION_LIMIT", "SOURCE_SCREENSHOT", "", "STATE_WAIT_MEDIA", "STATE_PENDING", "CLIENT_STATE_NONE", "TARGET_SLM_AUTO_MEMORY_PRO", "SELECT_SQL", "getSELECT_SQL", "()Ljava/lang/String;", "INSERT_SQL", "getINSERT_SQL", "migrate", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "deviceId", "prepareRowsForMigration", "", "Lcom/obric/memorydata/database/manager/RawObservationMigrationRow;", "sources", "Lcom/obric/memorydata/database/manager/LegacyScreenObservationForMigration90;", "prepareRowsForMigration$database_obricRelease", "toRawObservationRow", AILabCheckPermissionTask.KEY_SOURCE, "readLegacyScreenObservation", "cursor", "Landroid/database/Cursor;", "stringValue", "columnName", "longValue", "", "intValue", "cleaned", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f9584a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9585b = null;
    private static final String c = null;

    static {
        f9584a = new n();
        f9585b = "SELECT timestamp, trigger_type, app_name, package_name, screenshot_path,\n    image_tos_key, location, location_state, movement_state, click_detail,\n    scroll_detail, retry_time, logId, activity_name, target\nFROM (\n    SELECT * FROM ScreenObservation\n    WHERE state != 2\n        AND target != 'slmAutoMemoryPro'\n    ORDER BY id DESC\n    LIMIT 1000\n)\nORDER BY id ASC";
        c = "INSERT INTO RawObservation (\n    device_id, source, timestamp, span_start, span_end, payload, meta,\n    state, client_state, retry_count, last_error_code\n) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    private n() {
    }

    private final e a(Cursor r21) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r21, Cursor.class, "com.obric.memorydata.plugin");
        return new e(b(r1, "timestamp"), a(r1, "trigger_type"), a(r1, Api.KEY_APP_NAME), a(r1, "package_name"), a(r1, "screenshot_path"), a(r1, "image_tos_key"), a(r1, "location"), a(r1, "location_state"), a(r1, "movement_state"), a(r1, "click_detail"), a(r1, "scroll_detail"), c(r1, "retry_time"), a(r1, "logId"), a(r1, "activity_name"), a(r1, TypedValues.AttributesType.S_TARGET));
    }

    private final String a(Cursor r3, String r4) {
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        int r6 = r5.getColumnIndexOrThrow(r4);
        if (r5.isNull(r6) == false) goto L6;
        return "";
    L6:
        String r7 = r5.getString(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        return a(r7);
    }

    private final String a(String r2) {
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (Intrinsics.areEqual(r1, "null") == false) goto L6;
        return "";
    L6:
        return r1;
    }

    private final long b(Cursor r2, String r3) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        int r4 = r1.getColumnIndexOrThrow(r3);
        if (r1.isNull(r4) == false) goto L6;
        return 0;
    L6:
        return r1.getLong(r4);
    }

    private final int c(Cursor r2, String r3) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        int r4 = r1.getColumnIndexOrThrow(r3);
        if (r1.isNull(r4) == false) goto L6;
        return 0;
    L6:
        return r1.getInt(r4);
    }

    public final int a(SupportSQLiteDatabase r7, String r8) {
        SupportSQLiteDatabase r9 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "database");
        Intrinsics.checkNotNullParameter(r8, "deviceId");
        r9.beginTransaction();
        List<e> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r9.query(f9585b), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
    L7:
        if (r4.moveToNext() == false) goto L9;
        r0.add(f9584a.a(r4));     // Catch: Throwable -> L17
        goto L7
    L9:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L22
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r0, r8), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L22
        int r10 = 0;
    L12:
        if (r6.hasNext() == false) goto L14;
        m r1 = (m) ZeusTransformUtils.preCheckCast(r6.next(), m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r9.execSQL(c, r1.a());     // Catch: Throwable -> L22
        r10 = r10 + 1;     // Catch: Throwable -> L22
        goto L12
    L14:
        r9.setTransactionSuccessful();     // Catch: Throwable -> L22
        r9.endTransaction();
        return r10;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r9.endTransaction();
        throw th;
    }

    public final m a(e r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r19, "deviceId");
        String r1 = a(r18.e());
        String r0 = a(r18.f());
        Long r6 = null;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L7:
        Long r4 = Long.valueOf(r18.a());
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        r6 = r4;
    L13:
        if (r6 == null) goto L15;
        long r8 = r6.longValue();
    L16:
        long r9 = r8;
        JsonObject r5 = new JsonObject();
        r5.addProperty("type", "image");
        r5.addProperty("screenshot_path", r1);
        r5.addProperty("image_tos_key", r0);
        String r11 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        JsonObject r10 = new JsonObject();
        n r12 = f9584a;
        r10.addProperty(Api.KEY_APP_NAME, r12.a(r18.c()));
        r10.addProperty("package_name", r12.a(r18.d()));
        r10.addProperty("activity_name", r12.a(r18.n()));
        r10.addProperty("location", r12.a(r18.g()));
        r10.addProperty("location_state", r12.a(r18.h()));
        r10.addProperty("movement_state", r12.a(r18.i()));
        r10.addProperty("trigger_type", r12.a(r18.b()));
        r10.addProperty("click_detail", r12.a(r18.j()));
        r10.addProperty("scroll_detail", r12.a(r18.k()));
        r10.addProperty("log_id", r12.a(r18.m()));
        String r13 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L19;
        String r2 = RawObservationEntity.STATE_WAIT_MEDIA;
    L21:
        return new m(r19, "screenshot", r9, r9, r9, r11, r13, r2, "NONE", RangesKt.coerceAtLeast(r18.l(), 0), 0);
    L19:
        r2 = "PENDING";
        goto L21
    L15:
        r8 = System.currentTimeMillis();
        goto L16
    L10:
        r7 = false;
        goto L11
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return null;
    }

    public final List<m> a(List<e> r9, String r10) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "sources");
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        LinkedHashMap r11 = new LinkedHashMap(r8.size());
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L21;
        e r1 = (e) ZeusTransformUtils.preCheckCast(r12.next(), e.class, "com.obric.memorydata.plugin");
        n r2 = f9584a;
        if (Intrinsics.areEqual(r2.a(r1.o()), "slmAutoMemoryPro") == true) goto L4;
        String r3 = r2.a(r1.e());
        String r4 = r2.a(r1.f());
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r5) == false) goto L11;
        r5 = r4;
    L11:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L4;
        f r7 = new f(r1.a(), r6);
        e r13 = (e) ZeusTransformUtils.preCheckCast(r11.get(r7), e.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L20;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(r13.f()), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L4;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L4;
    L20:
        ((Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin")).put(r7, r1);
        goto L4
    L21:
        Collection r14 = r11.values();
        Intrinsics.checkNotNullExpressionValue(r14, "<get-values>(...)");
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L23:
        if (r17.hasNext() == false) goto L28;
        e r18 = (e) ZeusTransformUtils.preCheckCast(r17.next(), e.class, "com.obric.memorydata.plugin");
        n r19 = f9584a;
        Intrinsics.checkNotNull(r18);
        m r20 = r19.a(r18, r10);
        if (r20 == null) goto L23;
        r16.add(r20);
        goto L23
    L28:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    }
}
