package com.obric.memorydata.memory.review.provider;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.bt;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0002J*\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010\u0018H\u0002¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/EntityMemoryReviewRecordMapper;", "", "<init>", "()V", "fromScreenMemory", "Lcom/obric/memorydata/memory/review/model/MemoryReviewRecord;", "entity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "relevant", "Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "rawObservationIds", "", "", "rawObservations", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "feedbackState", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "fromCollectionMemory", "pojo", "Lcom/obric/memorydata/database/entity/EpisodicWithRelevantPojo;", "fromAudioMemory", "episodicPayload", "Lorg/json/JSONObject;", "screenMemoryTitle", "", "episodicSourceType", "episodicEvidenceList", "Lorg/json/JSONArray;", "sourceInfoJson", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "traceJson", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "recordId", "sourceDbId", "logId", "parseJsonValueOrNull", "jsonText", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f10473a = null;

    static {
        f10473a = new w();
    }

    private w() {
    }

    private final Object a(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L27;
        Object r4 = JSONObject.NULL;
        Intrinsics.checkNotNullExpressionValue(r4, "NULL");
        return r4;
    L27:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        w r6 = (w) ZeusTransformUtils.preCheckCast(this, w.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L21
        if (StringsKt.startsWith$default(r7, "{", false, 2, null) == false) goto L16;
        Object r3 = new JSONObject(r7);     // Catch: Throwable -> L21
    L19:
        Object r8 = Result.m1421constructorimpl(r3);     // Catch: Throwable -> L21
    L24:
        if (Result.m1424exceptionOrNullimpl(r8) == null) goto L26;
        return r5;
    L26:
        return r8;
    L16:
        if (StringsKt.startsWith$default(r7, "[", false, 2, null) == false) goto L18;
        r3 = new JSONArray(r7);     // Catch: Throwable -> L21
        goto L19
    L18:
        r3 = r5;
    L21:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String a(es r6) {
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
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.g(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L26;
    L29:
        boolean r7 = true;
    L30:
        if (r7 == true) goto L33;
        return "screenshot";
    L33:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L36;
    L39:
        boolean r9 = true;
    L40:
        if (r9 == true) goto L43;
        return "original_text";
    L43:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.e(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L46;
    L47:
        r1 = true;
    L48:
        if (r1 == true) goto L51;
        return "source_link";
    L51:
        return "unknown";
    L46:
        if (StringsKt.isBlank(r10) == false) goto L48;
    L36:
        if (StringsKt.isBlank(r8) == true) goto L39;
        r9 = false;
        goto L40
    L26:
        if (StringsKt.isBlank(r5) == true) goto L29;
        r7 = false;
        goto L30
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r2 = false;
        goto L12
    }

    private final String a(MemoryReviewModule r2, String r3, long r4, String r6) {
        JSONObject r1 = new JSONObject().put("module", r2.getKey()).put("recordId", r3).put("sourceDbId", r4);
        Object r7 = r6;
        if (r6 != null) goto L5;
        r7 = JSONObject.NULL;
    L5:
        String r5 = r1.put("logId", r7).toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        return r5;
    }

    private final JSONObject a(EpisodicMemoryEntity r4) {
        JSONObject r3 = new JSONObject().put(OaidModel.KEY_ID, r4.getId()).put("entityId", r4.getEntityId()).put("createTime", r4.getCreateTime()).put("modifyTime", r4.getModifyTime()).put("timestamp", r4.getTimestamp()).put(ObricMemoryConstants.KEY_PACKAGE_NAME, r4.getPackageName());
        Object r0 = r4.getUuid();
        if (r0 != null) goto L5;
        r0 = JSONObject.NULL;
    L5:
        JSONObject r5 = r3.put(Api.KEY_UUID, r0).put("title", r4.getTitle()).put(Params.CONTENT, r4.getContent());
        Object r1 = r4.getContentWithTime();
        if (r1 != null) goto L8;
        r1 = JSONObject.NULL;
    L8:
        JSONObject r6 = r5.put("contentWithTime", r1);
        Object r2 = r4.getFullContent();
        if (r2 != null) goto L11;
        r2 = JSONObject.NULL;
    L11:
        JSONObject r7 = r6.put("fullContent", r2).put("observation", r4.getObservation()).put("location", r4.getLocation()).put("appNames", r4.getAppNames());
        Object r8 = r4.getCategory();
        if (r8 != null) goto L14;
        r8 = JSONObject.NULL;
    L14:
        JSONObject r9 = r7.put(EventBody.KEY_CATEGORY, r8);
        Object r10 = r4.getProfileType();
        if (r10 != null) goto L17;
        r10 = JSONObject.NULL;
    L17:
        JSONObject r11 = r9.put("profileType", r10);
        Object r12 = r4.getProfileTag();
        if (r12 != null) goto L20;
        r12 = JSONObject.NULL;
    L20:
        JSONObject r13 = r11.put("profileTag", r12);
        Object r14 = r4.getTagOther();
        if (r14 != null) goto L23;
        r14 = JSONObject.NULL;
    L23:
        JSONObject r15 = r13.put("tagOther", r14);
        Object r16 = r4.getLogId();
        if (r16 != null) goto L26;
        r16 = JSONObject.NULL;
    L26:
        JSONObject r17 = r15.put("logId", r16).put("startTimestamp", r4.getStartTimestamp()).put("endTimestamp", r4.getEndTimestamp()).put("productType", r4.getProductType());
        Object r18 = r4.getUserEdit();
        if (r18 != null) goto L29;
        r18 = JSONObject.NULL;
    L29:
        JSONObject r19 = r17.put("userEdit", r18);
        Intrinsics.checkNotNullExpressionValue(r19, "put(...)");
        return r19;
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

    private final String b(EpisodicMemoryEntity r8) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8.getTitle(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == true) goto L8;
        int r9 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r8.getContent(), CharSequence.class, "com.obric.memorydata.plugin"), "\n- ", 0, false, 6, null);
        if (r9 < 0) goto L13;
        String r10 = r8.getContent().substring(0, r9);
        Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        return r10;
    L13:
        return r8.getContent();
    L8:
        return r8.getTitle();
    L5:
        r7 = false;
        goto L6
    }

    private final JSONArray b(es r10) {
        JSONArray r0 = new JSONArray();
        if (r10 != null) goto L5;
        return r0;
    L5:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.d(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L25;
        JSONObject r4 = new JSONObject();
        String r8 = "dialog_bubble";
        if (Intrinsics.areEqual(a(r10), "dialog_bubble") == true) goto L18;
        r8 = "original_text";
    L18:
        JSONObject r5 = r4.put("type", r8).put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r10.d());
        Object r7 = r10.c();
        if (r7 != null) goto L21;
        r7 = JSONObject.NULL;
    L21:
        JSONObject r6 = r5.put(ChatMessage.TYPE_QUERY, r7);
        Object r9 = r10.m();
        if (r9 != null) goto L24;
        r9 = JSONObject.NULL;
    L24:
        r0.put(r6.put("summary", r9));
    L25:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.g(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L28;
    L31:
        boolean r12 = true;
    L32:
        if (r12 == true) goto L37;
        JSONObject r13 = new JSONObject().put("type", "screenshot").put("screenshot", a(r10.g()));
        Object r14 = r10.m();
        if (r14 != null) goto L36;
        r14 = JSONObject.NULL;
    L36:
        r0.put(r13.put("summary", r14));
    L37:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.e(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L40;
    L41:
        r2 = true;
    L42:
        if (r2 == true) goto L50;
        JSONObject r16 = new JSONObject().put("type", "source_link").put("link", r10.e());
        Object r17 = r10.f();
        if (r17 != null) goto L46;
        r17 = JSONObject.NULL;
    L46:
        JSONObject r18 = r16.put("linkType", r17);
        Object r19 = r10.m();
        if (r19 != null) goto L49;
        r19 = JSONObject.NULL;
    L49:
        r0.put(r18.put("summary", r19));
    L50:
        return r0;
    L40:
        if (StringsKt.isBlank(r15) == false) goto L42;
    L28:
        if (StringsKt.isBlank(r11) == true) goto L31;
        r12 = false;
        goto L32
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r3 = false;
        goto L13
    }

    public final com.obric.memorydata.memory.review.model.h a(EpisodicMemoryEntity r19, es r20, List<Long> r21, List<RawObservationEntity> r22, MemoryReviewFeedbackState r23) {
        List<Long> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        List<RawObservationEntity> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "entity");
        Intrinsics.checkNotNullParameter(r2, "rawObservationIds");
        Intrinsics.checkNotNullParameter(r3, "rawObservations");
        Intrinsics.checkNotNullParameter(r23, "feedbackState");
        MemoryReviewModule r10 = MemoryReviewModule.SCREEN_MEMORY;
        JSONObject r4 = a(r19).put("module", r10.getKey()).put("recordId", r19.getEntityId()).put("rawObservationIds", az.f10433a.a(r2)).put("rawObservations", az.f10433a.b(r3)).put("sourceType", a(r20));
        String r5 = null;
        if (r20 == null) goto L5;
        String r6 = r20.i();
    L6:
        if (r20 == null) goto L8;
        String r7 = r20.h();
    L9:
        JSONObject r8 = r4.put("sourceInfo", a(r6, r7)).put("evidenceList", b(r20));
        if (r20 == null) goto L13;
        Object r9 = r20.c();
        if (r9 == null) goto L13;
    L14:
        JSONObject r11 = r8.put("sourceQuery", r9);
        if (r20 == null) goto L18;
        Object r12 = r20.d();
        if (r12 == null) goto L18;
    L19:
        JSONObject r13 = r11.put("sourceText", r12);
        if (r20 == null) goto L22;
        r5 = r20.g();
    L22:
        JSONObject r14 = r13.put("screenshot", a(r5));
        if (r20 == null) goto L26;
        Object r15 = r20.h();
        if (r15 == null) goto L26;
    L27:
        JSONObject r16 = r14.put("sourcePackageName", r15);
        if (r20 == null) goto L31;
        Object r1 = r20.i();
        if (r1 == null) goto L31;
    L32:
        JSONObject r17 = r16.put("sourceAppName", r1);
        String r18 = r19.getEntityId();
        String r110 = b(r19);
        String r111 = r19.getContent();
        String r112 = r17.toString();
        Intrinsics.checkNotNullExpressionValue(r112, "toString(...)");
        return new com.obric.memorydata.memory.review.model.h(r18, r10, r110, r111, r112, r23, a(r10, r19.getEntityId(), r19.getId(), r19.getLogId()), r19.getStartTimestamp());
    L31:
        r1 = JSONObject.NULL;
    L26:
        r15 = JSONObject.NULL;
    L18:
        r12 = JSONObject.NULL;
    L13:
        r9 = JSONObject.NULL;
        goto L14
    L8:
        r7 = null;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    public final com.obric.memorydata.memory.review.model.h a(EpisodicMemoryEntity r14, MemoryReviewFeedbackState r15) {
        Intrinsics.checkNotNullParameter(r14, "entity");
        Intrinsics.checkNotNullParameter(r15, "feedbackState");
        MemoryReviewModule r0 = MemoryReviewModule.AUDIO_MEMORY;
        JSONObject r1 = new JSONObject().put("createTime", r14.getCreateTime()).put("modifyTime", r14.getModifyTime());
        Object r2 = r14.getUuid();
        if (r2 != null) goto L5;
        r2 = JSONObject.NULL;
    L5:
        JSONObject r3 = r1.put(Api.KEY_UUID, r2).put("title", r14.getTitle()).put(Params.CONTENT, r14.getContent()).put("startTimestamp", r14.getStartTimestamp()).put("endTimestamp", r14.getEndTimestamp()).put("productType", r14.getProductType());
        Object r4 = r14.getLogId();
        if (r4 != null) goto L8;
        r4 = JSONObject.NULL;
    L8:
        JSONObject r5 = r3.put("logId", r4);
        String r7 = r14.getEntityId();
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getTitle(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r6) == false) goto L11;
        r6 = r14.getContent();
    L11:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        String r9 = r14.getContent();
        String r10 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
        return new com.obric.memorydata.memory.review.model.h(r7, r0, r8, r9, r10, r15, a(r0, r14.getEntityId(), r14.getId(), r14.getLogId()), r14.getModifyTime());
    }

    public final com.obric.memorydata.memory.review.model.h a(bt r14, MemoryReviewFeedbackState r15) {
        Intrinsics.checkNotNullParameter(r14, "pojo");
        Intrinsics.checkNotNullParameter(r15, "feedbackState");
        EpisodicMemoryEntity r0 = r14.a();
        es r16 = r14.b();
        MemoryReviewModule r7 = MemoryReviewModule.COLLECTION_MEMORY;
        Object r1 = a(r16);
        Object r2 = b(r16);
        String r4 = null;
        if (r16 == null) goto L12;
        String r5 = r16.m();
        if (r5 == null) goto L12;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L12;
    L13:
        String r8 = r5;
        JSONObject r6 = a(r0).put("module", r7.getKey()).put("recordId", r0.getEntityId());
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r0.getTitle(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r9) == false) goto L16;
        r9 = r0.getContent();
    L16:
        JSONObject r3 = r6.put("displayTitle", r9).put("displaySummary", r8).put("memoryContent", r0.getContent()).put("sourceType", r1);
        if (r16 == null) goto L19;
        String r10 = r16.i();
    L20:
        if (r16 == null) goto L22;
        String r11 = r16.h();
    L23:
        JSONObject r12 = r3.put("sourceInfo", a(r10, r11)).put("evidenceList", r2);
        if (r16 == null) goto L27;
        Object r13 = r16.c();
        if (r13 == null) goto L27;
    L28:
        JSONObject r17 = r12.put("sourceQuery", r13);
        if (r16 == null) goto L32;
        Object r18 = r16.d();
        if (r18 == null) goto L32;
    L33:
        JSONObject r19 = r17.put("sourceText", r18);
        if (r16 == null) goto L37;
        Object r20 = r16.e();
        if (r20 == null) goto L37;
    L38:
        JSONObject r21 = r19.put("sourceLink", r20);
        if (r16 == null) goto L42;
        Object r22 = r16.f();
        if (r22 == null) goto L42;
    L43:
        JSONObject r23 = r21.put("sourceLinkType", r22);
        if (r16 == null) goto L46;
        String r24 = r16.g();
    L47:
        JSONObject r25 = r23.put("screenshot", a(r24));
        if (r16 == null) goto L51;
        Object r26 = r16.h();
        if (r26 == null) goto L51;
    L52:
        JSONObject r27 = r25.put("sourcePackageName", r26);
        if (r16 == null) goto L56;
        Object r28 = r16.i();
        if (r28 == null) goto L56;
    L57:
        JSONObject r29 = r27.put("sourceAppName", r28);
        if (r16 == null) goto L60;
        r4 = r16.l();
    L60:
        JSONObject r30 = r29.put("tagList", a(r4));
        if (r16 == null) goto L64;
        Object r31 = r16.m();
        if (r31 == null) goto L64;
    L65:
        JSONObject r32 = r30.put("sourceSummary", r31);
        if (r16 == null) goto L68;
        Object r110 = Integer.valueOf(r16.n());
    L69:
        JSONObject r111 = r32.put("detailStatus", r110);
        String r33 = r0.getEntityId();
        CharSequence r34 = (CharSequence) ZeusTransformUtils.preCheckCast(r0.getTitle(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r34) == false) goto L72;
        r34 = r0.getContent();
    L72:
        String r112 = (String) ZeusTransformUtils.preCheckCast(r34, String.class, "com.obric.memorydata.plugin");
        String r113 = r111.toString();
        Intrinsics.checkNotNullExpressionValue(r113, "toString(...)");
        return new com.obric.memorydata.memory.review.model.h(r33, r7, r112, r8, r113, r15, a(r7, r0.getEntityId(), r0.getId(), r0.getLogId()), r0.getModifyTime());
    L68:
        r110 = JSONObject.NULL;
    L64:
        r31 = JSONObject.NULL;
    L56:
        r28 = JSONObject.NULL;
    L51:
        r26 = JSONObject.NULL;
        goto L52
    L46:
        r24 = null;
    L42:
        r22 = JSONObject.NULL;
    L37:
        r20 = JSONObject.NULL;
    L32:
        r18 = JSONObject.NULL;
    L27:
        r13 = JSONObject.NULL;
        goto L28
    L22:
        r11 = null;
        goto L23
    L19:
        r10 = null;
    L12:
        r5 = r0.getContent();
        goto L13
    }
}
