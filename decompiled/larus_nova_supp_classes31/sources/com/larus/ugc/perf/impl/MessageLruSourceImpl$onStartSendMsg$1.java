package com.larus.ugc.perf.impl;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.perf.impl.MessageLruSourceImpl$onStartSendMsg$1", f = "MessageLruSource.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
final class MessageLruSourceImpl$onStartSendMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ e $sourceData;
    int label;

    public MessageLruSourceImpl$onStartSendMsg$1(e r1, String r2, Continuation<? super MessageLruSourceImpl$onStartSendMsg$1> r3) {
        this.$sourceData = r1;
        this.$botId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MessageLruSourceImpl$onStartSendMsg$1(this.$sourceData, this.$botId, r4);
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
        Long r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        BotModel r7 = (BotModel) r6;
        if (r7 == null) goto L14;
        e r3 = this.$sourceData;
        f r4 = f.a;
        Integer r5 = r7.getBotType();
        r4.getClass();
        if (r5 != null) goto L19;
    L21:
        if (r5 != null) goto L24;
    L26:
        String r8 = "0";
    L27:
        r3.f(r8);
        e r9 = this.$sourceData;
        ModelItem r10 = r7.getModel();
        if (r10 == null) goto L30;
        r2 = Boxing.boxLong(r10.getModelType());
    L30:
        r9.m(r2);
        return Unit.INSTANCE;
    L24:
        if (r5.intValue() != 2) goto L26;
        r8 = "2";
        goto L27
    L19:
        if (r5.intValue() != 1) goto L21;
        r8 = "1";
        goto L27
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        MessageLruSourceImpl$onStartSendMsg$1$bot$1 r12 = new MessageLruSourceImpl$onStartSendMsg$1$bot$1(this.$botId, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r11, r12, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
