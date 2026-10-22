package com.larus.dora.impl;

import g49.d;
import java.util.Map;
import kj4.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraBuryPointManager$getAntiSoundLeakStateAndReport$1", f = "DoraBuryPointManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraBuryPointManager$getAntiSoundLeakStateAndReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraBuryPointManager$getAntiSoundLeakStateAndReport$1(Continuation<? super DoraBuryPointManager$getAntiSoundLeakStateAndReport$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraBuryPointManager$getAntiSoundLeakStateAndReport$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r8);
        int r9 = a.g().h();
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        if (r9 < 0) goto L7;
        int r3 = 1;
    L8:
        if (r9 != 1) goto L10;
        int r4 = 1;
    L11:
        r0.getClass();
        Map r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("settings_detail", String.valueOf(r4)), TuplesKt.to("is_success", String.valueOf(r3))});
        r0.L("dora_sound_leakage_settings", r1);
        String r2 = DoraBuryPointManager.b;
        d.d(r2, "DoraBuryPointManager.reportAntiSoundLeakStateWhenConnect, " + r1);
        d.d(r2, "DoraBuryPointManager.getAntiSoundLeakStateAndReport, state: " + r9);
        return Unit.INSTANCE;
    L10:
        r4 = 0;
        goto L11
    L7:
        r3 = 0;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
