package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PreGenReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("answer_finish")
    public boolean answerFinish;

    @SerializedName("max_new_tokens")
    public int maxNewTokens;

    @SerializedName("pre_query_fragment")
    public String preQueryFragment;

    @SerializedName("protocol_version")
    public int protocolVersion;

    @SerializedName("psession_id")
    public long psessionId;
    public PreGenType type;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PreGenReq() {
    }
}
