package q38;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u009b\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0005HÖ\u0001J\t\u00106\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001a¨\u00067"}, d2 = {"Lcom/larus/account/base/model/BaseInfo;", "", "userId", "", "appId", "", "avatarUrl", "", "screenName", "mobile", "safeMobile", "email", "connectInfo", "", "Lcom/larus/account/base/model/ConnectInfo;", "registerTime", "registerType", "registerApp", "lastLoginTime", "<init>", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()J", "getAppId", "()I", "getAvatarUrl", "()Ljava/lang/String;", "getScreenName", "getMobile", "getSafeMobile", "getEmail", "getConnectInfo", "()Ljava/util/List;", "getRegisterTime", "getRegisterType", "getRegisterApp", "getLastLoginTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class g {

    @SerializedName("app_id")
    private final int appId;

    @SerializedName("avatar_url")
    private final String avatarUrl;

    @SerializedName("connect_info")
    private final List<k> connectInfo;

    @SerializedName("email")
    private final String email;

    @SerializedName("last_login_time")
    private final String lastLoginTime;

    @SerializedName("mobile")
    private final String mobile;

    @SerializedName("register_app")
    private final String registerApp;

    @SerializedName("register_time")
    private final long registerTime;

    @SerializedName("register_type")
    private final String registerType;

    @SerializedName("safe_mobile")
    private final String safeMobile;

    @SerializedName("screen_name")
    private final String screenName;

    @SerializedName("user_id")
    private final long userId;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (this.userId == r9.userId) goto L12;
        return false;
    L12:
        if (this.appId == r9.appId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarUrl, r9.avatarUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.screenName, r9.screenName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mobile, r9.mobile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.safeMobile, r9.safeMobile) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.email, r9.email) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.connectInfo, r9.connectInfo) == true) goto L33;
        return false;
    L33:
        if (this.registerTime == r9.registerTime) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.registerType, r9.registerType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.registerApp, r9.registerApp) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.lastLoginTime, r9.lastLoginTime) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r0 = this.userId;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.appId) * 31;
        String r2 = this.avatarUrl;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.screenName;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.mobile;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        String r12 = this.safeMobile;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.email;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        int r17 = (r14 + r16) * 31;
        List<k> r19 = this.connectInfo;
        if (r19 != null) goto L25;
        int r20 = 0;
    L26:
        long r21 = this.registerTime;
        int r22 = (((r17 + r20) * 31) + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        String r23 = this.registerType;
        if (r23 != null) goto L29;
        int r24 = 0;
    L30:
        int r25 = (r22 + r24) * 31;
        String r26 = this.registerApp;
        if (r26 != null) goto L33;
        int r27 = 0;
    L34:
        int r29 = (r25 + r27) * 31;
        String r30 = this.lastLoginTime;
        if (r30 == null) goto L39;
        r3 = r30.hashCode();
    L39:
        return r29 + r3;
    L33:
        r27 = r26.hashCode();
        goto L34
    L29:
        r24 = r23.hashCode();
        goto L30
    L25:
        r20 = r19.hashCode();
        goto L26
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaseInfo(userId=" + this.userId + ", appId=" + this.appId + ", avatarUrl=" + this.avatarUrl + ", screenName=" + this.screenName + ", mobile=" + this.mobile + ", safeMobile=" + this.safeMobile + ", email=" + this.email + ", connectInfo=" + this.connectInfo + ", registerTime=" + this.registerTime + ", registerType=" + this.registerType + ", registerApp=" + this.registerApp + ", lastLoginTime=" + this.lastLoginTime + ')';
    }

    public g() {
        this.userId = 0;
        this.appId = 0;
        this.avatarUrl = null;
        this.screenName = null;
        this.mobile = null;
        this.safeMobile = null;
        this.email = null;
        this.connectInfo = null;
        this.registerTime = 0;
        this.registerType = null;
        this.registerApp = null;
        this.lastLoginTime = null;
    }

    public final String a() {
        return this.avatarUrl;
    }

    public final List<k> b() {
        return this.connectInfo;
    }

    public final String c() {
        return this.email;
    }

    public final String d() {
        return this.mobile;
    }

    public final String e() {
        return this.screenName;
    }
}
