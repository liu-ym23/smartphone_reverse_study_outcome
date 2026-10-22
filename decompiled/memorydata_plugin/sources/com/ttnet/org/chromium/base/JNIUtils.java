package com.ttnet.org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
@MainDex
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClassLoader sJniClassLoader;
    private static Boolean sSelectiveJniRegistrationEnabled;

    static {
    }

    public JNIUtils() {
    }

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = true;
    }

    private static ClassLoader getClassLoader() {
        ClassLoader r0 = sJniClassLoader;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return JNIUtils.class.getClassLoader();
    }

    public static ClassLoader getSplitClassLoader(String r3) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L9;
        if (BundleUtils.isIsolatedSplitInstalled(r0, r3) == false) goto L9;
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BundleUtils.createIsolatedSplitContext(r0, r3), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getClassLoader();
    L9:
        return getClassLoader();
    }

    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled != null) goto L6;
        sSelectiveJniRegistrationEnabled = false;
    L6:
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    public static void setClassLoader(ClassLoader r0) {
        sJniClassLoader = r0;
    }

    public static <K, V> void splitMap(Map<K, V> r4, K[] r5, V[] r6) {
        int r0 = 0;
        Iterator<Map.Entry<K, V>> r7 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5[r0] = r2.getKey();
        r6[r0] = r2.getValue();
        r0 = r0 + 1;
        goto L4
    }
}
