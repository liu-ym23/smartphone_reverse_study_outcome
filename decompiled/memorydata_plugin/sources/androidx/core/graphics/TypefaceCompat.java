package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompat {
    private static final LruCache<String, Typeface> sTypefaceCache = null;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl = null;

    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback r1) {
            this.mFontCallback = r1;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int r1) {
            ResourcesCompat.FontCallback r0 = this.mFontCallback;
            if (r0 == null) goto L6;
            r0.onFontRetrievalFailed(r1);
            return;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(Typeface r1) {
            ResourcesCompat.FontCallback r0 = this.mFontCallback;
            if (r0 == null) goto L6;
            r0.onFontRetrieved(r1);
            return;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        TypefaceCompatBaseImpl r0 = new TypefaceCompatApi29Impl();
    L5:
        sTypefaceCompatImpl = r0;
        sTypefaceCache = new LruCache(16);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        r0 = new TypefaceCompatApi28Impl();
        goto L5
    L10:
        if (Build.VERSION.SDK_INT < 26) goto L13;
        r0 = new TypefaceCompatApi26Impl();
        goto L5
    L13:
        if (Build.VERSION.SDK_INT < 24) goto L18;
        if (TypefaceCompatApi24Impl.isUsable() == false) goto L18;
        r0 = new TypefaceCompatApi24Impl();
    L18:
        if (Build.VERSION.SDK_INT < 21) goto L20;
        r0 = new TypefaceCompatApi21Impl();
        goto L5
    L20:
        r0 = new TypefaceCompatBaseImpl();
        goto L5
    }

    private TypefaceCompat() {
    }

    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    public static Typeface create(Context r2, Typeface r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L12;
        if (Build.VERSION.SDK_INT >= 21) goto L10;
        Typeface r6 = getBestFontFromFamily(r5, r3, r4);
        if (r6 == null) goto L10;
        return r6;
    L10:
        return Typeface.create(r3, r4);
    L12:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface create(Context r3, Typeface r4, int r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L10;
        Preconditions.checkArgumentInRange(r5, 1, 1000, "weight");
        if (r4 != null) goto L8;
        r4 = Typeface.DEFAULT;
    L8:
        return sTypefaceCompatImpl.createWeightStyle(r7, r4, r5, r6);
    L10:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface createFromFontInfo(Context r2, CancellationSignal r3, FontsContractCompat.FontInfo[] r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return sTypefaceCompatImpl.createFromFontInfo(r6, r3, r4, r5);
    }

    @Deprecated
    public static Typeface createFromResourcesFamilyXml(Context r12, FontResourcesParserCompat.FamilyResourceEntry r13, Resources r14, int r15, int r16, ResourcesCompat.FontCallback r17, Handler r18, boolean r19) {
        return createFromResourcesFamilyXml((Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin"), (FontResourcesParserCompat.FamilyResourceEntry) ZeusTransformUtils.wrapperContextForParams(r13, FontResourcesParserCompat.FamilyResourceEntry.class, "com.obric.memorydata.plugin"), r14, r15, null, 0, r16, r17, r18, r19);
    }

    public static Typeface createFromResourcesFamilyXml(Context r11, FontResourcesParserCompat.FamilyResourceEntry r12, Resources r13, int r14, String r15, int r16, int r17, ResourcesCompat.FontCallback r18, Handler r19, boolean r20) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        FontResourcesParserCompat.FamilyResourceEntry r2 = (FontResourcesParserCompat.FamilyResourceEntry) ZeusTransformUtils.wrapperContextForParams(r12, FontResourcesParserCompat.FamilyResourceEntry.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, FontResourcesParserCompat.ProviderResourceEntry.class) == false) goto L21;
        FontResourcesParserCompat.ProviderResourceEntry r3 = (FontResourcesParserCompat.ProviderResourceEntry) ZeusTransformUtils.preCheckCast(r2, FontResourcesParserCompat.ProviderResourceEntry.class, "com.obric.memorydata.plugin");
        Typeface r5 = getSystemFontFamily(r3.getSystemFontFamilyName());
        if (r5 == null) goto L10;
        if (r18 == null) goto L8;
        r18.callbackSuccessAsync(r5, r19);
    L8:
        return r5;
    L10:
        if (r20 == true) goto L12;
        if (r18 != null) goto L16;
    L15:
        boolean r7 = true;
    L17:
        if (r20 == false) goto L19;
        int r6 = r3.getTimeout();
    L20:
        Handler r9 = ResourcesCompat.FontCallback.getHandler(r19);
        ResourcesCallbackAdapter r10 = new ResourcesCallbackAdapter(r18);
        Typeface r0 = FontsContractCompat.requestFont(r4, r3.getRequest(), r17, r7, r6, r9, r10);
    L27:
        if (r0 == null) goto L29;
        sTypefaceCache.put(createResourceUid(r13, r14, r15, r16, r17), r0);
    L29:
        return r0;
    L19:
        r6 = -1;
    L16:
        r7 = false;
        goto L17
    L12:
        if (r3.getFetchStrategy() != 0) goto L16;
    L21:
        Typeface r8 = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(r4, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) ZeusTransformUtils.preCheckCast(r2, FontResourcesParserCompat.FontFamilyFilesResourceEntry.class, "com.obric.memorydata.plugin"), r13, r17);
        if (r18 == null) goto L26;
        if (r8 == null) goto L25;
        r18.callbackSuccessAsync(r8, r19);
        goto L26
    L25:
        r18.callbackFailAsync(-3, r19);
    L26:
        r0 = r8;
        goto L27
    }

    @Deprecated
    public static Typeface createFromResourcesFontFile(Context r6, Resources r7, int r8, String r9, int r10) {
        return createFromResourcesFontFile((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), r7, r8, r9, 0, r10);
    }

    public static Typeface createFromResourcesFontFile(Context r6, Resources r7, int r8, String r9, int r10, int r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Typeface r12 = sTypefaceCompatImpl.createFromResourcesFontFile(r1, r7, r8, r9, r11);
        if (r12 == null) goto L5;
        String r13 = createResourceUid(r7, r8, r9, r10, r11);
        sTypefaceCache.put(r13, r12);
    L5:
        return r12;
    }

    private static String createResourceUid(Resources r1, int r2, String r3, int r4, int r5) {
        return r1.getResourcePackageName(r2) + '-' + r3 + '-' + r4 + '-' + r2 + '-' + r5;
    }

    @Deprecated
    public static Typeface findFromCache(Resources r2, int r3, int r4) {
        return findFromCache(r2, r3, null, 0, r4);
    }

    public static Typeface findFromCache(Resources r1, int r2, String r3, int r4, int r5) {
        return (Typeface) ZeusTransformUtils.preCheckCast(sTypefaceCache.get(createResourceUid(r1, r2, r3, r4, r5)), Typeface.class, "com.obric.memorydata.plugin");
    }

    private static Typeface getBestFontFromFamily(Context r2, Typeface r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        TypefaceCompatBaseImpl r0 = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r6 = r0.getFontFamily(r3);
        if (r6 != null) goto L7;
        return null;
    L7:
        return r0.createFromFontFamilyFilesResourceEntry(r5, r6, ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin"), r4);
    }

    private static Typeface getSystemFontFamily(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isEmpty() == true) goto L16;
        Typeface r4 = Typeface.create(r3, 0);
        Typeface r1 = Typeface.create(Typeface.DEFAULT, 0);
        if (r4 != null) goto L10;
        return null;
    L10:
        if (r4.equals(r1) == false) goto L12;
        return null;
    L12:
        return r4;
    L16:
        return null;
    }
}
