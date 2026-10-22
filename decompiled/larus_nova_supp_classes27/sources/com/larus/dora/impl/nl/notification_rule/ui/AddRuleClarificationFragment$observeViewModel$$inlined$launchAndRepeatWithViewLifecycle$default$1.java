package com.larus.dora.impl.nl.notification_rule.ui;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.larus.dora.api.annotation.CurrentIdleState;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.ui.AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1", f = "AddRuleClarificationFragment.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle.State $minActiveState;
    final /* synthetic */ Fragment $this_launchAndRepeatWithViewLifecycle;
    int label;
    final /* synthetic */ AddRuleClarificationFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.notification_rule.ui.AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$launchAndRepeatWithViewLifecycle$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.ui.AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1$1", f = "AddRuleClarificationFragment.kt", i = {}, l = {CurrentIdleState.FOCUS}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AddRuleClarificationFragment this$0;

        public AnonymousClass1(Continuation r1, AddRuleClarificationFragment r2) {
            this.this$0 = r2;
            super(2, r1);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(r4, this.this$0);
            r0.L$0 = r3;
            return r0;
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
        L15:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            CustomBroadcastRulesViewModel r7 = this.this$0.e;
            if (r7 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r7 = null;
        L11:
            i1<Boolean> r8 = r7.isLoading();
            c r2 = new c(this.this$0);
            this.label = 1;
            if (r8.collect(r2, this) != r0) goto L15;
            return r0;
        }
    }

    public AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(Fragment r1, Lifecycle.State r2, Continuation r3, AddRuleClarificationFragment r4) {
        this.$this_launchAndRepeatWithViewLifecycle = r1;
        this.$minActiveState = r2;
        this.this$0 = r4;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AddRuleClarificationFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this.$this_launchAndRepeatWithViewLifecycle, this.$minActiveState, r5, this.this$0);
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
        Lifecycle r8 = this.$this_launchAndRepeatWithViewLifecycle.getViewLifecycleOwner().getLifecycle();
        Lifecycle.State r2 = this.$minActiveState;
        AnonymousClass1 r3 = new AnonymousClass1(null, this.this$0);
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
