package fs9;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J^\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001e¨\u0006-"}, d2 = {"Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "profileBotInfo", "Lcom/larus/profile/api/bean/ProfileBotInfo;", "blocklistInfo", "Lcom/larus/profile/api/bean/BlockListInfo;", "relationInfo", "Lcom/larus/profile/api/bean/RelationInfo;", "profileStatus", "", "isFromCache", "", "isDowngraded", "<init>", "(Lcom/larus/account/base/model/profile/UserInfo;Lcom/larus/profile/api/bean/ProfileBotInfo;Lcom/larus/profile/api/bean/BlockListInfo;Lcom/larus/profile/api/bean/RelationInfo;Ljava/lang/Integer;ZZ)V", "getUserInfo", "()Lcom/larus/account/base/model/profile/UserInfo;", "getProfileBotInfo", "()Lcom/larus/profile/api/bean/ProfileBotInfo;", "setProfileBotInfo", "(Lcom/larus/profile/api/bean/ProfileBotInfo;)V", "getBlocklistInfo", "()Lcom/larus/profile/api/bean/BlockListInfo;", "getRelationInfo", "()Lcom/larus/profile/api/bean/RelationInfo;", "getProfileStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/larus/account/base/model/profile/UserInfo;Lcom/larus/profile/api/bean/ProfileBotInfo;Lcom/larus/profile/api/bean/BlockListInfo;Lcom/larus/profile/api/bean/RelationInfo;Ljava/lang/Integer;ZZ)Lcom/larus/profile/api/bean/ProfileOverviewResponse;", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class u {
    public final transient boolean a;
    public final transient boolean b;

    @SerializedName("blocklist_info")
    private final b blocklistInfo;

    @Expose(deserialize = false, serialize = false)
    private o profileBotInfo;

    @SerializedName("profile_status")
    private final Integer profileStatus;

    @SerializedName("relation_info")
    private final w relationInfo;

    @SerializedName("profile_brief")
    private final r38.b userInfo;

    public u() {
        this(null, null, false, false, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (Intrinsics.areEqual(this.userInfo, r6.userInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.profileBotInfo, r6.profileBotInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.blocklistInfo, r6.blocklistInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.relationInfo, r6.relationInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.profileStatus, r6.profileStatus) == true) goto L24;
        return false;
    L24:
        if (this.a == r6.a) goto L27;
        return false;
    L27:
        if (this.b == r6.b) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        r38.b r0 = this.userInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        o r4 = this.profileBotInfo;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        b r7 = this.blocklistInfo;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        w r10 = this.relationInfo;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.profileStatus;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        int r15 = 1231;
        if (this.a == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r14 + r16) * 31;
        if (this.b == true) goto L31;
        r15 = 1237;
    L31:
        return r17 + r15;
    L25:
        r16 = 1237;
        goto L26
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
        return "ProfileOverviewResponse(userInfo=" + this.userInfo + ", profileBotInfo=" + this.profileBotInfo + ", blocklistInfo=" + this.blocklistInfo + ", relationInfo=" + this.relationInfo + ", profileStatus=" + this.profileStatus + ", isFromCache=" + this.a + ", isDowngraded=" + this.b + ')';
    }

    public final b b() {
        return this.blocklistInfo;
    }

    public final o c() {
        return this.profileBotInfo;
    }

    public final Integer d() {
        return this.profileStatus;
    }

    public final w e() {
        return this.relationInfo;
    }

    public final r38.b f() {
        return this.userInfo;
    }

    public static u a(u r8) {
        r38.b r1 = r8.userInfo;
        o r2 = r8.profileBotInfo;
        b r3 = r8.blocklistInfo;
        w r4 = r8.relationInfo;
        Integer r5 = r8.profileStatus;
        boolean r7 = r8.b;
        r8.getClass();
        return new u(r1, r2, r3, r4, r5, true, r7);
    }

    public final void g(o r1) {
        this.profileBotInfo = r1;
    }

    public /* synthetic */ u(r38.b r11, o r12, boolean r13, boolean r14, int r15) {
        Integer r1 = null;
        if ((r15 & 1) == 0) goto L5;
        r38.b r3 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        o r4 = null;
    L11:
        if ((r15 & 16) == 0) goto L13;
        r1 = 0;
    L13:
        Integer r7 = r1;
        if ((r15 & 32) == 0) goto L16;
        boolean r8 = false;
    L18:
        if ((r15 & 64) == 0) goto L20;
        boolean r9 = false;
    L21:
        this(r3, r4, null, null, r7, r8, r9);
        return;
    L20:
        r9 = r14;
        goto L21
    L16:
        r8 = r13;
        goto L18
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public u(r38.b r1, o r2, b r3, w r4, Integer r5, boolean r6, boolean r7) {
        this.userInfo = r1;
        this.profileBotInfo = r2;
        this.blocklistInfo = r3;
        this.relationInfo = r4;
        this.profileStatus = r5;
        this.a = r6;
        this.b = r7;
    }
}
