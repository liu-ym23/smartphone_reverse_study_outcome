package kotlinx.coroutines.flow;

import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/channels/n;", "", "value", "", "<anonymous>", "(Lkotlinx/coroutines/channels/n;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {236}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,407:1\n529#2,2:408\n544#2:410\n545#2:413\n1#3:411\n14#4:412\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$2\n*L\n232#1:408,2\n233#1:410\n233#1:413\n236#1:412\n*E\n"})
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.n, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> r5, h r10, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> r11) {
        this.$lastValue = r5;
        this.$downstream = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        FlowKt__DelayKt$debounceInternal$1$3$2 r11 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* synthetic */ Object mo2invoke(kotlinx.coroutines.channels.n r5, Continuation<? super Unit> r10) {
        return m1631invokeWpGqRn0(r5.f18815a, r10);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m1631invokeWpGqRn0(Object r5, Continuation<? super Unit> r10) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(new kotlinx.coroutines.channels.n(r5), r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [T, g8.g] */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        Ref.ObjectRef<Object> r12 = (Ref.ObjectRef) this.L$1;
        ResultKt.throwOnFailure(r10);
    L24:
        Ref.ObjectRef<Object> r13 = r12;
    L25:
        r13.element = kotlinx.coroutines.flow.internal.b.d;
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ?? r14 = ((kotlinx.coroutines.channels.n) this.L$0).f18815a;
        r13 = this.$lastValue;
        boolean r15 = r14 instanceof kotlinx.coroutines.channels.m;
        if (r15 == true) goto L11;
        r13.element = r14;
    L11:
        h r16 = this.$downstream;
        if (r15 == false) goto L28;
        Throwable r17 = kotlinx.coroutines.channels.n.a(r14);
        if (r17 != null) goto L26;
        Object r18 = r13.element;
        if (r18 == null) goto L25;
        if (r18 != kotlinx.coroutines.flow.internal.b.f18863b) goto L20;
        r18 = null;
    L20:
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 1;
        if (r16.emit(r18, this) != r5) goto L23;
        return r5;
    L23:
        r12 = r13;
        goto L24
    L26:
        throw r17;
    }
}
