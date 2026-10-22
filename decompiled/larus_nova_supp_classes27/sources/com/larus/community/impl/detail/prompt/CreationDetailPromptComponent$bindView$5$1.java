package com.larus.community.impl.detail.prompt;

import com.larus.platform.api.creation.UserCreation;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.prompt.CreationDetailPromptComponent$bindView$5$1", f = "CreationDetailPromptComponent.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailPromptComponent$bindView$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationDetailPromptComponent $this_run;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationDetailPromptComponent a;

        public a(CreationDetailPromptComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            CreationDetailPromptComponent r3 = this.a;
            r3.F2((UserCreation) r1);
            return Unit.INSTANCE;
        }
    }

    public CreationDetailPromptComponent$bindView$5$1(CreationDetailPromptComponent r1, Continuation<? super CreationDetailPromptComponent$bindView$5$1> r2) {
        this.$this_run = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDetailPromptComponent$bindView$5$1(this.$this_run, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.larus.community.impl.detail.loading.a r6 = (com.larus.community.impl.detail.loading.a) this.$this_run.j.getValue();
        if (r6 == null) goto L18;
        b1 r7 = r6.tb();
        if (r7 == null) goto L18;
        a r2 = new a(this.$this_run);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
