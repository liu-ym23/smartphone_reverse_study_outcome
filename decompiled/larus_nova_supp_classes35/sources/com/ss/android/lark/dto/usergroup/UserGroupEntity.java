package com.ss.android.lark.dto.usergroup;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/dto/usergroup/UserGroupEntity;", "Ljava/io/Serializable;", "groupId", BuildConfig.FLAVOR, "groupName", "groupMemberCount", "groupMemberCountInChat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getGroupName", "setGroupName", "getGroupMemberCount", "setGroupMemberCount", "getGroupMemberCountInChat", "setGroupMemberCountInChat", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserGroupEntity implements Serializable {
    private String groupId;
    private String groupMemberCount;
    private String groupMemberCountInChat;
    private String groupName;

    public static /* synthetic */ UserGroupEntity copy$default(UserGroupEntity r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.groupId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.groupName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.groupMemberCount;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.groupMemberCountInChat;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.groupName;
    }

    public final String component3() {
        return this.groupMemberCount;
    }

    public final String component4() {
        return this.groupMemberCountInChat;
    }

    public final UserGroupEntity copy(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "groupId");
        Intrinsics.checkNotNullParameter(r3, "groupName");
        Intrinsics.checkNotNullParameter(r4, "groupMemberCount");
        Intrinsics.checkNotNullParameter(r5, "groupMemberCountInChat");
        return new UserGroupEntity(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserGroupEntity) == true) goto L8;
        return false;
    L8:
        UserGroupEntity r6 = (UserGroupEntity) r5;
        if (Intrinsics.areEqual(this.groupId, r6.groupId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupName, r6.groupName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.groupMemberCount, r6.groupMemberCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.groupMemberCountInChat, r6.groupMemberCountInChat) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.groupId.hashCode() * 31) + this.groupName.hashCode()) * 31) + this.groupMemberCount.hashCode()) * 31) + this.groupMemberCountInChat.hashCode();
    }

    public String toString() {
        return "UserGroupEntity(groupId=" + this.groupId + ", groupName=" + this.groupName + ", groupMemberCount=" + this.groupMemberCount + ", groupMemberCountInChat=" + this.groupMemberCountInChat + ')';
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGroupMemberCount() {
        return this.groupMemberCount;
    }

    public final String getGroupMemberCountInChat() {
        return this.groupMemberCountInChat;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setGroupId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.groupId = r2;
    }

    public final void setGroupMemberCount(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.groupMemberCount = r2;
    }

    public final void setGroupMemberCountInChat(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.groupMemberCountInChat = r2;
    }

    public final void setGroupName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.groupName = r2;
    }

    public UserGroupEntity(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "groupId");
        Intrinsics.checkNotNullParameter(r3, "groupName");
        Intrinsics.checkNotNullParameter(r4, "groupMemberCount");
        Intrinsics.checkNotNullParameter(r5, "groupMemberCountInChat");
        this.groupId = r2;
        this.groupName = r3;
        this.groupMemberCount = r4;
        this.groupMemberCountInChat = r5;
    }
}
