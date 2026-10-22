package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle = null;
    private static final Method sCreateFromFamiliesWithDefault = null;
    private static final Class<?> sFontFamily = null;
    private static final Constructor<?> sFontFamilyCtor = null;

    static {
        Constructor<?> r10 = null;
        Class<?> r11 = Class.forName(FONT_FAMILY_CLASS);     // Catch: Throwable -> L5
        Constructor<?> r12 = r11.getConstructor(new Class[0]);     // Catch: Throwable -> L5
        Class<?> r13 = Integer.TYPE;     // Catch: Throwable -> L5
        Method r14 = r11.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{ByteBuffer.class, r13, List.class, r13, Boolean.TYPE});     // Catch: Throwable -> L5
        Method r15 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r11, 1).getClass()});     // Catch: Throwable -> L5
        r10 = r12;
    L7:
        sFontFamilyCtor = r10;
        sFontFamily = r11;
        sAddFontWeightStyle = r14;
        sCreateFromFamiliesWithDefault = r15;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r11 = null;
        r15 = null;
        r14 = null;
        goto L7
    }

    TypefaceCompatApi24Impl() {
    }

    private static boolean addFontWeightStyle(Object r10, ByteBuffer r11, int r12, int r13, boolean r14) {
        return ((Boolean) sAddFontWeightStyle.invoke(r10, new Object[]{r11, Integer.valueOf(r12), null, Integer.valueOf(r13), Boolean.valueOf(r14)})).booleanValue();
    L5:
        return false;
    }

    private static Typeface createFromFamiliesWithDefault(Object r10) {
        Object r11 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r11, 0, r10);     // Catch: Throwable -> L5
        return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r11});
    L5:
        return null;
    }

    public static boolean isUsable() {
        Method r10 = sAddFontWeightStyle;
        if (r10 != null) goto L5;
        Log.w(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
    L5:
        if (r10 == null) goto L7;
        return true;
    L7:
        return false;
    }

    private static Object newFamily() {
        return sFontFamilyCtor.newInstance(new Object[0]);
    L4:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13) {
        Object r14 = newFamily();
        if (r14 != null) goto L5;
        return null;
    L5:
        FontResourcesParserCompat.FontFileResourceEntry[] r15 = r11.getEntries();
        int r16 = r15.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L15;
        FontResourcesParserCompat.FontFileResourceEntry r18 = r15[r17];
        ByteBuffer r19 = TypefaceCompatUtil.copyToDirectBuffer(r10, r12, r18.getResourceId());
        if (r19 == null) goto L9;
        if (addFontWeightStyle(r14, r19, r18.getTtcIndex(), r18.getWeight(), r18.isItalic()) == false) goto L12;
        r17 = r17 + 1;
        goto L6
    L12:
        return null;
    L9:
        return null;
    L15:
        return createFromFamiliesWithDefault(r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context r10, @Nullable CancellationSignal r11, @NonNull FontsContractCompat.FontInfo[] r12, int r13) {
        Object r14 = newFamily();
        if (r14 != null) goto L5;
        return null;
    L5:
        SimpleArrayMap r15 = new SimpleArrayMap();
        int r16 = r12.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L16;
        FontsContractCompat.FontInfo r18 = r12[r17];
        Uri r19 = r18.getUri();
        ByteBuffer r20 = (ByteBuffer) r15.get(r19);
        if (r20 != null) goto L10;
        r20 = TypefaceCompatUtil.mmap(r10, r11, r19);
        r15.put(r19, r20);
    L10:
        if (r20 == null) goto L11;
        if (addFontWeightStyle(r14, r20, r18.getTtcIndex(), r18.getWeight(), r18.isItalic()) == false) goto L14;
        r17 = r17 + 1;
        goto L6
    L14:
        return null;
    L11:
        return null;
    L16:
        Typeface r21 = createFromFamiliesWithDefault(r14);
        if (r21 != null) goto L20;
        return null;
    L20:
        return Typeface.create(r21, r13);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @NonNull
    Typeface createWeightStyle(@NonNull Context r10, @NonNull Typeface r11, int r12, boolean r13) {
        Typeface r14 = WeightTypefaceApi21.createWeightStyle(r11, r12, r13);     // Catch: RuntimeException -> L4
    L5:
        if (r14 == null) goto L7;
        return r14;
    L7:
        return super.createWeightStyle(r10, r11, r12, r13);
    L4:
        r14 = null;
        goto L5
    }
}
