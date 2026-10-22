package kotlinx.coroutines.flow;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.g$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "value", "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {395}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
public final class FlowKt__DelayKt$timeoutInternal$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<Object>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FlowCollector<Object> $downStream;
    /* synthetic */ Object L$0;
    int label;

    public FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector<Object> r1, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> r2) {
        this.$downStream = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 r0 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Object r2 = this.L$0;
        ResultKt.throwOnFailure(r5);
    L14:
        Object r6 = r2;
    L16:
        if ((r6 instanceof g$a) == false) goto L23;
        Throwable r7 = kotlinx.coroutines.channels.g.a(r6);
        if (r7 == null) goto L20;
        throw r7;
    L20:
        return Boxing.boxBoolean(false);
    L23:
        return Boxing.boxBoolean(true);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        r6 = ((kotlinx.coroutines.channels.g) this.L$0).a;
        FlowCollector<Object> r3 = this.$downStream;
        if ((r6 instanceof kotlinx.coroutines.channels.g.c) == true) goto L16;
        this.L$0 = r6;
        this.label = 1;
        if (r3.emit(r6, this) != r0) goto L13;
        return r0;
    L13:
        r2 = r6;
        goto L14
    }

    public /* synthetic */ Object invoke(Object r1, Object r2) {
        return m759invokeWpGqRn0(((kotlinx.coroutines.channels.g) r1).a, (Continuation) r2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m759invokeWpGqRn0(Object r2, Continuation<? super Boolean> r3) {
        return create(new kotlinx.coroutines.channels.g(r2), r3).invokeSuspend(Unit.INSTANCE);
    }
}
