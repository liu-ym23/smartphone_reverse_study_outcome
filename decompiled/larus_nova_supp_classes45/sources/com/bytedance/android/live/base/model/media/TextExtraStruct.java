package com.bytedance.android.live.base.model.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class TextExtraStruct implements Parcelable {
    public static final Parcelable.Creator<TextExtraStruct> CREATOR = null;

    @SerializedName("end")
    private int end;
    private transient boolean isAddPosition;

    @SerializedName(NewBroadcastMonitor.STAGE.START)
    private int start;

    @SerializedName("user_id")
    private long userId;

    public class a implements Parcelable.Creator<TextExtraStruct> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct createFromParcel(Parcel r2) {
            return new TextExtraStruct(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TextExtraStruct[] newArray(int r1) {
            return new TextExtraStruct[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public TextExtraStruct() {
    }

    public int getEnd() {
        return this.end;
    }

    public int getStart() {
        return this.start;
    }

    public long getUserId() {
        return this.userId;
    }

    public boolean isAddPosition() {
        return this.isAddPosition;
    }

    public TextExtraStruct(Parcel r3) {
        this.start = r3.readInt();
        this.end = r3.readInt();
        this.userId = r3.readLong();
    }

    public void setAddPosition(boolean r1) {
        this.isAddPosition = r1;
    }

    public void setEnd(int r1) {
        this.end = r1;
    }

    public void setStart(int r1) {
        this.start = r1;
    }

    public void setUserId(long r1) {
        this.userId = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.start);
        r3.writeInt(this.end);
        r3.writeLong(this.userId);
    }
}
