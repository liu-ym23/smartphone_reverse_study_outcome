package com.larus.dora.impl.file;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.dora.impl.util.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraLogFileTransferCoordinator$scheduleIdleResume$1", f = "DoraLogFileTransferCoordinator.kt", i = {1, 2, 2, 3}, l = {234, 434, 242, 247}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "firmwareVersion", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class DoraLogFileTransferCoordinator$scheduleIdleResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sn;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public DoraLogFileTransferCoordinator$scheduleIdleResume$1(String r1, Continuation<? super DoraLogFileTransferCoordinator$scheduleIdleResume$1> r2) {
        this.$sn = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLogFileTransferCoordinator$scheduleIdleResume$1(this.$sn, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L20;
        if (r2 == 3) goto L15;
        if (r2 != 4) goto L14;
        String r0 = (String) this.L$1;
        kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L11
    L54:
        g49.d.d("DoraLogFileTransferCoordinator", "scheduleIdleResume: resume queue after reconcile, sn=" + r0);     // Catch: Throwable -> L11
        DoraFileFetchManager r3 = DoraLogFileTransferCoordinator.k;     // Catch: Throwable -> L11
        r3.getClass();     // Catch: Throwable -> L11
        g49.d.d("DoraFileFetchManager", "resumeQueueAndTasks: enter");     // Catch: Throwable -> L11
        r3.i.setValue(Boolean.FALSE);     // Catch: Throwable -> L11
    L58:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r1.unlock(null);
        return Unit.INSTANCE;
    L11:
        th = th;
        kotlinx.coroutines.sync.a r11 = r1;
    L65:
        r11.unlock(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r5 = (String) this.L$2;
        String r6 = (String) this.L$1;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L18
        String r9 = r5;
        r0 = r6;
        r11 = r7;
    L72:
        b0.a.getClass();     // Catch: Throwable -> L51
        List r10 = b0.d();     // Catch: Throwable -> L51
        if (r10 != null) goto L47;
        r10 = CollectionsKt.emptyList();     // Catch: Throwable -> L51
    L47:
        if ((!r10.isEmpty()) == false) goto L53;
        b0.I(CollectionsKt.emptyList());     // Catch: Throwable -> L51
        DoraLogFileTransferCoordinator r12 = DoraLogFileTransferCoordinator.a;     // Catch: Throwable -> L51
        int[] r13 = CollectionsKt.toIntArray(r10);     // Catch: Throwable -> L51
        this.L$0 = r11;     // Catch: Throwable -> L51
        this.L$1 = r0;     // Catch: Throwable -> L51
        this.L$2 = null;     // Catch: Throwable -> L51
        this.label = 4;     // Catch: Throwable -> L51
        if (r12.e("slardarCMD", r0, r9, r13, this) != r8) goto L53;
        return r8;
    L53:
        r1 = r11;
    L51:
        th = th;
    L18:
        th = th;
    L64:
        r11 = r7;
        goto L65
    L20:
        String r15 = (String) this.L$1;
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r14);
    L71:
    L62:
        th = th;
        r7 = r16;
        goto L64
    L30:
        if (DoraLogFileTransferCoordinator.d == true) goto L32;
    L56:
        g49.d.d("DoraLogFileTransferCoordinator", "scheduleIdleResume: canceled due to state change (busy/disconnected), sn=" + r15);     // Catch: Throwable -> L62
    L57:
        r1 = r16;
        goto L58
    L32:
        if (DoraLogFileTransferCoordinator.e == false) goto L56;
        DoraDevice r17 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L62
        if (r17 == null) goto L57;
        String r18 = r17.softVersion;     // Catch: Throwable -> L62
        if (r18 != null) goto L39;
        r18 = "";
    L39:
        g49.d.d("DoraLogFileTransferCoordinator", "scheduleIdleResume: reconcile local tasks before resume, sn=" + r15);     // Catch: Throwable -> L62
        DoraLogFileTransferCoordinator r20 = DoraLogFileTransferCoordinator.a;     // Catch: Throwable -> L62
        this.L$0 = r16;     // Catch: Throwable -> L62
        this.L$1 = r15;     // Catch: Throwable -> L62
        this.L$2 = r18;     // Catch: Throwable -> L62
        this.label = 3;     // Catch: Throwable -> L62
        if (DoraLogFileTransferCoordinator.b(r20, r15, r18, this) != r8) goto L42;
        return r8;
    L42:
        r9 = r18;
        r0 = r15;
        r11 = r16;
        goto L72
    L21:
        ResultKt.throwOnFailure(r14);
    L25:
        kotlinx.coroutines.sync.a r21 = DoraLogFileTransferCoordinator.c;
        String r110 = this.$sn;
        this.L$0 = r21;
        this.L$1 = r110;
        this.label = 2;
        if (r21.a(null, this) != r8) goto L28;
        return r8;
    L28:
        r16 = r21;
        r15 = r110;
        goto L71
    L22:
        ResultKt.throwOnFailure(r14);
        g49.d.d("DoraLogFileTransferCoordinator", "scheduleIdleResume: delay 30000ms for sn=" + this.$sn);
        this.label = 1;
        if (DelayKt.delay(j0.G2_OTA_DISCONNECT_WATCHDOG_MS, this) != r8) goto L25;
        return r8;
    }
}
