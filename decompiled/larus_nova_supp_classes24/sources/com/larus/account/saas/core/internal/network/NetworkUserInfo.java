package com.larus.account.saas.core.internal.network;

import b48.j;
import b48.l;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0081\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\t\u0010\u000e\u001a\u00020\fHÆ\u0003JW\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b!\u0010 R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\u0014\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b\u0014\u0010'R\u001a\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b\u0015\u0010'¨\u0006*"}, d2 = {"Lcom/larus/account/saas/core/internal/network/NetworkUserInfo;", "", "Lb48/l;", "toUserInfo", "", "component1", "", "component2", "component3", "component4", "Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;", "component5", "", "component6", "component7", "userType", "userId", "nickName", "userName", "avatar", "isNicknameDefault", "isAvatarDefault", "copy", "toString", "hashCode", "other", "equals", "I", "getUserType", "()I", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "getNickName", "getUserName", "Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;", "getAvatar", "()Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;", "Z", "()Z", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;ZZ)V", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class NetworkUserInfo {

    @SerializedName("image")
    private final NetworkAvatarInfo avatar;

    @SerializedName("is_default_avatar")
    private final boolean isAvatarDefault;

    @SerializedName("is_default_nickname")
    private final boolean isNicknameDefault;

    @SerializedName("nickname")
    private final String nickName;

    @SerializedName("entity_id")
    private final String userId;

    @SerializedName("user_name")
    private final String userName;

    @SerializedName("user_type")
    private final int userType;

    public NetworkUserInfo() {
        this(0, null, null, null, null, false, false, 127, null);
    }

    public static /* synthetic */ NetworkUserInfo copy$default(NetworkUserInfo r5, int r6, String r7, String r8, String r9, NetworkAvatarInfo r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.userType;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.userId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.nickName;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.userName;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.avatar;
    L17:
        NetworkAvatarInfo r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.isNicknameDefault;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.isAvatarDefault;
    L23:
        int r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final int component1() {
        return this.userType;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.nickName;
    }

    public final String component4() {
        return this.userName;
    }

    public final NetworkAvatarInfo component5() {
        return this.avatar;
    }

    public final boolean component6() {
        return this.isNicknameDefault;
    }

    public final boolean component7() {
        return this.isAvatarDefault;
    }

    public final NetworkUserInfo copy(int r10, String r11, String r12, String r13, NetworkAvatarInfo r14, boolean r15, boolean r16) {
        return new NetworkUserInfo(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NetworkUserInfo) == true) goto L8;
        return false;
    L8:
        NetworkUserInfo r6 = (NetworkUserInfo) r5;
        if (this.userType == r6.userType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nickName, r6.nickName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userName, r6.userName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.avatar, r6.avatar) == true) goto L24;
        return false;
    L24:
        if (this.isNicknameDefault == r6.isNicknameDefault) goto L27;
        return false;
    L27:
        if (this.isAvatarDefault == r6.isAvatarDefault) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = this.userType * 31;
        String r1 = this.userId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.nickName;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.userName;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        NetworkAvatarInfo r11 = this.avatar;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        int r12 = (r10 + r2) * 31;
        boolean r13 = this.isNicknameDefault;
        ?? r14 = 1;
        ?? r15 = r13;
        if (r13 == false) goto L21;
        r15 = 1;
    L21:
        int r16 = (r12 + r15) * 31;
        boolean r17 = this.isAvatarDefault;
        if (r17 == true) goto L26;
        r14 = r17;
    L26:
        return r16 + r14;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "NetworkUserInfo(userType=" + this.userType + ", userId=" + this.userId + ", nickName=" + this.nickName + ", userName=" + this.userName + ", avatar=" + this.avatar + ", isNicknameDefault=" + this.isNicknameDefault + ", isAvatarDefault=" + this.isAvatarDefault + ')';
    }

    public final l toUserInfo() {
        int r1 = this.userType;
        String r2 = this.userId;
        String r3 = this.nickName;
        String r4 = this.userName;
        NetworkAvatarInfo r0 = this.avatar;
        if (r0 == null) goto L5;
        j r5 = r0.toAvatarInfo();
    L7:
        return new l(r1, r2, r3, r4, r5, this.isNicknameDefault, this.isAvatarDefault);
    L5:
        r5 = null;
        goto L7
    }

    public final NetworkAvatarInfo getAvatar() {
        return this.avatar;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final boolean isAvatarDefault() {
        return this.isAvatarDefault;
    }

    public final boolean isNicknameDefault() {
        return this.isNicknameDefault;
    }

    public NetworkUserInfo(int r1, String r2, String r3, String r4, NetworkAvatarInfo r5, boolean r6, boolean r7) {
        this.userType = r1;
        this.userId = r2;
        this.nickName = r3;
        this.userName = r4;
        this.avatar = r5;
        this.isNicknameDefault = r6;
        this.isAvatarDefault = r7;
    }

    public /* synthetic */ NetworkUserInfo(int r7, String r8, String r9, String r10, NetworkAvatarInfo r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        int r16 = 0;
    L6:
        NetworkAvatarInfo r1 = null;
        if ((r14 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r4 = null;
    L19:
        if ((r14 & 16) != 0) goto L23;
        r1 = r11;
    L23:
        if ((r14 & 32) == 0) goto L25;
        boolean r5 = false;
    L27:
        if ((r14 & 64) == 0) goto L29;
        boolean r17 = false;
    L30:
        this(r16, r2, r3, r4, r1, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L6
    }
}
