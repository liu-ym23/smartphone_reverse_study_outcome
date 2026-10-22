package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistData;", "", "allowed", "", "reason", "", "appletList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "signaturePublicKeyVersion", "", "<init>", "(ZILjava/util/List;Ljava/lang/String;)V", "getAllowed", "()Z", "getReason", "()I", "getAppletList", "()Ljava/util/List;", "getSignaturePublicKeyVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsInAppWhitelistData {
    private final boolean allowed;

    @SerializedName("applet_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformAppletItem> appletList;
    private final int reason;

    @SerializedName("sign_public_key_version")
    private final String signaturePublicKeyVersion;

    public IsInAppWhitelistData() {
        this(false, 0, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IsInAppWhitelistData copy$default(IsInAppWhitelistData r0, boolean r1, int r10, List r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.allowed;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.reason;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.appletList;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.signaturePublicKeyVersion;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final boolean component1() {
        return this.allowed;
    }

    public final int component2() {
        return this.reason;
    }

    public final List<OpenPlatformAppletItem> component3() {
        return this.appletList;
    }

    public final String component4() {
        return this.signaturePublicKeyVersion;
    }

    public final IsInAppWhitelistData copy(boolean r10, int r11, List<OpenPlatformAppletItem> r12, String r13) {
        return new IsInAppWhitelistData(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof IsInAppWhitelistData) == true) goto L8;
        return false;
    L8:
        IsInAppWhitelistData r11 = (IsInAppWhitelistData) r10;
        if (this.allowed == r11.allowed) goto L12;
        return false;
    L12:
        if (this.reason == r11.reason) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletList, r11.appletList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.signaturePublicKeyVersion, r11.signaturePublicKeyVersion) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.allowed == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.reason) * 31;
        List<OpenPlatformAppletItem> r10 = this.appletList;
        int r11 = 0;
        if (r10 != null) goto L9;
        int r12 = 0;
    L10:
        int r13 = (r1 + r12) * 31;
        String r14 = this.signaturePublicKeyVersion;
        if (r14 == null) goto L15;
        r11 = r14.hashCode();
    L15:
        return r13 + r11;
    L9:
        r12 = r10.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "IsInAppWhitelistData(allowed=" + this.allowed + ", reason=" + this.reason + ", appletList=" + this.appletList + ", signaturePublicKeyVersion=" + this.signaturePublicKeyVersion + ')';
    }

    public final boolean getAllowed() {
        return this.allowed;
    }

    public final List<OpenPlatformAppletItem> getAppletList() {
        return this.appletList;
    }

    public final int getReason() {
        return this.reason;
    }

    public final String getSignaturePublicKeyVersion() {
        return this.signaturePublicKeyVersion;
    }

    public IsInAppWhitelistData(boolean r1, int r10, List<OpenPlatformAppletItem> r11, String r12) {
        this.allowed = r1;
        this.reason = r10;
        this.appletList = r11;
        this.signaturePublicKeyVersion = r12;
    }

    public /* synthetic */ IsInAppWhitelistData(boolean r10, int r11, List r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = CollectionsKt.emptyList();
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = null;
    L14:
        this(r10, r11, r12, r13);
    }
}
