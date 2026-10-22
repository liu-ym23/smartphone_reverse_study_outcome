package com.obric.memorydata.memory.review.provider;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.entity.iu;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011J,\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00132\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\t2\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\"\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J&\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002JB\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u00012\b\u0010%\u001a\u0004\u0018\u00010\u000b2\b\u0010&\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u000bH\u0002JL\u0010,\u001a\u00020\u0017*\u00020\u00192\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nH\u0002JP\u00107\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u00108\u001a\u0004\u0018\u00010\u000b*\u00020\u00192\u0006\u00109\u001a\u00020\u000bH\u0002J\u0016\u0010:\u001a\u0004\u0018\u00010\u0001*\u00020\u00192\u0006\u00109\u001a\u00020\u000bH\u0002J\u0012\u0010;\u001a\u00020#2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010=\u001a\u00020#2\u0006\u0010<\u001a\u00020\u000bH\u0002J\u0012\u0010>\u001a\u00020\u00012\b\u0010<\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006?"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/SnapshotMemoryReviewRecordMapper;", "", "<init>", "()V", "fromAutoMemoryPro", "Lcom/obric/memorydata/memory/review/model/MemoryReviewRecord;", "snapshot", "Lcom/obric/memorydata/database/entity/AutoMemoryProSnapShotEntity;", "ruleTitleByRuleId", "", "", "", "rawObservationIds", "", "rawObservations", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "feedbackState", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "fromPersonalMemory", "Lcom/obric/memorydata/database/entity/UnionSemanticMemorySnapShotEntity;", "relevantDataByEntityId", "Lcom/obric/memorydata/database/entity/ProactiveSemanticRelevantData;", "enrichAutoMemoryProPayload", "", "payload", "Lorg/json/JSONObject;", "ruleTitle", "resolveAutoMemoryProRuleTitle", "enrichPersonalMemoryPayload", "relevantData", "personalSourceType", "sourceQuery", "sourceText", "sourceScreenshot", "personalSourceEvidence", "Lorg/json/JSONArray;", "sourceType", "sourceAppName", "sourcePackageName", "sourceInfoJson", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "parseSnapshotJson", "snapshotJson", "putCommonSnapshotFields", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "recordId", "snapshotId", "sourceEntityId", "sourceDbKey", "sourceDbId", "snapshotVersion", "", "snapshotTime", "buildTraceJson", "optNonBlankString", "key", "optPresent", "parseSourceEvidence", EventBody.KEY_VALUE, "parseSourceEvidenceString", "parseJsonValueOrNull", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ba f10439a = null;

    static {
        f10439a = new ba();
    }

    private ba() {
    }

    public static /* synthetic */ com.obric.memorydata.memory.review.model.h a(ba r1, iu r2, Map r3, MemoryReviewFeedbackState r4, int r5, Object r6) {
        Map<String, fa> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r7 = MapsKt.emptyMap();
    L6:
        return r1.a(r2, r7, r4);
    }

    private final String a(fa r6) {
        if (r6 != null) goto L5;
        return "unknown";
    L5:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.c(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L23;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == true) goto L23;
        return "dialog_bubble";
    L16:
        if (StringsKt.isBlank(r3) == true) goto L19;
        r4 = false;
    L23:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.e(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L26;
    L29:
        boolean r7 = true;
    L30:
        if (r7 == true) goto L33;
        return "screenshot";
    L33:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L36;
    L37:
        r1 = true;
    L38:
        if (r1 == true) goto L41;
        return "original_text";
    L41:
        return "unknown";
    L36:
        if (StringsKt.isBlank(r8) == false) goto L38;
    L26:
        if (StringsKt.isBlank(r5) == true) goto L29;
        r7 = false;
        goto L30
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r2 = false;
        goto L12
    }

    private final String a(MemoryReviewModule r3, String r4, long r5, String r7, String r8, long r9, int r11, long r12, JSONObject r14) {
        JSONObject r6 = new JSONObject().put("module", r3.getKey()).put("recordId", r4).put("snapshotId", r5).put("sourceEntityId", r7).put(r8, r9).put("snapshotVersion", r11).put("snapshotTime", r12);
        String r2 = a(r14, "logId");
        if (r2 == null) goto L6;
        r6.put("logId", r2);
    L6:
        if (r14.has("traceId") == true) goto L8;
    L10:
        String r10 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        return r10;
    L8:
        if (r14.isNull("traceId") == true) goto L10;
        r6.put("traceId", r14.opt("traceId"));
        goto L10
    }

    private final String a(String r3, String r4, Object r5) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L20;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L20;
        return "dialog_bubble";
    L13:
        if (StringsKt.isBlank(r8) == true) goto L16;
        r9 = false;
    L20:
        if (r5 != null) goto L22;
    L25:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L28;
    L29:
        r6 = true;
    L30:
        if (r6 == true) goto L33;
        return "original_text";
    L33:
        return "unknown";
    L28:
        if (StringsKt.isBlank(r10) == false) goto L30;
    L22:
        if (Intrinsics.areEqual(r5, JSONObject.NULL) == true) goto L25;
        return "screenshot";
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r7 = false;
        goto L9
    }

    private final String a(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L18;
        String r1 = r2.optString(r3);
        Intrinsics.checkNotNull(r1);
        boolean r4 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
    L12:
        r4 = false;
    L13:
        if (r4 == true) goto L15;
        return null;
    L15:
        return r1;
    L10:
        if (Intrinsics.areEqual(r1, "null") == true) goto L12;
    L18:
        return null;
    }

    private final String a(JSONObject r5, Map<Long, String> r6) {
        String r7 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin")).get(Long.valueOf(r5.optLong("ruleId", 0))), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        String r8 = a(r5, "ruleTitle");
        if (r8 != null) goto L17;
        String r9 = a(r5, "rule_title");
        if (r9 != null) goto L18;
        String r10 = a(r5, "ruleName");
        if (r10 != null) goto L19;
        String r11 = a(r5, "rule");
        if (r11 != null) goto L20;
        String r12 = a(r5, "taskName");
        if (r12 == null) goto L15;
        return r12;
    L15:
        return a(r5, "memoryTaskName");
    L20:
        return r11;
    L19:
        return r10;
    L18:
        return r9;
    L17:
        return r8;
    L16:
        return r7;
    }

    private final JSONArray a(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == false) goto L6;
        return (JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L9;
        JSONArray r2 = new JSONArray().put(r3);
        Intrinsics.checkNotNullExpressionValue(r2, "put(...)");
        return r2;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L12;
        return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    L12:
        return new JSONArray();
    }

    private final JSONArray a(String r6, String r7, String r8, Object r9, String r10, String r11) {
        JSONArray r5 = new JSONArray();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L27;
        JSONObject r2 = new JSONObject();
        String r4 = "dialog_bubble";
        if (Intrinsics.areEqual(r6, "dialog_bubble") == true) goto L15;
        r4 = "original_text";
    L15:
        JSONObject r12 = r2.put("type", r4).put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r8);
        Object r13 = r7;
        if (r7 != null) goto L18;
        r13 = JSONObject.NULL;
    L18:
        JSONObject r14 = r12.put(ChatMessage.TYPE_QUERY, r13);
        if (r10 != null) goto L21;
        Object r15 = JSONObject.NULL;
    L22:
        JSONObject r16 = r14.put("appName", r15);
        if (r11 != null) goto L25;
        Object r17 = JSONObject.NULL;
    L26:
        r5.put(r16.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r17));
        goto L27
    L25:
        r17 = r11;
        goto L26
    L21:
        r15 = r10;
    L27:
        if (r9 != null) goto L29;
    L37:
        return r5;
    L29:
        if (Intrinsics.areEqual(r9, JSONObject.NULL) == true) goto L37;
        JSONObject r18 = new JSONObject().put("type", "screenshot").put("screenshot", r9);
        Object r19 = r10;
        if (r10 != null) goto L33;
        r19 = JSONObject.NULL;
    L33:
        JSONObject r20 = r18.put("appName", r19);
        Object r110 = r11;
        if (r11 != null) goto L36;
        r110 = JSONObject.NULL;
    L36:
        r5.put(r20.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r110));
        goto L37
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final JSONObject a(String r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        ba r2 = (ba) ZeusTransformUtils.preCheckCast(this, ba.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(new JSONObject(r3));     // Catch: Throwable -> L5
    L8:
        if (Result.m1424exceptionOrNullimpl(r4) == null) goto L12;
        r4 = new JSONObject().put("rawSnapshotJson", r3);
        Intrinsics.checkNotNullExpressionValue(r4, "put(...)");
    L12:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final JSONObject a(String r2, String r3) {
        JSONObject r1 = new JSONObject();
        Object r4 = r2;
        if (r2 != null) goto L5;
        r4 = JSONObject.NULL;
    L5:
        JSONObject r5 = r1.put("appName", r4);
        Object r6 = r3;
        if (r3 != null) goto L8;
        r6 = JSONObject.NULL;
    L8:
        JSONObject r7 = r5.put(ObricMemoryConstants.KEY_PACKAGE_NAME, r6);
        Intrinsics.checkNotNullExpressionValue(r7, "put(...)");
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(JSONObject r5, com.obric.memorydata.database.entity.aa r6, Object r7) {
        Object r1 = a(r5, "taskSubtitle");
        if (r1 != null) goto L11;
        r1 = a(r5, "displaySubtitle");
        if (r1 != null) goto L11;
        r1 = a(r5, "cardSubtitle");
        if (r1 != null) goto L11;
        r1 = a(r5, "realSubtitle");
        if (r1 != null) goto L11;
        r1 = a(r5, "subtitle");
    L11:
        if (r7 != 0) goto L13;
        r7 = JSONObject.NULL;
    L13:
        r5.put("ruleTitle", r7);
        if (r1 != null) goto L16;
        r1 = JSONObject.NULL;
    L16:
        r5.put("taskSubtitle", r1);
        Object r8 = a(r5, "title");
        if (r8 != null) goto L19;
        r8 = r6.c();
    L19:
        r5.put("displayTitle", r8);
        Object r9 = a(r5, Params.CONTENT);
        if (r9 != null) goto L26;
        r9 = a(r5, "subtitle");
        if (r9 != null) goto L26;
        r9 = a(r5, InfoRequestQPSOptTraceLogger.REASON);
        if (r9 != null) goto L26;
        r9 = JSONObject.NULL;
    L26:
        r5.put("displaySummary", r9);
        Object r10 = a(r5, Params.CONTENT);
        if (r10 != null) goto L29;
        r10 = JSONObject.NULL;
    L29:
        r5.put("currentContent", r10);
        Object r11 = a(r5, "previousContent");
        if (r11 != null) goto L34;
        r11 = a(r5, "oldContent");
        if (r11 != null) goto L34;
        r11 = JSONObject.NULL;
    L34:
        r5.put("previousContent", r11);
        Object r4 = a(r5, InfoRequestQPSOptTraceLogger.REASON);
        if (r4 != null) goto L37;
        r4 = JSONObject.NULL;
    L37:
        r5.put("changeReason", r4);
    }

    private final void a(JSONObject r24, iu r25, fa r26) {
        String r2 = a(r24, "sourceQuery");
        if (r2 != null) goto L5;
        r2 = a(r24, "source_query");
    L5:
        String r4 = a(r24, "sourceText");
        if (r4 != null) goto L8;
        r4 = a(r24, "source_text");
    L8:
        Object r6 = b(r24, "sourceScreenshot");
        if (r6 != null) goto L13;
        r6 = b(r24, "source_screenshot");
        if (r6 != null) goto L13;
        r6 = b(r24, "screenshot");
    L13:
        String r11 = a(r24, "sourceAppName");
        if (r11 != null) goto L20;
        r11 = a(r24, "source_app_name");
        if (r11 != null) goto L20;
        if (r26 == null) goto L19;
        r11 = r26.f();
        goto L20
    L19:
        r11 = null;
    L20:
        String r14 = a(r24, "sourcePackageName");
        if (r14 != null) goto L28;
        r14 = a(r24, "source_package_name");
        if (r14 != null) goto L28;
        if (r26 == null) goto L26;
        r14 = r26.g();
        goto L28
    L26:
        r14 = null;
    L28:
        if (r2 != null) goto L37;
        if (r4 != null) goto L37;
        if (r6 != null) goto L37;
        if (b(r24, "sourceEvidence") != null) goto L37;
        if (b(r24, "sourceInfo") != null) goto L37;
        boolean r16 = false;
    L38:
        if (r2 != null) goto L42;
        if (r26 == null) goto L41;
        r2 = r26.c();
        goto L42
    L41:
        r2 = null;
    L42:
        if (r4 != null) goto L46;
        if (r26 == null) goto L45;
        r4 = r26.d();
        goto L46
    L45:
        r4 = null;
    L46:
        if (r6 != null) goto L51;
        if (r26 == null) goto L49;
        String r7 = r26.e();
    L50:
        r6 = c(r7);
        goto L51
    L49:
        r7 = null;
    L51:
        String r18 = a(r24, "sourceType");
        if (r18 != null) goto L58;
        String r13 = a(r24, "source_type");
        if (r13 != null) goto L59;
        if (r16 == false) goto L57;
        r13 = a(r2, r4, r6);
        goto L59
    L57:
        r13 = a(r26);
    L59:
        String r0 = a(r24, "semanticType");
        if (r0 != null) goto L62;
        r0 = a(r24, "semantic_type");
    L62:
        Object r19 = a(r24, "tagPath");
        if (r19 != null) goto L65;
        r19 = a(r24, "tag_path");
    L65:
        if (r0 == null) goto L68;
        Object r1 = iq.b(r0);
        if (r1 == null) goto L68;
    L69:
        r24.put("primaryCategory", r1);
        if (r19 != null) goto L72;
        r19 = JSONObject.NULL;
    L72:
        r24.put("secondaryCategory", r19);
        Object r3 = a(r24, "description");
        if (r3 != null) goto L77;
        r3 = a(r24, "embeddingContent");
        if (r3 != null) goto L77;
        r3 = JSONObject.NULL;
    L77:
        r24.put("currentContent", r3);
        Object r10 = a(r24, "diffCurrentContent");
        if (r10 != null) goto L82;
        r10 = a(r24, "keyPhrase");
        if (r10 != null) goto L82;
        r10 = JSONObject.NULL;
    L82:
        r24.put("diffCurrentContent", r10);
        Object r5 = a(r24, "oldDescription");
        if (r5 != null) goto L89;
        r5 = a(r24, "previousDescription");
        if (r5 != null) goto L89;
        r5 = a(r24, "oldContent");
        if (r5 != null) goto L89;
        r5 = JSONObject.NULL;
    L89:
        r24.put("previousContent", r5);
        Object r12 = a(r24, "diffPreviousContent");
        if (r12 != null) goto L96;
        r12 = a(r24, "oldKeyPhrase");
        if (r12 != null) goto L96;
        r12 = a(r24, "previousKeyPhrase");
        if (r12 != null) goto L96;
        r12 = JSONObject.NULL;
    L96:
        r24.put("diffPreviousContent", r12);
        r24.put("sourceType", r13);
        JSONObject r8 = r24.optJSONObject("sourceInfo");
        if (r8 != null) goto L99;
        r8 = a(r11, r14);
    L99:
        r24.put("sourceInfo", r8);
        if (r2 != null) goto L102;
        Object r9 = JSONObject.NULL;
    L103:
        r24.put("sourceQuery", r9);
        if (r4 != null) goto L106;
        Object r15 = JSONObject.NULL;
    L107:
        r24.put("sourceText", r15);
        r24.put("sourceScreenshot", r6);
        r24.put("screenshot", r6);
        if (r11 != null) goto L110;
        Object r17 = JSONObject.NULL;
    L111:
        r24.put("sourceAppName", r17);
        if (r14 != null) goto L114;
        Object r20 = JSONObject.NULL;
    L115:
        r24.put("sourcePackageName", r20);
        Object r21 = b(r24, "detailStatus");
        if (r21 != null) goto L123;
        if (r26 == null) goto L119;
        Integer r110 = Integer.valueOf(r26.h());
    L120:
        if (r110 != null) goto L122;
        r21 = JSONObject.NULL;
        goto L123
    L122:
        r21 = r110;
        goto L123
    L119:
        r110 = null;
    L123:
        r24.put("detailStatus", r21);
        Object r22 = b(r24, "sourceEvidence");
        if (r22 == null) goto L127;
        JSONArray r23 = a(r22);
        if (r23 == null) goto L127;
    L128:
        r24.put("sourceEvidence", r23);
        String r27 = a(r24, "keyPhrase");
        if (r27 != null) goto L133;
        r27 = a(r24, "tagPath");
        if (r27 != null) goto L133;
        r27 = r25.c();
    L133:
        r24.put("displayTitle", r27);
        Object r28 = a(r24, "description");
        if (r28 != null) goto L138;
        r28 = a(r24, "embeddingContent");
        if (r28 != null) goto L138;
        r28 = JSONObject.NULL;
    L138:
        r24.put("displaySummary", r28);
        return;
    L127:
        r23 = a(r13, r2, r4, r6, r11, r14);
        goto L128
    L114:
        r20 = r14;
        goto L115
    L110:
        r17 = r11;
        goto L111
    L106:
        r15 = r4;
        goto L107
    L102:
        r9 = r2;
    L68:
        r1 = JSONObject.NULL;
        goto L69
    L58:
        r13 = r18;
    L37:
        r16 = true;
        goto L38
    }

    private final void a(JSONObject r1, MemoryReviewModule r2, String r3, long r4, String r6, String r7, long r8, int r10, long r11) {
        r1.put("recordId", r3);
        r1.put("module", r2.getKey());
        r1.put("snapshotId", r4);
        r1.put("sourceEntityId", r6);
        r1.put(r7, r8);
        r1.put("snapshotVersion", r10);
        r1.put("snapshotTime", r11);
    }

    private final Object b(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L5;
        return null;
    L5:
        if (r1.isNull(r2) == false) goto L8;
        return null;
    L8:
        return r1.opt(r2);
    }

    private final JSONArray b(String r7) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L25;
        if (Intrinsics.areEqual(r7, "null") == true) goto L25;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        ba r6 = (ba) ZeusTransformUtils.preCheckCast(this, ba.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L16
        if (StringsKt.startsWith$default(r8, "[", false, 2, null) == false) goto L11;
        JSONArray r2 = new JSONArray(r8);     // Catch: Throwable -> L16
    L14:
        Object r9 = Result.m1421constructorimpl(r2);     // Catch: Throwable -> L16
    L19:
        if (Result.m1424exceptionOrNullimpl(r9) == null) goto L22;
        r9 = new JSONArray().put(new JSONObject().put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r7));
    L22:
        Intrinsics.checkNotNullExpressionValue(r9, "getOrElse(...)");
        return (JSONArray) ZeusTransformUtils.preCheckCast(r9, JSONArray.class, "com.obric.memorydata.plugin");
    L11:
        if (StringsKt.startsWith$default(r8, "{", false, 2, null) == false) goto L13;
        r2 = new JSONArray().put(new JSONObject(r8));     // Catch: Throwable -> L16
        goto L14
    L13:
        r2 = new JSONArray().put(new JSONObject().put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r7));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L25:
        return new JSONArray();
    }

    private final Object c(String r4) {
        if (r4 == null) goto L5;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
    L29:
        Object r3 = JSONObject.NULL;
        Intrinsics.checkNotNullExpressionValue(r3, "NULL");
        return r3;
    L11:
        if (Intrinsics.areEqual(r5, "null") == true) goto L29;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        ba r6 = (ba) ZeusTransformUtils.preCheckCast(this, ba.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (StringsKt.startsWith$default(r5, "{", false, 2, null) == false) goto L17;
        Object r7 = new JSONObject(r5);     // Catch: Throwable -> L22
    L20:
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r8) == false) goto L28;
        return r5;
    L28:
        return r8;
    L17:
        if (StringsKt.startsWith$default(r5, "[", false, 2, null) == false) goto L19;
        r7 = new JSONArray(r5);     // Catch: Throwable -> L22
        goto L20
    L19:
        r7 = r5;
    L22:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L5:
        r5 = null;
        goto L6
    }

    public final com.obric.memorydata.memory.review.model.h a(com.obric.memorydata.database.entity.aa r27, Map<Long, String> r28, List<Long> r29, List<RawObservationEntity> r30, MemoryReviewFeedbackState r31) {
        Map<Long, String> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin");
        List<Long> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        List<RawObservationEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r27, "snapshot");
        Intrinsics.checkNotNullParameter(r15, "ruleTitleByRuleId");
        Intrinsics.checkNotNullParameter(r0, "rawObservationIds");
        Intrinsics.checkNotNullParameter(r11, "rawObservations");
        Intrinsics.checkNotNullParameter(r31, "feedbackState");
        JSONObject r9 = a(r27.e());
        MemoryReviewModule r7 = MemoryReviewModule.AUTO_MEMORY_PRO;
        String r17 = com.obric.memorydata.memory.review.model.i.f10395a.a(r7, String.valueOf(r27.a()));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        r0 = az.f10433a.a(r9);
    L8:
        a(r9, r7, r17, r27.a(), r27.c(), "autoMemoryProId", r27.b(), r27.d(), r27.f());
        r9.put("rawObservationIds", az.f10433a.a(r0));
        r9.put("rawObservations", az.f10433a.b(r11));
        a(r9, r27, a(r9, r15));
        String r1 = a(r9, "title");
        if (r1 != null) goto L11;
        r1 = r27.c();
    L11:
        String r19 = r1;
        String r2 = a(r9, Params.CONTENT);
        if (r2 != null) goto L16;
        r2 = a(r9, "subtitle");
        if (r2 != null) goto L16;
        r2 = a(r9, InfoRequestQPSOptTraceLogger.REASON);
    L16:
        String r16 = r9.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
        return new com.obric.memorydata.memory.review.model.h(r17, r7, r19, r2, r16, r31, a(r7, r17, r27.a(), r27.c(), "autoMemoryProId", r27.b(), r27.d(), r27.f(), r9), r27.f());
    }

    public final com.obric.memorydata.memory.review.model.h a(iu r24, Map<String, fa> r25, MemoryReviewFeedbackState r26) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r24, "snapshot");
        Intrinsics.checkNotNullParameter(r11, "relevantDataByEntityId");
        Intrinsics.checkNotNullParameter(r26, "feedbackState");
        JSONObject r10 = a(r24.e());
        MemoryReviewModule r8 = MemoryReviewModule.PERSONAL_MEMORY;
        String r16 = com.obric.memorydata.memory.review.model.i.f10395a.a(r8, String.valueOf(r24.a()));
        a(r10, r8, r16, r24.a(), r24.c(), "unionSemanticMemoryId", r24.b(), r24.d(), r24.f());
        a(r10, r24, (fa) ZeusTransformUtils.preCheckCast(r11.get(r24.c()), fa.class, "com.obric.memorydata.plugin"));
        String r0 = a(r10, "keyPhrase");
        if (r0 != null) goto L7;
        r0 = a(r10, "tagPath");
        if (r0 != null) goto L7;
        r0 = r24.c();
    L7:
        String r15 = r0;
        String r1 = a(r10, "description");
        if (r1 != null) goto L10;
        r1 = a(r10, "embeddingContent");
    L10:
        String r12 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        return new com.obric.memorydata.memory.review.model.h(r16, r8, r15, r1, r12, r26, a(r8, r16, r24.a(), r24.c(), "unionSemanticMemoryId", r24.b(), r24.d(), r24.f(), r10), r24.f());
    }
}
