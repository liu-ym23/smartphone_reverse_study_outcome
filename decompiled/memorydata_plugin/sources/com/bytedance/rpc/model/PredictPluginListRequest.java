package com.bytedance.rpc.model;

import com.bytedance.crash.entity.Header;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PredictPluginListRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("bot_id")
    public long botId;

    @SerializedName("bot_prompt")
    public String botPrompt;

    @SerializedName("existed_plugins")
    public List<PluginInfo> existedPlugins;

    @SerializedName("is_public")
    public boolean isPublic;

    @SerializedName("plugin_type")
    public List<Long> pluginType;

    @SerializedName("space_id")
    public long spaceId;

    @SerializedName(Header.KEY_USER_ID)
    public long userId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PredictPluginListRequest() {
    }
}
