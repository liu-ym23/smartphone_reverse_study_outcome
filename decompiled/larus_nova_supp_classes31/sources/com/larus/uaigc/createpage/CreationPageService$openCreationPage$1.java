package com.larus.uaigc.createpage;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService$openCreationPage$1", f = "CreationPageService.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
final class CreationPageService$openCreationPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
    int label;
    final /* synthetic */ CreationPageService this$0;

    public CreationPageService$openCreationPage$1(CreationPageService r1, com.larus.bmhome.actionbar.model.z0 r2, String r3, Continuation<? super CreationPageService$openCreationPage$1> r4) {
        this.this$0 = r1;
        this.$item = r2;
        this.$enterMethod = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationPageService$openCreationPage$1(this.this$0, this.$item, this.$enterMethod, r5);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationPageService r6 = this.this$0;
        com.larus.bmhome.actionbar.model.z0 r2 = this.$item;
        String r3 = this.$enterMethod;
        this.label = 1;
        if (CreationPageService.h(r6, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
