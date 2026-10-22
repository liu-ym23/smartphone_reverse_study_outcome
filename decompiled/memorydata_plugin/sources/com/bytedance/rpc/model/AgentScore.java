package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AgentScore implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("AgentId")
    public long agentId;

    @SerializedName("Score")
    public double score;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public AgentScore() {
    }
}
