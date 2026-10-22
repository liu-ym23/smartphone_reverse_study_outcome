package com.larus.voicecall.impl.component.core;

import com.larus.audio.AudioServiceDelegate;
import com.larus.im.service.audio.y0;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.core.RealtimeCoreComponent$startConnection$1", f = "RealtimeCoreComponent.kt", i = {}, l = {429, 432}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCoreComponent$startConnection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCoreComponent this$0;

    public RealtimeCoreComponent$startConnection$1(RealtimeCoreComponent r1, Continuation<? super RealtimeCoreComponent$startConnection$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCoreComponent$startConnection$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L15:
        RealtimeCoreComponent r6 = this.this$0;
        this.label = 2;
        if (RealtimeCoreComponent.C3(r6, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        RealtimeCoreComponent r7 = this.this$0;
        int r2 = RealtimeCoreComponent.P;
        if (y0.e(((h88.b) r7.W3()).e) == false) goto L15;
        AudioServiceDelegate r8 = AudioServiceDelegate.a;
        this.label = 1;
        if (r8.K("RealtimeCoreComponent", this) != r0) goto L15;
        return r0;
    }
}
