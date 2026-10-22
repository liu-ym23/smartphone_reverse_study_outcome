package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = null;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        public MediaDescriptionCompat a(Parcel r10) {
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return new MediaDescriptionCompat(r10);
        L7:
            return MediaDescriptionCompat.fromMediaDescription(c.a(r10));
        }

        public MediaDescriptionCompat[] b(int r10) {
            return new MediaDescriptionCompat[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MediaDescriptionCompat createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MediaDescriptionCompat[] newArray(int r10) {
            return b(r10);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f187e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Uri f188f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bundle f189g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Uri f190h;

        public b() {
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f183a, this.f184b, this.f185c, this.f186d, this.f187e, this.f188f, this.f189g, this.f190h);
        }

        public b b(@Nullable CharSequence r10) {
            this.f186d = r10;
            return this;
        }

        public b c(@Nullable Bundle r10) {
            this.f189g = r10;
            return this;
        }

        public b d(@Nullable Bitmap r10) {
            this.f187e = r10;
            return this;
        }

        public b e(@Nullable Uri r10) {
            this.f188f = r10;
            return this;
        }

        public b f(@Nullable String r10) {
            this.f183a = r10;
            return this;
        }

        public b g(@Nullable Uri r10) {
            this.f190h = r10;
            return this;
        }

        public b h(@Nullable CharSequence r10) {
            this.f185c = r10;
            return this;
        }

        public b i(@Nullable CharSequence r10) {
            this.f184b = r10;
            return this;
        }
    }

    static {
        CREATOR = new a();
    }

    MediaDescriptionCompat(Parcel r10) {
        this.mMediaId = r10.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r10);
        ClassLoader r11 = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = (Bitmap) r10.readParcelable(r11);
        this.mIconUri = (Uri) r10.readParcelable(r11);
        this.mExtras = r10.readBundle(r11);
        this.mMediaUri = (Uri) r10.readParcelable(r11);
    }

    MediaDescriptionCompat(String r10, CharSequence r11, CharSequence r12, CharSequence r13, Bitmap r14, Uri r15, Bundle r16, Uri r17) {
        this.mMediaId = r10;
        this.mTitle = r11;
        this.mSubtitle = r12;
        this.mDescription = r13;
        this.mIcon = r14;
        this.mIconUri = r15;
        this.mExtras = r16;
        this.mMediaUri = r17;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object r10) {
        Bundle r11 = null;
        if (r10 == null) goto L26;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L27;
        b r13 = new b();
        r13.f(c.f(r10));
        r13.i(c.h(r10));
        r13.h(c.g(r10));
        r13.b(c.b(r10));
        r13.d(c.d(r10));
        r13.e(c.e(r10));
        Bundle r14 = c.c(r10);
        if (r14 == null) goto L9;
        MediaSessionCompat.a(r14);
        Uri r15 = (Uri) r14.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
    L10:
        if (r15 != null) goto L12;
    L17:
        r11 = r14;
    L18:
        r13.c(r11);
        if (r15 == null) goto L22;
        r13.g(r15);
    L24:
        MediaDescriptionCompat r16 = r13.a();
        r16.mDescriptionObj = r10;
        return r16;
    L22:
        if (r12 < 23) goto L24;
        r13.g(d.a(r10));
        goto L24
    L12:
        if (r14.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) == true) goto L14;
    L16:
        r14.remove(DESCRIPTION_KEY_MEDIA_URI);
        r14.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
        goto L17
    L14:
        if (r14.size() != 2) goto L16;
    L9:
        r15 = null;
        goto L10
    L27:
        return null;
    L26:
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public CharSequence getDescription() {
        return this.mDescription;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    @Nullable
    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        Object r10 = this.mDescriptionObj;
        if (r10 != null) goto L19;
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 21) goto L20;
        Object r12 = c.a.b();
        c.a.g(r12, this.mMediaId);
        c.a.i(r12, this.mTitle);
        c.a.h(r12, this.mSubtitle);
        c.a.c(r12, this.mDescription);
        c.a.e(r12, this.mIcon);
        c.a.f(r12, this.mIconUri);
        Bundle r13 = this.mExtras;
        if (r11 < 23) goto L10;
    L14:
        c.a.d(r12, r13);
        if (r11 < 23) goto L17;
        d.a.a(r12, this.mMediaUri);
    L17:
        Object r14 = c.a.a(r12);
        this.mDescriptionObj = r14;
        return r14;
    L10:
        if (this.mMediaUri == null) goto L14;
        if (r13 != null) goto L13;
        r13 = new Bundle();
        r13.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
    L13:
        r13.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
        goto L14
    L20:
        return r10;
    L19:
        return r10;
    }

    @Nullable
    public String getMediaId() {
        return this.mMediaId;
    }

    @Nullable
    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Nullable
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        r10.writeString(this.mMediaId);
        TextUtils.writeToParcel(this.mTitle, r10, r11);
        TextUtils.writeToParcel(this.mSubtitle, r10, r11);
        TextUtils.writeToParcel(this.mDescription, r10, r11);
        r10.writeParcelable(this.mIcon, r11);
        r10.writeParcelable(this.mIconUri, r11);
        r10.writeBundle(this.mExtras);
        r10.writeParcelable(this.mMediaUri, r11);
        return;
    L5:
        c.i(getMediaDescription(), r10, r11);
    }
}
