package com.larus.voicecall.impl.continue_talk;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.bot.BotModel;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1", f = "ChatContinuousTalkComponent.kt", i = {0}, l = {379, 379, 386, 393}, m = "invokeSuspend", n = {"conv"}, s = {"L$0"})
public final class ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ xa8.e $param;
    Object L$0;
    int label;
    final /* synthetic */ ChatContinuousTalkComponent this$0;

    public ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1(ChatContinuousTalkComponent r1, xa8.e r2, Continuation<? super ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1> r3) {
        this.this$0 = r1;
        this.$param = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1(this.this$0, this.$param, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r14);
    L55:
        if (r14 == null) goto L58;
        this.this$0.fk(this.$param);
    L58:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r14);
    L43:
        if (r14 == null) goto L46;
        this.this$0.fk(this.$param);
    L46:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r14);
    L31:
        if (r14 == null) goto L34;
        this.this$0.fk(this.$param);
    L34:
        return Unit.INSTANCE;
    L13:
        Deferred r2 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r14);
    L27:
        if (r14 == null) goto L34;
        this.L$0 = null;
        this.label = 2;
        r14 = r2.await(this);
        if (r14 != r0) goto L31;
        return r0;
    L14:
        ResultKt.throwOnFailure(r14);
        ChatContinuousTalkComponent r15 = this.this$0;
        int r3 = ChatContinuousTalkComponent.M;
        com.larus.bmhome.chat.component.cvs.y r16 = r15.u0();
        if (r16 == null) goto L17;
        wc9.e r17 = r16.h();
    L18:
        if (r17 != null) goto L35;
        com.larus.bmhome.chat.component.cvs.y r18 = this.this$0.u0();
        if (r18 == null) goto L22;
        BotModel r19 = r18.j0();
    L23:
        if (r19 != null) goto L35;
        Deferred r110 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$bot$1(this.this$0, null), 3, null);
        r2 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$conv$1(this.this$0, null), 3, null);
        this.L$0 = r2;
        this.label = 1;
        r14 = r110.await(this);
        if (r14 != r0) goto L27;
        return r0;
    L22:
        r19 = null;
    L35:
        com.larus.bmhome.chat.component.cvs.y r111 = this.this$0.u0();
        if (r111 == null) goto L38;
        wc9.e r112 = r111.h();
    L39:
        if (r112 != null) goto L47;
        Deferred r113 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$conv$2(this.this$0, null), 3, null);
        this.label = 3;
        r14 = r113.await(this);
        if (r14 != r0) goto L43;
        return r0;
    L47:
        com.larus.bmhome.chat.component.cvs.y r114 = this.this$0.u0();
        if (r114 == null) goto L50;
        BotModel r115 = r114.j0();
    L51:
        if (r115 != null) goto L59;
        Deferred r116 = BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1$bot$2(this.this$0, null), 3, null);
        this.label = 4;
        r14 = r116.await(this);
        if (r14 != r0) goto L55;
        return r0;
    L59:
        this.this$0.fk(this.$param);
        return Unit.INSTANCE;
    L50:
        r115 = null;
        goto L51
    L38:
        r112 = null;
        goto L39
    L17:
        r17 = null;
        goto L18
    }
}
