package com.ss.android.lark.chat.api.service.track.sample;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReactionSampleReportConfig implements Serializable {

    @JSONField(name = "max_chat_member_count")
    public Integer maxChatMemberCount;

    @JSONField(name = "quantile_count")
    public Integer quantileCount;

    @JSONField(name = "report_time_internal_ms")
    public Long reportTimeIntervalInMs;

    @JSONField(name = "steady_state_period_s")
    public Long steadyStatePeriodInSeconds;

    @JSONField(name = "sync_msg_dep_latency_ms")
    public Long syncMsgDepLatencyInMs;

    public ReactionSampleReportConfig() {
        this.reportTimeIntervalInMs = 0L;
        this.steadyStatePeriodInSeconds = 0L;
        this.maxChatMemberCount = 0;
        this.quantileCount = 0;
        this.syncMsgDepLatencyInMs = 0L;
    }

    public ReactionSampleReportConfig(Long r1, Long r2, Integer r3, Integer r4, Long r5) {
        this.reportTimeIntervalInMs = r1;
        this.steadyStatePeriodInSeconds = r2;
        this.maxChatMemberCount = r3;
        this.quantileCount = r4;
        this.syncMsgDepLatencyInMs = r5;
    }
}
