package com.bytedance.obric.memory.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PushEvaluationNotifyRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String arguments;

    @SerializedName("fail_reason")
    public String failReason;

    @SerializedName("Head")
    public Head head;

    @SerializedName(LocationMonitorConst.IS_SUCCESS)
    public boolean isSuccess;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PushEvaluationNotifyRequest() {
    }
}
