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
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
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

    private static boolean addFontWeightStyle(Object r3, String r4, int r5, boolean r6) {
        init();
        return ((Boolean) ZeusTransformUtils.preCheckCast(sAddFontWeightStyle.invoke(r3, new Object[]{r4, Integer.valueOf(r5), Boolean.valueOf(r6)}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static Typeface createFromFamiliesWithDefault(Object r4) {
        init();
        Object r0 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r0, 0, r4);     // Catch: Throwable -> L5
        return (Typeface) ZeusTransformUtils.preCheckCast(sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r0}), Typeface.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private File getFile(ParcelFileDescriptor r3) {
        String r4 = Os.readlink("/proc/self/fd/" + r3.getFd());     // Catch: ErrnoException -> L8
        if (OsConstants.S_ISREG(Os.stat(r4).st_mode) == false) goto L7;
        return new File(r4);
    L7:
        return null;
    }

    private static void init() {
        if (sHasInitBeenCalled == false) goto L5;
        return;
    L5:
        sHasInitBeenCalled = true;
        Constructor<?> r1 = null;
        Class<?> r2 = ZeusTransformUtils.forName(FONT_FAMILY_CLASS, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Constructor<?> r4 = r2.getConstructor(new Class[0]);     // Catch: Throwable -> L8
        Method r5 = r2.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L8
        Method r0 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r2, 1).getClass()});     // Catch: Throwable -> L8
        r1 = r4;
    L10:
        sFontFamilyCtor = r1;
        sFontFamily = r2;
        sAddFontWeightStyle = r5;
        sCreateFromFamiliesWithDefault = r0;
        return;
    L8:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r0 = null;
        r2 = null;
        r5 = null;
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
    public Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Object r11 = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] r12 = r8.getEntries();
        int r13 = r12.length;
        int r0 = 0;
    L3:
        if (r0 >= r13) goto L22;
        FontResourcesParserCompat.FontFileResourceEntry r1 = r12[r0];
        File r2 = TypefaceCompatUtil.getTempFile(r6);
        if (r2 == null) goto L6;
    L19:
        r2.delete();
        return null;
    L16:
        th = move-exception;
        r2.delete();
        throw th;
    L8:
        if (TypefaceCompatUtil.copyToFile(r2, r9, r1.getResourceId()) == false) goto L9;
        boolean r3 = addFontWeightStyle(r11, r2.getPath(), r1.getWeight(), r1.isItalic());     // Catch: Throwable -> L16 RuntimeException -> L19
        r2.delete();
        if (r3 == false) goto L14;
        r0 = r0 + 1;
        goto L3
    L14:
        return null;
    L9:
        r2.delete();
        return null;
    L6:
        return null;
    L22:
        return createFromFamiliesWithDefault(r11);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r4, CancellationSignal r5, FontsContractCompat.FontInfo[] r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r6.length >= 1) goto L5;
        return null;
    L5:
        FontsContractCompat.FontInfo r9 = findBestInfo(r6, r7);
        ContentResolver r10 = r8.getContentResolver();
        ParcelFileDescriptor r11 = r10.openFileDescriptor(r9.getUri(), "r", r5);     // Catch: IOException -> L39
        if (r11 != null) goto L40;
        if (r11 == null) goto L10;
        r11.close();     // Catch: IOException -> L39
    L10:
        return null;
    L40:
        File r12 = getFile(r11);     // Catch: Throwable -> L32
        if (r12 != null) goto L14;
    L20:
        FileInputStream r13 = new FileInputStream(r11.getFileDescriptor());     // Catch: Throwable -> L32
        Typeface r3 = super.createFromInputStream(r8, r13);     // Catch: Throwable -> L26
        r13.close();     // Catch: Throwable -> L32
        if (r11 == null) goto L25;
        r11.close();     // Catch: IOException -> L39
    L25:
        return r3;
    L26:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Throwable -> L32
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
        goto L31
    L14:
        if (r12.canRead() == false) goto L20;
        Typeface r14 = Typeface.createFromFile(r12);     // Catch: Throwable -> L32
        if (r11 == null) goto L19;
        r11.close();     // Catch: IOException -> L39
    L19:
        return r14;
    L32:
        th = move-exception;
        if (r11 != null) goto L43;
    L38:
        throw th;     // Catch: IOException -> L39
    L43:
        r11.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L39
    L39:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    Typeface createWeightStyle(Context r3, Typeface r4, int r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Typeface r0 = WeightTypefaceApi21.createWeightStyle(r4, r5, r6);     // Catch: RuntimeException -> L5
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return super.createWeightStyle(r7, r4, r5, r6);
    L5:
        r0 = null;
        goto L6
    }
}
