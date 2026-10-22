package com.larus.dora.impl.onboarding.lite;

import android.widget.TextView;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingMediaCtrlFragment$onViewCreated$1$1", f = "DoraLiteOnboardingMediaCtrlFragment.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLiteOnboardingMediaCtrlFragment$onViewCreated$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $isSupport;
    final /* synthetic */ TextView $this_apply;
    Object L$0;
    int label;
    final /* synthetic */ DoraLiteOnboardingMediaCtrlFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingMediaCtrlFragment$onViewCreated$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingMediaCtrlFragment$onViewCreated$1$1$1", f = "DoraLiteOnboardingMediaCtrlFragment.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ DoraLiteOnboardingMediaCtrlFragment this$0;

        public AnonymousClass1(DoraLiteOnboardingMediaCtrlFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            DoraLiteOnboardingViewModel r5 = this.this$0.ca0();
            this.label = 1;
            r4 = r5.isDoraSupportOnboarding("MediaCtrlFragment#continueBtn", this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public DoraLiteOnboardingMediaCtrlFragment$onViewCreated$1$1(Ref.BooleanRef r1, TextView r2, DoraLiteOnboardingMediaCtrlFragment r3, Continuation<? super DoraLiteOnboardingMediaCtrlFragment$onViewCreated$1$1> r4) {
        this.$isSupport = r1;
        this.$this_apply = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraLiteOnboardingMediaCtrlFragment$onViewCreated$1$1(this.$isSupport, this.$this_apply, this.this$0, r5);
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
        Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r7);
    L12:
        r2.element = ((Boolean) r7).booleanValue();
        TextView r8 = this.$this_apply;
        if (this.$isSupport.element == true) goto L20;
        this.this$0.getClass();
        if (DoraOnboardingBaseFragment.Y90() == false) goto L20;
        this.this$0.getClass();
        if (DoraOnboardingBaseFragment.X90() == true) goto L20;
        int r3 = 2131903670;
    L21:
        r8.setText(r3);
        return Unit.INSTANCE;
    L20:
        r3 = 2131902338;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Ref.BooleanRef r9 = this.$isSupport;
        CoroutineDispatcher r4 = Dispatchers.getIO();
        AnonymousClass1 r5 = new AnonymousClass1(this.this$0, null);
        this.L$0 = r9;
        this.label = 1;
        Object r6 = BuildersKt.withContext(r4, r5, this);
        if (r6 != r0) goto L11;
        return r0;
    L11:
        r2 = r9;
        r7 = r6;
        goto L12
    }
}
