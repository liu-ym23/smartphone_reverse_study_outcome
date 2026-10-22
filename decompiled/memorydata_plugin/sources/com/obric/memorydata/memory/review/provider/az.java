package com.obric.memorydata.memory.review.provider;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0014\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tJ\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tJ\u001e\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u0012\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0002J\f\u0010\u001a\u001a\u00020\r*\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/RawObservationEvidenceJson;", "", "<init>", "()V", "MAX_REVIEW_RAW_OBSERVATION_COUNT", "", "idsToJson", "Lorg/json/JSONArray;", "rawObservationIds", "", "", "idsFromPayload", "payload", "Lorg/json/JSONObject;", "idsFromJsonString", EventBody.KEY_VALUE, "", "observationsToJson", "rawObservations", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "observationsToFeedbackJson", "includeImageTosKey", "", "optLongArray", "key", "toLongList", "toJsonObjectOrEmpty", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final az f10433a = null;

    static {
        f10433a = new az();
    }

    private az() {
    }

    private final List<Long> a(JSONArray r8) {
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r0 = r8.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        long r3 = r8.optLong(r2, -1);
        if (r3 <= 0) goto L7;
        r7.add(Long.valueOf(r3));
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 300);
    }

    private final List<Long> a(JSONObject r3, String r4) {
        if (r3.has(r4) == false) goto L23;
        if (r3.isNull(r4) == true) goto L23;
        Object r5 = r3.opt(r4);
        if (ZeusTransformUtils.instanceOf(r5, JSONArray.class) == false) goto L11;
        return a((JSONArray) ZeusTransformUtils.preCheckCast(r5, JSONArray.class, "com.obric.memorydata.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L21;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.m1421constructorimpl(f10433a.a(new JSONArray((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L14
    L16:
        List r7 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r6) == false) goto L27;
        r6 = r7;
    L27:
        return (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L21:
        return CollectionsKt.emptyList();
    L23:
        return CollectionsKt.emptyList();
    }

    private final JSONArray a(List<RawObservationEntity> r12, boolean r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        JSONArray r14 = new JSONArray();
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin"), 300), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r15.hasNext() == false) goto L43;
        RawObservationEntity r1 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r15.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        az r2 = f10433a;
        JSONObject r3 = r2.b(r1.getPayload());
        String r4 = r3.optString("screenshot_path");
        Intrinsics.checkNotNullExpressionValue(r4, "optString(...)");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r7 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
    L10:
        boolean r6 = false;
    L11:
        String r10 = null;
        if (r6 == true) goto L15;
        r5 = null;
    L15:
        if (r13 == false) goto L24;
        String r8 = r3.optString("image_tos_key");
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L19;
    L21:
        boolean r16 = false;
    L22:
        if (r16 == false) goto L24;
    L25:
        if (r5 != null) goto L27;
        if (r9 == null) goto L4;
    L27:
        JSONObject r17 = r2.b(r1.getMeta());
        JSONObject r18 = new JSONObject();
        if (r5 == null) goto L30;
        r18.put("screenshotPath", r5);
    L30:
        if (r9 == null) goto L32;
        r18.put("imageTosKey", r9);
    L32:
        String r19 = r17.optString(Api.KEY_APP_NAME);
        Intrinsics.checkNotNullExpressionValue(r19, "optString(...)");
        String r20 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L35;
    L37:
        r7 = false;
    L38:
        if (r7 == false) goto L40;
        r10 = r20;
    L40:
        if (r10 == null) goto L42;
        r18.put("appName", r10);
    L42:
        r14.put(r18);
        goto L4
    L35:
        if (Intrinsics.areEqual(r20, "null") == true) goto L37;
    L19:
        if (Intrinsics.areEqual(r9, "null") == true) goto L21;
        r16 = true;
    L24:
        r9 = null;
        goto L25
    L8:
        if (Intrinsics.areEqual(r5, "null") == true) goto L10;
        r6 = true;
        goto L11
    L43:
        return r14;
    }

    private final JSONObject b(String r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.m1421constructorimpl(new JSONObject(r2));     // Catch: Throwable -> L4
    L7:
        if (Result.m1424exceptionOrNullimpl(r3) == null) goto L11;
        r3 = new JSONObject();
    L11:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final List<Long> a(String r3) {
        List<Long> r2 = null;
        if (r3 != null) goto L5;
    L18:
        if (r2 == null) goto L20;
        return r2;
    L20:
        return CollectionsKt.emptyList();
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L18;
        az r4 = f10433a;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.m1421constructorimpl(r4.a(new JSONArray(r3)));     // Catch: Throwable -> L12
    L14:
        List r6 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r5) == false) goto L17;
        r5 = r6;
    L17:
        r2 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final List<Long> a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "payload");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(a(r3, "rawObservationIds"), Collection.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == false) goto L6;
        r2 = f10433a.a(r3, "batchScreenIds");
    L6:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }

    public final JSONArray a(List<Long> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "rawObservationIds");
        return new JSONArray((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), 300), Collection.class, "com.obric.memorydata.plugin"));
    }

    public final JSONArray b(List<RawObservationEntity> r3) {
        List<RawObservationEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rawObservations");
        return a(r4, false);
    }

    public final JSONArray c(List<RawObservationEntity> r3) {
        List<RawObservationEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rawObservations");
        return a(r4, true);
    }
}
