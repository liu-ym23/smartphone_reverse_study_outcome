package com.bytedance.rpc.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MaasConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(LocationMonitorConst.API_VERSION)
    public String apiVersion;
    public MaasAuthConf auth;

    @SerializedName("endpoint_create_time")
    public long endpointCreateTime;

    @SerializedName("endpoint_name")
    public String endpointName;
    public Map<String, String> extra;
    public List<String> plugins;

    @SerializedName("using_stream")
    public boolean usingStream;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MaasConf() {
    }
}
