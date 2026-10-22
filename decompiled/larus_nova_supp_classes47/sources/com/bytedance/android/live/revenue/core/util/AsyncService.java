package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class AsyncService implements o, d {
    public final ey0.a a;
    public Object b;
    public final List<Continuation<Unit>> c;

    public static final class a implements Continuation<Unit> {
        public final /* synthetic */ AsyncService a;

        public CoroutineContext getContext() {
            return this.a.a;
        }

        public a(AsyncService r1) {
            this.a = r1;
        }

        public final void resumeWith(Object r5) {
            AsyncService r0 = this.a;
            Throwable r1 = Result.exceptionOrNull-impl(r5);
            if (r1 == null) goto L6;
            r5 = r1;
        L6:
            r0.b = r5;
            Object r6 = this.a.b;
            if (Intrinsics.areEqual(r6, Unit.INSTANCE) == false) goto L14;
            Iterator<T> r7 = this.a.c.iterator();
        L10:
            if (r7.hasNext() == false) goto L12;
            ey0.b.a((Continuation) r7.next(), Unit.INSTANCE);
            goto L10
        L12:
            ((ArrayList) this.a.c).clear();
            return;
        L14:
            if ((r6 instanceof Throwable) == false) goto L22;
            Iterator<T> r2 = this.a.c.iterator();
        L17:
            if (r2.hasNext() == false) goto L23;
            Continuation r3 = (Continuation) r2.next();
            Result.Companion r4 = Result.Companion;
            r3.resumeWith(Result.constructor-impl(ResultKt.createFailure((Throwable) r6)));
            goto L17
        L23:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.core.util.AsyncService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
        public AnonymousClass1(AsyncService r8) {
            super(1, r8, AsyncService.class, "onStartAsync", "onStartAsync(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return ((AsyncService) ((CallableReference) this).receiver).o0(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }
    }

    public abstract Object o0(Continuation<? super Unit> r1);

    @Override // com.bytedance.android.live.revenue.core.util.d
    public final boolean f() {
        Object r0 = this.b;
        if (r0 != null) goto L6;
        return false;
    L6:
        if ((r0 instanceof Throwable) == false) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r0, Boolean.valueOf(this.a.a)) == false) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r0, Unit.INSTANCE) == false) goto L16;
        return true;
    L16:
        throw new AssertionError();
    }

    public final void onStart() {
        ContinuationKt.startCoroutine(new AnonymousClass1(this), new a(this));
    }

    public void onStop() {
        this.a.a = true;
        ((ArrayList) this.c).clear();
    }

    public AsyncService() {
        this.a = new ey0.a();
        this.c = new ArrayList();
    }

    @Override // com.bytedance.android.live.revenue.core.util.d
    public final Object g(Continuation<? super Unit> r3) {
        if (f() == true) goto L10;
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r3));
        ((ArrayList) this.c).add(r0);
        Object r1 = r0.getOrThrow();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r3);
    L9:
        return r1;
    L10:
        return Unit.INSTANCE;
    }

    public final void p0(com.bytedance.android.livesdk.revenue.service.sti.a r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$use");
        Intrinsics.checkNotNullParameter(r5, "block");
        if (r4.f() == false) goto L5;
        r5.invoke(r4);
        return;
    L5:
        AsyncService$use$1 r1 = new AsyncService$use$1(r4, r5, null);
        Intrinsics.checkNotNullParameter(r1, "block");
        if (this.a.a == true) goto L11;
        ContinuationKt.startCoroutine(r1, new com.bytedance.android.live.revenue.core.util.a(this));
        return;
    }
}
