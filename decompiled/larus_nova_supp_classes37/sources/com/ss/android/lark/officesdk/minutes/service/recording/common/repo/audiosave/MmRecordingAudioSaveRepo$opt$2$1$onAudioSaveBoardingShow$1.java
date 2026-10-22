package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo$opt$2$1", f = "MmRecordingAudioSaveRepo.kt", i = {}, l = {111}, m = "onAudioSaveBoardingShow", n = {}, s = {})
public final class MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveBoardingShow$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveBoardingShow$1(MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 r1, Continuation<? super MmRecordingAudioSaveRepo$opt$2$1$onAudioSaveBoardingShow$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.A(this);
    }
}
