package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f403b;

    public static class a implements Parcelable.Creator<RatingCompat> {
        @Override // android.os.Parcelable.Creator
        public final RatingCompat createFromParcel(Parcel r8) {
            return new RatingCompat(r8.readInt(), r8.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final RatingCompat[] newArray(int r8) {
            return new RatingCompat[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public RatingCompat(int r8, float r10) {
        this.f402a = r8;
        this.f403b = r10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f402a;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("Rating:style=");
        r8.append(this.f402a);
        r8.append(" rating=");
        float r10 = this.f403b;
        if (r10 >= 0.0f) goto L5;
        String r11 = "unrated";
    L6:
        r8.append(r11);
        return r8.toString();
    L5:
        r11 = String.valueOf(r10);
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f402a);
        r8.writeFloat(this.f403b);
    }
}
