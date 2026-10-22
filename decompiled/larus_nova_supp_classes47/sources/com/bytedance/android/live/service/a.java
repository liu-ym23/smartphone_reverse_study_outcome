package com.bytedance.android.live.service;

import com.bytedance.android.live.record.LiveScreenRecordPublishGuideDialog;
import com.bytedance.android.live.room.api.record.ILiveScreenRecordService;
import com.bytedance.android.live.room.api.record.guide.PublishDialogInfo;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class a implements ILiveScreenRecordService {
    public a() {
        k.l(a.class, this);
    }

    @Override // com.bytedance.android.live.room.api.record.ILiveScreenRecordService
    public com.bytedance.android.live.room.api.record.guide.a getPublishGuideDialog(PublishDialogInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        int r1 = LiveScreenRecordPublishGuideDialog.G;
        Intrinsics.checkNotNullParameter(r3, "info");
        return new com.bytedance.android.live.room.api.record.guide.a(new LiveScreenRecordPublishGuideDialog(r3.getContext(), r3));
    }
}
