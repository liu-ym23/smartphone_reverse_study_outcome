package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f418b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f420n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f421o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f422p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CharSequence f423q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f424r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f425s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f426t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Bundle f427u;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f429b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f430m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Bundle f431n;

        public static class a implements Parcelable.Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            public final CustomAction createFromParcel(Parcel r8) {
                return new CustomAction(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final CustomAction[] newArray(int r8) {
                return new CustomAction[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public CustomAction(Parcel r8) {
            this.f428a = r8.readString();
            this.f429b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r8);
            this.f430m = r8.readInt();
            this.f431n = r8.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + this.f429b + ", mIcon=" + this.f430m + ", mExtras=" + this.f431n;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            r8.writeString(this.f428a);
            TextUtils.writeToParcel(this.f429b, r8, r10);
            r8.writeInt(this.f430m);
            r8.writeBundle(this.f431n);
        }
    }

    public static class a implements Parcelable.Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        public final PlaybackStateCompat createFromParcel(Parcel r8) {
            return new PlaybackStateCompat(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final PlaybackStateCompat[] newArray(int r8) {
            return new PlaybackStateCompat[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public PlaybackStateCompat(Parcel r8) {
        this.f417a = r8.readInt();
        this.f418b = r8.readLong();
        this.f420n = r8.readFloat();
        this.f424r = r8.readLong();
        this.f419m = r8.readLong();
        this.f421o = r8.readLong();
        this.f423q = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r8);
        this.f425s = r8.createTypedArrayList(CustomAction.CREATOR);
        this.f426t = r8.readLong();
        this.f427u = r8.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f422p = r8.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f417a + ", position=" + this.f418b + ", buffered position=" + this.f419m + ", speed=" + this.f420n + ", updated=" + this.f424r + ", actions=" + this.f421o + ", error code=" + this.f422p + ", error message=" + this.f423q + ", custom actions=" + this.f425s + ", active item id=" + this.f426t + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.f417a);
        r8.writeLong(this.f418b);
        r8.writeFloat(this.f420n);
        r8.writeLong(this.f424r);
        r8.writeLong(this.f419m);
        r8.writeLong(this.f421o);
        TextUtils.writeToParcel(this.f423q, r8, r10);
        r8.writeTypedList(this.f425s);
        r8.writeLong(this.f426t);
        r8.writeBundle(this.f427u);
        r8.writeInt(this.f422p);
    }
}
