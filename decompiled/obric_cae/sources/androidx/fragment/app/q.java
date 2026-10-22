package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n.h<ClassLoader, n.h<String, Class<?>>> f2041a = null;

    static {
        f2041a = new n.h();
    }

    public static Class<?> a(ClassLoader r8, String r10) {
        n.h<ClassLoader, n.h<String, Class<?>>> r11 = f2041a;
        n.h<String, Class<?>> r12 = r11.getOrDefault(r8, null);
        if (r12 != null) goto L5;
        r12 = new n.h();
        r11.put(r8, r12);
    L5:
        Class<?> r13 = r12.getOrDefault(r10, null);
        if (r13 != null) goto L9;
        Class<?> r14 = Class.forName(r10, false, r8);
        r12.put(r10, r14);
        return r14;
    L9:
        return r13;
    }

    public static Class<? extends Fragment> b(ClassLoader r8, String r10) {
        return a(r8, r10);
    L5:
        e = move-exception;
        throw new Fragment.j(defpackage.b.d("Unable to instantiate fragment ", r10, ": make sure class is a valid subclass of Fragment"), e);
    L8:
        e = move-exception;
        throw new Fragment.j(defpackage.b.d("Unable to instantiate fragment ", r10, ": make sure class name exists"), e);
    }
}
