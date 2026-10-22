package ska;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.cocreationreview.s3;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.memorydata.sdk.proactive.ProactiveAllPageSnapshot;
import com.obric.memorydata.sdk.proactive.ProactiveDayHeaderDto;
import com.obric.memorydata.sdk.proactive.ProactiveDayPageResult;
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import com.obric.memorydata.sdk.proactive.ProactiveRecommendationDto;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;
    public static volatile Context b;

    static {
        a = new b();
    }

    public b() {
    }

    public static ProactiveLabelingFeedbackConfigDto b(b r4) {
        r4.getClass();
        String r5 = a("getAiProactiveLabelingFeedbackConfig", "requestJson", "{}");
        if (r5 == null) goto L9;
        JSONObject r0 = new JSONObject(r5);
        List r1 = h(r0.optJSONArray("positiveReasons"));
        List r2 = h(r0.optJSONArray("negativeReasons"));
        String r3 = r0.optString("feedbackPlaceholder");
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        return new ProactiveLabelingFeedbackConfigDto(r1, r2, r3);
    L9:
        return new ProactiveLabelingFeedbackConfigDto(CollectionsKt.listOf(new String[]{"提醒很及时", "内容有帮助", "理解我的需求"}), CollectionsKt.listOf(new String[]{"提醒不合时宜", "内容不准确", "打扰到我了"}), "建议写清：触发信号、建议内容、实际用户场景、期望的提醒时机或执行方式。");
    }

    public static ProactiveAllPageSnapshot e(String r14) {
        JSONObject r0 = new JSONObject(r14);
        long r2 = r0.optLong("batchId");
        JSONArray r1 = r0.optJSONArray("dayHeaders");
        if (r1 != null) goto L6;
        List r3 = CollectionsKt.emptyList();
    L5:
        List r5 = r3;
        return new ProactiveAllPageSnapshot(r2, r5, g(r0.optJSONArray("todayFirstPage")), r0.optBoolean("todayHasNext", false));
    L6:
        List r6 = CollectionsKt.createListBuilder();
        int r7 = r1.length();
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L16;
        JSONObject r9 = r1.optJSONObject(r8);
        if (r9 == null) goto L15;
        String r10 = r9.optString("dayKey");
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        r6.add(new ProactiveDayHeaderDto(r10, r9.optLong("dayStartMillis"), r9.optInt("count")));
    L15:
        r8 = r8 + 1;
        goto L7
    L16:
        r3 = CollectionsKt.build(r6);
        goto L5
    }

    public static ProactiveDayPageResult f(String r7) {
        JSONObject r0 = new JSONObject(r7);
        long r2 = r0.optLong("batchId");
        String r1 = r0.optString("dayKey");
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        return new ProactiveDayPageResult(r2, r1, r0.optBoolean("hasNext", false), g(r0.optJSONArray("list")));
    }

    public static List g(JSONArray r33) {
        JSONArray r0 = r33;
        if (r0 == null) goto L5;
        List r1 = CollectionsKt.createListBuilder();
        int r2 = r33.length();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L56;
        JSONObject r4 = r0.optJSONObject(r3);
        if (r4 == null) goto L54;
        a.getClass();
        String r6 = r4.optString("recommendId");
        if (r6 != null) goto L13;
        String r8 = "";
    L14:
        String r7 = r4.optString("taskId");
        if (r7 != null) goto L17;
        String r9 = "";
    L18:
        String r10 = r4.optString("subscriptionId");
        if (r10 != null) goto L21;
        String r11 = "";
    L22:
        String r12 = r4.optString("recommendText");
        if (r12 != null) goto L25;
        String r13 = "";
    L26:
        String r14 = r4.optString("emoji");
        if (r14 != null) goto L29;
        String r15 = "";
    L30:
        String r16 = d(r4, "actionCondition");
        String r17 = d(r4, "actionExecuteInstruction");
        String r18 = d(r4, "actionContext");
        List r19 = h(r4.optJSONArray("sourcePackages"));
        long r110 = r4.optLong("created");
        double r111 = r4.optDouble("score");
        String r20 = r4.optString(WindowEvent.Params.REASON);
        if (r20 != null) goto L33;
        String r21 = "";
    L34:
        String r22 = d(r4, "evidence");
        int r5 = r4.optInt("recommendStatus", 1);
        String r23 = r4.optString("status");
        if (r23 != null) goto L37;
        String r24 = "";
    L38:
        String r25 = r4.optString("type");
        if (r25 != null) goto L41;
        String r26 = "";
    L43:
        if (r4.has("expireAtMs") == true) goto L45;
    L48:
        Long r27 = null;
    L49:
        Long r28 = r27;
        String r29 = r4.optString("inspirationId");
        if (r29 != null) goto L52;
        String r210 = "";
    L53:
        String r30 = r8;
        String r31 = r9;
        String r32 = r11;
        String r112 = r13;
        String r113 = r15;
        String r211 = r21;
        r1.add(new ProactiveRecommendationDto(r30, r31, r32, r112, r113, r16, r17, r18, r19, r110, r111, r211, r22, r5, r24, r26, r28, r210, d(r4, "inspirationFeedbackAction"), d(r4, "inspirationUserFeedback"), r4.optLong("inspirationUpdated"), r4.optLong("inspirationTimestamp")));
        goto L54
    L52:
        r210 = r29;
        goto L53
    L45:
        if (r4.isNull("expireAtMs") == true) goto L48;
        r27 = Long.valueOf(r4.optLong("expireAtMs"));
        goto L49
    L41:
        r26 = r25;
        goto L43
    L37:
        r24 = r23;
        goto L38
    L33:
        r21 = r20;
        goto L34
    L29:
        r15 = r14;
        goto L30
    L25:
        r13 = r12;
        goto L26
    L21:
        r11 = r10;
        goto L22
    L17:
        r9 = r7;
        goto L18
    L13:
        r8 = r6;
    L54:
        r3 = r3 + 1;
        r0 = r33;
        goto L7
    L56:
        return CollectionsKt.build(r1);
    L5:
        return CollectionsKt.emptyList();
    }

    public static List h(JSONArray r5) {
        if (r5 == null) goto L4;
        List r0 = CollectionsKt.createListBuilder();
        int r1 = r5.length();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L15;
        String r3 = r5.optString(r2);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L13;
        r0.add(r3);
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        return CollectionsKt.build(r0);
    L4:
        return CollectionsKt.emptyList();
    }

    public static String d(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L5;
    L10:
        return null;
    L5:
        if (r1.isNull(r2) == true) goto L10;
        String r3 = r1.optString(r2);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == false) goto L10;
        return r3;
    }

    public final boolean bindService(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "targetPackage");
        Context r5 = r3.getApplicationContext();
        b = r5;
        a r1 = a.a;
        Intrinsics.checkNotNull(r5);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        a.b = r5.getApplicationContext();
        int r6 = s3.a;
        s3.b("proactive.compat", "provider bridge initialized targetPackage=" + r4);
        return true;
    }

    public static String a(String r4, String r5, String r6) {
        Context r0 = b;
        Object r1 = null;
        if (r0 != null) goto L22;
        return null;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        ContentResolver r3 = r0.getContentResolver();     // Catch: Throwable -> L11
        Uri r7 = UriProtector.parse("content://com.obric.memorydata.memory.provider");     // Catch: Throwable -> L11
        Bundle r8 = new Bundle();     // Catch: Throwable -> L11
        r8.putString(r5, r6);     // Catch: Throwable -> L11
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L11
        Bundle r10 = r3.call(r7, r4, null, r8);     // Catch: Throwable -> L11
        if (r10 == null) goto L8;
        String r11 = r10.getString("resultJson");     // Catch: Throwable -> L11
    L9:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L11
    L13:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L17;
        int r14 = s3.a;
        s3.c("proactive.compat", "provider call failed method=" + r4 + " type=" + r13.getClass().getSimpleName() + " message=" + r13.getMessage());
    L17:
        if (Result.isFailure-impl(r12) == true) goto L21;
        r1 = r12;
    L21:
        return (String) r1;
    L8:
        r11 = null;
    L11:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static ProactiveDayPageResult c(b r6, long r7, String r9, int r10) {
        r6.getClass();
        String r8 = a("loadAiProactiveDayRecommendationsPage", "requestJson", new JSONObject().put("batchId", r7).put("dayKey", r9).put("offset", r10).put("limit", 50).toString());
        if (r8 == null) goto L6;
        return f(r8);
    L6:
        return new ProactiveDayPageResult(r7, r9, false, CollectionsKt.emptyList());
    }
}
