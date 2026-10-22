package com.obric.assistant.zeus.plugin;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ZeusAutoFetchConfig;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "com.obric.assistant.zeus.plugin.ZeusSubProcessMainProcessWakeupManager$checkRunnable$1$1", f = "ZeusSubProcessMainProcessWakeupManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ZeusSubProcessMainProcessWakeupManager$checkRunnable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ZeusSubProcessMainProcessWakeupManager$checkRunnable$1$1(Continuation<? super ZeusSubProcessMainProcessWakeupManager$checkRunnable$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new ZeusSubProcessMainProcessWakeupManager$checkRunnable$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r18);
        ZeusSubProcessMainProcessWakeupManager r1 = ZeusSubProcessMainProcessWakeupManager.a;
        if (ZeusSubProcessMainProcessWakeupManager.f == true) goto L7;
        r1.getClass();
    L35:
        return Unit.INSTANCE;
    L7:
        r1.getClass();
        ZeusAutoFetchConfig r2 = ZeusSubProcessMainProcessWakeupManager.b();
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L16;
        FLogger.a.i("ZeusSubProcessMainProcessWakeupManager", "skip wake main process: feature switch disabled or unavailable");
        boolean r4 = false;
    L17:
        if (r4 == false) goto L35;
        ZeusSubProcessMainProcessWakeupManager.a r5 = ZeusSubProcessMainProcessWakeupManager.d();
        if (ZeusSubProcessMainProcessWakeupManager.e(r5) != null) goto L22;
    L25:
        long r7 = System.currentTimeMillis();
        Lazy r6 = e.a;
        long r8 = ((Keva) r6.getValue()).getLong("last_success_request_time_millis", 0);
        if (ZeusSubProcessMainProcessWakeupManager.f(r8, r7, r5.a) == true) goto L29;
        long r9 = ZeusSubProcessMainProcessWakeupManager.c(r8, r7, r5.a, r5);
    L33:
        long r10 = RangesKt.coerceIn(r9, r5.c, r5.d);
        ZeusSubProcessMainProcessWakeupManager.b.post(new s(r10));
        FLogger.a.i("ZeusSubProcessMainProcessWakeupManager", "schedule next check after " + r10 + " ms");
        goto L35
    L29:
        long r11 = ((Keva) r6.getValue()).getLong("last_wake_main_process_time_millis", 0);
        if (ZeusSubProcessMainProcessWakeupManager.f(r11, r7, r5.b) == true) goto L32;
        r9 = ZeusSubProcessMainProcessWakeupManager.c(r11, r7, r5.b, r5);
        goto L33
    L32:
        r9 = r5.b;
        goto L33
    L22:
        if (ZeusSubProcessMainProcessWakeupManager.d.compareAndSet(false, true) == true) goto L24;
        FLogger.a.i("ZeusSubProcessMainProcessWakeupManager", "skip request main process fetch: request in flight");
        goto L25
    L24:
        BuildersKt.launch$default(ZeusSubProcessMainProcessWakeupManager.c, null, null, new ZeusSubProcessMainProcessWakeupManager.requestMainProcessFetchAsync.1(null), 3, null);
        goto L25
    L16:
        r4 = true;
        goto L17
    L10:
        if (r2.getEnableSubProcessWakeMain() != true) goto L12;
        r3 = true;
        goto L14
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
