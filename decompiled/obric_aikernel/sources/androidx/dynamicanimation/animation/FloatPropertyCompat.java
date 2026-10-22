package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String r10) {
        this.mPropertyName = r10;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> r10) {
        final String r11 = r10.getName();
        return new AnonymousClass1(r11, r10);
    }

    public abstract float getValue(T r10);

    public abstract void setValue(T r10, float r11);
}
