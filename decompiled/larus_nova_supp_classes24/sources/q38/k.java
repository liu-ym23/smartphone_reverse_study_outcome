package q38;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009b\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0005HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00067"}, d2 = {"Lcom/larus/account/base/model/ConnectInfo;", "", "platform", "", "platformAppId", "", "profileImageUrl", "expiredTime", "", "expiresIn", "platformScreenName", "userId", "platformUid", "secPlatformUid", "modifyTime", "accessToken", "openId", "extra", "<init>", "(Ljava/lang/String;ILjava/lang/String;JILjava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlatform", "()Ljava/lang/String;", "getPlatformAppId", "()I", "getProfileImageUrl", "getExpiredTime", "()J", "getExpiresIn", "getPlatformScreenName", "getUserId", "getPlatformUid", "getSecPlatformUid", "getModifyTime", "getAccessToken", "getOpenId", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class k {

    @SerializedName("access_token")
    private final String accessToken;

    @SerializedName("expired_time")
    private final long expiredTime;

    @SerializedName("expires_in")
    private final int expiresIn;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("modify_time")
    private final long modifyTime;

    @SerializedName("open_id")
    private final String openId;

    @SerializedName("platform")
    private final String platform;

    @SerializedName("platform_app_id")
    private final int platformAppId;

    @SerializedName("platform_screen_name")
    private final String platformScreenName;

    @SerializedName("platform_uid")
    private final String platformUid;

    @SerializedName("profile_image_url")
    private final String profileImageUrl;

    @SerializedName("sec_platform_uid")
    private final String secPlatformUid;

    @SerializedName("user_id")
    private final long userId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
        if (Intrinsics.areEqual(this.platform, r9.platform) == true) goto L12;
        return false;
    L12:
        if (this.platformAppId == r9.platformAppId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.profileImageUrl, r9.profileImageUrl) == true) goto L18;
        return false;
    L18:
        if (this.expiredTime == r9.expiredTime) goto L21;
        return false;
    L21:
        if (this.expiresIn == r9.expiresIn) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.platformScreenName, r9.platformScreenName) == true) goto L27;
        return false;
    L27:
        if (this.userId == r9.userId) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.platformUid, r9.platformUid) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.secPlatformUid, r9.secPlatformUid) == true) goto L36;
        return false;
    L36:
        if (this.modifyTime == r9.modifyTime) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.accessToken, r9.accessToken) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.openId, r9.openId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.extra, r9.extra) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.platform;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.platformAppId) * 31;
        String r4 = this.profileImageUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.expiredTime;
        int r8 = (((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.expiresIn) * 31;
        String r9 = this.platformScreenName;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        long r12 = this.userId;
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        String r14 = this.platformUid;
        if (r14 != null) goto L17;
        int r15 = 0;
    L18:
        int r16 = (r13 + r15) * 31;
        String r17 = this.secPlatformUid;
        if (r17 != null) goto L21;
        int r19 = 0;
    L22:
        int r20 = (r16 + r19) * 31;
        long r21 = this.modifyTime;
        int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        String r23 = this.accessToken;
        if (r23 != null) goto L25;
        int r24 = 0;
    L26:
        int r25 = (r22 + r24) * 31;
        String r26 = this.openId;
        if (r26 != null) goto L29;
        int r27 = 0;
    L30:
        int r29 = (r25 + r27) * 31;
        String r30 = this.extra;
        if (r30 == null) goto L35;
        r1 = r30.hashCode();
    L35:
        return r29 + r1;
    L29:
        r27 = r26.hashCode();
        goto L30
    L25:
        r24 = r23.hashCode();
        goto L26
    L21:
        r19 = r17.hashCode();
        goto L22
    L17:
        r15 = r14.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConnectInfo(platform=" + this.platform + ", platformAppId=" + this.platformAppId + ", profileImageUrl=" + this.profileImageUrl + ", expiredTime=" + this.expiredTime + ", expiresIn=" + this.expiresIn + ", platformScreenName=" + this.platformScreenName + ", userId=" + this.userId + ", platformUid=" + this.platformUid + ", secPlatformUid=" + this.secPlatformUid + ", modifyTime=" + this.modifyTime + ", accessToken=" + this.accessToken + ", openId=" + this.openId + ", extra=" + this.extra + ')';
    }

    public k() {
        this.platform = null;
        this.platformAppId = 0;
        this.profileImageUrl = null;
        this.expiredTime = 0;
        this.expiresIn = 0;
        this.platformScreenName = null;
        this.userId = 0;
        this.platformUid = null;
        this.secPlatformUid = null;
        this.modifyTime = 0;
        this.accessToken = null;
        this.openId = null;
        this.extra = null;
    }

    public final int a() {
        return this.platformAppId;
    }
}
