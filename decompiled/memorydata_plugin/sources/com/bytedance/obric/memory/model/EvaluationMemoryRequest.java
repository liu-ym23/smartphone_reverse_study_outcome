package com.bytedance.obric.memory.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class EvaluationMemoryRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String arguments;
    public Map<String, String> params;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public EvaluationMemoryRequest() {
    }
}
