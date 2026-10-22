package qna;

import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
        new HashMap();
    }

    public static Method a(Class<?> r7, String r8, Class<?>... r9) throws NoSuchMethodException {
        Method r10 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});     // Catch: Throwable -> L4
        r10.setAccessible(true);     // Catch: Throwable -> L4
        return r10;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
