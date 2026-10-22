package com.larus.dora.impl.dynamic;

import com.larus.dora.impl.databinding.LarusDoraPageDynamicListBinding;
import com.larus.dora.impl.dynamic.widget.NestedDynamicPageView;
import com.larus.dora.impl.dynamic.widget.NewcomerGuideWidget;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDynamicFragment$registerWakeupListener$1$onVoiceWakeUp$1", f = "DoraDynamicFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicFragment$registerWakeupListener$1$onVoiceWakeUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraDynamicFragment this$0;

    public DoraDynamicFragment$registerWakeupListener$1$onVoiceWakeUp$1(DoraDynamicFragment r1, Continuation<? super DoraDynamicFragment$registerWakeupListener$1$onVoiceWakeUp$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraDynamicFragment$registerWakeupListener$1$onVoiceWakeUp$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        LarusDoraPageDynamicListBinding r3 = this.this$0.f;
        if (r3 == null) goto L12;
        NestedDynamicPageView r4 = r3.c;
        if (r4 == null) goto L12;
        NewcomerGuideWidget r5 = r4.getNewcomerGuideWidget();
        if (r5 == null) goto L12;
        r5.setThinkingMode(true);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
