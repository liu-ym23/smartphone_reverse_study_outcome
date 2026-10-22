package com.larus.voicecall.impl.component.subtitle;

import androidx.fragment.app.FragmentActivity;
import com.larus.im.bean.message.Message;
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
@DebugMetadata(c = "com.larus.voicecall.impl.component.subtitle.RealtimeSubtitleMenuPanelTrigger$handleLikeMessage$1", f = "RealtimeSubtitleMenuPanelTrigger.kt", i = {}, l = {138, 140}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeSubtitleMenuPanelTrigger$handleLikeMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ k0 this$0;

    public RealtimeSubtitleMenuPanelTrigger$handleLikeMessage$1(k0 r1, Continuation<? super RealtimeSubtitleMenuPanelTrigger$handleLikeMessage$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeSubtitleMenuPanelTrigger$handleLikeMessage$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L28:
        Message r7 = (Message) r6;
    L29:
        t19.s r8 = t19.s.a;
        FragmentActivity r2 = this.this$0.a;
        r8.getClass();
        t19.s.o(r2, 2131910469, false);
    L31:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L22:
        Message r9 = (Message) r6;
        goto L31
    L10:
        ResultKt.throwOnFailure(r6);
        Message r10 = this.this$0.e;
        if (r10 != null) goto L13;
    L15:
        boolean r11 = false;
    L16:
        if (r11 == false) goto L23;
        k0 r12 = this.this$0;
        com.larus.voicecall.impl.component.feedback.e r3 = r12.c;
        if (r3 == null) goto L31;
        Message r13 = r12.e;
        this.label = 1;
        r6 = r3.fL(r13, this);
        if (r6 != r0) goto L22;
        return r0;
    L23:
        k0 r14 = this.this$0;
        com.larus.voicecall.impl.component.feedback.e r4 = r14.c;
        if (r4 == null) goto L29;
        Message r15 = r14.e;
        this.label = 2;
        r6 = r4.R90(r15, this);
        if (r6 != r0) goto L28;
        return r0;
    L13:
        if (com.larus.bmhome.chat.bean.d.q0(r10) != true) goto L15;
        r11 = true;
        goto L16
    }
}
