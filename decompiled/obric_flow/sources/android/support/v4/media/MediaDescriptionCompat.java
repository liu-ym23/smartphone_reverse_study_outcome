package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f358c;
    public final CharSequence d;
    public final Bitmap e;
    public final Uri f;
    public final Bundle g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Uri f359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f360i;

    static {
        CREATOR = new a5.b(2);
    }

    public MediaDescriptionCompat(String r5, CharSequence r10, CharSequence r11, CharSequence r12, Bitmap r13, Uri r14, Bundle r15, Uri r16) {
        this.f356a = r5;
        this.f357b = r10;
        this.f358c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f359h = r16;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.f357b + ", " + this.f358c + ", " + this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        Object r11 = this.f360i;
        if (r11 != null) goto L5;
        MediaDescription.Builder r12 = new MediaDescription.Builder();
        r12.setMediaId(this.f356a);
        r12.setTitle(this.f357b);
        r12.setSubtitle(this.f358c);
        r12.setDescription(this.d);
        r12.setIconBitmap(this.e);
        r12.setIconUri(this.f);
        r12.setExtras(this.g);
        r12.setMediaUri(this.f359h);
        r11 = r12.build();
        this.f360i = r11;
    L5:
        ((MediaDescription) r11).writeToParcel(r5, r10);
    }
}
