package d5;

import com.ss.android.agilelogger.ALog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import mn.h;
import sj.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f16591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f16592b;

    static {
        f16591a = new HashMap();
        f16592b = false;
    }

    public static Method a(String r5) {
        HashMap r10 = f16591a;
        if (r10.containsKey(r5) == true) goto L5;
        xs.b r11 = ALog.sConfig;     // Catch: ClassNotFoundException -> L8
        Method r12 = g.k(ALog.class, r5, new Class[]{String.class, String.class});     // Catch: ClassNotFoundException -> L8
    L10:
        r10.put(r5, r12);
        return r12;
    L8:
        e = move-exception;
        h.g("default_handle", e);
        r12 = null;
        goto L10
    L5:
        return (Method) r10.get(r5);
    }

    public static boolean b(Method r5, String r10, String r11) {
        if (f16592b == false) goto L28;
        boolean r12 = true;
    L18:
        if (r12 == true) goto L20;
        return false;
    L20:
        if (r5 != null) goto L26;
    L25:
        return false;
    L26:
        r5.invoke(null, new Object[]{r10, r11});     // Catch: Throwable -> L23
        return true;
    L23:
        th = move-exception;
        h.g("default_handle", th);
        goto L25
    L28:
        xs.b r13 = ALog.sConfig;     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
        Method r14 = g.k(ALog.class, "isInitSuccess", null);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
        r14.setAccessible(true);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
        f16592b = ((Boolean) r14.invoke(null, null)).booleanValue();     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
    L16:
        r12 = f16592b;
        goto L18
    L11:
        e = move-exception;
        h.g("default_handle", e);
    L9:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }
}
