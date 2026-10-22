package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompat {
    private static final LruCache<String, Typeface> sTypefaceCache = null;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl = null;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        @Nullable
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(@Nullable ResourcesCompat.FontCallback r10) {
            this.mFontCallback = r10;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int r10) {
            ResourcesCompat.FontCallback r11 = this.mFontCallback;
            if (r11 == null) goto L6;
            r11.onFontRetrievalFailed(r10);
            return;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(@NonNull Typeface r10) {
            ResourcesCompat.FontCallback r11 = this.mFontCallback;
            if (r11 == null) goto L6;
            r11.onFontRetrieved(r10);
            return;
        }
    }

    static {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 < 29) goto L7;
        TypefaceCompatBaseImpl r11 = new TypefaceCompatApi29Impl();
    L5:
        sTypefaceCompatImpl = r11;
        sTypefaceCache = new LruCache(16);
        return;
    L7:
        if (r10 < 28) goto L10;
        r11 = new TypefaceCompatApi28Impl();
        goto L5
    L10:
        if (r10 < 26) goto L13;
        r11 = new TypefaceCompatApi26Impl();
        goto L5
    L13:
        if (r10 < 24) goto L18;
        if (TypefaceCompatApi24Impl.isUsable() == false) goto L18;
        r11 = new TypefaceCompatApi24Impl();
    L18:
        if (r10 < 21) goto L20;
        r11 = new TypefaceCompatApi21Impl();
        goto L5
    L20:
        r11 = new TypefaceCompatBaseImpl();
        goto L5
    }

    private TypefaceCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    @NonNull
    public static Typeface create(@NonNull Context r10, @Nullable Typeface r11, int r12) {
        if (r10 == null) goto L11;
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        Typeface r13 = getBestFontFromFamily(r10, r11, r12);
        if (r13 == null) goto L9;
        return r13;
    L9:
        return Typeface.create(r11, r12);
    L11:
        throw new IllegalArgumentException("Context cannot be null");
    }

    @NonNull
    public static Typeface create(@NonNull Context r10, @Nullable Typeface r11, @IntRange(from = 1, to = 1000) int r12, boolean r13) {
        if (r10 == null) goto L9;
        Preconditions.checkArgumentInRange(r12, 1, 1000, "weight");
        if (r11 != null) goto L7;
        r11 = Typeface.DEFAULT;
    L7:
        return sTypefaceCompatImpl.createWeightStyle(r10, r11, r12, r13);
    L9:
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromFontInfo(@NonNull Context r10, @Nullable CancellationSignal r11, @NonNull FontsContractCompat.FontInfo[] r12, int r13) {
        return sTypefaceCompatImpl.createFromFontInfo(r10, r11, r12, r13);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface createFromResourcesFamilyXml(@NonNull Context r10, @NonNull FontResourcesParserCompat.FamilyResourceEntry r11, @NonNull Resources r12, int r13, int r14, @Nullable ResourcesCompat.FontCallback r15, @Nullable Handler r16, boolean r17) {
        return createFromResourcesFamilyXml(r10, r11, r12, r13, null, 0, r14, r15, r16, r17);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFamilyXml(@NonNull Context r13, @NonNull FontResourcesParserCompat.FamilyResourceEntry r14, @NonNull Resources r15, int r16, @Nullable String r17, int r18, int r19, @Nullable ResourcesCompat.FontCallback r20, @Nullable Handler r21, boolean r22) {
        if ((r14 instanceof FontResourcesParserCompat.ProviderResourceEntry) == false) goto L21;
        FontResourcesParserCompat.ProviderResourceEntry r10 = (FontResourcesParserCompat.ProviderResourceEntry) r14;
        Typeface r11 = getSystemFontFamily(r10.getSystemFontFamilyName());
        if (r11 == null) goto L10;
        if (r20 == null) goto L8;
        r20.callbackSuccessAsync(r11, r21);
    L8:
        return r11;
    L10:
        if (r22 == true) goto L12;
        if (r20 != null) goto L16;
    L15:
        boolean r12 = true;
    L17:
        if (r22 == false) goto L19;
        int r23 = r10.getTimeout();
    L20:
        Handler r110 = ResourcesCompat.FontCallback.getHandler(r21);
        ResourcesCallbackAdapter r111 = new ResourcesCallbackAdapter(r20);
        Typeface r24 = FontsContractCompat.requestFont(r13, r10.getRequest(), r19, r12, r23, r110, r111);
    L26:
        if (r24 == null) goto L28;
        sTypefaceCache.put(createResourceUid(r15, r16, r17, r18, r19), r24);
    L28:
        return r24;
    L19:
        r23 = -1;
    L16:
        r12 = false;
        goto L17
    L12:
        if (r10.getFetchStrategy() != 0) goto L16;
    L21:
        r24 = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(r13, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) r14, r15, r19);
        if (r20 == null) goto L26;
        if (r24 == null) goto L25;
        r20.callbackSuccessAsync(r24, r21);
        goto L26
    L25:
        r20.callbackFailAsync(-3, r21);
        goto L26
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface createFromResourcesFontFile(@NonNull Context r10, @NonNull Resources r11, int r12, String r13, int r14) {
        return createFromResourcesFontFile(r10, r11, r12, r13, 0, r14);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFontFile(@NonNull Context r10, @NonNull Resources r11, int r12, String r13, int r14, int r15) {
        Typeface r16 = sTypefaceCompatImpl.createFromResourcesFontFile(r10, r11, r12, r13, r15);
        if (r16 == null) goto L5;
        String r17 = createResourceUid(r11, r12, r13, r14, r15);
        sTypefaceCache.put(r17, r16);
    L5:
        return r16;
    }

    private static String createResourceUid(Resources r10, int r11, String r12, int r13, int r14) {
        return r10.getResourcePackageName(r11) + '-' + r12 + '-' + r13 + '-' + r11 + '-' + r14;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface findFromCache(@NonNull Resources r10, int r11, int r12) {
        return findFromCache(r10, r11, null, 0, r12);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface findFromCache(@NonNull Resources r10, int r11, @Nullable String r12, int r13, int r14) {
        return sTypefaceCache.get(createResourceUid(r10, r11, r12, r13, r14));
    }

    @Nullable
    private static Typeface getBestFontFromFamily(Context r10, Typeface r11, int r12) {
        TypefaceCompatBaseImpl r13 = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r14 = r13.getFontFamily(r11);
        if (r14 != null) goto L7;
        return null;
    L7:
        return r13.createFromFontFamilyFilesResourceEntry(r10, r14, r10.getResources(), r12);
    }

    private static Typeface getSystemFontFamily(@Nullable String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isEmpty() == true) goto L16;
        Typeface r11 = Typeface.create(r10, 0);
        Typeface r12 = Typeface.create(Typeface.DEFAULT, 0);
        if (r11 != null) goto L10;
        return null;
    L10:
        if (r11.equals(r12) == false) goto L12;
        return null;
    L12:
        return r11;
    L16:
        return null;
    }
}
