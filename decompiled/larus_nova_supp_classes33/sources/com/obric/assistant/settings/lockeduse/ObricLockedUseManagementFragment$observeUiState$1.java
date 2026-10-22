package com.obric.assistant.settings.lockeduse;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.lockeduse.ObricLockedUseManagementFragment$observeUiState$1", f = "ObricLockedUseManagementFragment.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
final class ObricLockedUseManagementFragment$observeUiState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricLockedUseManagementFragment this$0;

    /* JADX INFO: renamed from: com.obric.assistant.settings.lockeduse.ObricLockedUseManagementFragment$observeUiState$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.lockeduse.ObricLockedUseManagementFragment$observeUiState$1$1", f = "ObricLockedUseManagementFragment.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricLockedUseManagementFragment this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.lockeduse.ObricLockedUseManagementFragment$observeUiState$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricLockedUseManagementFragment a;

            public a(ObricLockedUseManagementFragment r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                this.a.h.submitList(((m) r1).b);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ObricLockedUseManagementFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ObricLockedUseManagementFragment r6 = this.this$0;
            int r2 = ObricLockedUseManagementFragment.i;
            i1<m> r7 = ((ObricLockedUseManagementViewModel) r6.f.getValue()).getUiState();
            a r3 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public ObricLockedUseManagementFragment$observeUiState$1(ObricLockedUseManagementFragment r1, Continuation<? super ObricLockedUseManagementFragment$observeUiState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricLockedUseManagementFragment$observeUiState$1(this.this$0, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
