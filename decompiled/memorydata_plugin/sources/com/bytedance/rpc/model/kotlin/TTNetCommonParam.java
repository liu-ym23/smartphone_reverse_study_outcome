package com.bytedance.rpc.model.kotlin;

import com.bytedance.bdinstall.Api;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@RpcFieldModify
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bj\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B±\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010g\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jº\u0002\u0010n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010sHÖ\u0003J\t\u0010t\u001a\u00020uHÖ\u0001J\t\u0010v\u001a\u00020\u0006HÖ\u0001R \u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R \u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R \u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b1\u0010+\"\u0004\b2\u0010-R \u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R \u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R \u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R \u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!R \u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001f\"\u0004\bB\u0010!R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bC\u0010+\"\u0004\bD\u0010-R \u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001f\"\u0004\bF\u0010!R \u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001f\"\u0004\bH\u0010!R \u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001f\"\u0004\bJ\u0010!R \u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001f\"\u0004\bL\u0010!R \u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001f\"\u0004\bN\u0010!R \u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001f\"\u0004\bP\u0010!R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001f\"\u0004\bR\u0010!R \u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001f\"\u0004\bT\u0010!¨\u0006w"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;", "Ljava/io/Serializable;", "iid", "", "aid", "deviceId", "", Api.KEY_AC, "versionCode", "deviceType", "appName", "channel", "liveSdkVersion", "osVersion", "devicePlatform", "vid", "idfa", "openudid", "abClient", Api.KEY_SSMIX, "idfv", "abFeature", "abVersion", "abGroup", Api.KEY_REGION, "sysRegion", "carrierRegion", "deviceBrand", "buildNumber", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAbClient", "()Ljava/lang/String;", "setAbClient", "(Ljava/lang/String;)V", "getAbFeature", "setAbFeature", "getAbGroup", "setAbGroup", "getAbVersion", "setAbVersion", "getAc", "setAc", "getAid", "()Ljava/lang/Long;", "setAid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAppName", "setAppName", "getBuildNumber", "setBuildNumber", "getCarrierRegion", "setCarrierRegion", "getChannel", "setChannel", "getDeviceBrand", "setDeviceBrand", "getDeviceId", "setDeviceId", "getDevicePlatform", "setDevicePlatform", "getDeviceType", "setDeviceType", "getIdfa", "setIdfa", "getIdfv", "setIdfv", "getIid", "setIid", "getLiveSdkVersion", "setLiveSdkVersion", "getOpenudid", "setOpenudid", "getOsVersion", "setOsVersion", "getRegion", "setRegion", "getSsmix", "setSsmix", "getSysRegion", "setSysRegion", "getVersionCode", "setVersionCode", "getVid", "setVid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;", "equals", "", "other", "", "hashCode", "", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class TTNetCommonParam implements Serializable {

    @SerializedName(Api.KEY_AB_CLIENT)
    private String abClient;

    @SerializedName(Api.KEY_AB_FEATURE)
    private String abFeature;

    @SerializedName(Api.KEY_AB_GROUP)
    private String abGroup;

    @SerializedName(Api.KEY_AB_VERSION)
    private String abVersion;

    @SerializedName(Api.KEY_AC)
    private String ac;

    @SerializedName("aid")
    private Long aid;

    @SerializedName(Api.KEY_APP_NAME)
    private String appName;

    @SerializedName("build_number")
    private Long buildNumber;

    @SerializedName("carrier_region")
    private String carrierRegion;

    @SerializedName("channel")
    private String channel;

    @SerializedName("device_brand")
    private String deviceBrand;

    @SerializedName("device_id")
    private String deviceId;

    @SerializedName("device_platform")
    private String devicePlatform;

    @SerializedName(Api.KEY_DEVICE_TYPE)
    private String deviceType;

    @SerializedName("idfa")
    private String idfa;

    @SerializedName("idfv")
    private String idfv;

    @SerializedName("iid")
    private Long iid;

    @SerializedName("live_sdk_version")
    private String liveSdkVersion;

    @SerializedName("openudid")
    private String openudid;

    @SerializedName("os_version")
    private String osVersion;

    @SerializedName(Api.KEY_REGION)
    private String region;

    @SerializedName(Api.KEY_SSMIX)
    private String ssmix;

    @SerializedName("sys_region")
    private String sysRegion;

    @SerializedName("version_code")
    private String versionCode;

    @SerializedName("vid")
    private String vid;

    public TTNetCommonParam() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
    }

    public TTNetCommonParam(Long r3, Long r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, Long r27) {
        this.iid = r3;
        this.aid = r4;
        this.deviceId = r5;
        this.ac = r6;
        this.versionCode = r7;
        this.deviceType = r8;
        this.appName = r9;
        this.channel = r10;
        this.liveSdkVersion = r11;
        this.osVersion = r12;
        this.devicePlatform = r13;
        this.vid = r14;
        this.idfa = r15;
        this.openudid = r16;
        this.abClient = r17;
        this.ssmix = r18;
        this.idfv = r19;
        this.abFeature = r20;
        this.abVersion = r21;
        this.abGroup = r22;
        this.region = r23;
        this.sysRegion = r24;
        this.carrierRegion = r25;
        this.deviceBrand = r26;
        this.buildNumber = r27;
    }

    public /* synthetic */ TTNetCommonParam(Long r18, Long r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, Long r42, int r43, DefaultConstructorMarker r44) {
        if ((r43 & 1) == 0) goto L5;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
    L7:
        if ((r43 & 2) == 0) goto L9;
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
    L11:
        if ((r43 & 4) == 0) goto L13;
        String r5 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L15:
        if ((r43 & 8) == 0) goto L17;
        String r6 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L19:
        if ((r43 & 16) == 0) goto L21;
        String r7 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L23:
        if ((r43 & 32) == 0) goto L25;
        String r8 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L27:
        if ((r43 & 64) == 0) goto L29;
        String r9 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L31:
        if ((r43 & 128) == 0) goto L33;
        String r10 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L35:
        if ((r43 & 256) == 0) goto L37;
        String r11 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L39:
        if ((r43 & 512) == 0) goto L41;
        String r12 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L43:
        if ((r43 & 1024) == 0) goto L45;
        String r13 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L47:
        if ((r43 & 2048) == 0) goto L49;
        String r14 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L51:
        if ((r43 & 4096) == 0) goto L53;
        String r15 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L55:
        if ((r43 & 8192) == 0) goto L57;
        String r3 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L59:
        if ((r43 & 16384) == 0) goto L61;
        Object r16 = null;
        String r17 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L62:
        String r310 = r17;
        if ((r43 & 32768) == 0) goto L65;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L66:
        String r311 = r110;
        if ((r43 & 65536) == 0) goto L69;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L70:
        String r312 = r111;
        if ((r43 & 131072) == 0) goto L73;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L74:
        String r313 = r112;
        if ((r43 & 262144) == 0) goto L77;
        String r113 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L78:
        String r314 = r113;
        if ((r43 & 524288) == 0) goto L81;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L82:
        String r315 = r114;
        if ((r43 & 1048576) == 0) goto L85;
        String r115 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L86:
        String r316 = r115;
        if ((r43 & 2097152) == 0) goto L89;
        String r116 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L90:
        String r317 = r116;
        if ((r43 & 4194304) == 0) goto L93;
        String r117 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L94:
        String r45 = r117;
        if ((r43 & 8388608) == 0) goto L97;
        String r118 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L99:
        if ((r43 & 16777216) == 0) goto L101;
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(r16, Long.class, "com.obric.memorydata.plugin");
    L102:
        this(r1, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3, r310, r311, r312, r313, r314, r315, r316, r317, r45, r118, r0);
        return;
    L101:
        r0 = r42;
        goto L102
    L97:
        r118 = r41;
        goto L99
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = null;
        r17 = r32;
        goto L62
    L57:
        r3 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }

    public static /* synthetic */ TTNetCommonParam copy$default(TTNetCommonParam r17, Long r18, Long r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, Long r42, int r43, Object r44) {
        if ((r43 & 1) == 0) goto L5;
        Long r2 = r17.iid;
    L7:
        if ((r43 & 2) == 0) goto L9;
        Long r3 = r17.aid;
    L11:
        if ((r43 & 4) == 0) goto L13;
        String r4 = r17.deviceId;
    L15:
        if ((r43 & 8) == 0) goto L17;
        String r5 = r17.ac;
    L19:
        if ((r43 & 16) == 0) goto L21;
        String r6 = r17.versionCode;
    L23:
        if ((r43 & 32) == 0) goto L25;
        String r7 = r17.deviceType;
    L27:
        if ((r43 & 64) == 0) goto L29;
        String r8 = r17.appName;
    L31:
        if ((r43 & 128) == 0) goto L33;
        String r9 = r17.channel;
    L35:
        if ((r43 & 256) == 0) goto L37;
        String r10 = r17.liveSdkVersion;
    L39:
        if ((r43 & 512) == 0) goto L41;
        String r11 = r17.osVersion;
    L43:
        if ((r43 & 1024) == 0) goto L45;
        String r12 = r17.devicePlatform;
    L47:
        if ((r43 & 2048) == 0) goto L49;
        String r13 = r17.vid;
    L51:
        if ((r43 & 4096) == 0) goto L53;
        String r14 = r17.idfa;
    L55:
        if ((r43 & 8192) == 0) goto L57;
        String r15 = r17.openudid;
    L58:
        String r310 = r15;
        if ((r43 & 16384) == 0) goto L61;
        String r16 = r17.abClient;
    L62:
        String r311 = r16;
        if ((r43 & 32768) == 0) goto L65;
        String r110 = r17.ssmix;
    L66:
        String r312 = r110;
        if ((r43 & 65536) == 0) goto L69;
        String r111 = r17.idfv;
    L70:
        String r313 = r111;
        if ((r43 & 131072) == 0) goto L73;
        String r112 = r17.abFeature;
    L74:
        String r314 = r112;
        if ((r43 & 262144) == 0) goto L77;
        String r113 = r17.abVersion;
    L78:
        String r315 = r113;
        if ((r43 & 524288) == 0) goto L81;
        String r114 = r17.abGroup;
    L82:
        String r316 = r114;
        if ((r43 & 1048576) == 0) goto L85;
        String r115 = r17.region;
    L86:
        String r317 = r115;
        if ((r43 & 2097152) == 0) goto L89;
        String r116 = r17.sysRegion;
    L90:
        String r318 = r116;
        if ((r43 & 4194304) == 0) goto L93;
        String r117 = r17.carrierRegion;
    L94:
        String r45 = r117;
        if ((r43 & 8388608) == 0) goto L97;
        String r118 = r17.deviceBrand;
    L99:
        if ((r43 & 16777216) == 0) goto L101;
        Long r1 = r17.buildNumber;
    L103:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r45, r118, r1);
    L101:
        r1 = r42;
        goto L103
    L97:
        r118 = r41;
        goto L99
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Long component1() {
        return this.iid;
    }

    public final String component10() {
        return this.osVersion;
    }

    public final String component11() {
        return this.devicePlatform;
    }

    public final String component12() {
        return this.vid;
    }

    public final String component13() {
        return this.idfa;
    }

    public final String component14() {
        return this.openudid;
    }

    public final String component15() {
        return this.abClient;
    }

    public final String component16() {
        return this.ssmix;
    }

    public final String component17() {
        return this.idfv;
    }

    public final String component18() {
        return this.abFeature;
    }

    public final String component19() {
        return this.abVersion;
    }

    public final Long component2() {
        return this.aid;
    }

    public final String component20() {
        return this.abGroup;
    }

    public final String component21() {
        return this.region;
    }

    public final String component22() {
        return this.sysRegion;
    }

    public final String component23() {
        return this.carrierRegion;
    }

    public final String component24() {
        return this.deviceBrand;
    }

    public final Long component25() {
        return this.buildNumber;
    }

    public final String component3() {
        return this.deviceId;
    }

    public final String component4() {
        return this.ac;
    }

    public final String component5() {
        return this.versionCode;
    }

    public final String component6() {
        return this.deviceType;
    }

    public final String component7() {
        return this.appName;
    }

    public final String component8() {
        return this.channel;
    }

    public final String component9() {
        return this.liveSdkVersion;
    }

    public final TTNetCommonParam copy(Long r28, Long r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, Long r52) {
        return new TTNetCommonParam(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, TTNetCommonParam.class) == false) goto L57;
        TTNetCommonParam r4 = (TTNetCommonParam) ZeusTransformUtils.preCheckCast(r3, TTNetCommonParam.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.iid, r4.iid) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.aid, r4.aid) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.deviceId, r4.deviceId) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.ac, r4.ac) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.versionCode, r4.versionCode) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.deviceType, r4.deviceType) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.appName, r4.appName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.channel, r4.channel) == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.liveSdkVersion, r4.liveSdkVersion) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.osVersion, r4.osVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.devicePlatform, r4.devicePlatform) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.vid, r4.vid) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.idfa, r4.idfa) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.openudid, r4.openudid) == true) goto L35;
        return false;
    L35:
        if (Intrinsics.areEqual(this.abClient, r4.abClient) == true) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(this.ssmix, r4.ssmix) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.idfv, r4.idfv) == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.abFeature, r4.abFeature) == true) goto L43;
        return false;
    L43:
        if (Intrinsics.areEqual(this.abVersion, r4.abVersion) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.abGroup, r4.abGroup) == true) goto L47;
        return false;
    L47:
        if (Intrinsics.areEqual(this.region, r4.region) == true) goto L49;
        return false;
    L49:
        if (Intrinsics.areEqual(this.sysRegion, r4.sysRegion) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.carrierRegion, r4.carrierRegion) == true) goto L53;
        return false;
    L53:
        if (Intrinsics.areEqual(this.deviceBrand, r4.deviceBrand) == true) goto L55;
        return false;
    L55:
        if (Intrinsics.areEqual(this.buildNumber, r4.buildNumber) == true) goto L86;
        return false;
    L86:
        return true;
    L57:
        return false;
    }

    public final String getAbClient() {
        return this.abClient;
    }

    public final String getAbFeature() {
        return this.abFeature;
    }

    public final String getAbGroup() {
        return this.abGroup;
    }

    public final String getAbVersion() {
        return this.abVersion;
    }

    public final String getAc() {
        return this.ac;
    }

    public final Long getAid() {
        return this.aid;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Long getBuildNumber() {
        return this.buildNumber;
    }

    public final String getCarrierRegion() {
        return this.carrierRegion;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getDeviceBrand() {
        return this.deviceBrand;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDevicePlatform() {
        return this.devicePlatform;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getIdfa() {
        return this.idfa;
    }

    public final String getIdfv() {
        return this.idfv;
    }

    public final Long getIid() {
        return this.iid;
    }

    public final String getLiveSdkVersion() {
        return this.liveSdkVersion;
    }

    public final String getOpenudid() {
        return this.openudid;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getSsmix() {
        return this.ssmix;
    }

    public final String getSysRegion() {
        return this.sysRegion;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public final String getVid() {
        return this.vid;
    }

    public int hashCode() {
        Long r0 = this.iid;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.aid;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.deviceId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.ac;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.versionCode;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.deviceType;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.appName;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.channel;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.liveSdkVersion;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.osVersion;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.devicePlatform;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.vid;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.idfa;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.openudid;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.abClient;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.ssmix;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.idfv;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.abFeature;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.abVersion;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.abGroup;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        String r61 = this.region;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.sysRegion;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        String r67 = this.carrierRegion;
        if (r67 == null) goto L93;
        int r68 = r67.hashCode();
    L94:
        int r69 = (r66 + r68) * 31;
        String r70 = this.deviceBrand;
        if (r70 == null) goto L97;
        int r71 = r70.hashCode();
    L98:
        int r72 = (r69 + r71) * 31;
        Long r73 = this.buildNumber;
        if (r73 == null) goto L102;
        r1 = r73.hashCode();
    L102:
        return r72 + r1;
    L97:
        r71 = 0;
        goto L98
    L93:
        r68 = 0;
        goto L94
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void setAbClient(String r1) {
        this.abClient = r1;
    }

    public final void setAbFeature(String r1) {
        this.abFeature = r1;
    }

    public final void setAbGroup(String r1) {
        this.abGroup = r1;
    }

    public final void setAbVersion(String r1) {
        this.abVersion = r1;
    }

    public final void setAc(String r1) {
        this.ac = r1;
    }

    public final void setAid(Long r1) {
        this.aid = r1;
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final void setBuildNumber(Long r1) {
        this.buildNumber = r1;
    }

    public final void setCarrierRegion(String r1) {
        this.carrierRegion = r1;
    }

    public final void setChannel(String r1) {
        this.channel = r1;
    }

    public final void setDeviceBrand(String r1) {
        this.deviceBrand = r1;
    }

    public final void setDeviceId(String r1) {
        this.deviceId = r1;
    }

    public final void setDevicePlatform(String r1) {
        this.devicePlatform = r1;
    }

    public final void setDeviceType(String r1) {
        this.deviceType = r1;
    }

    public final void setIdfa(String r1) {
        this.idfa = r1;
    }

    public final void setIdfv(String r1) {
        this.idfv = r1;
    }

    public final void setIid(Long r1) {
        this.iid = r1;
    }

    public final void setLiveSdkVersion(String r1) {
        this.liveSdkVersion = r1;
    }

    public final void setOpenudid(String r1) {
        this.openudid = r1;
    }

    public final void setOsVersion(String r1) {
        this.osVersion = r1;
    }

    public final void setRegion(String r1) {
        this.region = r1;
    }

    public final void setSsmix(String r1) {
        this.ssmix = r1;
    }

    public final void setSysRegion(String r1) {
        this.sysRegion = r1;
    }

    public final void setVersionCode(String r1) {
        this.versionCode = r1;
    }

    public final void setVid(String r1) {
        this.vid = r1;
    }

    public String toString() {
        return "TTNetCommonParam(iid=" + this.iid + ", aid=" + this.aid + ", deviceId=" + this.deviceId + ", ac=" + this.ac + ", versionCode=" + this.versionCode + ", deviceType=" + this.deviceType + ", appName=" + this.appName + ", channel=" + this.channel + ", liveSdkVersion=" + this.liveSdkVersion + ", osVersion=" + this.osVersion + ", devicePlatform=" + this.devicePlatform + ", vid=" + this.vid + ", idfa=" + this.idfa + ", openudid=" + this.openudid + ", abClient=" + this.abClient + ", ssmix=" + this.ssmix + ", idfv=" + this.idfv + ", abFeature=" + this.abFeature + ", abVersion=" + this.abVersion + ", abGroup=" + this.abGroup + ", region=" + this.region + ", sysRegion=" + this.sysRegion + ", carrierRegion=" + this.carrierRegion + ", deviceBrand=" + this.deviceBrand + ", buildNumber=" + this.buildNumber + ")";
    }
}
