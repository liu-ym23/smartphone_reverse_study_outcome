package com.larus.uaigc.chat.creationsend;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.uaigc.bean.createpage.component.sendmessage.CreationSendUiEvent;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlinx.coroutines.DelayKt;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.creationsend.CreationSendUiEventComponent$handleChatListUiEvent$1", f = "CreationSendUiEventComponent.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
final class CreationSendUiEventComponent$handleChatListUiEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationSendUiEvent $event;
    int label;
    final /* synthetic */ CreationSendUiEventComponent this$0;

    public CreationSendUiEventComponent$handleChatListUiEvent$1(CreationSendUiEvent r1, CreationSendUiEventComponent r2, Continuation<? super CreationSendUiEventComponent$handleChatListUiEvent$1> r3) {
        this.$event = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationSendUiEventComponent$handleChatListUiEvent$1(this.$event, this.this$0, r4);
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
        ResultKt.throwOnFailure(r6);
    L26:
        CreationSendUiEventComponent r7 = this.this$0;
        int r2 = CreationSendUiEventComponent.j;
        r7.getClass();
        u7 r8 = d.a(r7).getAbility(u7.class);
        if (r8 == null) goto L30;
        r8.O5(true);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        if (this.$event.getSetLastReadRestore() == false) goto L14;
        CreationSendUiEventComponent r9 = this.this$0;
        int r3 = CreationSendUiEventComponent.j;
        r9.getClass();
        u7 r10 = d.a(r9).getAbility(u7.class);
        if (r10 == null) goto L14;
        r10.w70();
    L14:
        if (this.$event.getMarkChatListBottomReached() == false) goto L19;
        IObricChatSPIService r11 = (IObricChatSPIService) ServiceManager.get().getService(IObricChatSPIService.class);
        if (r11 == null) goto L19;
        r11.k(d.a(this.this$0));
    L19:
        if (this.$event.getScrollToLatest() == false) goto L30;
        CreationSendUiEventComponent r12 = this.this$0;
        int r4 = CreationSendUiEventComponent.j;
        r12.getClass();
        u7 r13 = d.a(r12).getAbility(u7.class);
        if (r13 == null) goto L23;
        r13.O5(true);
    L23:
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L26;
        return r0;
    }
}
