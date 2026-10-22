package com.obric.aikernel.middleware.impl.ttnet;

import com.bytedance.ttnet.TTNetInit;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.ChargingStateListener;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class TTNetConnectionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TTNetConnectionManager f4615a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f4616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f4617c;

    /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.ttnet.TTNetConnectionManager$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.middleware.impl.ttnet.TTNetConnectionManager$1", f = "TTNetConnectionManager.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.ttnet.TTNetConnectionManager$1$1, reason: invalid class name and collision with other inner class name */
        @DebugMetadata(c = "com.obric.aikernel.middleware.impl.ttnet.TTNetConnectionManager$1$1", f = "TTNetConnectionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01071 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            /* synthetic */ boolean Z$1;
            int label;

            C01071(Continuation<? super C01071> r10) {
                super(3, r10);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Boolean r10, Boolean r11, Continuation<? super Boolean> r12) {
                return invoke(r10.booleanValue(), r11.booleanValue(), r12);
            }

            public final Object invoke(boolean r10, boolean r11, Continuation<? super Boolean> r12) {
                C01071 r13 = new C01071(r12);
                r13.Z$0 = r10;
                r13.Z$1 = r11;
                return r13.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L12;
                ResultKt.throwOnFailure(r10);
                boolean r11 = this.Z$0;
                boolean r12 = this.Z$1;
                if (r11 == true) goto L8;
                if (r12 == true) goto L8;
                boolean r13 = true;
            L10:
                return Boxing.boxBoolean(r13);
            L8:
                r13 = false;
                goto L10
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.ttnet.TTNetConnectionManager$1$a */
        static final class a<T> implements kotlinx.coroutines.flow.d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final a<T> f4618c = null;

            static {
                f4618c = new a();
            }

            a() {
            }

            public final Object a(boolean r10, Continuation<? super Unit> r11) {
                if (r10 == false) goto L5;
                TTNetConnectionManager.f4615a.a();
            L5:
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.d
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a(((Boolean) r10).booleanValue(), r11);
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.flow.c r13 = e.w(com.obric.aikernel.middleware.api.appcontext.receiver.e.f4540a.b(), ChargingStateListener.f4508a.b(), new C01071(null));
            kotlinx.coroutines.flow.d r14 = a.f4618c;
            this.label = 1;
            if (r13.a(r14, this) != r11) goto L12;
            return r11;
        }
    }

    static {
        f4615a = new TTNetConnectionManager();
        h.d(m0.a(z0.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    private TTNetConnectionManager() {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (f4617c == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (com.obric.aikernel.middleware.api.appcontext.receiver.e.f4540a.d() == true) goto L13;
        if (ChargingStateListener.f4508a.e() == true) goto L13;
        if (f4616b > 0) goto L12;
        AIKLog.INSTANCE.i("TTNetConnectionManager", "close: set runInBackGround");     // Catch: Throwable -> L15
        f4617c = true;     // Catch: Throwable -> L15
        TTNetInit.runInBackGround(AppContext.INSTANCE.getContext(), true);     // Catch: Throwable -> L15
        goto L13
    L12:
        AIKLog.INSTANCE.i("TTNetConnectionManager", "close: have active call " + f4616b);     // Catch: Throwable -> L15
        goto L13
    }

    public final synchronized void b() {
        monitor-enter(this);
        f4616b--;     // Catch: Throwable -> L6
        a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        f4616b++;     // Catch: Throwable -> L6
        d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (f4617c == false) goto L6;
        AIKLog.INSTANCE.i("TTNetConnectionManager", "resume: cancel runInBackGround");     // Catch: Throwable -> L8
        TTNetInit.runInBackGround(AppContext.INSTANCE.getContext(), false);     // Catch: Throwable -> L8
        f4617c = false;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
