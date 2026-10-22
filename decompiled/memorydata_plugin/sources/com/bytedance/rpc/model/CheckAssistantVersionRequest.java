package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CheckAssistantVersionRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("assistant_app_version_code")
    public String assistantAppVersionCode;

    @SerializedName("assistant_update_version_code")
    public String assistantUpdateVersionCode;

    @SerializedName("os_version")
    public String osVersion;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public CheckAssistantVersionRequest() {
    }
}
