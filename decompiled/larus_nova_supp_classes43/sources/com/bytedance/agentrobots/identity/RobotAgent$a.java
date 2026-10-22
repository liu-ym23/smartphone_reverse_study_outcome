package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RobotAgent$a implements Parcelable.Creator<RobotAgent> {
    public RobotAgent$a() {
    }

    @Override // android.os.Parcelable.Creator
    public final RobotAgent createFromParcel(Parcel r10) {
        return new RobotAgent(r10);
    }

    @Override // android.os.Parcelable.Creator
    public final RobotAgent[] newArray(int r1) {
        return new RobotAgent[r1];
    }
}
