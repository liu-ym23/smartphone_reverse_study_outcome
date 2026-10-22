package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
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
        Constructor<?> r0 = null;
        Class<?> r1 = ZeusTransformUtils.forName(FONT_FAMILY_CLASS, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Constructor<?> r3 = r1.getConstructor(new Class[0]);     // Catch: Throwable -> L5
        Method r4 = r1.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L5
        Method r2 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r1, 1).getClass()});     // Catch: Throwable -> L5
        r0 = r3;
    L7:
        sFontFamilyCtor = r0;
        sFontFamily = r1;
        sAddFontWeightStyle = r4;
        sCreateFromFamiliesWithDefault = r2;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r1 = null;
        r2 = null;
        r4 = null;
        goto L7
    }

    TypefaceCompatApi24Impl() {
    }

    private static boolean addFontWeightStyle(Object r3, ByteBuffer r4, int r5, int r6, boolean r7) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(sAddFontWeightStyle.invoke(r3, new Object[]{r4, Integer.valueOf(r5), null, Integer.valueOf(r6), Boolean.valueOf(r7)}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        return false;
    }

    private static Typeface createFromFamiliesWithDefault(Object r4) {
        Object r1 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r1, 0, r4);     // Catch: Throwable -> L5
        return (Typeface) ZeusTransformUtils.preCheckCast(sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r1}), Typeface.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    public static boolean isUsable() {
        Method r0 = sAddFontWeightStyle;
        if (r0 != null) goto L5;
        Log.w(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
    L5:
        if (r0 == null) goto L7;
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
    public Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Object r11 = newFamily();
        if (r11 != null) goto L5;
        return null;
    L5:
        FontResourcesParserCompat.FontFileResourceEntry[] r12 = r8.getEntries();
        int r0 = r12.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L15;
        FontResourcesParserCompat.FontFileResourceEntry r2 = r12[r1];
        ByteBuffer r3 = TypefaceCompatUtil.copyToDirectBuffer(r6, r9, r2.getResourceId());
        if (r3 == null) goto L9;
        if (addFontWeightStyle(r11, r3, r2.getTtcIndex(), r2.getWeight(), r2.isItalic()) == false) goto L12;
        r1 = r1 + 1;
        goto L6
    L12:
        return null;
    L9:
        return null;
    L15:
        return createFromFamiliesWithDefault(r11);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r10, CancellationSignal r11, FontsContractCompat.FontInfo[] r12, int r13) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Object r14 = newFamily();
        if (r14 != null) goto L5;
        return null;
    L5:
        SimpleArrayMap r2 = new SimpleArrayMap();
        int r3 = r12.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L16;
        FontsContractCompat.FontInfo r5 = r12[r4];
        Uri r6 = r5.getUri();
        ByteBuffer r7 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r2.get(r6), ByteBuffer.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        r7 = TypefaceCompatUtil.mmap(r9, r11, r6);
        r2.put(r6, r7);
    L10:
        if (r7 == null) goto L11;
        if (addFontWeightStyle(r14, r7, r5.getTtcIndex(), r5.getWeight(), r5.isItalic()) == false) goto L14;
        r4 = r4 + 1;
        goto L6
    L14:
        return null;
    L11:
        return null;
    L16:
        Typeface r15 = createFromFamiliesWithDefault(r14);
        if (r15 != null) goto L20;
        return null;
    L20:
        return Typeface.create(r15, r13);
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
