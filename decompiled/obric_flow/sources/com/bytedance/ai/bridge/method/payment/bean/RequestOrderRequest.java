package com.bytedance.ai.bridge.method.payment.bean;

import ai.j0;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/RequestOrderRequest;", "", Constant.APPID, "", "doubaoUID", "data", "dbAuthorization", "osType", WsConstants.KEY_APP_ID, "aidVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getDoubaoUID", "getData", "getDbAuthorization", "getOsType", "getAid", "getAidVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequestOrderRequest {

    @SerializedName(WsConstants.KEY_APP_ID)
    private final String aid;

    @SerializedName("aid_version")
    private final String aidVersion;

    @SerializedName(WsConstants.KEY_APP_KEY)
    private final String appId;

    @SerializedName("data")
    private final String data;

    @SerializedName("db_authorization")
    private final String dbAuthorization;

    @SerializedName("doubao_uid")
    private final String doubaoUID;

    @SerializedName("os_type")
    private final String osType;

    public RequestOrderRequest() {
        String r5 = null;
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        this(r5, r10, r11, r12, r13, r14, r15, 127, null);
    }

    public static /* synthetic */ RequestOrderRequest copy$default(RequestOrderRequest r5, String r10, String r11, String r12, String r13, String r14, String r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r10 = r5.appId;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r11 = r5.doubaoUID;
    L8:
        String r19 = r11;
        if ((r17 & 4) == 0) goto L11;
        r12 = r5.data;
    L11:
        String r20 = r12;
        if ((r17 & 8) == 0) goto L14;
        r13 = r5.dbAuthorization;
    L14:
        String r21 = r13;
        if ((r17 & 16) == 0) goto L17;
        r14 = r5.osType;
    L17:
        String r22 = r14;
        if ((r17 & 32) == 0) goto L20;
        r15 = r5.aid;
    L20:
        String r23 = r15;
        if ((r17 & 64) == 0) goto L23;
        r16 = r5.aidVersion;
    L23:
        String r24 = r10;
        return r5.copy(r24, r19, r20, r21, r22, r23, r16);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.doubaoUID;
    }

    public final String component3() {
        return this.data;
    }

    public final String component4() {
        return this.dbAuthorization;
    }

    public final String component5() {
        return this.osType;
    }

    public final String component6() {
        return this.aid;
    }

    public final String component7() {
        return this.aidVersion;
    }

    public final RequestOrderRequest copy(String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
        Intrinsics.checkNotNullParameter(r11, "doubaoUID");
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "dbAuthorization");
        Intrinsics.checkNotNullParameter(r14, "osType");
        Intrinsics.checkNotNullParameter(r15, WsConstants.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r16, "aidVersion");
        return new RequestOrderRequest(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RequestOrderRequest) == true) goto L8;
        return false;
    L8:
        RequestOrderRequest r10 = (RequestOrderRequest) r5;
        if (Intrinsics.areEqual(this.appId, r10.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.doubaoUID, r10.doubaoUID) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r10.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dbAuthorization, r10.dbAuthorization) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.osType, r10.osType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.aid, r10.aid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.aidVersion, r10.aidVersion) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getAidVersion() {
        return this.aidVersion;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getData() {
        return this.data;
    }

    public final String getDbAuthorization() {
        return this.dbAuthorization;
    }

    public final String getDoubaoUID() {
        return this.doubaoUID;
    }

    public final String getOsType() {
        return this.osType;
    }

    public int hashCode() {
        int r5 = this.appId.hashCode() * 31;
        int r10 = a.b(this.doubaoUID, r5, 31);
        int r11 = a.b(this.data, r10, 31);
        int r12 = a.b(this.dbAuthorization, r11, 31);
        int r13 = a.b(this.osType, r12, 31);
        int r14 = a.b(this.aid, r13, 31);
        return this.aidVersion.hashCode() + r14;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("RequestOrderRequest(appId=");
        r5.append(this.appId);
        r5.append(", doubaoUID=");
        r5.append(this.doubaoUID);
        r5.append(", data=");
        r5.append(this.data);
        r5.append(", dbAuthorization=");
        r5.append(this.dbAuthorization);
        r5.append(", osType=");
        r5.append(this.osType);
        r5.append(", aid=");
        r5.append(this.aid);
        r5.append(", aidVersion=");
        return j0.p(r5, this.aidVersion, ')');
    }

    public RequestOrderRequest(String r5, String r10, String r11, String r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r5, Constant.APPID);
        Intrinsics.checkNotNullParameter(r10, "doubaoUID");
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r12, "dbAuthorization");
        Intrinsics.checkNotNullParameter(r13, "osType");
        Intrinsics.checkNotNullParameter(r14, WsConstants.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r15, "aidVersion");
        this.appId = r5;
        this.doubaoUID = r10;
        this.data = r11;
        this.dbAuthorization = r12;
        this.osType = r13;
        this.aid = r14;
        this.aidVersion = r15;
    }

    public /* synthetic */ RequestOrderRequest(String r5, String r10, String r11, String r12, String r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r16 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r16 & 4) == 0) goto L12;
        r11 = "";
    L12:
        if ((r16 & 8) == 0) goto L15;
        r12 = "";
    L15:
        if ((r16 & 16) == 0) goto L18;
        r13 = "android";
    L18:
        if ((r16 & 32) == 0) goto L21;
        r14 = "";
    L21:
        if ((r16 & 64) == 0) goto L23;
        r15 = "";
    L23:
        this(r5, r10, r11, r12, r13, r14, r15);
    }
}
