package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask", f = "MmRecordingUploadTask.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_USER_GROUP, ItemViewType.ITEM_VIEW_TYPE_LOADING_FOOTER}, m = "postAudioSegment", n = {}, s = {})
final class MmRecordingUploadTask$postAudioSegment$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingUploadTask this$0;

    public MmRecordingUploadTask$postAudioSegment$1(MmRecordingUploadTask r1, Continuation<? super MmRecordingUploadTask$postAudioSegment$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingUploadTask.a(this.this$0, null, this);
    }
}
