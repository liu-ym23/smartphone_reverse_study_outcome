package com.lark.kmp.rustclient.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.WaitConditionInterceptor$interceptEnqueue$1$action$1", f = "WaitConditionInterceptor.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
public final class WaitConditionInterceptor$interceptEnqueue$1$action$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.api.h<Resp> $chain;
    final /* synthetic */ MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> $resultFlow;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> a;

        public a(MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r0 = this.a;
            Object r4 = r0.emit((com.lark.kmp.rustclient.api.model.g) r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public WaitConditionInterceptor$interceptEnqueue$1$action$1(com.lark.kmp.rustclient.api.h<Resp> r1, MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r2, Continuation<? super WaitConditionInterceptor$interceptEnqueue$1$action$1> r3) {
        this.$chain = r1;
        this.$resultFlow = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new WaitConditionInterceptor$interceptEnqueue$1$action$1(this.$chain, this.$resultFlow, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
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
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.lark.kmp.rustclient.api.h<Resp> r6 = this.$chain;
        Flow r7 = r6.b(r6.c);
        a r2 = new a(this.$resultFlow);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
