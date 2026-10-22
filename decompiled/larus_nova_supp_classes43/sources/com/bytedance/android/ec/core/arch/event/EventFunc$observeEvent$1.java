package com.bytedance.android.ec.core.arch.event;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.arch.lifecycle.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/android/ec/core/arch/event/d;", "I", "Lcom/bytedance/android/ec/core/arch/state/b;", "S", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.arch.event.EventFunc$observeEvent$1", f = "EventFunc.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class EventFunc$observeEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ CoroutineContext $dispatcher;
    final /* synthetic */ LifecycleOwner $lifecycleOwnerNotNull;
    final /* synthetic */ a $sharedFlow;
    int label;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.arch.event.EventFunc$observeEvent$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/android/ec/core/arch/event/d;", "I", "Lcom/bytedance/android/ec/core/arch/state/b;", "S", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.core.arch.event.EventFunc$observeEvent$1$1", f = "EventFunc.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ EventFunc$observeEvent$1 this$0;

        public AnonymousClass1(EventFunc$observeEvent$1 r1, Continuation r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r11);
            r0.L$0 = r10;
            return r0;
        }

        public final Object invoke(Object r1, Object r10) {
            return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            CoroutineScope r0 = (CoroutineScope) this.L$0;
            int r11 = b.a;
            EventFunc$observeEvent$1 r12 = this.this$0;
            a r1 = r12.$sharedFlow;
            BuildersKt.launch$default(r0, r12.$dispatcher, null, new EventFunc$collect$1(r1, r12.$block, null), 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public EventFunc$observeEvent$1(LifecycleOwner r1, a r10, CoroutineContext r11, Function1 r12, Continuation r13) {
        this.$lifecycleOwnerNotNull = r1;
        this.$sharedFlow = r10;
        this.$dispatcher = r11;
        this.$block = r12;
        super(2, r13);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new EventFunc$observeEvent$1(this.$lifecycleOwnerNotNull, this.$sharedFlow, this.$dispatcher, this.$block, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
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
        LifecycleOwner r11 = this.$lifecycleOwnerNotNull;
        Lifecycle.State r12 = Lifecycle.State.STARTED;
        AnonymousClass1 r13 = new AnonymousClass1(this, null);
        this.label = 1;
        if (i.a(r11, r12, r13, this) != r0) goto L12;
        return r0;
    }
}
