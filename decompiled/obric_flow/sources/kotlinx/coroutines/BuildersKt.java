package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {}, d2 = {}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class BuildersKt {
    public static final <T> m0 async(CoroutineScope r5, CoroutineContext r10, CoroutineStart r11, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r12) {
        CoroutineContext r13 = x.b(r5, r10);
        if (r11.isLazy() == false) goto L5;
        m0 r14 = new s1(r13, r12);
    L6:
        r11.invoke(r12, r14, r14);
        return r14;
    L5:
        r14 = new n0(r13, true);
        goto L6
    }

    public static /* synthetic */ m0 async$default(CoroutineScope r5, CoroutineContext r10, CoroutineStart r11, Function2 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = CoroutineStart.DEFAULT;
    L9:
        return async(r5, r10, r11, r12);
    }

    public static final <T> Object invoke(z r5, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        return withContext(r5, r10, r11);
    }

    public static final Job launch(CoroutineScope r5, CoroutineContext r10, CoroutineStart r11, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r12) {
        CoroutineContext r13 = x.b(r5, r10);
        if (r11.isLazy() == false) goto L5;
        Job r14 = new t1(r13, r12);
    L6:
        r11.invoke(r12, r14, r14);
        return r14;
    L5:
        r14 = new y1(r13, true);
        goto L6
    }

    public static /* synthetic */ Job launch$default(CoroutineScope r5, CoroutineContext r10, CoroutineStart r11, Function2 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = CoroutineStart.DEFAULT;
    L9:
        return launch(r5, r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final <T> T runBlocking(CoroutineContext r5, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r10) throws InterruptedException {
        Thread r11 = Thread.currentThread();
        ContinuationInterceptor r12 = (ContinuationInterceptor) r5.get(ContinuationInterceptor.Key);
        if (r12 != null) goto L6;
        b1 r13 = b2.a();
        CoroutineContext r14 = x.b(GlobalScope.INSTANCE, r5.plus(r13));
    L9:
        f r15 = new f(r14, r11, r13);
        CoroutineStart.DEFAULT.invoke(r10, r15, r15);
        b1 r16 = r15.e;
        if (r16 == null) goto L38;
        int r17 = b1.d;
        r16.L(false);
    L38:
    L16:
        th = move-exception;
        if (r16 == null) goto L37;
        int r18 = b1.d;
        r16.g(false);
    L37:
        throw th;
    L13:
        if (Thread.interrupted() == true) goto L33;
        if (r16 == null) goto L18;
        long r19 = r16.N();     // Catch: Throwable -> L16
    L20:
        if (r15.isCompleted() == true) goto L23;
        LockSupport.parkNanos(r15, r19);     // Catch: Throwable -> L16
        goto L38
    L23:
        if (r16 == null) goto L25;
        int r20 = b1.d;
        r16.g(false);
    L25:
        T r21 = (T) j0.k(r1.f18988a.get(r15));
        if ((r21 instanceof v) == false) goto L28;
        v r22 = (v) r21;
    L29:
        if (r22 != null) goto L32;
        return r21;
    L32:
        throw r22.f19025a;
    L28:
        r22 = null;
        goto L29
    L18:
        r19 = Long.MAX_VALUE;
        goto L20
    L33:
        InterruptedException r23 = new InterruptedException();     // Catch: Throwable -> L16
        r15.w(r23);     // Catch: Throwable -> L16
        throw r23;     // Catch: Throwable -> L16
    L6:
        if ((r12 instanceof b1) == false) goto L8;
        b1 r24 = (b1) r12;
    L8:
        r13 = (b1) b2.f18773a.get();
        r14 = x.b(GlobalScope.INSTANCE, r5);
        goto L9
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext r5, Function2 r10, int r11, Object r12) throws InterruptedException {
        if ((r11 & 1) == 0) goto L6;
        r5 = EmptyCoroutineContext.INSTANCE;
    L6:
        return runBlocking(r5, r10);
    }

    public static final <T> Object withContext(CoroutineContext r5, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
        CoroutineContext r12 = r11.getContext();
        if (((Boolean) r5.fold(Boolean.FALSE, new com.bytedance.ai.applet.components.view.a(1))).booleanValue() == true) goto L5;
        CoroutineContext r13 = r12.plus(r5);
    L6:
        j0.e(r13);
        if (r13 != r12) goto L9;
        kotlinx.coroutines.internal.r r14 = new kotlinx.coroutines.internal.r(r11, r13);
        Object r15 = com.lynx.tasm.utils.a.z(r14, r14, r10);
    L33:
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L35:
        return r15;
    L9:
        ContinuationInterceptor.Key r16 = ContinuationInterceptor.Key;
        if (Intrinsics.areEqual(r13.get(r16), r12.get(r16)) == false) goto L17;
        g2 r17 = new g2(r11, r13);
        CoroutineContext r18 = r17.f18767c;
        Object r19 = kotlinx.coroutines.internal.v.c(r18, null);
        Object r20 = com.lynx.tasm.utils.a.z(r17, r17, r10);     // Catch: Throwable -> L14
        kotlinx.coroutines.internal.v.a(r18, r19);
        r15 = r20;
    L14:
        th = move-exception;
        kotlinx.coroutines.internal.v.a(r18, r19);
        throw th;
    L17:
        p0 r21 = new p0(r11, r13);
        xt.a.b(r10, r21, r21);
    L18:
        AtomicIntegerFieldUpdater r22 = p0.e;
        int r23 = r22.get(r21);
        if (r23 != 0) goto L21;
        if (r22.compareAndSet(r21, 0, 1) == false) goto L18;
        r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L33
    L21:
        if (r23 != 2) goto L28;
        r15 = j0.k(r1.f18988a.get(r21));
        if ((r15 instanceof v) == false) goto L33;
        throw ((v) r15).f19025a;
    L28:
        throw new IllegalStateException("Already suspended");
    L5:
        r13 = x.a(r12, r5, false);
        goto L6
    }
}
