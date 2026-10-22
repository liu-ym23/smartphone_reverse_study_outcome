package com.obric.cae.libs.AllianceDrop;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class AllianceDropEvent implements Parcelable {
    public static final int CONNECTION_LOST = 2;
    public static final Parcelable.Creator<AllianceDropEvent> CREATOR = null;
    public static final int FILE_NOT_FOUND = 1;
    public static final int NO_ENOUGH_SPACE = 3;
    public static final int REASON_CONNECT_FAILED = 9;
    public static final int REASON_FILE_COUNT_OVER_LIMIT = 11;
    public static final int REASON_FILE_SIZE_OVER_LIMIT = 12;
    public static final int REASON_NO_RESPONSE = 5;
    public static final int REASON_OTHER_P2P_CONNECTED = 13;
    public static final int REASON_REMOTE_BUSY = 8;
    public static final int REASON_SOFTAP_INUSE = 14;
    public static final int REASON_TRANSFER_FAIL = 10;
    public static final int REASON_TRANSFER_ONGOING = 7;
    public static final int REASON_USER_INTERRUPT = 6;
    public static final int REASON_USER_REFUSE = 4;
    private final String mDeviceId;
    private final int mSessionId;

    public class a implements Parcelable.Creator<AllianceDropEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AllianceDropEvent createFromParcel(Parcel r1) {
            return new AllianceDropEvent(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final AllianceDropEvent[] newArray(int r1) {
            return new AllianceDropEvent[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AllianceDropEvent(int r1, String r2) {
        this.mSessionId = r1;
        this.mDeviceId = r2;
    }

    public AllianceDropEvent(Parcel r2) {
        this.mSessionId = r2.readInt();
        this.mDeviceId = r2.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public int getSessionId() {
        return this.mSessionId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mSessionId);
        r1.writeString(this.mDeviceId);
    }
}
