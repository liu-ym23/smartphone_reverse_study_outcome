package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ToolsAuthInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("exempt_tools_auth")
    public boolean exemptToolsAuth;

    @SerializedName("tool_auth_list")
    public List<ToolAuth> toolAuthList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolsAuthInfo() {
    }
}
