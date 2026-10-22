package com.larus.profile.impl.creation;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$runWhenFragmentActive$2", f = "CreationDoSameAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationDoSameAbility$runWhenFragmentActive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$runWhenFragmentActive$2(CreationDoSameAbility r1, String r2, Function0<Unit> r3, Continuation<? super CreationDoSameAbility$runWhenFragmentActive$2> r4) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$action = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDoSameAbility$runWhenFragmentActive$2(this.this$0, this.$scene, this.$action, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        if (CreationDoSameAbility.g(this.this$0) == true) goto L8;
        FLogger.a.w("CreationDoSameAbility", this.$scene + " skipped, fragment inactive");
        return Unit.INSTANCE;
    L8:
        this.$action.invoke();
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
