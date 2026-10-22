package com.bytedance.android.ec.adapter.api.messagev2.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@ProtoMessage("webcast.im.TraceTimeMetricV2")
public class TraceTimeMetricV2 {

    @SerializedName("consumer_duration")
    long consumerDuration;

    @SerializedName("msg_send_timestamp")
    long msgSendTimestamp;

    @SerializedName("op_timestamp")
    long opTimestamp;

    @SerializedName("producer_duration")
    long producerDuration;

    public TraceTimeMetricV2() {
    }

    public long getConsumerDuration() {
        return this.consumerDuration;
    }

    public long getMsgSendTimestamp() {
        return this.msgSendTimestamp;
    }

    public long getOpTimestamp() {
        return this.opTimestamp;
    }

    public long getProducerDuration() {
        return this.producerDuration;
    }

    public TraceTimeMetricV2(long r1, long r10, long r11, long r12) {
        this.opTimestamp = r1;
        this.producerDuration = r10;
        this.consumerDuration = r11;
        this.msgSendTimestamp = r12;
    }
}
