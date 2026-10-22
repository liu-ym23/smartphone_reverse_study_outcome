package com.larus.bmhome.chat.component.playback;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.d;
import com.larus.im.internal.stream.StreamChannel;
import com.larus.im.internal.stream.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$cancelPlayback$3$1", f = "MessagePlaybackHelper.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
public final class MessagePlaybackHelper$cancelPlayback$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MessagePlaybackHelper this$0;

    public MessagePlaybackHelper$cancelPlayback$3$1(MessagePlaybackHelper r1, Continuation<? super MessagePlaybackHelper$cancelPlayback$3$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessagePlaybackHelper$cancelPlayback$3$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        MessagePlaybackHelper r5 = this.this$0;
        r5.g = true;
        Message r6 = r5.e;
        if (r6 == null) goto L17;
        int r2 = d.a;
        b r3 = b.a;
        this.label = 1;
        StreamChannel.a.getClass();
        Object r7 = StreamChannel.a(r6, false, false, this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        r7 = Unit.INSTANCE;
    L14:
        if (r7 != r0) goto L19;
        return r0;
    L17:
        return null;
    }
}
