package com.bytedance.rpc.model;

import com.bytedance.bdinstall.Api;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("access_type")
    public String accessType;
    public String channel;

    @SerializedName("device_brand")
    public String deviceBrand;

    @SerializedName("device_id")
    public long deviceId;

    @SerializedName("device_platform")
    public String devicePlatform;

    @SerializedName(Api.KEY_DEVICE_TYPE)
    public String deviceType;

    @SerializedName("os_version")
    public String osVersion;
    public String resolution;

    @SerializedName("update_version_code")
    public long updateVersionCode;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public DeviceInfo() {
    }
}
