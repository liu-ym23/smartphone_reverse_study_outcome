package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MockFunctionCallResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long code;
    public String content;
    public String entities;
    public Map<String, String> extra;

    @SerializedName("session_id")
    public String sessionId;

    @SerializedName("structured_content")
    public String structuredContent;

    @SerializedName(Header.KEY_USER_ID)
    public String userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MockFunctionCallResponse() {
    }
}
