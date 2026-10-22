package com.larus.business.floatchat.impl;

import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import va8.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1", f = "AIFloatChatViewControlBizCmdProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t0 $bizPayload;
    final /* synthetic */ String $queryMsgId;
    int label;

    public AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1(String r1, t0 r2, Continuation<? super AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1> r3) {
        this.$queryMsgId = r1;
        this.$bizPayload = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1(this.$queryMsgId, this.$bizPayload, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r6);
        CopyOnWriteArrayList<WeakReference<ew8.b>> r7 = y.a;
        String r8 = this.$queryMsgId;
        t0 r0 = this.$bizPayload;
        Iterator<WeakReference<ew8.b>> r1 = y.a.iterator();
        boolean r2 = false;
    L6:
        if (r1.hasNext() == false) goto L11;
        WeakReference<ew8.b> r3 = r1.next();
        ew8.b r4 = r3.get();
        if (r4 == null) goto L9;
        r4.ba(r8, r0);
        r2 = true;
        goto L6
    L9:
        y.a.remove(r3);
        goto L6
    L11:
        FLogger.a.i("AIFloatChatWindowEventDispatcher", "onReceiveRefreshCmd queryMsgId=" + r8 + ", viewBusinessPayload=" + r0 + ", dispatched=" + r2);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
