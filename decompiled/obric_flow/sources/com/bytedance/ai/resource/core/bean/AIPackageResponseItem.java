package com.bytedance.ai.resource.core.bean;

import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
import java.util.List;
import kk.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003JM\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageResponseItem;", "", Constant.APPID, "", "packageName", "versionCode", "digest", "resourceUrl", "resourceUrls", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getPackageName", "setPackageName", "getVersionCode", "setVersionCode", "getDigest", "setDigest", "getResourceUrl", "setResourceUrl", "getResourceUrls", "()Ljava/util/List;", "setResourceUrls", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageResponseItem {
    private String appId;
    private String digest;
    private String packageName;
    private String resourceUrl;
    private List<String> resourceUrls;
    private String versionCode;

    public AIPackageResponseItem() {
        String r5 = null;
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        List r14 = null;
        this(r5, r10, r11, r12, r13, r14, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageResponseItem copy$default(AIPackageResponseItem r5, String r10, String r11, String r12, String r13, String r14, List r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.appId;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.packageName;
    L8:
        String r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.versionCode;
    L11:
        String r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.digest;
    L14:
        String r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.resourceUrl;
    L17:
        String r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.resourceUrls;
    L20:
        String r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.versionCode;
    }

    public final String component4() {
        return this.digest;
    }

    public final String component5() {
        return this.resourceUrl;
    }

    public final List<String> component6() {
        return this.resourceUrls;
    }

    public final AIPackageResponseItem copy(String r10, String r11, String r12, String r13, String r14, List<String> r15) {
        Intrinsics.checkNotNullParameter(r10, Constant.APPID);
        Intrinsics.checkNotNullParameter(r11, "packageName");
        Intrinsics.checkNotNullParameter(r12, "versionCode");
        Intrinsics.checkNotNullParameter(r13, "digest");
        Intrinsics.checkNotNullParameter(r14, "resourceUrl");
        return new AIPackageResponseItem(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIPackageResponseItem) == true) goto L8;
        return false;
    L8:
        AIPackageResponseItem r10 = (AIPackageResponseItem) r5;
        if (Intrinsics.areEqual(this.appId, r10.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.versionCode, r10.versionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.digest, r10.digest) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceUrl, r10.resourceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resourceUrls, r10.resourceUrls) == true) goto L26;
        return false;
    L26:
        return true;
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
        int r5 = this.appId.hashCode() * 31;
        int r10 = a.b(this.packageName, r5, 31);
        int r11 = a.b(this.versionCode, r10, 31);
        int r12 = a.b(this.digest, r11, 31);
        int r13 = a.b(this.resourceUrl, r12, 31);
        List<String> r14 = this.resourceUrls;
        if (r14 != null) goto L5;
        int r15 = 0;
    L7:
        return r13 + r15;
    L5:
        r15 = r14.hashCode();
        goto L7
    }

    public final void setAppId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.appId = r5;
    }

    public final void setDigest(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.digest = r5;
    }

    public final void setPackageName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.packageName = r5;
    }

    public final void setResourceUrl(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.resourceUrl = r5;
    }

    public final void setResourceUrls(List<String> r5) {
        this.resourceUrls = r5;
    }

    public final void setVersionCode(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.versionCode = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("AIPackageResponseItem(appId=");
        r5.append(this.appId);
        r5.append(", packageName=");
        r5.append(this.packageName);
        r5.append(", versionCode=");
        r5.append(this.versionCode);
        r5.append(", digest=");
        r5.append(this.digest);
        r5.append(", resourceUrl=");
        r5.append(this.resourceUrl);
        r5.append(", resourceUrls=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.resourceUrls, ')');
    }

    public AIPackageResponseItem(String r5, String r10, String r11, String r12, String r13, List<String> r14) {
        Intrinsics.checkNotNullParameter(r5, Constant.APPID);
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "versionCode");
        Intrinsics.checkNotNullParameter(r12, "digest");
        Intrinsics.checkNotNullParameter(r13, "resourceUrl");
        this.appId = r5;
        this.packageName = r10;
        this.versionCode = r11;
        this.digest = r12;
        this.resourceUrl = r13;
        this.resourceUrls = r14;
    }

    public /* synthetic */ AIPackageResponseItem(String r5, String r10, String r11, String r12, String r13, List r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r5 = "";
    L6:
        if ((r15 & 2) == 0) goto L9;
        r10 = "";
    L9:
        if ((r15 & 4) == 0) goto L12;
        r11 = "";
    L12:
        if ((r15 & 8) == 0) goto L15;
        r12 = "";
    L15:
        if ((r15 & 16) == 0) goto L18;
        r13 = "";
    L18:
        if ((r15 & 32) == 0) goto L20;
        r14 = null;
    L20:
        this(r5, r10, r11, r12, r13, r14);
    }
}
