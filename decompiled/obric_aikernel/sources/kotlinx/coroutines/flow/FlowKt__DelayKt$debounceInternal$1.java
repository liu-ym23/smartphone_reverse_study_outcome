package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {221, 426}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,415:1\n18#2:416\n18#2:418\n1#3:417\n55#4,8:419\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n218#1:416\n221#1:418\n228#1:419,8\n*E\n"})
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<kotlinx.coroutines.l0, d<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ c<Object> $this_debounceInternal;
    final /* synthetic */ Function1<Object, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    FlowKt__DelayKt$debounceInternal$1(Function1<Object, Long> r10, c<Object> r11, Continuation<? super FlowKt__DelayKt$debounceInternal$1> r12) {
        this.$timeoutMillisSelector = r10;
        this.$this_debounceInternal = r11;
        super(3, r12);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.l0 r10, d<Object> r11, Continuation<? super Unit> r12) {
        return invoke2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.l0 r10, d<Object> r11, Continuation<? super Unit> r12) {
        FlowKt__DelayKt$debounceInternal$1 r13 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0111 -> B:7:0x0025). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        Ref.ObjectRef r12 = (Ref.ObjectRef) this.L$2;
        ReceiveChannel r13 = (ReceiveChannel) this.L$1;
        d r14 = (d) this.L$0;
        ResultKt.throwOnFailure(r18);
        d r15 = r14;
        ReceiveChannel r16 = r13;
    L7:
        Ref.ObjectRef r17 = r12;
    L13:
        if (r17.element == kotlinx.coroutines.flow.internal.n.f10497c) goto L56;
        Ref.LongRef r19 = new Ref.LongRef();
        Object r110 = r17.element;
        if (r110 == null) goto L33;
        Function1<Object, Long> r111 = this.$timeoutMillisSelector;
        kotlinx.coroutines.internal.i0 r112 = kotlinx.coroutines.flow.internal.n.f10495a;
        if (r110 != r112) goto L19;
        r110 = null;
    L19:
        long r113 = r111.invoke(r110).longValue();
        r19.element = r113;
        if (r113 < 0) goto L22;
        boolean r114 = true;
    L23:
        if (r114 == false) goto L35;
        if (r113 != 0) goto L33;
        Object r115 = r17.element;
        if (r115 != r112) goto L29;
        r115 = null;
    L29:
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = r17;
        this.L$3 = r19;
        this.label = 1;
        if (r15.emit(r115, this) != r10) goto L32;
        return r10;
    L32:
        r17.element = null;
        goto L33
    L35:
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    L22:
        r114 = false;
    L33:
        Ref.ObjectRef r116 = r17;
        Ref.LongRef r20 = r19;
        r12 = r116;
        if (kotlinx.coroutines.n0.a() == true) goto L39;
    L49:
        SelectImplementation r117 = new SelectImplementation(getContext());
        if (r12.element == 0) goto L52;
        kotlinx.coroutines.selects.a.a(r117, r20.element, new FlowKt__DelayKt$debounceInternal$1$3$1(r15, r12, null));
    L52:
        r117.e(r16.d(), new FlowKt__DelayKt$debounceInternal$1$3$2(r12, r15, null));
        this.L$0 = r15;
        this.L$1 = r16;
        this.L$2 = r12;
        this.L$3 = null;
        this.label = 2;
        if (r117.r(this) != r10) goto L7;
        return r10;
    L39:
        if (r12.element != 0) goto L41;
    L44:
        boolean r118 = true;
    L45:
        if (r118 == true) goto L49;
        throw new AssertionError();
    L41:
        if (r20.element > 0) goto L44;
        r118 = false;
        goto L45
    L56:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r19 = (Ref.LongRef) this.L$3;
        r17 = (Ref.ObjectRef) this.L$2;
        r16 = (ReceiveChannel) this.L$1;
        r15 = (d) this.L$0;
        ResultKt.throwOnFailure(r18);
        goto L32
    L11:
        ResultKt.throwOnFailure(r18);
        kotlinx.coroutines.l0 r21 = (kotlinx.coroutines.l0) this.L$0;
        d r22 = (d) this.L$1;
        r15 = r22;
        r16 = ProduceKt.d(r21, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, null);
        r17 = new Ref.ObjectRef();
        goto L13
    }
}
