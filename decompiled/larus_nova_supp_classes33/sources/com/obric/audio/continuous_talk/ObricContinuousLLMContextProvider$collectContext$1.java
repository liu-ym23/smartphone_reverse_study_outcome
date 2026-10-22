package com.obric.audio.continuous_talk;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.cae.libs.useraware.ApWakeEvent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/obric/audio/continuous_talk/session/api/IObricContTalkMgr$LLMContextInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousLLMContextProvider$collectContext$1", f = "ObricContinuousLLMContextProvider.kt", i = {}, l = {ApWakeEvent.WALKING_START}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousLLMContextProvider$collectContext$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super hia.a.c>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $roundId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ i this$0;

    public ObricContinuousLLMContextProvider$collectContext$1(i r1, long r2, Continuation<? super ObricContinuousLLMContextProvider$collectContext$1> r4) {
        this.this$0 = r1;
        this.$roundId = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricContinuousLLMContextProvider$collectContext$1 r0 = new ObricContinuousLLMContextProvider$collectContext$1(this.this$0, this.$roundId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<? super hia.a.c> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L34:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        final kotlinx.coroutines.channels.k r15 = (kotlinx.coroutines.channels.k) this.L$0;
        HashMap<String, String> r2 = new HashMap();
        IObricChatService.a.getClass();
        IObricChatService r3 = IObricChatService.a.a();
        if (r3 == null) goto L14;
        r3.g();
        zca.a r4 = MessageApiImpl.a.f(r2, this.this$0.b, new bda.b.a("", ""));
        i r5 = this.this$0;
        long r6 = this.$roundId;
        r5.c.set(r4.b);
        r2.putAll(r4.a);
        if (r6 != 1) goto L14;
        r5.d.clear();
        r5.d.putAll(r4.a);
    L14:
        if (this.$roundId == 2) goto L16;
    L18:
        boolean r7 = false;
    L20:
        if (r7 == true) goto L22;
    L24:
        HashMap<String, String> r8 = r2;
    L25:
        if (r7 == false) goto L27;
        this.this$0.e.compareAndSet(true, false);
    L27:
        FLogger r9 = FLogger.a;
        this.this$0.getClass();
        r9.i("ObricContinuousLLMContextProvider", "collectContext emit : roundId=" + this.$roundId + ", isAgentExtCompleted=" + this.this$0.c + ", actualMap=" + r8);
        if (this.this$0.c.get() == false) goto L30;
        r15.trySend-JP2dKIU(new hia.a.c(r8, true));
        Boxing.boxBoolean(r15.close(null));
        goto L34
    L30:
        this.this$0.c.set(true);
        r15.trySend-JP2dKIU(new hia.a.c(r8, false));
        final Job r10 = BuildersKt.launch$default(r15, null, null, new ObricContinuousLLMContextProvider$collectContext$1$timeoutJob$1(this.this$0, this.$roundId, r15, r8, null), 3, null);
        final i r11 = this.this$0;
        final long r12 = this.$roundId;
        r11.a = new g(r11, r12, r10, r15);
        Function0 r13 = new h(r10, r11);
        this.label = 1;
        if (ProduceKt.a(r15, r13, this) != r0) goto L34;
        return r0;
    L22:
        if ((!this.this$0.d.isEmpty()) == false) goto L24;
        i r16 = this.this$0;
        HashMap<String, String> r17 = r16.d;
        long r18 = this.$roundId;
        FLogger.a.i("ObricContinuousLLMContextProvider", "collectContext: roundId=" + r18 + ", enableResendScreenShot=" + r16.e + ", originMap=" + r2);
        r8 = r17;
        goto L25
    L16:
        if (this.this$0.e.get() == false) goto L18;
        r7 = true;
        goto L20
    }
}
