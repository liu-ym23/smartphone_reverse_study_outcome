package vendor.oak.qshhar;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class HarEventData implements Parcelable {
    public static final Parcelable.Creator<HarEventData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12907b;

    public class a implements Parcelable.Creator<HarEventData> {
        @Override // android.os.Parcelable.Creator
        public final HarEventData createFromParcel(Parcel r8) {
            return new HarEventData(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final HarEventData[] newArray(int r8) {
            return new HarEventData[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public HarEventData() {
    }

    public HarEventData(Parcel r8) {
        int r10 = r8.readInt();
        int r11 = r8.dataPosition();
        if ((r8.dataPosition() - r11) >= r10) goto L6;
        this.f12906a = r8.readInt();
    L6:
        if ((r8.dataPosition() - r11) >= r10) goto L8;
        this.f12907b = r8.readLong();
    L8:
        r8.setDataPosition(r11 + r10);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        int r11 = r8.dataPosition();
        r8.writeInt(0);
        r8.writeInt(this.f12906a);
        r8.writeLong(this.f12907b);
        int r12 = r8.dataPosition();
        r8.setDataPosition(r11);
        android.aimedia.a.n(r12, r11, r8, r12);
    }
}
