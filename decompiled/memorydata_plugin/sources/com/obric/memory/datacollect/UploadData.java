package com.obric.memory.datacollect;

import com.bytedance.rpc.model.TTNetCommonParam;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UploadData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String appName;

    @SerializedName("common_param")
    public TTNetCommonParam commonParam;
    public String data;
    public int dataType;
    public String packageName;
    public UserParams userParams;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UploadData() {
    }
}
