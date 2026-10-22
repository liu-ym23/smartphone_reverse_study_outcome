package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.picker.base.view.ItemViewType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "activeLanguage", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$1$10", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingViewModel$observeAIInterpretation$1$10 extends SuspendLambda implements Function2<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingViewModel this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$1$10$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$1$10$2", f = "MmRecordingViewModel.kt", i = {}, l = {1007}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g $activeLanguage;
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass2(MmRecordingViewModel r1, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$activeLanguage = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$activeLanguage, r4);
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
            MmRecordingViewModel r5 = this.this$0;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r2 = this.$activeLanguage;
            this.label = 1;
            if (MmRecordingViewModel.access$linkSubtitleTranslationIfNeeded(r5, r2, this) != r0) goto L12;
            return r0;
        }
    }

    public MmRecordingViewModel$observeAIInterpretation$1$10(MmRecordingViewModel r1, Continuation<? super MmRecordingViewModel$observeAIInterpretation$1$10> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingViewModel$observeAIInterpretation$1$10 r0 = new MmRecordingViewModel$observeAIInterpretation$1$10(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g r9 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g) this.L$0;
        this.this$0.setState(new AnonymousClass1(r9));
        BuildersKt.launch$default(MmRecordingViewModel.access$getViewModelScope(this.this$0), null, null, new AnonymousClass2(this.this$0, r9, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
