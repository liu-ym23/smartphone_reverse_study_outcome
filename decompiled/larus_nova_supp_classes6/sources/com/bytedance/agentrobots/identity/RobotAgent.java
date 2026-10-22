package com.bytedance.agentrobots.identity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class RobotAgent implements Parcelable {
    public static final Parcelable.Creator<RobotAgent> CREATOR = null;
    public final String a;
    public final RobotAgentType b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final String g;
    public final List<String> h;

    public RobotAgent() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RobotAgent(Parcel r3) {
        this.a = r3.readString();
        String r0 = r3.readString();
        if (r0 == null) goto L5;
        RobotAgentType r1 = RobotAgentType.valueOf(r0);
    L6:
        this.b = r1;
        this.c = r3.readString();
        this.d = r3.readString();
        this.g = r3.readString();
        this.e = r3.readString();
        this.h = r3.createStringArrayList();
        this.f = r3.readLong();
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.a);
        RobotAgentType r5 = this.b;
        if (r5 == null) goto L5;
        String r6 = r5.name();
    L6:
        r3.writeString(r6);
        r3.writeString(this.c);
        r3.writeString(this.d);
        r3.writeString(this.g);
        r3.writeString(this.e);
        r3.writeStringList(this.h);
        r3.writeLong(this.f);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
