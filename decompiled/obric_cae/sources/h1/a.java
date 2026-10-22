package h1;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n.b<String, Method> f7892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.b<String, Method> f7893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n.b<String, Class> f7894c;

    public a(n.b<String, Method> r8, n.b<String, Method> r10, n.b<String, Class> r11) {
        this.f7892a = r8;
        this.f7893b = r10;
        this.f7894c = r11;
    }

    public abstract b a();

    public final Class b(Class<? extends c> r8) {
        String r10 = r8.getName();
        n.b<String, Class> r11 = this.f7894c;
        Class r12 = r11.getOrDefault(r10, null);
        if (r12 != null) goto L6;
        Class<?> r13 = Class.forName(String.format("%s.%sParcelizer", new Object[]{r8.getPackage().getName(), r8.getSimpleName()}), false, r8.getClassLoader());
        r11.put(r8.getName(), r13);
        return r13;
    L6:
        return r12;
    }

    public final Method c(String r8) {
        n.b<String, Method> r10 = this.f7892a;
        Method r11 = r10.getOrDefault(r8, null);
        if (r11 != null) goto L6;
        System.currentTimeMillis();
        Method r12 = Class.forName(r8, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[]{a.class});
        r10.put(r8, r12);
        return r12;
    L6:
        return r11;
    }

    public final Method d(Class r8) {
        String r10 = r8.getName();
        n.b<String, Method> r11 = this.f7893b;
        Method r12 = r11.getOrDefault(r10, null);
        if (r12 != null) goto L6;
        Class r13 = b(r8);
        System.currentTimeMillis();
        Method r14 = r13.getDeclaredMethod("write", new Class[]{r8, a.class});
        r11.put(r8.getName(), r14);
        return r14;
    L6:
        return r12;
    }

    public abstract boolean e();

    public abstract byte[] f();

    public abstract CharSequence g();

    public abstract boolean h(int r8);

    public abstract int i();

    public final int j(int r8, int r10) {
        if (h(r10) == true) goto L6;
        return r8;
    L6:
        return i();
    }

    public abstract <T extends Parcelable> T k();

    public abstract String l();

    public final <T extends c> T m() {
        String r8 = l();
        if (r8 != null) goto L5;
        return null;
    L5:
        b r10 = a();
        return (T) c(r8).invoke(null, new Object[]{r10});
    L8:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L21:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L11:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L14:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L20;
        throw ((RuntimeException) e.getCause());
    L20:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    public abstract void n(int r8);

    public abstract void o(boolean r8);

    public abstract void p(byte[] r8);

    public abstract void q(CharSequence r8);

    public abstract void r(int r8);

    public final void s(int r8, int r10) {
        n(r10);
        r(r8);
    }

    public abstract void t(Parcelable r8);

    public abstract void u(String r8);

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(c r8) {
        if (r8 != null) goto L30;
        u(null);
        return;
    L30:
        u(b(r8.getClass()).getName());
        b r10 = a();
        d(r8.getClass()).invoke(null, new Object[]{r8, r10});     // Catch: ClassNotFoundException -> L11 NoSuchMethodException -> L14 InvocationTargetException -> L17 IllegalAccessException -> L24
        r10.w();
        return;
    L11:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L24:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L14:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L17:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L23;
        throw ((RuntimeException) e.getCause());
    L23:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    L27:
        e = move-exception;
        throw new RuntimeException(r8.getClass().getSimpleName().concat(" does not have a Parcelizer"), e);
    }
}
