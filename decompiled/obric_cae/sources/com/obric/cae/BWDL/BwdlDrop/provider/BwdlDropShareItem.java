package com.obric.cae.BWDL.BwdlDrop.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.cae.BWDL.BwdlDrop.BwdlDropUtils;
import com.obric.cae.log.CaeLog;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class BwdlDropShareItem implements Parcelable {
    public static final Parcelable.Creator<BwdlDropShareItem> CREATOR = null;
    private static final String TAG = "BwdlDropShareItem";
    private Context mContext;
    private FileInputStream mFileInputStream;
    private String mFileName;
    private String mMimeType;
    private long mSize;
    private Uri mUri;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BwdlDropShareItem(Context r8, Uri r10, String r11, long r12, FileInputStream r13) {
        this.mContext = r8;
        this.mUri = r10;
        this.mMimeType = r11;
        this.mFileName = BwdlDropUtils.getFileName(r10, r8);
        this.mSize = r12;
        this.mFileInputStream = r13;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FileInputStream getFileInputStream() {
        return this.mFileInputStream;
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

    public Uri getUri() {
        return this.mUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeParcelable(this.mUri, r10);
        r8.writeString16NoHelper(this.mFileName);
        r8.writeString16NoHelper(this.mMimeType);
        r8.writeLong(this.mSize);
    }

    public BwdlDropShareItem(Context r8, Uri r10, String r11, FileInputStream r12) {
        this.mContext = r8;
        this.mUri = r10;
        this.mMimeType = r11;
        this.mFileName = BwdlDropUtils.getFileName(r10, r8);
        this.mSize = r12.getChannel().size();     // Catch: IOException -> L5
    L7:
        this.mFileInputStream = r12;
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "IOException:" + e.getMessage());
        goto L7
    }

    public BwdlDropShareItem(Parcel r8) {
        this.mUri = (Uri) r8.readParcelable(Uri.class.getClassLoader());
        this.mFileName = r8.readString16NoHelper();
        this.mMimeType = r8.readString16NoHelper();
        this.mSize = r8.readLong();
    }
}
