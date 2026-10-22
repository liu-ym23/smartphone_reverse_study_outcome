package com.larus.bmhome.chat.larkforward;

import android.os.Handler;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.larkforward.FlowLarkToDoubaoServiceImpl$resolveMainBotConversation$2", f = "FlowLarkToDoubaoServiceImpl.kt", i = {1}, l = {591, 599}, m = "invokeSuspend", n = {"conversation"}, s = {"L$0"})
public final class FlowLarkToDoubaoServiceImpl$resolveMainBotConversation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowLarkToDoubaoServiceImpl.a $accountIdentity;
    final /* synthetic */ Function1<FlowLarkToDoubaoServiceImpl.c, Unit> $callback;
    Object L$0;
    int label;
    final /* synthetic */ FlowLarkToDoubaoServiceImpl this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowLarkToDoubaoServiceImpl$resolveMainBotConversation$2(FlowLarkToDoubaoServiceImpl.a r1, Function1<? super FlowLarkToDoubaoServiceImpl.c, Unit> r2, FlowLarkToDoubaoServiceImpl r3, Continuation<? super FlowLarkToDoubaoServiceImpl$resolveMainBotConversation$2> r4) {
        this.$accountIdentity = r1;
        this.$callback = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowLarkToDoubaoServiceImpl$resolveMainBotConversation$2(this.$accountIdentity, this.$callback, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        wc9.e r2 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r11);
    L24:
        String r3 = CollectionsKt.joinToString$default((Iterable) r11, null, null, null, 0, null, new z(), 31, null);
        final wc9.e r6 = r2;
    L26:
        final String r9 = r3;
        Lazy<Handler> r12 = FlowLarkToDoubaoServiceImpl.a;
        Handler r13 = FlowLarkToDoubaoServiceImpl.b.a();
        final Function1<FlowLarkToDoubaoServiceImpl.c, Unit> r5 = this.$callback;
        final FlowLarkToDoubaoServiceImpl r7 = this.this$0;
        final FlowLarkToDoubaoServiceImpl.a r8 = this.$accountIdentity;
        r13.post(new a0(r5, r6, r7, r8, r9));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        wc9.e r14 = (wc9.e) r11;
        LocalSubConvHelper r4 = LocalSubConvHelper.a;
        String r10 = LocalSubConvHelper.g(r14);
        r3 = "";
        if (r14 != null) goto L16;
    L25:
        r6 = r14;
        goto L26
    L16:
        if (LocalSubConvHelper.e(r14.a, r10) == false) goto L25;
        Lazy r15 = com.larus.im.j.a;
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        this.L$0 = r14;
        this.label = 2;
        Object r16 = com.larus.im.j.d(r10, this);
        if (r16 != r0) goto L23;
        return r0;
    L23:
        r2 = r14;
        r11 = r16;
        goto L24
    L10:
        ResultKt.throwOnFailure(r11);
        LocalSubConvHelper r17 = LocalSubConvHelper.a;
        String r18 = this.$accountIdentity.b;
        this.label = 1;
        r11 = r17.c(r18, null, this);
        if (r11 != r0) goto L13;
        return r0;
    }
}
