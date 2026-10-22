package kotlinx.coroutines.flow;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
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
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {215, 418}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_debounceInternal;
    final /* synthetic */ Function1<Object, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FlowKt__DelayKt$debounceInternal$1(Function1<Object, Long> r1, Flow<Object> r2, Continuation<? super FlowKt__DelayKt$debounceInternal$1> r3) {
        this.$timeoutMillisSelector = r1;
        this.$this_debounceInternal = r2;
        super(3, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((CoroutineScope) r1, (FlowCollector) r2, (Continuation) r3);
    }

    public final Object invoke(CoroutineScope r4, FlowCollector<Object> r5, Continuation<? super Unit> r6) {
        FlowKt__DelayKt$debounceInternal$1 r0 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, r6);
        r0.L$0 = r4;
        r0.L$1 = r5;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00f2 -> B:12:0x005f). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$2;
        ReceiveChannel r7 = (ReceiveChannel) this.L$1;
        FlowCollector r8 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r19);
    L11:
        FlowKt__DelayKt$debounceInternal$1 r9 = this;
    L13:
        if (r3.element == kotlinx.coroutines.flow.internal.o.c) goto L42;
        Ref$LongRef r10 = new Ref$LongRef();
        Object r11 = r3.element;
        if (r11 == null) goto L35;
        Function1<Object, Long> r12 = r9.$timeoutMillisSelector;
        b0 r13 = kotlinx.coroutines.flow.internal.o.a;
        if (r11 != r13) goto L19;
        r11 = null;
    L19:
        long r14 = ((Number) r12.invoke(r11)).longValue();
        r10.element = r14;
        if (r14 < 0) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == false) goto L34;
        if (r14 != 0) goto L35;
        Object r16 = r3.element;
        if (r16 != r13) goto L28;
        r16 = null;
    L28:
        r9.L$0 = r8;
        r9.L$1 = r7;
        r9.L$2 = r3;
        r9.L$3 = r10;
        r9.label = 1;
        if (r8.emit(r16, r9) != r1) goto L31;
        return r1;
    L31:
        ReceiveChannel r17 = r7;
        Ref.ObjectRef r18 = r3;
        Ref$LongRef r4 = r10;
        FlowCollector r110 = r8;
        ReceiveChannel r20 = r17;
    L32:
        r18.element = null;
        FlowCollector r111 = r110;
        r10 = r4;
        r3 = r18;
        r7 = r20;
        r8 = r111;
        goto L35
    L34:
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    L22:
        r15 = false;
    L35:
        SelectImplementation r112 = new SelectImplementation(r9.getContext());
        if (r3.element == null) goto L38;
        c.a(r112, r10.element, new FlowKt__DelayKt$debounceInternal$1$3$1(r8, r3, null));
    L38:
        r112.d(r7.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(r3, r8, null));
        r9.L$0 = r8;
        r9.L$1 = r7;
        r9.L$2 = r3;
        r9.L$3 = null;
        r9.label = 2;
        if (r112.h(r9) != r1) goto L13;
        return r1;
    L42:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r4 = (Ref$LongRef) this.L$3;
        r18 = (Ref.ObjectRef) this.L$2;
        r20 = (ReceiveChannel) this.L$1;
        FlowCollector r21 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r19);
        r110 = r21;
        r9 = this;
        goto L32
    L10:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        r8 = (FlowCollector) this.L$1;
        r7 = ProduceKt.c(r5, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3);
        r3 = new Ref.ObjectRef();
        goto L11
    }
}
