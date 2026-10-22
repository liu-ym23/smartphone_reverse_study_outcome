package com.larus.dora.impl.nl;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
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
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$updateProactiveFreq$1", f = "DoraUserSettingsManager.kt", i = {0, 0, 1, 2}, l = {322, 323, 326}, m = "invokeSuspend", n = {"originSettings", "updatedSettings", "originSettings", "originSettings"}, s = {"L$0", "L$1", "L$0", "L$0"})
final class DoraUserSettingsManager$updateProactiveFreq$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $freq;
    Object L$0;
    Object L$1;
    int label;

    public DoraUserSettingsManager$updateProactiveFreq$1(int r1, Continuation<? super DoraUserSettingsManager$updateProactiveFreq$1> r2) {
        this.$freq = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraUserSettingsManager$updateProactiveFreq$1(this.$freq, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        com.larus.dora.impl.network.f0 r2 = (com.larus.dora.impl.network.f0) this.L$0;
        ResultKt.throwOnFailure(r15);
    L37:
        DoraUserSettingsManager.c = r2;
        com.larus.dora.impl.util.x.a.getClass();
        com.larus.dora.impl.util.x.b(r2);
    L39:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        com.larus.dora.impl.network.f0 r3 = (com.larus.dora.impl.network.f0) this.L$0;
        ResultKt.throwOnFailure(r15);
    L25:
        if (((Boolean) r15).booleanValue() == false) goto L27;
        DoraUserSettingsManager.b();
        goto L39
    L27:
        StateFlowImpl r16 = DoraUserSettingsManager.r;
        com.larus.dora.impl.network.g0 r4 = r3.d();
        if (r4 == null) goto L32;
        String r5 = r4.h();
        if (r5 == null) goto L32;
        int r6 = CastIntegerProtector.parseInt(r5);
    L33:
        Integer r7 = Boxing.boxInt(r6);
        this.L$0 = r3;
        this.label = 3;
        r16.setValue(r7);
        if (Unit.INSTANCE != r0) goto L36;
        return r0;
    L36:
        r2 = r3;
    L32:
        r6 = 3;
        goto L33
    L11:
        com.larus.dora.impl.network.f0 r8 = (com.larus.dora.impl.network.f0) this.L$1;
        com.larus.dora.impl.network.f0 r9 = (com.larus.dora.impl.network.f0) this.L$0;
        ResultKt.throwOnFailure(r15);
    L20:
        DoraUserSettingsManager r17 = DoraUserSettingsManager.a;
        this.L$0 = r9;
        this.L$1 = null;
        this.label = 2;
        r15 = DoraUserSettingsManager.d(r17, r8, this);
        if (r15 != r0) goto L23;
        return r0;
    L23:
        r3 = r9;
        goto L25
    L12:
        ResultKt.throwOnFailure(r15);
        com.larus.dora.impl.network.f0 r18 = com.larus.dora.impl.network.f0.a(DoraUserSettingsManager.c, null, null, 31);
        com.larus.dora.impl.network.f0 r10 = DoraUserSettingsManager.c;
        com.larus.dora.impl.network.g0 r11 = r10.d();
        if (r11 == null) goto L15;
        com.larus.dora.impl.network.g0 r12 = com.larus.dora.impl.network.g0.a(r11, null, null, null, null, null, String.valueOf(this.$freq), 1983);
    L16:
        r8 = com.larus.dora.impl.network.f0.a(r10, null, r12, 15);
        StateFlowImpl r13 = DoraUserSettingsManager.r;
        Integer r14 = Boxing.boxInt(this.$freq);
        this.L$0 = r18;
        this.L$1 = r8;
        this.label = 1;
        r13.setValue(r14);
        if (Unit.INSTANCE != r0) goto L19;
        return r0;
    L19:
        r9 = r18;
        goto L20
    L15:
        r12 = null;
        goto L16
    }
}
