package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackRawObservationEnricher;", "", "<init>", "()V", "TAG", "", "enrich", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "feedback", "rawObservationStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ac f10402a = null;

    static {
        f10402a = new ac();
    }

    private ac() {
    }

    public final com.obric.memorydata.memory.review.model.c a(com.obric.memorydata.memory.review.model.c r14, al r15) {
        al r16 = (al) ZeusTransformUtils.wrapperContextForParams(r15, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "feedback");
        Intrinsics.checkNotNullParameter(r16, "rawObservationStore");
        if (r14.b() != MemoryReviewModule.SCREEN_MEMORY) goto L5;
    L24:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        ac r13 = (ac) ZeusTransformUtils.preCheckCast(this, ac.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        JSONObject r17 = new JSONObject(r14.f());     // Catch: Throwable -> L16
        List<Long> r1 = az.f10433a.a(r17);     // Catch: Throwable -> L16
        if (r1.isEmpty() == true) goto L12;
        ay r18 = r16.a(r1);     // Catch: Throwable -> L16
        if (r18.b().isEmpty() == true) goto L12;
        r17.put("rawObservations", az.f10433a.c(r18.b()));     // Catch: Throwable -> L16
        String r8 = r17.toString();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");     // Catch: Throwable -> L16
        com.obric.memorydata.memory.review.model.c r19 = com.obric.memorydata.memory.review.model.c.a(r14, null, null, null, null, null, r8, null, null, 223, null);     // Catch: Throwable -> L16
    L14:
        Object r110 = Result.m1421constructorimpl(r19);     // Catch: Throwable -> L16
    L18:
        Throwable r111 = Result.m1424exceptionOrNullimpl(r110);
        if (r111 != null) goto L21;
        Object r112 = r110;
    L23:
        return (com.obric.memorydata.memory.review.model.c) ZeusTransformUtils.preCheckCast(r112, com.obric.memorydata.memory.review.model.c.class, "com.obric.memorydata.plugin");
    L21:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewFeedbackRawObservationEnricher", "enrich feedback raw observations failed module=" + r14.b().getKey() + " recordId=" + r14.a() + " error=" + r111.getMessage(), null, 4, null);
        r112 = r14;
    L12:
        r19 = r14;
    L16:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r110 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (r14.b() == MemoryReviewModule.AUTO_MEMORY_PRO) goto L24;
        return r14;
    }
}
