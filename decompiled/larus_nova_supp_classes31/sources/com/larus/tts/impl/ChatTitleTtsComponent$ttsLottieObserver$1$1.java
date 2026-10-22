package com.larus.tts.impl;

import com.larus.audio.audiov3.tts.PlayStateEnum;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$ttsLottieObserver$1$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatTitleTtsComponent$ttsLottieObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayStateEnum $state;
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PlayStateEnum.values().length];
            r0[PlayStateEnum.PLAY_STATE_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PlayStateEnum.PLAY_STATE_PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public ChatTitleTtsComponent$ttsLottieObserver$1$1(PlayStateEnum r1, ChatTitleTtsComponent r2, Continuation<? super ChatTitleTtsComponent$ttsLottieObserver$1$1> r3) {
        this.$state = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTitleTtsComponent$ttsLottieObserver$1$1(this.$state, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r2);
        PlayStateEnum r3 = this.$state;
        if (r3 != null) goto L7;
        int r4 = -1;
    L9:
        if (r4 != 1) goto L11;
        ChatTitleTtsComponent r5 = this.this$0;
        int r0 = ChatTitleTtsComponent.v;
        com.larus.platform.api.g0 r6 = r5.Y2();
        if (r6 == null) goto L22;
        r6.Ua();
    L22:
        return Unit.INSTANCE;
    L11:
        if (r4 != 2) goto L13;
    L15:
        ChatTitleTtsComponent r7 = this.this$0;
        int r1 = ChatTitleTtsComponent.v;
        com.larus.platform.api.g0 r8 = r7.Y2();
        if (r8 == null) goto L22;
        r8.Wa();
        goto L22
    L13:
        if (r4 == 3) goto L15;
    L7:
        r4 = a.a[r3.ordinal()];
        goto L9
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
