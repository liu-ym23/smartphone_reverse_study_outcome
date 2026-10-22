package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RobotAgentProof$a implements Parcelable.Creator<RobotAgentProof> {
    public RobotAgentProof$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final RobotAgentProof createFromParcel(Parcel r10) {
        return new RobotAgentProof(r10);
    }

    @Override // android.os.Parcelable.Creator
    public final RobotAgentProof[] newArray(int r1) {
        return new RobotAgentProof[r1];
    }
}
