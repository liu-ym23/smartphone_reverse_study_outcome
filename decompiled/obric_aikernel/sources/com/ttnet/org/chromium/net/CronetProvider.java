package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
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

    static {
    }

    protected CronetProvider(Context r10) {
        if (r10 == null) goto L7;
        this.mContext = r10;
        return;
    L7:
        throw new IllegalArgumentException("Context must not be null");
    }

    private static boolean addCronetProviderFromResourceFile(Context r10, Set<CronetProvider> r11) {
        int r12 = r10.getResources().getIdentifier(RES_KEY_CRONET_IMPL_CLASS, TypedValues.Custom.S_STRING, r10.getPackageName());
        boolean r13 = false;
        if (r12 != 0) goto L5;
        return false;
    L5:
        String r14 = r10.getResources().getString(r12);
        if (r14 != null) goto L8;
    L19:
        return r13;
    L8:
        if (r14.equals(PLAY_SERVICES_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r14.equals(GMS_CORE_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r14.equals(JAVA_CRONET_PROVIDER_CLASS) == true) goto L19;
        if (r14.equals(NATIVE_CRONET_PROVIDER_CLASS) == true) goto L19;
        r13 = true;
        if (addCronetProviderImplByClassName(r10, r14, r11, true) == true) goto L19;
        Log.e(TAG, "Unable to instantiate Cronet implementation class " + r14 + " that is listed as in the app string resource file under " + RES_KEY_CRONET_IMPL_CLASS + " key");
        goto L19
    }

    private static boolean addCronetProviderImplByClassName(Context r10, String r11, Set<CronetProvider> r12, boolean r13) {
        r12.add((CronetProvider) r10.getClassLoader().loadClass(r11).asSubclass(CronetProvider.class).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r10}));     // Catch: Throwable -> L5
        return true;
    L5:
        e = move-exception;
        logReflectiveOperationException(r11, r13, e);
        return false;
    }

    public static List<CronetProvider> getAllProviders(Context r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        addCronetProviderImplByClassName(r10, NATIVE_CRONET_PROVIDER_CLASS, r11, false);
        return Collections.unmodifiableList(new ArrayList(r11));
    }

    private static void logReflectiveOperationException(String r10, boolean r11, Exception r12) {
        if (r11 == false) goto L4;
        Log.e(TAG, "Unable to load provider class: " + r10, r12);
        return;
    L4:
        String r13 = TAG;
        if (Log.isLoggable(r13, 3) == false) goto L9;
        Log.d(r13, "Tried to load " + r10 + " provider class but it wasn't included in the app classpath");
        return;
    }

    public abstract CronetEngine.Builder createBuilder(boolean r10);

    public abstract String getName();

    public abstract String getVersion();

    public abstract boolean isEnabled();

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + getName() + ", version=" + getVersion() + ", enabled=" + isEnabled() + "]";
    }
}
