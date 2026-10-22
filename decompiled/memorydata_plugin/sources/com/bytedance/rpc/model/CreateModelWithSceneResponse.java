package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CreateModelWithSceneResponse implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ID")
    public Map<ModelListScene, Long> iD;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public CreateModelWithSceneResponse() {
    }
}
