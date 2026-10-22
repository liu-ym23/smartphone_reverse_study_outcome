package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MockCallResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public long code;
    public String content;
    public String entities;
    public Map<String, String> extra;

    @SerializedName("structured_content")
    public String structuredContent;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MockCallResponse() {
    }
}
