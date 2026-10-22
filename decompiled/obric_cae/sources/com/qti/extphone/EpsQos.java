package com.qti.extphone;

import android.hardware.radio.V1_6.QosBandwidth;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class EpsQos extends Qos implements Parcelable {
    public static final Parcelable.Creator<EpsQos> CREATOR = null;
    int qosClassId;

    static {
        CREATOR = new AnonymousClass1();
    }

    public EpsQos() {
        super(1, new QosBandwidth(), new QosBandwidth());
    }

    public static EpsQos createFromParcelBody(Parcel r8) {
        return new EpsQos(r8);
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
    L17:
        return false;
    L8:
        if ((r8 instanceof EpsQos) == false) goto L17;
        EpsQos r10 = (EpsQos) r8;
        if (this.qosClassId != r10.qosClassId) goto L16;
        if (super.equals(r10) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int getQci() {
        return this.qosClassId;
    }

    @Override // com.qti.extphone.Qos
    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), Integer.valueOf(this.qosClassId)});
    }

    public String toString() {
        return "EpsQos { qosClassId=" + this.qosClassId + " downlink=" + this.downlink + " uplink=" + this.uplink + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        super.writeToParcel(1, r8, r10);
        r8.writeInt(this.qosClassId);
    }

    public EpsQos(android.hardware.radio.V1_6.EpsQos r8) {
        super(1, r8.downlink, r8.uplink);
        this.qosClassId = r8.qci;
    }

    private EpsQos(Parcel r8) {
        super(r8);
        this.qosClassId = r8.readInt();
    }

    public /* synthetic */ EpsQos(Parcel r8, int r10) {
        this(r8);
    }
}
