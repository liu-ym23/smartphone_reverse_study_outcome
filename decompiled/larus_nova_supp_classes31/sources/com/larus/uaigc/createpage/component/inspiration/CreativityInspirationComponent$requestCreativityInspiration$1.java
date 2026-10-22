package com.larus.uaigc.createpage.component.inspiration;

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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.inspiration.CreativityInspirationComponent$requestCreativityInspiration$1", f = "CreativityInspirationComponent.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
final class CreativityInspirationComponent$requestCreativityInspiration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasFace;
    final /* synthetic */ int $method;
    final /* synthetic */ int $scene;
    int label;
    final /* synthetic */ CreativityInspirationComponent this$0;

    public CreativityInspirationComponent$requestCreativityInspiration$1(CreativityInspirationComponent r1, int r2, int r3, boolean r4, Continuation<? super CreativityInspirationComponent$requestCreativityInspiration$1> r5) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$method = r3;
        this.$hasFace = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CreativityInspirationComponent$requestCreativityInspiration$1(this.this$0, this.$scene, this.$method, this.$hasFace, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ImageInspirationViewModel r11 = this.this$0.F2();
        fq8.c r2 = new fq8.c(this.$scene, this.$method, (String) this.this$0.k.getValue(), (String) this.this$0.i.getValue(), new fq8.d(Boxing.boxBoolean(this.$hasFace)));
        this.label = 1;
        if (r11.requestImgInspireRequest(r2, this) != r0) goto L12;
        return r0;
    }
}
