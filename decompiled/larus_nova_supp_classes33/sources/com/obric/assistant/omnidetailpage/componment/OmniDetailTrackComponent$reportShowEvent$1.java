package com.obric.assistant.omnidetailpage.componment;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailTrackComponent$reportShowEvent$1", f = "OmniDetailTrackComponent.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class OmniDetailTrackComponent$reportShowEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OmniDetailTrackComponent this$0;

    public OmniDetailTrackComponent$reportShowEvent$1(OmniDetailTrackComponent r1, Continuation<? super OmniDetailTrackComponent$reportShowEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OmniDetailTrackComponent$reportShowEvent$1(this.this$0, r3);
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
        String r2 = (String) this.L$1;
        com.larus.platform.service.o r3 = (com.larus.platform.service.o) this.L$0;
        ResultKt.throwOnFailure(r5);
    L12:
        r3.b(r2, (Bundle) r5);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        r3 = com.larus.platform.service.o.a;
        OmniDetailTrackComponent r6 = this.this$0;
        this.L$0 = r3;
        this.L$1 = "obric_omni_detail_show";
        this.label = 1;
        r5 = OmniDetailTrackComponent.F2(r6, this);
        if (r5 != r0) goto L11;
        return r0;
    L11:
        r2 = "obric_omni_detail_show";
        goto L12
    }
}
