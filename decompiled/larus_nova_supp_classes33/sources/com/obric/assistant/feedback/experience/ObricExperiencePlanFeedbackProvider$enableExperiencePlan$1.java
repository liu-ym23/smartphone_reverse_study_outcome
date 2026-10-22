package com.obric.assistant.feedback.experience;

import android.app.Activity;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager$b;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.obric.assistant.feedback.experience.ObricExperiencePlanFeedbackProvider$enableExperiencePlan$1", f = "ObricFeedbackPanelServiceImpl.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
final class ObricExperiencePlanFeedbackProvider$enableExperiencePlan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $showSuccess;
    final /* synthetic */ Activity $targetActivity;
    int label;
    final /* synthetic */ ObricExperiencePlanFeedbackProvider this$0;

    public ObricExperiencePlanFeedbackProvider$enableExperiencePlan$1(boolean r1, Activity r2, ObricExperiencePlanFeedbackProvider r3, Continuation<? super ObricExperiencePlanFeedbackProvider$enableExperiencePlan$1> r4) {
        this.$showSuccess = r1;
        this.$targetActivity = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricExperiencePlanFeedbackProvider$enableExperiencePlan$1(this.$showSuccess, this.$targetActivity, this.this$0, r5);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        ObricUserExperiencePlanManager$b r5 = (ObricUserExperiencePlanManager$b) r4;
        if (r5.a == true) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == false) goto L24;
        if (this.$showSuccess == false) goto L24;
        Activity r6 = this.$targetActivity;
        if (r6 == null) goto L24;
        ObricExperiencePlanFeedbackProvider.c(this.this$0, r6);
    L24:
        return Unit.INSTANCE;
    L14:
        if (r5.b == false) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ObricUserExperiencePlanManager r7 = ObricUserExperiencePlanManager.a;
        this.label = 1;
        r4 = r7.h(true, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
