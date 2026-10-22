package com.larus.bmhome.chat.component.bottom.core;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.bmhome.input.api.EnterKeyBehaviorServiceDelegate;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$observeEnterKeyBehavior$1", f = "CoreInputComponent.kt", i = {}, l = {5280}, m = "invokeSuspend", n = {}, s = {})
final class CoreInputComponent$observeEnterKeyBehavior$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$observeEnterKeyBehavior$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$observeEnterKeyBehavior$1$1", f = "CoreInputComponent.kt", i = {}, l = {5281}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoreInputComponent this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$observeEnterKeyBehavior$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CoreInputComponent a;

            public a(CoreInputComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r4, Continuation r5) {
                final EnterKeyAction r6 = (EnterKeyAction) r4;
                CoreInputComponent r7 = this.a;
                int r0 = CoreInputComponent.d3;
                final com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r8 = r7.W4();
                if (r8 == null) goto L6;
                r8.S9(0, new c7(r8, r6));
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(CoreInputComponent r1, Continuation<? super AnonymousClass1> r2) {
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
            kotlinx.coroutines.flow.i1 r6 = EnterKeyBehaviorServiceDelegate.b.a();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public CoreInputComponent$observeEnterKeyBehavior$1(CoreInputComponent r1, Continuation<? super CoreInputComponent$observeEnterKeyBehavior$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CoreInputComponent$observeEnterKeyBehavior$1(this.this$0, r3);
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
        CoreInputComponent r8 = this.this$0;
        LifecycleRegistry r2 = ((BaseComponentFeatureInternal) r8).a;
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        AnonymousClass1 r4 = new AnonymousClass1(r8, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
