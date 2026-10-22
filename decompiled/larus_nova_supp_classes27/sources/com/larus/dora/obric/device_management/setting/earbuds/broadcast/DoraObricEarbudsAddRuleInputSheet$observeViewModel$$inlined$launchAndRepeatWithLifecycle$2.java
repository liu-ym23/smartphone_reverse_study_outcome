package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import java.util.List;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAddRuleInputSheet$launchAndRepeatWithLifecycle$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2", f = "DoraObricEarbudsAddRuleInputSheet.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraObricEarbudsAddRuleInputSheet this$0;
    final /* synthetic */ DoraObricEarbudsAddRuleInputSheet this$0$inline_fun;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsAddRuleInputSheet$launchAndRepeatWithLifecycle$1$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2$1", f = "DoraObricEarbudsAddRuleInputSheet.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricEarbudsAddRuleInputSheet this$0;

        public AnonymousClass1(Continuation r1, DoraObricEarbudsAddRuleInputSheet r2) {
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
            DoraObricEarbudsAddRuleInputSheet r6 = this.this$0;
            int r2 = DoraObricEarbudsAddRuleInputSheet.i;
            kotlinx.coroutines.flow.d1<List<String>> r7 = r6.V90().getClarifiedDesc();
            k r3 = new k(this.this$0);
            this.label = 1;
            if (r7.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    public DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2(DoraObricEarbudsAddRuleInputSheet r1, Continuation r2, DoraObricEarbudsAddRuleInputSheet r3) {
        this.this$0$inline_fun = r1;
        this.this$0 = r3;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricEarbudsAddRuleInputSheet$observeViewModel$$inlined$launchAndRepeatWithLifecycle$2(this.this$0$inline_fun, r4, this.this$0);
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
        if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
