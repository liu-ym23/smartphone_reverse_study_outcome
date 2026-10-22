package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
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

    public CronetProvider(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.mContext = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        return;
    L7:
        throw new IllegalArgumentException("Context must not be null");
    }

    private static boolean addCronetProviderFromResourceFile(Context r5, Set<CronetProvider> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        int r0 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin"), RES_KEY_CRONET_IMPL_CLASS, TypedValues.Custom.S_STRING, r7.getPackageName(), "com.obric.memorydata.plugin");
        if (r0 != 0) goto L5;
        return false;
    L5:
        String r1 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getString(r0);
        if (r1 != null) goto L8;
    L20:
        return false;
    L8:
        if (r1.equals(PLAY_SERVICES_CRONET_PROVIDER_CLASS) == true) goto L20;
        if (r1.equals(GMS_CORE_CRONET_PROVIDER_CLASS) == true) goto L20;
        if (r1.equals(JAVA_CRONET_PROVIDER_CLASS) == true) goto L20;
        if (r1.equals(NATIVE_CRONET_PROVIDER_CLASS) == true) goto L20;
        if (addCronetProviderImplByClassName(r7, r1, r8, true) == true) goto L19;
        Log.e(TAG, "Unable to instantiate Cronet implementation class " + r1 + " that is listed as in the app string resource file under " + RES_KEY_CRONET_IMPL_CLASS + " key");
    L19:
        return true;
    }

    private static boolean addCronetProviderImplByClassName(Context r7, String r8, Set<CronetProvider> r9, boolean r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        r12.add((CronetProvider) ZeusTransformUtils.preCheckCast(r11.getClassLoader().loadClass(r8).asSubclass(CronetProvider.class).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r11}), CronetProvider.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
        return true;
    L5:
        e = move-exception;
        logReflectiveOperationException(r8, r10, e);
        return false;
    }

    public static List<CronetProvider> getAllProviders(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        LinkedHashSet r0 = new LinkedHashSet();
        addCronetProviderImplByClassName(r4, NATIVE_CRONET_PROVIDER_CLASS, r0, false);
        return Collections.unmodifiableList(new ArrayList(r0));
    }

    private static void logReflectiveOperationException(String r2, boolean r3, Exception r4) {
        if (r3 == false) goto L4;
        Log.e(TAG, "Unable to load provider class: " + r2, r4);
        return;
    L4:
        String r5 = TAG;
        if (Log.isLoggable(r5, 3) == false) goto L9;
        Log.d(r5, "Tried to load " + r2 + " provider class but it wasn't included in the app classpath");
        return;
    }

    public abstract CronetEngine.Builder createBuilder(boolean r1);

    public abstract String getName();

    public abstract String getVersion();

    public abstract boolean isEnabled();

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + getName() + ", version=" + getVersion() + ", enabled=" + isEnabled() + "]";
    }
}
