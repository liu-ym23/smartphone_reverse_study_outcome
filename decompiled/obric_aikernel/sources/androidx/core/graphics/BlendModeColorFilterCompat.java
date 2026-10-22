package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class BlendModeColorFilterCompat {

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static ColorFilter createBlendModeColorFilter(int r10, Object r11) {
            return new BlendModeColorFilter(r10, (BlendMode) r11);
        }
    }

    private BlendModeColorFilterCompat() {
    }

    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int r10, @NonNull BlendModeCompat r11) {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Object r12 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return Api29Impl.createBlendModeColorFilter(r10, r12);
    L8:
        PorterDuff.Mode r13 = BlendModeUtils.obtainPorterDuffFromCompat(r11);
        if (r13 != null) goto L11;
        return null;
    L11:
        return new PorterDuffColorFilter(r10, r13);
    }
}
