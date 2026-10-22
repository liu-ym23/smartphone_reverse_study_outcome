package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryBizData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("last_round_user_operation_text")
    public String lastRoundUserOperationText;

    @SerializedName("recent_user_memory")
    public String recentUserMemory;

    @SerializedName("recent_user_profile")
    public String recentUserProfile;

    @SerializedName("user_operation")
    public String userOperation;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MemoryBizData() {
    }
}
