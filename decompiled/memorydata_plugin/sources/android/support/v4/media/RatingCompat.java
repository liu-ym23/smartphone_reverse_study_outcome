package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

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

    static {
        CREATOR = new AnonymousClass1();
    }

    RatingCompat(int r1, float r2) {
        this.mRatingStyle = r1;
        this.mRatingValue = r2;
    }

    public static RatingCompat fromRating(Object r4) {
        RatingCompat r0 = null;
        if (r4 != null) goto L5;
    L16:
        return r0;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L16;
        int r1 = ((Rating) ZeusTransformUtils.preCheckCast(r4, Rating.class, "com.obric.memorydata.plugin")).getRatingStyle();
        if (((Rating) ZeusTransformUtils.preCheckCast(r4, Rating.class, "com.obric.memorydata.plugin")).isRated() == false) goto L14;
        switch(r1) {
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
        r0 = newPercentageRating(((Rating) ZeusTransformUtils.preCheckCast(r4, Rating.class, "com.obric.memorydata.plugin")).getPercentRating());
    L15:
        r0.mRatingObj = r4;
        goto L16
    L11:
        r0 = newStarRating(r1, ((Rating) ZeusTransformUtils.preCheckCast(r4, Rating.class, "com.obric.memorydata.plugin")).getStarRating());
        goto L15
    L12:
        r0 = newThumbRating(((Rating) ZeusTransformUtils.preCheckCast(r4, Rating.class, "com.obric.memorydata.plugin")).isThumbUp());
        goto L15
    L13:
        r0 = newHeartRating(((Rating) ZeusTransformUtils.preCheckCast(r4, Rating.class, "com.obric.memorydata.plugin")).hasHeart());
        goto L15
    L14:
        r0 = newUnratedRating(r1);
        goto L15
    }

    public static RatingCompat newHeartRating(boolean r2) {
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L7:
        return new RatingCompat(1, r3);
    L5:
        r3 = 0.0f;
        goto L7
    }

    public static RatingCompat newPercentageRating(float r2) {
        if (r2 >= 0.0f) goto L5;
    L9:
        Log.e(TAG, "Invalid percentage-based rating value");
        return null;
    L5:
        if (r2 > 100.0f) goto L9;
        return new RatingCompat(6, r2);
    }

    public static RatingCompat newStarRating(int r4, float r5) {
        if (r4 != 3) goto L5;
        float r0 = 3.0f;
    L15:
        if (r5 >= 0.0f) goto L17;
    L21:
        String r6 = "Trying to set out of range star-based rating";
    L9:
        Log.e(TAG, r6);
        return null;
    L17:
        if (r5 > r0) goto L21;
        return new RatingCompat(r4, r5);
    L5:
        if (r4 != 4) goto L7;
        r0 = 4.0f;
        goto L15
    L7:
        if (r4 == 5) goto L11;
        r6 = "Invalid rating style (" + r4 + ") for a star rating";
        goto L9
    L11:
        r0 = 5.0f;
        goto L15
    }

    public static RatingCompat newThumbRating(boolean r2) {
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L7:
        return new RatingCompat(2, r3);
    L5:
        r3 = 0.0f;
        goto L7
    }

    public static RatingCompat newUnratedRating(int r2) {
        switch(r2) {
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
        return new RatingCompat(r2, -1.0f);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        if (this.mRatingStyle == 6) goto L5;
        return -1.0f;
    L5:
        if (isRated() == true) goto L8;
        return -1.0f;
    L8:
        return this.mRatingValue;
    }

    public Object getRating() {
        if (this.mRatingObj != null) goto L19;
        if (Build.VERSION.SDK_INT < 19) goto L19;
        if (isRated() == false) goto L16;
        int r0 = this.mRatingStyle;
        switch(r0) {
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
        Rating r1 = Rating.newPercentageRating(getPercentRating());
    L17:
        this.mRatingObj = r1;
        goto L19
    L13:
        r1 = Rating.newStarRating(r0, getStarRating());
        goto L17
    L14:
        r1 = Rating.newThumbRating(isThumbUp());
        goto L17
    L15:
        r1 = Rating.newHeartRating(hasHeart());
        goto L17
    L16:
        r1 = Rating.newUnratedRating(this.mRatingStyle);
    L19:
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        int r0 = this.mRatingStyle;
        if (r0 == 3) goto L10;
        if (r0 == 4) goto L10;
        if (r0 == 5) goto L10;
        return -1.0f;
    L10:
        if (isRated() == true) goto L12;
        return -1.0f;
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
        StringBuilder r0 = new StringBuilder().append("Rating:style=").append(this.mRatingStyle).append(" rating=");
        float r2 = this.mRatingValue;
        if (r2 >= 0.0f) goto L5;
        String r3 = "unrated";
    L7:
        return r0.append(r3).toString();
    L5:
        r3 = String.valueOf(r2);
        goto L7
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mRatingStyle);
        r1.writeFloat(this.mRatingValue);
    }
}
