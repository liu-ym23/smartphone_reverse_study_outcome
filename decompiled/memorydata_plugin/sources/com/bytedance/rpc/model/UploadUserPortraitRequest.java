package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UploadUserPortraitRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("app_id")
    public String appId;
    public Map<String, String> extra;
    public List<Portrait> portraits;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UploadUserPortraitRequest() {
    }
}
