package com.larus.voicecall.impl.continue_talk;

import android.app.KeyguardManager;
import com.larus.audio.call.a;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "it", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponentViewModel$observeNotificationAction$1", f = "ChatContinuousTalkComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatContinuousTalkComponentViewModel$observeNotificationAction$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ChatContinuousTalkComponentViewModel this$0;

    public ChatContinuousTalkComponentViewModel$observeNotificationAction$1(ChatContinuousTalkComponentViewModel r1, Continuation<? super ChatContinuousTalkComponentViewModel$observeNotificationAction$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatContinuousTalkComponentViewModel$observeNotificationAction$1 r0 = new ChatContinuousTalkComponentViewModel$observeNotificationAction$1(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r4);
        int r5 = this.I$0;
        Object r0 = AppHost.a.getApplication().getSystemService("keyguard");
        if ((r0 instanceof KeyguardManager) == false) goto L7;
        KeyguardManager r1 = (KeyguardManager) r0;
    L8:
        boolean r2 = false;
        if (r1 != null) goto L11;
    L13:
        if (r2 == false) goto L15;
        String r3 = "lock_screen";
    L17:
        if (r5 != 1) goto L19;
        FLogger.a.i("ChatContinuousTalkComponentViewModel", "receive RtcNotificationAction.MUTE action");
        this.this$0.tryMute();
        ChatContinuousTalkComponentViewModel.access$mobMuteCallInContinuousTalk(this.this$0, r3);
    L31:
        return Unit.INSTANCE;
    L19:
        if (r5 != 2) goto L21;
        FLogger.a.i("ChatContinuousTalkComponentViewModel", "receive RtcNotificationAction.UN_MUTE action");
        this.this$0.tryUnMute();
        goto L31
    L21:
        if (r5 != 3) goto L31;
        FLogger.a.i("ChatContinuousTalkComponentViewModel", "receive RtcNotificationAction.HANG_UP action");
        RealtimeCallService r6 = ChatContinuousTalkComponentViewModel.access$getRealtimeCallService$p(this.this$0);
        if (r6 == null) goto L31;
        Function1 r7 = ((a) r6).g;
        if (r7 == null) goto L31;
        r7.invoke(r3);
        goto L31
    L15:
        r3 = "banner";
        goto L17
    L11:
        if (r1.isKeyguardLocked() != true) goto L13;
        r2 = true;
        goto L13
    L7:
        r1 = null;
        goto L8
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
