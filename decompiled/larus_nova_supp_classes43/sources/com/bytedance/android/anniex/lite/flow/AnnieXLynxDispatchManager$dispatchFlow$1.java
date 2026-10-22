package com.bytedance.android.anniex.lite.flow;

import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.AnnieXLynxDispatchManager$dispatchFlow$1", f = "AnnieXLynxDispatchManager.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXLynxDispatchManager$dispatchFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ oa.b $loadFlowTask;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ b this$0;

    public AnnieXLynxDispatchManager$dispatchFlow$1(b r1, oa.b r10, Continuation<? super AnnieXLynxDispatchManager$dispatchFlow$1> r11) {
        this.this$0 = r1;
        this.$loadFlowTask = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AnnieXLynxDispatchManager$dispatchFlow$1(this.this$0, this.$loadFlowTask, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r11 = (Iterator) this.L$1;
        b r12 = (b) this.L$0;
        ResultKt.throwOnFailure(r10);
    L14:
        if (r11.hasNext() == false) goto L21;
        oa.a r13 = (oa.a) r11.next();
        if (r12.e == null) goto L14;
        this.L$0 = r12;
        this.L$1 = r11;
        this.label = 1;
        r13.getClass();
        if (Unit.INSTANCE != r0) goto L14;
        return r0;
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IAnnieXPreloadStrategyProvider r14 = this.this$0.f;
        if (r14 == null) goto L21;
        KitType r15 = KitType.UNKNOWN;
        List r16 = r14.getLoadStrategy();
        if (r16 == null) goto L21;
        r12 = this.this$0;
        r11 = r16.iterator();
        goto L14
    }
}
