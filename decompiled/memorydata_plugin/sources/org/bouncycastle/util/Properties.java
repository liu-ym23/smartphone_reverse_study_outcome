package org.bouncycastle.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AccessController;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class Properties {
    private static final ThreadLocal threadProperties = null;

    static {
        threadProperties = new ThreadLocal();
    }

    public static int asInteger(String r0, int r1) {
        String r2 = getPropertyValue(r0);
        if (r2 != null) goto L5;
        return r1;
    L5:
        return Integer.parseInt(r2);
    }

    public static String getPropertyValue(final String r3) {
        String r0 = (String) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1(r3)), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(threadProperties.get(), Map.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get(r3), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        return r2;
    L11:
        return (String) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass2(r3)), String.class, "com.obric.memorydata.plugin");
    }

    public static boolean isOverrideSet(String r0) {
        return isSetTrue(getPropertyValue(r0));
    L4:
        return false;
    }

    private static boolean isSetTrue(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.length() == 4) goto L8;
        return false;
    L8:
        if (r5.charAt(0) == 't') goto L12;
        if (r5.charAt(0) == 'T') goto L12;
        return false;
    L12:
        if (r5.charAt(1) == 'r') goto L16;
        if (r5.charAt(1) == 'R') goto L16;
        return false;
    L16:
        if (r5.charAt(2) == 'u') goto L20;
        if (r5.charAt(2) == 'U') goto L20;
        return false;
    L20:
        if (r5.charAt(3) == 'e') goto L24;
        if (r5.charAt(3) == 'E') goto L24;
        return false;
    L24:
        return true;
    }
}
