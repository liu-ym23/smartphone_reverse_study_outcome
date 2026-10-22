package com.bytedance.ai.bridge.remote.model;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/AppMeta;", "Ljava/io/Serializable;", "appKey", "", BdpAwemeConstant.KEY_APP_NAME, "description", "iconUrl", "agreements", "Lcom/bytedance/ai/bridge/remote/model/Agreements;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/Agreements;)V", "getAppKey", "()Ljava/lang/String;", "getAppName", "getDescription", "getIconUrl", "getAgreements", "()Lcom/bytedance/ai/bridge/remote/model/Agreements;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppMeta implements Serializable {

    @SerializedName("agreements")
    private final Agreements agreements;

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("app_name")
    private final String appName;

    @SerializedName("description")
    private final String description;

    @SerializedName("icon_url")
    private final String iconUrl;

    public AppMeta() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ AppMeta copy$default(AppMeta r10, String r11, String r12, String r13, String r14, Agreements r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.appKey;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.appName;
    L8:
        String r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.description;
    L11:
        String r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.iconUrl;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.agreements;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final Agreements component5() {
        return this.agreements;
    }

    public final AppMeta copy(String r10, String r11, String r12, String r13, Agreements r14) {
        return new AppMeta(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppMeta) == true) goto L8;
        return false;
    L8:
        AppMeta r11 = (AppMeta) r10;
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r11.appName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r11.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r11.iconUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.agreements, r11.agreements) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.appKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.appName;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.description;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.iconUrl;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        Agreements r21 = this.agreements;
        if (r21 == null) goto L23;
        r1 = r21.hashCode();
    L23:
        return r20 + r1;
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppMeta(appKey=" + this.appKey + ", appName=" + this.appName + ", description=" + this.description + ", iconUrl=" + this.iconUrl + ", agreements=" + this.agreements + ')';
    }

    public final Agreements getAgreements() {
        return this.agreements;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public AppMeta(String r1, String r10, String r11, String r12, Agreements r13) {
        this.appKey = r1;
        this.appName = r10;
        this.description = r11;
        this.iconUrl = r12;
        this.agreements = r13;
    }

    public /* synthetic */ AppMeta(String r10, String r11, String r12, String r13, Agreements r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        String r17 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r18 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r19 = null;
    L19:
        if ((r15 & 16) == 0) goto L21;
        Agreements r110 = null;
    L22:
        this(r17, r1, r18, r19, r110);
        return;
    L21:
        r110 = r14;
        goto L22
    L17:
        r19 = r13;
        goto L19
    L13:
        r18 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L11
    L5:
        r17 = r10;
        goto L7
    }
}
