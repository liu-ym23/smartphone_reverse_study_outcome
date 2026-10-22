package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GetModelListV2Request implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ModelName")
    public String modelName;

    @SerializedName("Status")
    public List<ModelStatus> status;

    @SerializedName("WithMaster")
    public boolean withMaster;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetModelListV2Request() {
    }
}
