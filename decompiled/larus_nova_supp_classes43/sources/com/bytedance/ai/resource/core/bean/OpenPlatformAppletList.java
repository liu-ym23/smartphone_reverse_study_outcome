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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletList;", "", "appletList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "signaturePublicKeyVersion", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getAppletList", "()Ljava/util/List;", "getSignaturePublicKeyVersion", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformAppletList {

    @SerializedName("applet_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformAppletItem> appletList;

    @SerializedName("sign_public_key_version")
    private final String signaturePublicKeyVersion;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPlatformAppletList() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformAppletList copy$default(OpenPlatformAppletList r0, List r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.appletList;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.signaturePublicKeyVersion;
    L9:
        return r0.copy(r1, r10);
    }

    public final List<OpenPlatformAppletItem> component1() {
        return this.appletList;
    }

    public final String component2() {
        return this.signaturePublicKeyVersion;
    }

    public final OpenPlatformAppletList copy(List<OpenPlatformAppletItem> r10, String r11) {
        return new OpenPlatformAppletList(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformAppletList) == true) goto L8;
        return false;
    L8:
        OpenPlatformAppletList r11 = (OpenPlatformAppletList) r10;
        if (Intrinsics.areEqual(this.appletList, r11.appletList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signaturePublicKeyVersion, r11.signaturePublicKeyVersion) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<OpenPlatformAppletItem> r0 = this.appletList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.signaturePublicKeyVersion;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformAppletList(appletList=" + this.appletList + ", signaturePublicKeyVersion=" + this.signaturePublicKeyVersion + ')';
    }

    public final List<OpenPlatformAppletItem> getAppletList() {
        return this.appletList;
    }

    public final String getSignaturePublicKeyVersion() {
        return this.signaturePublicKeyVersion;
    }

    public OpenPlatformAppletList(List<OpenPlatformAppletItem> r1, String r10) {
        this.appletList = r1;
        this.signaturePublicKeyVersion = r10;
    }

    public /* synthetic */ OpenPlatformAppletList(List r1, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r1, r10);
    }
}
