package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "languages", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/aiinterpretation/MmAIInterpretationLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$1$6", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingViewModel$observeAIInterpretation$1$6 extends SuspendLambda implements Function2<List<? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingViewModel this$0;

    public MmRecordingViewModel$observeAIInterpretation$1$6(MmRecordingViewModel r1, Continuation<? super MmRecordingViewModel$observeAIInterpretation$1$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingViewModel$observeAIInterpretation$1$6 r0 = new MmRecordingViewModel$observeAIInterpretation$1$6(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((List) r1, (Continuation) r2);
    }

    public final Object invoke(List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.g> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        final List r4 = (List) this.L$0;
        this.this$0.setState(new AnonymousClass1(r4));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
