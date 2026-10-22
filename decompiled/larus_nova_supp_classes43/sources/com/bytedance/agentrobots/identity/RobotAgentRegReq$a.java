package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RobotAgentRegReq$a implements Parcelable.Creator<RobotAgentRegReq> {
    public RobotAgentRegReq$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final RobotAgentRegReq createFromParcel(Parcel r10) {
        return new RobotAgentRegReq(r10);
    }

    @Override // android.os.Parcelable.Creator
    public final RobotAgentRegReq[] newArray(int r1) {
        return new RobotAgentRegReq[r1];
    }
}
