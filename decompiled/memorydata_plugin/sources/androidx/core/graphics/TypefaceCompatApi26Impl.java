package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class<?> mFontFamily;
    protected final Constructor<?> mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Class<?> r0 = null;
        Class<?> r1 = obtainFontFamily();     // Catch: Throwable -> L5
        Constructor<?> r2 = obtainFontFamilyCtor(r1);     // Catch: Throwable -> L5
        Method r3 = obtainAddFontFromAssetManagerMethod(r1);     // Catch: Throwable -> L5
        Method r4 = obtainAddFontFromBufferMethod(r1);     // Catch: Throwable -> L5
        Method r5 = obtainFreezeMethod(r1);     // Catch: Throwable -> L5
        Method r6 = obtainAbortCreationMethod(r1);     // Catch: Throwable -> L5
        Method r7 = obtainCreateFromFamiliesWithDefaultMethod(r1);     // Catch: Throwable -> L5
        r0 = r1;
    L7:
        this.mFontFamily = r0;
        this.mFontFamilyCtor = r2;
        this.mAddFontFromAssetManager = r3;
        this.mAddFontFromBuffer = r4;
        this.mFreeze = r5;
        this.mAbortCreation = r6;
        this.mCreateFromFamiliesWithDefault = r7;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
        r7 = null;
        r2 = null;
        r3 = null;
        r4 = null;
        r5 = null;
        r6 = null;
        goto L7
    }

    private void abortCreation(Object r2) {
        this.mAbortCreation.invoke(r2, new Object[0]);     // Catch: Throwable -> L4
        return;
    }

    private boolean addFontFromAssetManager(Context r4, Object r5, String r6, int r7, int r8, int r9, FontVariationAxis[] r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.mAddFontFromAssetManager.invoke(r5, new Object[]{r11.getAssets(), r6, 0, false, Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), r10}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        return false;
    }

    private boolean addFontFromBuffer(Object r3, ByteBuffer r4, int r5, int r6, int r7) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.mAddFontFromBuffer.invoke(r3, new Object[]{r4, Integer.valueOf(r5), null, Integer.valueOf(r6), Integer.valueOf(r7)}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        return false;
    }

    private boolean freeze(Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.mFreeze.invoke(r3, new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        return false;
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager != null) goto L6;
        Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
    L6:
        if (this.mAddFontFromAssetManager == null) goto L8;
        return true;
    L8:
        return false;
    }

    private Object newFamily() {
        return this.mFontFamilyCtor.newInstance(new Object[0]);
    L4:
        return null;
    }

    public Typeface createFromFamiliesWithDefault(Object r5) {
        Object r1 = Array.newInstance(this.mFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r1, 0, r5);     // Catch: Throwable -> L5
        return (Typeface) ZeusTransformUtils.preCheckCast(this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r1, -1, -1}), Typeface.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r11, FontResourcesParserCompat.FontFamilyFilesResourceEntry r12, Resources r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r16 = newFamily();
        if (r16 != null) goto L9;
        return null;
    L9:
        FontResourcesParserCompat.FontFileResourceEntry[] r17 = r12.getEntries();
        int r8 = r17.length;
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L17;
        FontResourcesParserCompat.FontFileResourceEntry r0 = r17[r9];
        String r3 = r0.getFileName();
        int r4 = r0.getTtcIndex();
        int r5 = r0.getWeight();
        boolean r6 = r0.isItalic();
        if (addFontFromAssetManager(r15, r16, r3, r4, r5, r6 ? 1 : 0, FontVariationAxis.fromFontVariationSettings(r0.getVariationSettings())) == false) goto L13;
        r9 = r9 + 1;
        goto L10
    L13:
        abortCreation(r16);
        return null;
    L17:
        if (freeze(r16) == true) goto L20;
        return null;
    L20:
        return createFromFamiliesWithDefault(r16);
    L5:
        return super.createFromFontFamilyFilesResourceEntry(r15, r12, r13, r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r12, CancellationSignal r13, FontsContractCompat.FontInfo[] r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        if (r14.length >= 1) goto L6;
        return null;
    L6:
        if (isFontFamilyPrivateAPIAvailable() == true) goto L25;
        FontsContractCompat.FontInfo r11 = findBestInfo(r14, r15);
        ParcelFileDescriptor r17 = r16.getContentResolver().openFileDescriptor(r11.getUri(), "r", r13);     // Catch: IOException -> L24
        if (r17 != null) goto L50;
        if (r17 == null) goto L12;
        r17.close();     // Catch: IOException -> L24
    L12:
        return null;
    L50:
        Typeface r18 = new Typeface.Builder(r17.getFileDescriptor()).setWeight(r11.getWeight()).setItalic(r11.isItalic()).build();     // Catch: Throwable -> L17
        if (r17 == null) goto L16;
        r17.close();     // Catch: IOException -> L24
    L16:
        return r18;
    L17:
        th = move-exception;
        if (r17 != null) goto L52;
    L23:
        throw th;     // Catch: IOException -> L24
    L52:
        r17.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24
    L24:
        return null;
    L25:
        Map<Uri, ByteBuffer> r19 = TypefaceCompatUtil.readFontInfoIntoByteBuffer(r16, r14, r13);
        Object r110 = newFamily();
        if (r110 != null) goto L28;
        return null;
    L28:
        int r0 = r14.length;
        boolean r4 = false;
        int r10 = 0;
    L29:
        if (r10 >= r0) goto L39;
        FontsContractCompat.FontInfo r5 = r14[r10];
        ByteBuffer r6 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r19.get(r5.getUri()), ByteBuffer.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L38;
        if (addFontFromBuffer(r110, r6, r5.getTtcIndex(), r5.getWeight(), r5.isItalic() ? 1 : 0) == false) goto L35;
        r4 = true;
        goto L38
    L35:
        abortCreation(r110);
        return null;
    L38:
        r10 = r10 + 1;
        goto L29
    L39:
        if (r4 == true) goto L43;
        abortCreation(r110);
        return null;
    L43:
        if (freeze(r110) == true) goto L45;
        return null;
    L45:
        Typeface r111 = createFromFamiliesWithDefault(r110);
        if (r111 != null) goto L49;
        return null;
    L49:
        return Typeface.create(r111, r15);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context r9, Resources r10, int r11, String r12, int r13) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r14 = newFamily();
        if (r14 != null) goto L10;
        return null;
    L10:
        if (addFontFromAssetManager(r1, r14, r12, 0, -1, -1, null) == true) goto L14;
        abortCreation(r14);
        return null;
    L14:
        if (freeze(r14) == true) goto L17;
        return null;
    L17:
        return createFromFamiliesWithDefault(r14);
    L5:
        return super.createFromResourcesFontFile(r1, r10, r11, r12, r13);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    Typeface createWeightStyle(Context r3, Typeface r4, int r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Typeface r0 = WeightTypefaceApi26.createWeightStyle(r4, r5, r6);     // Catch: RuntimeException -> L5
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        return super.createWeightStyle(r7, r4, r5, r6);
    L5:
        r0 = null;
        goto L6
    }

    public Method obtainAbortCreationMethod(Class<?> r2) {
        return r2.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    public Method obtainAddFontFromAssetManagerMethod(Class<?> r3) {
        return r3.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    public Method obtainAddFontFromBufferMethod(Class<?> r3) {
        return r3.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r4) {
        Method r5 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r4, 1).getClass(), Integer.TYPE, Integer.TYPE});
        r5.setAccessible(true);
        return r5;
    }

    public Class<?> obtainFontFamily() {
        return ZeusTransformUtils.forName(FONT_FAMILY_CLASS, "com.obric.memorydata.plugin");
    }

    public Constructor<?> obtainFontFamilyCtor(Class<?> r1) {
        return r1.getConstructor(new Class[0]);
    }

    public Method obtainFreezeMethod(Class<?> r2) {
        return r2.getMethod(FREEZE_METHOD, new Class[0]);
    }
}
