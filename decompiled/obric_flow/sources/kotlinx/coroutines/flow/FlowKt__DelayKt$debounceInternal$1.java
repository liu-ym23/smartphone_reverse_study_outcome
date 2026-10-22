package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/h;", "downstream", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/h;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {215, 415}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n14#2:408\n14#2:410\n1#3:409\n54#4,5:411\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n212#1:408\n215#1:410\n222#1:411,5\n*E\n"})
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, h, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $this_debounceInternal;
    final /* synthetic */ Function1<Object, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FlowKt__DelayKt$debounceInternal$1(Function1<Object, Long> r5, g r10, Continuation<? super FlowKt__DelayKt$debounceInternal$1> r11) {
        this.$timeoutMillisSelector = r5;
        this.$this_debounceInternal = r10;
        super(3, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r5, h r10, Continuation<? super Unit> r11) {
        return invoke2(r5, r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00dd -> B:7:0x001e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L11;
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L9;
        Ref.ObjectRef r11 = (Ref.ObjectRef) this.L$2;
        kotlinx.coroutines.channels.w r12 = (kotlinx.coroutines.channels.w) this.L$1;
        h r13 = (h) this.L$0;
        ResultKt.throwOnFailure(r15);
    L7:
        h r14 = r13;
        kotlinx.coroutines.channels.w r16 = r12;
        Ref.ObjectRef r17 = r11;
    L13:
        if (r17.element == kotlinx.coroutines.flow.internal.b.d) goto L39;
        Ref.LongRef r18 = new Ref.LongRef();
        Object r19 = r17.element;
        if (r19 == null) goto L29;
        Function1<Object, Long> r20 = this.$timeoutMillisSelector;
        g8.g r21 = kotlinx.coroutines.flow.internal.b.f18863b;
        if (r19 != r21) goto L19;
        r19 = null;
    L19:
        long r110 = r20.invoke(r19).longValue();
        r18.element = r110;
        if (r110 < 0) goto L31;
        if (r110 != 0) goto L29;
        Object r111 = r17.element;
        if (r111 != r21) goto L25;
        r111 = null;
    L25:
        this.L$0 = r14;
        this.L$1 = r16;
        this.L$2 = r17;
        this.L$3 = r18;
        this.label = 1;
        if (r14.emit(r111, this) != r5) goto L28;
        return r5;
    L28:
        r17.element = null;
        goto L29
    L31:
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    L29:
        Ref.LongRef r112 = r18;
        r11 = r17;
        r12 = r16;
        r13 = r14;
        kotlinx.coroutines.selects.f r22 = new kotlinx.coroutines.selects.f(getContext());
        if (r11.element == 0) goto L35;
        kotlinx.coroutines.selects.b.a(r22, r112.element, new FlowKt__DelayKt$debounceInternal$1$3$1(r13, r11, null));
    L35:
        r22.j(r12.i(), new FlowKt__DelayKt$debounceInternal$1$3$2(r11, r13, null));
        this.L$0 = r13;
        this.L$1 = r12;
        this.L$2 = r11;
        this.L$3 = null;
        this.label = 2;
        if (r22.g(this) != r5) goto L7;
        return r5;
    L39:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r18 = (Ref.LongRef) this.L$3;
        r17 = (Ref.ObjectRef) this.L$2;
        r16 = (kotlinx.coroutines.channels.w) this.L$1;
        r14 = (h) this.L$0;
        ResultKt.throwOnFailure(r15);
        goto L28
    L11:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        h r23 = (h) this.L$1;
        kotlinx.coroutines.channels.t r114 = kotlinx.coroutines.channels.s.b(r113, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3);
        r17 = new Ref.ObjectRef();
        r16 = r114;
        r14 = r23;
        goto L13
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, h r10, Continuation<? super Unit> r11) {
        FlowKt__DelayKt$debounceInternal$1 r12 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, r11);
        r12.L$0 = r5;
        r12.L$1 = r10;
        return r12.invokeSuspend(Unit.INSTANCE);
    }
}
