package com.larus.account.base.multi;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0086\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u000bHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0007\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/larus/account/base/multi/PassportUserInfo;", "", "avatar", "", "currentUser", "", "description", "isLogin", "mobile", "name", "passportEnterpriseUserType", "", "secUserId", "userId", "larkTenantInfo", "Lcom/larus/account/base/multi/LarkTenantInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/base/multi/LarkTenantInfo;)V", "getAvatar", "()Ljava/lang/String;", "getCurrentUser", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDescription", "getMobile", "getName", "getPassportEnterpriseUserType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSecUserId", "getUserId", "getLarkTenantInfo", "()Lcom/larus/account/base/multi/LarkTenantInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/base/multi/LarkTenantInfo;)Lcom/larus/account/base/multi/PassportUserInfo;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class n {

    @SerializedName("avatar")
    private final String avatar;

    @SerializedName("current_user")
    private final Boolean currentUser;

    @SerializedName("description")
    private final String description;

    @SerializedName("is_login")
    private final Boolean isLogin;

    @SerializedName("lark_tenant_info")
    private final f larkTenantInfo;

    @SerializedName("mobile")
    private final String mobile;

    @SerializedName("name")
    private final String name;

    @SerializedName("passport_enterprise_user_type")
    private final Integer passportEnterpriseUserType;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("user_id")
    private final String userId;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.avatar, r6.avatar) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentUser, r6.currentUser) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isLogin, r6.isLogin) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mobile, r6.mobile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.passportEnterpriseUserType, r6.passportEnterpriseUserType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.secUserId, r6.secUserId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.larkTenantInfo, r6.larkTenantInfo) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r0 = this.avatar;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.currentUser;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.description;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isLogin;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.mobile;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.name;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r19 = (r15 + r17) * 31;
        Integer r20 = this.passportEnterpriseUserType;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.secUserId;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.userId;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r29 = (r25 + r27) * 31;
        f r30 = this.larkTenantInfo;
        if (r30 == null) goto L43;
        r1 = r30.hashCode();
    L43:
        return r29 + r1;
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
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

    public final String toString() {
        return "PassportUserInfo(avatar=" + this.avatar + ", currentUser=" + this.currentUser + ", description=" + this.description + ", isLogin=" + this.isLogin + ", mobile=" + this.mobile + ", name=" + this.name + ", passportEnterpriseUserType=" + this.passportEnterpriseUserType + ", secUserId=" + this.secUserId + ", userId=" + this.userId + ", larkTenantInfo=" + this.larkTenantInfo + ')';
    }

    public n() {
        this.avatar = null;
        this.currentUser = null;
        this.description = null;
        this.isLogin = null;
        this.mobile = null;
        this.name = null;
        this.passportEnterpriseUserType = null;
        this.secUserId = null;
        this.userId = null;
        this.larkTenantInfo = null;
    }

    public final String a() {
        return this.avatar;
    }

    public final f b() {
        return this.larkTenantInfo;
    }

    public final String c() {
        return this.name;
    }

    public final Integer d() {
        return this.passportEnterpriseUserType;
    }

    public final String e() {
        return this.secUserId;
    }
}
