package com.bytedance.android.live.room.api.record;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.room.api.record.guide.PublishDialogInfo;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.service.LiveScreenRecordService")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/record/ILiveScreenRecordService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/room/api/record/guide/PublishDialogInfo;", "info", "Lcom/bytedance/android/live/room/api/record/guide/a;", "getPublishGuideDialog", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveScreenRecordService extends IService {
    com.bytedance.android.live.room.api.record.guide.a getPublishGuideDialog(PublishDialogInfo r1);
}
