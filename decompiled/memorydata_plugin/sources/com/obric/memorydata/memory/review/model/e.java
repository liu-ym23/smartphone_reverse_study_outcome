package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0007*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0013*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0016\u0010!\u001a\u0004\u0018\u00010\u0007*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0007H\u0002¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewJsonCodec;", "", "<init>", "()V", "parsePageRequest", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "jsonText", "", "pageToJson", "page", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", "parseFeedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "submitResultToJson", "result", "Lcom/obric/memorydata/memory/review/model/MemoryReviewSubmitResult;", "recordsToJson", "Lorg/json/JSONArray;", "records", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewRecord;", "recordToJson", "Lorg/json/JSONObject;", "record", "feedbackInfoToJson", "feedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackInfo;", "optNullableString", "key", "optNullableLong", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Long;", "optStringArray", "optJsonText", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10388a = null;

    static {
        f10388a = new e();
    }

    private e() {
    }

    private final String a(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L13;
        String r1 = r2.optString(r3);
        Intrinsics.checkNotNull(r1);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
        return null;
    L10:
        return r1;
    L13:
        return null;
    }

    private final JSONArray a(List<h> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        JSONArray r5 = new JSONArray();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        h r1 = (h) ZeusTransformUtils.preCheckCast(r6.next(), h.class, "com.obric.memorydata.plugin");
        r5.put(f10388a.a(r1));
        goto L4
    L6:
        return r5;
    }

    private final JSONObject a(d r5) {
        JSONObject r4 = new JSONObject().put("state", r5.a().getKey());
        MemoryReviewVote r0 = r5.b();
        if (r0 == null) goto L6;
        Object r1 = r0.getKey();
        if (r1 == null) goto L6;
    L7:
        JSONObject r6 = r4.put("vote", r1).put("reasons", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r5.c(), Collection.class, "com.obric.memorydata.plugin"))).put("comment", r5.d()).put("updateTimeMillis", r5.g());
        Intrinsics.checkNotNullExpressionValue(r6, "put(...)");
        return r6;
    L6:
        r1 = JSONObject.NULL;
        goto L7
    }

    private final JSONObject a(h r3) {
        JSONObject r2 = new JSONObject().put("recordId", r3.a()).put("module", r3.b().getKey());
        Object r0 = r3.c();
        if (r0 != null) goto L5;
        r0 = JSONObject.NULL;
    L5:
        JSONObject r4 = r2.put("title", r0);
        Object r1 = r3.d();
        if (r1 != null) goto L8;
        r1 = JSONObject.NULL;
    L8:
        JSONObject r5 = r4.put("summary", r1).put("cardPayloadJson", r3.e()).put("feedbackState", r3.f().getKey());
        Object r6 = r3.g();
        if (r6 != null) goto L11;
        r6 = JSONObject.NULL;
    L11:
        JSONObject r7 = r5.put("traceJson", r6).put("updateTimeMillis", r3.h());
        Intrinsics.checkNotNullExpressionValue(r7, "put(...)");
        return r7;
    }

    private final Long b(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L5;
        return null;
    L5:
        if (r1.isNull(r2) == false) goto L8;
        return null;
    L8:
        return Long.valueOf(r1.optLong(r2));
    }

    private final List<String> c(JSONObject r5, String r6) {
        JSONArray r4 = r5.optJSONArray(r6);
        if (r4 == null) goto L5;
        List<String> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r8 = 0;
        int r1 = r4.length();
    L7:
        if (r8 >= r1) goto L15;
        String r2 = r4.optString(r8);
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        r7.add(r2);
    L14:
        r8 = r8 + 1;
        goto L7
    L15:
        return r7;
    L5:
        return CollectionsKt.emptyList();
    }

    private final String d(JSONObject r3, String r4) {
        Object r0 = null;
        if (r3.has(r4) == true) goto L5;
        return null;
    L5:
        if (r3.isNull(r4) == true) goto L24;
        Object r2 = r3.opt(r4);
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == true) goto L15;
        if (r2 != null) goto L20;
        return null;
    L15:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L22;
        r0 = r2;
    L22:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L20:
        return r2.toString();
    L24:
        return null;
    }

    public final g a(String r18) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r5 = null;
        if (r2 == false) goto L54;
        return null;
    L54:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L46
        e r6 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        JSONObject r7 = new JSONObject(r18);     // Catch: Throwable -> L46
        MemoryReviewModule.a r0 = MemoryReviewModule.Companion;     // Catch: Throwable -> L46
        String r8 = r7.getString("module");     // Catch: Throwable -> L46
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");     // Catch: Throwable -> L46
        MemoryReviewModule r10 = r0.a(r8);     // Catch: Throwable -> L46
        if (r10 != null) goto L15;
        return null;
    L15:
        String r9 = r6.a(r7, "pageCursor");     // Catch: Throwable -> L46
        if (r9 != null) goto L18;
        r9 = r6.a(r7, "cursor");     // Catch: Throwable -> L46
    L18:
        String r11 = r9;
        b r12 = a.f10381a.a(r11);     // Catch: Throwable -> L46
        if (r12 == null) goto L25;
        Long r13 = Long.valueOf(r12.a());     // Catch: Throwable -> L46
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue() == Long.MAX_VALUE) goto L23;
        r3 = true;
    L23:
        if (r3 == false) goto L25;
    L26:
        int r14 = r7.optInt("pageSize", 10);     // Catch: Throwable -> L46
        Long r15 = r6.b(r7, "observeFromTimeMillis");     // Catch: Throwable -> L46
        if (r15 == null) goto L30;
    L28:
        long r16 = r15.longValue();     // Catch: Throwable -> L46
    L29:
        long r17 = r16;
        if (r13 == null) goto L37;
    L35:
        long r19 = r13.longValue();     // Catch: Throwable -> L46
    L44:
        Object r20 = Result.m1421constructorimpl(new g(r10, r11, r14, r17, r19));     // Catch: Throwable -> L46
    L49:
        if (Result.m1427isFailureimpl(r20) == true) goto L53;
        r5 = r20;
    L53:
        return (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.memorydata.plugin");
    L37:
        r13 = r6.b(r7, "windowEndTimeMillis");     // Catch: Throwable -> L46
        if (r13 != null) goto L35;
        r13 = r6.b(r7, "endTimeMillis");     // Catch: Throwable -> L46
        if (r13 != null) goto L35;
        r19 = System.currentTimeMillis();     // Catch: Throwable -> L46
        goto L44
    L30:
        r15 = r6.b(r7, "startTimeMillis");     // Catch: Throwable -> L46
        if (r15 != null) goto L28;
        r16 = 0;
    L25:
        r13 = null;
    L46:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r20 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L49
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final String a(f r8) {
        Intrinsics.checkNotNullParameter(r8, "page");
        JSONArray r0 = a(r8.d());
        JSONArray r7 = a(r8.e());
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, d>> r2 = r8.f().entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
        d r5 = (d) ZeusTransformUtils.preCheckCast(r3.getValue(), d.class, "com.obric.memorydata.plugin");
        r1.put(r4, f10388a.a(r5));
        goto L4
    L6:
        JSONObject r9 = new JSONObject().put("module", r8.a().getKey()).put("observeFromTimeMillis", r8.b()).put("windowEndTimeMillis", r8.c()).put("pendingRecords", r0).put("completedRecords", r7).put("feedbackByRecordId", r1);
        Object r6 = r8.g();
        if (r6 != null) goto L9;
        r6 = JSONObject.NULL;
    L9:
        JSONObject r10 = r9.put("nextPageCursor", r6);
        Object r11 = r8.i();
        if (r11 != null) goto L12;
        r11 = JSONObject.NULL;
    L12:
        String r12 = r10.put("nextCursor", r11).put("hasMore", r8.h()).toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        return r12;
    }

    public final String a(j r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        String r2 = new JSONObject().put("accepted", r3.a()).put("message", r3.b()).toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }

    public final c b(String r21) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        Object r6 = null;
        if (r5 == false) goto L46;
        return null;
    L46:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L38
        e r8 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        JSONObject r9 = new JSONObject(r21);     // Catch: Throwable -> L38
        MemoryReviewModule.a r0 = MemoryReviewModule.Companion;     // Catch: Throwable -> L38
        String r10 = r9.getString("module");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");     // Catch: Throwable -> L38
        MemoryReviewModule r11 = r0.a(r10);     // Catch: Throwable -> L38
        if (r11 != null) goto L15;
        return null;
    L15:
        MemoryReviewVote.a r1 = MemoryReviewVote.Companion;     // Catch: Throwable -> L38
        String r12 = r9.getString("vote");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");     // Catch: Throwable -> L38
        MemoryReviewVote r13 = r1.a(r12);     // Catch: Throwable -> L38
        if (r13 != null) goto L18;
        return null;
    L18:
        String r14 = r9.getString("recordId");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");     // Catch: Throwable -> L38
        List<String> r15 = r8.c(r9, "reasons");     // Catch: Throwable -> L38
        String r16 = r9.optString("comment", "");     // Catch: Throwable -> L38
        Intrinsics.checkNotNullExpressionValue(r16, "optString(...)");     // Catch: Throwable -> L38
        String r3 = r8.d(r9, "businessPayloadJson");     // Catch: Throwable -> L38
        if (r3 != null) goto L30;
        r3 = r8.d(r9, "businessPayload");     // Catch: Throwable -> L38
        if (r3 != null) goto L30;
        r3 = r8.d(r9, "displayedCard");     // Catch: Throwable -> L38
        if (r3 != null) goto L30;
        r3 = r8.d(r9, "displayedCardJson");     // Catch: Throwable -> L38
        if (r3 != null) goto L30;
        String r2 = r8.a(r9, "displayedCardJson");     // Catch: Throwable -> L38
        if (r2 != null) goto L29;
        r2 = "{}";
    L29:
        String r17 = r2;
    L31:
        String r18 = r8.d(r9, "trace");     // Catch: Throwable -> L38
        if (r18 != null) goto L36;
        r18 = r8.d(r9, "traceJson");     // Catch: Throwable -> L38
        if (r18 != null) goto L36;
        r18 = r8.a(r9, "traceJson");     // Catch: Throwable -> L38
    L36:
        Object r19 = Result.m1421constructorimpl(new c(r14, r11, r13, r15, r16, r17, r18, null, 128, null));     // Catch: Throwable -> L38
    L41:
        if (Result.m1427isFailureimpl(r19) == true) goto L45;
        r6 = r19;
    L45:
        return (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin");
    L30:
        r17 = r3;
    L38:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L41
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r5 = false;
        goto L9
    }
}
