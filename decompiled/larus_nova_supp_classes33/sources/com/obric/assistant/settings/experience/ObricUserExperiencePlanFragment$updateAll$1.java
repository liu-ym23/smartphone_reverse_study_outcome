package com.obric.assistant.settings.experience;

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
@DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanFragment$updateAll$1", f = "ObricUserExperiencePlanFragment.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
final class ObricUserExperiencePlanFragment$updateAll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    int label;
    final /* synthetic */ ObricUserExperiencePlanFragment this$0;

    public ObricUserExperiencePlanFragment$updateAll$1(boolean r1, ObricUserExperiencePlanFragment r2, Continuation<? super ObricUserExperiencePlanFragment$updateAll$1> r3) {
        this.$enabled = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricUserExperiencePlanFragment$updateAll$1(this.$enabled, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        ObricUserExperiencePlanManager$b r6 = (ObricUserExperiencePlanManager$b) r5;
        ObricUserExperiencePlanFragment r3 = this.this$0;
        ObricUserExperiencePlanManager.a r4 = r6.c;
        int r7 = ObricUserExperiencePlanFragment.j;
        r3.X90(r4);
        if (r6.a == true) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == true) goto L20;
        ObricUserExperiencePlanFragment.U90(this.this$0);
    L20:
        return Unit.INSTANCE;
    L14:
        if (r6.b == false) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ObricUserExperiencePlanManager r8 = ObricUserExperiencePlanManager.a;
        boolean r9 = this.$enabled;
        this.label = 1;
        r5 = r8.h(r9, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
