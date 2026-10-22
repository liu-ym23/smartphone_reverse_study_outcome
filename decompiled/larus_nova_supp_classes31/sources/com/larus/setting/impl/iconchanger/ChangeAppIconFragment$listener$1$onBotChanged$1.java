package com.larus.setting.impl.iconchanger;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.service.BotChangeType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment$listener$1$onBotChanged$1", f = "ChangeAppIconFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChangeAppIconFragment$listener$1$onBotChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotChangeType $changeType;
    int label;
    final /* synthetic */ ChangeAppIconFragment this$0;

    public ChangeAppIconFragment$listener$1$onBotChanged$1(BotChangeType r1, ChangeAppIconFragment r2, Continuation<? super ChangeAppIconFragment$listener$1$onBotChanged$1> r3) {
        this.$changeType = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChangeAppIconFragment$listener$1$onBotChanged$1(this.$changeType, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r2);
        if (this.$changeType == BotChangeType.DELETE) goto L14;
        ChangeAppIconFragment r3 = this.this$0;
        if (r3.x == false) goto L14;
        BotModel r0 = r3.r;
        if (r0 == null) goto L11;
        SpeakerVoice r1 = r0.getVoiceType();
    L12:
        r3.ba0(r1);
        goto L14
    L11:
        r1 = null;
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
