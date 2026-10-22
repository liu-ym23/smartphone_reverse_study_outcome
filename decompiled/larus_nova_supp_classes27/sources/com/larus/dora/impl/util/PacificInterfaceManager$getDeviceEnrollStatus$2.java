package com.larus.dora.impl.util;

import com.enroll.audio.enroll.IVoiceEnrollService;
import com.larus.dora.impl.DoraPreWakeUpTask;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.util.PacificInterfaceManager$getDeviceEnrollStatus$2", f = "PacificInterfaceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PacificInterfaceManager$getDeviceEnrollStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $deviceName;
    final /* synthetic */ String $mac;
    int label;

    public PacificInterfaceManager$getDeviceEnrollStatus$2(String r1, String r2, Continuation<? super PacificInterfaceManager$getDeviceEnrollStatus$2> r3) {
        this.$mac = r1;
        this.$deviceName = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PacificInterfaceManager$getDeviceEnrollStatus$2(this.$mac, this.$deviceName, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r7);
        Function1<? super Boolean, Unit> r8 = PacificInterfaceManager.a;
        String r9 = PacificInterfaceManager.f(this.$mac);
        if (r9 != null) goto L7;
        r9 = this.$mac;
    L7:
        IVoiceEnrollService r0 = (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class);
        boolean r1 = false;
        if (r0 == null) goto L10;
        boolean r2 = r0.a(r9);
    L11:
        g49.d.d("PacificInterfaceManager", "getDeviceEnrollStatus local:" + r2);
        if (r2 == true) goto L20;
        if (r0 == null) goto L15;
        r1 = r0.query(r9);
    L15:
        g49.d.d("PacificInterfaceManager", "getDeviceEnrollStatus cloud:" + r1);
        if (r1 == false) goto L20;
        if (r0 == null) goto L19;
        r0.g(r9, this.$deviceName);
    L19:
        r2 = true;
    L20:
        if (r2 == false) goto L23;
        int r10 = DoraPreWakeUpTask.d;
        DoraPreWakeUpTask.Companion.m();
    L23:
        return Boxing.boxBoolean(r2);
    L10:
        r2 = false;
        goto L11
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
