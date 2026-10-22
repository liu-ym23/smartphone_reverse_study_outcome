package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f18910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f18911b;

    /* JADX WARN: Multi-variable type inference failed */
    public w0(Function2 r5, Ref.ObjectRef r10) {
        this.f18910a = (SuspendLambda) r5;
        this.f18911b = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
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
    public final Object emit(Object r5, Continuation r10) {
        if ((r10 instanceof FlowKt__ReduceKt$first$$inlined$collectWhile$2$1) == false) goto L7;
        FlowKt__ReduceKt$first$$inlined$collectWhile$2$1 r11 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Object r16 = r11.L$1;
        w0 this = (w0) r11.L$0;
        ResultKt.throwOnFailure(r13);
        T r17 = r16;
    L18:
        if (((Boolean) r13).booleanValue() == false) goto L20;
        this.f18911b.element = r17;
        throw new AbortFlowException(this);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = this;
        r11.L$1 = r5;
        r11.label = 1;
        InlineMarker.mark(6);
        r13 = this.f18910a.mo2invoke(r5, r11);
        InlineMarker.mark(7);
        r17 = r5;
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r11 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2$1(this, r10);
        goto L8
    }
}
