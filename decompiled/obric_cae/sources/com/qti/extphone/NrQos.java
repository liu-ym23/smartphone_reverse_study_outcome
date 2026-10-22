package com.qti.extphone;

import android.aimedia.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class NrQos extends Qos implements Parcelable {
    public static final Parcelable.Creator<NrQos> CREATOR = null;
    int averagingWindowMs;
    int fiveQi;
    int qosFlowId;

    static {
        CREATOR = new AnonymousClass1();
    }

    public NrQos(android.hardware.radio.V1_6.NrQos r8) {
        super(2, r8.downlink, r8.uplink);
        this.fiveQi = r8.fiveQi;
        this.qosFlowId = r8.qfi;
        this.averagingWindowMs = r8.averagingWindowMs;
    }

    public static NrQos createFromParcelBody(Parcel r8) {
        return new NrQos(r8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.qti.extphone.Qos
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L22:
        return false;
    L8:
        if ((r8 instanceof NrQos) == false) goto L22;
        NrQos r10 = (NrQos) r8;
        if (super.equals(r10) == true) goto L14;
        return false;
    L14:
        if (this.qosFlowId != r10.qosFlowId) goto L21;
        if (this.fiveQi != r10.fiveQi) goto L21;
        if (this.averagingWindowMs != r10.averagingWindowMs) goto L21;
        return true;
    L21:
        return false;
    }

    public int get5Qi() {
        return this.fiveQi;
    }

    public int getAveragingWindow() {
        return this.averagingWindowMs;
    }

    public int getQfi() {
        return this.qosFlowId;
    }

    @Override // com.qti.extphone.Qos
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.qosFlowId), Integer.valueOf(this.fiveQi), Integer.valueOf(this.averagingWindowMs)});
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("NrQos { fiveQi=");
        r8.append(this.fiveQi);
        r8.append(" downlink=");
        r8.append(this.downlink);
        r8.append(" uplink=");
        r8.append(this.uplink);
        r8.append(" qosFlowId=");
        r8.append(this.qosFlowId);
        r8.append(" averagingWindowMs=");
        return a.h(r8, this.averagingWindowMs, "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        super.writeToParcel(2, r8, r10);
        r8.writeInt(this.qosFlowId);
        r8.writeInt(this.fiveQi);
        r8.writeInt(this.averagingWindowMs);
    }

    private NrQos(Parcel r8) {
        super(r8);
        this.qosFlowId = r8.readInt();
        this.fiveQi = r8.readInt();
        this.averagingWindowMs = r8.readInt();
    }

    public /* synthetic */ NrQos(Parcel r8, int r10) {
        this(r8);
    }
}
