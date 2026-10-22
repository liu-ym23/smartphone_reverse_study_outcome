package com.ss.android.newmedia.activity.social;

import android.os.Parcel;
import android.os.Parcelable;
import ia.b;

/* JADX INFO: loaded from: classes2.dex */
public class ReportItem implements Parcelable {
    public static final Parcelable.Creator<ReportItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b("type")
    public final int f6718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b("text")
    public final String f6719b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f6720m;

    public static class a implements Parcelable.Creator<ReportItem> {
        @Override // android.os.Parcelable.Creator
        public final ReportItem createFromParcel(Parcel r8) {
            return new ReportItem(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final ReportItem[] newArray(int r8) {
            return new ReportItem[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public ReportItem() {
        this.f6720m = false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f6718a);
        r8.writeString(this.f6719b);
        r8.writeByte(this.f6720m ? 1 : 0);
    }

    public ReportItem(Parcel r8) {
        boolean r10 = false;
        this.f6720m = false;
        this.f6718a = r8.readInt();
        this.f6719b = r8.readString();
        if (r8.readByte() == 0) goto L5;
        r10 = true;
    L5:
        this.f6720m = r10;
    }
}
