package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
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
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompat {
    private static final LruCache<String, Typeface> sTypefaceCache = null;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl = null;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        @Nullable
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(@Nullable ResourcesCompat.FontCallback r5) {
            this.mFontCallback = r5;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int r5) {
            ResourcesCompat.FontCallback r10 = this.mFontCallback;
            if (r10 == null) goto L6;
            r10.onFontRetrievalFailed(r5);
            return;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(@NonNull Typeface r5) {
            ResourcesCompat.FontCallback r10 = this.mFontCallback;
            if (r10 == null) goto L6;
            r10.onFontRetrieved(r5);
            return;
        }
    }

    static {
        sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        sTypefaceCache = new LruCache(16);
    }

    private TypefaceCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    @NonNull
    public static Typeface create(@NonNull Context r5, @Nullable Typeface r10, int r11) {
        if (r5 == null) goto L6;
        return Typeface.create(r10, r11);
    L6:
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromFontInfo(@NonNull Context r5, @Nullable CancellationSignal r10, @NonNull FontsContractCompat.FontInfo[] r11, int r12) {
        return sTypefaceCompatImpl.createFromFontInfo(r5, r10, r11, r12);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFamilyXml(@NonNull Context r13, @NonNull FontResourcesParserCompat.FamilyResourceEntry r14, @NonNull Resources r15, int r16, @Nullable String r17, int r18, int r19, @Nullable ResourcesCompat.FontCallback r20, @Nullable Handler r21, boolean r22) {
        if ((r14 instanceof FontResourcesParserCompat.ProviderResourceEntry) == false) goto L22;
        FontResourcesParserCompat.ProviderResourceEntry r5 = (FontResourcesParserCompat.ProviderResourceEntry) r14;
        Typeface r10 = getSystemFontFamily(r5.getSystemFontFamilyName());
        if (r10 == null) goto L10;
        if (r20 == null) goto L8;
        r20.callbackSuccessAsync(r10, r21);
    L8:
        return r10;
    L10:
        if (r22 == true) goto L12;
        if (r20 == null) goto L13;
    L14:
        boolean r11 = false;
    L17:
        if (r22 == false) goto L20;
        int r12 = r5.getTimeout();
    L19:
        int r110 = r12;
        Typeface r23 = FontsContractCompat.requestFont(r13, r5.getRequest(), r19, r11, r110, ResourcesCompat.FontCallback.getHandler(r21), new ResourcesCallbackAdapter(r20));
    L27:
        if (r23 == null) goto L29;
        sTypefaceCache.put(createResourceUid(r15, r16, r17, r18, r19), r23);
    L29:
        return r23;
    L20:
        r12 = -1;
    L13:
        r11 = true;
        goto L17
    L12:
        if (r5.getFetchStrategy() != 0) goto L14;
    L22:
        r23 = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(r13, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) r14, r15, r19);
        if (r20 == null) goto L27;
        if (r23 == null) goto L26;
        r20.callbackSuccessAsync(r23, r21);
        goto L27
    L26:
        r20.callbackFailAsync(-3, r21);
        goto L27
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

    private static String createResourceUid(Resources r5, int r10, String r11, int r12, int r13) {
        return r5.getResourcePackageName(r10) + '-' + r11 + '-' + r12 + '-' + r10 + '-' + r13;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface findFromCache(@NonNull Resources r5, int r10, @Nullable String r11, int r12, int r13) {
        return sTypefaceCache.get(createResourceUid(r5, r10, r11, r12, r13));
    }

    @Nullable
    private static Typeface getBestFontFromFamily(Context r5, Typeface r10, int r11) {
        TypefaceCompatBaseImpl r12 = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r13 = r12.getFontFamily(r10);
        if (r13 != null) goto L7;
        return null;
    L7:
        return r12.createFromFontFamilyFilesResourceEntry(r5, r13, r5.getResources(), r11);
    }

    private static Typeface getSystemFontFamily(@Nullable String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == true) goto L16;
        Typeface r10 = Typeface.create(r5, 0);
        Typeface r11 = Typeface.create(Typeface.DEFAULT, 0);
        if (r10 != null) goto L10;
        return null;
    L10:
        if (r10.equals(r11) == false) goto L12;
        return null;
    L12:
        return r10;
    L16:
        return null;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface findFromCache(@NonNull Resources r5, int r10, int r11) {
        return findFromCache(r5, r10, null, 0, r11);
    }

    @NonNull
    public static Typeface create(@NonNull Context r5, @Nullable Typeface r10, @IntRange(from = 1, to = WsConstants.RELEASE_DELAY) int r11, boolean r12) {
        if (r5 == null) goto L9;
        Preconditions.checkArgumentInRange(r11, 1, 1000, "weight");
        if (r10 != null) goto L7;
        r10 = Typeface.DEFAULT;
    L7:
        return sTypefaceCompatImpl.createWeightStyle(r5, r10, r11, r12);
    L9:
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface createFromResourcesFontFile(@NonNull Context r10, @NonNull Resources r11, int r12, String r13, int r14) {
        return createFromResourcesFontFile(r10, r11, r12, r13, 0, r14);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface createFromResourcesFamilyXml(@NonNull Context r10, @NonNull FontResourcesParserCompat.FamilyResourceEntry r11, @NonNull Resources r12, int r13, int r14, @Nullable ResourcesCompat.FontCallback r15, @Nullable Handler r16, boolean r17) {
        return createFromResourcesFamilyXml(r10, r11, r12, r13, null, 0, r14, r15, r16, r17);
    }
}
