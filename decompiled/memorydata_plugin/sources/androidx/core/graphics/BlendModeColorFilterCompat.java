package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class BlendModeColorFilterCompat {

    static class Api29Impl {
        private Api29Impl() {
        }

        static ColorFilter createBlendModeColorFilter(int r3, Object r4) {
            return new BlendModeColorFilter(r3, (BlendMode) ZeusTransformUtils.preCheckCast(r4, BlendMode.class, "com.obric.memorydata.plugin"));
        }
    }

    private BlendModeColorFilterCompat() {
    }

    public static ColorFilter createBlendModeColorFilterCompat(int r3, BlendModeCompat r4) {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Object r5 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return Api29Impl.createBlendModeColorFilter(r3, r5);
    L8:
        PorterDuff.Mode r6 = BlendModeUtils.obtainPorterDuffFromCompat(r4);
        if (r6 != null) goto L11;
        return null;
    L11:
        return new PorterDuffColorFilter(r3, r6);
    }
}
