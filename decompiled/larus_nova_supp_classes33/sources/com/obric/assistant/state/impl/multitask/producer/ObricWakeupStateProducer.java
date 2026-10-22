package com.obric.assistant.state.impl.multitask.producer;

import aha.v;
import aha.w;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.state.api.multitask.producer.IObricWakeupStateProducerService;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import jha.f;
import jha.g;
import jha.j;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J2\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014H\u0016J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\"\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/ObricWakeupStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowStateProducer;", "Lcom/obric/assistant/state/api/multitask/producer/IObricWakeupStateProducerService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "wakeupTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/state/impl/multitask/producer/ObricWakeupStateProducer$WakeupTask;", "wakeupTasksLock", "", "dispatchPolicy", "Lcom/obric/assistant/state/multitask/core/TaskFlowDispatchPolicy;", "dispatchWakeupStart", "", "wakeupId", "wakeupSource", "ext", "", "registerWakeupTask", "handle", "Lcom/obric/assistant/state/multitask/core/TaskHandle;", "Lcom/obric/assistant/state/api/multitask/state/ObricWakeupState;", "dispatchWakeupEnd", "task", "buildWakeupId", "Companion", "WakeupTask", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupStateProducer implements j, IObricWakeupStateProducerService {
    public final CoroutineScope a;
    public final ConcurrentHashMap<String, b> b;
    public final Object c;

    public static final class a {
    }

    public static final class b {
        public final jha.l<v> a;
        public final AtomicReference<Job> b;

        public b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "WakeupTask(handle=" + this.a + ", timeoutJob=" + this.b + ')';
        }

        public b(jha.l r3) {
            AtomicReference<Job> r0 = new AtomicReference(null);
            Intrinsics.checkNotNullParameter(r3, "handle");
            Intrinsics.checkNotNullParameter(r0, "timeoutJob");
            this.a = r3;
            this.b = r0;
        }
    }

    static {
    }

    public ObricWakeupStateProducer() {
        ExecutorCoroutineDispatcher r0 = f.a;
        this.a = f.b;
        this.b = new ConcurrentHashMap();
        this.c = new Object();
    }

    @Override // com.obric.assistant.state.api.multitask.producer.IObricWakeupStateProducerService
    public final void a(String r16, String r17, Map<String, ? extends Object> r18) {
        String r1 = r16;
        Map r3 = null;
        boolean r4 = false;
        if (com.obric.assistant.state.impl.v2.utils.f.a == true) goto L33;
    L15:
        if (r1 != null) goto L17;
    L27:
        String r5 = "wakeup-" + SystemClock.elapsedRealtime();
    L28:
        FLogger.a.i("ObricWakeupStateProducer", "dispatchWakeupStart, wakeupId=" + r5 + ", wakeupSource=" + r17);
        Intrinsics.checkNotNullParameter(r5, "wakeupId");
        w r0 = w.a;
        int r2 = com.obric.assistant.state.multitask.ext.f.a;
        g r6 = TaskFlowDslKt.b(r0, r5);
        if (r18 == null) goto L31;
        r3 = MapsKt.toMap(r18);
    L31:
        BuildersKt.launch$default(this.a, null, CoroutineStart.UNDISPATCHED, new ObricWakeupStateProducer$dispatchWakeupStart$3(r6, new v.b(r5, r17, r3), this, r5, r17, null), 1, null);
        return;
    L17:
        if ((!StringsKt.isBlank(r16)) == true) goto L19;
    L21:
        if (r4 == true) goto L24;
        r1 = null;
    L24:
        if (r1 == null) goto L27;
        r5 = r1;
        goto L28
    L19:
        if (Intrinsics.areEqual(r1, "-1") == true) goto L21;
        r4 = true;
        goto L21
    L33:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
        hm9.j r8 = hm9.j.a;     // Catch: Throwable -> L10
        hm9.j.h.d(false);     // Catch: Throwable -> L10
        r8.d();     // Catch: Throwable -> L10
        IObricNetworkService r9 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: Throwable -> L10
        if (r9 == null) goto L7;
        r9.f(false);     // Catch: Throwable -> L10
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L10
    L12:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L15;
        FLogger.a.e("ObricWakeupStateProducer", "dispatchWakeupStart, early unblock failed", r12);
        goto L15
    L7:
        r10 = null;
    L10:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
