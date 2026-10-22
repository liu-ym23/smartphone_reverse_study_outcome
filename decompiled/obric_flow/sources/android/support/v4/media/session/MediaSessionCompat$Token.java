package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Parcelable f379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f380b;

    static {
        CREATOR = new a5.b(7);
    }

    public MediaSessionCompat$Token(Parcelable r5, c r10) {
        this.f379a = r5;
        this.f380b = r10;
    }

    public static MediaSessionCompat$Token c(Parcelable r5, c r10) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if ((r5 instanceof MediaSession.Token) == false) goto L8;
        return new MediaSessionCompat$Token(r5, r10);
    L8:
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MediaSessionCompat$Token) == true) goto L8;
        return false;
    L8:
        MediaSessionCompat$Token r10 = (MediaSessionCompat$Token) r5;
        Parcelable r11 = this.f379a;
        if (r11 == null) goto L11;
        Parcelable r12 = r10.f379a;
        if (r12 != null) goto L19;
        return false;
    L19:
        return r11.equals(r12);
    L11:
        if (r10.f379a != null) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Parcelable r5 = this.f379a;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeParcelable(this.f379a, r10);
    }
}
