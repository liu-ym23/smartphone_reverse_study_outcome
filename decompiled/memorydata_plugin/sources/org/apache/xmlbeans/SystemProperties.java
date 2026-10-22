package org.apache.xmlbeans;

import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes7.dex */
public class SystemProperties {
    private static Map<Object, Object> propertyH;

    public static String getProperty(String r2) {
        if (propertyH == null) goto L13;
    L8:
        Object r3 = propertyH.get(r2);
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.toString();
    L13:
        propertyH = System.getProperties();     // Catch: SecurityException -> L6
    L6:
        propertyH = new Properties();
        return null;
    }

    public static String getProperty(String r0, String r1) {
        String r2 = getProperty(r0);
        if (r2 != null) goto L5;
        return r1;
    L5:
        return r2;
    }
}
