package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1", f = "DoraObricEarbudsConfirmRulesSheet.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    int label;
    final /* synthetic */ DoraObricEarbudsConfirmRulesSheet this$0;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1$1", f = "DoraObricEarbudsConfirmRulesSheet.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super AnonymousClass1> r2) {
            this.$block = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$block, r3);
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
            Function1<Continuation<? super Unit>, Object> r5 = this.$block;
            this.label = 1;
            if (r5.invoke(this) != r0) goto L12;
            return r0;
        }

        public final Object invokeSuspend$$forInline(Object r1) {
            this.$block.invoke(this);
            return Unit.INSTANCE;
        }
    }

    public DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1(DoraObricEarbudsConfirmRulesSheet r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1> r3) {
        this.this$0 = r1;
        this.$block = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricEarbudsConfirmRulesSheet$launchAndRepeatWithLifecycle$1(this.this$0, this.$block, r4);
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
        Lifecycle r8 = this.this$0.getLifecycle();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(this.$block, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.a(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }

    public final Object invokeSuspend$$forInline(Object r5) {
        Lifecycle r6 = this.this$0.getLifecycle();
        Lifecycle.State r0 = Lifecycle.State.STARTED;
        AnonymousClass1 r1 = new AnonymousClass1(this.$block, null);
        InlineMarker.mark(0);
        RepeatOnLifecycleKt.a(r6, r0, r1, this);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
