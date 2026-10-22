package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils.MmRecordingMapSaveHelper", f = "MmRecordingMapSaveHelper.kt", i = {0, 0, 0}, l = {245}, m = "setMapStyle", n = {"uiLaunchMode", "isDarkMode", "startTime"}, s = {"L$0", "Z$0", "J$0"})
public final class MmRecordingMapSaveHelper$setMapStyle$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingMapSaveHelper this$0;

    public MmRecordingMapSaveHelper$setMapStyle$1(MmRecordingMapSaveHelper r1, Continuation<? super MmRecordingMapSaveHelper$setMapStyle$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        MmRecordingMapSaveHelper r4 = this.this$0;
        int r0 = MmRecordingMapSaveHelper.m;
        return r4.h(null, null, false, this);
    }
}
