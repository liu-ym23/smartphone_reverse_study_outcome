package com.obric.assistant.component.clicktalk;

import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.clicktalk.ChatClickTalkComponent$operateDoraVUI$1$1$1", f = "ChatClickTalkComponent.kt", i = {0}, l = {1763}, m = "invokeSuspend", n = {"operation"}, s = {"L$0"})
public final class ChatClickTalkComponent$operateDoraVUI$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enable;
    final /* synthetic */ long $operationVersion;
    Object L$0;
    int label;

    public ChatClickTalkComponent$operateDoraVUI$1$1$1(boolean r1, long r2, Continuation<? super ChatClickTalkComponent$operateDoraVUI$1$1$1> r4) {
        this.$enable = r1;
        this.$operationVersion = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatClickTalkComponent$operateDoraVUI$1$1$1(this.$enable, this.$operationVersion, r5);
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
        Deferred r2 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r6);
    L22:
        if (Intrinsics.areEqual(r6, Boxing.boxBoolean(true)) == true) goto L25;
        FLogger.a.w("ChatClickTalkComponent", "operateDoraVUI timeout, enable=" + this.$enable);
        final long r3 = this.$operationVersion;
        r2.invokeOnCompletion(new h0(r3));
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L27;
        com.larus.home.impl.sdk.s r8 = r7.s0();
        if (r8 == null) goto L27;
        if (this.$enable == false) goto L15;
        Deferred r9 = r8.j();
    L16:
        if (r9 == null) goto L27;
        ChatClickTalkComponent$operateDoraVUI$1$1$1$completed$1 r4 = new ChatClickTalkComponent$operateDoraVUI$1$1$1$completed$1(r9, null);
        this.L$0 = r9;
        this.label = 1;
        Object r5 = TimeoutKt.c(3000, r4, this);
        if (r5 != r0) goto L20;
        return r0;
    L20:
        r2 = r9;
        r6 = r5;
        goto L22
    L15:
        r9 = r8.g();
    L27:
        return Unit.INSTANCE;
    }
}
