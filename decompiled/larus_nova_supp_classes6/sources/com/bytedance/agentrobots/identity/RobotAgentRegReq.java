package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class RobotAgentRegReq implements Parcelable {
    public static final Parcelable.Creator<RobotAgentRegReq> CREATOR = null;
    public final String a;
    public final RobotAgentType b;
    public final String c;
    public final List<String> d;

    public RobotAgentRegReq() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotAgentRegReq(Parcel r3) {
        this.a = r3.readString();
        int r0 = r3.readInt();
        if (r0 != (-1)) goto L5;
        RobotAgentType r1 = null;
    L6:
        this.b = r1;
        this.c = r3.readString();
        this.d = r3.createStringArrayList();
        return;
    L5:
        r1 = RobotAgentType.values()[r0];
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        RobotAgentType r3 = this.b;
        if (r3 == null) goto L5;
        int r4 = r3.ordinal();
    L6:
        r1.writeInt(r4);
        r1.writeString(this.c);
        r1.writeStringList(this.d);
        return;
    L5:
        r4 = -1;
        goto L6
    }
}
