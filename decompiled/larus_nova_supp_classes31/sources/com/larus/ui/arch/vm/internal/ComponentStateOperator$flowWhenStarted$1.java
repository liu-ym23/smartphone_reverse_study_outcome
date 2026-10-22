package com.larus.ui.arch.vm.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1", f = "ComponentStateOperator.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
final class ComponentStateOperator$flowWhenStarted$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $owner;
    final /* synthetic */ Flow<Object> $this_flowWhenStarted;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ComponentStateOperator<w1a.b> this$0;

    /* JADX INFO: renamed from: com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1", f = "ComponentStateOperator.kt", i = {0, 0, 0, 0, 0, 0}, l = {381}, m = "invokeSuspend", n = {"startedChannel", "flowChannel", "transform", "started", "flowValue", "isClosed"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.channels.k<Object> $$this$channelFlow;
        final /* synthetic */ LifecycleOwner $owner;
        final /* synthetic */ Flow<Object> $this_flowWhenStarted;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ ComponentStateOperator<w1a.b> this$0;

        public AnonymousClass1(ComponentStateOperator<w1a.b> r1, LifecycleOwner r2, Flow<Object> r3, kotlinx.coroutines.channels.k<Object> r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$owner = r2;
            this.$this_flowWhenStarted = r3;
            this.$$this$channelFlow = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$owner, this.$this_flowWhenStarted, this.$$this$channelFlow, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x00e0 -> B:15:0x00e2). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            Ref.BooleanRef r3 = (Ref.BooleanRef) this.L$5;
            Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$4;
            Ref.ObjectRef r5 = (Ref.ObjectRef) this.L$3;
            Function3 r6 = (Function3) this.L$2;
            ReceiveChannel r7 = (ReceiveChannel) this.L$1;
            ReceiveChannel r8 = (Channel) this.L$0;
            ResultKt.throwOnFailure(r19);
            AnonymousClass1 r10 = this;
            Ref.ObjectRef r11 = r4;
            Ref.ObjectRef r12 = r5;
            Function3 r13 = r6;
            ReceiveChannel r14 = r7;
            ReceiveChannel r15 = r8;
        L10:
            if (r3.element == true) goto L17;
            SelectImplementation r9 = new SelectImplementation(r10.getContext());
            Ref.ObjectRef r16 = r12;
            Object r110 = r1;
            AnonymousClass1 r17 = r10;
            r9.d(r15.getOnReceiveCatching(), new ComponentStateOperator$flowWhenStarted$1$1$1$1(r14, r3, r16, r11, r13, null));
            r9.d(r14.getOnReceiveCatching(), new ComponentStateOperator$flowWhenStarted$1$1$1$2(r3, r11, r16, r13, null));
            r17.L$0 = r15;
            r17.L$1 = r14;
            r17.L$2 = r13;
            r17.L$3 = r12;
            r17.L$4 = r11;
            r17.L$5 = r3;
            r17.label = 1;
            if (r9.h(r17) != r110) goto L14;
            return r110;
        L14:
            r10 = r17;
            r1 = r110;
            goto L10
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r19);
            CoroutineScope r18 = (CoroutineScope) this.L$0;
            ComponentStateOperator<w1a.b> r20 = this.this$0;
            final Lifecycle r21 = this.$owner.getLifecycle();
            r20.getClass();
            final ReceiveChannel r22 = ChannelKt.Channel$default(-1, null, null, 6, null);
            final LifecycleObserver r23 = new ComponentStateOperator$startedChannel$observer$1(r22);
            r21.addObserver(r23);
            r22.invokeOnClose(new b(r21, r23));
            ReceiveChannel r24 = ProduceKt.c(r18, 0, new ComponentStateOperator$flowWhenStarted$1$1$flowChannel$1(this.$this_flowWhenStarted, null), 3);
            ComponentStateOperator$flowWhenStarted$1$1$transform$1 r25 = new ComponentStateOperator$flowWhenStarted$1$1$transform$1(this.$$this$channelFlow, null);
            Ref.ObjectRef r26 = new Ref.ObjectRef();
            Ref.ObjectRef r27 = new Ref.ObjectRef();
            r10 = this;
            r14 = r24;
            r15 = r22;
            r13 = r25;
            r12 = r26;
            r11 = r27;
            r3 = new Ref.BooleanRef();
            goto L10
        }
    }

    public ComponentStateOperator$flowWhenStarted$1(ComponentStateOperator<w1a.b> r1, LifecycleOwner r2, Flow<Object> r3, Continuation<? super ComponentStateOperator$flowWhenStarted$1> r4) {
        this.this$0 = r1;
        this.$owner = r2;
        this.$this_flowWhenStarted = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ComponentStateOperator$flowWhenStarted$1 r0 = new ComponentStateOperator$flowWhenStarted$1(this.this$0, this.$owner, this.$this_flowWhenStarted, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.channels.k r7 = (kotlinx.coroutines.channels.k) this.L$0;
        AnonymousClass1 r11 = new AnonymousClass1(this.this$0, this.$owner, this.$this_flowWhenStarted, r7, null);
        this.label = 1;
        if (CoroutineScopeKt.coroutineScope(r11, this) != r0) goto L12;
        return r0;
    }
}
