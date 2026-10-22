package com.ttnet.org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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
        sSelectiveJniRegistrationEnabled = Boolean.TRUE;
    }

    private static ClassLoader getClassLoader() {
        ClassLoader r10 = sJniClassLoader;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return JNIUtils.class.getClassLoader();
    }

    @CalledByNative
    public static ClassLoader getSplitClassLoader(String r10) {
        Context r11 = ContextUtils.getApplicationContext();
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (BundleUtils.isIsolatedSplitInstalled(r11, r10) == false) goto L9;
        return BundleUtils.createIsolatedSplitContext(r11, r10).getClassLoader();
    L9:
        return getClassLoader();
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled != null) goto L6;
        sSelectiveJniRegistrationEnabled = Boolean.FALSE;
    L6:
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    public static void setClassLoader(ClassLoader r10) {
        sJniClassLoader = r10;
    }

    public static <K, V> void splitMap(Map<K, V> r10, K[] r11, V[] r12) {
        int r13 = 0;
        Iterator<Map.Entry<K, V>> r14 = r10.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry<K, V> r15 = r14.next();
        r11[r13] = r15.getKey();
        r12[r13] = r15.getValue();
        r13 = r13 + 1;
        goto L4
    }
}
