package cn.nubia.neopush.commons.deviceid;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ClassAccessor {
    private static final String TAG = "ClassAccessor";

    public ClassAccessor() {
    }

    public <T> T getFieldValue(Class<?> r5, Object r10, String r11) {
        if (r10 == null) goto L14;
        if (r11 == null) goto L19;
        if (r5 == null) goto L6;
    L17:
        Field r12 = r5.getDeclaredField(r11);     // Catch: Exception -> L16
        if (r12 == null) goto L20;
        r12.setAccessible(true);     // Catch: Exception -> L16
        return (T) r12.get(r10);
    L20:
        return null;
    L21:
        return null;
    L6:
        if ((r10 instanceof Class) == false) goto L9;
        Class<?> r13 = (Class) r10;
    L8:
        r5 = r13;
        goto L17
    L9:
        r13 = r10.getClass();
        goto L8
    L19:
        return null;
    L14:
        return null;
    }

    public <T> T invokeMethod(Class<?> r5, Object r10, String r11, Class<?> r12, Object r13) {
        if (r10 == null) goto L21;
        if (r11 == null) goto L22;
        if (r5 == null) goto L7;
    L20:
        if (r12 != null) goto L12;
        Method r14 = r5.getDeclaredMethod(r11, null);     // Catch: Exception -> L19
    L13:
        if (r14 == null) goto L23;
        r14.setAccessible(true);     // Catch: Exception -> L19
        if (r12 != null) goto L18;
        return (T) r14.invoke(r10, null);
    L18:
        return (T) r14.invoke(r10, new Object[]{r13});
    L23:
        return null;
    L12:
        r14 = r5.getDeclaredMethod(r11, new Class[]{r12});     // Catch: Exception -> L19
        goto L13
    L25:
        return null;
    L7:
        if ((r10 instanceof Class) == false) goto L9;
        r5 = (Class) r10;
        goto L20
    L9:
        r5 = r10.getClass();
        goto L20
    L22:
        return null;
    L21:
        return null;
    }

    public Class<?> loadClass(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L9;
    L6:
        return null;
    L9:
        return Class.forName(r5);
    }
}
