package com.ss.android.lark.chat.entity.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\bHÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTeamInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "teamId", BuildConfig.FLAVOR, "teamChatType", "Lcom/ss/android/lark/chat/entity/chat/TeamChatType;", "discoverable", BuildConfig.FLAVOR, "<init>", "(JLcom/ss/android/lark/chat/entity/chat/TeamChatType;Z)V", "component1", "component2", "component3", "copy", "describeContents", BuildConfig.FLAVOR, "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTeamInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<ChatTeamInfo> CREATOR = null;
    public final boolean discoverable;
    public final TeamChatType teamChatType;
    public final long teamId;

    public static final class a implements Parcelable.Creator<ChatTeamInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatTeamInfo createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            long r1 = r5.readLong();
            TeamChatType r3 = TeamChatType.valueOf(r5.readString());
            if (r5.readInt() == 0) goto L5;
            boolean r6 = true;
        L7:
            return new ChatTeamInfo(r1, r3, r6);
        L5:
            r6 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatTeamInfo[] newArray(int r1) {
            return new ChatTeamInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ChatTeamInfo copy$default(ChatTeamInfo r0, long r1, TeamChatType r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.teamId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.teamChatType;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.discoverable;
    L12:
        return r0.copy(r1, r3, r4);
    }

    public final long component1() {
        return this.teamId;
    }

    public final TeamChatType component2() {
        return this.teamChatType;
    }

    public final boolean component3() {
        return this.discoverable;
    }

    public final ChatTeamInfo copy(long r2, TeamChatType r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "teamChatType");
        return new ChatTeamInfo(r2, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ChatTeamInfo) == true) goto L8;
        return false;
    L8:
        ChatTeamInfo r9 = (ChatTeamInfo) r8;
        if (this.teamId == r9.teamId) goto L12;
        return false;
    L12:
        if (this.teamChatType == r9.teamChatType) goto L15;
        return false;
    L15:
        if (this.discoverable == r9.discoverable) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r0 = this.teamId;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.teamChatType.hashCode()) * 31;
        if (this.discoverable == false) goto L5;
        int r2 = 1231;
    L7:
        return r1 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public String toString() {
        return "ChatTeamInfo(teamId=" + this.teamId + ", teamChatType=" + this.teamChatType + ", discoverable=" + this.discoverable + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeLong(this.teamId);
        r3.writeString(this.teamChatType.name());
        r3.writeInt(this.discoverable ? 1 : 0);
    }

    public ChatTeamInfo(long r2, TeamChatType r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "teamChatType");
        this.teamId = r2;
        this.teamChatType = r4;
        this.discoverable = r5;
    }
}
