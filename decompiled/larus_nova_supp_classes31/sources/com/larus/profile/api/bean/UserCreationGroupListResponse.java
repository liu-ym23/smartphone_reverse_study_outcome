package com.larus.profile.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/profile/api/bean/UserCreationGroupListResponse;", "Landroid/os/Parcelable;", "creationGroupList", "", "Lcom/larus/profile/api/bean/UserCreationGroup;", "hasMore", "", "nextCursor", "", "<init>", "(Ljava/util/List;ZLjava/lang/String;)V", "getCreationGroupList", "()Ljava/util/List;", "getHasMore", "()Z", "getNextCursor", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class UserCreationGroupListResponse implements Parcelable {
    public static final Parcelable.Creator<UserCreationGroupListResponse> CREATOR = null;

    @SerializedName("creation_group_list")
    private final List<UserCreationGroup> creationGroupList;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("next_cursor")
    private final String nextCursor;

    public static final class a implements Parcelable.Creator<UserCreationGroupListResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationGroupListResponse createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            boolean r1 = false;
            ArrayList r2 = null;
            if (r7.readInt() == 0) goto L14;
            int r0 = r7.readInt();
            ArrayList r3 = new ArrayList(r0);
            int r4 = 0;
        L6:
            if (r4 == r0) goto L12;
            if (r7.readInt() != 0) goto L10;
            UserCreationGroup r5 = null;
        L11:
            r3.add(r5);
            r4 = r4 + 1;
            goto L6
        L10:
            r5 = UserCreationGroup.CREATOR.createFromParcel(r7);
            goto L11
        L12:
            r2 = r3;
        L14:
            if (r7.readInt() == 0) goto L17;
            r1 = true;
        L17:
            return new UserCreationGroupListResponse(r2, r1, r7.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationGroupListResponse[] newArray(int r1) {
            return new UserCreationGroupListResponse[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationGroupListResponse) == true) goto L8;
        return false;
    L8:
        UserCreationGroupListResponse r6 = (UserCreationGroupListResponse) r5;
        if (Intrinsics.areEqual(this.creationGroupList, r6.creationGroupList) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r6.hasMore) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nextCursor, r6.nextCursor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<UserCreationGroup> r0 = this.creationGroupList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        if (this.hasMore == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.nextCursor;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return r5 + r1;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserCreationGroupListResponse(creationGroupList=" + this.creationGroupList + ", hasMore=" + this.hasMore + ", nextCursor=" + this.nextCursor + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<UserCreationGroup> r0 = this.creationGroupList;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L12:
        r5.writeInt(this.hasMore ? 1 : 0);
        r5.writeString(this.nextCursor);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<UserCreationGroup> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        UserCreationGroup r3 = r1.next();
        if (r3 == null) goto L10;
        r5.writeInt(1);
        r3.writeToParcel(r5, r6);
        goto L7
    L10:
        r5.writeInt(0);
        goto L7
    }

    public UserCreationGroupListResponse() {
        this(new ArrayList(), false, null);
    }

    public final List<UserCreationGroup> a() {
        return this.creationGroupList;
    }

    public final boolean b() {
        return this.hasMore;
    }

    public final String c() {
        return this.nextCursor;
    }

    public UserCreationGroupListResponse(List<UserCreationGroup> r1, boolean r2, String r3) {
        this.creationGroupList = r1;
        this.hasMore = r2;
        this.nextCursor = r3;
    }
}
