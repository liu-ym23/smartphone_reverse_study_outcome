package com.obric.cae.libs.network.AppQoEReport;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class QoeReportParams implements Parcelable {
    public static final Parcelable.Creator<QoeReportParams> CREATOR = null;
    public int appType;
    public int businessType;
    public int eventType;
    public long value;

    public class a implements Parcelable.Creator<QoeReportParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QoeReportParams createFromParcel(Parcel r1) {
            QoeReportParams r0 = new QoeReportParams();
            r0.readFromParcel(r1);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final QoeReportParams[] newArray(int r1) {
            return new QoeReportParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QoeReportParams() {
        this.appType = 0;
        this.businessType = 0;
        this.eventType = 0;
        this.value = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r7) {
        int r0 = r7.dataPosition();
        int r1 = r7.readInt();
        if (r1 < 4) goto L44;
        if ((r7.dataPosition() - r0) >= r1) goto L8;
        this.appType = r7.readInt();     // Catch: Throwable -> L45
        if ((r7.dataPosition() - r0) >= r1) goto L17;
        this.businessType = r7.readInt();     // Catch: Throwable -> L45
        if ((r7.dataPosition() - r0) >= r1) goto L25;
        this.eventType = r7.readInt();     // Catch: Throwable -> L45
        if ((r7.dataPosition() - r0) >= r1) goto L33;
        this.value = r7.readLong();     // Catch: Throwable -> L45
        if (r0 > (Integer.MAX_VALUE - r1)) goto L42;
    L9:
        r7.setDataPosition(r0 + r1);
        return;
    L42:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L33:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L25:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r0 <= (Integer.MAX_VALUE - r1)) goto L9;
        throw new BadParcelableException("Overflow in the size of parcelable");
    L44:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L49;
        r7.setDataPosition(r0 + r1);
        throw th;
    L49:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeInt(this.appType);
        r3.writeInt(this.businessType);
        r3.writeInt(this.eventType);
        r3.writeLong(this.value);
        int r2 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r2 - r5);
        r3.setDataPosition(r2);
    }
}
