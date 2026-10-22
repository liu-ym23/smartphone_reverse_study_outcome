package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f363b;

    static {
        CREATOR = new a5.b(4);
    }

    public RatingCompat(float r5, int r10) {
        this.f362a = r10;
        this.f363b = r5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f362a;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Rating:style=");
        r5.append(this.f362a);
        r5.append(" rating=");
        float r10 = this.f363b;
        if (r10 >= 0.0f) goto L5;
        String r11 = "unrated";
    L6:
        r5.append(r11);
        return r5.toString();
    L5:
        r11 = String.valueOf(r10);
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f362a);
        r5.writeFloat(this.f363b);
    }
}
