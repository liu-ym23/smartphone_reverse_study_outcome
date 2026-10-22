package com.ss.android.lark.chat.api.service.track.sample;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReadSampleReportConfig implements Serializable {

    @JSONField(name = "max_chat_member_count")
    public Integer maxChatMemberCount;

    @JSONField(name = "read_count_lower_threshold")
    public Integer readCountLowerThreshold;

    @JSONField(name = "read_count_upper_fact")
    public Float readCountUpperFact;

    @JSONField(name = "report_time_internal_ms")
    public Long reportTimeIntervalInMs;

    @JSONField(name = "steady_state_period_s")
    public Long steadyStatePeriodInSeconds;

    @JSONField(name = "sync_msg_dep_latency_ms")
    public Long syncMsgDepLatencyInMs;

    public ReadSampleReportConfig() {
        this.reportTimeIntervalInMs = 0L;
        this.steadyStatePeriodInSeconds = 0L;
        this.maxChatMemberCount = 0;
        this.readCountLowerThreshold = 0;
        this.readCountUpperFact = Float.valueOf(1.0f);
        this.syncMsgDepLatencyInMs = 0L;
    }

    public ReadSampleReportConfig(Long r1, Long r2, Integer r3, Integer r4, Float r5, Long r6) {
        this.reportTimeIntervalInMs = r1;
        this.steadyStatePeriodInSeconds = r2;
        this.maxChatMemberCount = r3;
        this.readCountLowerThreshold = r4;
        this.readCountUpperFact = r5;
        this.syncMsgDepLatencyInMs = r6;
    }
}
