package nmb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a implements InvocationHandler {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r1, Method r2, Object[] r3) {
            Class<?> r4 = r2.getReturnType();
            if (Intrinsics.areEqual(r4, Boolean.TYPE) == false) goto L6;
            return Boolean.FALSE;
        L6:
            if (Intrinsics.areEqual(r4, Byte.TYPE) == false) goto L9;
            return (byte) 0;
        L9:
            if (Intrinsics.areEqual(r4, Short.TYPE) == false) goto L12;
            return (short) 0;
        L12:
            if (Intrinsics.areEqual(r4, Integer.TYPE) == false) goto L15;
            return 0;
        L15:
            if (Intrinsics.areEqual(r4, Long.TYPE) == false) goto L18;
            return 0L;
        L18:
            if (Intrinsics.areEqual(r4, Float.TYPE) == false) goto L21;
            return Float.valueOf(0.0f);
        L21:
            if (Intrinsics.areEqual(r4, Double.TYPE) == false) goto L24;
            return Double.valueOf(0.0d);
        L24:
            if (Intrinsics.areEqual(r4, Character.TYPE) == true) goto L35;
            return null;
        L35:
            return (char) 0;
        }
    }

    static {
    }

    public static Object a(Class r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        a r0 = a.a;
        return Proxy.newProxyInstance(r4.getClassLoader(), new Class[]{r4}, r0);
    }
}
