package com.larus.bot.impl.feature.edit.feature.bio;

import android.animation.ObjectAnimator;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bio.BotBioEditView$bindObservers$1", f = "BotBioEditView.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
final class BotBioEditView$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ f this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            c r6 = (c) r4;
            f r7 = this.a;
            r7.getClass();
            if (r6.a == true) goto L5;
            r7.a.a.setVisibility(8);
        L13:
            return Unit.INSTANCE;
        L5:
            r7.a.a.setVisibility(0);
            if (r6.b == false) goto L8;
            r7.a.b.setHint("");
            r7.a.b.setEnabled(false);
            r7.a.c.a.setVisibility(0);
            r7.e = com.larus.bot.impl.common.util.j.c(r7.a.c.a);
            goto L13
        L8:
            r7.a.b.setHint(r7.c.getResources().getString(2131901098));
            r7.a.c.a.setVisibility(8);
            r7.a.b.setEnabled(true);
            ObjectAnimator r8 = r7.e;
            if (r8 == null) goto L11;
            r8.cancel();
        L11:
            r7.e = null;
            goto L13
        }
    }

    public BotBioEditView$bindObservers$1(f r1, Continuation<? super BotBioEditView$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotBioEditView$bindObservers$1(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i1<c> r6 = this.this$0.b.getUiState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
