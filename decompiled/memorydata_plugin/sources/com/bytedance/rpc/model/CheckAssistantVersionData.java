package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CheckAssistantVersionData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("is_rom_compatible")
    public boolean isRomCompatible;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public CheckAssistantVersionData() {
    }
}
