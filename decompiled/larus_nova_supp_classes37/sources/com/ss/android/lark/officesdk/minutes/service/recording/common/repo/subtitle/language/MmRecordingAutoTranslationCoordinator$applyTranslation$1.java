package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingAutoTranslationCoordinator", f = "MmRecordingAutoTranslationCoordinator.kt", i = {0}, l = {245, 272}, m = "applyTranslation", n = {"action"}, s = {"L$0"})
public final class MmRecordingAutoTranslationCoordinator$applyTranslation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAutoTranslationCoordinator this$0;

    public MmRecordingAutoTranslationCoordinator$applyTranslation$1(MmRecordingAutoTranslationCoordinator r1, Continuation<? super MmRecordingAutoTranslationCoordinator$applyTranslation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAutoTranslationCoordinator r3 = this.this$0;
        int r0 = MmRecordingAutoTranslationCoordinator.k;
        return r3.c(null, this);
    }
}
