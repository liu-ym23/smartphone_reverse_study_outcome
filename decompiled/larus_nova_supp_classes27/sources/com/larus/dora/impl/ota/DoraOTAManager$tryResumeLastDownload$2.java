package com.larus.dora.impl.ota;

import com.bytedance.dora.device.DoraDevice;
import g49.d;
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
@DebugMetadata(c = "com.larus.dora.impl.ota.DoraOTAManager$tryResumeLastDownload$2", f = "DoraOTAManager.kt", i = {}, l = {417}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTAManager$tryResumeLastDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraOTAManager$a $context;
    final /* synthetic */ DoraDevice $current;
    final /* synthetic */ String $trigger;
    int label;

    public DoraOTAManager$tryResumeLastDownload$2(DoraDevice r1, DoraOTAManager$a r2, String r3, Continuation<? super DoraOTAManager$tryResumeLastDownload$2> r4) {
        this.$current = r1;
        this.$context = r2;
        this.$trigger = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraOTAManager$tryResumeLastDownload$2(this.$current, this.$context, this.$trigger, r5);
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
        if (((Boolean) r5).booleanValue() == true) goto L15;
        d.e("DoraOTAManager", "tryResumeLastDownload: owner rejected, trigger=" + this.$trigger);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DoraOTAManager r6 = DoraOTAManager.a;
        DoraDevice r2 = this.$current;
        e49.a r3 = this.$context.b;
        this.label = 1;
        r5 = r6.b(r2, r3, true, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
