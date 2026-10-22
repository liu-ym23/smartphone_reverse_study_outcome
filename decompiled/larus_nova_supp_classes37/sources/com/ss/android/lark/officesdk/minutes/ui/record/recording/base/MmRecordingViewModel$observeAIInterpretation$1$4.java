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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "enabled", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$1$4", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingViewModel$observeAIInterpretation$1$4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingViewModel this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$1$4$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$1$4$2", f = "MmRecordingViewModel.kt", i = {}, l = {985}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingViewModel this$0;

        public AnonymousClass2(MmRecordingViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            this.label = 1;
            if (MmRecordingViewModel.linkSubtitleTranslationIfNeeded$default(r5, null, this, 1, null) != r0) goto L12;
            return r0;
        }
    }

    public MmRecordingViewModel$observeAIInterpretation$1$4(MmRecordingViewModel r1, Continuation<? super MmRecordingViewModel$observeAIInterpretation$1$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingViewModel$observeAIInterpretation$1$4 r0 = new MmRecordingViewModel$observeAIInterpretation$1$4(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r7);
        final boolean r8 = this.Z$0;
        this.this$0.setState(new AnonymousClass1(r8));
        if (r8 == true) goto L7;
        MmRecordingViewModel.access$markAIInterpretationHeadsetDialogDismissed(this.this$0, "ai interpretation disabled");
    L7:
        if (r8 == false) goto L10;
        BuildersKt.launch$default(MmRecordingViewModel.access$getViewModelScope(this.this$0), null, null, new AnonymousClass2(this.this$0, null), 3, null);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
