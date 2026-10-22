package com.larus.community.impl.detail.prompt;

import com.larus.community.impl.detail.bottomtools.CreationLikeState;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.prompt.CreationDetailPromptComponent$initObserver$1", f = "CreationDetailPromptComponent.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailPromptComponent$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationDetailPromptComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationDetailPromptComponent a;

        public a(CreationDetailPromptComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            CreationLikeState r6 = (CreationLikeState) r4;
            CreationDetailPromptView r7 = this.a.m;
            if (r7 == null) goto L9;
            FLogger.a.i("CreationDetailPromptComponent", "creationLikeState is " + r6);
            if (r6 == null) goto L9;
            r7.a.e.S5(r6);
        L9:
            return Unit.INSTANCE;
        }
    }

    public CreationDetailPromptComponent$initObserver$1(CreationDetailPromptComponent r1, Continuation<? super CreationDetailPromptComponent$initObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationDetailPromptComponent$initObserver$1(this.this$0, r3);
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
        com.larus.community.impl.detail.bottomtools.a r6 = (com.larus.community.impl.detail.bottomtools.a) this.this$0.i.getValue();
        if (r6 == null) goto L18;
        i1<CreationLikeState> r7 = r6.qd();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
