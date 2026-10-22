package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JW\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "", "versionCode", "", Constant.APPID, "packageName", "resourceUrls", "", "resourceUrl", "digest", WsConstants.KEY_APP_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVersionCode", "()Ljava/lang/String;", "getAppId", "getPackageName", "getResourceUrls", "()Ljava/util/List;", "getResourceUrl", "getDigest", "getAid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenPlatformAppletItem {

    @SerializedName("parent_applet_id")
    private final String aid;

    @SerializedName("resource_id")
    private final String appId;
    private final String digest;

    @SerializedName(Constant.PACKAGE_NAME)
    private final String packageName;

    @SerializedName("download_url")
    private final String resourceUrl;

    @SerializedName("download_url_list")
    private final List<String> resourceUrls;

    @SerializedName("applet_version_code")
    private final String versionCode;

    public OpenPlatformAppletItem() {
        String r5 = null;
        String r10 = null;
        String r11 = null;
        List r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        this(r5, r10, r11, r12, r13, r14, r15, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformAppletItem copy$default(OpenPlatformAppletItem r5, String r10, String r11, String r12, List r13, String r14, String r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r10 = r5.versionCode;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r11 = r5.appId;
    L8:
        String r19 = r11;
        if ((r17 & 4) == 0) goto L11;
        r12 = r5.packageName;
    L11:
        String r20 = r12;
        if ((r17 & 8) == 0) goto L14;
        r13 = r5.resourceUrls;
    L14:
        List r21 = r13;
        if ((r17 & 16) == 0) goto L17;
        r14 = r5.resourceUrl;
    L17:
        String r22 = r14;
        if ((r17 & 32) == 0) goto L20;
        r15 = r5.digest;
    L20:
        String r23 = r15;
        if ((r17 & 64) == 0) goto L23;
        r16 = r5.aid;
    L23:
        String r24 = r10;
        return r5.copy(r24, r19, r20, r21, r22, r23, r16);
    }

    public final String component1() {
        return this.versionCode;
    }

    public final String component2() {
        return this.appId;
    }

    public final String component3() {
        return this.packageName;
    }

    public final List<String> component4() {
        return this.resourceUrls;
    }

    public final String component5() {
        return this.resourceUrl;
    }

    public final String component6() {
        return this.digest;
    }

    public final String component7() {
        return this.aid;
    }

    public final OpenPlatformAppletItem copy(String r10, String r11, String r12, List<String> r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "versionCode");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        Intrinsics.checkNotNullParameter(r12, "packageName");
        Intrinsics.checkNotNullParameter(r14, "resourceUrl");
        Intrinsics.checkNotNullParameter(r15, "digest");
        Intrinsics.checkNotNullParameter(r16, WsConstants.KEY_APP_ID);
        return new OpenPlatformAppletItem(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OpenPlatformAppletItem) == true) goto L8;
        return false;
    L8:
        OpenPlatformAppletItem r10 = (OpenPlatformAppletItem) r5;
        if (Intrinsics.areEqual(this.versionCode, r10.versionCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r10.appId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resourceUrls, r10.resourceUrls) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceUrl, r10.resourceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.digest, r10.digest) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.aid, r10.aid) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDigest() {
        return this.digest;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final List<String> getResourceUrls() {
        return this.resourceUrls;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        int r5 = this.versionCode.hashCode() * 31;
        int r10 = a.b(this.appId, r5, 31);
        int r11 = a.b(this.packageName, r10, 31);
        List<String> r12 = this.resourceUrls;
        if (r12 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r11 + r13) * 31;
        int r15 = a.b(this.resourceUrl, r14, 31);
        int r16 = a.b(this.digest, r15, 31);
        return this.aid.hashCode() + r16;
    L5:
        r13 = r12.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("OpenPlatformAppletItem(versionCode=");
        r5.append(this.versionCode);
        r5.append(", appId=");
        r5.append(this.appId);
        r5.append(", packageName=");
        r5.append(this.packageName);
        r5.append(", resourceUrls=");
        r5.append(this.resourceUrls);
        r5.append(", resourceUrl=");
        r5.append(this.resourceUrl);
        r5.append(", digest=");
        r5.append(this.digest);
        r5.append(", aid=");
        return j0.p(r5, this.aid, ')');
    }

    public OpenPlatformAppletItem(String r5, String r10, String r11, List<String> r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r5, "versionCode");
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r13, "resourceUrl");
        Intrinsics.checkNotNullParameter(r14, "digest");
        Intrinsics.checkNotNullParameter(r15, WsConstants.KEY_APP_ID);
        this.versionCode = r5;
        this.appId = r10;
        this.packageName = r11;
        this.resourceUrls = r12;
        this.resourceUrl = r13;
        this.digest = r14;
        this.aid = r15;
    }

    public /* synthetic */ OpenPlatformAppletItem(String r5, String r10, String r11, List r12, String r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
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
        r12 = null;
    L15:
        if ((r16 & 16) == 0) goto L18;
        r13 = "";
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
