package com.larus.ui.arch.vm.internal;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.PausingDispatcherKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentVMFlowExtKt$collectLatest$1", f = "ComponentVMFlowExt.kt", i = {}, l = {61, 62}, m = "invokeSuspend", n = {}, s = {})
final class ComponentVMFlowExtKt$collectLatest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
    final /* synthetic */ Flow<Object> $flow;
    final /* synthetic */ LifecycleOwner $owner;
    int label;

    /* JADX INFO: renamed from: com.larus.ui.arch.vm.internal.ComponentVMFlowExtKt$collectLatest$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "", "it"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentVMFlowExtKt$collectLatest$1$1", f = "ComponentVMFlowExt.kt", i = {}, l = {TraceLevel.ALL}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
        final /* synthetic */ LifecycleOwner $owner;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.larus.ui.arch.vm.internal.ComponentVMFlowExtKt$collectLatest$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentVMFlowExtKt$collectLatest$1$1$1", f = "ComponentVMFlowExt.kt", i = {}, l = {TraceLevel.ALL}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<Object, Continuation<? super Unit>, Object> $action;
            final /* synthetic */ Object $it;
            int label;

            public C00501(Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r1, Object r2, Continuation<? super C00501> r3) {
                this.$action = r1;
                this.$it = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00501(this.$action, this.$it, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                Function2<Object, Continuation<? super Unit>, Object> r5 = this.$action;
                Object r2 = this.$it;
                this.label = 1;
                if (r5.invoke(r2, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(LifecycleOwner r1, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super AnonymousClass1> r3) {
            this.$owner = r1;
            this.$action = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$owner, this.$action, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(Object r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            Object r8 = this.L$0;
            LifecycleOwner r2 = this.$owner;
            C00501 r3 = new C00501(this.$action, r8, null);
            this.label = 1;
            if (PausingDispatcherKt.whenStarted(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    public ComponentVMFlowExtKt$collectLatest$1(Flow<Object> r1, LifecycleOwner r2, Function2<Object, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super ComponentVMFlowExtKt$collectLatest$1> r4) {
        this.$flow = r1;
        this.$owner = r2;
        this.$action = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ComponentVMFlowExtKt$collectLatest$1(this.$flow, this.$owner, this.$action, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        Flow<Object> r8 = this.$flow;
        AnonymousClass1 r2 = new AnonymousClass1(this.$owner, this.$action, null);
        this.label = 2;
        if (kotlinx.coroutines.flow.e.i(r8, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (f2.a(this) != r0) goto L13;
        return r0;
    }
}
