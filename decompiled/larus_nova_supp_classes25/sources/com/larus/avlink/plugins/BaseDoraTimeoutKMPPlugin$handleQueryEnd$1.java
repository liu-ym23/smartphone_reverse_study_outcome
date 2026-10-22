package com.larus.avlink.plugins;

import com.larus.avlink.model.TimerScene;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import java.util.Map;
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
@DebugMetadata(c = "com.larus.avlink.plugins.BaseDoraTimeoutKMPPlugin$handleQueryEnd$1", f = "BaseDoraTimeoutKMPPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseDoraTimeoutKMPPlugin$handleQueryEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ e this$0;

    public BaseDoraTimeoutKMPPlugin$handleQueryEnd$1(e r1, Continuation<? super BaseDoraTimeoutKMPPlugin$handleQueryEnd$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BaseDoraTimeoutKMPPlugin$handleQueryEnd$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r5);
        e r6 = this.this$0;
        TimerScene r0 = TimerScene.QueryEnd;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "scene");
        boolean r1 = false;
        if (Intrinsics.areEqual(((n4) r6.getContext()).params().k.o, "dora_si") == true) goto L18;
        Map<Function1<Boolean, Unit>, k4> r7 = x2.a;
        IDoraService r8 = x2.c();
        if (r8 == null) goto L14;
        DeviceService r9 = r8.device();
        if (r9 == null) goto L14;
        if (r9.M() != true) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == true) goto L18;
        r1 = true;
    L14:
        r10 = false;
    L18:
        com.larus.avlink.n1.d("DoraTimeoutKMPPlugin", "change mic ,scene: " + r0 + ", needSound: " + r1);
        if (r1 == false) goto L26;
        Map<Function1<Boolean, Unit>, k4> r11 = x2.a;
        IDoraService r12 = x2.c();
        if (r12 == null) goto L26;
        com.larus.dora.impl.serviceimpl.f r13 = r12.M0();
        if (r13 == null) goto L26;
        r13.b(1);
    L26:
        return Unit.INSTANCE;
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
