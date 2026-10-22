package com.larus.avlink.plugins;

import com.larus.avlink.api.model.DoraEvent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraTaskPlugin$handleReceiverEvent$1", f = "DoraTaskPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraTaskPlugin$handleReceiverEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraTaskPlugin this$0;

    public DoraTaskPlugin$handleReceiverEvent$1(DoraTaskPlugin r1, Continuation<? super DoraTaskPlugin$handleReceiverEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraTaskPlugin$handleReceiverEvent$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        Lazy r3 = ia8.m.a;
        ia8.m.b(DoraEvent.VuiTtsBreak);
        Map<Function1<Boolean, Unit>, k4> r4 = x2.a;
        x2.h("ASR_START");
        com.larus.avlink.n1.d(this.this$0.f, "ASR_START in firstAsrResponse");
        if (Intrinsics.areEqual(((n4) this.this$0.getContext()).params().k.o, "dora_half_duplex") == false) goto L7;
        String r5 = "radio";
    L8:
        Intrinsics.checkNotNullParameter(r5, "audioType");
        IDoraService r0 = x2.c();
        if (r0 == null) goto L12;
        r0.onAsrStart(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        r5 = "TTS";
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
