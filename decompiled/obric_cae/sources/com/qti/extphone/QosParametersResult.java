package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class QosParametersResult implements Parcelable {
    public static final Parcelable.Creator<QosParametersResult> CREATOR = null;
    public static final int QOS_TYPE_EPS = 1;
    public static final int QOS_TYPE_NR = 2;
    private static final String TAG = "QosParametersResult";
    private final Qos mDefaultQos;
    private final List<QosBearerSession> mQosBearerSessions;

    public static final class Builder {
        private Qos mDefaultQos;
        private List<QosBearerSession> mQosBearerSessions;

        public Builder() {
            this.mQosBearerSessions = new ArrayList();
        }

        public QosParametersResult build() {
            return new QosParametersResult(this.mDefaultQos, this.mQosBearerSessions);
        }

        public Builder setDefaultQos(Qos r8) {
            this.mDefaultQos = r8;
            return this;
        }

        public Builder setQosBearerSessions(List<QosBearerSession> r8) {
            this.mQosBearerSessions = r8;
            return this;
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public QosParametersResult() {
        this.mDefaultQos = null;
        this.mQosBearerSessions = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof QosParametersResult) == true) goto L8;
        return false;
    L8:
        QosParametersResult r10 = (QosParametersResult) r8;
        Qos r11 = this.mDefaultQos;
        if (r11 == null) goto L15;
        Qos r12 = r10.mDefaultQos;
        if (r12 == null) goto L15;
        boolean r13 = r11.equals(r12);
    L18:
        List<QosBearerSession> r14 = this.mQosBearerSessions;
        if (r14 == null) goto L29;
        if (r10.mQosBearerSessions == null) goto L29;
        if (r14.size() == r10.mQosBearerSessions.size()) goto L26;
    L31:
        boolean r15 = false;
    L32:
        if (r13 == false) goto L36;
        if (r15 == false) goto L36;
        return true;
    L36:
        return false;
    L26:
        if (this.mQosBearerSessions.containsAll(r10.mQosBearerSessions) == false) goto L31;
    L30:
        r15 = true;
    L29:
        if (r14 != r10.mQosBearerSessions) goto L31;
    L15:
        if (r11 != r10.mDefaultQos) goto L17;
        r13 = true;
        goto L18
    L17:
        r13 = false;
        goto L18
    }

    public Qos getDefaultQos() {
        return this.mDefaultQos;
    }

    public List<QosBearerSession> getQosBearerSessions() {
        return this.mQosBearerSessions;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mDefaultQos, this.mQosBearerSessions});
    }

    public String toString() {
        StringBuffer r8 = new StringBuffer("QosParametersResult: { defaultQos=");
        r8.append(this.mDefaultQos);
        r8.append(" qosBearerSessions=");
        r8.append(this.mQosBearerSessions);
        r8.append("}");
        return r8.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        Qos r11 = this.mDefaultQos;
        if (r11 != null) goto L5;
        Parcelable r12 = null;
    L9:
        r8.writeParcelable(r12, r10);
        r8.writeList(this.mQosBearerSessions);
        return;
    L5:
        if (r11.getType() != 1) goto L7;
        r12 = (EpsQos) this.mDefaultQos;
        goto L9
    L7:
        r12 = (NrQos) this.mDefaultQos;
        goto L9
    }

    public QosParametersResult(Parcel r8) {
        this.mDefaultQos = (Qos) r8.readParcelable(Qos.class.getClassLoader());
        ArrayList r10 = new ArrayList();
        this.mQosBearerSessions = r10;
        r8.readList(r10, QosBearerSession.class.getClassLoader());
    }

    public QosParametersResult(Qos r8, List<QosBearerSession> r10) {
        this.mDefaultQos = r8;
        if (r10 != null) goto L5;
        ArrayList r11 = new ArrayList();
    L6:
        this.mQosBearerSessions = r11;
        return;
    L5:
        r11 = new ArrayList(r10);
        goto L6
    }
}
