package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String r5) {
        this.mPropertyName = r5;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(final FloatProperty<T> r5) {
        final String r10 = r5.getName();
        return new AnonymousClass1(r10, r5);
    }

    public abstract float getValue(T r5);

    public abstract void setValue(T r5, float r10);
}
