package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper", f = "MmRecordingMapSaveHelper.kt", i = {0, 0, 0, 0, 0, 0}, l = {217, 236}, m = "createAndCaptureMap", n = {"map", "context", "container", "isDarkMode", "latitude", "longitude"}, s = {"L$0", "L$1", "L$2", "Z$0", "D$0", "D$1"})
public final class MmRecordingMapSaveHelper$createAndCaptureMap$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    public MmRecordingMapSaveHelper$createAndCaptureMap$1(MmRecordingMapSaveHelper r1, Continuation<? super MmRecordingMapSaveHelper$createAndCaptureMap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        MmRecordingMapSaveHelper r0 = this.this$0;
        int r12 = MmRecordingMapSaveHelper.m;
        return r0.e(null, null, null, false, 0.0d, 0.0d, this);
    }
}
