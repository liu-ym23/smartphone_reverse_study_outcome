package com.obric.memory.datacollect.kotlin;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u0007HÆ\u0001J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0003HÖ\u0001J\t\u0010I\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001e\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001e\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001e\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001e\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017¨\u0006J"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/CommonData;", "Ljava/io/Serializable;", "dataId", "", "timestamp", "", "url", "", "urlType", "Lcom/obric/memory/datacollect/kotlin/UrlType;", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "viewTreeTextInfo", "eventType", "eventName", "operateNodeInfo", "description", WsConstants.KEY_EXTRA, "(IJLjava/lang/String;Lcom/obric/memory/datacollect/kotlin/UrlType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getAppName", "setAppName", "getDataId", "()I", "setDataId", "(I)V", "getDescription", "setDescription", "getEventName", "setEventName", "getEventType", "setEventType", "getExtra", "setExtra", "getOperateNodeInfo", "setOperateNodeInfo", "getPackageName", "setPackageName", "getTimestamp", "()J", "setTimestamp", "(J)V", "getUrl", "setUrl", "getUrlType", "()Lcom/obric/memory/datacollect/kotlin/UrlType;", "setUrlType", "(Lcom/obric/memory/datacollect/kotlin/UrlType;)V", "getViewTreeTextInfo", "setViewTreeTextInfo", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class CommonData implements Serializable {

    @SerializedName("activityName")
    private String activityName;

    @SerializedName("appName")
    private String appName;

    @SerializedName("dataId")
    private int dataId;

    @SerializedName("description")
    private String description;

    @SerializedName("eventName")
    private String eventName;

    @SerializedName("eventType")
    private int eventType;

    @SerializedName(WsConstants.KEY_EXTRA)
    private String extra;

    @SerializedName("operateNodeInfo")
    private String operateNodeInfo;

    @SerializedName(ObricMemoryConstants.KEY_PACKAGE_NAME)
    private String packageName;

    @SerializedName("timestamp")
    private long timestamp;

    @SerializedName("url")
    private String url;

    @SerializedName("urlType")
    private UrlType urlType;

    @SerializedName("viewTreeTextInfo")
    private String viewTreeTextInfo;

    public CommonData(int r2, long r3, String r5, UrlType r6, String r7, String r8, String r9, String r10, int r11, String r12, String r13, String r14, String r15) {
        Intrinsics.checkParameterIsNotNull(r5, "url");
        Intrinsics.checkParameterIsNotNull(r6, "urlType");
        Intrinsics.checkParameterIsNotNull(r7, "appName");
        Intrinsics.checkParameterIsNotNull(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkParameterIsNotNull(r9, "activityName");
        Intrinsics.checkParameterIsNotNull(r10, "viewTreeTextInfo");
        Intrinsics.checkParameterIsNotNull(r12, "eventName");
        Intrinsics.checkParameterIsNotNull(r13, "operateNodeInfo");
        Intrinsics.checkParameterIsNotNull(r14, "description");
        Intrinsics.checkParameterIsNotNull(r15, WsConstants.KEY_EXTRA);
        this.dataId = r2;
        this.timestamp = r3;
        this.url = r5;
        this.urlType = r6;
        this.appName = r7;
        this.packageName = r8;
        this.activityName = r9;
        this.viewTreeTextInfo = r10;
        this.eventType = r11;
        this.eventName = r12;
        this.operateNodeInfo = r13;
        this.description = r14;
        this.extra = r15;
    }

    public static /* synthetic */ CommonData copy$default(CommonData r15, int r16, long r17, String r19, UrlType r20, String r21, String r22, String r23, String r24, int r25, String r26, String r27, String r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        int r2 = r15.dataId;
    L7:
        if ((r30 & 2) == 0) goto L9;
        long r3 = r15.timestamp;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r5 = r15.url;
    L15:
        if ((r30 & 8) == 0) goto L17;
        UrlType r6 = r15.urlType;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r7 = r15.appName;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r8 = r15.packageName;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r9 = r15.activityName;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r10 = r15.viewTreeTextInfo;
    L35:
        if ((r30 & 256) == 0) goto L37;
        int r11 = r15.eventType;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r12 = r15.eventName;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r13 = r15.operateNodeInfo;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r14 = r15.description;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r1 = r15.extra;
    L55:
        return r15.copy(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L53:
        r1 = r29;
        goto L55
    L49:
        r14 = r28;
        goto L51
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final int component1() {
        return this.dataId;
    }

    public final String component10() {
        return this.eventName;
    }

    public final String component11() {
        return this.operateNodeInfo;
    }

    public final String component12() {
        return this.description;
    }

    public final String component13() {
        return this.extra;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.url;
    }

    public final UrlType component4() {
        return this.urlType;
    }

    public final String component5() {
        return this.appName;
    }

    public final String component6() {
        return this.packageName;
    }

    public final String component7() {
        return this.activityName;
    }

    public final String component8() {
        return this.viewTreeTextInfo;
    }

    public final int component9() {
        return this.eventType;
    }

    public final CommonData copy(int r17, long r18, String r20, UrlType r21, String r22, String r23, String r24, String r25, int r26, String r27, String r28, String r29, String r30) {
        Intrinsics.checkParameterIsNotNull(r20, "url");
        Intrinsics.checkParameterIsNotNull(r21, "urlType");
        Intrinsics.checkParameterIsNotNull(r22, "appName");
        Intrinsics.checkParameterIsNotNull(r23, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkParameterIsNotNull(r24, "activityName");
        Intrinsics.checkParameterIsNotNull(r25, "viewTreeTextInfo");
        Intrinsics.checkParameterIsNotNull(r27, "eventName");
        Intrinsics.checkParameterIsNotNull(r28, "operateNodeInfo");
        Intrinsics.checkParameterIsNotNull(r29, "description");
        Intrinsics.checkParameterIsNotNull(r30, WsConstants.KEY_EXTRA);
        return new CommonData(r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, CommonData.class) == false) goto L33;
        CommonData r6 = (CommonData) ZeusTransformUtils.preCheckCast(r5, CommonData.class, "com.obric.memorydata.plugin");
        if (this.dataId == r6.dataId) goto L9;
        return false;
    L9:
        if (this.timestamp == r6.timestamp) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.urlType, r6.urlType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.activityName, r6.activityName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.viewTreeTextInfo, r6.viewTreeTextInfo) == true) goto L23;
        return false;
    L23:
        if (this.eventType == r6.eventType) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.eventName, r6.eventName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.operateNodeInfo, r6.operateNodeInfo) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L50;
        return false;
    L50:
        return true;
    L33:
        return false;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getDataId() {
        return this.dataId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getOperateNodeInfo() {
        return this.operateNodeInfo;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUrl() {
        return this.url;
    }

    public final UrlType getUrlType() {
        return this.urlType;
    }

    public final String getViewTreeTextInfo() {
        return this.viewTreeTextInfo;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.dataId) * 31) + Long.hashCode(this.timestamp)) * 31;
        String r1 = this.url;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        UrlType r5 = this.urlType;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.appName;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.packageName;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.activityName;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.viewTreeTextInfo;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (((r16 + r18) * 31) + Integer.hashCode(this.eventType)) * 31;
        String r20 = this.eventName;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.operateNodeInfo;
        if (r23 == null) goto L33;
        int r24 = r23.hashCode();
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.description;
        if (r26 == null) goto L37;
        int r27 = r26.hashCode();
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.extra;
        if (r29 == null) goto L42;
        r2 = r29.hashCode();
    L42:
        return r28 + r2;
    L37:
        r27 = 0;
        goto L38
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void setActivityName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.activityName = r2;
    }

    public final void setAppName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.appName = r2;
    }

    public final void setDataId(int r1) {
        this.dataId = r1;
    }

    public final void setDescription(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.description = r2;
    }

    public final void setEventName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.eventName = r2;
    }

    public final void setEventType(int r1) {
        this.eventType = r1;
    }

    public final void setExtra(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.extra = r2;
    }

    public final void setOperateNodeInfo(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.operateNodeInfo = r2;
    }

    public final void setPackageName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.packageName = r2;
    }

    public final void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public final void setUrl(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.url = r2;
    }

    public final void setUrlType(UrlType r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.urlType = r2;
    }

    public final void setViewTreeTextInfo(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.viewTreeTextInfo = r2;
    }

    public String toString() {
        return "CommonData(dataId=" + this.dataId + ", timestamp=" + this.timestamp + ", url=" + this.url + ", urlType=" + this.urlType + ", appName=" + this.appName + ", packageName=" + this.packageName + ", activityName=" + this.activityName + ", viewTreeTextInfo=" + this.viewTreeTextInfo + ", eventType=" + this.eventType + ", eventName=" + this.eventName + ", operateNodeInfo=" + this.operateNodeInfo + ", description=" + this.description + ", extra=" + this.extra + ")";
    }
}
