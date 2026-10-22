package com.larus.tts.impl;

import com.larus.audio.ttsV2.a;
import com.larus.im.bean.bot.BotModel;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$onTtsCheckClick$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {784}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleTtsComponent$onTtsCheckClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ Ref.BooleanRef $isAudioDowngrade;
    final /* synthetic */ Ref.BooleanRef $isChecked;
    final /* synthetic */ String $openMethod;
    final /* synthetic */ com.larus.platform.api.g0 $title;
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public ChatTitleTtsComponent$onTtsCheckClick$1(ChatTitleTtsComponent r1, Ref.BooleanRef r2, BotModel r3, Ref.BooleanRef r4, String r5, com.larus.platform.api.g0 r6, Continuation<? super ChatTitleTtsComponent$onTtsCheckClick$1> r7) {
        this.this$0 = r1;
        this.$isChecked = r2;
        this.$bot = r3;
        this.$isAudioDowngrade = r4;
        this.$openMethod = r5;
        this.$title = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatTitleTtsComponent$onTtsCheckClick$1(this.this$0, this.$isChecked, this.$bot, this.$isAudioDowngrade, this.$openMethod, this.$title, r10);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ChatTitleTtsComponent r2 = this.this$0;
        boolean r12 = this.$isChecked.element;
        BotModel r3 = this.$bot;
        int r4 = ChatTitleTtsComponent.v;
        e r5 = r2.U2();
        boolean r6 = this.$isAudioDowngrade.element;
        String r7 = this.$openMethod;
        a r8 = new a(this.$title.getEarphoneState().a, this.$title.getEarphoneState().b);
        this.label = 1;
        if (ChatTitleTtsComponent.F2(r2, r12, r3, r5, r6, r7, r8, this) != r0) goto L12;
        return r0;
    }
}
