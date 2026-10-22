package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2", f = "DoraObricEarbudsConfirmRulesSheet.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraObricEarbudsConfirmRulesSheet this$0;
    final /* synthetic */ DoraObricEarbudsConfirmRulesSheet this$0$inline_fun;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2$1", f = "DoraObricEarbudsConfirmRulesSheet.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricEarbudsConfirmRulesSheet this$0;

        public AnonymousClass1(Continuation r1, DoraObricEarbudsConfirmRulesSheet r2) {
            this.this$0 = r2;
            super(2, r1);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(r3, this.this$0);
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
            DoraObricEarbudsConfirmRulesSheet r6 = this.this$0;
            int r2 = DoraObricEarbudsConfirmRulesSheet.g;
            kotlinx.coroutines.flow.d1<Unit> r7 = ((CustomBroadcastRulesViewModel) r6.d.getValue()).getActionSuccessEvent();
            m1 r3 = new m1(this.this$0);
            this.label = 1;
            if (r7.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2(DoraObricEarbudsConfirmRulesSheet r1, Continuation r2, DoraObricEarbudsConfirmRulesSheet r3) {
        this.this$0$inline_fun = r1;
        this.this$0 = r3;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricEarbudsConfirmRulesSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2(this.this$0$inline_fun, r4, this.this$0);
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
        Lifecycle r8 = this.this$0$inline_fun.getLifecycle();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(null, this.this$0);
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
