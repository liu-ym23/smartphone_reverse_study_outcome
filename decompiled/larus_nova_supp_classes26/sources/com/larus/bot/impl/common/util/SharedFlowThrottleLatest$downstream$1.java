package com.larus.bot.impl.common.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.SharedFlowThrottleLatest$downstream$1", f = "FlowExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SharedFlowThrottleLatest$downstream$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ f<Object> this$0;

    /* JADX INFO: renamed from: com.larus.bot.impl.common.util.SharedFlowThrottleLatest$downstream$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.common.util.SharedFlowThrottleLatest$downstream$1$1", f = "FlowExt.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ f<Object> this$0;

        /* JADX INFO: renamed from: com.larus.bot.impl.common.util.SharedFlowThrottleLatest$downstream$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ f<T> a;
            public final /* synthetic */ CoroutineScope b;

            public a(f<T> r1, CoroutineScope r2) {
                this.a = r1;
                this.b = r2;
            }

            public final Object emit(T r12, Continuation<? super Unit> r13) {
                f<T> r6 = this.a;
                CoroutineScope r7 = this.b;
                r6.getClass();
                long r2 = System.currentTimeMillis() - r6.e;
                f.a<T> r0 = r6.f;
                if (r0 == null) goto L9;
                Job r1 = r0.b;
                if (r1 == null) goto L9;
                boolean r3 = true;
                if (r1.isActive() != true) goto L9;
            L10:
                if (r3 == false) goto L15;
                f.a<T> r14 = r6.f;
                if (r14 == null) goto L20;
                r14.a = r12;
            L20:
                Object r15 = Unit.INSTANCE;
            L30:
                if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
                return r15;
            L33:
                return Unit.INSTANCE;
            L15:
                if (r2 >= 0) goto L17;
            L21:
                r6.f = null;
                r6.e = System.currentTimeMillis();
                r15 = r6.c.emit(r12, r13);
                if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
                r15 = Unit.INSTANCE;
            L26:
                if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
                r15 = Unit.INSTANCE;
                goto L30
            L17:
                if (r2 >= r6.b) goto L21;
                f.a<T> r16 = new f.a(r12);
                r16.b = BuildersKt.launch$default(r7, null, null, new SharedFlowThrottleLatest$emitAt$2$1(r6, r2, r16, null), 3, null);
                r6.f = r16;
            L9:
                r3 = false;
                goto L10
            }
        }

        public AnonymousClass1(f<Object> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            f<Object> r2 = this.this$0;
            Flow<Object> r3 = r2.a;
            a r4 = new a(r2, r7);
            this.label = 1;
            if (r3.collect(r4, this) != r0) goto L12;
            return r0;
        }
    }

    public SharedFlowThrottleLatest$downstream$1(f<Object> r1, Continuation<? super SharedFlowThrottleLatest$downstream$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SharedFlowThrottleLatest$downstream$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r7);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(getContext()), null, null, new AnonymousClass1(this.this$0, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
