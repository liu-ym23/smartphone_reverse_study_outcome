package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MPparams implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_parameters")
    public String actionParameters;
    public Map<String, String> ext;
    public long id;

    @SerializedName("question_id")
    public long questionId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MPparams() {
    }
}
