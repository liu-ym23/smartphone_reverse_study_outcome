package com.obric.audio.enroll.ui.fragment;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$handleTipsBlocking$2$1", f = "EnrollingFragment.kt", i = {}, l = {622}, m = "invokeSuspend", n = {}, s = {})
final class EnrollingFragment$handleTipsBlocking$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    public EnrollingFragment$handleTipsBlocking$2$1(EnrollingFragment r1, Continuation<? super EnrollingFragment$handleTipsBlocking$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollingFragment$handleTipsBlocking$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
    L10:
        if (this.this$0.j != EnrollingFragment.TipState.CHANGING) goto L12;
        boolean r2 = true;
    L13:
        FLogger.a.i("EnrollingFragment", "isTipState changing , need wait some time");
        if (r2 == false) goto L19;
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L10;
        return r0;
    L19:
        return Boxing.boxBoolean(true);
    L12:
        r2 = false;
        goto L13
    }
}
