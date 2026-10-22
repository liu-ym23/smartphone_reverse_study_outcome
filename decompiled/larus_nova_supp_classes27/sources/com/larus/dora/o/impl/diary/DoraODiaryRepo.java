package com.larus.dora.o.impl.diary;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.account.base.api.ILoginService;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraODiaryRepo {
    public static final DoraODiaryRepo a = null;

    static {
        a = new DoraODiaryRepo();
    }

    public DoraODiaryRepo() {
    }

    public static JSONObject a(l0 r3) {
        if (r3 == null) goto L5;
        String r1 = r3.c;
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        if (r3 == null) goto L10;
        int r4 = r3.d;
    L12:
        if (StringsKt.isBlank(r1) == false) goto L15;
        if (r4 > 0) goto L15;
        return null;
    L15:
        JSONObject r0 = new JSONObject();
        if (r4 <= 0) goto L19;
        r0.put("diary_version", r4);
    L19:
        if ((!StringsKt.isBlank(r1)) == false) goto L21;
        JSONObject r5 = new JSONObject();
        r5.put("snapshot_json", r1);
        Unit r2 = Unit.INSTANCE;
        r0.put("extra", r5);
    L21:
        return r0;
    L10:
        r4 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final Object g(Continuation<? super u0> r9) {
        if ((r9 instanceof DoraODiaryRepo$fetchStyleList$1) == false) goto L7;
        DoraODiaryRepo$fetchStyleList$1 r0 = (DoraODiaryRepo$fetchStyleList$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$fetchStyleList$1 r6 = r0;
        Object r10 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L23
    L19:
        com.larus.network.http.y r11 = (com.larus.network.http.a) r10;     // Catch: Exception -> L23
        if ((r11 instanceof com.larus.network.http.y) == false) goto L25;
        return (u0) ((com.larus.network.http.a) r11).b;
    L25:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L23
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L23
        r4.put("dora_sub_biz", FlowDoraSubBizType.a.a());     // Catch: Exception -> L23
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L23
        r6.label = 1;     // Catch: Exception -> L23
        r10 = com.larus.dora.api.network.a.c(r5, u0.class, "/alice/wearable/diary/get_style", r4, null, r6, 248);     // Catch: Exception -> L23
        if (r10 != r2) goto L19;
        return r2;
    L23:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "fetchStyleList error: " + e.getMessage());
    L7:
        r0 = new DoraODiaryRepo$fetchStyleList$1(this, r9);
        goto L8
    }

    public final Object b(List<String> r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof DoraODiaryRepo$deleteDiary$1) == false) goto L7;
        DoraODiaryRepo$deleteDiary$1 r0 = (DoraODiaryRepo$deleteDiary$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$deleteDiary$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L21
    L19:
        boolean r12 = ((com.larus.network.http.a) r11) instanceof com.larus.network.http.y;     // Catch: Exception -> L21
    L24:
        return Boxing.boxBoolean(r12);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L21
        r4.put("diary_ids", new JSONArray(r9));     // Catch: Exception -> L21
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L21
        r6.label = 1;     // Catch: Exception -> L21
        r11 = com.larus.dora.api.network.a.c(r5, Object.class, "/alice/wearable/diary/delete_user_diary", r4, null, r6, 248);     // Catch: Exception -> L21
        if (r11 != r2) goto L19;
        return r2;
    L21:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "deleteDiary error: " + e.getMessage());
        r12 = false;
    L7:
        r0 = new DoraODiaryRepo$deleteDiary$1(this, r10);
        goto L8
    }

    public final Object c(String r9, Continuation<? super Boolean> r10) {
        if ((r10 instanceof DoraODiaryRepo$deleteStyle$1) == false) goto L7;
        DoraODiaryRepo$deleteStyle$1 r0 = (DoraODiaryRepo$deleteStyle$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$deleteStyle$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L21
    L19:
        boolean r12 = ((com.larus.network.http.a) r11) instanceof com.larus.network.http.y;     // Catch: Exception -> L21
    L24:
        return Boxing.boxBoolean(r12);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L21
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L21
        r4.put("dora_sub_biz", FlowDoraSubBizType.a.a());     // Catch: Exception -> L21
        r4.put("style_id", r9);     // Catch: Exception -> L21
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L21
        r6.label = 1;     // Catch: Exception -> L21
        r11 = com.larus.dora.api.network.a.c(r5, Object.class, "/alice/wearable/diary/delete_style", r4, null, r6, 248);     // Catch: Exception -> L21
        if (r11 != r2) goto L19;
        return r2;
    L21:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "deleteStyle error: " + e.getMessage());
        r12 = false;
    L7:
        r0 = new DoraODiaryRepo$deleteStyle$1(this, r10);
        goto L8
    }

    public final Object e(String r11, Continuation<? super String> r12) {
        if ((r12 instanceof DoraODiaryRepo$fetchDetailRawJson$1) == false) goto L7;
        DoraODiaryRepo$fetchDetailRawJson$1 r1 = (DoraODiaryRepo$fetchDetailRawJson$1) r12;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$fetchDetailRawJson$1 r7 = r1;
        Object r13 = r7.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r7.label;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        r11 = (String) r7.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L29
    L20:
        com.larus.network.http.y r14 = (com.larus.network.http.a) r13;     // Catch: Exception -> L29
        if ((r14 instanceof com.larus.network.http.y) == false) goto L27;
        b0 r15 = (b0) ((com.larus.network.http.a) r14).b;     // Catch: Exception -> L29
        if (r15 == null) goto L31;
        JsonObject r16 = r15.a();     // Catch: Exception -> L29
        if (r16 == null) goto L31;
        return r16.toString();
    L31:
        return null;
    L27:
        FLogger.a.e("DoraODiaryRepo", "fetchDetailRawJson failed, diaryId=" + r11);     // Catch: Exception -> L29
        goto L31
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L29
        r5.put("user_id", ILoginService.a.getAccountInfo().d);     // Catch: Exception -> L29
        r5.put("diary_id", r11);     // Catch: Exception -> L29
        com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L29
        r7.L$0 = r11;     // Catch: Exception -> L29
        r7.label = 1;     // Catch: Exception -> L29
        r13 = com.larus.dora.api.network.a.c(r6, b0.class, "/alice/wearable/diary/get_diary_detail_v2", r5, null, r7, 248);     // Catch: Exception -> L29
        if (r13 != r3) goto L20;
        return r3;
    L29:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "fetchDetailRawJson error: " + e.getMessage());
    L7:
        r1 = new DoraODiaryRepo$fetchDetailRawJson$1(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public final Object f(int r10, Continuation<? super Map<Integer, ? extends List<String>>> r11) {
        if ((r11 instanceof DoraODiaryRepo$fetchFeedbackReasons$1) == false) goto L7;
        DoraODiaryRepo$fetchFeedbackReasons$1 r0 = (DoraODiaryRepo$fetchFeedbackReasons$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$fetchFeedbackReasons$1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L58
    L19:
        com.larus.network.http.y r13 = (com.larus.network.http.a) r12;     // Catch: Exception -> L58
        if ((r13 instanceof com.larus.network.http.y) == false) goto L22;
        com.larus.network.http.y r14 = r13;     // Catch: Exception -> L58
    L23:
        if (r14 == null) goto L25;
        e0 r15 = (e0) ((com.larus.network.http.a) r14).b;     // Catch: Exception -> L58
    L26:
        if (r15 == null) goto L28;
        Map<String, List<String>> r16 = r15.a();     // Catch: Exception -> L58
    L29:
        if (r16 != null) goto L31;
        r16 = MapsKt.emptyMap();     // Catch: Exception -> L58
    L31:
        Set<Map.Entry<String, List<String>>> r17 = r16.entrySet();     // Catch: Exception -> L58
        ArrayList r18 = new ArrayList();     // Catch: Exception -> L58
        Iterator<T> r110 = r17.iterator();     // Catch: Exception -> L58
    L33:
        if (r110.hasNext() == false) goto L56;
        Map.Entry r4 = (Map.Entry) r110.next();     // Catch: Exception -> L58
        String r5 = (String) r4.getKey();     // Catch: Exception -> L58
        List r7 = (List) r4.getValue();     // Catch: Exception -> L58
        Integer r8 = StringsKt.toIntOrNull(r5);     // Catch: Exception -> L58
        if (r8 == null) goto L53;
        int r9 = r8.intValue();     // Catch: Exception -> L58
        if (r7 == null) goto L46;
        List r20 = CollectionsKt.filterNotNull(r7);     // Catch: Exception -> L58
        if (r20 == null) goto L46;
        List r21 = new ArrayList();     // Catch: Exception -> L58
        Iterator r22 = r20.iterator();     // Catch: Exception -> L58
    L42:
        if (r22.hasNext() == false) goto L47;
        Object r23 = r22.next();     // Catch: Exception -> L58
        if ((!StringsKt.isBlank((String) r23)) == false) goto L42;
        r21.add(r23);     // Catch: Exception -> L58
    L47:
        if (r21 != 0) goto L50;
        r21 = CollectionsKt.emptyList();     // Catch: Exception -> L58
    L50:
        if (r21.isEmpty() == true) goto L53;
        Pair r24 = TuplesKt.to(Boxing.boxInt(r9), r21);     // Catch: Exception -> L58
    L54:
        if (r24 == null) goto L33;
        r18.add(r24);     // Catch: Exception -> L58
    L46:
        r21 = 0;
    L53:
        r24 = null;
        goto L54
    L56:
        return MapsKt.toMap(r18);
    L28:
        r16 = null;
        goto L29
    L25:
        r15 = null;
        goto L26
    L22:
        r14 = null;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        com.larus.dora.api.network.a r25 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L58
        JSONObject r26 = new JSONObject();     // Catch: Exception -> L58
        r26.put("scene", 2);     // Catch: Exception -> L58
        r26.put("target_type", r10);     // Catch: Exception -> L58
        Unit r111 = Unit.INSTANCE;     // Catch: Exception -> L58
        r6.label = 1;     // Catch: Exception -> L58
        r12 = com.larus.dora.api.network.a.c(r25, e0.class, "/alice/wearable/feedback/get_config", r26, null, r6, 248);     // Catch: Exception -> L58
        if (r12 != r2) goto L19;
        return r2;
    L58:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "fetchFeedbackReasons error: " + e.getMessage());
        return MapsKt.emptyMap();
    L7:
        r0 = new DoraODiaryRepo$fetchFeedbackReasons$1(this, r11);
        goto L8
    }

    public final Object h(t0 r9, Continuation<? super v0> r10) {
        if ((r10 instanceof DoraODiaryRepo$setStyle$1) == false) goto L7;
        DoraODiaryRepo$setStyle$1 r0 = (DoraODiaryRepo$setStyle$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$setStyle$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L23
    L19:
        com.larus.network.http.y r12 = (com.larus.network.http.a) r11;     // Catch: Exception -> L23
        if ((r12 instanceof com.larus.network.http.y) == false) goto L25;
        return (v0) ((com.larus.network.http.a) r12).b;
    L25:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L23
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L23
        r4.put("dora_sub_biz", FlowDoraSubBizType.a.a());     // Catch: Exception -> L23
        r4.put("style_info", new JSONObject(new Gson().toJson(r9)));     // Catch: Exception -> L23
        r4.put("req_id", UUID.randomUUID().toString());     // Catch: Exception -> L23
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L23
        r6.label = 1;     // Catch: Exception -> L23
        r11 = com.larus.dora.api.network.a.c(r5, v0.class, "/alice/wearable/diary/set_style", r4, null, r6, 248);     // Catch: Exception -> L23
        if (r11 != r2) goto L19;
        return r2;
    L23:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "setStyle error: " + e.getMessage());
    L7:
        r0 = new DoraODiaryRepo$setStyle$1(this, r10);
        goto L8
    }

    public final Object j(t0 r9, Continuation<? super v0> r10) {
        if ((r10 instanceof DoraODiaryRepo$updateStyle$1) == false) goto L7;
        DoraODiaryRepo$updateStyle$1 r0 = (DoraODiaryRepo$updateStyle$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$updateStyle$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L23
    L19:
        com.larus.network.http.y r12 = (com.larus.network.http.a) r11;     // Catch: Exception -> L23
        if ((r12 instanceof com.larus.network.http.y) == false) goto L25;
        return (v0) ((com.larus.network.http.a) r12).b;
    L25:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r11);
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L23
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L23
        r4.put("dora_sub_biz", FlowDoraSubBizType.a.a());     // Catch: Exception -> L23
        r4.put("style_info", new JSONObject(new Gson().toJson(r9)));     // Catch: Exception -> L23
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L23
        r6.label = 1;     // Catch: Exception -> L23
        r11 = com.larus.dora.api.network.a.c(r5, v0.class, "/alice/wearable/diary/update_style", r4, null, r6, 248);     // Catch: Exception -> L23
        if (r11 != r2) goto L19;
        return r2;
    L23:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "updateStyle error: " + e.getMessage());
    L7:
        r0 = new DoraODiaryRepo$updateStyle$1(this, r10);
        goto L8
    }

    public final Object d(String r10, Integer r11, Continuation<? super j> r12) {
        if ((r12 instanceof DoraODiaryRepo$fetchBriefList$1) == false) goto L7;
        DoraODiaryRepo$fetchBriefList$1 r0 = (DoraODiaryRepo$fetchBriefList$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$fetchBriefList$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L28
    L23:
        com.larus.network.http.y r14 = (com.larus.network.http.a) r13;     // Catch: Exception -> L28
        if ((r14 instanceof com.larus.network.http.y) == true) goto L33;
        FLogger.a.e("DoraODiaryRepo", "fetchBriefList failed");     // Catch: Exception -> L28
    L30:
        return null;
    L33:
        return (j) ((com.larus.network.http.a) r14).b;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L28
        if (r11 == null) goto L19;
        int r15 = r11.intValue();     // Catch: Exception -> L28
    L20:
        r4.put("biz_id", r15);     // Catch: Exception -> L28
        r4.put("cursor", r10);     // Catch: Exception -> L28
        com.larus.dora.api.network.a r5 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L28
        r6.label = 1;     // Catch: Exception -> L28
        r13 = com.larus.dora.api.network.a.c(r5, j.class, "/alice/wearable/diary/list_user_diary_brief", r4, null, r6, 248);     // Catch: Exception -> L28
        if (r13 != r2) goto L23;
        return r2;
    L19:
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L28
        r15 = FlowDoraSubBizType.a.a();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "fetchBriefList error: " + e.getMessage());
    L7:
        r0 = new DoraODiaryRepo$fetchBriefList$1(this, r12);
        goto L8
    }

    public final Object i(String r17, int r18, List<String> r110, String r20, Integer r21, l0 r22, Continuation<? super Boolean> r23) {
        int r0 = r18;
        if ((r23 instanceof DoraODiaryRepo$submitFeedback$1) == false) goto L7;
        DoraODiaryRepo$submitFeedback$1 r4 = (DoraODiaryRepo$submitFeedback$1) r23;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        DoraODiaryRepo$submitFeedback$1 r11 = r4;
        Object r2 = r11.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r11.label;
        boolean r13 = false;
        boolean r14 = true;
        if (r7 == 0) goto L16;
        if (r7 != 1) goto L15;
        r0 = r11.I$0;
        String r1 = (String) r11.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Exception -> L60
    L54:
        boolean r3 = ((com.larus.network.http.a) r2) instanceof com.larus.network.http.y;     // Catch: Exception -> L60
        FLogger r8 = FLogger.a;     // Catch: Exception -> L60
        StringBuilder r9 = new StringBuilder("submitFeedback diary=");     // Catch: Exception -> L60
        r9.append(r1);     // Catch: Exception -> L60
        r9.append(" action=");     // Catch: Exception -> L60
        r9.append(r0);     // Catch: Exception -> L60
        r9.append(" ok=");     // Catch: Exception -> L60
        if (r3 == true) goto L58;
        r14 = false;
    L58:
        r9.append(r14);     // Catch: Exception -> L60
        r8.i("DoraODiaryRepo", r9.toString());     // Catch: Exception -> L60
        r13 = r3;
    L63:
        return Boxing.boxBoolean(r13);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L60
        Integer r12 = null;
        if (r22 == null) goto L26;
        String r15 = r22.b;     // Catch: Exception -> L60
        if (r15 == null) goto L26;
        if ((!StringsKt.isBlank(r15)) == true) goto L25;
        r15 = null;
    L25:
        if (r15 == null) goto L26;
    L27:
        r10.put("target_id", r15);     // Catch: Exception -> L60
        if (r22 == null) goto L30;
        int r16 = r22.a;     // Catch: Exception -> L60
    L31:
        r10.put("target_type", r16);     // Catch: Exception -> L60
        r10.put("action_type", r0);     // Catch: Exception -> L60
        if ((!r110.isEmpty()) == false) goto L35;
        r10.put("reasons", new JSONArray(r110).toString());     // Catch: Exception -> L60
    L35:
        if ((!StringsKt.isBlank(r20)) == false) goto L37;
        r10.put("content", StringsKt.take(StringsKt.trim(r20).toString(), 1000));     // Catch: Exception -> L60
    L37:
        JSONObject r24 = a(r22);     // Catch: Exception -> L60
        if (r24 == null) goto L40;
        r10.put("context", r24);     // Catch: Exception -> L60
    L40:
        JSONObject r25 = new JSONObject();     // Catch: Exception -> L60
        if (r21 != null) goto L43;
    L50:
        FlowDoraSubBizType.Companion.getClass();     // Catch: Exception -> L60
        int r26 = FlowDoraSubBizType.a.a();     // Catch: Exception -> L60
    L51:
        r25.put("dora_sub_biz", r26);     // Catch: Exception -> L60
        r25.put("scene", 2);     // Catch: Exception -> L60
        r25.put("feedback", r10);     // Catch: Exception -> L60
        com.larus.dora.api.network.a r27 = com.larus.dora.api.network.a.a;     // Catch: Exception -> L60
        r1 = r17;
        r11.L$0 = r1;     // Catch: Exception -> L60
        r11.I$0 = r0;     // Catch: Exception -> L60
        r11.label = 1;     // Catch: Exception -> L60
        r2 = com.larus.dora.api.network.a.c(r27, k0.class, "/alice/wearable/feedback/submit", r25, null, r11, 248);     // Catch: Exception -> L60
        if (r2 != r6) goto L54;
        return r6;
    L43:
        if (r21.intValue() <= 0) goto L45;
        boolean r28 = true;
    L46:
        if (r28 == false) goto L48;
        r12 = r21;
    L48:
        if (r12 == null) goto L50;
        r26 = r12.intValue();     // Catch: Exception -> L60
        goto L51
    L45:
        r28 = false;
        goto L46
    L30:
        r16 = 1;
    L26:
        r15 = r17;
    L60:
        e = move-exception;
        FLogger.a.e("DoraODiaryRepo", "submitFeedback error: " + e.getMessage());
    L7:
        r4 = new DoraODiaryRepo$submitFeedback$1(this, r23);
        goto L8
    }
}
