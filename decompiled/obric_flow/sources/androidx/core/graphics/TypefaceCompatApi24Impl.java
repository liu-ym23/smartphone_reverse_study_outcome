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
        Constructor<?> r5 = null;
        Class<?> r10 = Class.forName(FONT_FAMILY_CLASS);     // Catch: Throwable -> L5
        Constructor<?> r11 = r10.getConstructor(null);     // Catch: Throwable -> L5
        Class r12 = Integer.TYPE;     // Catch: Throwable -> L5
        Method r13 = r10.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{ByteBuffer.class, r12, List.class, r12, Boolean.TYPE});     // Catch: Throwable -> L5
        Method r14 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r10, 1).getClass()});     // Catch: Throwable -> L5
        r5 = r11;
    L7:
        sFontFamilyCtor = r5;
        sFontFamily = r10;
        sAddFontWeightStyle = r13;
        sCreateFromFamiliesWithDefault = r14;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r10 = null;
        r14 = null;
        r13 = null;
        goto L7
    }

    public TypefaceCompatApi24Impl() {
    }

    private static boolean addFontWeightStyle(Object r5, ByteBuffer r10, int r11, int r12, boolean r13) {
        return ((Boolean) sAddFontWeightStyle.invoke(r5, new Object[]{r10, Integer.valueOf(r11), null, Integer.valueOf(r12), Boolean.valueOf(r13)})).booleanValue();
    L4:
        return false;
    }

    private static Typeface createFromFamiliesWithDefault(Object r5) {
        Object r10 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r10, 0, r5);     // Catch: Throwable -> L5
        return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r10});
    L5:
        return null;
    }

    public static boolean isUsable() {
        Method r5 = sAddFontWeightStyle;
        if (r5 != null) goto L5;
        Log.w(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
    L5:
        if (r5 == null) goto L7;
        return true;
    L7:
        return false;
    }

    private static Object newFamily() {
        return sFontFamilyCtor.newInstance(null);
    L8:
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
        int r5 = r15.length;
        int r16 = 0;
    L6:
        if (r16 >= r5) goto L15;
        FontResourcesParserCompat.FontFileResourceEntry r17 = r15[r16];
        ByteBuffer r18 = TypefaceCompatUtil.copyToDirectBuffer(r10, r12, r17.getResourceId());
        if (r18 == null) goto L9;
        if (addFontWeightStyle(r14, r18, r17.getTtcIndex(), r17.getWeight(), r17.isItalic()) == false) goto L12;
        r16 = r16 + 1;
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
        SimpleArrayMap r5 = new SimpleArrayMap();
        int r15 = r12.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L16;
        FontsContractCompat.FontInfo r17 = r12[r16];
        Uri r18 = r17.getUri();
        ByteBuffer r19 = (ByteBuffer) r5.get(r18);
        if (r19 != null) goto L10;
        r19 = TypefaceCompatUtil.mmap(r10, r11, r18);
        r5.put(r18, r19);
    L10:
        if (r19 == null) goto L11;
        if (addFontWeightStyle(r14, r19, r17.getTtcIndex(), r17.getWeight(), r17.isItalic()) == false) goto L14;
        r16 = r16 + 1;
        goto L6
    L14:
        return null;
    L11:
        return null;
    L16:
        Typeface r20 = createFromFamiliesWithDefault(r14);
        if (r20 != null) goto L20;
        return null;
    L20:
        return Typeface.create(r20, r13);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @NonNull
    public Typeface createWeightStyle(@NonNull Context r5, @NonNull Typeface r10, int r11, boolean r12) {
        Typeface r13 = WeightTypefaceApi21.createWeightStyle(r10, r11, r12);     // Catch: RuntimeException -> L4
    L5:
        if (r13 == null) goto L7;
        return r13;
    L7:
        return super.createWeightStyle(r5, r10, r11, r12);
    L4:
        r13 = null;
        goto L5
    }
}
