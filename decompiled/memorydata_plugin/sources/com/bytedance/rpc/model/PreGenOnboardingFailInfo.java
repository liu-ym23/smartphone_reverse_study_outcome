package com.bytedance.rpc.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PreGenOnboardingFailInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("conversation_id")
    public long conversationId;

    @SerializedName(LocationMonitorConst.ERR_CODE)
    public int errCode;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PreGenOnboardingFailInfo() {
    }
}
