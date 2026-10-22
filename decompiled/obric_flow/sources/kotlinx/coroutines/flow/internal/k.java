package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k2;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements kotlinx.coroutines.flow.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.channels.i f18871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18872b;

    public k(kotlinx.coroutines.channels.i r5, int r10) {
        this.f18871a = r5;
        this.f18872b = r10;
    }

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
    @Override // kotlinx.coroutines.flow.h
    public final Object emit(Object r10, Continuation r11) {
        if ((r11 instanceof CombineKt$combineInternal$2$1$1$emit$1) == false) goto L7;
        CombineKt$combineInternal$2$1$1$emit$1 r5 = (CombineKt$combineInternal$2$1$1$emit$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L62:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
    L19:
        r5.label = 2;
        CoroutineContext r16 = r5.getContext();
        j0.e(r16);
        Continuation r17 = IntrinsicsKt.intercepted(r5);
        if ((r17 instanceof kotlinx.coroutines.internal.e) == false) goto L22;
        kotlinx.coroutines.internal.e r18 = (kotlinx.coroutines.internal.e) r17;
    L23:
        if (r18 != null) goto L25;
        Object r19 = Unit.INSTANCE;
    L53:
        if (r19 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L56;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L56:
        if (r19 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
        r19 = Unit.INSTANCE;
    L59:
        if (r19 != r14) goto L62;
        return r14;
    L25:
        kotlinx.coroutines.z r20 = r18.d;
        if (r20.isDispatchNeeded(r16) == false) goto L28;
        r18.f = Unit.INSTANCE;
        r18.f18987c = 1;
        r20.dispatchYield(r16, r18);
    L51:
        r19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L53
    L28:
        k2 r21 = new k2(k2.f18976b);
        CoroutineContext r22 = r16.plus(r21);
        Unit r23 = Unit.INSTANCE;
        r18.f = r23;
        r18.f18987c = 1;
        r20.dispatchYield(r22, r18);
        if (r21.f18977a == false) goto L51;
        b1 r24 = b2.a();
        ArrayDeque r25 = r24.f18772c;
        if (r25 == null) goto L33;
        boolean r26 = r25.isEmpty();
    L34:
        if (r26 == false) goto L37;
    L47:
        r19 = Unit.INSTANCE;
        goto L53
    L37:
        if (r24.M() == false) goto L39;
        r18.f = r23;
        r18.f18987c = 1;
        r24.J(r18);
        r19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L53
    L39:
        r24.L(true);
        r18.run();     // Catch: Throwable -> L44
    L41:
        if (r24.O() == true) goto L41;
    L43:
        r24.g(true);
    L44:
        th = move-exception;
        r18.h(th);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        r24.g(true);
        throw th;
    L33:
        r26 = true;
        goto L34
    L22:
        r18 = null;
        goto L23
    L16:
        ResultKt.throwOnFailure(r13);
        IndexedValue r27 = new IndexedValue(this.f18872b, r10);
        r5.label = 1;
        if (this.f18871a.r(r27, r5) != r14) goto L19;
        return r14;
    L7:
        r5 = new CombineKt$combineInternal$2$1$1$emit$1(this, r11);
        goto L8
    }
}
