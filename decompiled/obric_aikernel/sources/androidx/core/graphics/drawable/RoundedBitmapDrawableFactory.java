package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources r10, Bitmap r11) {
            super(r10, r11);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        void gravityCompatApply(int r10, int r11, int r12, Rect r13, Rect r14) {
            GravityCompat.apply(r10, r11, r12, r13, r14, 0);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            Bitmap r10 = this.mBitmap;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (BitmapCompat.hasMipMap(r10) == false) goto L7;
            return true;
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean r10) {
            Bitmap r11 = this.mBitmap;
            if (r11 == null) goto L6;
            BitmapCompat.setHasMipMap(r11, r10);
            invalidateSelf();
            return;
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r10, @Nullable Bitmap r11) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return new RoundedBitmapDrawable21(r10, r11);
    L7:
        return new DefaultRoundedBitmapDrawable(r10, r11);
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r10, @NonNull InputStream r11) {
        RoundedBitmapDrawable r12 = create(r10, BitmapFactory.decodeStream(r11));
        if (r12.getBitmap() != null) goto L5;
        Log.w(TAG, "RoundedBitmapDrawable cannot decode " + r11);
    L5:
        return r12;
    }

    @NonNull
    public static RoundedBitmapDrawable create(@NonNull Resources r10, @NonNull String r11) {
        RoundedBitmapDrawable r12 = create(r10, BitmapFactory.decodeFile(r11));
        if (r12.getBitmap() != null) goto L5;
        Log.w(TAG, "RoundedBitmapDrawable cannot decode " + r11);
    L5:
        return r12;
    }
}
