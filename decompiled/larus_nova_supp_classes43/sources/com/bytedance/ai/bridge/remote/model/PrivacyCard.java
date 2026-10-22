package com.bytedance.ai.bridge.remote.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/PrivacyCard;", "Ljava/io/Serializable;", "doubaoMiniAppKey", "", "doubaoMiniAppName", "doubaoMiniAppIcon", "doubaoMiniAppVersion", "doubaoMiniAppDescription", "privacyInfo", "Lcom/bytedance/ai/bridge/remote/model/PrivacyInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/bridge/remote/model/PrivacyInfo;)V", "getDoubaoMiniAppKey", "()Ljava/lang/String;", "getDoubaoMiniAppName", "getDoubaoMiniAppIcon", "getDoubaoMiniAppVersion", "getDoubaoMiniAppDescription", "getPrivacyInfo", "()Lcom/bytedance/ai/bridge/remote/model/PrivacyInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyCard implements Serializable {

    @SerializedName("DoubaoMiniAppDescription")
    private final String doubaoMiniAppDescription;

    @SerializedName("DoubaoMiniAppIcon")
    private final String doubaoMiniAppIcon;

    @SerializedName("DoubaoMiniAppKey")
    private final String doubaoMiniAppKey;

    @SerializedName("DoubaoMiniAppName")
    private final String doubaoMiniAppName;

    @SerializedName("DoubaoMiniAppVersion")
    private final String doubaoMiniAppVersion;

    @SerializedName("PrivacyInfo")
    private final PrivacyInfo privacyInfo;

    public PrivacyCard() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PrivacyCard copy$default(PrivacyCard r10, String r11, String r12, String r13, String r14, String r15, PrivacyInfo r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.doubaoMiniAppKey;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.doubaoMiniAppName;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.doubaoMiniAppIcon;
    L11:
        String r0 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.doubaoMiniAppVersion;
    L14:
        String r1 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.doubaoMiniAppDescription;
    L17:
        String r20 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.privacyInfo;
    L20:
        String r21 = r11;
        return r10.copy(r21, r19, r0, r1, r20, r16);
    }

    public final String component1() {
        return this.doubaoMiniAppKey;
    }

    public final String component2() {
        return this.doubaoMiniAppName;
    }

    public final String component3() {
        return this.doubaoMiniAppIcon;
    }

    public final String component4() {
        return this.doubaoMiniAppVersion;
    }

    public final String component5() {
        return this.doubaoMiniAppDescription;
    }

    public final PrivacyInfo component6() {
        return this.privacyInfo;
    }

    public final PrivacyCard copy(String r10, String r11, String r12, String r13, String r14, PrivacyInfo r15) {
        return new PrivacyCard(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PrivacyCard) == true) goto L8;
        return false;
    L8:
        PrivacyCard r11 = (PrivacyCard) r10;
        if (Intrinsics.areEqual(this.doubaoMiniAppKey, r11.doubaoMiniAppKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.doubaoMiniAppName, r11.doubaoMiniAppName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.doubaoMiniAppIcon, r11.doubaoMiniAppIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.doubaoMiniAppVersion, r11.doubaoMiniAppVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.doubaoMiniAppDescription, r11.doubaoMiniAppDescription) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.privacyInfo, r11.privacyInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.doubaoMiniAppKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        String r12 = this.doubaoMiniAppName;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.doubaoMiniAppIcon;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.doubaoMiniAppVersion;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.doubaoMiniAppDescription;
        if (r21 != null) goto L21;
        int r22 = 0;
    L22:
        int r23 = (r20 + r22) * 31;
        PrivacyInfo r24 = this.privacyInfo;
        if (r24 == null) goto L27;
        r1 = r24.hashCode();
    L27:
        return r23 + r1;
    L21:
        r22 = r21.hashCode();
        goto L22
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
        return "PrivacyCard(doubaoMiniAppKey=" + this.doubaoMiniAppKey + ", doubaoMiniAppName=" + this.doubaoMiniAppName + ", doubaoMiniAppIcon=" + this.doubaoMiniAppIcon + ", doubaoMiniAppVersion=" + this.doubaoMiniAppVersion + ", doubaoMiniAppDescription=" + this.doubaoMiniAppDescription + ", privacyInfo=" + this.privacyInfo + ')';
    }

    public final String getDoubaoMiniAppDescription() {
        return this.doubaoMiniAppDescription;
    }

    public final String getDoubaoMiniAppIcon() {
        return this.doubaoMiniAppIcon;
    }

    public final String getDoubaoMiniAppKey() {
        return this.doubaoMiniAppKey;
    }

    public final String getDoubaoMiniAppName() {
        return this.doubaoMiniAppName;
    }

    public final String getDoubaoMiniAppVersion() {
        return this.doubaoMiniAppVersion;
    }

    public final PrivacyInfo getPrivacyInfo() {
        return this.privacyInfo;
    }

    public PrivacyCard(String r1, String r10, String r11, String r12, String r13, PrivacyInfo r14) {
        this.doubaoMiniAppKey = r1;
        this.doubaoMiniAppName = r10;
        this.doubaoMiniAppIcon = r11;
        this.doubaoMiniAppVersion = r12;
        this.doubaoMiniAppDescription = r13;
        this.privacyInfo = r14;
    }

    public /* synthetic */ PrivacyCard(String r10, String r11, String r12, String r13, String r14, PrivacyInfo r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r16 & 4) == 0) goto L13;
        String r19 = null;
    L15:
        if ((r16 & 8) == 0) goto L17;
        String r20 = null;
    L19:
        if ((r16 & 16) == 0) goto L21;
        String r21 = null;
    L23:
        if ((r16 & 32) == 0) goto L25;
        PrivacyInfo r110 = null;
    L26:
        this(r18, r1, r19, r20, r21, r110);
        return;
    L25:
        r110 = r15;
        goto L26
    L21:
        r21 = r14;
        goto L23
    L17:
        r20 = r13;
        goto L19
    L13:
        r19 = r12;
        goto L15
    L9:
        r1 = r11;
        goto L11
    L5:
        r18 = r10;
        goto L7
    }
}
