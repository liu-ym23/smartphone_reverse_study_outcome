package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GetModelListWithSceneRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("HasDeleteModel")
    public boolean hasDeleteModel;

    @SerializedName("ModelName")
    public String modelName;

    @SerializedName("Scene")
    public ModelListScene scene;

    @SerializedName("WithMaster")
    public boolean withMaster;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GetModelListWithSceneRequest() {
    }
}
