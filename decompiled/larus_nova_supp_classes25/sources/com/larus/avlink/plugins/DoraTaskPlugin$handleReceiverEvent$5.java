package com.larus.avlink.plugins;

import com.larus.avlink.api.model.DoraEvent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraTaskPlugin$handleReceiverEvent$5", f = "DoraTaskPlugin.kt", i = {}, l = {756, 761}, m = "invokeSuspend", n = {}, s = {})
final class DoraTaskPlugin$handleReceiverEvent$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraTaskPlugin this$0;

    public DoraTaskPlugin$handleReceiverEvent$5(DoraTaskPlugin r1, Continuation<? super DoraTaskPlugin$handleReceiverEvent$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraTaskPlugin$handleReceiverEvent$5(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L20:
        Lazy r8 = ia8.m.a;
        ia8.m.b(DoraEvent.VuiDataEnd);
        Map<Function1<Boolean, Unit>, k4> r9 = x2.a;
        x2.h("DATA_END");
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L15:
        Lazy r10 = ia8.m.a;
        ia8.m.b(DoraEvent.VuiTtsEnd);
        Map<Function1<Boolean, Unit>, k4> r11 = x2.a;
        x2.j("TTS_END", this.this$0.y);
        if (this.this$0.l3().a0() == true) goto L22;
        this.label = 2;
        if (DelayKt.delay(100, this) != r0) goto L20;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        if ((!this.this$0.j) == false) goto L15;
        Lazy r12 = ia8.m.a;
        ia8.m.b(DoraEvent.VuiTTSStart);
        Map<Function1<Boolean, Unit>, k4> r13 = x2.a;
        x2.j("TTS_START", null);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L15;
        return r0;
    }
}
