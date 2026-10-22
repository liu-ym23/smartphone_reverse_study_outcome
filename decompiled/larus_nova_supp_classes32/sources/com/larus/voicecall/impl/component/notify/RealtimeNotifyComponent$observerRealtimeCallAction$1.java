package com.larus.voicecall.impl.component.notify;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "it", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent$observerRealtimeCallAction$1", f = "RealtimeNotifyComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeNotifyComponent$observerRealtimeCallAction$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ RealtimeNotifyComponent this$0;

    public RealtimeNotifyComponent$observerRealtimeCallAction$1(RealtimeNotifyComponent r1, Continuation<? super RealtimeNotifyComponent$observerRealtimeCallAction$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RealtimeNotifyComponent$observerRealtimeCallAction$1 r0 = new RealtimeNotifyComponent$observerRealtimeCallAction$1(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r2);
        int r3 = this.I$0;
        if (r3 != 1) goto L7;
        RealtimeNotifyComponent r4 = this.this$0;
        int r0 = RealtimeNotifyComponent.w;
        com.larus.voicecall.impl.component.core.a r5 = r4.m3();
        if (r5 == null) goto L21;
        r5.mute();
    L21:
        return Unit.INSTANCE;
    L7:
        if (r3 != 2) goto L9;
        RealtimeNotifyComponent r6 = this.this$0;
        int r1 = RealtimeNotifyComponent.w;
        com.larus.voicecall.impl.component.core.a r7 = r6.m3();
        if (r7 == null) goto L21;
        r7.R1();
        goto L21
    L9:
        if (r3 != 3) goto L21;
        RealtimeNotifyComponent r8 = this.this$0;
        int r9 = RealtimeNotifyComponent.w;
        com.larus.voicecall.impl.component.window.b r10 = (com.larus.voicecall.impl.component.window.b) r8.p.getValue();
        if (r10 == null) goto L21;
        r10.zg();
        goto L21
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
