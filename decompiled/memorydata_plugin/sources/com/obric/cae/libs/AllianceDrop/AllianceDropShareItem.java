package com.obric.cae.libs.AllianceDrop;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class AllianceDropShareItem implements Parcelable {
    public static final Parcelable.Creator<AllianceDropShareItem> CREATOR = null;
    public static final int STATUS_FAILED = 2;
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_UNKNOWN = 0;
    private static final String TAG = "AllianceDropShareItem";
    private final String mFileName;
    private final String mMimeType;
    private final long mSize;
    private int mStatus;
    private Uri mUri;

    public class a implements Parcelable.Creator<AllianceDropShareItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AllianceDropShareItem createFromParcel(Parcel r1) {
            return new AllianceDropShareItem(r1);
        }

        @Override // android.os.Parcelable.Creator
        public final AllianceDropShareItem[] newArray(int r1) {
            return new AllianceDropShareItem[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AllianceDropShareItem(Uri r2, String r3, long r4, String r6) {
        this.mStatus = 0;
        this.mUri = r2;
        this.mMimeType = r3;
        this.mFileName = r6;
        this.mSize = r4;
    }

    public AllianceDropShareItem(Parcel r4) {
        this.mStatus = 0;
        String r1 = r4.readString();
        if (r1 == null) goto L5;
        Uri r2 = Uri.parse(r1);
    L6:
        this.mUri = r2;
        this.mFileName = r4.readString();
        this.mMimeType = r4.readString();
        this.mSize = r4.readLong();
    L11:
        this.mStatus = 0;
        return;
    L8:
        if (r4.dataAvail() <= 0) goto L15;
        this.mStatus = r4.readInt();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public long getSize() {
        return this.mSize;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public void setStatus(int r2) {
        if (r2 != 0) goto L4;
    L8:
        this.mStatus = r2;
        return;
    L4:
        if (r2 == 1) goto L8;
        if (r2 == 2) goto L8;
        r2 = 0;
        goto L8
    }

    public void setUri(Uri r1) {
        this.mUri = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Uri r5 = this.mUri;
        if (r5 == null) goto L5;
        String r6 = r5.toString();
    L6:
        r3.writeString(r6);
        r3.writeString(this.mFileName);
        r3.writeString(this.mMimeType);
        r3.writeLong(this.mSize);
        r3.writeInt(this.mStatus);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
