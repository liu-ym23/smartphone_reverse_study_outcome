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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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
        Class<?> r10 = null;
        Class<?> r11 = obtainFontFamily();     // Catch: Throwable -> L5
        Constructor<?> r12 = obtainFontFamilyCtor(r11);     // Catch: Throwable -> L5
        Method r13 = obtainAddFontFromAssetManagerMethod(r11);     // Catch: Throwable -> L5
        Method r14 = obtainAddFontFromBufferMethod(r11);     // Catch: Throwable -> L5
        Method r15 = obtainFreezeMethod(r11);     // Catch: Throwable -> L5
        Method r16 = obtainAbortCreationMethod(r11);     // Catch: Throwable -> L5
        Method r17 = obtainCreateFromFamiliesWithDefaultMethod(r11);     // Catch: Throwable -> L5
        r10 = r11;
    L7:
        this.mFontFamily = r10;
        this.mFontFamilyCtor = r12;
        this.mAddFontFromAssetManager = r13;
        this.mAddFontFromBuffer = r14;
        this.mFreeze = r15;
        this.mAbortCreation = r16;
        this.mCreateFromFamiliesWithDefault = r17;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
        r17 = null;
        r12 = null;
        r13 = null;
        r14 = null;
        r15 = null;
        r16 = null;
        goto L7
    }

    private void abortCreation(Object r10) {
        this.mAbortCreation.invoke(r10, new Object[0]);     // Catch: Throwable -> L4
        return;
    }

    private boolean addFontFromAssetManager(Context r10, Object r11, String r12, int r13, int r14, int r15, @Nullable FontVariationAxis[] r16) {
        return ((Boolean) this.mAddFontFromAssetManager.invoke(r11, new Object[]{r10.getAssets(), r12, 0, Boolean.FALSE, Integer.valueOf(r13), Integer.valueOf(r14), Integer.valueOf(r15), r16})).booleanValue();
    L5:
        return false;
    }

    private boolean addFontFromBuffer(Object r10, ByteBuffer r11, int r12, int r13, int r14) {
        return ((Boolean) this.mAddFontFromBuffer.invoke(r10, new Object[]{r11, Integer.valueOf(r12), null, Integer.valueOf(r13), Integer.valueOf(r14)})).booleanValue();
    L5:
        return false;
    }

    private boolean freeze(Object r10) {
        return ((Boolean) this.mFreeze.invoke(r10, new Object[0])).booleanValue();
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

    @Nullable
    private Object newFamily() {
        return this.mFontFamilyCtor.newInstance(new Object[0]);
    L4:
        return null;
    }

    @Nullable
    protected Typeface createFromFamiliesWithDefault(Object r10) {
        Object r11 = Array.newInstance(this.mFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r11, 0, r10);     // Catch: Throwable -> L5
        return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r11, -1, -1});
    L5:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r11, FontResourcesParserCompat.FontFamilyFilesResourceEntry r12, Resources r13, int r14) {
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r15 = newFamily();
        if (r15 != null) goto L9;
        return null;
    L9:
        FontResourcesParserCompat.FontFileResourceEntry[] r16 = r12.getEntries();
        int r10 = r16.length;
        int r17 = 0;
    L10:
        if (r17 >= r10) goto L17;
        FontResourcesParserCompat.FontFileResourceEntry r18 = r16[r17];
        String r19 = r18.getFileName();
        int r20 = r18.getTtcIndex();
        int r21 = r18.getWeight();
        boolean r22 = r18.isItalic();
        if (addFontFromAssetManager(r11, r15, r19, r20, r21, r22 ? 1 : 0, FontVariationAxis.fromFontVariationSettings(r18.getVariationSettings())) == false) goto L13;
        r17 = r17 + 1;
        goto L10
    L13:
        abortCreation(r15);
        return null;
    L17:
        if (freeze(r15) == true) goto L20;
        return null;
    L20:
        return createFromFamiliesWithDefault(r15);
    L5:
        return super.createFromFontFamilyFilesResourceEntry(r11, r12, r13, r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context r11, @Nullable CancellationSignal r12, @NonNull FontsContractCompat.FontInfo[] r13, int r14) {
        if (r13.length >= 1) goto L6;
        return null;
    L6:
        if (isFontFamilyPrivateAPIAvailable() == true) goto L23;
        FontsContractCompat.FontInfo r10 = findBestInfo(r13, r14);
        ParcelFileDescriptor r15 = r11.getContentResolver().openFileDescriptor(r10.getUri(), "r", r12);     // Catch: IOException -> L22
        if (r15 != null) goto L48;
        if (r15 == null) goto L12;
        r15.close();     // Catch: IOException -> L22
    L12:
        return null;
    L48:
        Typeface r16 = new Typeface.Builder(r15.getFileDescriptor()).setWeight(r10.getWeight()).setItalic(r10.isItalic()).build();     // Catch: Throwable -> L16
        r15.close();     // Catch: IOException -> L22
        return r16;
    L16:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        return null;
    L23:
        Map<Uri, ByteBuffer> r17 = TypefaceCompatUtil.readFontInfoIntoByteBuffer(r11, r13, r12);
        Object r18 = newFamily();
        if (r18 != null) goto L26;
        return null;
    L26:
        int r19 = r13.length;
        boolean r20 = false;
        int r21 = 0;
    L27:
        if (r21 >= r19) goto L37;
        FontsContractCompat.FontInfo r22 = r13[r21];
        ByteBuffer r23 = r17.get(r22.getUri());
        if (r23 == null) goto L36;
        if (addFontFromBuffer(r18, r23, r22.getTtcIndex(), r22.getWeight(), r22.isItalic() ? 1 : 0) == false) goto L33;
        r20 = true;
        goto L36
    L33:
        abortCreation(r18);
        return null;
    L36:
        r21 = r21 + 1;
        goto L27
    L37:
        if (r20 == true) goto L41;
        abortCreation(r18);
        return null;
    L41:
        if (freeze(r18) == true) goto L43;
        return null;
    L43:
        Typeface r110 = createFromFamiliesWithDefault(r18);
        if (r110 != null) goto L47;
        return null;
    L47:
        return Typeface.create(r110, r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context r10, Resources r11, int r12, String r13, int r14) {
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r15 = newFamily();
        if (r15 != null) goto L10;
        return null;
    L10:
        if (addFontFromAssetManager(r10, r15, r13, 0, -1, -1, null) == true) goto L14;
        abortCreation(r15);
        return null;
    L14:
        if (freeze(r15) == true) goto L17;
        return null;
    L17:
        return createFromFamiliesWithDefault(r15);
    L5:
        return super.createFromResourcesFontFile(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @NonNull
    Typeface createWeightStyle(@NonNull Context r10, @NonNull Typeface r11, int r12, boolean r13) {
        Typeface r14 = WeightTypefaceApi26.createWeightStyle(r11, r12, r13);     // Catch: RuntimeException -> L4
    L5:
        if (r14 == null) goto L7;
        return r14;
    L7:
        return super.createWeightStyle(r10, r11, r12, r13);
    L4:
        r14 = null;
        goto L5
    }

    protected Method obtainAbortCreationMethod(Class<?> r10) {
        return r10.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class<?> r10) {
        Class<?> r11 = Integer.TYPE;
        return r10.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, r11, Boolean.TYPE, r11, r11, r11, FontVariationAxis[].class});
    }

    protected Method obtainAddFontFromBufferMethod(Class<?> r10) {
        Class<?> r11 = Integer.TYPE;
        return r10.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, r11, FontVariationAxis[].class, r11, r11});
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r10) {
        Class r11 = Integer.TYPE;
        Method r12 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r10, 1).getClass(), r11, r11});
        r12.setAccessible(true);
        return r12;
    }

    protected Class<?> obtainFontFamily() {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    protected Constructor<?> obtainFontFamilyCtor(Class<?> r10) {
        return r10.getConstructor(new Class[0]);
    }

    protected Method obtainFreezeMethod(Class<?> r10) {
        return r10.getMethod(FREEZE_METHOD, new Class[0]);
    }
}
