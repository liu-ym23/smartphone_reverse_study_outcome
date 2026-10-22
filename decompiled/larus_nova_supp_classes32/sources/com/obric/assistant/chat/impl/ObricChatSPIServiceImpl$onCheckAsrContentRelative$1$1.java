package com.obric.assistant.chat.impl;

import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.automic.IObricAutoMicService;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.impl.ObricChatSPIServiceImpl$onCheckAsrContentRelative$1$1", f = "ObricChatSPIServiceImpl.kt", i = {}, l = {MessageContentType.FORM_MSG}, m = "invokeSuspend", n = {}, s = {})
final class ObricChatSPIServiceImpl$onCheckAsrContentRelative$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $asrContent;
    final /* synthetic */ com.obric.assistant.voice.a $historyContent;
    final /* synthetic */ IObricAutoMicService $this_run;
    int label;

    public ObricChatSPIServiceImpl$onCheckAsrContentRelative$1$1(IObricAutoMicService r1, String r2, com.obric.assistant.voice.a r3, Continuation<? super ObricChatSPIServiceImpl$onCheckAsrContentRelative$1$1> r4) {
        this.$this_run = r1;
        this.$asrContent = r2;
        this.$historyContent = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricChatSPIServiceImpl$onCheckAsrContentRelative$1$1(this.$this_run, this.$asrContent, this.$historyContent, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IObricAutoMicService r6 = this.$this_run;
        String r2 = this.$asrContent;
        com.obric.assistant.voice.a r3 = this.$historyContent;
        this.label = 1;
        r5 = r6.j(r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
