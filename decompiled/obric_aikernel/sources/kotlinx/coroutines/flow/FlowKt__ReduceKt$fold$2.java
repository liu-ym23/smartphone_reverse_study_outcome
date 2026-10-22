package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reduce.kt\nkotlinx/coroutines/flow/FlowKt__ReduceKt$fold$2\n*L\n1#1,172:1\n*E\n"})
public final class FlowKt__ReduceKt$fold$2<T> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef<R> f10428c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> f10429g;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$fold$2(Ref.ObjectRef<R> r10, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r11) {
        this.f10428c = r10;
        this.f10429g = r11;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.d
    public final Object emit(T r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof FlowKt__ReduceKt$fold$2$emit$1) == false) goto L7;
        FlowKt__ReduceKt$fold$2$emit$1 r12 = (FlowKt__ReduceKt$fold$2$emit$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Ref.ObjectRef r17 = (Ref.ObjectRef) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        r17.element = (T) r14;
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        Ref.ObjectRef r18 = this.f10428c;
        Function3<R, T, Continuation<? super R>, Object> r19 = this.f10429g;
        T r20 = r18.element;
        r12.L$0 = r18;
        r12.label = 1;
        Object r21 = r19.invoke((R) r20, r10, r12);
        if (r21 != r15) goto L17;
        return r15;
    L17:
        r14 = (T) r21;
        r17 = r18;
    L7:
        r12 = new FlowKt__ReduceKt$fold$2$emit$1(this, r11);
        goto L8
    }
}
