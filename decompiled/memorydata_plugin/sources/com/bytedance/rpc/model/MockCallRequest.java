package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MockCallRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String arguments;

    @SerializedName("data_require")
    public String dataRequire;
    public String entities;

    @SerializedName("function_name")
    public String functionName;
    public List<MessageLLM> messages;
    public Metadata metadata;

    @SerializedName("mock_source")
    public String mockSource;

    @SerializedName("mock_task")
    public String mockTask;

    @SerializedName("mock_version")
    public String mockVersion;

    @SerializedName("mock_way")
    public String mockWay;

    @SerializedName("session_state")
    public String sessionState;
    public String tools;

    @SerializedName("turn_idx")
    public long turnIdx;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MockCallRequest() {
    }
}
