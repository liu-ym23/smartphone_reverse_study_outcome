package com.larus.bmhome.share.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "", "shareId", "", "shareUrl", "qrCodeUrl", "sharePermissionType", "", "larkMetaIdentity", "Lcom/larus/bmhome/share/network/LarkMetaIdentity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/share/network/LarkMetaIdentity;)V", "getShareId", "()Ljava/lang/String;", "getShareUrl", "getQrCodeUrl", "getSharePermissionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLarkMetaIdentity", "()Lcom/larus/bmhome/share/network/LarkMetaIdentity;", "isCcmSharePanelAvailable", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/share/network/LarkMetaIdentity;)Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveMessageShareInfo {

    @SerializedName("lark_meta_identity")
    private final LarkMetaIdentity larkMetaIdentity;

    @SerializedName("qr_code_url")
    private final String qrCodeUrl;

    @SerializedName("share_id")
    private final String shareId;

    @SerializedName("share_permission_type")
    private final Integer sharePermissionType;

    @SerializedName("share_url")
    private final String shareUrl;

    public SaveMessageShareInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SaveMessageShareInfo copy$default(SaveMessageShareInfo r3, String r4, String r5, String r6, Integer r7, LarkMetaIdentity r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.shareId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.shareUrl;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.qrCodeUrl;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.sharePermissionType;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.larkMetaIdentity;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.shareId;
    }

    public final String component2() {
        return this.shareUrl;
    }

    public final String component3() {
        return this.qrCodeUrl;
    }

    public final Integer component4() {
        return this.sharePermissionType;
    }

    public final LarkMetaIdentity component5() {
        return this.larkMetaIdentity;
    }

    public final SaveMessageShareInfo copy(String r8, String r9, String r10, Integer r11, LarkMetaIdentity r12) {
        return new SaveMessageShareInfo(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SaveMessageShareInfo) == true) goto L8;
        return false;
    L8:
        SaveMessageShareInfo r6 = (SaveMessageShareInfo) r5;
        if (Intrinsics.areEqual(this.shareId, r6.shareId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shareUrl, r6.shareUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.qrCodeUrl, r6.qrCodeUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sharePermissionType, r6.sharePermissionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.larkMetaIdentity, r6.larkMetaIdentity) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.shareId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.shareUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.qrCodeUrl;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.sharePermissionType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        LarkMetaIdentity r13 = this.larkMetaIdentity;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SaveMessageShareInfo(shareId=" + this.shareId + ", shareUrl=" + this.shareUrl + ", qrCodeUrl=" + this.qrCodeUrl + ", sharePermissionType=" + this.sharePermissionType + ", larkMetaIdentity=" + this.larkMetaIdentity + ')';
    }

    public final boolean isCcmSharePanelAvailable() {
        Integer r0 = this.sharePermissionType;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.intValue() != 2) goto L24;
        String r1 = this.shareUrl;
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L25;
        LarkMetaIdentity r3 = this.larkMetaIdentity;
        if (r3 != null) goto L18;
    L20:
        boolean r4 = false;
    L21:
        if (r4 == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r3.isValid() != true) goto L20;
        r4 = true;
        goto L21
    L25:
        return false;
    L10:
        if (StringsKt.isBlank(r1) == true) goto L13;
        r2 = false;
        goto L14
    L24:
        return false;
    }

    public final LarkMetaIdentity getLarkMetaIdentity() {
        return this.larkMetaIdentity;
    }

    public final String getQrCodeUrl() {
        return this.qrCodeUrl;
    }

    public final String getShareId() {
        return this.shareId;
    }

    public final Integer getSharePermissionType() {
        return this.sharePermissionType;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public SaveMessageShareInfo(String r1, String r2, String r3, Integer r4, LarkMetaIdentity r5) {
        this.shareId = r1;
        this.shareUrl = r2;
        this.qrCodeUrl = r3;
        this.sharePermissionType = r4;
        this.larkMetaIdentity = r5;
    }

    public /* synthetic */ SaveMessageShareInfo(String r4, String r5, String r6, Integer r7, LarkMetaIdentity r8, int r9, DefaultConstructorMarker r10) {
        String r0 = "";
        if ((r9 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r9 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r9 & 4) != 0) goto L15;
        r0 = r6;
    L15:
        if ((r9 & 8) == 0) goto L17;
        Integer r2 = null;
    L19:
        if ((r9 & 16) == 0) goto L21;
        LarkMetaIdentity r12 = null;
    L22:
        this(r11, r1, r0, r2, r12);
        return;
    L21:
        r12 = r8;
        goto L22
    L17:
        r2 = r7;
        goto L19
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
