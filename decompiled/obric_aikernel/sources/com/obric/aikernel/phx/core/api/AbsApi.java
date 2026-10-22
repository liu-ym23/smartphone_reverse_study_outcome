package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsApi implements IBaseModel {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b extends com.obric.aikernel.b.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n<Bundle> f4753c;

        /* JADX WARN: Multi-variable type inference failed */
        b(n<? super Bundle> r10) {
            this.f4753c = r10;
        }

        @Override // com.obric.aikernel.b
        public void j2(Bundle r10) {
            if (r10 == null) goto L4;
            e8.a.t(r10);
        L4:
            if (r10 == null) goto L6;
            n<Bundle> r11 = this.f4753c;
        L7:
            com.obric.aikernel.sdk.a.a(r11, r10);
            return;
        L6:
            AIKLog.INSTANCE.v("AbsApi", "callModelAsResponse bundle is null");
            r11 = this.f4753c;
            r10 = e8.a.B(new Bundle(), 108, "bundle is null", false, 4, null);
            goto L7
        }
    }

    public static final class c extends com.obric.aikernel.b.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<Bundle> f4754c;

        /* JADX WARN: Multi-variable type inference failed */
        c(l<? super Bundle> r10) {
            this.f4754c = r10;
        }

        @Override // com.obric.aikernel.b
        public void j2(Bundle r10) {
            if (r10 == null) goto L4;
            e8.a.t(r10);
        L4:
            if (r10 == null) goto L6;
            e8.a.I(r10);
        L6:
            if (r10 != null) goto L8;
            return;
        L8:
            if (e8.a.o(r10) == false) goto L11;
            long r11 = e8.a.l(r10);
            AIKLog.INSTANCE.i("AbsApi", "flow task id=" + r11);
            return;
        L11:
            this.f4754c.E(r10);
            if (e8.a.m(r10) == false) goto L16;
            AIKLog.INSTANCE.i("AbsApi", "finish callModelAsFlow, task: server finished.");
            kotlinx.coroutines.channels.n.a.a(this.f4754c, null, 1, null);
            return;
        }
    }

    public static final class d extends com.obric.aikernel.b.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4755c;

        d(String r10) {
            this.f4755c = r10;
        }

        @Override // com.obric.aikernel.b
        public void j2(Bundle r10) {
            AIKLog r11 = AIKLog.INSTANCE;
            StringBuilder r12 = new StringBuilder();
            r12.append("finish unload ");
            r12.append(this.f4755c);
            r12.append(" is ");
            if (r10 == null) goto L5;
            Boolean r13 = Boolean.valueOf(e8.a.n(r10));
        L6:
            r12.append(r13);
            r11.i("AbsApi", r12.toString());
            return;
        L5:
            r13 = null;
            goto L6
        }
    }

    static {
        new a(null);
    }

    public AbsApi() {
    }

    public static final /* synthetic */ boolean a(AbsApi r10, com.obric.aikernel.a r11, Bundle r12, l r13) {
        return r10.i(r11, r12, r13);
    }

    private final boolean i(com.obric.aikernel.a r10, Bundle r11, l<? super Bundle> r12) {
        AIKLog.INSTANCE.i("AbsApi", "start callModelAsFlow " + r11.getString(IdlKeys.MethodName));
        r10.A1(r11, new c(r12));     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        r12.E(e8.a.y(new Bundle(), 102, th.getMessage()));
        kotlinx.coroutines.channels.n.a.a(r12, null, 1, null);
        return false;
    }

    public final kotlinx.coroutines.flow.c<Bundle> c(com.obric.aikernel.a r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "binder");
        Intrinsics.checkNotNullParameter(r11, "args");
        return e.d(new AbsApi$callModelAsFlow$1(r10, this, r11, null));
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
        IBaseModel.a.a(this);
    }

    public final <T> Object f(com.obric.aikernel.a r10, Bundle r11, Function1<? super Bundle, ? extends T> r12, Continuation<? super T> r13) {
        if ((r13 instanceof AbsApi$callModelAsResponse$1) == false) goto L7;
        AbsApi$callModelAsResponse$1 r14 = (AbsApi$callModelAsResponse$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        Ref.ObjectRef r19 = (Ref.ObjectRef) r14.L$4;
        CoroutineContext r20 = (CoroutineContext) r14.L$3;
        r12 = (Function1) r14.L$2;
        Bundle r21 = (Bundle) r14.L$1;
        com.obric.aikernel.a r22 = (com.obric.aikernel.a) r14.L$0;
        ResultKt.throwOnFailure(r16);
    L25:
        Bundle r23 = (Bundle) r16;
        v1 r24 = (v1) r19.element;
        if (r24 == null) goto L29;
        v1.a.a(r24, null, 1, null);
    L29:
        return r12.invoke(r23);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        AIKLog.INSTANCE.v("AbsApi", "start callModelAsResponse " + r11.getString(IdlKeys.MethodName) + ", traceid=" + r11.getString(IdlKeys.Args_TraceId));
        CoroutineContext r25 = r14.getContext();
        Ref.ObjectRef r26 = new Ref.ObjectRef();
        r14.L$0 = r10;
        r14.L$1 = r11;
        r14.L$2 = r12;
        r14.L$3 = r25;
        r14.L$4 = r26;
        r14.label = 1;
        final o r27 = new o(IntrinsicsKt.intercepted(r14), 1);
        r27.F();
        r26.element = (T) BinderMonitor.f4766a.b(r25, r10, new AbsApi$callModelAsResponse$responseBundle$1$1(r27));     // Catch: Throwable -> L17
        r10.A1(r11, new b(r27));     // Catch: Throwable -> L17
    L19:
        r16 = r27.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r14);
    L22:
        if (r16 != r17) goto L24;
        return r17;
    L24:
        r19 = r26;
    L17:
        th = move-exception;
        com.obric.aikernel.sdk.a.a(r27, e8.a.y(new Bundle(), 102, th.getMessage()));
    L7:
        r14 = new AbsApi$callModelAsResponse$1(this, r13);
        goto L8
    }

    public final Object k(com.obric.aikernel.a r12, String r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof AbsApi$unload$1) == false) goto L7;
        AbsApi$unload$1 r10 = (AbsApi$unload$1) r14;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r15 = r10.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r12 = (com.obric.aikernel.a) r10.L$1;
        r13 = (String) r10.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        r12.A1(e8.a.b((Bundle) r15, r13, IdlKeys.Method_UnloadPackage, IdlKeys.Call_Type_CallBiz, null, "AbsApi", "unload", null, false, 200, null), new d(r13));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        ParamsCompat r18 = ParamsCompat.f4752a;
        RequestParams r19 = new RequestParams(null, null, 3, null);
        r10.L$0 = r13;
        r10.L$1 = r12;
        r10.label = 1;
        r15 = r18.f(r19, r10);
        if (r15 != r16) goto L17;
        return r16;
    L7:
        r10 = new AbsApi$unload$1(this, r14);
        goto L8
    }
}
