package m6b;

import com.bytedance.lark.pb.im.v1.PushDraftChange;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface e {
    @SdkPush(5311)
    RucketJob<PushDraftChange> pushDraftChange();
}
