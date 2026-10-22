package com.obric.memorydata.memory.review.provider.a;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.memory.review.model.d;
import com.obric.memorydata.memory.review.model.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\tH\u0002\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002\u001a'\u0010\u000e\u001a\u0004\u0018\u00010\u0004*\u00020\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0010\"\u00020\tH\u0002¢\u0006\u0002\u0010\u0011\u001a'\u0010\u0012\u001a\u0004\u0018\u00010\t*\u00020\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0010\"\u00020\tH\u0002¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"isLegacyAudioCardInWindow", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackInfo;", "startTimeInclusive", "", "endTimeExclusive", "toLegacyCompletedRecord", "Lcom/obric/memorydata/memory/review/model/MemoryReviewRecord;", "recordId", "", "toJsonObjectOrNull", "Lorg/json/JSONObject;", "hasNonNull", "key", "firstPositiveLong", "keys", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/Long;", "firstNonBlankString", "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/String;", "LEGACY_AUDIO_ENTITY_TYPE", "", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final /* synthetic */ h a(d r0, String r1) {
        return b(r0, r1);
    }

    private static final Long a(JSONObject r9, String... r10) {
        int r0 = r10.length;
        int r2 = 0;
    L3:
        Long r3 = null;
        if (r2 >= r0) goto L16;
        String r4 = r10[r2];
        if (a(r9, r4) == false) goto L14;
        Long r5 = Long.valueOf(r9.optLong(r4));
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        r3 = r5;
        goto L14
    L11:
        r6 = false;
    L14:
        if (r3 != null) goto L16;
        r2 = r2 + 1;
    L16:
        return r3;
    }

    private static final JSONObject a(String r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Object r2 = null;
        if (r1 == false) goto L22;
        return null;
    L22:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        Object r5 = Result.m1421constructorimpl(new JSONObject(r3));     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r5) == true) goto L21;
        r2 = r5;
    L21:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ boolean a(d r0, long r1, long r3) {
        return b(r0, r1, r3);
    }

    private static final boolean a(JSONObject r1, String r2) {
        if (r1.has(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.isNull(r2) == true) goto L7;
        return true;
    }

    private static final h b(d r11, String r12) {
        String r5 = r11.e();
        if (r5 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = a(r5);
        if (r1 != null) goto L8;
        return null;
    L8:
        String r3 = b(r1, new String[]{"displayTitle", "topic", ActivityLifecycle.NAME, "title"});
        String r4 = b(r1, new String[]{"displaySummary", "summaryText", "summary", Params.CONTENT});
        Long r0 = a(r1, new String[]{"modifyTime", "createTime", "timestamp"});
        if (r0 == null) goto L11;
        long r2 = r0.longValue();
    L12:
        MemoryReviewModule r6 = MemoryReviewModule.AUDIO_MEMORY;
        MemoryReviewFeedbackState r7 = MemoryReviewFeedbackState.SUBMITTED;
        String r8 = r11.f();
        return new h(r12, r6, r3, r4, r5, r7, r8, r2);
    L11:
        r2 = r11.g();
        goto L12
    }

    private static final String b(JSONObject r7, String... r8) {
        int r0 = r8.length;
        int r2 = 0;
    L3:
        String r3 = null;
        if (r2 >= r0) goto L18;
        String r4 = r8[r2];
        if (a(r7, r4) == false) goto L16;
        String r5 = r7.optString(r4);
        Intrinsics.checkNotNull(r5);
        boolean r6 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L11;
    L13:
        r6 = false;
    L14:
        if (r6 == false) goto L16;
        r3 = r5;
        goto L16
    L11:
        if (Intrinsics.areEqual(r5, "null") == true) goto L13;
    L16:
        if (r3 != null) goto L18;
        r2 = r2 + 1;
    L18:
        return r3;
    }

    private static final boolean b(d r6, long r7, long r9) {
        if (r6.a() == MemoryReviewFeedbackState.SUBMITTED) goto L5;
        return false;
    L5:
        JSONObject r0 = a(r6.e());
        if (r0 != null) goto L9;
        return false;
    L9:
        if (a(r0, "productType") == false) goto L15;
        if (r0.optInt("productType") != 502) goto L13;
    L12:
        boolean r1 = true;
    L26:
        if (r1 == true) goto L28;
        return false;
    L28:
        Long r2 = a(r0, new String[]{"modifyTime", "createTime", "timestamp"});
        if (r2 == null) goto L31;
        long r3 = r2.longValue();
    L41:
        if (r3 >= r7) goto L43;
        return false;
    L43:
        if (r3 < r9) goto L45;
        return false;
    L45:
        return true;
    L31:
        Long r8 = Long.valueOf(r6.g());
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L34;
        boolean r4 = true;
    L35:
        if (r4 == true) goto L38;
        r8 = null;
    L38:
        if (r8 == null) goto L46;
        r3 = r8.longValue();
        goto L41
    L46:
        return false;
    L34:
        r4 = false;
    L13:
        r1 = false;
        goto L26
    L15:
        if (a(r0, "entityType") == false) goto L20;
        if (r0.optInt("entityType") != 502) goto L13;
    L20:
        if (r0.has("audioInfo") == true) goto L12;
        if (r0.has("file") == true) goto L12;
        if (r0.has("transcript") == false) goto L13;
        goto L13
    }
}
