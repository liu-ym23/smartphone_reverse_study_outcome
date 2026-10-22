package com.larus.bmhome.chat.component.playback;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.social.page.datasource.event.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.playback.MessagePlaybackHelper$showAllCase$2$1", f = "MessagePlaybackHelper.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_TIMEOUT}, m = "invokeSuspend", n = {}, s = {})
public final class MessagePlaybackHelper$showAllCase$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MessagePlaybackHelper this$0;

    public MessagePlaybackHelper$showAllCase$2$1(MessagePlaybackHelper r1, Continuation<? super MessagePlaybackHelper$showAllCase$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessagePlaybackHelper$showAllCase$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L17:
        MessagePlaybackHelper r6 = this.this$0;
        c r2 = r6.a;
        if (r2 == null) goto L22;
        List r3 = r2.a;
        if (r3 == null) goto L22;
        int r4 = r3.size();
    L23:
        r6.d = r4 + 1;
        return Unit.INSTANCE;
    L22:
        r4 = 0;
        goto L23
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MessagePlaybackHelper r7 = this.this$0;
        Function3 r8 = r7.l;
        if (r8 == null) goto L17;
        c r9 = r7.a;
        if (r9 == null) goto L13;
        Boolean r10 = Boxing.boxBoolean(true);
        this.label = 1;
        if (r8.invoke(r9, r10, this) != r0) goto L17;
        return r0;
    L13:
        return Unit.INSTANCE;
    }
}
