package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1", f = "CocreationReviewActivity.kt", i = {}, l = {3552}, m = "invokeSuspend", n = {}, s = {})
final class CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $feedbackText;
    final /* synthetic */ String $relatedInfo;
    final /* synthetic */ r0 $report;
    int label;

    public CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1(r0 r1, String r2, String r3, Continuation<? super CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1> r4) {
        this.$report = r1;
        this.$feedbackText = r2;
        this.$relatedInfo = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1(this.$report, this.$feedbackText, this.$relatedInfo, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L30:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ska.b r7 = ska.b.a;
        Object r2 = this.$report.b;
        Object r3 = this.$feedbackText;
        Object r4 = this.$relatedInfo;
        this.label = 1;
        r7.getClass();
        JSONObject r8 = new JSONObject();
        if (r2 != null) goto L11;
        r2 = JSONObject.NULL;
    L11:
        JSONObject r9 = r8.put("feedbackReason", r2);
        if (r3 != null) goto L14;
        r3 = JSONObject.NULL;
    L14:
        JSONObject r10 = r9.put("feedbackText", r3);
        if (r4 != null) goto L17;
        r4 = JSONObject.NULL;
    L17:
        String r11 = ska.b.a("submitAiProactiveDirectFeedback", "requestJson", r10.put("relatedInfo", r4).put("feedbackSource", "label_app").toString());
        boolean r5 = false;
        if (r11 != null) goto L31;
    L27:
        r6 = Boxing.boxBoolean(r5);
        if (r6 != r0) goto L30;
        return r0;
    L31:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L21
        Object r13 = Result.constructor-impl(Boxing.boxBoolean(new JSONObject(r11).optBoolean("accepted", false)));     // Catch: Throwable -> L21
    L23:
        Boolean r14 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r13) == false) goto L26;
        r13 = r14;
    L26:
        r5 = ((Boolean) r13).booleanValue();
    L21:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
