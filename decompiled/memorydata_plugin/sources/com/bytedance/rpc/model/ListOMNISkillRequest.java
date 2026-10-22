package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ListOMNISkillRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> ext;

    @SerializedName("include_disabled")
    public boolean includeDisabled;
    public String query;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ListOMNISkillRequest() {
    }
}
