package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class NewMsgTimeHolder implements Parcelable {
    public static final Parcelable.Creator<NewMsgTimeHolder> CREATOR = null;
    public final long endDecodeTs;
    public final long receiveRawDataTs;
    public final long startDecodeTs;

    static class a implements Parcelable.Creator<NewMsgTimeHolder> {
        a() {
        }

        public NewMsgTimeHolder a(Parcel r10) {
            return new NewMsgTimeHolder(r10);
        }

        public NewMsgTimeHolder[] b(int r10) {
            return new NewMsgTimeHolder[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NewMsgTimeHolder createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NewMsgTimeHolder[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public NewMsgTimeHolder(long r10, long r11, long r12) {
        this.receiveRawDataTs = r10;
        this.startDecodeTs = r11;
        this.endDecodeTs = r12;
    }

    protected NewMsgTimeHolder(Parcel r10) {
        this.receiveRawDataTs = r10.readLong();
        this.startDecodeTs = r10.readLong();
        this.endDecodeTs = r10.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeLong(this.receiveRawDataTs);
        r10.writeLong(this.startDecodeTs);
        r10.writeLong(this.endDecodeTs);
    }
}
