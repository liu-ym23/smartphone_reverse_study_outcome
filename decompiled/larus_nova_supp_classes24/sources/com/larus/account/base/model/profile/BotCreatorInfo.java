package com.larus.account.base.model.profile;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/larus/account/base/model/profile/BotCreatorInfo;", "Landroid/os/Parcelable;", "name", "", "id", "avatar", "Lcom/larus/account/base/model/profile/AvatarInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/base/model/profile/AvatarInfo;)V", "getName", "()Ljava/lang/String;", "getId", "getAvatar", "()Lcom/larus/account/base/model/profile/AvatarInfo;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class BotCreatorInfo implements Parcelable {
    public static final Parcelable.Creator<BotCreatorInfo> CREATOR = null;

    @SerializedName("creator_avatar")
    private final AvatarInfo avatar;

    @SerializedName("creator_id")
    private final String id;

    @SerializedName("creator_handle")
    private final String name;

    public static final class a implements Parcelable.Creator<BotCreatorInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotCreatorInfo createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            String r1 = r5.readString();
            String r2 = r5.readString();
            if (r5.readInt() != 0) goto L5;
            Object r6 = null;
        L7:
            return new BotCreatorInfo(r1, r2, (AvatarInfo) r6);
        L5:
            r6 = AvatarInfo.CREATOR.createFromParcel(r5);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BotCreatorInfo[] newArray(int r1) {
            return new BotCreatorInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotCreatorInfo() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotCreatorInfo) == true) goto L8;
        return false;
    L8:
        BotCreatorInfo r6 = (BotCreatorInfo) r5;
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatar, r6.avatar) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        AvatarInfo r7 = this.avatar;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotCreatorInfo(name=" + this.name + ", id=" + this.id + ", avatar=" + this.avatar + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.name);
        r3.writeString(this.id);
        AvatarInfo r0 = this.avatar;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
    }

    public BotCreatorInfo(String r1, String r2, AvatarInfo r3) {
        this.name = r1;
        this.id = r2;
        this.avatar = r3;
    }
}
