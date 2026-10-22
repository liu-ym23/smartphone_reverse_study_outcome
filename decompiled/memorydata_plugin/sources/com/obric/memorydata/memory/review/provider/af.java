package com.obric.memorydata.memory.review.provider;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.memory.review.model.MemoryReviewVote;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002J\f\u0010\u0015\u001a\u00020\r*\u00020\rH\u0002J\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0002J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u000b*\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackServerRequestMapper;", "", "<init>", "()V", "toRequest", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewUserFeedbackRequest;", "feedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "updateTime", "", "resolveLastBuildLogId", "", "trace", "Lorg/json/JSONObject;", "displayedCard", "resolveUuid", "toServerFeedbackType", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewVote;", "parseJsonObject", "raw", "stripVersionRecords", "Lorg/json/JSONArray;", "stripVersionRecordsValue", "optNonBlankString", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f10407a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10408a = null;

        static {
            int[] r0 = new int[MemoryReviewVote.values().length];
            r0[MemoryReviewVote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemoryReviewVote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10408a = r0;
        }
    }

    static {
        f10407a = new af();
    }

    private af() {
    }

    private final int a(MemoryReviewVote r2) {
        int r1 = a.f10408a[r2.ordinal()];
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        return 2;
    L7:
        throw new NoWhenBranchMatchedException();
    L9:
        return 1;
    }

    private final Object a(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L6;
        return a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));
    L6:
        if (ZeusTransformUtils.instanceOf(r3, JSONArray.class) == true) goto L8;
        return r3;
    L8:
        return a((JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin"));
    }

    private final String a(JSONObject r1, String r2) {
        String r0 = r1.optString(r2);
        Intrinsics.checkNotNull(r0);
        boolean r3 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L7:
        r3 = false;
    L8:
        if (r3 == true) goto L12;
        return null;
    L12:
        return r0;
    L5:
        if (Intrinsics.areEqual(r0, "null") == true) goto L7;
        goto L7
    }

    private final String a(JSONObject r3, JSONObject r4) {
        String r1 = a(r3, "lastBuildLogId");
        if (r1 != null) goto L13;
        String r5 = a(r3, "logId");
        if (r5 != null) goto L12;
        r5 = a(r4, "lastBuildLogId");
        if (r5 != null) goto L12;
        String r2 = a(r4, "logId");
        if (r2 != null) goto L14;
        return "";
    L14:
        return r2;
    L12:
        return r5;
    L13:
        return r1;
    }

    private final JSONArray a(JSONArray r5) {
        JSONArray r0 = new JSONArray();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.put(a(r5.opt(r2)));
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private final JSONObject a(String r3) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        af r4 = (af) ZeusTransformUtils.preCheckCast(this, af.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r5 = Result.m1421constructorimpl(new JSONObject(r3));     // Catch: Throwable -> L14
    L16:
        JSONObject r6 = new JSONObject();
        if (Result.m1427isFailureimpl(r5) == false) goto L20;
        r5 = r6;
    L20:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r5, JSONObject.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new JSONObject();
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final JSONObject a(JSONObject r6) {
        JSONObject r0 = new JSONObject();
        Iterator<String> r1 = r6.keys();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r2, "versionRecords") == true) goto L4;
        r0.put(r2, a(r6.opt(r2)));
        goto L4
    L8:
        return r0;
    }

    private final String b(JSONObject r2, JSONObject r3) {
        String r4 = a(r3, Api.KEY_UUID);
        if (r4 != null) goto L8;
        String r5 = a(r2, Api.KEY_UUID);
        if (r5 != null) goto L9;
        return "";
    L9:
        return r5;
    L8:
        return r4;
    }

    public final an a(com.obric.memorydata.memory.review.model.c r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "feedback");
        JSONObject r0 = a(r12.f());
        JSONObject r1 = a(r12.g());
        String r9 = a(r1, r0);
        JSONObject r10 = new JSONObject().put("recordId", r12.a()).put("moduleKey", r12.b().getKey()).put(Api.KEY_UUID, b(r1, r0)).put("lastBuildLogId", r9);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12.h(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        r10.put("audioUrls", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r12.h(), Collection.class, "com.obric.memorydata.plugin")));
    L5:
        r10.put("displayedCard", a(r0));
        String r3 = "memory_review_" + r12.b().getKey() + '_' + r12.a() + '_' + r13;
        int r5 = ag.a(r12.b());
        List<String> r6 = r12.d();
        int r7 = a(r12.c());
        String r8 = r12.e();
        Intrinsics.checkNotNull(r10);
        return new an(r3, "label_app", r5, r6, r7, r8, r9, r10);
    }
}
