package com.obric.assistant.feedback.experience;

import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.obric.assistant.impl.databinding.ObricFeedbackExperiencePlanEntryBinding;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager;
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
@DebugMetadata(c = "com.obric.assistant.feedback.experience.ObricExperiencePlanFeedbackProvider$attach$3", f = "ObricFeedbackPanelServiceImpl.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
public final class ObricExperiencePlanFeedbackProvider$attach$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ ObricFeedbackExperiencePlanEntryBinding $viewBinding;
    int label;
    final /* synthetic */ ObricExperiencePlanFeedbackProvider this$0;

    public ObricExperiencePlanFeedbackProvider$attach$3(ObricExperiencePlanFeedbackProvider r1, ObricFeedbackExperiencePlanEntryBinding r2, LifecycleOwner r3, Continuation<? super ObricExperiencePlanFeedbackProvider$attach$3> r4) {
        this.this$0 = r1;
        this.$viewBinding = r2;
        this.$lifecycleOwner = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricExperiencePlanFeedbackProvider$attach$3(this.this$0, this.$viewBinding, this.$lifecycleOwner, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        ObricUserExperiencePlanManager.a r5 = (ObricUserExperiencePlanManager.a) r4;
        if (this.this$0.b != this.$viewBinding) goto L23;
        if (this.$lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L23;
        this.this$0.d = !r5.b();
        LinearLayout r6 = this.$viewBinding.a;
        if (this.this$0.d == false) goto L19;
        int r2 = 0;
    L20:
        r6.setVisibility(r2);
        return Unit.INSTANCE;
    L19:
        r2 = 8;
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ObricUserExperiencePlanManager r7 = ObricUserExperiencePlanManager.a;
        this.label = 1;
        r4 = r7.f(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
