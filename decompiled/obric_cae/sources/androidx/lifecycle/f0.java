package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Class<?>> f2148a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Class<?>> f2149b = null;

    static {
        f2148a = l6.a.l0(new Class[]{Application.class, a0.class});
        f2149b = l6.a.k0(a0.class);
    }

    public static final <T> Constructor<T> a(Class<T> r8, List<? extends Class<?>> r10) {
        he.i.f(r10, "signature");
        Object[] r11 = r8.getConstructors();
        he.i.e(r11, "modelClass.constructors");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L15;
        Constructor<T> r14 = (Constructor<T>) r11[r13];
        Class<?>[] r15 = r14.getParameterTypes();
        he.i.e(r15, "constructor.parameterTypes");
        List r16 = yd.e.w0(r15);
        if (he.i.a(r10, r16) == true) goto L6;
        if (r10.size() != r16.size()) goto L14;
        if (r16.containsAll(r10) == false) goto L14;
        throw new UnsupportedOperationException("Class " + r8.getSimpleName() + " must have parameters in the proper order: " + r10);
    L14:
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L15:
        return null;
    }

    public static final <T extends h0> T b(Class<T> r8, Constructor<T> r10, Object... r11) {
        return r10.newInstance(Arrays.copyOf(r11, r11.length));
    L10:
        e = move-exception;
        throw new RuntimeException("Failed to access " + r8, e);
    L7:
        e = move-exception;
        throw new RuntimeException("A " + r8 + " cannot be instantiated.", e);
    L4:
        e = move-exception;
        throw new RuntimeException("An exception happened in constructor of " + r8, e.getCause());
    }
}
