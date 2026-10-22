package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    public static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        public DefaultRoundedBitmapDrawable(Resources r5, Bitmap r10) {
            super(r5, r10);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void gravityCompatApply(int r10, int r11, int r12, Rect r13, Rect r14) {
            GravityCompat.apply(r10, r11, r12, r13, r14, 0);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            Bitmap r5 = this.mBitmap;
            if (r5 != null) goto L5;
        L7:
            return false;
        L5:
            if (BitmapCompat.hasMipMap(r5) == false) goto L7;
            return true;
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean r5) {
            Bitmap r10 = this.mBitmap;
            if (r10 == null) goto L6;
            BitmapCompat.setHasMipMap(r10, r5);
            invalidateSelf();
            return;
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r5, @Nullable Bitmap r10) {
        return new RoundedBitmapDrawable21(r5, r10);
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r5, @NonNull String r10) {
        RoundedBitmapDrawable r11 = create(r5, BitmapFactory.decodeFile(r10));
        if (r11.getBitmap() != null) goto L5;
        Log.w(TAG, "RoundedBitmapDrawable cannot decode " + r10);
    L5:
        return r11;
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r5, @NonNull InputStream r10) {
        RoundedBitmapDrawable r11 = create(r5, BitmapFactory.decodeStream(r10));
        if (r11.getBitmap() != null) goto L5;
        Log.w(TAG, "RoundedBitmapDrawable cannot decode " + r10);
    L5:
        return r11;
    }
}
