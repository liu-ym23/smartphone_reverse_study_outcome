package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class RobotAgentRegRes implements Parcelable {
    public static final Parcelable.Creator<RobotAgentRegRes> CREATOR = null;
    public int a;
    public final RobotAgent b;
    public final RobotAgentProof c;
    public final RobotDeviceStatus d;

    public RobotAgentRegRes() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotAgentRegRes(Parcel r2) {
        this.a = r2.readInt();
        this.b = (RobotAgent) r2.readParcelable(RobotAgent.class.getClassLoader());
        this.c = (RobotAgentProof) r2.readParcelable(RobotAgentProof.class.getClassLoader());
        this.d = (RobotDeviceStatus) r2.readParcelable(RobotDeviceStatus.class.getClassLoader());
    }

    public void setResult(int r1) {
        this.a = r1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(this.a);
        r2.writeParcelable(this.b, r3);
        r2.writeParcelable(this.c, r3);
        r2.writeParcelable(this.d, r3);
    }
}
