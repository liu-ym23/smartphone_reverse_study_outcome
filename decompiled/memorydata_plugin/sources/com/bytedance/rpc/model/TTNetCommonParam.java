package com.bytedance.rpc.model;

import com.bytedance.bdinstall.Api;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@RpcFieldModify
public class TTNetCommonParam implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName(Api.KEY_AB_CLIENT)
    @RpcField(FieldType.QUERY)
    public String abClient;

    @SerializedName(Api.KEY_AB_FEATURE)
    @RpcField(FieldType.QUERY)
    public String abFeature;

    @SerializedName(Api.KEY_AB_GROUP)
    @RpcField(FieldType.QUERY)
    public String abGroup;

    @SerializedName(Api.KEY_AB_VERSION)
    @RpcField(FieldType.QUERY)
    public String abVersion;

    @RpcField(FieldType.QUERY)
    public String ac;

    @RpcField(FieldType.QUERY)
    public long aid;

    @SerializedName(Api.KEY_APP_NAME)
    @RpcField(FieldType.QUERY)
    public String appName;

    @SerializedName("build_number")
    @RpcField(FieldType.QUERY)
    public long buildNumber;

    @SerializedName("carrier_region")
    @RpcField(FieldType.QUERY)
    public String carrierRegion;

    @RpcField(FieldType.QUERY)
    public String channel;

    @SerializedName("device_brand")
    @RpcField(FieldType.QUERY)
    public String deviceBrand;

    @SerializedName("device_id")
    @RpcField(FieldType.QUERY)
    public String deviceId;

    @SerializedName("device_platform")
    @RpcField(FieldType.QUERY)
    public String devicePlatform;

    @SerializedName(Api.KEY_DEVICE_TYPE)
    @RpcField(FieldType.QUERY)
    public String deviceType;

    @RpcField(FieldType.QUERY)
    public String idfa;

    @RpcField(FieldType.QUERY)
    public String idfv;

    @RpcField(FieldType.QUERY)
    public long iid;

    @SerializedName("live_sdk_version")
    @RpcField(FieldType.QUERY)
    public String liveSdkVersion;

    @RpcField(FieldType.QUERY)
    public String openudid;

    @SerializedName("os_version")
    @RpcField(FieldType.QUERY)
    public String osVersion;

    @RpcField(FieldType.QUERY)
    public String region;

    @RpcField(FieldType.QUERY)
    public String ssmix;

    @SerializedName("sys_region")
    @RpcField(FieldType.QUERY)
    public String sysRegion;

    @SerializedName("version_code")
    @RpcField(FieldType.QUERY)
    public String versionCode;

    @RpcField(FieldType.QUERY)
    public String vid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public TTNetCommonParam() {
    }
}
