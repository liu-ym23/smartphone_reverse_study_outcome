package com.obric.cae.libs.appqoe;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class AppQoeResult implements Parcelable {
    public static final int CHANNEL_CELL0 = 1;
    public static final int CHANNEL_CELL1 = 2;
    public static final int CHANNEL_UNKNOWN = 0;
    public static final int CHANNEL_WLAN0 = 3;
    public static final int CHANNEL_WLAN1 = 4;
    public static final int CONFIDENCE_HIGH = 2;
    public static final int CONFIDENCE_LOW = 0;
    public static final int CONFIDENCE_MEDIUM = 1;
    public static final Parcelable.Creator<AppQoeResult> CREATOR = null;
    public static final int REASON_LINK = 1;
    public static final int REASON_NON_COMM = 3;
    public static final int REASON_SERVER = 2;
    public static final int REASON_UNKNOWN = 0;
    private final int confidence;
    private final int maxRatioChannelId;
    private final String packageName;
    private final int reason;
    private final int reportSourceType;
    private final boolean result;
    private final int uid;

    public class a implements Parcelable.Creator<AppQoeResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppQoeResult createFromParcel(Parcel r1) {
            return new AppQoeResult(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final AppQoeResult[] newArray(int r1) {
            return new AppQoeResult[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AppQoeResult(int r1, String r2, boolean r3, int r4, int r5, int r6, int r7) {
        this.uid = r1;
        this.packageName = r2;
        this.result = r3;
        this.reason = r4;
        this.confidence = r5;
        this.maxRatioChannelId = r6;
        this.reportSourceType = r7;
    }

    public AppQoeResult(Parcel r2) {
        this.uid = r2.readInt();
        this.packageName = r2.readString();
        if (r2.readInt() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.result = r0;
        this.reason = r2.readInt();
        this.confidence = r2.readInt();
        this.maxRatioChannelId = r2.readInt();
        this.reportSourceType = r2.readInt();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public int getMaxRatioChannelId() {
        return this.maxRatioChannelId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getReason() {
        return this.reason;
    }

    public int getReportSourceType() {
        return this.reportSourceType;
    }

    public boolean getResult() {
        return this.result;
    }

    public int getUid() {
        return this.uid;
    }

    public String toString() {
        return "AppQoeResult{uid=" + this.uid + ", result=" + this.result + ", reason=" + this.reason + ", confidence=" + this.confidence + ", maxRatioChannelId=" + this.maxRatioChannelId + ", reportSourceType=" + this.reportSourceType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.uid);
        r1.writeString(this.packageName);
        r1.writeInt(this.result ? 1 : 0);
        r1.writeInt(this.reason);
        r1.writeInt(this.confidence);
        r1.writeInt(this.maxRatioChannelId);
        r1.writeInt(this.reportSourceType);
    }
}
