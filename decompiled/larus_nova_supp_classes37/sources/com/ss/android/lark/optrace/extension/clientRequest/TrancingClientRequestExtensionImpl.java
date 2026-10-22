package com.ss.android.lark.optrace.extension.clientRequest;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.extension.TracingExtension;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class TrancingClientRequestExtensionImpl extends TrancingClientRequestExtension implements Parcelable {
    public static final Parcelable.Creator<TrancingClientRequestExtensionImpl> CREATOR = null;
    private String requestId;

    public class a implements Parcelable.Creator<TrancingClientRequestExtensionImpl> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TrancingClientRequestExtensionImpl createFromParcel(Parcel r2) {
            return new TrancingClientRequestExtensionImpl(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TrancingClientRequestExtensionImpl[] newArray(int r1) {
            return new TrancingClientRequestExtensionImpl[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.optrace.extension.clientRequest.TrancingClientRequestExtension, com.ss.android.lark.optrace.extension.TracingExtension
    public TracingExtension mergeExtension(TracingExtension r1) {
        return this;
    }

    static {
        CREATOR = new a();
    }

    public TrancingClientRequestExtensionImpl() {
    }

    @Override // com.ss.android.lark.optrace.extension.clientRequest.TrancingClientRequestExtension
    public String getRequestId() {
        return this.requestId;
    }

    public TrancingClientRequestExtensionImpl(Parcel r1) {
        this.requestId = r1.readString();
    }

    @Override // com.ss.android.lark.optrace.extension.clientRequest.TrancingClientRequestExtension
    public void setRequestId(String r3) {
        if (TextUtils.isEmpty(this.requestId) == true) goto L6;
        Log.i("TrancingClientRequestExtensionImpl", " requestid has generated " + r3);
        return;
    L6:
        this.requestId = r3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.requestId);
    }
}
