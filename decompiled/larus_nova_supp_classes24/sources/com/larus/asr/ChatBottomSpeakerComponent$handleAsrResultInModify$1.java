package com.larus.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.ChatBottomSpeakerComponent$handleAsrResultInModify$1", f = "ChatBottomSpeakerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatBottomSpeakerComponent$handleAsrResultInModify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $asrResult;
    final /* synthetic */ ICoreInputAbility $coreInput;
    int label;
    final /* synthetic */ ChatBottomSpeakerComponent this$0;

    public ChatBottomSpeakerComponent$handleAsrResultInModify$1(ICoreInputAbility r1, String r2, ChatBottomSpeakerComponent r3, Continuation<? super ChatBottomSpeakerComponent$handleAsrResultInModify$1> r4) {
        this.$coreInput = r1;
        this.$asrResult = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatBottomSpeakerComponent$handleAsrResultInModify$1(this.$coreInput, this.$asrResult, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        ICoreInputAbility.b.d(this.$coreInput, this.$asrResult, true, false, null, null, false, 56);
        va8.o r11 = ChatBottomSpeakerComponent.C3(this.this$0);
        if (r11 == null) goto L8;
        r11.Vc();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
