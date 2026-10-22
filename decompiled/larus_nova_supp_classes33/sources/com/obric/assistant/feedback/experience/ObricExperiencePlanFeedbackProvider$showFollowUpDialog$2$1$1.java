package com.obric.assistant.feedback.experience;

import android.app.Activity;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager;
import com.obric.cae.libs.useraware.ApWakeEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.experience.ObricExperiencePlanFeedbackProvider$showFollowUpDialog$2$1$1", f = "ObricFeedbackPanelServiceImpl.kt", i = {}, l = {ApWakeEvent.OTHER_END}, m = "invokeSuspend", n = {}, s = {})
final class ObricExperiencePlanFeedbackProvider$showFollowUpDialog$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $wasEnabled;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricExperiencePlanFeedbackProvider this$0;

    public ObricExperiencePlanFeedbackProvider$showFollowUpDialog$2$1$1(boolean r1, ObricExperiencePlanFeedbackProvider r2, Activity r3, Continuation<? super ObricExperiencePlanFeedbackProvider$showFollowUpDialog$2$1$1> r4) {
        this.$wasEnabled = r1;
        this.this$0 = r2;
        this.$activity = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricExperiencePlanFeedbackProvider$showFollowUpDialog$2$1$1 r0 = new ObricExperiencePlanFeedbackProvider$showFollowUpDialog$2$1$1(this.$wasEnabled, this.this$0, this.$activity, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L13:
        Object r5 = Result.constructor-impl((ObricUserExperiencePlanManager.a) r4);     // Catch: Throwable -> L15
    L18:
        if (Result.exceptionOrNull-impl(r5) == null) goto L21;
        ObricUserExperiencePlanManager r6 = ObricUserExperiencePlanManager.a;
        r5 = ObricUserExperiencePlanManager.b();
    L21:
        ObricUserExperiencePlanManager.a r7 = (ObricUserExperiencePlanManager.a) r5;
        if (this.$wasEnabled == true) goto L27;
        if (r7.b() == false) goto L27;
        ObricExperiencePlanFeedbackProvider.c(this.this$0, this.$activity);
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
        ObricUserExperiencePlanManager r10 = ObricUserExperiencePlanManager.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r4 = r10.f(this);     // Catch: Throwable -> L15
        if (r4 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
