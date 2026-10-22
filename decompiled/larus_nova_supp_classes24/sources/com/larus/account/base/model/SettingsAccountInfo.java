package com.larus.account.base.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/account/base/model/SettingsAccountInfo;", "Landroid/os/Parcelable;", "baseAccountInfo", "Lcom/larus/account/base/model/SettingsBaseAccountInfo;", "connectAccountInfo", "", "Lcom/larus/account/base/model/SettingsConnectAccountInfo;", "<init>", "(Lcom/larus/account/base/model/SettingsBaseAccountInfo;Ljava/util/List;)V", "getBaseAccountInfo", "()Lcom/larus/account/base/model/SettingsBaseAccountInfo;", "getConnectAccountInfo", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SettingsAccountInfo implements Parcelable {
    public static final Parcelable.Creator<SettingsAccountInfo> CREATOR = null;

    @SerializedName("base_account_info")
    private final SettingsBaseAccountInfo baseAccountInfo;

    @SerializedName("connect_account_info")
    private final List<SettingsConnectAccountInfo> connectAccountInfo;

    public static final class a implements Parcelable.Creator<SettingsAccountInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SettingsAccountInfo createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            ArrayList r1 = null;
            if (r7.readInt() != 0) goto L5;
            SettingsBaseAccountInfo r0 = null;
        L6:
            SettingsBaseAccountInfo r2 = r0;
            if (r7.readInt() == 0) goto L18;
            int r3 = r7.readInt();
            ArrayList r4 = new ArrayList(r3);
            int r5 = 0;
        L10:
            if (r5 == r3) goto L16;
            if (r7.readInt() != 0) goto L14;
            SettingsConnectAccountInfo r6 = null;
        L15:
            r4.add(r6);
            r5 = r5 + 1;
            goto L10
        L14:
            r6 = SettingsConnectAccountInfo.CREATOR.createFromParcel(r7);
            goto L15
        L16:
            r1 = r4;
        L18:
            return new SettingsAccountInfo(r2, r1);
        L5:
            r0 = SettingsBaseAccountInfo.CREATOR.createFromParcel(r7);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final SettingsAccountInfo[] newArray(int r1) {
            return new SettingsAccountInfo[r1];
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
        if ((r5 instanceof SettingsAccountInfo) == true) goto L8;
        return false;
    L8:
        SettingsAccountInfo r6 = (SettingsAccountInfo) r5;
        if (Intrinsics.areEqual(this.baseAccountInfo, r6.baseAccountInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.connectAccountInfo, r6.connectAccountInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        SettingsBaseAccountInfo r0 = this.baseAccountInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<SettingsConnectAccountInfo> r4 = this.connectAccountInfo;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "SettingsAccountInfo(baseAccountInfo=" + this.baseAccountInfo + ", connectAccountInfo=" + this.connectAccountInfo + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        SettingsBaseAccountInfo r0 = this.baseAccountInfo;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        List<SettingsConnectAccountInfo> r1 = this.connectAccountInfo;
        if (r1 != null) goto L9;
        r5.writeInt(0);
        return;
    L9:
        r5.writeInt(1);
        r5.writeInt(r1.size());
        Iterator<SettingsConnectAccountInfo> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L23;
        SettingsConnectAccountInfo r3 = r2.next();
        if (r3 == null) goto L14;
        r5.writeInt(1);
        r3.writeToParcel(r5, r6);
        goto L11
    L14:
        r5.writeInt(0);
        goto L11
    L23:
        return;
    L5:
        r5.writeInt(1);
        r0.writeToParcel(r5, r6);
        goto L6
    }

    public SettingsAccountInfo() {
        this(new SettingsBaseAccountInfo(0), CollectionsKt.emptyList());
    }

    public final SettingsBaseAccountInfo a() {
        return this.baseAccountInfo;
    }

    public final List<SettingsConnectAccountInfo> b() {
        return this.connectAccountInfo;
    }

    public SettingsAccountInfo(SettingsBaseAccountInfo r1, List<SettingsConnectAccountInfo> r2) {
        this.baseAccountInfo = r1;
        this.connectAccountInfo = r2;
    }
}
