package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothEvent implements Parcelable {
    public static final Parcelable.Creator<SmartBluetoothEvent> CREATOR = null;
    private static final int PROFILE_PBAP = 6;
    private static final int VERSION = 1;
    private final BluetoothDevice mBluetoothDevice;
    private final int mProfile;
    private final int mState;

    public static final enum A2dpState extends Enum<A2dpState> {
        public static final A2dpState STATE_CONNECTED = null;
        public static final A2dpState STATE_CONNECTING = null;
        public static final A2dpState STATE_DISCONNECTED = null;
        public static final A2dpState STATE_DISCONNECTING = null;
        public static final A2dpState STATE_NOT_PLAYING = null;
        public static final A2dpState STATE_PLAYING = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ A2dpState[] f5388b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5389a;

        static {
            A2dpState r8 = new A2dpState(0, 0, "STATE_DISCONNECTED");
            STATE_DISCONNECTED = r8;
            A2dpState r10 = new A2dpState(1, 1, "STATE_CONNECTING");
            STATE_CONNECTING = r10;
            A2dpState r11 = new A2dpState(2, 2, "STATE_CONNECTED");
            STATE_CONNECTED = r11;
            A2dpState r12 = new A2dpState(3, 3, "STATE_DISCONNECTING");
            STATE_DISCONNECTING = r12;
            A2dpState r13 = new A2dpState(4, 10, "STATE_PLAYING");
            STATE_PLAYING = r13;
            A2dpState r14 = new A2dpState(5, 11, "STATE_NOT_PLAYING");
            STATE_NOT_PLAYING = r14;
            f5388b = new A2dpState[]{r8, r10, r11, r12, r13, r14};
        }

        public A2dpState(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5389a = r10;
        }

        public static A2dpState valueOf(String r8) {
            return (A2dpState) Enum.valueOf(A2dpState.class, r8);
        }

        public static A2dpState[] values() {
            return (A2dpState[]) f5388b.clone();
        }

        public int getValue() {
            return this.f5389a;
        }
    }

    public static final enum GattState extends Enum<GattState> {
        public static final GattState STATE_CONNECTED = null;
        public static final GattState STATE_DISCONNECTED = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GattState[] f5390b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5391a;

        static {
            GattState r8 = new GattState(0, 0, "STATE_DISCONNECTED");
            STATE_DISCONNECTED = r8;
            GattState r10 = new GattState(1, 2, "STATE_CONNECTED");
            STATE_CONNECTED = r10;
            f5390b = new GattState[]{r8, r10};
        }

        public GattState(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5391a = r10;
        }

        public static GattState valueOf(String r8) {
            return (GattState) Enum.valueOf(GattState.class, r8);
        }

        public static GattState[] values() {
            return (GattState[]) f5390b.clone();
        }

        public int getValue() {
            return this.f5391a;
        }
    }

    public static final enum HeadsetState extends Enum<HeadsetState> {
        public static final HeadsetState STATE_AUDIO_CONNECTED = null;
        public static final HeadsetState STATE_AUDIO_CONNECTING = null;
        public static final HeadsetState STATE_AUDIO_DISCONNECTED = null;
        public static final HeadsetState STATE_CONNECTED = null;
        public static final HeadsetState STATE_CONNECTING = null;
        public static final HeadsetState STATE_DISCONNECTED = null;
        public static final HeadsetState STATE_DISCONNECTING = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ HeadsetState[] f5392b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5393a;

        static {
            HeadsetState r8 = new HeadsetState(0, 0, "STATE_DISCONNECTED");
            STATE_DISCONNECTED = r8;
            HeadsetState r10 = new HeadsetState(1, 1, "STATE_CONNECTING");
            STATE_CONNECTING = r10;
            HeadsetState r11 = new HeadsetState(2, 2, "STATE_CONNECTED");
            STATE_CONNECTED = r11;
            HeadsetState r12 = new HeadsetState(3, 3, "STATE_DISCONNECTING");
            STATE_DISCONNECTING = r12;
            HeadsetState r13 = new HeadsetState(4, 10, "STATE_AUDIO_DISCONNECTED");
            STATE_AUDIO_DISCONNECTED = r13;
            HeadsetState r14 = new HeadsetState(5, 11, "STATE_AUDIO_CONNECTING");
            STATE_AUDIO_CONNECTING = r14;
            HeadsetState r15 = new HeadsetState(6, 12, "STATE_AUDIO_CONNECTED");
            STATE_AUDIO_CONNECTED = r15;
            f5392b = new HeadsetState[]{r8, r10, r11, r12, r13, r14, r15};
        }

        public HeadsetState(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5393a = r10;
        }

        public static HeadsetState valueOf(String r8) {
            return (HeadsetState) Enum.valueOf(HeadsetState.class, r8);
        }

        public static HeadsetState[] values() {
            return (HeadsetState[]) f5392b.clone();
        }

        public int getValue() {
            return this.f5393a;
        }
    }

    public static final enum PbapState extends Enum<PbapState> {
        public static final PbapState STATE_CONNECTED = null;
        public static final PbapState STATE_CONNECTING = null;
        public static final PbapState STATE_DISCONNECTED = null;
        public static final PbapState STATE_DISCONNECTING = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PbapState[] f5394b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5395a;

        static {
            PbapState r8 = new PbapState(0, 0, "STATE_DISCONNECTED");
            STATE_DISCONNECTED = r8;
            PbapState r10 = new PbapState(1, 1, "STATE_CONNECTING");
            STATE_CONNECTING = r10;
            PbapState r11 = new PbapState(2, 2, "STATE_CONNECTED");
            STATE_CONNECTED = r11;
            PbapState r12 = new PbapState(3, 3, "STATE_DISCONNECTING");
            STATE_DISCONNECTING = r12;
            f5394b = new PbapState[]{r8, r10, r11, r12};
        }

        public PbapState(int r8, int r10, String r11) {
            super(r11, r8);
            this.f5395a = r10;
        }

        public static PbapState valueOf(String r8) {
            return (PbapState) Enum.valueOf(PbapState.class, r8);
        }

        public static PbapState[] values() {
            return (PbapState[]) f5394b.clone();
        }

        public int getValue() {
            return this.f5395a;
        }
    }

    public class a implements Parcelable.Creator<SmartBluetoothEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SmartBluetoothEvent createFromParcel(Parcel r8) {
            return new SmartBluetoothEvent(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final SmartBluetoothEvent[] newArray(int r8) {
            return new SmartBluetoothEvent[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public SmartBluetoothEvent(BluetoothDevice r8, int r10, int r11) {
        this.mBluetoothDevice = r8;
        this.mProfile = r10;
        this.mState = r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L17;
        SmartBluetoothEvent r10 = (SmartBluetoothEvent) r8;
        if (this.mProfile != r10.mProfile) goto L17;
        if (this.mState != r10.mState) goto L17;
        return Objects.equals(this.mBluetoothDevice, r10.mBluetoothDevice);
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public int getProfile() {
        return this.mProfile;
    }

    public String getProfileName() {
        int r8 = this.mProfile;
        if (r8 != 1) goto L5;
        return BdimCategoryConstants.CATEGORY_HEADSET;
    L5:
        if (r8 != 2) goto L7;
        return "A2DP";
    L7:
        if (r8 != 6) goto L9;
        return "PBAP";
    L9:
        if (r8 == 7) goto L12;
        return "WAIT_ADAPT";
    L12:
        return "GATT";
    }

    public int getState() {
        return this.mState;
    }

    public String getStateName() {
        int r8 = this.mProfile;
        if (r8 != 1) goto L28;
        int r10 = this.mState;
        if (r10 != HeadsetState.STATE_DISCONNECTED.getValue()) goto L8;
        return "STATE_DISCONNECTED";
    L8:
        if (r10 != HeadsetState.STATE_CONNECTING.getValue()) goto L11;
        return "STATE_CONNECTING";
    L11:
        if (r10 != HeadsetState.STATE_CONNECTED.getValue()) goto L14;
        return "STATE_CONNECTED";
    L14:
        if (r10 != HeadsetState.STATE_DISCONNECTING.getValue()) goto L17;
        return "STATE_DISCONNECTING";
    L17:
        if (r10 != HeadsetState.STATE_AUDIO_DISCONNECTED.getValue()) goto L20;
        return "STATE_AUDIO_DISCONNECTED";
    L20:
        if (r10 != HeadsetState.STATE_AUDIO_CONNECTING.getValue()) goto L23;
        return "STATE_AUDIO_CONNECTING";
    L23:
        if (r10 != HeadsetState.STATE_AUDIO_CONNECTED.getValue()) goto L26;
        return "STATE_AUDIO_CONNECTED";
    L26:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L28:
        if (r8 != 2) goto L50;
        int r11 = this.mState;
        if (r11 != A2dpState.STATE_DISCONNECTED.getValue()) goto L33;
        return "STATE_DISCONNECTED";
    L33:
        if (r11 != A2dpState.STATE_CONNECTING.getValue()) goto L36;
        return "STATE_CONNECTING";
    L36:
        if (r11 != A2dpState.STATE_CONNECTED.getValue()) goto L39;
        return "STATE_CONNECTED";
    L39:
        if (r11 != A2dpState.STATE_DISCONNECTING.getValue()) goto L42;
        return "STATE_DISCONNECTING";
    L42:
        if (r11 != A2dpState.STATE_PLAYING.getValue()) goto L45;
        return "STATE_PLAYING";
    L45:
        if (r11 != A2dpState.STATE_NOT_PLAYING.getValue()) goto L48;
        return "STATE_NOT_PLAYING";
    L48:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L50:
        if (r8 != 6) goto L66;
        int r12 = this.mState;
        if (r12 != PbapState.STATE_DISCONNECTED.getValue()) goto L55;
        return "STATE_DISCONNECTED";
    L55:
        if (r12 != PbapState.STATE_CONNECTING.getValue()) goto L58;
        return "STATE_CONNECTING";
    L58:
        if (r12 != PbapState.STATE_CONNECTED.getValue()) goto L61;
        return "STATE_CONNECTED";
    L61:
        if (r12 != PbapState.STATE_DISCONNECTING.getValue()) goto L64;
        return "STATE_DISCONNECTING";
    L64:
        return BdimCategoryConstants.VALUE_UNKNOWN;
    L66:
        if (r8 != 7) goto L74;
        int r13 = this.mState;
        if (r13 != GattState.STATE_DISCONNECTED.getValue()) goto L71;
        return "STATE_DISCONNECTED";
    L71:
        if (r13 == GattState.STATE_CONNECTED.getValue()) goto L73;
        return BdimCategoryConstants.VALUE_UNKNOWN;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.mBluetoothDevice, 0);
        r8.writeInt(this.mProfile);
        r8.writeInt(this.mState);
    }

    public SmartBluetoothEvent(Parcel r8) {
        this.mBluetoothDevice = (BluetoothDevice) r8.readParcelable(BluetoothDevice.class.getClassLoader());
        this.mProfile = r8.readInt();
        this.mState = r8.readInt();
    }
}
