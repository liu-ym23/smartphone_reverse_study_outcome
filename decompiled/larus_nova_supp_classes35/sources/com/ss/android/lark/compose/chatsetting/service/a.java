package com.ss.android.lark.compose.chatsetting.service;

import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.pb.messages.GenLarkReportUrlRequest;
import com.ss.android.lark.pb.messages.GenLarkReportUrlResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    @ServerCall(900014)
    RucketJob<GenLarkReportUrlResponse> getReportUrl(GenLarkReportUrlRequest r1);
}
