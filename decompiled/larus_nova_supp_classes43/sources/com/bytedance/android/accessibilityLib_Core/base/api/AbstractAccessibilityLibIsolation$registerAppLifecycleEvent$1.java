package com.bytedance.android.accessibilityLib_Core.base.api;

import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1", f = "AbstractAccessibilityLibIsolation.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
final class AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AbstractAccessibilityLibIsolation this$0;

    /* JADX INFO: renamed from: com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    @DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1$1", f = "AbstractAccessibilityLibIsolation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1 this$0;

        public AnonymousClass1(AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1 r1, Continuation r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        public final Object invoke(Object r1, Object r10) {
            return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            ProcessLifecycleOwner.get().getLifecycle().addObserver((LifecycleEventObserver) this.this$0.this$0.g.getValue());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1(AbstractAccessibilityLibIsolation r1, Continuation r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AbstractAccessibilityLibIsolation$registerAppLifecycleEvent$1(this.this$0, r11);
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
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r12 = new AnonymousClass1(this, null);
        this.label = 1;
        if (BuildersKt.withContext(r11, r12, this) != r0) goto L12;
        return r0;
    }
}
