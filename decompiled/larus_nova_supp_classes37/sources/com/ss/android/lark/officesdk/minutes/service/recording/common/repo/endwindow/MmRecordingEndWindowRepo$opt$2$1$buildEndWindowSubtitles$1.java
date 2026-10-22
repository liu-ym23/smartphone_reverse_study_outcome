package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmRecordingEndWindowRepo$opt$2$1", f = "MmRecordingEndWindowRepo.kt", i = {0, 0, 0, 0, 0}, l = {160}, m = "buildEndWindowSubtitles", n = {"meetingId", "destination$iv$iv", "item", "displaySpeaker", "content"}, s = {"L$0", "L$1", "L$3", "L$4", "L$5"})
public final class MmRecordingEndWindowRepo$opt$2$1$buildEndWindowSubtitles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingEndWindowRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingEndWindowRepo$opt$2$1$buildEndWindowSubtitles$1(MmRecordingEndWindowRepo$opt$2.AnonymousClass1 r1, Continuation<? super MmRecordingEndWindowRepo$opt$2$1$buildEndWindowSubtitles$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.U0(null, null, this);
    }
}
