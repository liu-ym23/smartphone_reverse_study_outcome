package com.ss.android.lark.chat.export.offlineCacheClean;

import com.bytedance.lark.pb.im.v1.OfflineDataCleanPush;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c {
    @SdkPush(50005)
    RucketJob<OfflineDataCleanPush> pushOfflineDataClean();
}
