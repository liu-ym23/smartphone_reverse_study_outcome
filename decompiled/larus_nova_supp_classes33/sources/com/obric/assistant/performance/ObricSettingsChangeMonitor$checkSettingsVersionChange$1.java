package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricSettingsChangeMonitor$checkSettingsVersionChange$1", f = "ObricSettingsChangeMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricSettingsChangeMonitor$checkSettingsVersionChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricSettingsChangeMonitor$checkSettingsVersionChange$1(Continuation<? super ObricSettingsChangeMonitor$checkSettingsVersionChange$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ObricSettingsChangeMonitor$checkSettingsVersionChange$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r10);
    L16:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "checkSettingsVersionChange err: ", e);
    L19:
        return Unit.INSTANCE;
    L6:
        if (c.b() == false) goto L9;
        FLogger.a.i("ObricPerformanceMonitor", "assistant active, skip light doze settings check.");     // Catch: Exception -> L16
        return Unit.INSTANCE;
    L9:
        t1 r11 = t1.a;     // Catch: Exception -> L16
        int r2 = r11.getObricSettingsConfig().getObricSettingsVersion();     // Catch: Exception -> L16
        FLogger r3 = FLogger.a;     // Catch: Exception -> L16
        r3.i("ObricPerformanceMonitor", "checkSettingsVersionChange: cloudVersion=" + r2 + ", settingsVersion=" + ObricSettingsChangeMonitor.f);     // Catch: Exception -> L16
        int r1 = ObricSettingsChangeMonitor.f;     // Catch: Exception -> L16
        if (r2 <= r1) goto L19;
        Lazy r4 = ObricSettingsChangeMonitor.a;     // Catch: Exception -> L16
        r11.z1(r2);     // Catch: Exception -> L16
        ObricSettingsChangeMonitor.f = r2;     // Catch: Exception -> L16
        if (ObricSettingsChangeMonitor.b == true) goto L14;
        r3.i("ObricPerformanceMonitor", "doSettingsChangeKill: not enabled");     // Catch: Exception -> L16
    L14:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricSettingsChangeMonitor$doSettingsChangeKill$1(r1, r2, null), 3, null);     // Catch: Exception -> L16
        goto L19
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
