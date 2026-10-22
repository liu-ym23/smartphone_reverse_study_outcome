package com.obric.memorydata.memory.ui.feedback;

import com.obric.memorydata.memory.review.provider.ad;
import com.obric.memorydata.memory.review.provider.ag;
import com.obric.memorydata.memory.review.provider.am;
import com.obric.memorydata.memory.review.provider.an;
import com.obric.memorydata.memory.review.provider.av;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B1\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0003R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportService;", "", "enabledProvider", "Lkotlin/Function0;", "", "remoteDataSource", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackRemoteDataSource;", "uniqIdProvider", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackRemoteDataSource;Lkotlin/jvm/functions/Function0;)V", "reportIfEnabled", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportResult;", "feedbackContent", "reportDataProvider", "Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportData;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10954a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Boolean> f10955b;
    private final ad c;
    private final Function0<String> d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/feedback/MemoryFeedbackOdpReportService$Companion;", "", "<init>", "()V", "TAG", "", "FEEDBACK_TYPE_NEGATIVE", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10954a = new a(null);
    }

    public j() {
        this(null, null, null, 7, null);
    }

    public j(Function0<Boolean> r3, ad r4, Function0<String> r5) {
        Function0<Boolean> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        ad r7 = (ad) ZeusTransformUtils.wrapperContextForParams(r4, ad.class, "com.obric.memorydata.plugin");
        Function0<String> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "enabledProvider");
        Intrinsics.checkNotNullParameter(r7, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r8, "uniqIdProvider");
        this.f10955b = r6;
        this.c = r7;
        this.d = r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ j(Function0 r3, ad r4, Function0 r5, int r6, DefaultConstructorMarker r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        ad r9 = (ad) ZeusTransformUtils.wrapperContextForParams(r4, ad.class, "com.obric.memorydata.plugin");
        Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = $$Lambda$j$93gXDQ7bOwSL5MihD31HG46Z0Gg.INSTANCE;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r9 = (ad) ZeusTransformUtils.preCheckCast(new av(null, 1, 0 == true ? 1 : 0), ad.class, "com.obric.memorydata.plugin");
    L9:
        if ((r6 & 4) == 0) goto L11;
        r10 = $$Lambda$j$S27fghfU8cnYBJ16F5fpMctZiTM.INSTANCE;
    L11:
        this(r8, r9, r10);
    }

    private static final boolean a() {
        return l.f10958a.a();
    }

    private static final String b() {
        return "memory_feedback_" + UUID.randomUUID();
    }

    public static /* synthetic */ boolean lambda$93gXDQ7bOwSL5MihD31HG46Z0Gg() {
        return a();
    }

    public static /* synthetic */ String lambda$S27fghfU8cnYBJ16F5fpMctZiTM() {
        return b();
    }

    public final MemoryFeedbackOdpReportResult a(String r16, Function0<h> r17) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "feedbackContent");
        Function0<Boolean> r0 = this.f10955b;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(r0.invoke());     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r1) == false) goto L11;
        r1 = false;
    L11:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L13;
        Object r6 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        j r3 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r4 == null) goto L18;
        h r7 = (h) ZeusTransformUtils.preCheckCast(r4.invoke(), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
    L19:
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L21
    L23:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L27;
        RunLog.INSTANCE.warn("MemoryFeedbackOdp", "build ODP report data failed", r9);
    L27:
        if (Result.m1427isFailureimpl(r8) == true) goto L30;
        r6 = r8;
    L30:
        h r10 = (h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L33;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L36
        j r12 = (j) ZeusTransformUtils.preCheckCast(this, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        Object r13 = Result.m1421constructorimpl(r12.c.a(new an((String) ZeusTransformUtils.preCheckCast(r12.d.invoke(), String.class, "com.obric.memorydata.plugin"), "label_app", ag.a(r10.a()), CollectionsKt.emptyList(), 2, r16, r10.b(), r10.c())));     // Catch: Throwable -> L36
    L38:
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
        if (r14 == null) goto L42;
        RunLog.INSTANCE.warn("MemoryFeedbackOdp", "report memory feedback to ODP failed", r14);
    L42:
        if (Result.m1424exceptionOrNullimpl(r13) != null) goto L47;
        am r15 = (am) ZeusTransformUtils.preCheckCast(r13, am.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryFeedbackOdp", "report memory feedback to ODP result, success=" + r15.a(), false, 4, null);
        if (r15.a() == false) goto L47;
        return MemoryFeedbackOdpReportResult.SUCCESS;
    L47:
        return MemoryFeedbackOdpReportResult.FAILURE;
    L36:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L38
    L33:
        return MemoryFeedbackOdpReportResult.MISSING_DATA;
    L18:
        r7 = null;
    L21:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    L13:
        return MemoryFeedbackOdpReportResult.DISABLED;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
