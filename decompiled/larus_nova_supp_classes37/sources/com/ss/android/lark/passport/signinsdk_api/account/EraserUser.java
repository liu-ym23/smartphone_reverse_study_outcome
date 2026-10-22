package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/account/EraserUser;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "uid", "", "tenantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getTenantId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class EraserUser implements Parcelable, Serializable {
    public static final Parcelable.Creator<EraserUser> CREATOR = null;
    private final String tenantId;
    private final String uid;

    public static final class a implements Parcelable.Creator<EraserUser> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EraserUser createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new EraserUser(r3.readString(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final EraserUser[] newArray(int r1) {
            return new EraserUser[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ EraserUser copy$default(EraserUser r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.uid;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.tenantId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.tenantId;
    }

    public final EraserUser copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
        return new EraserUser(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EraserUser) == true) goto L8;
        return false;
    L8:
        EraserUser r6 = (EraserUser) r5;
        if (Intrinsics.areEqual(this.uid, r6.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tenantId, r6.tenantId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.uid.hashCode() * 31) + this.tenantId.hashCode();
    }

    public String toString() {
        return "EraserUser(uid=" + this.uid + ", tenantId=" + this.tenantId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.uid);
        r1.writeString(this.tenantId);
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getUid() {
        return this.uid;
    }

    public EraserUser(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
        this.uid = r2;
        this.tenantId = r3;
    }
}
