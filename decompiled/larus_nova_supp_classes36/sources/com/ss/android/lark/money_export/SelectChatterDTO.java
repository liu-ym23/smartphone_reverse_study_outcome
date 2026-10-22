package com.ss.android.lark.money_export;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0010HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/money_export/SelectChatterDTO;", "Landroid/os/Parcelable;", "id", "", "avatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getId", "()Ljava/lang/String;", "getAvatar", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "CREATOR", "money-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SelectChatterDTO implements Parcelable {
    public static final a CREATOR = null;
    private final String avatar;
    private final String id;

    public static final class a implements Parcelable.Creator<SelectChatterDTO> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SelectChatterDTO createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new SelectChatterDTO(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SelectChatterDTO[] newArray(int r1) {
            return new SelectChatterDTO[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ SelectChatterDTO copy$default(SelectChatterDTO r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.avatar;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.avatar;
    }

    public final SelectChatterDTO copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "avatar");
        return new SelectChatterDTO(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectChatterDTO) == true) goto L8;
        return false;
    L8:
        SelectChatterDTO r6 = (SelectChatterDTO) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatar, r6.avatar) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.avatar.hashCode();
    }

    public String toString() {
        return "SelectChatterDTO(id=" + this.id + ", avatar=" + this.avatar + ')';
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.id;
    }

    public SelectChatterDTO(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        String r0 = r3.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = r3.readString();
        if (r4 == null) goto L9;
        r1 = r4;
    L9:
        this(r0, r1);
    }

    public SelectChatterDTO(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "avatar");
        this.id = r2;
        this.avatar = r3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.id);
        r1.writeString(this.avatar);
    }
}
