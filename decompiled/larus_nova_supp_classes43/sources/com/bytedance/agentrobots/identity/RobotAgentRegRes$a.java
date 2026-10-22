package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RobotAgentRegRes$a implements Parcelable.Creator<RobotAgentRegRes> {
    public RobotAgentRegRes$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final RobotAgentRegRes createFromParcel(Parcel r10) {
        return new RobotAgentRegRes(r10);
    }

    @Override // android.os.Parcelable.Creator
    public final RobotAgentRegRes[] newArray(int r1) {
        return new RobotAgentRegRes[r1];
    }
}
