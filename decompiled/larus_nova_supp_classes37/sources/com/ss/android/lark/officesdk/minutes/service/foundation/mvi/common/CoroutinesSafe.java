package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CoroutinesSafe {
    public final CoroutineScope a;
    public kotlinx.coroutines.channels.a b;

    public static final class a {
    }

    public static final class b implements CoroutineContext.Element {
        public final CoroutineContext.Key<?> a;

        public b() {
            c r0 = c.a;
            Intrinsics.checkNotNullParameter(r0, "key");
            this.a = r0;
        }

        public final CoroutineContext.Key<?> getKey() {
            return this.a;
        }

        public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r1) {
            return (E) CoroutineContext.Element.DefaultImpls.get(this, r1);
        }

        public final CoroutineContext minusKey(CoroutineContext.Key<?> r1) {
            return CoroutineContext.Element.DefaultImpls.minusKey(this, r1);
        }

        public final CoroutineContext plus(CoroutineContext r1) {
            return CoroutineContext.Element.DefaultImpls.plus(this, r1);
        }

        public final <R> R fold(R r1, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r2) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(this, r1, r2);
        }
    }

    public static final class c implements CoroutineContext.Key<b> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    static {
    }

    public CoroutinesSafe(CoroutineScope r2) {
        Intrinsics.checkNotNullParameter(r2, "coroutineScope");
        this.a = r2;
    }

    public final void c(Function1<? super Continuation<? super Unit>, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "block");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        BuildersKt.launch$default(this.a, null, null, new CoroutinesSafe$runConcurrentSafe$1(this, r8, r0, null), 3, null);
    }

    public static final void a(CoroutinesSafe r4, CoroutineScope r5) {
        if (r4.b != null) goto L6;
        lvb.a.e("CoroutinesSafe", "initConcurrentEventIfNeed");
        c r1 = c.a;
        r4.b = kotlinx.coroutines.channels.b.a(r5, new b(), 0, new CoroutinesSafe$initConcurrentEventIfNeed$1(null), 14);
        return;
    }

    public final <T> Object b(Function1<? super Continuation<? super T>, ? extends Object> r14, Continuation<? super T> r15) {
        if (((b) r15.getContext().get(c.a)) != null) goto L5;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        j r6 = new j(IntrinsicsKt.intercepted(r15), 1);
        r6.C();
        BuildersKt.launch$default(this.a, null, null, new CoroutinesSafe$makeConcurrentSafe$2$1(this, r2, r6, r14, null), 3, null);
        Object r16 = r6.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r15);
    L9:
        return r16;
    L5:
        return r14.invoke(r15);
    }
}
