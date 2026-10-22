package com.larus.bmhome.miniartifact.listpage.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/ConfigElementImage;", "Ljava/io/Serializable;", "defaultImageUrl", "", "elementId", "defaultImageUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefaultImageUrl", "()Ljava/lang/String;", "getElementId", "getDefaultImageUri", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigElementImage implements Serializable {

    @SerializedName("default_image_uri")
    private final String defaultImageUri;

    @SerializedName("default_image_url")
    private final String defaultImageUrl;

    @SerializedName("element_id")
    private final String elementId;

    public ConfigElementImage() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ConfigElementImage copy$default(ConfigElementImage r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.defaultImageUrl;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.elementId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.defaultImageUri;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.defaultImageUrl;
    }

    public final String component2() {
        return this.elementId;
    }

    public final String component3() {
        return this.defaultImageUri;
    }

    public final ConfigElementImage copy(String r2, String r3, String r4) {
        return new ConfigElementImage(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ConfigElementImage) == true) goto L8;
        return false;
    L8:
        ConfigElementImage r6 = (ConfigElementImage) r5;
        if (Intrinsics.areEqual(this.defaultImageUrl, r6.defaultImageUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.elementId, r6.elementId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultImageUri, r6.defaultImageUri) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.defaultImageUrl;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.elementId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.defaultImageUri;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ConfigElementImage(defaultImageUrl=" + this.defaultImageUrl + ", elementId=" + this.elementId + ", defaultImageUri=" + this.defaultImageUri + ')';
    }

    public final String getDefaultImageUri() {
        return this.defaultImageUri;
    }

    public final String getDefaultImageUrl() {
        return this.defaultImageUrl;
    }

    public final String getElementId() {
        return this.elementId;
    }

    public ConfigElementImage(String r1, String r2, String r3) {
        this.defaultImageUrl = r1;
        this.elementId = r2;
        this.defaultImageUri = r3;
    }

    public /* synthetic */ ConfigElementImage(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
