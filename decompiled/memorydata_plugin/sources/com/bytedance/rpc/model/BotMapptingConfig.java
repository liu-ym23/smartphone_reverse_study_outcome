package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class BotMapptingConfig implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("target_bot_id")
    public long targetBotId;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public BotMapptingConfig() {
    }
}
