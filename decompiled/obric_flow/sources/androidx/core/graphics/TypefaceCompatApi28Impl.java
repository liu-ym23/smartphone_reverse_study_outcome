package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int RESOLVE_BY_FONT_TABLE = -1;

    public TypefaceCompatApi28Impl() {
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    public Typeface createFromFamiliesWithDefault(Object r5) {
        Object r10 = Array.newInstance(this.mFontFamily, 1);     // Catch: Throwable -> L4
        Array.set(r10, 0, r5);     // Catch: Throwable -> L4
        return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r10, DEFAULT_FAMILY, -1, -1});
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl, androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @NonNull
    public Typeface createWeightStyle(@NonNull Context r5, @NonNull Typeface r10, int r11, boolean r12) {
        return Typeface.create(r10, r11, r12);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r5) throws NoSuchMethodException {
        Class<?> r10 = Array.newInstance(r5, 1).getClass();
        Class r11 = Integer.TYPE;
        Method r12 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{r10, String.class, r11, r11});
        r12.setAccessible(true);
        return r12;
    }
}
