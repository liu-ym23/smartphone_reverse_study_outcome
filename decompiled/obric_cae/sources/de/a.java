package de;

import he.i;
import ie.c;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: de.a$a, reason: collision with other inner class name */
    public static final class C0063a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f7073a = null;

        static {
            Method[] r8 = Throwable.class.getMethods();
            i.e(r8, "throwableMethods");
            int r10 = r8.length;
            int r11 = 0;
            int r12 = 0;
        L3:
            Method r13 = null;
            Class<?> r14 = null;
            if (r12 >= r10) goto L17;
            Method r15 = r8[r12];
            if (i.a(r15.getName(), "addSuppressed") == false) goto L13;
            Class<?>[] r16 = r15.getParameterTypes();
            i.e(r16, "it.parameterTypes");
            boolean r17 = true;
            if (r16.length != 1) goto L11;
            r14 = r16[0];
        L11:
            if (i.a(r14, Throwable.class) == false) goto L13;
        L14:
            if (r17 == true) goto L15;
            r12 = r12 + 1;
            goto L3
        L15:
            r13 = r15;
        L13:
            r17 = false;
        L17:
            f7073a = r13;
            int r18 = r8.length;
        L18:
            if (r11 >= r18) goto L23;
            if (i.a(r8[r11].getName(), "getSuppressed") == true) goto L28;
            r11 = r11 + 1;
            goto L18
        L28:
            return;
        }
    }

    public a() {
    }

    public void a(Throwable r8, Throwable r10) {
        i.f(r8, "cause");
        i.f(r10, "exception");
        Method r11 = C0063a.f7073a;
        if (r11 == null) goto L6;
        r11.invoke(r8, new Object[]{r10});
        return;
    }

    public c b() {
        return new ie.b();
    }
}
