package com.obric.assistant.chat;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.ObricChatService$setTtsEnable$task$1$2$t$1", f = "ObricChatService.kt", i = {}, l = {664}, m = "invokeSuspend", n = {}, s = {})
public final class ObricChatService$setTtsEnable$task$1$2$t$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $enable;
    int label;
    final /* synthetic */ ObricChatService this$0;

    public ObricChatService$setTtsEnable$task$1$2$t$1(boolean r1, ObricChatService r2, Continuation<? super ObricChatService$setTtsEnable$task$1$2$t$1> r3) {
        this.$enable = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricChatService$setTtsEnable$task$1$2$t$1(this.$enable, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
    L9:
        boolean r2 = this.$enable;
        ObricChatService r3 = this.this$0;
        List r4 = ObricChatService.m;
        if (r2 == r3.x()) goto L14;
        FLogger.a.i("ObricChatService", "AFTER PERFORM ! waiting.......100ms to check the ttsButton again , desireValue is " + this.$enable + " , current is " + this.this$0.x());
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L9;
        return r0;
    L14:
        boolean r8 = this.this$0.x();
        FLogger.a.i("ObricChatService", "END WAITING... " + r8);
        return Boxing.boxBoolean(r8);
    }
}
