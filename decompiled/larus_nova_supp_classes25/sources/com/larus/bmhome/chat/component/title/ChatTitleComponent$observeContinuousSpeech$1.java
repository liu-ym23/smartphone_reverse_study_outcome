package com.larus.bmhome.chat.component.title;

import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import lq9.k;
import s1a.a;
import ss8.g;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$observeContinuousSpeech$1", f = "ChatTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleComponent$observeContinuousSpeech$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ChatTitleComponent this$0;

    public ChatTitleComponent$observeContinuousSpeech$1(ChatTitleComponent r1, Continuation<? super ChatTitleComponent$observeContinuousSpeech$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatTitleComponent$observeContinuousSpeech$1 r0 = new ChatTitleComponent$observeContinuousSpeech$1(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L67;
        ResultKt.throwOnFailure(r6);
        boolean r7 = this.Z$0;
        FLogger r0 = FLogger.a;
        ChatTitleComponent r1 = this.this$0;
        int r2 = ChatTitleComponent.P1;
        r0.i(r1.d4(), "receive continuousTalk change to " + r7);
        if (AudioServiceDelegate.a.F().b() == true) goto L7;
        boolean r3 = false;
        if (r7 == true) goto L33;
        com.larus.platform.api.g0 r8 = this.this$0.n;
        if (r8 == null) goto L13;
        r8.setTtsVisible(true);
    L13:
        com.larus.platform.api.g0 r9 = this.this$0.n;
        if (r9 == null) goto L16;
        r9.setTtsContinuousTalkVisible(false);
    L16:
        b r10 = a.g(a.c(this.this$0));
        if (r10 == null) goto L23;
        g r11 = r10.getAbility(g.class);
        if (r11 == null) goto L23;
        if (r11.bc(ChatUIBlockConfig.HIDE_TITLE_BAR_BUTTONS) != true) goto L23;
        r3 = true;
    L23:
        r0.i(this.this$0.d4(), "[observeContinuousSpeech] continuousTalk=false, isCallBlocked=" + r3);
        com.larus.platform.api.g0 r12 = this.this$0.n;
        if (r12 == null) goto L26;
        r12.setRealTimeCallVisible(!r3);
    L26:
        com.larus.platform.api.g0 r13 = this.this$0.n;
        if (r13 == null) goto L29;
        r13.setMoreBtnEnabled(true);
    L29:
        com.larus.platform.api.g0 r14 = this.this$0.n;
        if (r14 == null) goto L65;
        r14.setBackBtnEnabled(true);
    L65:
        return Unit.INSTANCE;
    L33:
        if (((k) this.this$0.H1.getValue()).e() == true) goto L43;
        com.larus.platform.api.g0 r15 = this.this$0.n;
        if (r15 == null) goto L37;
        r15.setTtsVisible(false);
    L37:
        com.larus.platform.api.g0 r16 = this.this$0.n;
        if (r16 == null) goto L40;
        r16.setTtsContinuousTalkEnabled(false);
    L40:
        com.larus.platform.api.g0 r17 = this.this$0.n;
        if (r17 == null) goto L52;
        r17.setTtsContinuousTalkVisible(true);
    L52:
        com.larus.platform.api.g0 r18 = this.this$0.n;
        if (r18 == null) goto L55;
        r18.setTtsContinuousTalkChecked(true);
    L55:
        com.larus.platform.api.g0 r19 = this.this$0.n;
        if (r19 == null) goto L58;
        r19.setRealTimeCallVisible(false);
    L58:
        com.larus.platform.api.g0 r20 = this.this$0.n;
        if (r20 == null) goto L61;
        r20.setMoreBtnEnabled(false);
    L61:
        com.larus.platform.api.g0 r21 = this.this$0.n;
        if (r21 == null) goto L65;
        r21.setBackBtnEnabled(false);
        goto L65
    L43:
        com.larus.platform.api.g0 r22 = this.this$0.n;
        if (r22 == null) goto L46;
        r22.setTtsVisible(false);
    L46:
        com.larus.platform.api.g0 r23 = this.this$0.n;
        if (r23 == null) goto L49;
        r23.setTtsContinuousTalkEnabled(true);
    L49:
        com.larus.platform.api.g0 r24 = this.this$0.n;
        if (r24 == null) goto L52;
        r24.setTtsContinuousTalkVisible(true);
        goto L52
    L7:
        return Unit.INSTANCE;
    L67:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
