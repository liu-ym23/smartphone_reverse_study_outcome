package com.obric.audio.continuous_talk;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import laa.f;
import r58.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkUIComponent$invokeOnSpeak$1$5$1$1", f = "ObricContinuousTalkUIComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkUIComponent$invokeOnSpeak$1$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $audioData;
    int label;
    final /* synthetic */ ObricContinuousTalkUIComponent this$0;

    public ObricContinuousTalkUIComponent$invokeOnSpeak$1$5$1$1(ObricContinuousTalkUIComponent r1, d r2, Continuation<? super ObricContinuousTalkUIComponent$invokeOnSpeak$1$5$1$1> r3) {
        this.this$0 = r1;
        this.$audioData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricContinuousTalkUIComponent$invokeOnSpeak$1$5$1$1(this.this$0, this.$audioData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        ObricContinuousTalkUIComponent r6 = this.this$0;
        d r0 = this.$audioData;
        int r1 = ObricContinuousTalkUIComponent.M;
        r6.getClass();
        FLogger.a.i("ObricContinuousTalkUIComponent", "processRecordedAudio: " + r0);
        f r7 = r6.z3();
        if (r7 == null) goto L8;
        r7.Ru(r0.b, null);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
