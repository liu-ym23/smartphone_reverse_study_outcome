package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ActionParameters implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Content")
    public String content;

    @SerializedName("Package")
    public String mPackage;

    @SerializedName("OperationId")
    public String operationId;

    @SerializedName("Params")
    public String params;

    @SerializedName("Version")
    public int version;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ActionParameters() {
    }
}
