package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class RobotAgentProof implements Parcelable {
    public static final Parcelable.Creator<RobotAgentProof> CREATOR = null;
    public final String a;
    public final String b;
    public final RobotDeviceStatus c;
    public final byte[] d;
    public final List<String> e;
    public final byte[] f;

    public RobotAgentProof() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotAgentProof(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = (RobotDeviceStatus) r2.readParcelable(RobotDeviceStatus.class.getClassLoader());
        this.d = r2.createByteArray();
        this.e = r2.createStringArrayList();
        this.f = r2.createByteArray();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.a);
        r2.writeString(this.b);
        r2.writeParcelable(this.c, r3);
        r2.writeByteArray(this.d);
        r2.writeStringList(this.e);
        r2.writeByteArray(this.f);
    }
}
