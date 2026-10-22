package com.obric.assistant.audio;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.audio.ObricTtsServiceImpl$playTtsSimple$1", f = "ObricTtsServiceImpl.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
final class ObricTtsServiceImpl$playTtsSimple$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $playScene;
    int label;
    final /* synthetic */ ObricTtsServiceImpl this$0;

    public ObricTtsServiceImpl$playTtsSimple$1(ObricTtsServiceImpl r1, String r2, String r3, Continuation<? super ObricTtsServiceImpl$playTtsSimple$1> r4) {
        this.this$0 = r1;
        this.$playScene = r2;
        this.$content = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricTtsServiceImpl$playTtsSimple$1(this.this$0, this.$playScene, this.$content, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        ObricTtsServiceImpl r7 = this.this$0;
        String r2 = this.$playScene;
        String r3 = this.$content;
        int r4 = ObricTtsServiceImpl.e;
        r7.h(r2, r3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r5 = this.this$0.c;
        this.label = 1;
        if (DelayKt.delay(r5, this) != r0) goto L11;
        return r0;
    }
}
