package com.obric.memorydata.memory.review.trace;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u001c\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J:\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0013J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0013J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00182\u0006\u0010$\u001a\u00020\u0013J\u001c\u0010(\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0018J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0018\u0010.\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0012\u0010/\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u00010\u00132\b\u00103\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u00104\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u00107\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0002J,\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130;2\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u0005H\u0002J\u0018\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0013H\u0002J\u001c\u0010A\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010B\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010C\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0002J\u001c\u0010D\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0002J8\u0010E\u001a\u00020\u001b2\b\u0010F\u001a\u0004\u0018\u00010\u001b2\b\u0010G\u001a\u0004\u0018\u00010\u001b2\b\u0010H\u001a\u0004\u0018\u00010\u001b2\b\u0010I\u001a\u0004\u0018\u00010\u001b2\u0006\u0010J\u001a\u00020\u001bH\u0002J<\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u00132\b\u0010F\u001a\u0004\u0018\u00010\u001b2\b\u0010H\u001a\u0004\u0018\u00010\u001b2\u0006\u0010J\u001a\u00020\u001bH\u0002J\u0010\u0010O\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010P\u001a\u0002092\u0006\u0010L\u001a\u00020\u00132\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0013H\u0002J\u001c\u0010Q\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u001b2\b\u00106\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0010\u0010S\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0010\u0010U\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0013H\u0002J&\u0010V\u001a\u0002092\b\u0010W\u001a\u0004\u0018\u00010\u001b2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u0002090YH\u0002J\u0012\u0010Z\u001a\u00020#2\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\\\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010]\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0013H\u0002J\u0018\u0010^\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0013H\u0002J\u001e\u0010_\u001a\u0002092\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050a2\u0006\u0010b\u001a\u00020\u0013H\u0002J\b\u0010c\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportPayloadBuilder;", "", "<init>", "()V", "KEY_MEMORY_OPS", "", "KEY_OBSERVATIONS", "KEY_VIEW_TREES", "KEY_VIEW_TREE_FILES", "KEY_AUDIO_URLS", "KEY_HOTWORDS", "KEY_IN_APP_TRACES", "KEY_IN_APP_TRACE_OBSERVATION_IDS", "KEY_INSERT", "KEY_UPDATE", "KEY_DELETE", "KEY_SEARCH", "KEY_PROMPT", "buildFromMemoryOps", "Lorg/json/JSONObject;", AILabCheckPermissionTask.KEY_SOURCE, "memoryOpsJson", "buildFromViewTrees", "viewTrees", "", "buildFromObservationBatch", "observations", "Lorg/json/JSONArray;", "viewTreeFiles", "audioUrls", "hotwords", "mergeReportData", "oldReportData", "newReportData", "hasAnyOps", "", "reportData", "hasReportContent", "traceObservationIds", "", "resolveInAppTraces", "traces", "Lcom/obric/memorydata/memory/review/trace/InAppTraceAttachment;", "observationIds", "hasAnyOpsPayload", "ops", "wrap", "normalizeOps", "rawOps", "mergeOps", "oldOps", "newOps", "mergeEntityOps", "oldArray", "newArray", "mergeQueryOps", "mergeByKey", "", "merged", "", "item", "key", "mergeJsonObject", "oldItem", "newItem", "mergeResultEntities", "mergeScalarArray", "mergeViewTrees", "mergeViewTreeFiles", "mergeObservationAlignedStrings", "oldObservations", "oldValues", "newObservations", "newValues", "mergedObservations", "putMergedAudioUrls", "result", "oldJson", "newJson", "hasAuditoryObservation", "putMergedHotwords", "mergeObservations", "observationKey", "entityOpKey", "queryOpKey", "resultEntityKey", "forEachJson", "array", "block", "Lkotlin/Function1;", "isNonEmpty", EventBody.KEY_VALUE, "parseReportData", "mergeSource", "mergeSources", "appendSources", "values", "", "json", "emptyOps", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f10497a = null;

    static {
        f10497a = new j();
    }

    private j() {
    }

    private static final Unit a(LinkedHashMap r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        j r0 = f10497a;
        r0.a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"), r4, r0.g(r4));
        return Unit.INSTANCE;
    }

    private final JSONArray a(JSONArray r11) {
        JSONArray r10 = new JSONArray();
        int r0 = r11.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        JSONObject r3 = r11.optJSONObject(r2);
        if (r3 == null) goto L15;
        Long r4 = Long.valueOf(r3.optLong(OaidModel.KEY_ID, 0));
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        r10.put(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L15
    L9:
        r5 = false;
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        return r10;
    }

    private final JSONArray a(JSONArray r3, JSONArray r4) {
        final LinkedHashMap r0 = new LinkedHashMap();
        a(r3, new $$Lambda$j$U0W5SVkF91Ur63LqPgSGWHOAjw(r0));
        a(r4, new $$Lambda$j$ftR7X0y6UEfxCR1tNS0x444pzQ(r0));
        JSONArray r2 = new JSONArray();
        Collection r5 = r0.values();
        Intrinsics.checkNotNullExpressionValue(r5, "<get-values>(...)");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r2.put((JSONObject) ZeusTransformUtils.preCheckCast(r6.next(), JSONObject.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r2;
    }

    private final JSONArray a(JSONArray r3, JSONArray r4, JSONArray r5, JSONArray r6, JSONArray r7) {
        if (r4 != null) goto L6;
        if (r6 != null) goto L6;
        return new JSONArray();
    L6:
        LinkedHashMap r2 = new LinkedHashMap();
        a(r2, r3, r4);
        a(r2, r5, r6);
        JSONArray r8 = new JSONArray();
        int r9 = 0;
        int r10 = r7.length();
    L7:
        if (r9 >= r10) goto L17;
        JSONObject r11 = r7.optJSONObject(r9);
        if (r11 == null) goto L13;
        String r12 = f10497a.f(r11);
        if (r12 == null) goto L13;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r2.get(r12), String.class, "com.obric.memorydata.plugin");
    L14:
        if (r13 != null) goto L16;
        r13 = "";
    L16:
        r8.put(r13);
        r9 = r9 + 1;
    L13:
        r13 = null;
        goto L14
    L17:
        return r8;
    }

    private final JSONObject a() {
        JSONObject r2 = new JSONObject().put("insert", new JSONArray()).put(BuildConfig.CHANNEL, new JSONArray()).put("delete", new JSONArray()).put("search", new JSONArray()).put(Params.PROMPT, new JSONArray());
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    }

    private final JSONObject a(String r3) {
        if (r3 == null) goto L19;
        Object r1 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L7;
        r3 = null;
    L7:
        if (r3 == null) goto L19;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L10
        Object r4 = Result.m1421constructorimpl(new JSONObject(r3));     // Catch: Throwable -> L10
    L13:
        if (Result.m1427isFailureimpl(r4) == true) goto L16;
        r1 = r4;
    L16:
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r1, JSONObject.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L19;
        return r5;
    L10:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L19:
        return new JSONObject();
    }

    private final JSONObject a(String r2, JSONObject r3) {
        JSONObject r1 = new JSONObject().put("memoryOps", r3).put(AILabCheckPermissionTask.KEY_SOURCE, r2);
        Intrinsics.checkNotNullExpressionValue(r1, "put(...)");
        return r1;
    }

    private final JSONObject a(JSONObject r7, JSONObject r8) {
        JSONObject r0 = a();
        JSONObject r9 = e(r7);
        JSONObject r6 = e(r8);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"insert", BuildConfig.CHANNEL, "delete"}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r1, f10497a.a(r9.optJSONArray(r1), r6.optJSONArray(r1)));
        goto L4
    L6:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"search", Params.PROMPT}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        r0.put(r2, f10497a.b(r9.optJSONArray(r2), r6.optJSONArray(r2)));
        goto L8
    L10:
        return r0;
    }

    private static final void a(LinkedHashMap<String, JSONObject> r7, JSONArray r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        int r1 = r8.length();
    L5:
        if (r0 >= r1) goto L21;
        JSONObject r2 = r8.optJSONObject(r0);
        if (r2 == null) goto L20;
        String r3 = r2.optString("fileName");
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L20;
        JSONObject r4 = (JSONObject) ZeusTransformUtils.preCheckCast(r7.get(r3), JSONObject.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L18;
        JSONObject r6 = new JSONObject(r2.toString());
    L19:
        r5.put(r3, r6);
        goto L20
    L18:
        r6 = f10497a.b(r4, r2);
    L20:
        r0 = r0 + 1;
        goto L5
    }

    private static final void a(LinkedHashMap<String, String> r6, JSONArray r7, JSONArray r8) {
        if (r7 == null) goto L26;
        if (r8 == null) goto L31;
        int r0 = 0;
        int r1 = r7.length();
    L6:
        if (r0 >= r1) goto L32;
        JSONObject r2 = r7.optJSONObject(r0);
        if (r2 == null) goto L25;
        String r3 = f10497a.f(r2);
        Object r4 = r8.opt(r0);
        String r5 = null;
        if (r4 != null) goto L13;
    L18:
        if (r5 != null) goto L21;
        r5 = "";
    L21:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L23;
    L24:
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).put(r3, r5);
        goto L25
    L23:
        if (((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).containsKey(r3) == true) goto L25;
    L13:
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == false) goto L16;
        r4 = null;
    L16:
        if (r4 == null) goto L18;
        r5 = r4.toString();
    L25:
        r0 = r0 + 1;
        goto L6
    L32:
        return;
    L31:
        return;
    }

    private static final void a(LinkedHashSet<String> r5, JSONArray r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        int r1 = r6.length();
    L5:
        if (r0 >= r1) goto L18;
        Object r2 = r6.opt(r0);
        if (r2 == null) goto L17;
        String r3 = r2.toString();
        if (r3 == null) goto L17;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L17;
        r5.add(r3);
    L17:
        r0 = r0 + 1;
        goto L5
    }

    private final void a(Map<String, JSONObject> r4, JSONObject r5, String r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        JSONObject r0 = (JSONObject) ZeusTransformUtils.preCheckCast(r7.get(r6), JSONObject.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        JSONObject r3 = new JSONObject(r5.toString());
    L6:
        r7.put(r6, r3);
        return;
    L5:
        r3 = b(r0, r5);
        goto L6
    }

    private final void a(Set<String> r6, JSONObject r7) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        String r8 = r7.optString(AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNull(r8);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r8 = null;
    L6:
        if (r8 == null) goto L8;
        r5.add(r8);
    L8:
        JSONArray r9 = r7.optJSONArray("sources");
        if (r9 != null) goto L11;
        return;
    L11:
        int r10 = 0;
        int r1 = r9.length();
    L12:
        if (r10 >= r1) goto L20;
        String r3 = r9.optString(r10);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L19;
        r5.add(r3);
    L19:
        r10 = r10 + 1;
        goto L12
    }

    private final void a(JSONArray r5, Function1<? super JSONObject, Unit> r6) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        int r7 = 0;
        int r1 = r5.length();
    L6:
        if (r7 >= r1) goto L14;
        Object r2 = r5.opt(r7);
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L10;
        JSONObject r3 = (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
    L11:
        if (r3 == null) goto L13;
        r4.invoke(r3);
    L13:
        r7 = r7 + 1;
        goto L6
    L10:
        r3 = null;
        goto L11
    }

    private final void a(JSONObject r5, JSONObject r6, JSONObject r7) {
        JSONArray r8 = r7.optJSONArray("hotwords");
        boolean r0 = true;
        JSONArray r2 = null;
        if (r8 != null) goto L5;
    L13:
        JSONArray r9 = r6.optJSONArray("hotwords");
        if (r9 != null) goto L16;
    L21:
        if (r2 != null) goto L23;
        return;
    L23:
        r8 = r2;
    L24:
        r5.put("hotwords", new JSONArray(r8.toString()));
        return;
    L16:
        if (r9.length() > 0) goto L19;
        r0 = false;
    L19:
        if (r0 == false) goto L21;
        r2 = r9;
        goto L21
    L5:
        if (r8.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r8 = null;
    L11:
        if (r8 == null) goto L13;
    L7:
        r3 = false;
        goto L8
    }

    private final void a(JSONObject r8, JSONObject r9, JSONObject r10, JSONArray r11, JSONArray r12, JSONArray r13) {
        if (b(r13) == true) goto L5;
        return;
    L5:
        JSONArray r7 = a(r11, r9.optJSONArray("audioUrls"), r12, r10.optJSONArray("audioUrls"), r13);
        if (r7.length() <= 0) goto L9;
        r8.put("audioUrls", r7);
        return;
    }

    private final boolean a(Object r4) {
        if (r4 != null) goto L6;
    L22:
        return false;
    L6:
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == true) goto L22;
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L14;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L22;
        return true;
    L14:
        if (ZeusTransformUtils.instanceOf(r4, JSONArray.class) == false) goto L19;
        if (((JSONArray) ZeusTransformUtils.preCheckCast(r4, JSONArray.class, "com.obric.memorydata.plugin")).length() <= 0) goto L22;
        return true;
    L19:
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == true) goto L21;
        return true;
    L21:
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin")).length() <= 0) goto L22;
        return true;
    }

    private static final Unit b(LinkedHashMap r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        j r0 = f10497a;
        r0.a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"), r4, r0.g(r4));
        return Unit.INSTANCE;
    }

    private final JSONArray b(JSONArray r3, JSONArray r4) {
        final LinkedHashMap r0 = new LinkedHashMap();
        a(r3, new $$Lambda$j$yA3DP66s9fri87JKfSBDzEQpyo(r0));
        a(r4, new $$Lambda$j$ZRFjdpkrodxVEklSB2SdwphsiTc(r0));
        JSONArray r2 = new JSONArray();
        Collection r5 = r0.values();
        Intrinsics.checkNotNullExpressionValue(r5, "<get-values>(...)");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r2.put((JSONObject) ZeusTransformUtils.preCheckCast(r6.next(), JSONObject.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r2;
    }

    private final JSONObject b(JSONObject r8, JSONObject r9) {
        JSONObject r7 = new JSONObject(r8.toString());
        Iterator<String> r10 = r9.keys();
        Intrinsics.checkNotNullExpressionValue(r10, "keys(...)");
    L4:
        if (r10.hasNext() == false) goto L20;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        Object r1 = r9.opt(r0);
        JSONArray r4 = null;
        if (Intrinsics.areEqual(r0, "resultEntities") == true) goto L7;
        if (Intrinsics.areEqual(r0, "resultEntityIds") == true) goto L13;
        if (f10497a.a(r1) == false) goto L4;
    L19:
        r7.put(r0, r1);
        goto L4
    L13:
        j r3 = f10497a;
        JSONArray r5 = r7.optJSONArray(r0);
        if (ZeusTransformUtils.instanceOf(r1, JSONArray.class) == false) goto L16;
        r4 = (JSONArray) ZeusTransformUtils.preCheckCast(r1, JSONArray.class, "com.obric.memorydata.plugin");
    L16:
        r1 = r3.d(r5, r4);
        goto L19
    L7:
        j r6 = f10497a;
        JSONArray r11 = r7.optJSONArray(r0);
        if (ZeusTransformUtils.instanceOf(r1, JSONArray.class) == false) goto L10;
        r4 = (JSONArray) ZeusTransformUtils.preCheckCast(r1, JSONArray.class, "com.obric.memorydata.plugin");
    L10:
        r1 = r6.c(r11, r4);
        goto L19
    L20:
        return r7;
    }

    private static final void b(LinkedHashMap<String, JSONObject> r8, JSONArray r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        int r1 = r9.length();
    L5:
        if (r0 >= r1) goto L15;
        JSONObject r2 = r9.optJSONObject(r0);
        if (r2 == null) goto L14;
        j r3 = f10497a;
        String r4 = r3.f(r2);
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r8.get(r4), JSONObject.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L12;
        JSONObject r7 = new JSONObject(r2.toString());
    L13:
        r6.put(r4, r7);
        goto L14
    L12:
        r7 = r3.b(r5, r2);
    L14:
        r0 = r0 + 1;
        goto L5
    }

    private final boolean b(JSONArray r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r5.length()), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L22;
        JSONObject r1 = r5.optJSONObject(((IntIterator) ZeusTransformUtils.preCheckCast(r6, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        if (r1 == null) goto L13;
        String r2 = r1.optString(AILabCheckPermissionTask.KEY_SOURCE);
    L15:
        if (Intrinsics.areEqual(r2, "auditory") == false) goto L9;
        return true;
    L13:
        r2 = null;
        goto L15
    L22:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    private final String c(JSONObject r4, JSONObject r5) {
        String r6 = r4.optString(AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNull(r6);
        String r2 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r6 = null;
    L6:
        if (r6 != null) goto L14;
        String r3 = r5.optString(AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L10;
        r2 = r3;
    L10:
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L14:
        return r6;
    }

    private static final Unit c(LinkedHashMap r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        j r0 = f10497a;
        r0.a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"), r4, r0.h(r4));
        return Unit.INSTANCE;
    }

    private final JSONArray c(JSONArray r3, JSONArray r4) {
        final LinkedHashMap r0 = new LinkedHashMap();
        a(r3, new $$Lambda$j$xMWkkOloH1fSxEx1okm8H1MhSU(r0));
        a(r4, new $$Lambda$j$HM_AxrZcJ0NLEiMWgZ3idIEAfo(r0));
        JSONArray r2 = new JSONArray();
        Collection r5 = r0.values();
        Intrinsics.checkNotNullExpressionValue(r5, "<get-values>(...)");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r2.put((JSONObject) ZeusTransformUtils.preCheckCast(r6.next(), JSONObject.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r2;
    }

    private static final Unit d(LinkedHashMap r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        j r0 = f10497a;
        r0.a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"), r4, r0.h(r4));
        return Unit.INSTANCE;
    }

    private final JSONArray d(JSONArray r3, JSONArray r4) {
        LinkedHashSet r2 = new LinkedHashSet();
        a(r2, r3);
        a(r2, r4);
        JSONArray r5 = new JSONArray();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.put((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r5;
    }

    private final JSONArray d(JSONObject r4, JSONObject r5) {
        LinkedHashSet r0 = new LinkedHashSet();
        a((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"), r4);
        a((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"), r5);
        JSONArray r3 = new JSONArray();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r3.put((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r3;
    }

    private final boolean d(JSONObject r6) {
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"insert", BuildConfig.CHANNEL, "delete", "search", Params.PROMPT}), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L18;
        JSONArray r0 = r6.optJSONArray((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L13;
        int r1 = r0.length();
    L14:
        if (r1 <= 0) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L9;
        return true;
    L16:
        r2 = false;
        goto L17
    L13:
        r1 = 0;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private static final Unit e(LinkedHashMap r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        j r0 = f10497a;
        r0.a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"), r4, r0.i(r4));
        return Unit.INSTANCE;
    }

    private final JSONArray e(JSONArray r1, JSONArray r2) {
        JSONArray r0 = new JSONArray();
        h(r0, r1);
        h(r0, r2);
        return r0;
    }

    private final JSONObject e(JSONObject r8) {
        JSONObject r7 = a();
        if (r8 != null) goto L5;
        return r7;
    L5:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"insert", BuildConfig.CHANNEL, "delete", "search", Params.PROMPT}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        JSONArray r3 = r8.optJSONArray(r1);
        if (r3 == null) goto L7;
        JSONArray r2 = r7.getJSONArray(r1);
        int r4 = 0;
        int r5 = r3.length();
    L12:
        if (r4 >= r5) goto L7;
        r2.put(r3.opt(r4));
        r4 = r4 + 1;
        goto L12
    L14:
        return r7;
    }

    private final String f(JSONObject r5) {
        Long r4 = Long.valueOf(r5.optLong(OaidModel.KEY_ID, -1));
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L12;
        String r6 = r4.toString();
        if (r6 == null) goto L12;
        return r6;
    L12:
        String r7 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    L5:
        r0 = false;
        goto L6
    }

    private static final Unit f(LinkedHashMap r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        j r0 = f10497a;
        r0.a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"), r4, r0.i(r4));
        return Unit.INSTANCE;
    }

    private final JSONArray f(JSONArray r3, JSONArray r4) {
        LinkedHashMap r2 = new LinkedHashMap();
        a(r2, r3);
        a(r2, r4);
        JSONArray r5 = new JSONArray();
        Collection r6 = r2.values();
        Intrinsics.checkNotNullExpressionValue(r6, "<get-values>(...)");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r5.put((JSONObject) ZeusTransformUtils.preCheckCast(r7.next(), JSONObject.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r5;
    }

    private final String g(JSONObject r11) {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{r11.optString("operateType"), r11.optString("entityType"), r11.optString("entityId")}), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    private final JSONArray g(JSONArray r3, JSONArray r4) {
        LinkedHashMap r2 = new LinkedHashMap();
        b(r2, r3);
        b(r2, r4);
        JSONArray r5 = new JSONArray();
        Collection r6 = r2.values();
        Intrinsics.checkNotNullExpressionValue(r6, "<get-values>(...)");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r5.put((JSONObject) ZeusTransformUtils.preCheckCast(r7.next(), JSONObject.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r5;
    }

    private final String h(JSONObject r11) {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{r11.optString("toolName"), r11.optString("operateType"), r11.optString("entityType"), r11.optString(ChatMessage.TYPE_QUERY)}), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    private static final void h(JSONArray r4, JSONArray r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = 0;
        int r1 = r5.length();
    L5:
        if (r0 >= r1) goto L14;
        Object r2 = r5.opt(r0);
        if (r2 != null) goto L9;
    L12:
        String r3 = "";
    L13:
        r4.put(r3);
        r0 = r0 + 1;
        goto L5
    L9:
        if (Intrinsics.areEqual(r2, JSONObject.NULL) == true) goto L12;
        r3 = r2.toString();
        goto L13
    }

    private final String i(JSONObject r11) {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{r11.optString("entityType"), r11.optString("entityId")}), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: renamed from: lambda$HM_AxrZcJ0NLEiMWgZ3i-dIEAfo, reason: not valid java name */
    public static /* synthetic */ Unit m757lambda$HM_AxrZcJ0NLEiMWgZ3idIEAfo(LinkedHashMap r0, JSONObject r1) {
        return f(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$U-0W5SVkF91Ur63LqPgSGWHOAjw, reason: not valid java name */
    public static /* synthetic */ Unit m758lambda$U0W5SVkF91Ur63LqPgSGWHOAjw(LinkedHashMap r0, JSONObject r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$ZRFjdpkrodxVEklSB2SdwphsiTc(LinkedHashMap r0, JSONObject r1) {
        return d(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ftR7X0y6-UEfxCR1tNS0x444pzQ, reason: not valid java name */
    public static /* synthetic */ Unit m759lambda$ftR7X0y6UEfxCR1tNS0x444pzQ(LinkedHashMap r0, JSONObject r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$xMWkkOloH1fSxEx1okm8H1-MhSU, reason: not valid java name */
    public static /* synthetic */ Unit m760lambda$xMWkkOloH1fSxEx1okm8H1MhSU(LinkedHashMap r0, JSONObject r1) {
        return e(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$yA3DP66s9fri87JKfSB-DzEQpyo, reason: not valid java name */
    public static /* synthetic */ Unit m761lambda$yA3DP66s9fri87JKfSBDzEQpyo(LinkedHashMap r0, JSONObject r1) {
        return c(r0, r1);
    }

    public final JSONObject a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "memoryOpsJson");
        JSONObject r2 = null;
        Object r3 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r6 = Result.m1421constructorimpl(new JSONObject(r5));     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r6) == true) goto L15;
        r3 = r6;
    L15:
        r2 = (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L17:
        return a(r4, e(r2));
    }

    public final JSONObject a(String r8, JSONArray r9, JSONArray r10, List<String> r11, JSONArray r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r9, "observations");
        Intrinsics.checkNotNullParameter(r10, "viewTreeFiles");
        Intrinsics.checkNotNullParameter(r13, "audioUrls");
        if (r13.isEmpty() == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L27;
        JSONObject r14 = a(r8, a());
        if (r10.length() <= 0) goto L14;
        r14.put("viewTreeFiles", new JSONArray(r10.toString()));
    L14:
        if (r9.length() <= 0) goto L17;
        r14.put("observations", new JSONArray(r9.toString()));
        r14.put("inAppTraceObservationIds", a(r9));
    L17:
        if (b(r9) == true) goto L19;
    L21:
        if (r12 != null) goto L23;
    L25:
        return r14;
    L23:
        if (r12.length() <= 0) goto L25;
        r14.put("hotwords", new JSONArray(r12.toString()));
        goto L25
    L19:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L21;
        r14.put("audioUrls", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")));
        goto L21
    L27:
        throw new IllegalArgumentException("audioUrls and observations must have the same size".toString());
    L5:
        if (r13.size() == r9.length()) goto L8;
        r4 = false;
        goto L9
    }

    public final JSONObject a(JSONObject r7, List<a> r8) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "reportData");
        Intrinsics.checkNotNullParameter(r6, "traces");
        JSONObject r9 = new JSONObject(r7.toString());
        r9.remove("inAppTraceObservationIds");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        JSONArray r10 = new JSONArray();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.memorydata.plugin");
        r10.put(new JSONObject().put("observation_id", r1.a()).put("tos_uri", r1.b()).put("start_timestamp", r1.c()).put("end_timestamp", r1.d()));
        goto L6
    L8:
        Unit r12 = Unit.INSTANCE;
        r9.put("in_app_traces", r10);
    L9:
        return r9;
    }

    public final boolean a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "reportData");
        JSONObject r3 = r2.optJSONObject("memoryOps");
        if (r3 != null) goto L7;
        return false;
    L7:
        return d(r3);
    }

    public final String b(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "newReportData");
        JSONObject r11 = a(r9);
        JSONObject r12 = a(r10);
        JSONObject r1 = a(r11.optJSONObject("memoryOps"), r12.optJSONObject("memoryOps"));
        JSONObject r0 = new JSONObject().put("memoryOps", r1).put(AILabCheckPermissionTask.KEY_SOURCE, c(r11, r12));
        JSONArray r5 = r11.optJSONArray("observations");
        JSONArray r6 = r12.optJSONArray("observations");
        JSONArray r7 = i.f10494a.a(g(r5, r6));
        if (r7.length() <= 0) goto L5;
        r0.put("observations", r7);
    L8:
        Intrinsics.checkNotNull(r0);
        a(r0, r11, r12, r5, r6, r7);
        a(r0, r11, r12);
        JSONArray r2 = f(r11.optJSONArray("viewTreeFiles"), r12.optJSONArray("viewTreeFiles"));
        if (r2.length() <= 0) goto L11;
        r0.put("viewTreeFiles", r2);
    L11:
        JSONArray r3 = d(r11.optJSONArray("inAppTraceObservationIds"), r12.optJSONArray("inAppTraceObservationIds"));
        if (r3.length() <= 0) goto L14;
        r0.put("inAppTraceObservationIds", r3);
    L14:
        JSONArray r8 = d(r11, r12);
        if (r8.length() <= 0) goto L17;
        r0.put("sources", r8);
    L17:
        String r13 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
        return r13;
    L5:
        JSONArray r4 = e(r11.optJSONArray("viewTrees"), r12.optJSONArray("viewTrees"));
        if (r4.length() <= 0) goto L8;
        r0.put("viewTrees", r4);
        goto L8
    }

    public final boolean b(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "reportData");
        if (a(r2) == true) goto L24;
        JSONArray r1 = r2.optJSONArray("observations");
        if (r1 == null) goto L7;
        int r3 = r1.length();
    L8:
        if (r3 > 0) goto L24;
        JSONArray r4 = r2.optJSONArray("viewTrees");
        if (r4 == null) goto L12;
        int r5 = r4.length();
    L13:
        if (r5 > 0) goto L24;
        JSONArray r6 = r2.optJSONArray("viewTreeFiles");
        if (r6 == null) goto L17;
        int r7 = r6.length();
    L18:
        if (r7 > 0) goto L24;
        JSONArray r8 = r2.optJSONArray("audioUrls");
        if (r8 == null) goto L22;
        int r9 = r8.length();
    L23:
        if (r9 > 0) goto L24;
        return false;
    L22:
        r9 = 0;
        goto L23
    L17:
        r7 = 0;
        goto L18
    L12:
        r5 = 0;
        goto L13
    L7:
        r3 = 0;
    L24:
        return true;
    }

    public final List<Long> c(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "reportData");
        JSONArray r9 = r10.optJSONArray("inAppTraceObservationIds");
        if (r9 == null) goto L5;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r9.length()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L24;
        Object r3 = r9.opt(((IntIterator) ZeusTransformUtils.preCheckCast(r12, IntIterator.class, "com.obric.memorydata.plugin")).nextInt());
        Long r4 = null;
        if (r3 == null) goto L21;
        String r5 = r3.toString();
        if (r5 == null) goto L21;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L21;
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
        r4 = r6;
        goto L21
    L18:
        r7 = false;
    L21:
        if (r4 == null) goto L8;
        r1.add(r4);
        goto L8
    L24:
        return CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L5:
        return CollectionsKt.emptyList();
    }
}
