package com.larus.tts.impl;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.tencent.open.log.TraceLevel;
import es8.d;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$handleTtsChecked$2$1$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleTtsComponent$handleTtsChecked$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $checked;
    final /* synthetic */ boolean $updateStatue;
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public ChatTitleTtsComponent$handleTtsChecked$2$1$1(boolean r1, ChatTitleTtsComponent r2, boolean r3, Continuation<? super ChatTitleTtsComponent$handleTtsChecked$2$1$1> r4) {
        this.$updateStatue = r1;
        this.this$0 = r2;
        this.$checked = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatTitleTtsComponent$handleTtsChecked$2$1$1(this.$updateStatue, this.this$0, this.$checked, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r8);
        if (this.$updateStatue == false) goto L23;
        ChatTitleTtsComponent r9 = this.this$0;
        int r0 = ChatTitleTtsComponent.v;
        com.larus.platform.api.g0 r10 = r9.Y2();
        if (r10 == null) goto L23;
        boolean r1 = this.$checked;
        ChatTitleTtsComponent r2 = this.this$0;
        r10.setTtsChecked(r1);
        if (r10.getTtsBanned() == false) goto L11;
    L13:
        boolean r3 = false;
    L14:
        r2.j.setValue(Boxing.boxBoolean(r3));
        if (ObricTtsControlDelegate.b.e() == false) goto L17;
        boolean r4 = d.a;
        d.b.postValue(Boolean.valueOf(r3));
    L17:
        FLogger r5 = FLogger.a;
        r5.i("ChatTitleTtsComponent", "[showTtsCheckedToast][normal] checked=" + r1 + ", ttsBanned=" + r10.getTtsBanned() + ", ttsEnabled=" + r3 + ", earphoneOn=" + r10.getEarphoneState().a);
        if (r3 == false) goto L20;
        int r11 = 2131900115;
    L21:
        r5.i("ChatTitleTtsComponent", "[showTtsCheckedToast] checked=" + r3);
        t19.s.a.g(r2.getContext(), r11, false);
        goto L23
    L20:
        r11 = 2131900114;
        goto L21
    L11:
        if (r10.getTtsChecked() == false) goto L13;
        r3 = true;
    L23:
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
