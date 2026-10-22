package com.larus.bmhome.taskskill;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$refreshRecentExposedSkillsIfNeeded$2$2$1", f = "SkillComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$refreshRecentExposedSkillsIfNeeded$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $load;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$refreshRecentExposedSkillsIfNeeded$2$2$1(SkillComponent r1, i r2, Continuation<? super SkillComponent$refreshRecentExposedSkillsIfNeeded$2$2$1> r3) {
        this.this$0 = r1;
        this.$load = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SkillComponent$refreshRecentExposedSkillsIfNeeded$2$2$1(this.this$0, this.$load, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        i r3 = this.this$0.R;
        i r0 = this.$load;
        if (r3 != r0) goto L8;
        r0.b = true;
        r0.c = null;
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
