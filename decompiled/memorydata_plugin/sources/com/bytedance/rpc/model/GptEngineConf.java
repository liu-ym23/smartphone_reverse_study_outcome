package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class GptEngineConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_param")
    public String abParam;

    @SerializedName("app_id")
    public String appId;
    public String cluster;
    public String runtime;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public GptEngineConf() {
    }
}
