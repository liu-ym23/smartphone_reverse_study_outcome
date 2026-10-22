package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
final class DistinctFlowImpl$collect$2<T> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DistinctFlowImpl<T> f10395c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<Object> f10396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ d<T> f10397h;

    /* JADX WARN: Multi-variable type inference failed */
    DistinctFlowImpl$collect$2(DistinctFlowImpl<T> r10, Ref.ObjectRef<Object> r11, d<? super T> r12) {
        this.f10395c = r10;
        this.f10396g = r11;
        this.f10397h = r12;
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
    @Override // kotlinx.coroutines.flow.d
    public final Object emit(T r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof DistinctFlowImpl$collect$2$emit$1) == false) goto L7;
        DistinctFlowImpl$collect$2$emit$1 r12 = (DistinctFlowImpl$collect$2$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L25:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        T r17 = (T) this.f10395c.f10393g.invoke(r10);
        Object r18 = this.f10396g.element;
        if (r18 != kotlinx.coroutines.flow.internal.n.f10495a) goto L17;
    L21:
        this.f10396g.element = r17;
        d<T> r19 = this.f10397h;
        r12.label = 1;
        if (r19.emit(r10, r12) != r15) goto L25;
        return r15;
    L17:
        if (this.f10395c.f10394h.invoke(r18, r17).booleanValue() == false) goto L21;
        return Unit.INSTANCE;
    L7:
        r12 = new DistinctFlowImpl$collect$2$emit$1(this, r11);
        goto L8
    }
}
