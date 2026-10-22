package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreGenFirstMetOnboardingRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bot_id_list")
    public List<Long> botIdList;
    public long count;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PreGenFirstMetOnboardingRequest() {
    }
}
