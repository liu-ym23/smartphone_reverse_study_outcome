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
        Class<?> r5 = obtainFontFamily();     // Catch: Throwable -> L5
        Constructor<?> r10 = obtainFontFamilyCtor(r5);     // Catch: Throwable -> L5
        Method r11 = obtainAddFontFromAssetManagerMethod(r5);     // Catch: Throwable -> L5
        Method r12 = obtainAddFontFromBufferMethod(r5);     // Catch: Throwable -> L5
        Method r13 = obtainFreezeMethod(r5);     // Catch: Throwable -> L5
        Method r14 = obtainAbortCreationMethod(r5);     // Catch: Throwable -> L5
        Method r15 = obtainCreateFromFamiliesWithDefaultMethod(r5);     // Catch: Throwable -> L5
    L7:
        this.mFontFamily = r5;
        this.mFontFamilyCtor = r10;
        this.mAddFontFromAssetManager = r11;
        this.mAddFontFromBuffer = r12;
        this.mFreeze = r13;
        this.mAbortCreation = r14;
        this.mCreateFromFamiliesWithDefault = r15;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
        r5 = null;
        r10 = null;
        r11 = null;
        r12 = null;
        r13 = null;
        r14 = null;
        r15 = null;
        goto L7
    }

    private void abortCreation(Object r5) {
        this.mAbortCreation.invoke(r5, null);     // Catch: Throwable -> L4
        return;
    }

    private boolean addFontFromAssetManager(Context r11, Object r12, String r13, int r14, int r15, int r16, @Nullable FontVariationAxis[] r17) {
        return ((Boolean) this.mAddFontFromAssetManager.invoke(r12, new Object[]{r11.getAssets(), r13, 0, Boolean.FALSE, Integer.valueOf(r14), Integer.valueOf(r15), Integer.valueOf(r16), r17})).booleanValue();
    L8:
        return false;
    }

    private boolean addFontFromBuffer(Object r5, ByteBuffer r10, int r11, int r12, int r13) {
        return ((Boolean) this.mAddFontFromBuffer.invoke(r5, new Object[]{r10, Integer.valueOf(r11), null, Integer.valueOf(r12), Integer.valueOf(r13)})).booleanValue();
    L4:
        return false;
    }

    private boolean freeze(Object r5) {
        return ((Boolean) this.mFreeze.invoke(r5, null)).booleanValue();
    L4:
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
        return this.mFontFamilyCtor.newInstance(null);
    L5:
        return null;
    }

    @Nullable
    public Typeface createFromFamiliesWithDefault(Object r5) {
        Object r10 = Array.newInstance(this.mFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r10, 0, r5);     // Catch: Throwable -> L5
        return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r10, -1, -1});
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
        FontResourcesParserCompat.FontFileResourceEntry r5 = r16[r17];
        String r18 = r5.getFileName();
        int r19 = r5.getTtcIndex();
        int r20 = r5.getWeight();
        boolean r21 = r5.isItalic();
        if (addFontFromAssetManager(r11, r15, r18, r19, r20, r21 ? 1 : 0, FontVariationAxis.fromFontVariationSettings(r5.getVariationSettings())) == false) goto L13;
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
        int r5 = r13.length;
        boolean r19 = false;
        int r20 = 0;
    L27:
        if (r20 >= r5) goto L37;
        FontsContractCompat.FontInfo r21 = r13[r20];
        ByteBuffer r22 = r17.get(r21.getUri());
        if (r22 == null) goto L36;
        if (addFontFromBuffer(r18, r22, r21.getTtcIndex(), r21.getWeight(), r21.isItalic() ? 1 : 0) == false) goto L33;
        r19 = true;
        goto L36
    L33:
        abortCreation(r18);
        return null;
    L36:
        r20 = r20 + 1;
        goto L27
    L37:
        if (r19 == true) goto L41;
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
    public Typeface createWeightStyle(@NonNull Context r5, @NonNull Typeface r10, int r11, boolean r12) {
        Typeface r13 = WeightTypefaceApi26.createWeightStyle(r10, r11, r12);     // Catch: RuntimeException -> L4
    L5:
        if (r13 == null) goto L7;
        return r13;
    L7:
        return super.createWeightStyle(r5, r10, r11, r12);
    L4:
        r13 = null;
        goto L5
    }

    public Method obtainAbortCreationMethod(Class<?> r5) throws NoSuchMethodException {
        return r5.getMethod(ABORT_CREATION_METHOD, null);
    }

    public Method obtainAddFontFromAssetManagerMethod(Class<?> r10) throws NoSuchMethodException {
        Class r11 = Integer.TYPE;
        return r10.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, r11, Boolean.TYPE, r11, r11, r11, FontVariationAxis[].class});
    }

    public Method obtainAddFontFromBufferMethod(Class<?> r5) throws NoSuchMethodException {
        Class r10 = Integer.TYPE;
        return r5.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, r10, FontVariationAxis[].class, r10, r10});
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r5) throws NoSuchMethodException {
        Class<?> r10 = Array.newInstance(r5, 1).getClass();
        Class r11 = Integer.TYPE;
        Method r12 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{r10, r11, r11});
        r12.setAccessible(true);
        return r12;
    }

    public Class<?> obtainFontFamily() throws ClassNotFoundException {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    public Constructor<?> obtainFontFamilyCtor(Class<?> r5) throws NoSuchMethodException {
        return r5.getConstructor(null);
    }

    public Method obtainFreezeMethod(Class<?> r5) throws NoSuchMethodException {
        return r5.getMethod(FREEZE_METHOD, null);
    }
}
