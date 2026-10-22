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

    public TypefaceCompatApi21Impl() {
    }

    private static boolean addFontWeightStyle(Object r5, String r10, int r11, boolean r12) {
        init();
        return ((Boolean) sAddFontWeightStyle.invoke(r5, new Object[]{r10, Integer.valueOf(r11), Boolean.valueOf(r12)})).booleanValue();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static Typeface createFromFamiliesWithDefault(Object r5) {
        init();
        Object r10 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r10, 0, r5);     // Catch: Throwable -> L5
        return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r10});
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private File getFile(@NonNull ParcelFileDescriptor r5) {
        String r10 = Os.readlink("/proc/self/fd/" + r5.getFd());     // Catch: ErrnoException -> L8
        if (OsConstants.S_ISREG(Os.stat(r10).st_mode) == false) goto L7;
        return new File(r10);
    L7:
        return null;
    }

    private static void init() {
        if (sHasInitBeenCalled == false) goto L5;
        return;
    L5:
        sHasInitBeenCalled = true;
        Constructor<?> r5 = null;
        Class<?> r10 = Class.forName(FONT_FAMILY_CLASS);     // Catch: Throwable -> L8
        Constructor<?> r11 = r10.getConstructor(null);     // Catch: Throwable -> L8
        Method r12 = r10.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L8
        Method r13 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r10, 1).getClass()});     // Catch: Throwable -> L8
        r5 = r11;
    L10:
        sFontFamilyCtor = r5;
        sFontFamily = r10;
        sAddFontWeightStyle = r12;
        sCreateFromFamiliesWithDefault = r13;
        return;
    L8:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r13 = null;
        r10 = null;
        r12 = null;
        goto L10
    }

    private static Object newFamily() {
        init();
        return sFontFamilyCtor.newInstance(null);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r10, FontResourcesParserCompat.FontFamilyFilesResourceEntry r11, Resources r12, int r13) {
        Object r14 = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] r15 = r11.getEntries();
        int r16 = r15.length;
        int r5 = 0;
    L3:
        if (r5 >= r16) goto L22;
        FontResourcesParserCompat.FontFileResourceEntry r17 = r15[r5];
        File r18 = TypefaceCompatUtil.getTempFile(r10);
        if (r18 == null) goto L6;
    L19:
        r18.delete();
        return null;
    L16:
        th = move-exception;
        r18.delete();
        throw th;
    L8:
        if (TypefaceCompatUtil.copyToFile(r18, r12, r17.getResourceId()) == false) goto L9;
        if (addFontWeightStyle(r14, r18.getPath(), r17.getWeight(), r17.isItalic()) == false) goto L13;
        r18.delete();
        r5 = r5 + 1;
        goto L3
    L13:
        r18.delete();
        return null;
    L9:
        r18.delete();
        return null;
    L6:
        return null;
    L22:
        return createFromFamiliesWithDefault(r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r5, CancellationSignal r10, @NonNull FontsContractCompat.FontInfo[] r11, int r12) {
        if (r11.length >= 1) goto L5;
        return null;
    L5:
        FontsContractCompat.FontInfo r13 = findBestInfo(r11, r12);
        ContentResolver r14 = r5.getContentResolver();
        ParcelFileDescriptor r15 = r14.openFileDescriptor(r13.getUri(), "r", r10);     // Catch: IOException -> L37
        if (r15 != null) goto L40;
        if (r15 == null) goto L10;
        r15.close();     // Catch: IOException -> L37
    L10:
        return null;
    L40:
        File r16 = getFile(r15);     // Catch: Throwable -> L19
        if (r16 != null) goto L14;
    L21:
        FileInputStream r17 = new FileInputStream(r15.getFileDescriptor());     // Catch: Throwable -> L19
        Typeface r18 = super.createFromInputStream(r5, r17);     // Catch: Throwable -> L26
        r17.close();     // Catch: Throwable -> L19
        r15.close();     // Catch: IOException -> L37
        return r18;
    L26:
        th = move-exception;
        r17.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Throwable -> L19
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
        goto L31
    L14:
        if (r16.canRead() == false) goto L21;
        Typeface r19 = Typeface.createFromFile(r16);     // Catch: Throwable -> L19
        r15.close();     // Catch: IOException -> L37
        return r19;
    L19:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: IOException -> L37
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L37
    L37:
        return null;
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
