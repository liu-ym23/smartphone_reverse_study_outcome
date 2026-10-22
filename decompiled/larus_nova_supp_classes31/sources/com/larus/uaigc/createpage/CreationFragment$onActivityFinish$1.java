package com.larus.uaigc.createpage;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationFragment$onActivityFinish$1", f = "CreationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationFragment$onActivityFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationFragment this$0;

    public CreationFragment$onActivityFinish$1(CreationFragment r1, Continuation<? super CreationFragment$onActivityFinish$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationFragment$onActivityFinish$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        py9.a r3 = (py9.a) s1a.a.g(this.this$0).getAbility(py9.a.class);
        if (r3 == null) goto L7;
        r3.mV();
    L7:
        CreationFragment r4 = this.this$0;
        int r0 = CreationFragment.n;
        r4.N6();
        ICoreInputAbility r5 = (ICoreInputAbility) this.this$0.i.getValue();
        if (r5 == null) goto L11;
        r5.qp(true);
        Boxing.boxBoolean(true);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
