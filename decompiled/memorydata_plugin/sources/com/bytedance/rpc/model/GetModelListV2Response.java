package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GetModelListV2Response implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ModelList")
    public List<ModelDesc> modelList;

    @SerializedName("ModelMap")
    public Map<Long, ModelDesc> modelMap;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetModelListV2Response() {
    }
}
