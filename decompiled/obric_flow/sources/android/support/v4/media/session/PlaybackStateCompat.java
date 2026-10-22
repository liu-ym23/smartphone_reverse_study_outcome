package android.support.v4.media.session;

import ai.j0;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f386c;
    public final float d;
    public final long e;
    public final int f;
    public final CharSequence g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f389j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f390k;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f393c;
        public final Bundle d;

        static {
            CREATOR = new g();
        }

        public CustomAction(Parcel r5) {
            this.f391a = r5.readString();
            this.f392b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r5);
            this.f393c = r5.readInt();
            this.d = r5.readBundle(f.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + this.f392b + ", mIcon=" + this.f393c + ", mExtras=" + this.d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            r5.writeString(this.f391a);
            TextUtils.writeToParcel(this.f392b, r5, r10);
            r5.writeInt(this.f393c);
            r5.writeBundle(this.d);
        }
    }

    static {
        CREATOR = new a5.b(9);
    }

    public PlaybackStateCompat(Parcel r5) {
        this.f384a = r5.readInt();
        this.f385b = r5.readLong();
        this.d = r5.readFloat();
        this.f387h = r5.readLong();
        this.f386c = r5.readLong();
        this.e = r5.readLong();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r5);
        this.f388i = r5.createTypedArrayList(CustomAction.CREATOR);
        this.f389j = r5.readLong();
        this.f390k = r5.readBundle(f.class.getClassLoader());
        this.f = r5.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("PlaybackState {state=");
        r5.append(this.f384a);
        r5.append(", position=");
        r5.append(this.f385b);
        r5.append(", buffered position=");
        r5.append(this.f386c);
        r5.append(", speed=");
        r5.append(this.d);
        r5.append(", updated=");
        r5.append(this.f387h);
        r5.append(", actions=");
        r5.append(this.e);
        r5.append(", error code=");
        r5.append(this.f);
        r5.append(", error message=");
        r5.append(this.g);
        r5.append(", custom actions=");
        r5.append(this.f388i);
        r5.append(", active item id=");
        return j0.o(r5, this.f389j, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f384a);
        r5.writeLong(this.f385b);
        r5.writeFloat(this.d);
        r5.writeLong(this.f387h);
        r5.writeLong(this.f386c);
        r5.writeLong(this.e);
        TextUtils.writeToParcel(this.g, r5, r10);
        r5.writeTypedList(this.f388i);
        r5.writeLong(this.f389j);
        r5.writeBundle(this.f390k);
        r5.writeInt(this.f);
    }
}
