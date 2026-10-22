package com.larus.bmhome.chat.component.trace;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.d;
import com.obric.assistant.spi.message.IObricForegroundWidgetSyncService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import k99.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.trace.ChatTraceComponent$appBackGroundListener$1$onAppForeground$3$1", f = "ChatTraceComponent.kt", i = {0}, l = {570}, m = "invokeSuspend", n = {"extra"}, s = {"L$0"})
public final class ChatTraceComponent$appBackGroundListener$1$onAppForeground$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $it;
    Object L$0;
    int label;
    final /* synthetic */ ChatTraceComponent this$0;

    public ChatTraceComponent$appBackGroundListener$1$onAppForeground$3$1(ChatTraceComponent r1, e r2, Continuation<? super ChatTraceComponent$appBackGroundListener$1$onAppForeground$3$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTraceComponent$appBackGroundListener$1$onAppForeground$3$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Map r2 = (Map) this.L$0;
        ResultKt.throwOnFailure(r5);
    L19:
        Map r6 = r2;
    L20:
        d.d().pullRemoteConversation(this.$it.a, "onAppForeground", r6);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        r6 = new LinkedHashMap();
        a r3 = (a) this.this$0.A.getValue();
        if (r3 != null) goto L11;
    L13:
        IObricForegroundWidgetSyncService r4 = (IObricForegroundWidgetSyncService) ServiceManager.get().getService(IObricForegroundWidgetSyncService.class);
        if (r4 == null) goto L20;
        String r7 = this.$it.a;
        this.L$0 = r6;
        this.label = 1;
        if (r4.a(r7, this) != r0) goto L18;
        return r0;
    L18:
        r2 = r6;
        goto L19
    L11:
        if (r3.EP() == null) goto L13;
        r6.put("disable_check_single_chain", "1");
        goto L13
    }
}
