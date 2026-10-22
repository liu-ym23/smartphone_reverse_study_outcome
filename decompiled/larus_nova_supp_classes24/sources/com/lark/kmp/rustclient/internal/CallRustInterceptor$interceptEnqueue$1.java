package com.lark.kmp.rustclient.internal;

import com.lark.kmp.logger.LarkLogger;
import com.lark.kmp.pb.basic.v1.Command;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/suite/lark/rust/callback/AsyncCallbackData;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.CallRustInterceptor$interceptEnqueue$1", f = "CallRustInterceptor.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
public final class CallRustInterceptor$interceptEnqueue$1 extends SuspendLambda implements Function2<FlowCollector<? super rpc.a>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.api.a<Resp> $input;
    final /* synthetic */ Flow<rpc.a> $rustFlow;
    final /* synthetic */ long $taskId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CallRustInterceptor this$0;

    /* JADX INFO: renamed from: com.lark.kmp.rustclient.internal.CallRustInterceptor$interceptEnqueue$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.lark.kmp.rustclient.internal.CallRustInterceptor$interceptEnqueue$1$1", f = "CallRustInterceptor.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<rpc.a> $$this$flow;
        final /* synthetic */ com.lark.kmp.rustclient.api.a<Resp> $input;
        final /* synthetic */ Flow<rpc.a> $rustFlow;
        final /* synthetic */ long $taskId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CallRustInterceptor this$0;

        /* JADX INFO: renamed from: com.lark.kmp.rustclient.internal.CallRustInterceptor$interceptEnqueue$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        @DebugMetadata(c = "com.lark.kmp.rustclient.internal.CallRustInterceptor$interceptEnqueue$1$1$1", f = "CallRustInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ com.lark.kmp.rustclient.api.a<Resp> $input;
            final /* synthetic */ long $taskId;
            int label;
            final /* synthetic */ CallRustInterceptor this$0;

            public C00061(com.lark.kmp.rustclient.api.a<Resp> r1, long r2, CallRustInterceptor r4, Continuation<? super C00061> r5) {
                this.$input = r1;
                this.$taskId = r2;
                this.this$0 = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new C00061(this.$input, this.$taskId, this.this$0, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r10) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L23;
                ResultKt.throwOnFailure(r10);
                com.lark.kmp.rustclient.api.a<Resp> r11 = this.$input;
                com.lark.kmp.rustclient.api.model.c<Resp> r1 = r11.a;
                com.lark.kmp.rustclient.api.model.j r0 = r11.b;
                boolean r2 = r0 instanceof com.lark.kmp.rustclient.api.model.l;
                com.lark.kmp.rustclient.api.model.l r3 = null;
                if (r2 == false) goto L7;
                com.lark.kmp.rustclient.api.model.l r4 = (com.lark.kmp.rustclient.api.model.l) r0;
            L8:
                if (r4 == null) goto L11;
                String r5 = r4.a;
                if (r5 == null) goto L11;
            L12:
                if (r2 == false) goto L14;
                r3 = (com.lark.kmp.rustclient.api.model.l) r0;
            L14:
                if (r3 == null) goto L19;
                Long r6 = r3.b;
                if (r6 == null) goto L19;
                Long r7 = r6;
            L20:
                this.this$0.b.b(new com.lark.kmp.rustclient.api.model.e(Command.WRAPPER_WITH_PACKET.getValue(), d.a(new u(r1, r5, Boxing.boxLong(this.$taskId), null, r7, 8)).encode(), this.$input.a.a(), this.$input.a.b, this.$taskId));
                return Unit.INSTANCE;
            L19:
                r7 = r11.d;
            L11:
                r5 = r11.c;
                goto L12
            L7:
                r4 = null;
                goto L8
            L23:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.lark.kmp.rustclient.internal.CallRustInterceptor$interceptEnqueue$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ FlowCollector<rpc.a> a;

            public a(FlowCollector<? super rpc.a> r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                FlowCollector<rpc.a> r0 = this.a;
                Object r4 = r0.emit((rpc.a) r2, r3);
                if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r4;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Flow<rpc.a> r1, com.lark.kmp.rustclient.api.a<Resp> r2, long r3, CallRustInterceptor r5, FlowCollector<? super rpc.a> r6, Continuation<? super AnonymousClass1> r7) {
            this.$rustFlow = r1;
            this.$input = r2;
            this.$taskId = r3;
            this.this$0 = r5;
            this.$$this$flow = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r8 = new AnonymousClass1(this.$rustFlow, this.$input, this.$taskId, this.this$0, this.$$this$flow, r11);
            r8.L$0 = r10;
            return r8;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new C00061(this.$input, this.$taskId, this.this$0, null), 3, null);
            Flow<rpc.a> r14 = this.$rustFlow;
            a r2 = new a(this.$$this$flow);
            this.label = 1;
            if (r14.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public CallRustInterceptor$interceptEnqueue$1(Flow<rpc.a> r1, com.lark.kmp.rustclient.api.a<Resp> r2, long r3, CallRustInterceptor r5, Continuation<? super CallRustInterceptor$interceptEnqueue$1> r6) {
        this.$rustFlow = r1;
        this.$input = r2;
        this.$taskId = r3;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        CallRustInterceptor$interceptEnqueue$1 r7 = new CallRustInterceptor$interceptEnqueue$1(this.$rustFlow, this.$input, this.$taskId, this.this$0, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super rpc.a> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        FlowCollector r9 = (FlowCollector) this.L$0;
        LarkLogger r13 = LarkLogger.a;
        LarkLogger.a("CallRustInterceptor", "interceptEnqueue flow");
        AnonymousClass1 r14 = new AnonymousClass1(this.$rustFlow, this.$input, this.$taskId, this.this$0, r9, null);
        this.label = 1;
        if (CoroutineScopeKt.coroutineScope(r14, this) != r0) goto L12;
        return r0;
    }
}
