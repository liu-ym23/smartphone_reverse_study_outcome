package com.bytedance.obric.memory.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetAudioASRResultRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("task_ids")
    public List<String> taskIds;

    @SerializedName(Header.KEY_USER_ID)
    public String userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetAudioASRResultRequest() {
    }
}
