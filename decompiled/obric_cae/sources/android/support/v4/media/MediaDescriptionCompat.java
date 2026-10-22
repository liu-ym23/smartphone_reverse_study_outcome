package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f385b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CharSequence f386m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CharSequence f387n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Bitmap f388o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Uri f389p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Bundle f390q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Uri f391r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Object f392s;

    public static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        public final MediaDescriptionCompat createFromParcel(Parcel r8) {
            return MediaDescriptionCompat.t(MediaDescription.CREATOR.createFromParcel(r8));
        }

        @Override // android.os.Parcelable.Creator
        public final MediaDescriptionCompat[] newArray(int r8) {
            return new MediaDescriptionCompat[r8];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bitmap f397e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Uri f398f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bundle f399g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Uri f400h;
    }

    static {
        CREATOR = new a();
    }

    public MediaDescriptionCompat() {
        throw null;
    }

    public MediaDescriptionCompat(String r8, CharSequence r10, CharSequence r11, CharSequence r12, Bitmap r13, Uri r14, Bundle r15, Uri r16) {
        this.f384a = r8;
        this.f385b = r10;
        this.f386m = r11;
        this.f387n = r12;
        this.f388o = r13;
        this.f389p = r14;
        this.f390q = r15;
        this.f391r = r16;
    }

    public static MediaDescriptionCompat t(Object r11) {
        Bundle r8 = null;
        if (r11 == null) goto L22;
        b r10 = new b();
        MediaDescription r12 = (MediaDescription) r11;
        r10.f393a = r12.getMediaId();
        r10.f394b = r12.getTitle();
        r10.f395c = r12.getSubtitle();
        r10.f396d = r12.getDescription();
        r10.f397e = r12.getIconBitmap();
        r10.f398f = r12.getIconUri();
        Bundle r13 = r12.getExtras();
        if (r13 == null) goto L7;
        MediaSessionCompat.a(r13);
        Uri r14 = (Uri) r13.getParcelable("android.support.v4.media.description.MEDIA_URI");
    L8:
        if (r14 != null) goto L10;
    L15:
        r8 = r13;
    L16:
        r10.f399g = r8;
        if (r14 == null) goto L19;
        r10.f400h = r14;
    L20:
        MediaDescriptionCompat r15 = new MediaDescriptionCompat(r10.f393a, r10.f394b, r10.f395c, r10.f396d, r10.f397e, r10.f398f, r10.f399g, r10.f400h);
        r15.f392s = r11;
        return r15;
    L19:
        r10.f400h = r12.getMediaUri();
        goto L20
    L10:
        if (r13.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") == true) goto L12;
    L14:
        r13.remove("android.support.v4.media.description.MEDIA_URI");
        r13.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        goto L15
    L12:
        if (r13.size() != 2) goto L14;
    L7:
        r14 = null;
        goto L8
    L22:
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.f385b + ", " + this.f386m + ", " + this.f387n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        Object r11 = this.f392s;
        if (r11 != null) goto L5;
        MediaDescription.Builder r12 = new MediaDescription.Builder();
        r12.setMediaId(this.f384a);
        r12.setTitle(this.f385b);
        r12.setSubtitle(this.f386m);
        r12.setDescription(this.f387n);
        r12.setIconBitmap(this.f388o);
        r12.setIconUri(this.f389p);
        r12.setExtras(this.f390q);
        r12.setMediaUri(this.f391r);
        r11 = r12.build();
        this.f392s = r11;
    L5:
        ((MediaDescription) r11).writeToParcel(r8, r10);
    }
}
