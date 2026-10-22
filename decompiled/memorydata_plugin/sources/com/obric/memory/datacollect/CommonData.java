package com.obric.memory.datacollect;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class CommonData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String activityName;
    public String appName;
    public int dataId;
    public String description;
    public String eventName;
    public int eventType;
    public String extra;
    public String operateNodeInfo;
    public String packageName;
    public long timestamp;
    public String url;
    public int urlType;
    public String viewTreeTextInfo;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public CommonData() {
    }
}
