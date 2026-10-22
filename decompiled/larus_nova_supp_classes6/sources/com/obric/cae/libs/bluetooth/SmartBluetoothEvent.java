package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class SmartBluetoothEvent implements Parcelable {
    public static final Parcelable.Creator<SmartBluetoothEvent> CREATOR = null;
    private static final int PROFILE_PBAP = 6;
    private static final int VERSION = 1;
    private final BluetoothDevice mBluetoothDevice;
    private final int mProfile;
    private final int mState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getProfileName() {
        int r0 = this.mProfile;
        if (r0 != 1) goto L5;
        return "HEADSET";
    L5:
        if (r0 != 2) goto L7;
        return "A2DP";
    L7:
        if (r0 != 6) goto L9;
        return "PBAP";
    L9:
        if (r0 == 7) goto L12;
        return "WAIT_ADAPT";
    L12:
        return "GATT";
    }

    public String getStateName() {
        int r0 = this.mProfile;
        if (r0 != 1) goto L28;
        int r1 = this.mState;
        if (r1 != HeadsetState.STATE_DISCONNECTED.getValue()) goto L8;
        return "STATE_DISCONNECTED";
    L8:
        if (r1 != HeadsetState.STATE_CONNECTING.getValue()) goto L11;
        return "STATE_CONNECTING";
    L11:
        if (r1 != HeadsetState.STATE_CONNECTED.getValue()) goto L14;
        return "STATE_CONNECTED";
    L14:
        if (r1 != HeadsetState.STATE_DISCONNECTING.getValue()) goto L17;
        return "STATE_DISCONNECTING";
    L17:
        if (r1 != HeadsetState.STATE_AUDIO_DISCONNECTED.getValue()) goto L20;
        return "STATE_AUDIO_DISCONNECTED";
    L20:
        if (r1 != HeadsetState.STATE_AUDIO_CONNECTING.getValue()) goto L23;
        return "STATE_AUDIO_CONNECTING";
    L23:
        if (r1 != HeadsetState.STATE_AUDIO_CONNECTED.getValue()) goto L26;
        return "STATE_AUDIO_CONNECTED";
    L26:
        return "UNKNOWN";
    L28:
        if (r0 != 2) goto L50;
        int r2 = this.mState;
        if (r2 != A2dpState.STATE_DISCONNECTED.getValue()) goto L33;
        return "STATE_DISCONNECTED";
    L33:
        if (r2 != A2dpState.STATE_CONNECTING.getValue()) goto L36;
        return "STATE_CONNECTING";
    L36:
        if (r2 != A2dpState.STATE_CONNECTED.getValue()) goto L39;
        return "STATE_CONNECTED";
    L39:
        if (r2 != A2dpState.STATE_DISCONNECTING.getValue()) goto L42;
        return "STATE_DISCONNECTING";
    L42:
        if (r2 != A2dpState.STATE_PLAYING.getValue()) goto L45;
        return "STATE_PLAYING";
    L45:
        if (r2 != A2dpState.STATE_NOT_PLAYING.getValue()) goto L48;
        return "STATE_NOT_PLAYING";
    L48:
        return "UNKNOWN";
    L50:
        if (r0 != 6) goto L66;
        int r3 = this.mState;
        if (r3 != PbapState.STATE_DISCONNECTED.getValue()) goto L55;
        return "STATE_DISCONNECTED";
    L55:
        if (r3 != PbapState.STATE_CONNECTING.getValue()) goto L58;
        return "STATE_CONNECTING";
    L58:
        if (r3 != PbapState.STATE_CONNECTED.getValue()) goto L61;
        return "STATE_CONNECTED";
    L61:
        if (r3 != PbapState.STATE_DISCONNECTING.getValue()) goto L64;
        return "STATE_DISCONNECTING";
    L64:
        return "UNKNOWN";
    L66:
        if (r0 != 7) goto L74;
        int r4 = this.mState;
        if (r4 != GattState.STATE_DISCONNECTED.getValue()) goto L71;
        return "STATE_DISCONNECTED";
    L71:
        if (r4 == GattState.STATE_CONNECTED.getValue()) goto L73;
        return "UNKNOWN";
    L73:
        return "STATE_CONNECTED";
    L74:
        return "WAIT_ADAPT";
    }

    public String toString() {
        if (this.mBluetoothDevice != null) goto L7;
        return "null";
    L7:
        return "SmartBluetoothEvent[1, " + this.mBluetoothDevice.getName() + ", " + this.mBluetoothDevice.getAddress() + ", " + getProfileName() + ", " + getStateName() + ']';
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public int getProfile() {
        return this.mProfile;
    }

    public int getState() {
        return this.mState;
    }

    public SmartBluetoothEvent(Parcel r2) {
        this.mBluetoothDevice = (BluetoothDevice) r2.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mProfile = r2.readInt();
        this.mState = r2.readInt();
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L17;
        SmartBluetoothEvent r5 = (SmartBluetoothEvent) r4;
        if (this.mProfile != r5.mProfile) goto L17;
        if (this.mState != r5.mState) goto L17;
        return Objects.equals(this.mBluetoothDevice, r5.mBluetoothDevice);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.mBluetoothDevice, 0);
        r2.writeInt(this.mProfile);
        r2.writeInt(this.mState);
    }

    public SmartBluetoothEvent(BluetoothDevice r1, int r2, int r3) {
        this.mBluetoothDevice = r1;
        this.mProfile = r2;
        this.mState = r3;
    }
}
