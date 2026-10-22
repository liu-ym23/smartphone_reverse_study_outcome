package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ToolsCallRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("access_key")
    public String accessKey;
    public String arguments;

    @SerializedName("extra_info")
    public Map<String, String> extraInfo;

    @SerializedName("mcp_hub_app_id")
    public String mcpHubAppId;

    @SerializedName("mcp_server_name")
    public String mcpServerName;

    @SerializedName("mcp_server_names")
    public List<String> mcpServerNames;
    public String name;

    @SerializedName("search_common_info")
    public SearchCommon searchCommonInfo;

    @SerializedName("tool_id")
    public String toolId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ToolsCallRequest() {
    }
}
