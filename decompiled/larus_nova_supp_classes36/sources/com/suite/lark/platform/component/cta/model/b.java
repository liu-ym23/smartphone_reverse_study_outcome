package com.suite.lark.platform.component.cta.model;

import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {
    @SdkCall(2167)
    RucketJob<SendHttpResponse> fetchStuckSpot(SendHttpRequest r1);
}
