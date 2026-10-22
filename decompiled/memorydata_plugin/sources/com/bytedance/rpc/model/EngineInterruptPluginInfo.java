package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EngineInterruptPluginInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String lastChatBotReq;

    @SerializedName("prev_interrupt_msg_id")
    public long prevInterruptMsgId;

    @SerializedName("tool_info_list")
    public List<ToolCallInfo> toolInfoList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public EngineInterruptPluginInfo() {
    }
}
