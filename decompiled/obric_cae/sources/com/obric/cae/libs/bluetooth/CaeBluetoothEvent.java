package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class CaeBluetoothEvent implements Parcelable {
    public static final int A2DP = 2;
    public static final int AVRCP = 4;
    public static final int CATEGORY_A2DP_CODEC_ISSUE = 2;
    public static final int CATEGORY_A2DP_CONNECT_ISSUE = 1;
    public static final int CATEGORY_ABNORMAL_DISCONNECT_ISSUE = 5;
    public static final int CATEGORY_ABSOLUTE_VOLUME_ISSUE = 2;
    public static final int CATEGORY_AT_COMMAND_ISSUE = 4;
    public static final int CATEGORY_AVDTP_STATE_ISSUE = 3;
    public static final int CATEGORY_AVRCP_CONNECT_ISSUE = 1;
    public static final int CATEGORY_CALL_STATE_ISSUE = 6;
    public static final int CATEGORY_DELAY_REPORT_ISSUE = 4;
    public static final int CATEGORY_ENCRYPTION_ISSUE = 4;
    public static final int CATEGORY_HFP_CODEC_ISSUE = 3;
    public static final int CATEGORY_HFP_CONNECT_ISSUE = 1;
    public static final int CATEGORY_HFP_VOLUME_ISSUE = 2;
    public static final int CATEGORY_HID_CONNECT_ISSUE = 1;
    public static final int CATEGORY_LATENCY_ISSUE = 6;
    public static final int CATEGORY_PAIRING_ISSUE = 3;
    public static final int CATEGORY_PASSTHROUGH_CMD_ISSUE = 4;
    public static final int CATEGORY_PLAYBACK_STATUS_ISSUE = 3;
    public static final int CATEGORY_PLAYER_SETTINGS_ISSUE = 5;
    public static final int CATEGORY_RECONFIGURE_ISSUE = 5;
    public static final int CATEGORY_RING_ISSUE = 7;
    public static final int CATEGORY_ROLE_SWITCH_ISSUE = 1;
    public static final int CATEGORY_SCO_ISSUE = 5;
    public static final int CATEGORY_SNIFF_MODE_ISSUE = 2;
    public static final int CATEGORY_TRANSPORT_STABILITY_ISSUE = 7;
    public static final Parcelable.Creator<CaeBluetoothEvent> CREATOR = null;
    public static final int GAP = 1;
    public static final int HFP = 3;
    public static final int HID = 5;
    private static final String TAG = "CaeBluetoothEvent";
    private BluetoothDevice mBluetoothDevice;
    private int mCategory;
    private String mDetailMessage;
    private int mProfile;

    public class a implements Parcelable.Creator<CaeBluetoothEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CaeBluetoothEvent createFromParcel(Parcel r8) {
            return new CaeBluetoothEvent(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final CaeBluetoothEvent[] newArray(int r8) {
            return new CaeBluetoothEvent[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public CaeBluetoothEvent(BluetoothDevice r8, int r10, int r11, String r12) {
        this.mBluetoothDevice = r8;
        this.mProfile = r10;
        this.mCategory = r11;
        this.mDetailMessage = r12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public String getDetailMessage() {
        return this.mDetailMessage;
    }

    public int getProfile() {
        return this.mProfile;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.mBluetoothDevice, 0);
        r8.writeInt(this.mProfile);
        r8.writeInt(this.mCategory);
        r8.writeString(this.mDetailMessage);
    }

    public CaeBluetoothEvent(Parcel r8) {
        this.mBluetoothDevice = (BluetoothDevice) r8.readParcelable(null);
        this.mProfile = r8.readInt();
        this.mCategory = r8.readInt();
        this.mDetailMessage = r8.readString();
    }
}
