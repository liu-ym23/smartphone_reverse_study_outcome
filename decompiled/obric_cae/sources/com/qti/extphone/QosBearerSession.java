package com.qti.extphone;

import android.hardware.radio.V1_6.QosFilter;
import android.hardware.radio.V1_6.QosSession;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class QosBearerSession implements Parcelable {
    public static final Parcelable.Creator<QosBearerSession> CREATOR = null;
    final Qos qos;
    final List<QosBearerFilter> qosBearerFilterList;
    final int qosBearerSessionId;

    static {
        CREATOR = new AnonymousClass1();
    }

    public QosBearerSession(int r8, Qos r10, List<QosBearerFilter> r11) {
        this.qosBearerSessionId = r8;
        this.qos = r10;
        this.qosBearerFilterList = r11;
    }

    public static QosBearerSession create(QosSession r8) {
        ArrayList r10 = new ArrayList();
        ArrayList r11 = r8.qosFilters;
        if (r11 == null) goto L9;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L9;
        r10.add(QosBearerFilter.create((QosFilter) r12.next()));
    L9:
        return new QosBearerSession(r8.qosSessionId, Qos.create(r8.qos), r10);
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
    L21:
        return false;
    L8:
        if ((r8 instanceof QosBearerSession) == false) goto L21;
        QosBearerSession r10 = (QosBearerSession) r8;
        if (this.qosBearerSessionId != r10.qosBearerSessionId) goto L20;
        if (this.qos.equals(r10.qos) == false) goto L20;
        if (this.qosBearerFilterList.size() != r10.qosBearerFilterList.size()) goto L20;
        if (this.qosBearerFilterList.containsAll(r10.qosBearerFilterList) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public Qos getQos() {
        return this.qos;
    }

    public List<QosBearerFilter> getQosBearerFilterList() {
        return this.qosBearerFilterList;
    }

    public int getQosBearerSessionId() {
        return this.qosBearerSessionId;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.qosBearerSessionId), this.qos, this.qosBearerFilterList});
    }

    public String toString() {
        return "QosBearerSession { qosBearerSessionId=" + this.qosBearerSessionId + " qos=" + this.qos + " qosBearerFilterList=" + this.qosBearerFilterList + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.qosBearerSessionId);
        if (this.qos.getType() != 1) goto L5;
        Parcelable r11 = (EpsQos) this.qos;
    L6:
        r8.writeParcelable(r11, r10);
        r8.writeList(this.qosBearerFilterList);
        return;
    L5:
        r11 = (NrQos) this.qos;
        goto L6
    }

    private QosBearerSession(Parcel r8) {
        this.qosBearerSessionId = r8.readInt();
        this.qos = (Qos) r8.readParcelable(Qos.class.getClassLoader());
        ArrayList r10 = new ArrayList();
        this.qosBearerFilterList = r10;
        r8.readList(r10, QosBearerFilter.class.getClassLoader());
    }

    public /* synthetic */ QosBearerSession(Parcel r8, int r10) {
        this(r8);
    }
}
