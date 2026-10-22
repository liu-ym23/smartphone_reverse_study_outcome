package com.bytedance.android.live.broadcast.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class WelfarePermissionInfo implements Parcelable {
    public static final Parcelable.Creator<WelfarePermissionInfo> CREATOR = null;

    @SerializedName("available")
    public boolean available;

    @SerializedName("setting_page_url")
    public String settingPageUrl;

    public class a implements Parcelable.Creator<WelfarePermissionInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WelfarePermissionInfo createFromParcel(Parcel r2) {
            return new WelfarePermissionInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WelfarePermissionInfo[] newArray(int r1) {
            return new WelfarePermissionInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WelfarePermissionInfo() {
    }

    public WelfarePermissionInfo(Parcel r2) {
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.available = r0;
        this.settingPageUrl = r2.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeByte(this.available ? 1 : 0);
        r1.writeString(this.settingPageUrl);
    }
}
