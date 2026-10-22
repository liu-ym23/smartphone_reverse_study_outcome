package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.entity.db;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewVote;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ@\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\tJ&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0002JL\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0002¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackEntityMapper;", "", "<init>", "()V", "toSubmittingEntity", "Lcom/obric/memorydata/database/entity/MemoryReviewFeedbackEntity;", "feedback", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "updateTime", "", "serverUniqId", "", "toSubmittedEntity", "serverStatus", "serverError", "serverUpdateTime", "toFailedEntity", "error", "toFeedbackState", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackState;", "entity", "toFeedbackInfo", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackInfo;", "parseReasons", "", "reasonsJson", "toEntity", "status", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f10401a = null;

    static {
        f10401a = new aa();
    }

    private aa() {
    }

    private final db a(com.obric.memorydata.memory.review.model.c r23, long r24, String r26, String r27, String r28, String r29, String r30, long r31) {
        String r3 = r23.a();
        String r4 = r23.b().getKey();
        String r5 = r23.c().getKey();
        String r1 = new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r23.d(), Collection.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return new db(0, r3, r4, r5, r1, r23.e(), r23.f(), r26, r27, r23.g(), r24, r28, r29, r30, r31, 1, null);
    }

    private final List<String> a(String r6) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        aa r5 = (aa) ZeusTransformUtils.preCheckCast(this, aa.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        JSONArray r7 = new JSONArray(r6);     // Catch: Throwable -> L14
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        int r2 = 0;
        int r3 = r7.length();     // Catch: Throwable -> L14
    L4:
        if (r2 >= r3) goto L12;
        String r4 = r7.optString(r2);     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L14
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L11;
        r8.add(r4);     // Catch: Throwable -> L14
    L11:
        r2 = r2 + 1;     // Catch: Throwable -> L14
        goto L4
    L12:
        Object r9 = Result.m1421constructorimpl(r8);     // Catch: Throwable -> L14
    L16:
        List r10 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r9) == false) goto L20;
        r9 = r10;
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final db a(com.obric.memorydata.memory.review.model.c r13, long r14, String r16) {
        Intrinsics.checkNotNullParameter(r13, "feedback");
        Intrinsics.checkNotNullParameter(r16, "serverUniqId");
        return a(r13, r14, MemoryReviewFeedbackState.SUBMITTING.getKey(), null, r16, "submitting", null, r14);
    }

    public final db a(com.obric.memorydata.memory.review.model.c r13, long r14, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r13, "feedback");
        Intrinsics.checkNotNullParameter(r16, "serverUniqId");
        Intrinsics.checkNotNullParameter(r17, "error");
        return a(r13, r14, MemoryReviewFeedbackState.FAILED.getKey(), r17, r16, "failed", r17, r14);
    }

    public final db a(com.obric.memorydata.memory.review.model.c r13, long r14, String r16, String r17, String r18, long r19) {
        Intrinsics.checkNotNullParameter(r13, "feedback");
        Intrinsics.checkNotNullParameter(r16, "serverUniqId");
        Intrinsics.checkNotNullParameter(r17, "serverStatus");
        return a(r13, r14, MemoryReviewFeedbackState.SUBMITTED.getKey(), null, r16, r17, r18, r19);
    }

    public final MemoryReviewFeedbackState a(db r1) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        MemoryReviewFeedbackState r0 = MemoryReviewFeedbackState.Companion.a(r1.h());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return MemoryReviewFeedbackState.SUBMITTED;
    }

    public final com.obric.memorydata.memory.review.model.d b(db r12) {
        Intrinsics.checkNotNullParameter(r12, "entity");
        MemoryReviewFeedbackState r2 = a(r12);
        if (r2 != MemoryReviewFeedbackState.SUBMITTED) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        MemoryReviewVote r1 = MemoryReviewVote.Companion.a(r12.d());
    L10:
        MemoryReviewVote r3 = r1;
        if (r0 == false) goto L13;
        List<String> r11 = a(r12.e());
    L14:
        List<String> r4 = r11;
        if (r0 == false) goto L17;
        String r13 = r12.f();
    L19:
        return new com.obric.memorydata.memory.review.model.d(r2, r3, r4, r13, r12.g(), r12.j(), r12.k());
    L17:
        r13 = "";
        goto L19
    L13:
        r11 = CollectionsKt.emptyList();
        goto L14
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = false;
        goto L7
    }
}
