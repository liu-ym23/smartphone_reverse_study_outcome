package com.ss.android.lark.mention.base.impl.atselector.doubaoview.viewmodel;

import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {
    @SdkCall(50113)
    RucketJob<PullDoubaoChatterResponse> getDoubaoChatter(PullDoubaoChatterRequest r1);
}
