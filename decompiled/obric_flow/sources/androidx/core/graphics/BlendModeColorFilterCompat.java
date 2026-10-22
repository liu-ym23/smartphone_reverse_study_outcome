package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class BlendModeColorFilterCompat {

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static ColorFilter createBlendModeColorFilter(int r5, Object r10) {
            return new BlendModeColorFilter(r5, (BlendMode) r10);
        }
    }

    private BlendModeColorFilterCompat() {
    }

    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int r5, @NonNull BlendModeCompat r10) {
        Object r11 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return Api29Impl.createBlendModeColorFilter(r5, r11);
    }
}
