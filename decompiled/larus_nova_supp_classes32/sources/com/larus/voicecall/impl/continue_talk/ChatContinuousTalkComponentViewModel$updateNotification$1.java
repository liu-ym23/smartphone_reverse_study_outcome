package com.larus.voicecall.impl.continue_talk;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IRtcNotificationService;
import com.larus.voicecall.impl.notification.d;
import com.obric.aivoice.core.data.NameKeys;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponentViewModel$updateNotification$1", f = "ChatContinuousTalkComponentViewModel.kt", i = {}, l = {597}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponentViewModel$updateNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ ChatContinuousTalkComponentViewModel this$0;

    public ChatContinuousTalkComponentViewModel$updateNotification$1(ChatContinuousTalkComponentViewModel r1, String r2, Context r3, Continuation<? super ChatContinuousTalkComponentViewModel$updateNotification$1> r4) {
        this.this$0 = r1;
        this.$reason = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatContinuousTalkComponentViewModel$updateNotification$1(this.this$0, this.$reason, this.$context, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        Bitmap r3 = (Bitmap) r12;
        int r13 = com.larus.voicecall.impl.ui.t.a;
        String r2 = com.larus.voicecall.impl.ui.t.a(AppHost.a.getApplication(), ChatContinuousTalkComponentViewModel.access$getCurrentState$p(this.this$0), ChatContinuousTalkComponentViewModel.access$isMute$p(this.this$0));
        FLogger.a.d("ChatContinuousTalkComponentViewModel", "refreshCallNotification, currentState:" + this.this$0.getState().getTalkState() + ", content:" + r2);
        d r14 = d.a;
        String r9 = this.$reason;
        BotModel r4 = ChatContinuousTalkComponentViewModel.access$getCurrentBot$p(this.this$0);
        if (r4 == null) goto L14;
        String r5 = r4.getName();
    L15:
        if (r5 != null) goto L17;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L17:
        IRtcNotificationService.a r10 = new IRtcNotificationService.a(r5, r2, r3, com.larus.voicecall.impl.ui.t.b(ChatContinuousTalkComponentViewModel.access$getCurrentState$p(this.this$0), ChatContinuousTalkComponentViewModel.access$isMute$p(this.this$0)), ChatContinuousTalkComponentViewModel.access$isMute$p(this.this$0), true, true, this.$context);
        r14.getClass();
        d.f(r9, r10);
        return Unit.INSTANCE;
    L14:
        r5 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        ChatContinuousTalkComponentViewModel r15 = this.this$0;
        this.label = 1;
        r12 = ChatContinuousTalkComponentViewModel.access$getRoundAvatarBitmap(r15, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
