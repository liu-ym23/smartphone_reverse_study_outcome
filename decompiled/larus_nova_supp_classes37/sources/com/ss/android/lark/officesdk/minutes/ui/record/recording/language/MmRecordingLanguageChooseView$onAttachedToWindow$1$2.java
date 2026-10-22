package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "language", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.language.MmRecordingLanguageChooseView$onAttachedToWindow$1$2", f = "MmRecordingLanguageChooseView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingLanguageChooseView$onAttachedToWindow$1$2 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingLanguageChooseView this$0;

    public MmRecordingLanguageChooseView$onAttachedToWindow$1$2(MmRecordingLanguageChooseView r1, Continuation<? super MmRecordingLanguageChooseView$onAttachedToWindow$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingLanguageChooseView$onAttachedToWindow$1$2 r0 = new MmRecordingLanguageChooseView$onAttachedToWindow$1$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(h r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((h) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        h r3 = (h) this.L$0;
        this.this$0.f.setIconDesc(r3.b);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
