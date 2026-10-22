package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {242}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,415:1\n514#2,6:416\n530#2,4:422\n534#2:428\n1#3:426\n18#4:427\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n*L\n238#1:416,6\n239#1:422,4\n239#1:428\n242#1:427\n*E\n"})
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ d<Object> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> r10, d<Object> r11, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> r12) {
        this.$lastValue = r10;
        this.$downstream = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FlowKt__DelayKt$debounceInternal$1$3$2 r12 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.channels.g<? extends Object> r10, Continuation<? super Unit> r11) {
        return m1547invokeWpGqRn0(r10.k(), r11);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m1547invokeWpGqRn0(Object r10, Continuation<? super Unit> r11) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(kotlinx.coroutines.channels.g.b(r10), r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [T, kotlinx.coroutines.internal.i0] */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        Ref.ObjectRef<Object> r13 = (Ref.ObjectRef) this.L$1;
        ResultKt.throwOnFailure(r10);
    L24:
        Ref.ObjectRef<Object> r14 = r13;
    L25:
        r14.element = kotlinx.coroutines.flow.internal.n.f10497c;
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ?? r15 = ((kotlinx.coroutines.channels.g) this.L$0).k();
        r14 = this.$lastValue;
        boolean r16 = r15 instanceof kotlinx.coroutines.channels.g.c;
        if (r16 == true) goto L11;
        r14.element = r15;
    L11:
        d<Object> r17 = this.$downstream;
        if (r16 == false) goto L28;
        Throwable r18 = kotlinx.coroutines.channels.g.e(r15);
        if (r18 != null) goto L26;
        Object r19 = r14.element;
        if (r19 == null) goto L25;
        if (r19 != kotlinx.coroutines.flow.internal.n.f10495a) goto L20;
        r19 = null;
    L20:
        this.L$0 = r15;
        this.L$1 = r14;
        this.label = 1;
        if (r17.emit(r19, this) != r11) goto L23;
        return r11;
    L23:
        r13 = r14;
        goto L24
    L26:
        throw r18;
    }
}
