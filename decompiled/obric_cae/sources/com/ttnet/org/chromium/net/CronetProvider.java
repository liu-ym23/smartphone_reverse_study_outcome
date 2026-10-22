package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CronetProvider {
    private static final String GMS_CORE_CRONET_PROVIDER_CLASS = "com.google.android.gms.net.GmsCoreCronetProvider";
    private static final String JAVA_CRONET_PROVIDER_CLASS = "com.ttnet.org.chromium.net.impl.JavaCronetProvider";
    private static final String NATIVE_CRONET_PROVIDER_CLASS = "com.ttnet.org.chromium.net.impl.NativeCronetProvider";
    private static final String PLAY_SERVICES_CRONET_PROVIDER_CLASS = "com.google.android.gms.net.PlayServicesCronetProvider";
    public static final String PROVIDER_NAME_APP_PACKAGED = "App-Packaged-Cronet-Provider";
    public static final String PROVIDER_NAME_FALLBACK = "Fallback-Cronet-Provider";
    private static final String RES_KEY_CRONET_IMPL_CLASS = "CronetProviderClassName";
    private static final String TAG = "CronetProvider";
    protected final Context mContext;

    public CronetProvider(Context r8) {
        if (r8 == null) goto L7;
        this.mContext = r8;
        return;
    L7:
        throw new IllegalArgumentException("Context must not be null");
    }

    private static boolean addCronetProviderFromResourceFile(Context r8, Set<CronetProvider> r10) {
        int r11 = r8.getResources().getIdentifier(RES_KEY_CRONET_IMPL_CLASS, "string", r8.getPackageName());
        boolean r12 = false;
        if (r11 != 0) goto L5;
        return false;
    L5:
        String r13 = r8.getResources().getString(r11);
        if (r13 != null) goto L8;
    L19:
        return r12;
    L8:
        if (r13.equals(PLAY_SERVICES_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r13.equals(GMS_CORE_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r13.equals(JAVA_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r13.equals(NATIVE_CRONET_PROVIDER_CLASS) == true) goto L19;
        r12 = true;
        if (addCronetProviderImplByClassName(r8, r13, r10, true) == true) goto L19;
        Log.e(TAG, "Unable to instantiate Cronet implementation class " + r13 + " that is listed as in the app string resource file under CronetProviderClassName key");
        goto L19
    }

    private static boolean addCronetProviderImplByClassName(Context r8, String r10, Set<CronetProvider> r11, boolean r12) {
        r11.add((CronetProvider) r8.getClassLoader().loadClass(r10).asSubclass(CronetProvider.class).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r8}));     // Catch: Throwable -> L5
        return true;
    L5:
        e = move-exception;
        logReflectiveOperationException(r10, r12, e);
        return false;
    }

    public static List<CronetProvider> getAllProviders(Context r8) {
        LinkedHashSet r10 = new LinkedHashSet();
        addCronetProviderImplByClassName(r8, PLAY_SERVICES_CRONET_PROVIDER_CLASS, r10, false);
        addCronetProviderImplByClassName(r8, GMS_CORE_CRONET_PROVIDER_CLASS, r10, false);
        addCronetProviderImplByClassName(r8, NATIVE_CRONET_PROVIDER_CLASS, r10, false);
        addCronetProviderImplByClassName(r8, JAVA_CRONET_PROVIDER_CLASS, r10, false);
        return Collections.unmodifiableList(new ArrayList(r10));
    }

    private static void logReflectiveOperationException(String r8, boolean r10, Exception r11) {
        if (r10 == false) goto L4;
        Log.e(TAG, "Unable to load provider class: " + r8, r11);
        return;
    L4:
        String r12 = TAG;
        if (Log.isLoggable(r12, 3) == false) goto L9;
        Log.d(r12, "Tried to load " + r8 + " provider class but it wasn't included in the app classpath");
        return;
    }

    public abstract CronetEngine.Builder createBuilder();

    public abstract String getName();

    public abstract String getVersion();

    public abstract boolean isEnabled();

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + getName() + ", version=" + getVersion() + ", enabled=" + isEnabled() + "]";
    }
}
