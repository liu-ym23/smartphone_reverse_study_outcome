package com.bytedance.android.live.base.event;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RoomStatusEvent implements Parcelable {
    public static final Parcelable.Creator<RoomStatusEvent> CREATOR = null;
    public long a;
    public long b;
    public final String c;
    public boolean d;
    public int e;
    public List<Long> f;

    public class a implements Parcelable.Creator<RoomStatusEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RoomStatusEvent createFromParcel(Parcel r2) {
            return new RoomStatusEvent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final RoomStatusEvent[] newArray(int r1) {
            return new RoomStatusEvent[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public RoomStatusEvent() {
    }

    public RoomStatusEvent(Parcel r3) {
        this.a = r3.readLong();
        this.b = r3.readLong();
        this.c = r3.readString();
        if (r3.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.d = r0;
        this.e = r3.readInt();
        ArrayList r1 = new ArrayList();
        this.f = r1;
        r3.readList(r1, List.class.getClassLoader());
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.a);
        r3.writeLong(this.b);
        r3.writeString(this.c);
        r3.writeByte(this.d ? 1 : 0);
        r3.writeInt(this.e);
        r3.writeList(this.f);
    }
}
