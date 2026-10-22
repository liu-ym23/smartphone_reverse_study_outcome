package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.l<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ c<Object> $this_debounceInternal;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.l<Object> f10402c;

        AnonymousClass1(kotlinx.coroutines.channels.l<Object> r10) {
            this.f10402c = r10;
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
            if ((r11 instanceof FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) == false) goto L7;
            FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 r12 = (FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) r11;
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
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            kotlinx.coroutines.channels.l<Object> r17 = this.f10402c;
            if (r10 != null) goto L17;
            r10 = (T) kotlinx.coroutines.flow.internal.n.f10495a;
        L17:
            r12.label = 1;
            if (r17.H(r10, r12) != r15) goto L21;
            return r15;
        L7:
            r12 = new FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(this, r11);
            goto L8
        }
    }

    FlowKt__DelayKt$debounceInternal$1$values$1(c<Object> r10, Continuation<? super FlowKt__DelayKt$debounceInternal$1$values$1> r11) {
        this.$this_debounceInternal = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowKt__DelayKt$debounceInternal$1$values$1 r12 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.l<? super Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.l<Object> r10, Continuation<? super Unit> r11) {
        return ((FlowKt__DelayKt$debounceInternal$1$values$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        kotlinx.coroutines.channels.l r13 = (kotlinx.coroutines.channels.l) this.L$0;
        c<Object> r14 = this.$this_debounceInternal;
        AnonymousClass1 r15 = new AnonymousClass1(r13);
        this.label = 1;
        if (r14.a(r15, this) != r11) goto L12;
        return r11;
    }
}
