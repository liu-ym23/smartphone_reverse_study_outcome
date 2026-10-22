package com.larus.avlink.plugins;

import com.larus.avlink.api.model.DoraEvent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import java.util.LinkedHashMap;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraTaskPlugin$handleReceiverEvent$3", f = "DoraTaskPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraTaskPlugin$handleReceiverEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.im.service.audio.z0.a $event;
    int label;
    final /* synthetic */ DoraTaskPlugin this$0;

    public DoraTaskPlugin$handleReceiverEvent$3(DoraTaskPlugin r1, com.larus.im.service.audio.z0.a r2, Continuation<? super DoraTaskPlugin$handleReceiverEvent$3> r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraTaskPlugin$handleReceiverEvent$3(this.this$0, this.$event, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L43;
        ResultKt.throwOnFailure(r12);
        Lazy r13 = ia8.m.a;
        ia8.m.b(DoraEvent.VuiAsrEnd);
        Map<Function1<Boolean, Unit>, k4> r14 = x2.a;
        IDoraService r15 = x2.c();
        if (r15 == null) goto L7;
        r15.onAsrEnd();
    L7:
        DoraTaskPlugin r16 = this.this$0;
        pf9.a0 r0 = this.$event;
        int r1 = DoraTaskPlugin.B;
        r16.getClass();
        LinkedHashMap r2 = pf9.i.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r0.a != 0) goto L19;
        Long r3 = r0.b;
        if (r3 == null) goto L19;
        if (r3.longValue() != 0) goto L19;
        if (r0.c == true) goto L19;
        if (r0.e != 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == true) goto L41;
        if (r0.c == false) goto L37;
        if (r0.d == true) goto L37;
        com.larus.avlink.n1.d(r16.f, "handleAsrEndResult notContent");
        ia8.m.b(DoraEvent.ASRNoContent);
        if (com.larus.audio.call.arch.b.a(r16.getContext()).a0() == false) goto L30;
        x2.j("ASR_END", null);
        com.larus.avlink.n1.d(r16.f, "ASR_END in handleAsrEndResult noContent");
        x2.j("TTS_START", null);
        com.larus.avlink.n1.d(r16.f, "TTS_START in handleAsrEndResult noContent");
        x2.j("TTS_END", null);
        com.larus.avlink.n1.d(r16.f, "TTS_END in handleAsrEndResult noContent");
        goto L41
    L30:
        if (v88.a.f(Integer.valueOf(((n4) r16.getContext()).q())) == false) goto L32;
        ((n4) r16.getContext()).d(false, 7, 102);
        goto L41
    L32:
        CoroutineScope r5 = ((n4) r16.getContext()).r();
        if (r5 == null) goto L35;
        BuildersKt.launch$default(r5, Dispatchers.getIO(), null, new DoraTaskPlugin$handleAsrEndResult$1(null), 2, null);
    L35:
        com.larus.avlink.n1.d(r16.f, "RESET in handleAsrEndResult noContent");
        ia8.m.b(DoraEvent.VUIReset);
    L37:
        if (r0.d == false) goto L39;
        x2.j("ASR_START", null);
    L39:
        x2.j("ASR_END", r16.x);
    L41:
        return Unit.INSTANCE;
    L19:
        r4 = false;
        goto L20
    L43:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
