package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1 extends SuspendLambda implements Function1<Continuation<? super Deferred<? extends g>>, Object> {
    final /* synthetic */ Function1<Continuation<? super g>, Object> $block;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/standaloneinterpretation/MmStandaloneAIInterpretationUpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1$1", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {394, 396}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
        final /* synthetic */ Function1<Continuation<? super g>, Object> $block;
        final /* synthetic */ Deferred<g> $previousTask;
        int label;
        final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

        public AnonymousClass1(Deferred<g> r1, MmStandaloneAIInterpretationRepo r2, Function1<? super Continuation<? super g>, ? extends Object> r3, Continuation<? super AnonymousClass1> r4) {
            this.$previousTask = r1;
            this.this$0 = r2;
            this.$block = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$previousTask, this.this$0, this.$block, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super g> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L22:
            return r5;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L16:
            if (this.this$0.j.g().a() == true) goto L19;
            return null;
        L19:
            Function1<Continuation<? super g>, Object> r6 = this.$block;
            this.label = 2;
            r5 = r6.invoke(this);
            if (r5 != r0) goto L22;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            Deferred<g> r7 = this.$previousTask;
            if (r7 == null) goto L16;
            this.label = 1;
            if (r7.join(this) != r0) goto L16;
            return r0;
        }
    }

    public MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1(MmStandaloneAIInterpretationRepo r1, Function1<? super Continuation<? super g>, ? extends Object> r2, Continuation<? super MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1> r3) {
        this.this$0 = r1;
        this.$block = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$task$1(this.this$0, this.$block, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Deferred<g>> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r9);
        MmStandaloneAIInterpretationRepo r10 = this.this$0;
        Deferred<g> r0 = r10.m;
        Deferred<g> r11 = BuildersKt.async$default(r10.j.v, null, null, new AnonymousClass1(r0, r10, this.$block, null), 3, null);
        this.this$0.m = r11;
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
