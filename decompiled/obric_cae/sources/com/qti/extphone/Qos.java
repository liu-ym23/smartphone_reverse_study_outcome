package com.qti.extphone;

import android.aimedia.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Qos {
    public static final int QOS_TYPE_EPS = 1;
    public static final int QOS_TYPE_NR = 2;
    final QosBandwidth downlink;

    @QosType
    final int type;
    final QosBandwidth uplink;

    public static class QosBandwidth implements Parcelable {
        public static final Parcelable.Creator<QosBandwidth> CREATOR = null;
        int guaranteedBitrateKbps;
        int maxBitrateKbps;

        static {
            CREATOR = new AnonymousClass1();
        }

        public QosBandwidth() {
        }

        public QosBandwidth(int r8, int r10) {
            this.maxBitrateKbps = r8;
            this.guaranteedBitrateKbps = r10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L17:
            return false;
        L8:
            if ((r8 instanceof QosBandwidth) == false) goto L17;
            QosBandwidth r10 = (QosBandwidth) r8;
            if (this.maxBitrateKbps != r10.maxBitrateKbps) goto L16;
            if (this.guaranteedBitrateKbps != r10.guaranteedBitrateKbps) goto L16;
            return true;
        L16:
            return false;
        }

        public int getGuaranteedBitrateKbps() {
            return this.guaranteedBitrateKbps;
        }

        public int getMaxBitrateKbps() {
            return this.maxBitrateKbps;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.maxBitrateKbps), Integer.valueOf(this.guaranteedBitrateKbps)});
        }

        public String toString() {
            StringBuilder r8 = new StringBuilder("Bandwidth { maxBitrateKbps=");
            r8.append(this.maxBitrateKbps);
            r8.append(" guaranteedBitrateKbps=");
            return a.h(r8, this.guaranteedBitrateKbps, "}");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r8, int r10) {
            r8.writeInt(this.maxBitrateKbps);
            r8.writeInt(this.guaranteedBitrateKbps);
        }

        private QosBandwidth(Parcel r8) {
            this.maxBitrateKbps = r8.readInt();
            this.guaranteedBitrateKbps = r8.readInt();
        }

        public /* synthetic */ QosBandwidth(Parcel r8, int r10) {
            this(r8);
        }
    }

    public @interface QosType {
    }

    public Qos(int r8, android.hardware.radio.V1_6.QosBandwidth r10, android.hardware.radio.V1_6.QosBandwidth r11) {
        this.type = r8;
        this.downlink = new QosBandwidth(r10.maxBitrateKbps, r10.guaranteedBitrateKbps);
        this.uplink = new QosBandwidth(r11.maxBitrateKbps, r11.guaranteedBitrateKbps);
    }

    public static Qos create(android.hardware.radio.V1_6.Qos r8) {
        byte r10 = r8.getDiscriminator();
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return null;
    L9:
        return new NrQos(r8.nr());
    L11:
        return new EpsQos(r8.eps());
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
        return true;
    L5:
        Qos r10 = (Qos) r8;
        if (this.type == r10.type) goto L8;
    L12:
        return false;
    L8:
        if (this.downlink.equals(r10.downlink) == false) goto L12;
        if (this.uplink.equals(r10.uplink) == false) goto L12;
        return true;
    }

    public QosBandwidth getDownlinkBandwidth() {
        return this.downlink;
    }

    @QosType
    public int getType() {
        return this.type;
    }

    public QosBandwidth getUplinkBandwidth() {
        return this.uplink;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.downlink, this.uplink});
    }

    public void writeToParcel(@QosType int r8, Parcel r10, int r11) {
        r10.writeInt(r8);
        r10.writeParcelable(this.downlink, r11);
        r10.writeParcelable(this.uplink, r11);
    }

    public Qos(Parcel r8) {
        this.type = r8.readInt();
        this.downlink = (QosBandwidth) r8.readParcelable(QosBandwidth.class.getClassLoader());
        this.uplink = (QosBandwidth) r8.readParcelable(QosBandwidth.class.getClassLoader());
    }
}
