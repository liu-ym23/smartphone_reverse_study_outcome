package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteModelWithSceneRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ModelID")
    public long modelID;

    @SerializedName("OpEmployee")
    public String opEmployee;

    @SerializedName("Scene")
    public ModelListScene scene;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public DeleteModelWithSceneRequest() {
    }
}
