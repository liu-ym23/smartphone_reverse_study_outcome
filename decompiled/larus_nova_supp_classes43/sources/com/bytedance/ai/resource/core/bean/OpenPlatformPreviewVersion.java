package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "", "versionTag", "", "updatedAt", "", "isDefault", "", com.bytedance.android.ec.core.event.a.KEY_STATUS, "createdAt", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;)V", "getVersionTag", "()Ljava/lang/String;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStatus", "getCreatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewVersion {

    @SerializedName("created_at")
    private final Long createdAt;

    @SerializedName("is_default")
    private final Boolean isDefault;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_STATUS)
    private final String status;

    @SerializedName("updated_at")
    private final Long updatedAt;

    @SerializedName("version_tag")
    private final String versionTag;

    public OpenPlatformPreviewVersion() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OpenPlatformPreviewVersion copy$default(OpenPlatformPreviewVersion r10, String r11, Long r12, Boolean r13, String r14, Long r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.versionTag;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.updatedAt;
    L8:
        Long r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.isDefault;
    L11:
        Boolean r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.status;
    L14:
        String r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.createdAt;
    L17:
        String r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final String component1() {
        return this.versionTag;
    }

    public final Long component2() {
        return this.updatedAt;
    }

    public final Boolean component3() {
        return this.isDefault;
    }

    public final String component4() {
        return this.status;
    }

    public final Long component5() {
        return this.createdAt;
    }

    public final OpenPlatformPreviewVersion copy(String r10, Long r11, Boolean r12, String r13, Long r14) {
        return new OpenPlatformPreviewVersion(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformPreviewVersion) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewVersion r11 = (OpenPlatformPreviewVersion) r10;
        if (Intrinsics.areEqual(this.versionTag, r11.versionTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updatedAt, r11.updatedAt) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isDefault, r11.isDefault) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.status, r11.status) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createdAt, r11.createdAt) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.versionTag;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        Long r12 = this.updatedAt;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        Boolean r15 = this.isDefault;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.status;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        Long r21 = this.createdAt;
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
        return "OpenPlatformPreviewVersion(versionTag=" + this.versionTag + ", updatedAt=" + this.updatedAt + ", isDefault=" + this.isDefault + ", status=" + this.status + ", createdAt=" + this.createdAt + ')';
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Long getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getVersionTag() {
        return this.versionTag;
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }

    public OpenPlatformPreviewVersion(String r1, Long r10, Boolean r11, String r12, Long r13) {
        this.versionTag = r1;
        this.updatedAt = r10;
        this.isDefault = r11;
        this.status = r12;
        this.createdAt = r13;
    }

    public /* synthetic */ OpenPlatformPreviewVersion(String r10, Long r11, Boolean r12, String r13, Long r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        String r17 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        Long r1 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        Boolean r18 = null;
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r19 = null;
    L19:
        if ((r15 & 16) == 0) goto L21;
        Long r110 = null;
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
