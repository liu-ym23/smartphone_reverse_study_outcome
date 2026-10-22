package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class BdDiagInfo implements Parcelable {
    public static final Parcelable.Creator<BdDiagInfo> CREATOR = null;
    private static final String TAG = "BdDiagInfo";
    private BdDiagProto.diagLogInfo diagLog;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BdDiagInfo(Parcel r8) {
        this.diagLog = BdDiagProto.diagLogInfo.parseFrom(r8.createByteArray());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BdDiagProto.diagLogInfo getLog() {
        return this.diagLog;
    }

    public String toString() {
        return "BdDiagInfo: " + this.diagLog.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        if (r8 == null) goto L7;
        BdDiagProto.diagLogInfo r11 = this.diagLog;
        if (r11 == null) goto L8;
        r8.writeByteArray(r11.toByteArray());
        return;
    L8:
        return;
    }

    public BdDiagInfo(BdDiagProto.diagLogInfo r8) {
        this.diagLog = r8;
    }
}
