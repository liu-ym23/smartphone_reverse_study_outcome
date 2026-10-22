package com.larus.bmhome.chat.standarduikit.browsercontrol.vm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.browsercontrol.vm.BrowserControlViewModel$browserControlBlockOutput$2$1$onRejectClick$1", f = "BrowserControlViewModel.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
public final class BrowserControlViewModel$browserControlBlockOutput$2$1$onRejectClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrowserControlViewModel this$0;

    public BrowserControlViewModel$browserControlBlockOutput$2$1$onRejectClick$1(BrowserControlViewModel r1, Continuation<? super BrowserControlViewModel$browserControlBlockOutput$2$1$onRejectClick$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BrowserControlViewModel$browserControlBlockOutput$2$1$onRejectClick$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        int r5 = e.a;
        a r6 = this.this$0.a;
        if (r6 == null) goto L12;
        String r7 = r6.c;
        if (r7 == null) goto L12;
    L13:
        this.label = 1;
        if (e.a(r7, this) != r0) goto L17;
        return r0;
    L12:
        r7 = "";
        goto L13
    }
}
