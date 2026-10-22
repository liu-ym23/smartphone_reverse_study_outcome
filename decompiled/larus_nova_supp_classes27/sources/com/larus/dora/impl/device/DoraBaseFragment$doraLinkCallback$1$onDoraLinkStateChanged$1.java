package com.larus.dora.impl.device;

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
@DebugMetadata(c = "com.larus.dora.impl.device.DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1", f = "DoraBaseFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ DoraBaseFragment this$0;

    public DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1(DoraBaseFragment r1, int r2, Continuation<? super DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1> r3) {
        this.this$0 = r1;
        this.$state = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1(this.this$0, this.$state, r4);
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
        DoraBaseFragment r4 = this.this$0;
        if (this.$state != 2) goto L7;
        boolean r0 = true;
    L8:
        r4.V90(r0);
        return Unit.INSTANCE;
    L7:
        r0 = false;
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
