package com.obric.memorydata.middleware.a;

import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.EntityProvider;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.database.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J6\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/synthesis/SynthesisSources;", "", "<init>", "()V", "tables", "", "", "resolve", "Lorg/json/JSONObject;", "uid", "type", "entityId", ObricMemoryConstants.KEY_PACKAGE_NAME, "read", "column", OaidModel.KEY_ID, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f11598b = null;

    static {
        f11597a = new b();
        f11598b = MapsKt.mapOf(new Pair[]{TuplesKt.to("episodic_memory", "ShortMemory"), TuplesKt.to("note", "RawNoteEntity"), TuplesKt.to("schedule", "RawScheduleEntity"), TuplesKt.to("photo", "RawPhotoEntity"), TuplesKt.to("file", "RawFileEntity"), TuplesKt.to("message", "RawMessageEntity"), TuplesKt.to("contact", "RawContactEntity"), TuplesKt.to(NotificationCompat.CATEGORY_ALARM, "RawAlarmEntity"), TuplesKt.to("recording", "RawRecordingEntity")});
    }

    private b() {
    }

    private final JSONObject a(String r17, String r18, String r19, Object r20, String r21) {
        a.f11596a.b(r17);
        String r2 = (String) ZeusTransformUtils.preCheckCast(f11598b.get(r18), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r18, "episodic_memory") == false) goto L8;
        String r5 = "user";
    L10:
        if (Intrinsics.areEqual(r5, "user") == false) goto L12;
        String r6 = MemoryDbEngine.USER_LOGIC_DB_NAME;
    L13:
        SupportSQLiteDatabase r7 = c.f11648a.b(r6);
        if (r7 == null) goto L50;
        if (Intrinsics.areEqual(r18, "photo") == false) goto L19;
        String r8 = "coalesce(caption, '') || char(10) || coalesce(ocr, '')";
    L22:
        String r9 = "";
        if (r21 == null) goto L25;
        String r10 = " AND packageName = ?";
    L27:
        if (r21 == null) goto L29;
        Object[] r14 = {r20, r21};
    L30:
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r7.query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT entityId, substr(" + r8 + ", 1, 8001), modifyTime, createTime, packageName FROM " + r2 + " WHERE " + r19 + " = ?" + r10 + " LIMIT 1", r14), SupportSQLiteQuery.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r4.moveToFirst() == true) goto L35;
        JSONObject r1 = null;
    L41:
        CloseableKt.closeFinally(r3, null);
        a.f11596a.b(r17);
        return r1;
    L35:
        JSONObject r11 = new JSONObject().put(EntityProvider.KEY_ENTITY_TYPE, r18).put("entity_id", r4.getString(0));     // Catch: Throwable -> L43
        String r12 = r4.getString(1);     // Catch: Throwable -> L43
        if (r12 == null) goto L39;
        r9 = r12;
    L39:
        r1 = r11.put(Params.CONTENT, r9).put("modify_time", r4.getLong(2)).put("create_time", r4.getLong(3)).put("source_scope", r5).put("package_name", r4.getString(4)).put("partial", Intrinsics.areEqual(r18, "recording"));     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L29:
        r14 = new Object[]{r20};
        goto L30
    L25:
        r10 = "";
        goto L27
    L19:
        if (Intrinsics.areEqual(r18, "recording") == false) goto L21;
        r8 = "summary";
        goto L22
    L21:
        r8 = "fullContent";
        goto L22
    L50:
        throw new IllegalStateException("DATABASE_UNAVAILABLE".toString());
    L12:
        r6 = MemoryDbEngine.ENCRYPT_DB_NAME;
        goto L13
    L8:
        r5 = "global";
        goto L10
    }

    public final JSONObject a(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "uid");
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "entityId");
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return a(r8, r9, "entityId", r10, r11);
    }
}
