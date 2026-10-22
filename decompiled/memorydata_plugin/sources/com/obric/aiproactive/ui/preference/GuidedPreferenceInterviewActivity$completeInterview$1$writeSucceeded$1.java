package com.obric.aiproactive.ui.preference;

import com.obric.aiproactive.api.AiRuleItemDto;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.preference.GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1", f = "GuidedPreferenceInterviewActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<String> $generatedRules;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuidedPreferenceInterviewActivity this$0;

    GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1(List<String> r3, GuidedPreferenceInterviewActivity r4, Continuation<? super GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1> r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        GuidedPreferenceInterviewActivity r7 = (GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r4, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$generatedRules = r6;
        this.this$0 = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1 r0 = new GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1(this.$generatedRules, this.this$0, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
        return ((GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r9);
        al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        List<String> r11 = this.$generatedRules;
        GuidedPreferenceInterviewActivity r8 = this.this$0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Integer r3 = null;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        IProactiveService r12 = GuidedPreferenceInterviewActivity.access$getProactiveService(r8);     // Catch: Throwable -> L16
        if (r12 == null) goto L12;
        List<AiRuleItemDto> r13 = r12.addInterviewGeneratedRules(r11);     // Catch: Throwable -> L16
        if (r13 == null) goto L12;
        r3 = Boxing.boxInt(r13.size());     // Catch: Throwable -> L16
    L12:
        boolean r14 = i.f6773a.a(r11.size(), r3);     // Catch: Throwable -> L16
    L14:
        Object r15 = Result.m1421constructorimpl(Boxing.boxBoolean(r14));     // Catch: Throwable -> L16
    L18:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GuidedPreferenceInterviewActivity.TAG, "guided preference completion failed: " + r16.getClass().getSimpleName(), null, 4, null);
    L21:
        Boolean r17 = Boxing.boxBoolean(false);
        if (Result.m1427isFailureimpl(r15) == true) goto L24;
        return r15;
    L24:
        return r17;
    L13:
        r14 = i.f6773a.a(0, null);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
