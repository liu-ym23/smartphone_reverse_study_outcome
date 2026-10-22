package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ObricMainProcessStateManager {
    public static final ObricMainProcessStateManager a = null;
    public static final ReentrantLock b = null;
    public static final StateFlowImpl c = null;
    public static final CoroutineScope d = null;
    public static final b1 e = null;
    public static a f;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.manager.ObricMainProcessStateManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.assistant.activation.presentation.runtime.manager.ObricMainProcessStateManager$1", f = "ObricMainProcessStateManager.kt", i = {}, l = {ITaskManager.Stub.TRANSACTION_scheduleShortcutTask}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.manager.ObricMainProcessStateManager$1$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r3, Continuation r4) {
                boolean r5 = ((Boolean) r3).booleanValue();
                FLogger.a.i("ObricMainProcessStateManager", "main_process_ready_state_changed: ready=" + r5);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            b1 r5 = ObricMainProcessStateManager.e;
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r5.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
        public final IBinder a;
        public final long b;
        public final IBinder.DeathRecipient c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ReadyRegistration(binder=" + this.a + ", generation=" + this.b + ", deathRecipient=" + this.c + ')';
        }

        public a(IBinder r2, long r3, v1 r5) {
            Intrinsics.checkNotNullParameter(r2, "binder");
            Intrinsics.checkNotNullParameter(r5, "deathRecipient");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public ObricMainProcessStateManager() {
    }

    static {
        a = new ObricMainProcessStateManager();
        b = new ReentrantLock();
        StateFlowImpl r0 = j1.a(Boolean.FALSE);
        c = r0;
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        d = r3;
        e = e.b(r0);
        BuildersKt.launch$default(r3, null, null, new AnonymousClass1(null), 3, null);
    }

    public static void b(a r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Boolean.valueOf(r5.a.unlinkToDeath(r5.c, 0)));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L12;
        FLogger.a.w("ObricMainProcessStateManager", "ready_binder_unlink_failed: generation=" + r5.b + " binderAlive=" + r5.a.isBinderAlive() + " message=" + r2.getMessage(), r2);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static void a(a r6, String r7) {
        ReentrantLock r0 = b;
        r0.lock();
    L14:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (f != r6) goto L7;
        f = null;     // Catch: Throwable -> L14
        c.setValue(Boolean.FALSE);     // Catch: Throwable -> L14
        boolean r1 = true;
    L8:
        r0.unlock();
        if (r1 == true) goto L12;
        FLogger.a.i("ObricMainProcessStateManager", "ready_clear_ignored: generation=" + r6.b + " reason=" + r7);
        return;
    L12:
        b(r6);
        FLogger.a.i("ObricMainProcessStateManager", "main_process_not_ready: generation=" + r6.b + " reason=" + r7);
        return;
    L7:
        r1 = false;
        goto L8
    }
}
