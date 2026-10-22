package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class WeatherInfoResponseData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Result result;

    @SerializedName("server_time")
    public long serverTime;
    public String timezone;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public WeatherInfoResponseData() {
    }
}
