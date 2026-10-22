package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = null;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    static class a implements Parcelable.Creator<RatingCompat> {
        a() {
        }

        public RatingCompat a(Parcel r10) {
            return new RatingCompat(r10.readInt(), r10.readFloat());
        }

        public RatingCompat[] b(int r10) {
            return new RatingCompat[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RatingCompat createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RatingCompat[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    RatingCompat(int r10, float r11) {
        this.mRatingStyle = r10;
        this.mRatingValue = r11;
    }

    public static RatingCompat fromRating(Object r10) {
        RatingCompat r11 = null;
        if (r10 != null) goto L5;
    L16:
        return r11;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L16;
        Rating r12 = (Rating) r10;
        int r13 = r12.getRatingStyle();
        if (r12.isRated() == false) goto L14;
        switch(r13) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L9;
        };
    L9:
        return null;
    L10:
        r11 = newPercentageRating(r12.getPercentRating());
    L15:
        r11.mRatingObj = r10;
        goto L16
    L11:
        r11 = newStarRating(r13, r12.getStarRating());
        goto L15
    L12:
        r11 = newThumbRating(r12.isThumbUp());
        goto L15
    L13:
        r11 = newHeartRating(r12.hasHeart());
        goto L15
    L14:
        r11 = newUnratedRating(r13);
        goto L15
    }

    public static RatingCompat newHeartRating(boolean r10) {
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L7:
        return new RatingCompat(1, r11);
    L5:
        r11 = 0.0f;
        goto L7
    }

    public static RatingCompat newPercentageRating(float r10) {
        if (r10 >= 0.0f) goto L5;
    L9:
        Log.e(TAG, "Invalid percentage-based rating value");
        return null;
    L5:
        if (r10 > 100.0f) goto L9;
        return new RatingCompat(6, r10);
    }

    public static RatingCompat newStarRating(int r10, float r11) {
        if (r10 != 3) goto L5;
        float r12 = 3.0f;
    L15:
        if (r11 >= 0.0f) goto L17;
    L21:
        String r13 = "Trying to set out of range star-based rating";
    L9:
        Log.e(TAG, r13);
        return null;
    L17:
        if (r11 > r12) goto L21;
        return new RatingCompat(r10, r11);
    L5:
        if (r10 != 4) goto L7;
        r12 = 4.0f;
        goto L15
    L7:
        if (r10 == 5) goto L11;
        r13 = "Invalid rating style (" + r10 + ") for a star rating";
        goto L9
    L11:
        r12 = 5.0f;
        goto L15
    }

    public static RatingCompat newThumbRating(boolean r10) {
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L7:
        return new RatingCompat(2, r11);
    L5:
        r11 = 0.0f;
        goto L7
    }

    public static RatingCompat newUnratedRating(int r10) {
        switch(r10) {
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return new RatingCompat(r10, RATING_NOT_RATED);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        if (this.mRatingStyle == 6) goto L5;
        return RATING_NOT_RATED;
    L5:
        if (isRated() == true) goto L8;
        return RATING_NOT_RATED;
    L8:
        return this.mRatingValue;
    }

    public Object getRating() {
        if (this.mRatingObj != null) goto L19;
        if (Build.VERSION.SDK_INT < 19) goto L19;
        if (isRated() == false) goto L16;
        int r10 = this.mRatingStyle;
        switch(r10) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L10;
        };
    L10:
        return null;
    L12:
        Rating r11 = Rating.newPercentageRating(getPercentRating());
    L17:
        this.mRatingObj = r11;
        goto L19
    L13:
        r11 = Rating.newStarRating(r10, getStarRating());
        goto L17
    L14:
        r11 = Rating.newThumbRating(isThumbUp());
        goto L17
    L15:
        r11 = Rating.newHeartRating(hasHeart());
        goto L17
    L16:
        r11 = Rating.newUnratedRating(this.mRatingStyle);
    L19:
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        int r10 = this.mRatingStyle;
        if (r10 == 3) goto L10;
        if (r10 == 4) goto L10;
        if (r10 == 5) goto L10;
        return RATING_NOT_RATED;
    L10:
        if (isRated() == true) goto L12;
        return RATING_NOT_RATED;
    L12:
        return this.mRatingValue;
    }

    public boolean hasHeart() {
        if (this.mRatingStyle == 1) goto L6;
        return false;
    L6:
        if (this.mRatingValue == 1.0f) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean isRated() {
        if (this.mRatingValue < 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isThumbUp() {
        if (this.mRatingStyle == 2) goto L6;
        return false;
    L6:
        if (this.mRatingValue != 1.0f) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Rating:style=");
        r10.append(this.mRatingStyle);
        r10.append(" rating=");
        float r11 = this.mRatingValue;
        if (r11 >= 0.0f) goto L5;
        String r12 = "unrated";
    L6:
        r10.append(r12);
        return r10.toString();
    L5:
        r12 = String.valueOf(r11);
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mRatingStyle);
        r10.writeFloat(this.mRatingValue);
    }
}
