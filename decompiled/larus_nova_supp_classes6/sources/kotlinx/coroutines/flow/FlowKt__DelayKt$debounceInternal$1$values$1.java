package kotlinx.coroutines.flow;

import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", i = {}, l = {EntityType.SIM_CARD}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$debounceInternal$1$values$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_debounceInternal;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ kotlinx.coroutines.channels.k<Object> a;

        public AnonymousClass1(kotlinx.coroutines.channels.k<Object> r1) {
            this.a = r1;
        }

        public final Object emit(T r5, Continuation<? super Unit> r6) {
            if ((r6 instanceof FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) == false) goto L7;
            FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1 r0 = (FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1) r6;
            int r1 = r0.label;
            if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
            r0.label = r1 - IWakeupSessionConstant.RC_ERROR;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r7);
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.channels.k<Object> r8 = this.a;
            if (r5 != null) goto L17;
            r5 = (T) kotlinx.coroutines.flow.internal.o.a;
        L17:
            r0.label = 1;
            if (r8.send(r5, r0) != r2) goto L21;
            return r2;
        L7:
            r0 = new FlowKt__DelayKt$debounceInternal$1$values$1$1$emit$1(this, r6);
            goto L8
        }
    }

    public FlowKt__DelayKt$debounceInternal$1$values$1(Flow<Object> r1, Continuation<? super FlowKt__DelayKt$debounceInternal$1$values$1> r2) {
        this.$this_debounceInternal = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowKt__DelayKt$debounceInternal$1$values$1 r0 = new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) this.L$0;
        Flow<Object> r2 = this.$this_debounceInternal;
        AnonymousClass1 r3 = new AnonymousClass1(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
