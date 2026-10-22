package com.obric.assistant.audio;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.audio.ObricTtsServiceImpl$audioObserver$1$onObricTTSStateChanged$1$1", f = "ObricTtsServiceImpl.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
public final class ObricTtsServiceImpl$audioObserver$1$onObricTTSStateChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ ObricTtsServiceImpl this$0;

    public ObricTtsServiceImpl$audioObserver$1$onObricTTSStateChanged$1$1(String r1, ObricTtsServiceImpl r2, Continuation<? super ObricTtsServiceImpl$audioObserver$1$onObricTTSStateChanged$1$1> r3) {
        this.$it = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricTtsServiceImpl$audioObserver$1$onObricTTSStateChanged$1$1(this.$it, this.this$0, r4);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        Message r6 = (Message) r5;
        if (r6 == null) goto L33;
        ObricTtsServiceImpl r3 = this.this$0;
        IObricChatService.a.getClass();
        IObricChatService r4 = IObricChatService.a.a();
        if (r4 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L30;
        IBluetoothHeadSetAPI r8 = tha.c.a();
        if (r8 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L28;
    L31:
        r3.a = Boxing.boxBoolean(r2);
        goto L33
    L28:
        if (r3.d(r6) == false) goto L30;
    L23:
        if (r8.a() != true) goto L25;
        r9 = true;
    L30:
        r2 = false;
        goto L31
    L16:
        if (r4.c(r6) != true) goto L18;
        r7 = true;
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IChatRepoService r10 = zh8.a.a;
        String r11 = this.$it;
        this.label = 1;
        r5 = r10.E1(r11, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
