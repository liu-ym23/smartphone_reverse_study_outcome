package com.bytedance.rpc.model;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ReplyItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("affect_stability")
    public boolean affectStability;
    public CopilotContent content;

    @SerializedName(LocationMonitorConst.ERR_CODE)
    public int errCode;

    @SerializedName(InfoRequestQPSOptTraceLogger.ERROR_MESSAGE)
    public String errorMessage;

    @SerializedName("is_finish")
    public boolean isFinish;

    @SerializedName("is_from_cache")
    public boolean isFromCache;

    @SerializedName("llm_token")
    public LlmToken llmToken;

    @SerializedName("next_key")
    public String nextKey;

    @SerializedName("not_show_text")
    public boolean notShowText;

    @SerializedName("reply_type")
    public ReplyType replyType;

    @SerializedName("reset_content")
    public boolean resetContent;

    @SerializedName("risk_information")
    public RiskInformation riskInformation;

    @SerializedName("stream_idx")
    public long streamIdx;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ReplyItem() {
    }
}
