package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {215, 418}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<kotlinx.coroutines.al, j<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> r3, i<? extends T> r4, Continuation<? super FlowKt__DelayKt$debounceInternal$1> r5) {
        Function1<T, Long> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        i<T> r7 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$timeoutMillisSelector = r6;
        this.$this_debounceInternal = r7;
        super(3, r8);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Object r4, Continuation<? super Unit> r5) {
        return invoke((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(kotlinx.coroutines.al r3, j<? super T> r4, Continuation<? super Unit> r5) {
        kotlinx.coroutines.al r6 = (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__DelayKt$debounceInternal$1 r0 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, r8);
        r0.L$0 = r6;
        r0.L$1 = r7;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x017f -> B:7:0x0038). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        long r5 = 0;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        Ref.ObjectRef r3 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.channels.y r10 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        j r11 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        j r12 = r11;
        kotlinx.coroutines.channels.y r13 = r10;
    L7:
        Ref.ObjectRef r14 = r3;
        r5 = 0;
    L13:
        if (r14.element == kotlinx.coroutines.flow.internal.s.c) goto L57;
        Ref.LongRef r4 = new Ref.LongRef();
        if (r14.element == null) goto L33;
        Function1<T, Long> r15 = this.$timeoutMillisSelector;
        kotlinx.coroutines.internal.aj r16 = kotlinx.coroutines.flow.internal.s.f17463a;
        T r17 = r14.element;
        if (r17 != r16) goto L19;
        r17 = null;
    L19:
        r4.element = ((Number) ZeusTransformUtils.preCheckCast(r15.invoke(r17), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r4.element < r5) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == false) goto L35;
        if (r4.element != r5) goto L33;
        kotlinx.coroutines.internal.aj r110 = kotlinx.coroutines.flow.internal.s.f17463a;
        T r111 = r14.element;
        if (r111 != r110) goto L29;
        r111 = null;
    L29:
        Continuation<? super Unit> r112 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r12;
        this.L$1 = r13;
        this.L$2 = r14;
        this.L$3 = r4;
        this.label = 1;
        if (r12.emit(r111, r112) != r1) goto L32;
        return r1;
    L32:
        r14.element = null;
        goto L33
    L35:
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    L22:
        r19 = false;
    L33:
        Ref.ObjectRef r113 = r14;
        Ref.LongRef r114 = r4;
        r3 = r113;
        if (kotlinx.coroutines.an.a() == true) goto L39;
    L49:
        kotlinx.coroutines.selects.l r115 = new kotlinx.coroutines.selects.l(getContext());
        kotlinx.coroutines.selects.c r116 = (kotlinx.coroutines.selects.c) ZeusTransformUtils.preCheckCast(r115, kotlinx.coroutines.selects.c.class, "com.obric.memorydata.plugin");
        if (r3.element == null) goto L52;
        kotlinx.coroutines.selects.b.a(r116, r114.element, (Function1) ZeusTransformUtils.preCheckCast(new FlowKt__DelayKt$debounceInternal$1$3$1(r12, r3, null), Function1.class, "com.obric.memorydata.plugin"));
    L52:
        r116.a(r13.k(), (Function2) ZeusTransformUtils.preCheckCast(new FlowKt__DelayKt$debounceInternal$1$3$2(r3, r12, null), Function2.class, "com.obric.memorydata.plugin"));
        this.L$0 = r12;
        this.L$1 = r13;
        this.L$2 = r3;
        this.L$3 = null;
        this.label = 2;
        if (r115.a(this) != r1) goto L7;
        return r1;
    L39:
        if (r3.element != null) goto L41;
    L44:
        boolean r117 = true;
    L45:
        if (r117 == true) goto L49;
        throw new AssertionError();
    L41:
        if (r114.element > r5) goto L44;
        r117 = false;
        goto L45
    L57:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r4 = (Ref.LongRef) ZeusTransformUtils.preCheckCast(this.L$3, Ref.LongRef.class, "com.obric.memorydata.plugin");
        r14 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r13 = (kotlinx.coroutines.channels.y) ZeusTransformUtils.preCheckCast(this.L$1, kotlinx.coroutines.channels.y.class, "com.obric.memorydata.plugin");
        r12 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
        goto L32
    L11:
        ResultKt.throwOnFailure(r18);
        kotlinx.coroutines.al r118 = (kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        j r6 = (j) ZeusTransformUtils.preCheckCast(this.L$1, j.class, "com.obric.memorydata.plugin");
        r12 = r6;
        r13 = kotlinx.coroutines.channels.u.a(r118, null, 0, (Function2) ZeusTransformUtils.preCheckCast(new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r14 = new Ref.ObjectRef();
        goto L13
    }
}
