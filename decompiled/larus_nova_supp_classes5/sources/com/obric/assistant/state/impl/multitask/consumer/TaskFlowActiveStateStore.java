package com.obric.assistant.state.impl.multitask.consumer;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService;
import com.obric.assistant.util.r;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import jha.o;
import jha.p;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import zga.d;
import zga.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\b\b\u0000\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0005ABCDEB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0019H\u0016J \u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0019H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000fH\u0016J,\u0010$\u001a\u00020\u001f2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030\n2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010'\u001a\u00020\u0019H\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020,H\u0002JP\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00102\n\u0010%\u001a\u0006\u0012\u0002\b\u00030\n2\u0010\u0010/\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\u0010\u00100\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0002J)\u00101\u001a\u0004\u0018\u00010\u00192\u0006\u0010.\u001a\u00020\u00102\u0010\u00102\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0002¢\u0006\u0002\u00103J8\u00104\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00102\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u001d2\u0010\u0010&\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0002J^\u00105\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00106\u001a\u0002072<\b\u0002\u0010\b\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\tj\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b`\rH\u0002J \u00108\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0019H\u0002J\u0010\u0010:\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u0010H\u0002J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0015H\u0002J,\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u001d2\u0014\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0>H\u0002J4\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u001d2\u0014\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0>2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002JZ\u0010@\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\tj\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b`\r2\u0014\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0>2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\b\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\tj\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b`\rX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\tj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore;", "Lcom/obric/assistant/state/api/multitask/IObricTaskFlowActiveStateService;", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateReceiver;", "<init>", "()V", "lock", "", "dispatchLock", "activeStates", "Ljava/util/LinkedHashMap;", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/multitask/core/TaskStateEnvelope;", "Lcom/obric/assistant/state/multitask/core/TaskState;", "Lkotlin/collections/LinkedHashMap;", "observerRegistrations", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateObserver;", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$ObserverRegistration;", "registrationGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "asyncCommands", "Lkotlinx/coroutines/channels/Channel;", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$AsyncCommand;", "asyncScope", "Lkotlinx/coroutines/CoroutineScope;", "isActive", "", "filter", "Lcom/obric/assistant/state/api/multitask/ObricTaskFlowActiveStateFilter;", "getActiveStates", "", "registerObserver", "", "observer", "sticky", "registerSyncObserver", "unregisterObserver", "onStateChanged", "taskFlowId", "changedState", "active", "processAsyncRegistration", "command", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$AsyncCommand$Register;", "processAsyncStateChange", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$AsyncCommand$StateChanged;", "processStateChange", "registration", "previousActiveState", "currentActiveState", "matches", "state", "(Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$ObserverRegistration;Lcom/obric/assistant/state/multitask/core/TaskStateEnvelope;)Ljava/lang/Boolean;", "notifyObserver", "newRegistration", "dispatchMode", "Lcom/obric/assistant/state/impl/multitask/consumer/TaskFlowActiveStateStore$DispatchMode;", "logRegistration", "replaced", "isCurrent", "enqueueAsyncCommand", "immutableSnapshot", "states", "", "filterSnapshot", "filterStateMap", "DispatchMode", "ObserverRegistration", "StateTransition", "AsyncCommand", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskFlowActiveStateStore implements IObricTaskFlowActiveStateService {
    public static final /* synthetic */ int h = 0;
    public final Object a;
    public final Object b;
    public final LinkedHashMap<jha.g<?>, p<? extends o>> c;
    public final LinkedHashMap<e, c> d;
    public final AtomicLong e;
    public final Channel<a> f;
    public final CoroutineScope g;

    /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.consumer.TaskFlowActiveStateStore$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.state.impl.multitask.consumer.TaskFlowActiveStateStore$1", f = "ObricTaskFlowActiveStateServiceImpl.kt", i = {}, l = {BytedCertConstant.H5_COMPRESS_RATE}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ TaskFlowActiveStateStore this$0;

        public AnonymousClass1(TaskFlowActiveStateStore r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0036 -> B:13:0x003b). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ChannelIterator<a> r2 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r14);
            ChannelIterator<a> r3 = r2;
            Object r4 = r0;
            AnonymousClass1 r5 = this;
        L14:
            if (((Boolean) r14).booleanValue() == false) goto L29;
            a.b r15 = (a) r3.next();
            if ((r15 instanceof a.a) == false) goto L18;
            TaskFlowActiveStateStore r6 = r5.this$0;
            int r7 = TaskFlowActiveStateStore.h;
            r6.getClass();
            ((a.a) r15).getClass();
            r6.d(null);
            throw null;
        L18:
            if ((r15 instanceof a.b) == false) goto L25;
            TaskFlowActiveStateStore r8 = r5.this$0;
            a.b r16 = r15;
            int r9 = TaskFlowActiveStateStore.h;
            r8.getClass();
            Iterator r11 = r16.a.iterator();
        L21:
            if (r11.hasNext() == false) goto L23;
            r8.g((c) r11.next(), r16.b, r16.c, r16.d, r16.e);
            goto L21
        L23:
            AnonymousClass1 r17 = r5;
            r0 = r4;
            ChannelIterator<a> r10 = r3;
        L9:
            r17.L$0 = r10;
            r17.label = 1;
            Object r12 = r10.hasNext(r17);
            if (r12 != r0) goto L12;
            return r0;
        L12:
            Object r13 = r0;
            r5 = r17;
            r14 = r12;
            r3 = r10;
            r4 = r13;
            goto L14
        L25:
            throw new NoWhenBranchMatchedException();
        L29:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            r10 = this.this$0.f.iterator();
            r17 = this;
            goto L9
        }
    }

    static {
    }

    public TaskFlowActiveStateStore() {
        this.a = new Object();
        this.b = new Object();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new AtomicLong(0);
        this.f = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.g = r3;
        BuildersKt.launch$default(r3, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void a(e r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        Object r0 = this.a;
        monitor-enter(r0);
        c r1 = this.d.remove(r4);     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r1 == null) goto L14;
        FLogger.a.i("ObricTaskFlowActiveState", "observer_unregistered observer=".concat(r4.getClass().getName()));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final boolean b(r r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        Object r0 = this.a;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(this.c.values());     // Catch: Throwable -> L19
        monitor-exit(r0);
        List r2 = r1;
        if ((r2 instanceof Collection) == true) goto L9;
    L11:
        Iterator r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        if (r3.a((p) r4.next()) == false) goto L13;
        return true;
    L17:
        return false;
    L9:
        if (r2.isEmpty() == false) goto L11;
    L19:
        th = move-exception;
        throw th;
    }

    public final boolean d(c r8) {
        Object r0 = this.a;
        monitor-enter(r0);
        c r1 = this.d.get(r8.a);     // Catch: Throwable -> L12
        boolean r2 = false;
        if (r1 == null) goto L10;
        if (r1.d != r8.d) goto L10;
        r2 = true;
    L10:
        monitor-exit(r0);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    public static Boolean e(c r2, p r3) {
        if (r3 != null) goto L12;
    L6:
        boolean r4 = false;
    L7:
        return Boolean.valueOf(r4);
    L9:
        th = move-exception;
        FLogger.a.e("ObricTaskFlowActiveState", "apply observer filter failed", th);
        return null;
    L12:
        boolean r5 = r2.b.a(r3);     // Catch: Throwable -> L9
        r4 = true;
        if (r5 != true) goto L6;
        goto L6
    }

    public final void c(e r13, d r14) {
        Intrinsics.checkNotNullParameter(r13, "observer");
        Intrinsics.checkNotNullParameter(r14, "filter");
        Object r0 = this.b;
        monitor-enter(r0);
        Object r1 = this.a;     // Catch: Throwable -> L40
        monitor-enter(r1);     // Catch: Throwable -> L40
        List r2 = CollectionsKt.toList(this.c.values());     // Catch: Throwable -> L37
        monitor-exit(r1);     // Catch: Throwable -> L40
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L33
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L33
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();     // Catch: Throwable -> L33
        if (r14.a((p) r5) == false) goto L10;
        r3.add(r5);     // Catch: Throwable -> L33
        goto L10
    L14:
        LinkedHashMap r8 = new LinkedHashMap();     // Catch: Throwable -> L33
        Iterator r6 = r3.iterator();     // Catch: Throwable -> L33
    L15:
        if (r6.hasNext() == false) goto L19;
        Object r7 = r6.next();     // Catch: Throwable -> L33
        r8.put(((p) r7).a, r7);     // Catch: Throwable -> L33
        goto L15
    L19:
        Object r9 = this.a;     // Catch: Throwable -> L40
        monitor-enter(r9);     // Catch: Throwable -> L40
        boolean r10 = this.d.containsKey(r13);     // Catch: Throwable -> L30
        c r11 = new c(r13, r14, DispatchMode.SYNC, this.e.incrementAndGet(), r8);     // Catch: Throwable -> L30
        this.d.put(r13, r11);     // Catch: Throwable -> L30
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r9);     // Catch: Throwable -> L40
        FLogger r16 = FLogger.a;     // Catch: Throwable -> L40
        StringBuilder r17 = new StringBuilder("observer_");     // Catch: Throwable -> L40
        if (r10 == false) goto L26;
        String r12 = "replaced";
    L27:
        r17.append(r12);     // Catch: Throwable -> L40
        r17.append(" observer=");     // Catch: Throwable -> L40
        r17.append(r11.a.getClass().getName());     // Catch: Throwable -> L40
        r17.append(",mode=");     // Catch: Throwable -> L40
        r17.append(r11.c);     // Catch: Throwable -> L40
        r17.append(",sticky=true,filteredCount=");     // Catch: Throwable -> L40
        r17.append(r11.e.size());     // Catch: Throwable -> L40
        r16.i("ObricTaskFlowActiveState", r17.toString());     // Catch: Throwable -> L40
        f(r11, Collections.unmodifiableList(new ArrayList(r8.values())), null);     // Catch: Throwable -> L40
        monitor-exit(r0);
        return;
    L26:
        r12 = "registered";
        goto L27
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L33:
        th = move-exception;
        FLogger.a.e("ObricTaskFlowActiveState", "apply observer initial filter failed", th);     // Catch: Throwable -> L40
        return;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }

    public final void f(c r7, List<? extends p<? extends o>> r8, p<? extends o> r9) {
        if (d(r7) == true) goto L5;
        return;
    L5:
        long r2 = SystemClock.elapsedRealtime();
        r7.a.a(r8, r9);     // Catch: Throwable -> L17
        FLogger r4 = FLogger.a;     // Catch: Throwable -> L17
        StringBuilder r5 = new StringBuilder("observer_notified observer=");     // Catch: Throwable -> L17
        r5.append(r7.a.getClass().getName());     // Catch: Throwable -> L17
        r5.append(",mode=");     // Catch: Throwable -> L17
        r5.append(r7.c);     // Catch: Throwable -> L17
        r5.append(",taskFlowId=");     // Catch: Throwable -> L17
        String r10 = null;
        if (r9 == null) goto L9;
        jha.g r1 = r9.a;     // Catch: Throwable -> L17
    L10:
        r5.append(r1);     // Catch: Throwable -> L17
        r5.append(",state=");     // Catch: Throwable -> L17
        if (r9 == null) goto L15;
        o r11 = r9.b;     // Catch: Throwable -> L17
        if (r11 == null) goto L15;
        r10 = r11.getClass().getSimpleName();     // Catch: Throwable -> L17
    L15:
        r5.append(r10);     // Catch: Throwable -> L17
        r5.append(",filteredCount=");     // Catch: Throwable -> L17
        r5.append(r8.size());     // Catch: Throwable -> L17
        r5.append(",callbackCostMs=");     // Catch: Throwable -> L17
        r5.append(SystemClock.elapsedRealtime() - r2);     // Catch: Throwable -> L17
        r4.i("ObricTaskFlowActiveState", r5.toString());     // Catch: Throwable -> L17
        return;
    L9:
        r1 = null;
    L17:
        th = move-exception;
        FLogger.a.e("ObricTaskFlowActiveState", "notify observer failed", th);
    }

    public final void g(c r2, jha.g<?> r3, p<? extends o> r4, p<? extends o> r5, p<? extends o> r6) {
        if (d(r2) == true) goto L5;
        return;
    L5:
        Boolean r7 = e(r2, r4);
        if (r7 == null) goto L23;
        boolean r8 = r7.booleanValue();
        Boolean r0 = e(r2, r5);
        if (r0 == null) goto L24;
        boolean r1 = r0.booleanValue();
        if (r8 == true) goto L13;
        if (r1 == true) goto L13;
        return;
    L13:
        p r9 = (p) r2.e.get(r3);
        if (r1 == false) goto L17;
        if (r5 == null) goto L17;
        r2.e.put(r3, r5);
    L19:
        if (Intrinsics.areEqual(r9, r2.e.get(r3)) == false) goto L21;
        return;
    L21:
        f(r2, Collections.unmodifiableList(new ArrayList(r2.e.values())), r6);
        return;
    L17:
        r2.e.remove(r3);
        goto L19
    L24:
        return;
    }
}
