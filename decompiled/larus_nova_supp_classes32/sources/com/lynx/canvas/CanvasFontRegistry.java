package com.lynx.canvas;

import android.content.res.AssetManager;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CanvasFontRegistry {
    private static final String TAG = "CanvasFontRegistry";
    private static volatile CanvasFontRegistry mInstance;
    private final ArrayList<FontInfo> mFontInfoCache;
    private final HashSet<KryptonFontLazyProvider> mFontLazyProviders;
    private boolean mNativeReady;

    /* JADX INFO: renamed from: com.lynx.canvas.CanvasFontRegistry$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class FontInfo {
        public String familyName;
        public String localUrl;
        public int style;
        public int weight;

        private FontInfo() {
        }

        public /* synthetic */ FontInfo(AnonymousClass1 r1) {
            this();
        }
    }

    private native void nativeOnRegisterFontLazyProvider();

    private native boolean nativeRegisterFont(String r1, String r2, int r3, int r4);

    private void syncFontCacheOnNativeReady() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativeReady == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L7:
        this.mNativeReady = true;     // Catch: Throwable -> L16
        Iterator<FontInfo> r0 = this.mFontInfoCache.iterator();     // Catch: Throwable -> L16
    L9:
        if (r0.hasNext() == false) goto L11;
        FontInfo r1 = r0.next();     // Catch: Throwable -> L16
        nativeRegisterFont(r1.familyName, r1.localUrl, r1.weight, r1.style);     // Catch: Throwable -> L16
        goto L9
    L11:
        this.mFontInfoCache.clear();     // Catch: Throwable -> L16
        if (this.mFontLazyProviders.size() <= 0) goto L14;
        nativeOnRegisterFontLazyProvider();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    }

    public HashSet<KryptonFontLazyProvider> copyLazyProviders() {
        monitor-enter(this);
        HashSet<KryptonFontLazyProvider> r0 = new HashSet(this.mFontLazyProviders);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static CanvasFontRegistry GetInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(CanvasFontRegistry.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new CanvasFontRegistry();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CanvasFontRegistry.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public CanvasFontRegistry() {
        this.mFontInfoCache = new ArrayList();
        this.mNativeReady = false;
        this.mFontLazyProviders = new HashSet();
    }

    private static AssetManager getAssetManager() {
        Krypton r0 = Krypton.inst();
    L7:
        th = move-exception;
        KryptonLLog.i(TAG, "getAssetManager error " + th.toString());
        return null;
    L4:
        if (r0.hasInitialized() == false) goto L13;
        return r0.getContext().getAssets();
    L13:
        return null;
    }

    public static void onNativeFirstUseComplexLayout() {
        Krypton.inst().loadLibrary("kryptoni18n", true);
    }

    public static void onNativeReady() {
        GetInstance().syncFontCacheOnNativeReady();
    }

    public void registerFontLazyProvider(KryptonFontLazyProvider r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        this.mFontLazyProviders.add(r2);     // Catch: Throwable -> L10
        KryptonLLog.i(TAG, "register font lazy provider");     // Catch: Throwable -> L10
        if (this.mNativeReady == false) goto L8;
        nativeOnRegisterFontLazyProvider();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static String getLocalFontUrlFromPlatformProvider(String r5, int r6, int r7) {
        Iterator<KryptonFontLazyProvider> r0 = GetInstance().copyLazyProviders().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next().getLocalFontUrlByFamilyName(r5, r6, r7);
        if (r1 == null) goto L4;
        if (r1.length() <= 0) goto L4;
        KryptonLLog.i(TAG, "getLocalFontUrlByFamilyName " + r5 + " success " + r1);
        return r1;
    L11:
        KryptonLLog.i(TAG, "getLocalFontUrlByFamilyName " + r5 + " not found ");
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public boolean registerFont(String r3, String r4, int r5, int r6) {
        if (r3 != null) goto L4;
    L25:
        KryptonLLog.e(TAG, "registerFont " + r3 + " param error");
        return false;
    L4:
        if (r3.length() == 0) goto L25;
        if (r4 == null) goto L25;
        if (r4.length() == 0) goto L25;
        if (r5 < 0) goto L25;
        if (r6 < 0) goto L25;
        KryptonLLog.i(TAG, "registerFont ".concat(r3));
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (this.mNativeReady == false) goto L18;
        boolean r7 = nativeRegisterFont(r3, r4, r5, r6);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return r7;
    L18:
        FontInfo r0 = new FontInfo(null);     // Catch: Throwable -> L22
        r0.familyName = r3;     // Catch: Throwable -> L22
        r0.localUrl = r4;     // Catch: Throwable -> L22
        r0.weight = r5;     // Catch: Throwable -> L22
        r0.style = r6;     // Catch: Throwable -> L22
        this.mFontInfoCache.add(r0);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return true;
    }
}
