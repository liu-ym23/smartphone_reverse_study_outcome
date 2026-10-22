package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateModelWithSceneRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("IconURL")
    public String iconURL;

    @SerializedName("ModelID")
    public long modelID;

    @SerializedName("OpEmployee")
    public String opEmployee;

    @SerializedName("Ranking")
    public int ranking;

    @SerializedName("Scene")
    public ModelListScene scene;

    @SerializedName("ShowName")
    public String showName;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UpdateModelWithSceneRequest() {
    }
}
