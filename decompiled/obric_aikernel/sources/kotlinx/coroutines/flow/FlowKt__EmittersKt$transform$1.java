package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1\n*L\n1#1,222:1\n*E\n"})
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements Function2<d<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ c<Object> $this_transform;
    final /* synthetic */ Function3<d<Object>, Object, Continuation<? super Unit>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$1\n*L\n1#1,222:1\n*E\n"})
    public static final class AnonymousClass1<T> implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function3<d<Object>, T, Continuation<? super Unit>, Object> f10406c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d<Object> f10407g;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super d<Object>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r10, d<Object> r11) {
            this.f10406c = r10;
            this.f10407g = r11;
        }

        @Override // kotlinx.coroutines.flow.d
        public final Object emit(T r10, Continuation<? super Unit> r11) {
            if ((r11 instanceof FlowKt__EmittersKt$transform$1$1$emit$1) == false) goto L7;
            FlowKt__EmittersKt$transform$1$1$emit$1 r12 = (FlowKt__EmittersKt$transform$1$1$emit$1) r11;
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
        L18:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            Function3<d<Object>, T, Continuation<? super Unit>, Object> r17 = this.f10406c;
            d<Object> r18 = this.f10407g;
            r12.label = 1;
            if (r17.invoke(r18, r10, r12) != r15) goto L18;
            return r15;
        L7:
            r12 = new FlowKt__EmittersKt$transform$1$1$emit$1(this, r11);
            goto L8
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1(c<Object> r10, Function3<? super d<Object>, Object, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super FlowKt__EmittersKt$transform$1> r12) {
        this.$this_transform = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowKt__EmittersKt$transform$1 r12 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(d<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<Object> r10, Continuation<? super Unit> r11) {
        return ((FlowKt__EmittersKt$transform$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
        d r13 = (d) this.L$0;
        c<Object> r14 = this.$this_transform;
        AnonymousClass1 r15 = new AnonymousClass1(this.$transform, r13);
        this.label = 1;
        if (r14.a(r15, this) != r11) goto L12;
        return r11;
    }

    public final Object invokeSuspend$$forInline(Object r10) {
        d r11 = (d) this.L$0;
        c<Object> r12 = this.$this_transform;
        AnonymousClass1 r13 = new AnonymousClass1(this.$transform, r11);
        InlineMarker.mark(0);
        r12.a(r13, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
