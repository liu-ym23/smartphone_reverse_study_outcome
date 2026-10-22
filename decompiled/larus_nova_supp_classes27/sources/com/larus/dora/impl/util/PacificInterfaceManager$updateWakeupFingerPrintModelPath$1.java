package com.larus.dora.impl.util;

import com.enroll.audio.enroll.IVoiceEnrollService;
import com.obric.assistant.spi.dora.ObricDoraDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.util.PacificInterfaceManager$updateWakeupFingerPrintModelPath$1", f = "PacificInterfaceManager.kt", i = {0}, l = {72}, m = "invokeSuspend", n = {"retryCount"}, s = {"I$0"})
public final class PacificInterfaceManager$updateWakeupFingerPrintModelPath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $firstKwsModelPath;
    final /* synthetic */ String $sidEnrollModelPath;
    int I$0;
    int label;

    public PacificInterfaceManager$updateWakeupFingerPrintModelPath$1(String r1, String r2, Continuation<? super PacificInterfaceManager$updateWakeupFingerPrintModelPath$1> r3) {
        this.$firstKwsModelPath = r1;
        this.$sidEnrollModelPath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PacificInterfaceManager$updateWakeupFingerPrintModelPath$1(this.$firstKwsModelPath, this.$sidEnrollModelPath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:13:0x0032). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r10);
        PacificInterfaceManager$updateWakeupFingerPrintModelPath$1 r11 = this;
    L13:
        r2 = r2 + 1;
        DoraResourceUtil r6 = DoraResourceUtil.a;
        String r7 = DoraResourceUtil.g();
        g49.d.d("PacificInterfaceManager", "retry check silentFilePath count=" + r2 + ", path=" + r7);
        if (r7 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == false) goto L21;
    L9:
        if (r2 >= 5) goto L25;
        r11.I$0 = r2;
        r11.label = 1;
        if (DelayKt.delay(5000, r11) != r0) goto L13;
        return r0;
    L25:
        if (r2 < 5) goto L27;
        g49.d.e("PacificInterfaceManager", "silentFilePath still empty after 5 retries");
    L27:
        PacificInterfaceManager.c = null;
        return Unit.INSTANCE;
    L21:
        IVoiceEnrollService.a.getClass();
        IVoiceEnrollService r3 = IVoiceEnrollService.a.a();
        if (r3 == null) goto L24;
        r3.b(r11.$firstKwsModelPath, r11.$sidEnrollModelPath, r7);
    L24:
        ObricDoraDelegate.b.b(r11.$firstKwsModelPath, r11.$sidEnrollModelPath, r7);
        PacificInterfaceManager.d(true);
        goto L25
    L16:
        if (r7.length() == 0) goto L19;
        r8 = false;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r11 = this;
        r2 = 0;
        goto L9
    }
}
