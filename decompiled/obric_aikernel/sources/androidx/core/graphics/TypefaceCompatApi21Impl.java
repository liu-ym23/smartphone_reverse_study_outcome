package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle = null;
    private static Method sCreateFromFamiliesWithDefault = null;
    private static Class<?> sFontFamily = null;
    private static Constructor<?> sFontFamilyCtor = null;
    private static boolean sHasInitBeenCalled = false;

    static {
    }

    TypefaceCompatApi21Impl() {
    }

    private static boolean addFontWeightStyle(Object r10, String r11, int r12, boolean r13) {
        init();
        return ((Boolean) sAddFontWeightStyle.invoke(r10, new Object[]{r11, Integer.valueOf(r12), Boolean.valueOf(r13)})).booleanValue();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static Typeface createFromFamiliesWithDefault(Object r10) {
        init();
        Object r11 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r11, 0, r10);     // Catch: Throwable -> L5
        return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r11});
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private File getFile(@NonNull ParcelFileDescriptor r10) {
        String r11 = Os.readlink("/proc/self/fd/" + r10.getFd());     // Catch: ErrnoException -> L8
        if (OsConstants.S_ISREG(Os.stat(r11).st_mode) == false) goto L7;
        return new File(r11);
    L7:
        return null;
    }

    private static void init() {
        if (sHasInitBeenCalled == false) goto L5;
        return;
    L5:
        sHasInitBeenCalled = true;
        Constructor<?> r10 = null;
        Class<?> r11 = Class.forName(FONT_FAMILY_CLASS);     // Catch: Throwable -> L8
        Constructor<?> r12 = r11.getConstructor(new Class[0]);     // Catch: Throwable -> L8
        Method r13 = r11.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L8
        Method r14 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r11, 1).getClass()});     // Catch: Throwable -> L8
        r10 = r12;
    L10:
        sFontFamilyCtor = r10;
        sFontFamily = r11;
        sAddFontWeightStyle = r13;
        sCreateFromFamiliesWithDefault = r14;
        return;
    L8:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r14 = null;
        r11 = null;
        r13 = null;
        goto L10
    }

    private static Object newFamily() {
        init();
        return sFontFamilyCtor.newInstance(new Object[0]);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13) {
        Object r14 = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] r15 = r11.getEntries();
        int r16 = r15.length;
        int r17 = 0;
    L3:
        if (r17 >= r16) goto L22;
        FontResourcesParserCompat.FontFileResourceEntry r18 = r15[r17];
        File r19 = TypefaceCompatUtil.getTempFile(r10);
        if (r19 == null) goto L6;
    L19:
        r19.delete();
        return null;
    L16:
        th = move-exception;
        r19.delete();
        throw th;
    L8:
        if (TypefaceCompatUtil.copyToFile(r19, r12, r18.getResourceId()) == false) goto L9;
        boolean r20 = addFontWeightStyle(r14, r19.getPath(), r18.getWeight(), r18.isItalic());     // Catch: Throwable -> L16 RuntimeException -> L19
        r19.delete();
        if (r20 == false) goto L14;
        r17 = r17 + 1;
        goto L3
    L14:
        return null;
    L9:
        r19.delete();
        return null;
    L6:
        return null;
    L22:
        return createFromFamiliesWithDefault(r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r10, CancellationSignal r11, @NonNull FontsContractCompat.FontInfo[] r12, int r13) {
        if (r12.length >= 1) goto L5;
        return null;
    L5:
        FontsContractCompat.FontInfo r14 = findBestInfo(r12, r13);
        ContentResolver r15 = r10.getContentResolver();
        ParcelFileDescriptor r16 = r15.openFileDescriptor(r14.getUri(), "r", r11);     // Catch: IOException -> L36
        if (r16 != null) goto L37;
        if (r16 == null) goto L10;
        r16.close();     // Catch: IOException -> L36
    L10:
        return null;
    L37:
        File r17 = getFile(r16);     // Catch: Throwable -> L30
        if (r17 != null) goto L14;
    L19:
        FileInputStream r18 = new FileInputStream(r16.getFileDescriptor());     // Catch: Throwable -> L30
        Typeface r19 = super.createFromInputStream(r10, r18);     // Catch: Throwable -> L24
        r18.close();     // Catch: Throwable -> L30
        r16.close();     // Catch: IOException -> L36
        return r19;
    L24:
        th = move-exception;
        r18.close();     // Catch: Throwable -> L27
    L29:
        throw th;     // Catch: Throwable -> L30
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L30
        goto L29
    L14:
        if (r17.canRead() == false) goto L19;
        Typeface r20 = Typeface.createFromFile(r17);     // Catch: Throwable -> L30
        r16.close();     // Catch: IOException -> L36
        return r20;
    L30:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: IOException -> L36
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L36
    L36:
        return null;
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
