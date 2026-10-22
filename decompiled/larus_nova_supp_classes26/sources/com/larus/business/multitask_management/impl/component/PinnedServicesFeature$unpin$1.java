package com.larus.business.multitask_management.impl.component;

import android.content.Context;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ll9.r;
import ll9.t;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.PinnedServicesFeature$unpin$1", f = "PinnedServicesFeature.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
public final class PinnedServicesFeature$unpin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t $node;
    int label;
    final /* synthetic */ PinnedServicesFeature this$0;

    public PinnedServicesFeature$unpin$1(PinnedServicesFeature r1, t r2, Continuation<? super PinnedServicesFeature$unpin$1> r3) {
        this.this$0 = r1;
        this.$node = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PinnedServicesFeature$unpin$1(this.this$0, this.$node, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Long r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        r r7 = (r) r6;
        if (r7 == null) goto L14;
        r2 = r7.a;
    L14:
        if (r2 != null) goto L17;
        FLogger.a.e("multitask-PinnedServicesFeature", "unpin node " + this.$node + " failed");
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        PinnedServicesFeature r8 = this.this$0;
        t r3 = this.$node;
        PinnedServicesFeature.F2(r8, r3.a, r3.b);
        s r9 = s.a;
        Context r4 = this.this$0.getContext();
        int r5 = j0.a;
        String r10 = j0.d(2131899890);
        r9.getClass();
        s.p(r4, r10);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        PinnedServicesFeature$unpin$1$resp$1 r12 = new PinnedServicesFeature$unpin$1$resp$1(this.$node, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r11, r12, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
