package kotlinx.coroutines.flow;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "value", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {236}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<Object> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> r1, FlowCollector<Object> r2, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> r3) {
        this.$lastValue = r1;
        this.$downstream = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        FlowKt__DelayKt$debounceInternal$1$3$2 r0 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.ObjectRef<Object> r2 = (Ref.ObjectRef) this.L$1;
        ResultKt.throwOnFailure(r7);
    L24:
        Ref.ObjectRef<Object> r3 = r2;
    L25:
        r3.element = kotlinx.coroutines.flow.internal.o.c;
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Object r8 = ((kotlinx.coroutines.channels.g) this.L$0).a;
        r3 = this.$lastValue;
        boolean r4 = r8 instanceof kotlinx.coroutines.channels.g.c;
        if (r4 == true) goto L11;
        r3.element = r8;
    L11:
        FlowCollector<Object> r5 = this.$downstream;
        if (r4 == false) goto L28;
        Throwable r6 = kotlinx.coroutines.channels.g.a(r8);
        if (r6 != null) goto L26;
        Object r9 = r3.element;
        if (r9 == null) goto L25;
        if (r9 != kotlinx.coroutines.flow.internal.o.a) goto L20;
        r9 = null;
    L20:
        this.L$0 = r8;
        this.L$1 = r3;
        this.label = 1;
        if (r5.emit(r9, this) != r0) goto L23;
        return r0;
    L23:
        r2 = r3;
        goto L24
    L26:
        throw r6;
    }

    public /* synthetic */ Object invoke(Object r1, Object r2) {
        return m758invokeWpGqRn0(((kotlinx.coroutines.channels.g) r1).a, (Continuation) r2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m758invokeWpGqRn0(Object r2, Continuation<? super Unit> r3) {
        return create(new kotlinx.coroutines.channels.g(r2), r3).invokeSuspend(Unit.INSTANCE);
    }
}
