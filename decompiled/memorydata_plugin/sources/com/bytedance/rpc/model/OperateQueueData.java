package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OperateQueueData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, String> resultMap;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OperateQueueData() {
    }
}
