package com.bytedance.obric.memory.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class Head implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("Accept")
    public String accept;

    @SerializedName("AppId")
    public long appId;

    @SerializedName("AppVersion")
    public String appVersion;

    @SerializedName("Architecture")
    public String architecture;

    @SerializedName("DeviceId")
    public long deviceId;

    @SerializedName("Lang")
    public String lang;

    @SerializedName(ExifInterface.TAG_MODEL)
    public String model;

    @SerializedName("Network")
    public String network;

    @SerializedName("OsVersionCode")
    public int osVersionCode;

    @SerializedName("OsVersionName")
    public String osVersionName;

    @SerializedName("SN")
    public String sN;

    @SerializedName("Terminal")
    public String terminal;

    @SerializedName("UdId")
    public String udId;

    @SerializedName("UserId")
    public long userId;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    @SerializedName("Vendor")
    public String f2967vendor;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Head() {
    }
}
