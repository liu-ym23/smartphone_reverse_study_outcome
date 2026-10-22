package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ProactiveAgentUserFeedbackReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("feedback_reason")
    public String feedbackReason;

    @SerializedName("feedback_source")
    public String feedbackSource;

    @SerializedName("feedback_text")
    public String feedbackText;

    @SerializedName("feedback_type")
    public int feedbackType;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("related_info")
    public String relatedInfo;

    @SerializedName("related_type")
    public int relatedType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ProactiveAgentUserFeedbackReq() {
    }
}
