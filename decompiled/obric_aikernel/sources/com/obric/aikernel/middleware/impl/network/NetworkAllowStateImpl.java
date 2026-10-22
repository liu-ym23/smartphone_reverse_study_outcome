package com.obric.aikernel.middleware.impl.network;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.middleware.api.appcontext.receiver.ChargingStateListener;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.network.INetworkAllowState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.p1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkAllowStateImpl implements INetworkAllowState {
    public static final NetworkAllowStateImpl INSTANCE = null;
    private static final String TAG = "NetworkAllowStateImpl";
    private static final Lazy isAllowState$delegate = null;

    /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.network.NetworkAllowStateImpl$init$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.middleware.impl.network.NetworkAllowStateImpl$init$1", f = "NetworkAllowStateImpl.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.network.NetworkAllowStateImpl$init$1$1, reason: invalid class name and collision with other inner class name */
        @DebugMetadata(c = "com.obric.aikernel.middleware.impl.network.NetworkAllowStateImpl$init$1$1", f = "NetworkAllowStateImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01061 extends SuspendLambda implements Function4<Boolean, Boolean, Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            /* synthetic */ boolean Z$1;
            /* synthetic */ boolean Z$2;
            int label;

            C01061(Continuation<? super C01061> r10) {
                super(4, r10);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Boolean r10, Boolean r11, Boolean r12, Continuation<? super Boolean> r13) {
                return invoke(r10.booleanValue(), r11.booleanValue(), r12.booleanValue(), r13);
            }

            public final Object invoke(boolean r10, boolean r11, boolean r12, Continuation<? super Boolean> r13) {
                C01061 r14 = new C01061(r13);
                r14.Z$0 = r10;
                r14.Z$1 = r11;
                r14.Z$2 = r12;
                return r14.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r10);
                boolean r11 = this.Z$0;
                boolean r12 = this.Z$1;
                boolean r13 = this.Z$2;
                AIKLog.INSTANCE.d(NetworkAllowStateImpl.TAG, "isNetWindowAllow = " + r11 + ", isScreenOn = " + r12 + ", isCharging = " + r13);
                if (r12 == true) goto L9;
                if (r13 == true) goto L9;
                boolean r14 = false;
            L11:
                return Boxing.boxBoolean(r14);
            L9:
                r14 = true;
                goto L11
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.network.NetworkAllowStateImpl$init$1$a */
        static final class a<T> implements d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final a<T> f4562c = null;

            static {
                f4562c = new a();
            }

            a() {
            }

            public final Object a(boolean r10, Continuation<? super Unit> r11) {
                NetworkAllowStateImpl.access$isAllowState(NetworkAllowStateImpl.INSTANCE).setValue(Boxing.boxBoolean(r10));
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
            c r13 = e.h(com.obric.aikernel.middleware.api.appcontext.receiver.d.f4534a.c(), com.obric.aikernel.middleware.api.appcontext.receiver.e.f4540a.b(), ChargingStateListener.f4508a.b(), new C01061(null));
            d r14 = a.f4562c;
            this.label = 1;
            if (r13.a(r14, this) != r11) goto L12;
            return r11;
        }
    }

    static {
        INSTANCE = new NetworkAllowStateImpl();
        isAllowState$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    private NetworkAllowStateImpl() {
    }

    public static final /* synthetic */ g1 access$isAllowState(NetworkAllowStateImpl r10) {
        return r10.isAllowState();
    }

    @JvmStatic
    public static final NetworkAllowStateImpl getInst() {
        return INSTANCE;
    }

    private final g1<Boolean> isAllowState() {
        return (g1) isAllowState$delegate.getValue();
    }

    @Override // com.obric.aikernel.middleware.api.network.INetworkAllowState
    public p1<Boolean> getAllowState() {
        return isAllowState();
    }

    @Override // com.obric.aikernel.middleware.api.network.INetworkAllowState
    public void init() {
        AIKLog.INSTANCE.d(TAG, CommonConsts.APM_INNER_EVENT_COST_INIT);
        h.d(m0.a(z0.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.obric.aikernel.middleware.api.network.INetworkAllowState
    public boolean isAllowNetworkRequestNow() {
        return isAllowState().getValue().booleanValue();
    }
}
