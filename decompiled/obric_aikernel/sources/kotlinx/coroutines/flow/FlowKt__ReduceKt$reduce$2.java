package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
final class FlowKt__ReduceKt$reduce$2<T> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<Object> f10430c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> f10431g;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ReduceKt$reduce$2(Ref.ObjectRef<Object> r10, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r11) {
        this.f10430c = r10;
        this.f10431g = r11;
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
        if ((r11 instanceof FlowKt__ReduceKt$reduce$2$emit$1) == false) goto L7;
        FlowKt__ReduceKt$reduce$2$emit$1 r12 = (FlowKt__ReduceKt$reduce$2$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Ref.ObjectRef<Object> r17 = (Ref.ObjectRef) r12.L$0;
        ResultKt.throwOnFailure(r14);
        Object r18 = (T) r14;
    L20:
        Ref.ObjectRef<Object> r19 = r17;
        Object r20 = r18;
    L21:
        r19.element = (T) r20;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r19 = this.f10430c;
        Object r21 = r19.element;
        r20 = r10;
        if (r21 == kotlinx.coroutines.flow.internal.n.f10495a) goto L21;
        Function3<S, T, Continuation<? super S>, Object> r22 = this.f10431g;
        r12.L$0 = r19;
        r12.label = 1;
        Object r23 = r22.invoke((S) r21, r10, r12);
        if (r23 != r15) goto L19;
        return r15;
    L19:
        r18 = r23;
        r17 = r19;
    L7:
        r12 = new FlowKt__ReduceKt$reduce$2$emit$1(this, r11);
        goto L8
    }
}
