package com.obric.assistant.omnidetailpage.componment;

import com.flow.kmp.common.util.CoroutineExtKt;
import com.larus.im.bean.message.Message;
import com.obric.assistant.chat.IObricChatService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/message/Message;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$updateTitle$1$message$2$1", f = "OmniDetailContentComponent.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
public final class OmniDetailContentComponent$updateTitle$1$message$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Message>, Object> {
    final /* synthetic */ String $queryId;
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public OmniDetailContentComponent$updateTitle$1$message$2$1(OmniDetailContentComponent r1, String r2, Continuation<? super OmniDetailContentComponent$updateTitle$1$message$2$1> r3) {
        this.this$0 = r1;
        this.$queryId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OmniDetailContentComponent$updateTitle$1$message$2$1(this.this$0, this.$queryId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Message> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L22:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        OmniDetailContentComponent r7 = this.this$0;
        String r2 = this.$queryId;
        this.label = 1;
        int r3 = OmniDetailContentComponent.I;
        r7.getClass();
        kotlinx.coroutines.j r8 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r8.C();
        IObricChatService.a.getClass();
        IObricChatService r4 = IObricChatService.a.a();
        if (r4 == null) goto L16;
        wc9.e r5 = r4.h();
        if (r5 == null) goto L16;
        String r9 = r5.a;
        if (r9 == null) goto L16;
        com.larus.im.d.e().o(r9, r2, new v(r8));
    L17:
        r6 = r8.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(this);
    L20:
        if (r6 != r0) goto L22;
        return r0;
    L16:
        CoroutineExtKt.c(r8, null);
        goto L17
    }
}
