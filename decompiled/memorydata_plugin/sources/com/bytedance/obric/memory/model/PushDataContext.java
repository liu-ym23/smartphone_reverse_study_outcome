package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PushDataContext implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String appName;
    public long currentTs;
    public double latitude;
    public String location;
    public double longitude;
    public String zone;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PushDataContext() {
    }
}
