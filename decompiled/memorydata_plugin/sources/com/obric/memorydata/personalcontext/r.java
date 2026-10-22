package com.obric.memorydata.personalcontext;

import android.database.sqlite.SQLiteException;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.dg;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.entity.RecommendComplexQuery;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/SynthesisRecommendationReader;", "", "<init>", "()V", "read", "Lcom/obric/memorydata/sdk/MemoryResponse;", "", "Lcom/obric/memorydata/sdk/entity/RecommendComplexQuery;", "limit", "", "materialize", "uid", "", "card", "Lcom/obric/memorydata/database/entity/MemorySynthesisTaskCard;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f12257a = null;

    static {
        f12257a = new r();
    }

    private r() {
    }

    private final RecommendComplexQuery a(String r19, dg r20) {
        String r0 = "modify_time";
        JSONArray r5 = new JSONArray(r20.e());     // Catch: JSONException -> L52
        int r6 = r5.length();     // Catch: JSONException -> L52
        if (1 <= r6) goto L6;
    L8:
        boolean r7 = false;
    L9:
        if (r7 == true) goto L11;
        return null;
    L11:
        if (r20.b() != 1) goto L61;
        JSONArray r8 = new JSONArray();     // Catch: JSONException -> L52
        int r9 = r5.length();     // Catch: JSONException -> L52
        int r10 = 0;
        boolean r11 = false;
        boolean r12 = false;
    L14:
        if (r10 >= r9) goto L48;
        JSONObject r13 = r5.getJSONObject(r10);     // Catch: JSONException -> L52
        com.obric.memorydata.middleware.a.b r14 = com.obric.memorydata.middleware.a.b.f11597a;     // Catch: JSONException -> L52
        String r15 = r13.getString(com.obric.capabilitykit.EntityProvider.KEY_ENTITY_TYPE);     // Catch: JSONException -> L52
        Intrinsics.checkNotNullExpressionValue(r15, "getString(...)");     // Catch: JSONException -> L52
        String r16 = r13.getString("entity_id");     // Catch: JSONException -> L52
        Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");     // Catch: JSONException -> L52
        String r4 = r13.getString("package_name");     // Catch: JSONException -> L52
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");     // Catch: JSONException -> L52
        JSONObject r17 = r14.a(r19, r15, r16, r4);     // Catch: JSONException -> L52
        if (r17 != null) goto L19;
    L25:
        String r18 = r0;
        boolean r110 = true;
    L26:
        boolean r1 = false;
    L27:
        if (r1 == false) goto L29;
    L32:
        if (r1 == true) goto L34;
        r11 = r110;
    L47:
        r10 = r10 + 1;     // Catch: JSONException -> L52
        r0 = r18;
        goto L14
    L34:
        if (r17 == null) goto L36;
        String r111 = r17.getString(Params.CONTENT);     // Catch: JSONException -> L52
    L37:
        if (r111 != null) goto L40;
        r111 = "";
    L40:
        if (r12 == false) goto L42;
    L45:
        r12 = r110;
    L46:
        r8.put(StringsKt.take(r111, 2000));     // Catch: JSONException -> L52
        goto L47
    L42:
        if (r111.length() > 2000) goto L45;
        r12 = false;
        goto L46
    L36:
        r111 = null;
        goto L37
    L29:
        if (r13.getBoolean("required") == false) goto L32;
        return null;
    L19:
        if (Intrinsics.areEqual(r17.optString("source_scope"), r13.getString("source_scope")) == false) goto L25;
        if (r17.optLong(r0) != r13.getLong(r0)) goto L25;
        String r112 = r17.optString(Params.CONTENT);     // Catch: JSONException -> L52
        Intrinsics.checkNotNullExpressionValue(r112, "optString(...)");     // Catch: JSONException -> L52
        r18 = r0;
        boolean r2 = StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.memorydata.plugin"));     // Catch: JSONException -> L52
        r110 = true;
        if ((!r2) == false) goto L26;
        r1 = true;
        goto L27
    L48:
        JSONObject r3 = new JSONObject().put(OaidModel.KEY_ID, r20.a()).put("task_id", r20.a()).put("schema_version", r20.b()).put("create_time", r20.f()).put("source_missing", r11).put("source_truncated", r12);     // Catch: JSONException -> L52
        String r21 = r20.c();     // Catch: JSONException -> L52
        String r22 = r20.d();     // Catch: JSONException -> L52
        String r23 = r8.toString();     // Catch: JSONException -> L52
        Intrinsics.checkNotNullExpressionValue(r23, "toString(...)");     // Catch: JSONException -> L52
        String r24 = r3.toString();     // Catch: JSONException -> L52
        Intrinsics.checkNotNullExpressionValue(r24, "toString(...)");     // Catch: JSONException -> L52
        return new RecommendComplexQuery(r21, r22, r23, r24);
    L61:
        return null;
    L6:
        if (r6 >= 9) goto L8;
        r7 = true;
    L53:
        return null;
    }

    public final MemoryResponse<List<RecommendComplexQuery>> a(int r13) {
        boolean r1 = false;
        if (1 <= r13) goto L5;
    L7:
        if (r1 == false) goto L9;
        String r2 = AppContext.INSTANCE.getUserId();
        if (com.obric.memorydata.middleware.a.a.f11596a.a(r2) == false) goto L14;
        ZoneId r3 = ZoneId.systemDefault();     // Catch: IllegalStateException -> L30 SQLiteException -> L31
        LocalDate r4 = LocalDate.now(r3);     // Catch: IllegalStateException -> L30 SQLiteException -> L31
        List<dg> r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemorySynthesisDao().readyCards(RangesKt.coerceAtMost(r13 * 4, 200), r4.atStartOfDay(r3).toInstant().toEpochMilli(), r4.plusDays(1).atStartOfDay(r3).toInstant().toEpochMilli());     // Catch: IllegalStateException -> L30 SQLiteException -> L31
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: IllegalStateException -> L30 SQLiteException -> L31
        int r6 = 100000;
        Iterator<dg> r8 = r5.iterator();     // Catch: IllegalStateException -> L30 SQLiteException -> L31
    L17:
        if (r8.hasNext() == false) goto L26;
        RecommendComplexQuery r9 = a(r2, (dg) ZeusTransformUtils.preCheckCast(r8.next(), dg.class, "com.obric.memorydata.plugin"));     // Catch: IllegalStateException -> L30 SQLiteException -> L31
        if (r9 == null) goto L17;
        r6 = r6 - (((r9.getSourceData().length() + r9.getQuery().length()) + r9.getReason().length()) + r9.getMeta().length());     // Catch: IllegalStateException -> L30 SQLiteException -> L31
        if (r6 < 0) goto L26;
        r7.add(r9);     // Catch: IllegalStateException -> L30 SQLiteException -> L31
        if (r7.size() != r13) goto L17;
    L26:
        if (com.obric.memorydata.middleware.a.a.f11596a.a(r2) == true) goto L44;
        return new MemoryResponse(0, null, CollectionsKt.emptyList(), 3, null);
    L44:
        return new MemoryResponse(0, null, r7, 3, null);
    L14:
        return new MemoryResponse(0, null, CollectionsKt.emptyList(), 3, null);
    L32:
        return new MemoryResponse(400, "DATABASE_ERROR", null, 4, null);
    L43:
        return new MemoryResponse(404, "ACCESS_OR_DATABASE_UNAVAILABLE", null, 4, null);
    L9:
        return new MemoryResponse(405, "INVALID_LIMIT", null, 4, null);
    L5:
        if (r13 >= 101) goto L7;
        r1 = true;
        goto L7
    }
}
