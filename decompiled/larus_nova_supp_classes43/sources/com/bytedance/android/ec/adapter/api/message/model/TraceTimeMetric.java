package com.bytedance.android.ec.adapter.api.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@ProtoMessage("webcast.im.TraceTimeMetric")
public class TraceTimeMetric {

    @SerializedName("consumer_duration")
    public long consumerDuration;

    @SerializedName("msg_send_timestamp")
    public long msgSendTimestamp;

    @SerializedName("op_timestamp")
    public long opTimestamp;

    @SerializedName("producer_duration")
    public long producerDuration;

    public TraceTimeMetric() {
    }
}
